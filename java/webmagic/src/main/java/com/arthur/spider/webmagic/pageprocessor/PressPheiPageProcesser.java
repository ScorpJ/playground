package com.arthur.spider.webmagic.pageprocessor;

import com.arthur.spider.webmagic.utils.PageType;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.DuplicateRemovedScheduler;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Selectable;

import javax.management.JMException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//电子工业出版社
public class PressPheiPageProcesser implements PageProcessor {


    private static final String DFT_USR_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36";

    private Site site;


    @Override
    public void process(Page page) {


        PageType curPageType = parserPageType(page.getUrl().get());


        switch(curPageType){
            case ListPage:
                this.processListPage(page);
                page.setSkip(true);
                break;
            case DetailPage:
                this.processDetailPage(page);
                break;
            default:
                page.setSkip(true);
                break;
        }
    }


    private PageType parserPageType(String url){

        if(url.contains("bookid=")){
            return PageType.DetailPage;
        }
        if(url.contains("searchkey")){
            return PageType.ListPage;
        }
        return PageType.UnkonwnType;
    }

    private void processListPage(Page page){
        List<String>  filteredLinks = page.getHtml().links()
                .regex("(https://www\\.phei\\.com\\.cn/module/goods/.+(?!#))").all();

        filteredLinks = filteredLinks.stream()
                .filter(e -> !(e.contains("#")) &&
                        e.contains("bookid=")
                        && e.matches(".*(\\d+)$"))
                .collect(Collectors.toSet())
                .stream().collect(Collectors.toList());

        page.addTargetRequests(filteredLinks);
    }

    private void processDetailPage(Page page){

        //Parser page content
        String[] categories =  this.parserCategory(page);
        String innerBookId = page.getUrl().regex("bookid=(\\d+)").get();
        String title = page.getHtml().xpath("div[@class='content_book_info']/h1/text()").toString();
        String authorInfo = page.getHtml().xpath("div[@class='content_book_info']/p[2]/text()").toString();
        String pubDateStr = page.getHtml().xpath("div[@class='content_book_info']/p[3]/span[1]/text()").toString();
        String words = page.getHtml().xpath("div[@class='content_book_info']/p[3]/span[2]/text()").toString();
        String version = page.getHtml().xpath("div[@class='content_book_info']/p[3]/span[3]/text()").toString();
        String pageNum = page.getHtml().xpath("div[@class='content_book_info']/p[3]/span[4]/text()").toString();
        String isbn = page.getHtml().xpath("div[@class='content_book_info']/p[4]/span[3]/text()").toString();
        String bidPrice = page.getHtml().xpath("p[@class='book_price']/span/text()").toString();

        String contentSummary = page.getHtml().xpath("div[@class='book_inner_content']/p/text()").get();

        //目录
        String catalog = page.getHtml().xpath("div[@class='book_inner_content']/textarea[1]/text()").get();
        //前言
        String preface = page.getHtml().xpath("div[@class='book_inner_content']/textarea[2]/text()").get();;
        //上架建议
        String tags = page.getHtml().xpath("div[@class='book_inner_content']/textarea[3]/text()").get();;
        String authorSummary = page.getHtml().xpath("div[@class='book_inner_content']/textarea[4]/text()").get();;
        String editorRecommend = page.getHtml().xpath("div[@class='book_inner_content']/textarea[5]/text()").get();;

        page.putField("Categories", categories);
        page.putField("InnerBookId", innerBookId);
        page.putField("Title", cleanData(title));
        page.putField("AuthorInfo", cleanData(authorInfo));
        page.putField("PubDate", cleanData(pubDateStr));
        page.putField("Words", cleanData(words));
        page.putField("Version", cleanData(version));
        page.putField("PageNum", cleanData(pageNum));
        page.putField("ISBN", cleanData(isbn));
        page.putField("BidPrice", cleanData(bidPrice));

        page.putField("ContentSummary", cleanData(contentSummary));
        page.putField("Catalog", (catalog));
        page.putField("Preface", (preface));
        page.putField("Tags", cleanData(tags));
        page.putField("AuthorSummary", cleanData(authorSummary));
        page.putField("EditorRecommend", cleanData(editorRecommend));

        page.putField("URL", page.getUrl().get());

    }

    private String[] parserCategory(Page page){

        List<String> categories = new ArrayList<>();

        List<Selectable> nodes = page.getHtml().xpath("div[@class='web_book_localtion']/a/text()").nodes();
        String leafNode = page.getHtml().xpath("div[@class='web_book_localtion']/span/text()").get();
        for(Selectable node: nodes){
            categories.add(node.get());
        }
        categories.add(leafNode);

        return categories.toArray(new String[0]);
    }

    private String cleanData(String passInValue){

        if(StringUtils.isBlank(passInValue)){
            return StringUtils.EMPTY;
        }

        if(passInValue.contains(":")){
            return passInValue.split(":")[1].replaceAll("\\u00A0", " ").trim();
        }else if(passInValue.contains("：")){
            return passInValue.split("：")[1].replaceAll("\\u00A0", " ").trim();
        }else{
            return passInValue.replaceAll("\\u00A0", " ").trim();
        }
    }



    @Override
    public Site getSite() {
        if (null == site) {
            site = Site.me().setDomain("www.phei.com.cn")
                    .setUserAgent(DFT_USR_AGENT)
                    .setSleepTime(500);
        }
        return site;
    }

    public static void main(String[] args) throws JMException {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();

        DuplicateRemovedScheduler scheduler = new QueueScheduler();

        scheduler.setDuplicateRemover(new BloomFilterDuplicateRemover(1000000));
//        httpClientDownloader.setProxyProvider(
//                SimpleProxyProvider.from(new Proxy("cn-proxy.jp.oracle.com",80)));

        //科技, 教育, 经管， 少儿， 大众
        String[] startPoints = {
//                "https://www.phei.com.cn/module/goods/searchkey.jsp?goodtypeid=1&goodtypename=%E7%A7%91%E6%8A%80",
//                "https://www.phei.com.cn/module/goods/searchkey.jsp?goodtypeid=1&goodtypename=%E6%95%99%E8%82%B2",
//                "https://www.phei.com.cn/module/goods/searchkey.jsp?goodtypeid=1&goodtypename=%E7%BB%8F%E6%B5%8E%E7%AE%A1%E7%90%86",
                "https://www.phei.com.cn/module/goods/searchkey.jsp?goodtypeid=1&goodtypename=%E5%B0%91%E5%84%BF"
//                "https://www.phei.com.cn/module/goods/searchkey.jsp?goodtypeid=1&goodtypename=%E5%A4%A7%E4%BC%97"
        };


        List<String> listPageUrls = new LinkedList<>();

        for(int pageNum = 1 ; pageNum <= 67; pageNum++){
            for(String baseUrl: startPoints){
                listPageUrls.add(baseUrl+ "&Page=" + pageNum);
            }
        }

        Spider pheiSpider = Spider.create(new PressPheiPageProcesser())
                .setScheduler(scheduler)
                .setDownloader(httpClientDownloader)
                .addUrl(listPageUrls.toArray(new String[0]))
                .addPipeline(new JsonFilePipeline("D:\\tmp\\books_phei\\"))
                .thread(1);

        SpiderMonitor.instance().register(pheiSpider);
        pheiSpider.start();

    }
}
