package com.xfj.spider.util.hkea;

import com.xfj.spider.util.FangTianXian.FangSpiderHouseZhishi;
import com.xfj.spider.util.handler.crawl.ChainCrawl;
import com.xfj.spider.util.handler.crawl.Crawl;
import com.xfj.spider.util.handler.downloader.SeleniumDownloader;
import com.xfj.spider.util.handler.pipeline.HkeaAgentDataPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @ClassName HkeaAgent
 * @Description //TODO
 * @Author xnc
 * @Date 2019/1/284:32 PM
 * @return 1.0
 **/
@Component
public class HkeaAgent implements PageProcessor {

    private static ChainCrawl chainCrawl = new ChainCrawl();

    @Autowired
    private HkeaAgentDataPipeline hkeaAgentDataPipeline;

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
        Spider spider = Spider.create(new HkeaAgent());
        spider.addPipeline(hkeaAgentDataPipeline);
        spider.addUrl(url);
        spider.thread(5);
        spider.run();
    }

}
