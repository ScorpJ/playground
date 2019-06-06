package com.arthur.common.strategy;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


@Component
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
			Map strategyHandlerMap = ((ListableBeanFactory)beanFactory).getBeansOfType(strategyClazz);			
			Iterator<Map.Entry<String, Object>> it = strategyHandlerMap.entrySet().iterator();			
			while(it.hasNext()){
				Map.Entry<String, Object> entry = it.next();
				String beanId = entry.getKey();
				Object targetBean = entry.getValue();
				logger.info("StrategyHelperLoader find bean {} of class {}", beanId, targetBean.getClass().toString());			
			}
			helper.setStrategyMap(Collections.unmodifiableMap(strategyHandlerMap));
			logger.info("StrategyHelperLoader loaded {} beans for {}", strategyHandlerMap.size(), strategyClazz.getName());
			
		}
		return bean;
	}


}
