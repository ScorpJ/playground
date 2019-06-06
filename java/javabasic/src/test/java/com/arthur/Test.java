package com.arthur;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {


    public static void main(String[] args){


//        Pattern p = Pattern.compile("^[a-zA-Z0-9](([a-zA-Z0-9\\s\\.]{1,3}[a-zA-Z0-9\\.])|([a-zA-Z0-9\\.]?))$");
//        Matcher m = p.matcher("A\\c");
        System.out.println(Integer.MAX_VALUE + ":" +(Integer.MAX_VALUE + "").length());
        System.out.println(Long.MAX_VALUE + ":"+ (Long.MAX_VALUE + "").length());
    }
}
