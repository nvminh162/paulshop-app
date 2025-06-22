package com.nvminh162.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.nvminh162.laptopshop.domain.User;
import com.nvminh162.laptopshop.service.UploadService;
import com.nvminh162.laptopshop.service.UserService;

@Controller
public class UserController {
    private final UserService userService;
    private final UploadService uploadService;

    public UserController(UserService userService, UploadService uploadService) {
        this.userService = userService;
        this.uploadService = uploadService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("nvminh162", "Hello, nvminh162 say hi!");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/show";
    }

    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("id", id);
        model.addAttribute("user", user);
        return "admin/user/detail";
    }

    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping(value = "/admin/user/create")
    public String createUserPage(
            Model model,
            @ModelAttribute("newUser") User user,
            @RequestParam("avatarFile") MultipartFile file) {
        String avatar = uploadService.handleSaveUploadFile(file, "avatar");

        user.setAvatar(avatar);
        user.setRole(this.userService.getRoleById(user.getRole().getId()));

        this.userService.saveAUser(user);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("id", id);
        model.addAttribute("user", user);
        model.addAttribute("updateUser", user);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String postUpdateUser(Model model, @ModelAttribute("updateUser") User user) {
        User userExist = this.userService.getUserById(user.getId());
        System.out.println(userExist);
        if (userExist != null) {
            userExist.setFullName(user.getFullName());
            userExist.setAddress(user.getAddress());
            userExist.setPhone(user.getPhone());
            this.userService.saveAUser(userExist);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeletePage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        User deleteUser = new User();
        deleteUser.setId(id);
        model.addAttribute("deleteUser", deleteUser);
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String deletePage(Model model, @ModelAttribute("deleteUser") User user) {
        this.userService.deleteAUser(user.getId());
        return "redirect:/admin/user";
    }
}