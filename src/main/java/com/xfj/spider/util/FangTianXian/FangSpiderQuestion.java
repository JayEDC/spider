package com.xfj.spider.util.FangTianXian;

import com.xfj.spider.util.handler.crawl.ChainCrawl;
import com.xfj.spider.util.handler.crawl.Crawl;
import com.xfj.spider.util.handler.downloader.SeleniumDownloader;
import com.xfj.spider.util.handler.downloader.SpikeFileCacheQueueScheduler;
import com.xfj.spider.util.handler.pipeline.FangCommentsPipeline;
import com.xfj.spider.util.handler.pipeline.FangQuestionPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.FileCacheQueueScheduler;

import javax.management.JMException;

/**
 * @ClassName FangSpiderQuestion
 * @Description //TODO
 * @Author xnc
 * @Date 2019/1/95:34 PM
 * @return 1.0
 **/
@Component
public class FangSpiderQuestion implements PageProcessor {

    private ChainCrawl chainCrawl = new ChainCrawl();

    public void add(Crawl crawl){
        chainCrawl.add(crawl);
    }

    @Autowired
    FangCommentsPipeline fangCommentsPipeline;
    @Autowired
    FangQuestionPipeline fangQuestionPipeline;

    @Override
    public void process(Page page) {
        Boolean success = chainCrawl.run(page);
        page.setSkip(!success);
    }

    private Site site = Site.me().setRetryTimes(1).setSleepTime(100);

    @Override
    public Site getSite() {
        return site;
    }

    public void run(String url) throws JMException {
        FileCacheQueueScheduler fileCacheQueueScheduler = new FileCacheQueueScheduler("E:\\spider");

        Spider spider = Spider.create(this);
        spider.setDownloader(new SeleniumDownloader().setSleepTime(100));
        spider.setScheduler(fileCacheQueueScheduler);
        spider.addUrl(url);
        spider.addPipeline(fangQuestionPipeline);
        spider.addPipeline(fangCommentsPipeline);
        spider.thread(10);
        spider.run();
        SpiderMonitor.instance().register(spider);
    }
}
