package com.arthur.mybatisstartup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.arthur.mybatisstartup.dao")
public class MybatisStartupApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisStartupApplication.class, args);
    }


}
