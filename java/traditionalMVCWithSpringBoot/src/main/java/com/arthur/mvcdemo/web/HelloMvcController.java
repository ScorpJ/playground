package com.arthur.mvcdemo.web;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/hello")
public class HelloMvcController {
	private static Logger logger = LoggerFactory.getLogger(HelloMvcController.class);
	
	@RequestMapping("/mvc")
	// http://host:8080/hello/mvc
	public String helloMvc() {		
		//Mapping ot /WEB-INF/jsps/home.jsp
		logger.info("Info: Call in helloMvc of HelloMvcController");		
		logger.debug("Debug: Call in helloMvc of HelloMvcController");		
		return "home";
	}

}
