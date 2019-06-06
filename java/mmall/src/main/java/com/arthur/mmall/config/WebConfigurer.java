package com.arthur.mmall.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfigurer extends WebMvcConfigurationSupport {

    private static Logger logger = LoggerFactory.getLogger(WebConfigurer.class);

    @Bean
    public MultipartResolver multipartResolver() {
        logger.info("In bean definition method: multipartResolver()");
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        //200*1024*1024即200M resolveLazily属性启用是为了推迟文件解析，以便捕获文件大小异常
        multipartResolver.setMaxUploadSize(209715200);
        multipartResolver.setDefaultEncoding("UTF-8");
        multipartResolver.setMaxInMemorySize(4096);
//		multipartResolver.setResolveLazily(true);
        return multipartResolver;
    }


}
