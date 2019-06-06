package com.artur.infrastructure.strategy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;



@Service
public class StrategyHelperLoader implements BeanFactoryAware,
		BeanPostProcessor {

	private static final Logger logger = LoggerFactory.getLogger(StrategyHelperLoader.class);
	private BeanFactory beanFactory;
	
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		 this.beanFactory = beanFactory;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)
	    throws BeansException {
		return bean;
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		if(StrategyHelper.class.isAssignableFrom(bean.getClass())){
			StrategyHelper helper = (StrategyHelper)bean;
			Class strategyClazz = helper.getStrategyClazz();
			Map stragegyHandlerMap = ((ListableBeanFactory)beanFactory).getBeansOfType(strategyClazz);
			Iterator it = stragegyHandlerMap.values().iterator();
			Map<String,StrategyHandler> strategyHandlerMap = new HashMap<String,StrategyHandler>(); 
			while(it.hasNext()){
				Object obj = it.next();
				StrategyHandler strategyHandler;
				try{
					strategyHandler = (StrategyHandler)obj;
				}catch(ClassCastException e){
					throw new RuntimeException(obj + " is not implements StrategyHandler!");
				}
				
				if(StringUtils.isBlank(strategyHandler.getName())){
					throw new RuntimeException(strategyHandler + " is not configed, please give it a name property!");					
				}
				if(strategyHandlerMap.containsKey(strategyHandler.getName())){
					throw new RuntimeException(strategyHandler.getName() + " has been configed already!");			
				}
				strategyHandlerMap.put(strategyHandler.getName(), strategyHandler);
				
				logger.info("Add stragetyHandler {} to {}", strategyHandler.getName(), beanName);
			}
			
			helper.setStrategyMap(strategyHandlerMap);
			logger.info("{} strategyHelper size: {}", beanName,  strategyHandlerMap.size());
			
		}
		return bean;
	}


}
