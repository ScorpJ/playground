package com.arthur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.arthur.mvcdemo.web.WebMvcConfigurer;


@SpringBootApplication
@EnableAspectJAutoProxy
@Import(WebMvcConfigurer.class)
public class ApplicationConfig extends SpringBootServletInitializer {
	
	private Logger loger = LoggerFactory.getLogger(ApplicationConfig.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfig.class, args);
	}
	
	

}
