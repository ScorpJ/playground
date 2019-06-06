package com.arthur.startup.web.controller;


import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/home")
public class HelloController {

    @RequestMapping(path = "/hello", method = {RequestMethod.GET})
    public String sayHello(@RequestParam(name = "name", required = false) String name) {

        if (StringUtils.isBlank(name)) {
            name = "Spring Boot";
        }

        return "Hello " + name;

    }
}
