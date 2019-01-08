package com.xfj.spider.util.FangTianXian;

import com.xfj.spider.util.handler.crawl.ChainCrawl;
import com.xfj.spider.util.handler.crawl.Crawl;
import com.xfj.spider.util.handler.downloader.SeleniumDownloader;
import com.xfj.spider.util.handler.pipeline.FangZhiShiPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @ClassName FangSpiderHouseZhishi
 * @Description 房天下 房产知识采集
 * @Author xnc
 * @Date 2019/1/711:23 AM
 * @return 1.0
 **/
public class FangSpiderHouseZhishi implements PageProcessor {

    private static ChainCrawl chainCrawl = new ChainCrawl();

    @Autowired
    private FangZhiShiPipeline fangZhiShiPipeline;

    public void add(Crawl crawl){
        chainCrawl.add(crawl);
    }

    @Override
    public void process(Page page) {
        Boolean success = chainCrawl.run(page);
        page.setSkip(!success);
    }

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public Site getSite() {
        return site;
    }

    public void run(String url){
        Spider spider = Spider.create(new FangSpiderHouseZhishi());
        spider.setDownloader(new SeleniumDownloader().setSleepTime(1000));
        spider.addUrl(url);
        spider.addPipeline(fangZhiShiPipeline);
        spider.thread(5);
        spider.run();
    }
}
