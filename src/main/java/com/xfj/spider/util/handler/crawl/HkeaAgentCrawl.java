package com.xfj.spider.util.handler.crawl;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HkeaAgentCrawl
 * @Description //TODO
 * @Author xnc
 * @Date 2019/1/284:42 PM
 * @return 1.0
 **/
public class HkeaAgentCrawl extends AbstractCrawl {

    @Override
    public boolean run(Page page) {

        Html html = page.getHtml();
        String url = page.getUrl().get();
        /**
         * 获取所有房源连接
         */
        List<String> urls = html.css(".loupan_box .lp_mk_img").links().all();
        page.addTargetRequests(urls);

        if(this.checkUrlWithKey(page,"ListingServ") && !this.checkUrlWithKey(page,"pid") && !this.checkUrlWithKey(page,"currPage")){
            List<String> list = new ArrayList<>();
            for (int i = 50;i >= 2;i--){
                list.add("http://www.hkea.com.hk/pub/ListingServ?currPage="+i);
            }
            page.addTargetRequests(list);
        }

        if(this.checkUrlWithKey(page,"pid")){
            List<String> list = html.css(".people p","text").all();
            if(null != list && list.size() != 0){
                String[] name = list.get(0).split("：");
                page.putField("name",name[1]);
                String[] phone = list.get(1).split("：");
                page.putField("phone",phone[1]);
                String email = html.css(".people p a","text").get();
                page.putField("email",email);
                page.putField("type","1");
                page.putField("url",page.getUrl());
                return true;
            }
        }
        page.putField("type","0");
        return false;
    }
}
