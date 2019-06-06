package com.arthur.springclould.apigateaway.localapps;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/myapps")
public class LocalAppsController {


    @GetMapping(path="/hi")
    public String hello(){
        return "Hello, this is local service.";
    }
}
