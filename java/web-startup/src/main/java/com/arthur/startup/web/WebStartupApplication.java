package com.arthur.startup.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class WebStartupApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebStartupApplication.class, args);
    }
}
