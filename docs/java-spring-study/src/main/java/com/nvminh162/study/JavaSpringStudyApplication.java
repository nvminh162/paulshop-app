package com.nvminh162.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavaSpringStudyApplication {

    public static void main(String[] args) {
        ApplicationContext abc = SpringApplication.run(JavaSpringStudyApplication.class, args);
        for (String s : abc.getBeanDefinitionNames()) {
            System.out.println(">>> Beans item: " + s);
        }
    }

} 
