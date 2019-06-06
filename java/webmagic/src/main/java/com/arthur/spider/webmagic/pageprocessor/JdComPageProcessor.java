package com.arthur.spider.webmagic.pageprocessor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;

import us.codecraft.webmagic.processor.PageProcessor;

public class JdComPageProcessor implements PageProcessor {

    private static final String DFT_USR_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36";

    private Site site;


    @Override
    public void process(Page page) {

        String category = this.parserCategory(page);


//        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
//        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        if (page.getResultItems().get("name") == null) {
            //skip this page
            page.setSkip(true);
        }
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

        // 部分三：从页面发现后续的url地址来抓取
        page.addTargetRequests(page.getHtml().links().regex("(https://\\w+\\.pageprocessor\\.com)").all());

    }



    @Override
    public Site getSite() {
        if (null == site) {
            site = Site.me().setDomain("pageprocessor.com")
                    .setUserAgent(DFT_USR_AGENT)
                    .addCookie("__jdu", "15521368279441897898655")
                    .addCookie("ipLoc-djd", "1-72-2799-0")
                    .addCookie("shshshfpa", "96dfcfa1-d150-2e4b-a349-5dc6e0de9097-1552136838")
                    .addCookie("shshshfpb", "l2G%20%2F3GQJxUzaFapbNkIK2g%3D%3D")
                    .addCookie("user-key", "72906967-9cd4-46b2-b87c-9e343a86927d")
                    .addCookie("cn", "0")
                    .addCookie("TrackID", "1j8_ca0uZ1Ry4PEk3KSO802gczwMdcxED4Y96TxDCCDKMAPIzd5l27HnfkBfBFC9L22_c3vFh8yh7NTXyPlNzyw5xt-Disix-ma1mjA--vGw")
                    .addCookie("pinId", "VUQq8G6P3uw")
                    .addCookie("pin", "scorpj")
                    .addCookie("unick", "scorpj")
                    .addCookie("_tp", "x16Tsg6Cwe6Ua8KHQwzCvw%3D%3D")
                    .addCookie("_pst", "scorpj")
                    .addCookie("ipLocation", "%u5317%u4EAC")
                    .addCookie("areaId", "1")
                    .addCookie("__jdc", "122270672")
                    .addCookie("PCSYCityID", "1")
                    .addCookie("shshshfp", "97dfe6dc1a66072bb134c0c7048237ba")
                    .addCookie("_gcl_au", "1.1.37825719.1553432252")
                    .addCookie("3AB9D23F7A4B3C9B", "6FXNOMUDO5K7FXYKWFHPCMS3U73CJYP4ZWKLCN3VUJCIMND5QCMWPZA2KFRLIEOGQZRWXBJNMAOQNABRBVGIZVOV4A")
                    .addCookie("shshshsID", "203585b8070811eb60a046131256fb25_1_1553435189655")
                    .addCookie("__jda", "122270672.15521368279441897898655.1552136828.1553431012.1553435190.9")
                    .addCookie("__jdb", "122270672.1.15521368279441897898655|9.1553435190")
                    .addCookie("__jdv", "122270672|direct|-|none|-|1553435189820")
                    .setSleepTime(2000);

        }
        return site;
    }


    private String parserCategory(Page page) {

        StringBuilder builder = new StringBuilder();

        builder.append(page.getHtml().css("#crumb-wrap item").toString());


        return builder.toString();

    }




    public static void main(String[] args) {


//        System.out.println(System.getProperty("selenuim_config"));

        Spider.create(new JdComPageProcessor())
                .addUrl("https://item.pageprocessor.com/25051544376.html")
//                .addUrl("https://book.jd.com")
                .setDownloader(new SeleniumDownloader())
//                .addPipeline(new JsonFilePipeline("D:\\tmp\\pageprocessor\\"))
                .thread(1).run();

//        -Dselenuim_config=C:\\Users\\jiey\\webmagic-selenium\\config.ini


    }
}
