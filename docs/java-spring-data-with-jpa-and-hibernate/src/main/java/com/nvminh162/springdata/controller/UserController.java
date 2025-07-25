package com.nvminh162.springdata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nvminh162.springdata.domain.User;
import com.nvminh162.springdata.repository.UserRepository;
import com.nvminh162.springdata.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

// Spring MVC Model
@Controller
public class UserController {

    private final UserRepository userRepository;

    private final UserService userService;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getTableUserPage(Model model) {
        List<User> users = this.userService.handleGetAllUser();
        model.addAttribute("users", users);
        return "admin/user/table-user";
    }

    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User user = this.userService.handleFindById(id);
        model.addAttribute("id", id);
        model.addAttribute("user", user);
        return "admin/user/show";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdatePage(Model model, @PathVariable long id) {
        User user = this.userService.handleFindById(id);
        model.addAttribute("id", id);
        model.addAttribute("user", user);
        model.addAttribute("updateUser", user);
        return "admin/user/update";
    }

    @RequestMapping("/admin/user/create")
    public String getCreatePage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createPage(Model model, @ModelAttribute("newUser") User user) {
        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    @PostMapping("/admin/user/update")
    public String updatePage(Model model, @ModelAttribute("updateUser") User user) {
        User userExist = this.userService.handleFindById(user.getId());
        System.out.println(userExist);
        if (userExist != null) {
            userExist.setFullName(user.getFullName());
            userExist.setAddress(user.getAddress());
            userExist.setPhone(user.getPhone());
            this.userService.handleSaveUser(userExist);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeletePage(Model model, @PathVariable long id) {
        User user = this.userService.handleFindById(id);
        model.addAttribute("id", id);
        model.addAttribute("deleteUser", user);
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String deletePage(Model model, @ModelAttribute("deleteUser") User user) {
        this.userService.handleDeleteById(user.getId());
        return "redirect:/admin/user";
    }

}
