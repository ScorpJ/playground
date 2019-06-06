package com.homework.galaxy.utils;


public class StringUtils{

	public static boolean isNotBlank(String value){
		if(value != null
				&& !value.isEmpty()
				&& value.trim().length() > 0){
			return true;
		}
		return false;
	}
}
