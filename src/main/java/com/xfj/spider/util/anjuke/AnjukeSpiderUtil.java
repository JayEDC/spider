package com.xfj.spider.util.anjuke;

 /** not bug with the project
  *
  *      ┏┛ ┻━━━━━┛ ┻┓
  *      ┃　　　　　　 ┃
  *      ┃　　　━　　　┃
  *      ┃　┳┛　  ┗┳　┃
  *      ┃　　　　　　 ┃
  *      ┃　　　┻　　　┃
  *      ┃　　　　　　 ┃
  *      ┗━┓　　　┏━━━┛
  *        ┃　　　┃   神兽保佑
  *        ┃　　　┃   代码无BUG！
  *        ┃　　　┗━━━━━━━━━┓
  *        ┃　　　　　　　    ┣┓
  *        ┃　　　　         ┏┛
  *        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
  *          ┃ ┫ ┫   ┃ ┫ ┫
  *          ┗━┻━┛   ┗━┻━┛
  *
  * */

import com.xfj.spider.util.handler.crawl.Crawl;
import com.xfj.spider.util.handler.crawl.ChainCrawl;
import com.xfj.spider.util.handler.downloader.AnjukeSeleniumDownloader;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @ClassName FiveEightSpiderUtil
 * @Description //TODO
 * @Author xnc
 * @Date 2018/11/294:55 PM
 * @return 1.0
 **/
public class AnjukeSpiderUtil implements PageProcessor {

    private ChainCrawl chainCrawl = new ChainCrawl();


    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    public AnjukeSpiderUtil(){
        super();
    }
    public void add(Crawl crawl){
        chainCrawl.add(crawl);

    }
    @Override
    public void process(Page page) {
       chainCrawl.run(page);
       page.setSkip(true);
    }


    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        // 安居客经纪人页面
        String url ="https://zh.anjuke.com/tycoon/?from=navigation";
        AnjukeSpiderUtil anjukeSpiderUtil = new AnjukeSpiderUtil();

        Spider.create(anjukeSpiderUtil)
                .setDownloader(new AnjukeSeleniumDownloader())
                .addUrl(url)
                .thread(1)
                .run();
    }


}


