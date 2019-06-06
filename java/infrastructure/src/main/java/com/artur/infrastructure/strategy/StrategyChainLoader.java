package com.artur.infrastructure.strategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;


@Service
public class StrategyChainLoader implements BeanFactoryAware,BeanPostProcessor{

	private static final Logger logger = LoggerFactory.getLogger(StrategyChainLoader.class);
			
	
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
			
		if(StrategyChain.class.isAssignableFrom(bean.getClass())){
			StrategyChain straCommandLine = (StrategyChain)bean;
			
			List strategyChain = new ArrayList();
			
			Class strategyClazz = straCommandLine.getStrategyClazz();
			Map stragegyHandlerMap = ((ListableBeanFactory)beanFactory).getBeansOfType(strategyClazz);
			Iterator it = stragegyHandlerMap.keySet().iterator();
			
			while(it.hasNext()){
				String straName = (String)it.next();
				strategyChain.add(stragegyHandlerMap.get(straName));
				
				logger.info("Add strategy {} to strategy chain {}", straName, beanName);			
			}
			
			straCommandLine.setStrategyChain(strategyChain);
            logger.info("{} size: {}", beanName, strategyChain.size());           
			
		}
		return bean;
	}


}
