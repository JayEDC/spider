package com.xfj.spider;

import com.xfj.spider.util.handler.test.TestAgentCrawl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@MapperScan(value = "com.xfj.spider.mapper")
@SpringBootTest
public class SpiderApplicationTests {


    @Test
    public void contextLoads() {
        System.out.println("233");
        //TestAgentCrawl testAgentCrawl = new TestAgentCrawl();
        //testAgentCrawl.testCrawlAgentDetail();
    }

}
