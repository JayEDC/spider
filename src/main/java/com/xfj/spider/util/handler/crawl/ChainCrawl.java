package com.xfj.spider.util.handler.crawl;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lao SiCheng
 * @version 0.1
 */
public class ChainCrawl implements Crawl{
    // 存放所有检测页面方法
    List<Crawl> crawls = new  ArrayList<>();
    @Override
    public boolean run(Page page) {
        // 循环检测页面内容
        for(Crawl crawl : crawls){
            boolean result = crawl.run(page);
            //如果检测有需要信息，跳出循环
            if(result){
                return true;
            }
        }
        return true;
    }
    public ChainCrawl add(Crawl crawl){
        crawls.add(crawl);
        return this;
    }
}
