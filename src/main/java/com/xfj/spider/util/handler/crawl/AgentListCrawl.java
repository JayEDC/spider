package com.xfj.spider.util.handler.crawl;

import com.xfj.spider.util.handler.base.ConstantAnjuke;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Selectable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 经纪人列表页，获取列表信息，继续进行循环
 * @author Lao SiCheng
 * @version 0.1
 */
public class AgentListCrawl extends AbstractCrawl {

    @Override
        public boolean run(Page page) {
        // 获取url进行页面区分

        if(this.checkUrlWithKey(page, ConstantAnjuke.AGENTPAGELIST)){
            //  //*[@id="list-content"]
            Selectable listPage = page.getHtml().xpath("//*[@id=\"list-content\"]");

            // 进一步判断获取内容是否存在
            if(null != listPage.get()){
                //对列表页过滤
                List<String> listLinks = listPage.links().all();
                Set<String> set = new HashSet<>();
                for(String link : listLinks){
                    // 去掉一些不像的链接
                    if(this.checkUrlWithKey(link, ConstantAnjuke.AGENTPAGEINFO)){
                        // todo 注意这里，手动修改链接
                        //set.add(link+ConstantAnjuke.AGENTINFO+"/");
                        set.add(link);
                    }
                }
                listLinks.clear();
                listLinks.addAll(set);
                page.addTargetRequests(listLinks);
            }
            // 判断下一页内容
            Selectable lastPageElement = page.getHtml().$(".aNxt");
            List<String> listLastPage = lastPageElement.links().all();
            if(listLastPage!=null && listLastPage.size()>0) {
                //获取下一页元素链接，继续循环, 理论上，下一页的元素只有一个
                page.addTargetRequest(listLastPage.get(0));
            }
            return true;

        }
        return false;

    }
}
