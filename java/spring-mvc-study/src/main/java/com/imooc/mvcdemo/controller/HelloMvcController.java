package com.imooc.mvcdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/hello")
public class HelloMvcController {
	
	
	@RequestMapping("/mvc")
	// http://host:8080/hello/mvc
	public String helloMvc() {		
		//Mapping ot /WEB-INF/jsps/home.jsp
//		System.out.println("Call helloMvc");
		return "home";
	}
	
//	public String method(List<String> list){
//		return "";
//	}
//	
//	public int method(List<Integer> list){
//		return 0;
//	}

}
