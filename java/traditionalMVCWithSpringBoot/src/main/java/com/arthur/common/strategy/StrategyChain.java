package com.arthur.common.strategy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;

public abstract class StrategyChain<T> {

	private List<T> strategyChain;

	public abstract Class<T> getStrategyClazz();


	public void setStrategyChain(List<T> strategyChain) {
		this.strategyChain = strategyChain;
	}

	
	@SuppressWarnings("unchecked")
	public Iterator<T> readOnlyIterator(){
		
		if(strategyChain == null){
			throw new IllegalArgumentException("StrategyChain is null!");
		}
		 
		final Iterator<T> it = strategyChain.iterator() ;
		
		return (Iterator<T>)Proxy.newProxyInstance(this.getClass().getClassLoader(), 
				               new Class[]{Iterator.class}, 
				               new InvocationHandler(){

//								@Override
								public Object invoke(Object proxy,
										Method method, Object[] args)
										throws Throwable {
									if ("remove".equals(method.getName())) {
										throw new UnsupportedOperationException();
									}
									else {
										return method.invoke(it, args);
									}
								}});
	}

	
	
}
