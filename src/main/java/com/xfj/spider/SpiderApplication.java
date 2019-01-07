package com.xfj.spider;

import com.xfj.spider.util.handler.test.TestAgentCrawl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import tk.mybatis.spring.annotation.MapperScan;

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
@EnableCaching
public class SpiderApplication {

    public static void main(String[] args) {
        ApplicationContext  applicationContext = SpringApplication.run(SpiderApplication.class, args);



        //SpringUtil.setApplicationContext(applicationContext);
        //IPDataCache.initIpCatch();
        //EsfToolsSpiderProxyIp esfToolsSpiderProxyIp = IPDataCache.getRandomProxyIp();
        //new FiveEightSpiderUtil().main();
        TestAgentCrawl testAgentCrawl = applicationContext.getBean(TestAgentCrawl.class);
        testAgentCrawl.testCrawAgentListAndDetail();
       /// System.out.println("___________________"+esfToolsSpiderProxyIp.getIpAddr());
    }
}
