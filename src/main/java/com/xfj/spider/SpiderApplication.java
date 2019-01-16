package com.xfj.spider;

import com.xfj.spider.util.FangTianXian.FangSpiderHouseZhishi;
import com.xfj.spider.util.FangTianXian.FangSpiderQuestion;
import com.xfj.spider.util.FiveEight.FiveEightSpiderUtil;
import com.xfj.spider.util.SpringUtil;
import com.xfj.spider.util.handler.crawl.FangCommentsCrawl;
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




/** The Pig
 *                                    -
 *      _._ _..._ .-',        _.._('))
 *     '-.          /_       /    ',
 *       )          \  .__.-'       /
 *      /  -   -                      '
 *     |   a   a                       \
 *     \    .-.                        |
 *      '-.('').-'             ,'      ;
 *          '- ；               |      ;
 *             \                \    .'
 *             | ?   ._  _  __ _.-\  /
 *             |  | |        / /  \ \
 *             / ,|,|      /,/   /,/
 *
 * */



@SpringBootApplication
@MapperScan(value = "com.xfj.spider.mapper")
public class SpiderApplication {

    public static void main(String[] args) {
        ApplicationContext  applicationContext = SpringApplication.run(SpiderApplication.class, args);
        //SpringUtil.setApplicationContext(applicationContext);
        //IPDataCache.initIpCatch();
        //EsfToolsSpiderProxyIp esfToolsSpiderProxyIp = IPDataCache.getRandomProxyIp();
        /*FangSpiderQuestion fangSpiderQuestion = SpringUtil.getBean(FangSpiderQuestion.class);
        fangSpiderQuestion.add(new FangCommentsCrawl());
        fangSpiderQuestion.run("https://www.fang.com/ask/ask_32099089.html");*/
        //System.out.println("___________________"+esfToolsSpiderProxyIp.getIpAddr());
    }
}
