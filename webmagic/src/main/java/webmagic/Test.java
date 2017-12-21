package webmagic;


import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;


public class Test implements PageProcessor {


    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me()
                            .setRetryTimes(10)
                            .setSleepTime(1000)
                            .setTimeOut(3000)
                            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
    @Override
    public Site getSite() {
        return site;
    }

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
        page.putField("author", page.getHtml().css(".tab1").links().all());

        //page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        System.out.println("page = " + page.getResultItems().get("author"));


       // page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

        // 部分三：从页面发现后续的url地址来抓取
        //page.addTargetRequests(page.getHtml().links().c.all());
    }



    public static void main(String[] args) {

        Spider.create(new Test())
            //从"http://data.eastmoney.com/dxf/default.html"开始抓
            .addUrl("http://data.eastmoney.com/dxf/default.html")
            //开启5个线程抓取
            .thread(5)
            //启动爬虫
            .run();
    }
}