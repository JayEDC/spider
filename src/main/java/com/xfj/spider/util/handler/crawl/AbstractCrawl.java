package com.xfj.spider.util.handler.crawl;

import us.codecraft.webmagic.Page;

/**
 * @author Lao SiCheng
 * @version 0.1
 */
public abstract class AbstractCrawl implements Crawl {
    @Override
    public abstract boolean run(Page page);

    public boolean checkUrlWithKey(Page page ,String key){
        return page.getUrl().toString().contains(key);
    }
    public boolean checkUrlWithKey(String url,String key){
        return url.contains(key);
    }
}
