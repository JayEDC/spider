package com.xfj.spider;

import com.xfj.spider.util.FangTianXian.FangSpiderHouseZhishi;
import com.xfj.spider.util.FangTianXian.FangSpiderQuestion;
import com.xfj.spider.util.FangTianXian.FangSpiderWenda;
import com.xfj.spider.util.SpringUtil;
import com.xfj.spider.util.handler.crawl.FangCommentsCrawl;
import com.xfj.spider.util.handler.crawl.FangQuestionCrawl;
import com.xfj.spider.util.handler.crawl.FangZhiShiCrawl;
import com.xfj.spider.util.handler.crawl.HkeaAgentCrawl;
import com.xfj.spider.util.handler.test.TestAgentCrawl;
import com.xfj.spider.util.hkea.HkeaAgent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import sun.management.resources.agent;
import tk.mybatis.spring.annotation.MapperScan;

import javax.management.JMException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

@SpringBootApplication
@MapperScan(value = "com.xfj.spider.mapper")
//@EnableCaching
public class SpiderApplication {

    public static void main(String[] args) throws JMException {
        ApplicationContext  applicationContext = SpringApplication.run(SpiderApplication.class, args);
        SpringUtil.setApplicationContext(applicationContext);
        //IPDataCache.initIpCatch();
        //EsfToolsSpiderProxyIp esfToolsSpiderProxyIp = IPDataCache.getRandomProxyIp();
        //new FiveEightSpiderUtil().main();
        //TestAgentCrawl testAgentCrawl = applicationContext.getBean(TestAgentCrawl.class);
       // testAgentCrawl.testCrawAgentListAndDetail();
       /// System.out.println("___________________"+esfToolsSpiderProxyIp.getIpAddr());
        FangSpiderQuestion fangSpiderQuestion = SpringUtil.getBean(FangSpiderQuestion.class);
        fangSpiderQuestion.add(new FangCommentsCrawl());
        fangSpiderQuestion.run("https://www.fang.com/ask/ask_32099089.html");
       /* FangSpiderHouseZhishi fangSpiderHouseZhishi = SpringUtil.getBean(FangSpiderHouseZhishi.class);
        fangSpiderHouseZhishi.add(new FangZhiShiCrawl());
        fangSpiderHouseZhishi.run("https://zhishi.fang.com/xf/");*/

        /*HkeaAgent agent = SpringUtil.getBean(HkeaAgent.class);
        agent.add(new HkeaAgentCrawl());
        agent.run("http://www.hkea.com.hk/pub/ListingServ");*/

        /*https://www.fang.com/ask/Search.html?Title=%E5%B9%B3%E6%B2%99%E4%B9%9D%E5%8F%B72%E6%9C%9F

https://www.fang.com/ask/Search.html?searchtitle=%E9%A6%99%E6%B0%B4%E9%B8%BF%E9%97%A8

https://www.fang.com/ask/Search.html?searchtitle=%E9%94%A6%E7%BB%A3%E5%9B%BD%E9%99%85%E8%8A%B1%E5%9F%8E
https://www.fang.com/ask/Search.html?searchtitle=%E7%8F%A0%E6%B5%B7%E9%80%B8%E9%AA%8F%E6%98%9F%E5%9B%AD
https://www.fang.com/ask/Search.html?searchtitle=%E7%95%94%E5%B1%B1%E4%B8%AD%E5%BF%83%E5%9F%8E*/

       /* String url = null;
        try {
             url = java.net.URLEncoder.encode("泰禾中央广场","utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        List<String> list = new ArrayList<>();

        for(int i=20;i>=0;i--){
            list.add("https://www.fang.com/ask/Search/Index.do?pageNo="+i+"&pagesize=20&Searchtitle="+url);
        }
        FangSpiderWenda question  = SpringUtil.getBean(FangSpiderWenda.class);
        question.add(new FangQuestionCrawl(list));
        question.run("https://www.fang.com/ask/Search.html?searchtitle="+url);*/
    }



}
