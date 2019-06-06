package com.arthur.redisstudy.credits.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeStrUtil {
	
	
	public static final long ONE_DAY_MILLSEC = 24L *  60L * 60L * 1000L; 
	
	protected static final String DATE_FORMAT_DATE_ONLY = "yyyy-MM-dd";
	protected static final String DATE_FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	
	protected static final SimpleDateFormat sdfDateOnly = new SimpleDateFormat(DATE_FORMAT_DATE_ONLY);
	protected static final SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String getCurrentDateOnlyStr(){		
		return sdfDateOnly.format(new Date());
	}
	
	public static String convertDttm2DateOnlyStr(Long dttmInMillSec){		
		return sdfDateOnly.format(new Date(dttmInMillSec));
	}
	
	public static String convertDateDateOnlyStr(Date date){	
		return ((date == null)?"":sdfDateOnly.format(date));
	}

}
