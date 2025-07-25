package com.nvminh162.javaspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nvminh162.javaspringmvc.domain.User;
import com.nvminh162.javaspringmvc.service.UserService;
 
// Spring MVC Model
@Controller
public class UserController {
    private UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.handleHello();
        model.addAttribute("test", test);
        model.addAttribute("test2", "From controller with model");
        return "nvminh162";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create1", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User nvminh162) {
        // model.addAttribute("newUser", new User());
        System.out.println("here ..." + nvminh162);
        return "nvminh162";
    }
}

// Spring RestFul API
/* @RestController
public class UserController {

    private UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getHomePage() {
        return userService.handleHello();
    }
} 
 */