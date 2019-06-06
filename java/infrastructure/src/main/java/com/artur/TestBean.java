package com.artur;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestBean {
	
	private int intPro;
	private Integer intObjPro;
	private long longPro;
	private Long longObjPro;
	private double douPro;
	private Double douObjPro;
	
	private String strPro;
	
	private List<TestBean> testBeanList;
	private Set<TestBean> testBeanSet; 
	private TestBean[] testBeanArry;
	private Map<String, TestBean> testBeanMap;
	public int getIntPro() {
		return intPro;
	}
	public void setIntPro(int intPro) {
		this.intPro = intPro;
	}
	public Integer getIntObjPro() {
		return intObjPro;
	}
	public void setIntObjPro(Integer intObjPro) {
		this.intObjPro = intObjPro;
	}
	public long getLongPro() {
		return longPro;
	}
	public void setLongPro(long longPro) {
		this.longPro = longPro;
	}
	public Long getLongObjPro() {
		return longObjPro;
	}
	public void setLongObjPro(Long longObjPro) {
		this.longObjPro = longObjPro;
	}
	public double getDouPro() {
		return douPro;
	}
	public void setDouPro(double douPro) {
		this.douPro = douPro;
	}
	public Double getDouObjPro() {
		return douObjPro;
	}
	public void setDouObjPro(Double douObjPro) {
		this.douObjPro = douObjPro;
	}
	public String getStrPro() {
		return strPro;
	}
	public void setStrPro(String strPro) {
		this.strPro = strPro;
	}
	public List<TestBean> getTestBeanList() {
		return testBeanList;
	}
	public void setTestBeanList(List<TestBean> testBeanList) {
		this.testBeanList = testBeanList;
	}
	public Set<TestBean> getTestBeanSet() {
		return testBeanSet;
	}
	public void setTestBeanSet(Set<TestBean> testBeanSet) {
		this.testBeanSet = testBeanSet;
	}
	public TestBean[] getTestBeanArry() {
		return testBeanArry;
	}
	public void setTestBeanArry(TestBean[] testBeanArry) {
		this.testBeanArry = testBeanArry;
	}
	public Map<String, TestBean> getTestBeanMap() {
		return testBeanMap;
	}
	public void setTestBeanMap(Map<String, TestBean> testBeanMap) {
		this.testBeanMap = testBeanMap;
	}
	
	@Deprecated
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException{
		 
//		  TestBean bean = new TestBean();
//		  
//		  List<TestBean> beanList = new ArrayList<TestBean>();
//		  beanList.add(new TestBean());
//		  
//		  Object arrayIns = Array.newInstance(TestBean.class, 2);
//		  
//		  Array.set(arrayIns, 0, new TestBean());
//		  Array.set(arrayIns, 1, new TestBean());
		  
//		  Array.getLength(array)
//		  
//		  System.out.println("List:"+ Arrays.asList(arrayIns));
//		  System.out.println("List 2:"+ beanList);
		  
		  
		  List<String> l = Collections.emptyList();
		  
		  
		  l.add("test");
		  
		  System.out.println("List 2:"+ l);
//		  throw new IllegalArgumentException();
		  
//		  bean.setTestBeanList(list);
//		  
//		  bean.setTestBeanArry(list.to);
		  
//		  bean.setTestBeanArry(list.toArray());
		  
//		  Arrays.
		
//	       Method[] methods = TestBean.class.getMethods();
////	       Map<String, Method> setterMap = new HashMap<String, Method>();
//	       
//	       TestBean.class.getDeclaredField("");
//	       
//	       for(Method m : methods){
//	           String methodName = m.getName();
//	           if ( methodName.equals("setTestBeanList")){
//	        	   
////	        	  m.invoke(bean, arrayIns) ;
//	        	   
////	             String key = methodName.substring(3).toUpperCase();
////	             setterMap.put(key, m);
//	             
//	        	   Type[] t = m.getGenericParameterTypes();
////	        	   m.get
////	        	   Arrays.as
//	        	   
////	        	   t[0].
//	        	  
//	        	 System.out.println("parameter type.getClass "+t[0].getClass());
//	        	 System.out.println("parameter type.getTypeName "+t[0].getTypeName());
//	             
////	             System.out.println("parameter type for "+m.getName()+":"+pType);
////	             if (double.class.equals(pType)){
////	            	 System.out.println("******** double.class *********"+m);
////	             }
////	        	 Collections.
////	             
////	             if (pType.isArray()){
////	            	 System.out.println("******** Array *********"+m);
////	            	 System.out.println("%%%%%%%%%%%% Element Type: %%%%%%%%%%%%%*"+pType.getComponentType());	            	             	 
////	             }
//	             
//	           }
//	       }
//	       
//	       System.out.println("setterMap for "+ TestBean.class.getSimpleName() + " :"+setterMap);
	       
	       
//	       System.out.println(bean.getTestBeanArry().length);

//		TestBean.class.getm
		
	       
	}
	
	

}
