package com.xfj.spider.util.handler.test;

import com.xfj.spider.util.handler.crawl.Crawl;
import com.xfj.spider.util.handler.crawl.AgentDetailCrawl;
import com.xfj.spider.util.handler.crawl.AgentListCrawl;
import com.xfj.spider.util.handler.base.TestCrawBase;


import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


/**
 * @author Lao SiCheng
 * @version 0.1
 */
@Configuration
public class TestAgentCrawl {
    @Autowired
    TestCrawBase testCrawBase;
    @Test
    public void testTestCrawlAgentList() {
        // 测试经纪人列表链接
        // 采集深圳经纪人信息
        String url ="https://shenzhen.anjuke.com/tycoon/?from=navigation";
        Crawl agentCrawl = new AgentListCrawl();
        TestCrawBase testCrawBase = new TestCrawBase();
        testCrawBase.add(agentCrawl);
        testCrawBase.run(url);

    }
    @Test
    public void testCrawlAgentDetail(){
        // 测试经纪人具体信息链接
        String url ="https://zhongyuandichan1.anjuke.com/gongsi-jjr-1636395/js/";

        Crawl agentCrawl = new AgentDetailCrawl();
        testCrawBase.add(agentCrawl);
        testCrawBase.run(url);
    }
    @Test
    public void testCrawAgentListAndDetail(){
        // 惠州
        String url = "https://huizhou.anjuke.com/tycoon/?from=navigation";
        // 河源
        //String url = "https://heyuan.anjuke.com/tycoon/?from=navigation";
        // 江门
        //String url = "https://jiangmen.anjuke.com/tycoon/?from=navigation";
        // 梅州
        //String url = "https://meizhou.anjuke.com/tycoon/?from=navigation";
        // 佛山
        //String url = "https://foshan.anjuke.com/tycoon/?from=navigation";
        //汕尾
        //String url ="https://shanwei.anjuke.com/tycoon/?from=navigation";
        //中山
        //String url ="https://zs.anjuke.com/tycoon/?from=navigation";
        //湛江
        //String url="https://zhanjiang.anjuke.com/tycoon/?from=navigation";
        //肇庆
        //String url ="https://zhaoqing.anjuke.com/tycoon/?from=navigation";
        //广州
        //String url ="https://guangzhou.anjuke.com/tycoon/?from=navigation";
        //深圳
        //String url ="https://shenzhen.anjuke.com/tycoon/?from=navigation";
        Crawl agentListCrawl = new AgentListCrawl();
        Crawl agentDetailCrawl = new AgentDetailCrawl();
        testCrawBase.add(agentListCrawl);
        testCrawBase.add(agentDetailCrawl);
        testCrawBase.run(url);
    }
    @Test
    public void ProxyUsingChromeDriver()
    {
        //Set the location of the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/Users/lao/Downloads/chromedriver");
        //Create a new desired capability
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        // Create a new proxy object and set the proxy
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("192.168.10.58:8888");
        //Add the proxy to our capabilities
        //capabilities.setCapability("proxy", proxy);
        //Start a new ChromeDriver using the capabilities object we created and added the proxy to
        //ChromeDriver Driver = new ChromeDriver(capabilities);

       // Proxy proxy = new Proxy();
        //proxy.setHttpProxy("http://192.168.10.58:8888");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        chromeOptions.setCapability("proxy",proxy);
       // chromeOptions.setCapability("proxy",proxy);
        ChromeDriver Driver = new ChromeDriver(chromeOptions);

        //Navigation to a url and a look at the traffic logged in fiddler
        //Driver.navigate().to("http://www.baidu.com");
        Driver.get("http://www.baidu.com");
    }
}
