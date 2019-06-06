package com.arthur.redisstudy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.arthur.redisstudy.credits.WebMvcConfigurer;


@SpringBootApplication
@EnableAspectJAutoProxy
@Import(WebMvcConfigurer.class)
public class RedisStudyApplicationConfig extends SpringBootServletInitializer {
	
	private Logger loger = LoggerFactory.getLogger(RedisStudyApplicationConfig.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RedisStudyApplicationConfig.class, args);
	}
	
	

}
