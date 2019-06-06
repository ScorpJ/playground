package com.arthur.redisstudy;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Map<String,String> map = new HashMap();
       
       map.put("k1", "v1");
       map.put("k2", "v2");
       
       
       Map<String,String> outerMap = new HashMap(map);
       
       System.out.println(map);
       System.out.println(outerMap);
       
       outerMap.remove("k1");
       
       System.out.println(map);
       System.out.println(outerMap);
       
       
       
	}

}
