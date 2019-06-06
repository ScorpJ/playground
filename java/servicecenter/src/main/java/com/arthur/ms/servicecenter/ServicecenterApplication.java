package com.arthur.ms.servicecenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableEurekaServer
@SpringBootApplication
@EnableZuulProxy
public class ServicecenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicecenterApplication.class, args);
    }
}
