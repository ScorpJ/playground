package com.arthur.springcloud.mockapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("com.arthur.springcloud.mockapp.web")
public class MockappApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockappApplication.class, args);
    }

}

