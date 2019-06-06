package com.arthur.common.strategy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myTestService2")
//@Qualifier("myTestService2")
public class TestServiceImpl2 implements TestService {

	@Override
	public void doService() {
		System.out.println("doService in myTestService2");	
	}

}
