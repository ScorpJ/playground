package com.arthur.common.strategy;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

public abstract class StrategyHelper<T> {

	
	private Map<String,T> strategyMap;

	public abstract Class<T> getStrategyClazz();

	public void setStrategyMap(Map<String,T> strategyMap){
		this.strategyMap = strategyMap;
	}
	
	public T getStrategyHandler(String handlerName){
		
		if(StringUtils.isBlank(handlerName)){
			throw new IllegalArgumentException("Wanted handlerName is null!");
		}
		
		if(strategyMap == null){
			throw new RuntimeException("StrategyMap is null, please init the map first!");
		}
		
		T handler = strategyMap.get(handlerName.trim());
		
		if(handler == null){
			throw new IllegalArgumentException("Can't find "+ this.getStrategyClazz().getName() +" implements with name "+handlerName+",expected values are:"+strategyMap.keySet()+".");
		}
		
		
		return handler;
	}
	
	
	
}
