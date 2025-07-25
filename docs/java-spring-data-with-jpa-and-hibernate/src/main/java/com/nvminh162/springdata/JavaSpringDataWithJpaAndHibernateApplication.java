package com.nvminh162.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class JavaSpringDataWithJpaAndHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringDataWithJpaAndHibernateApplication.class, args);
    }

}
