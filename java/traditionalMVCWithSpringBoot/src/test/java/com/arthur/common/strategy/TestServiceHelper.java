package com.arthur.common.strategy;

import org.springframework.stereotype.Component;

@Component
public class TestServiceHelper extends StrategyHelper<TestService> {

	@Override
	public Class<TestService> getStrategyClazz() {
		return TestService.class;
	}

}
