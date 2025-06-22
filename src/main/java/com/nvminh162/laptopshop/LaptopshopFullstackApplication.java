package com.nvminh162.laptopshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class LaptopshopFullstackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaptopshopFullstackApplication.class, args);
    }

}
