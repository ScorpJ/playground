package com.arthur.spider.webmagic;

public class Test {

    public static void main(String[] args) {


        String title = "码农翻身  ";

        title.chars().forEach(e-> System.out.println(e));

        System.out.println(title.trim()+ "--");
        System.out.println(title.replaceAll("\u00A0","")+ "--");
    }
}
