package com.xfj.spider.util.handler.base;

import com.xfj.spider.util.handler.crawl.Crawl;
import com.xfj.spider.util.handler.crawl.ChainCrawl;
import com.xfj.spider.util.handler.downloader.AnjukeSeleniumDownloader;
import com.xfj.spider.util.handler.pipeline.AgentDetailPipeline;
import com.xfj.spider.util.handler.pipeline.AgentResoldPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author Lao SiCheng
 * @version 0.1
 */
@Component
public class TestCrawBase implements PageProcessor {
    private ChainCrawl chainCrawl = new ChainCrawl();
    @Autowired
    private  AgentDetailPipeline agentDetailPipeline;
    @Autowired
    private AgentResoldPipeline agentResoldPipeline;
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    public void add(Crawl crawl){
        chainCrawl.add(crawl);
    }
    @Override
    public void process(Page page) {
        Boolean success = chainCrawl.run(page);
        page.setSkip(!success);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public  void run(String url) {


        //TestCrawBase testCrawBase = new TestCrawBase();

        Spider.create(this)
                .setDownloader(new AnjukeSeleniumDownloader())
                .addUrl(url)
                .addPipeline(new ConsolePipeline())
                .addPipeline(agentDetailPipeline)
                .addPipeline(agentResoldPipeline)
                .thread(3)
                .run();
    }
}
