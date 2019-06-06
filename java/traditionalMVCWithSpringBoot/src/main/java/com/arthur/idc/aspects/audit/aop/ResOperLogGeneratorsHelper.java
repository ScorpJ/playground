package com.arthur.idc.aspects.audit.aop;

import org.springframework.stereotype.Component;

import com.arthur.common.strategy.StrategyHelper;


@Component("resOperLogGeneratorsHelper")
public class ResOperLogGeneratorsHelper extends StrategyHelper<ResOperLogGenerator> {

	@Override
	public Class<ResOperLogGenerator> getStrategyClazz() {
		return ResOperLogGenerator.class;
	}

	
	public ResOperLogGenerator getResOperLogGenerator(String serviceName){
		return super.getStrategyHandler(serviceName);
	}
	
}
