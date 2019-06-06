package com.arthur.spider.webmagic;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;


public class HelloSpider {

    public static void main(String[] args){

        Spider.create(new HelloPageProcessor())
                .setDownloader(new SeleniumDownloader())
                .addUrl("http://www.ndrc.gov.cn/").thread(1).run();

    }
}
