package com.arthur.common.strategy;

import org.springframework.stereotype.Component;

@Component("myTestService1")
public class TestServiceImpl1 implements TestService {

	@Override
	public void doService() {
		System.out.println("doService in myTestService1");	
	}


}
