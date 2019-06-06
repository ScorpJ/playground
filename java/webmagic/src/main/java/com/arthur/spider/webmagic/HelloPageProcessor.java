package com.arthur.spider.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class HelloPageProcessor implements PageProcessor {

    private static final String DFT_USR_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36";

    private Site site;

    @Override
    public void process(Page page) {

        page.addTargetRequests(page.getHtml().links().regex("(http://www\\.ndrc\\.gov\\.cn/\\w+)").all());
//        page.putField("author", page.getUrl().regex("https://\\w+\\.pageprocessor\\.com/\\w+)/.*").toString());
//        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        if (page.getResultItems().get("name")==null){
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

    }

    @Override
    public Site getSite() {

        if (null == site) {
            site = Site.me().setDomain("ndrc.gov.cn")
                    .setUserAgent(DFT_USR_AGENT)
                    .setSleepTime(2000);

        }
        return site;
    }
}
