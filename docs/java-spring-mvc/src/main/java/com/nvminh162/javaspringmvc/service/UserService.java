package com.nvminh162.javaspringmvc.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String handleHello() {
        return "Hello from service! Test!";
    }
}
