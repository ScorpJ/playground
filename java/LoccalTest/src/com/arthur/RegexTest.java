package com.arthur;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public RegexTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Pattern pattern = Pattern.compile("((?<=,)null(?=,))");
		Matcher matcher = pattern.matcher("adf.null,null,null,abcnull,nulladc,abc");
		if (matcher.find()){
		   System.out.println(matcher.replaceAll(""));
		}
		
		System.out.println("end");
		
		
	        
		
		Map<String, Object> map = new HashMap<String, Object>(5);
		Map<String, Object> map2 = new ConcurrentHashMap<>();
		
	}

}
