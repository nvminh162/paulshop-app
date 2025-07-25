package com.nvminh162.javaspringsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class JavaSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringSecurityApplication.class, args);
    }

}
