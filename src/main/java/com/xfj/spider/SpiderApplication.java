package com.xfj.spider;

import com.xfj.spider.cache.IPDataCache;
import com.xfj.spider.model.EsfToolsSpiderProxyIp;
import com.xfj.spider.util.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

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
@MapperScan(value = "com.xfj.spider.mapper")
@SpringBootApplication
@EnableCaching
public class SpiderApplication {

    public static void main(String[] args) {
        ApplicationContext  applicationContext = SpringApplication.run(SpiderApplication.class, args);
        SpringUtil.setApplicationContext(applicationContext);
        IPDataCache.initIpCatch();
        EsfToolsSpiderProxyIp esfToolsSpiderProxyIp = IPDataCache.getRandomProxyIp();
        System.out.println("___________________"+esfToolsSpiderProxyIp.getIpAddr());
    }
}
