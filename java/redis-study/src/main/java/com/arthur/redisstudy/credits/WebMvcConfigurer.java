package com.arthur.redisstudy.credits;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableWebMvc
@ComponentScan("com.arthur.redisstudy.credits")
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
	
	private Logger loger = LoggerFactory.getLogger(WebMvcConfigurer.class);
	
	// Only used when running in embedded servlet
//	@Bean
//	public DispatcherServlet dispatcherServlet() {
//		return new DispatcherServlet();
//	}

	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver(){
		loger.debug("Init Bean {}", ContentNegotiatingViewResolver.class);		
		
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		List<View> defaultViews = new ArrayList<>();
		defaultViews.add(new MappingJackson2JsonView());
		
		resolver.setOrder(1);
		resolver.setDefaultViews(defaultViews);
		return resolver;
	}
	
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**");
	}
	
	
//	@Bean
//	public InternalResourceViewResolver internalResourceViewResolver() {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setPrefix("/WEB-INF/jsps/");
//		viewResolver.setSuffix(".jsp");
//		viewResolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
//		return viewResolver;
//	}
	
//	@Bean 
//	public MultipartResolver multipartResolver(){
//		CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
//		//200*1024*1024鍗�200M resolveLazily灞炴�у惎鐢ㄦ槸涓轰簡鎺ㄨ繜鏂囦欢瑙ｆ瀽锛屼互渚挎崟鑾锋枃浠跺ぇ灏忓紓甯�
//		multipartResolver.setMaxUploadSize(209715200);
//		multipartResolver.setDefaultEncoding("UTF-8");
//		multipartResolver.setResolveLazily(true);
//		return multipartResolver;
//	}	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/resources/*").addResourceLocations("/resources/");
//	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.mediaType("json", MediaType.APPLICATION_JSON_UTF8)
		          .mediaType("xml", MediaType.APPLICATION_XML)
		          .mediaType("htm", MediaType.TEXT_HTML)
		          .mediaType("html", MediaType.TEXT_HTML)
		          .ignoreAcceptHeader(false);
	}
	

//	@Override
//	public void configureDefaultServletHandling(
//			DefaultServletHandlerConfigurer configurer) {
//		configurer.enable();
//	}
	
}
