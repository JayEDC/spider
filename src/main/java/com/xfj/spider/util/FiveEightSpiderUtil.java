package com.xfj.spider.util;
import java.util.Date;
import java.util.*;

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

import com.xfj.spider.cache.IPDataCache;
import com.xfj.spider.model.Agent;
import com.xfj.spider.model.AgentPlatform;
import com.xfj.spider.model.EsfToolsSpiderProxyIp;
import com.xfj.spider.model.Telephone;
import com.xfj.spider.service.impl.AgentPlatformServiceImpl;
import com.xfj.spider.service.impl.AgentServiceImpl;
import com.xfj.spider.service.impl.TelephoneServiceImpl;
import com.xfj.spider.util.handler.downloader.AnjukeSeleniumDownloader;
import com.xfj.spider.util.handler.downloader.SeleniumDownloader;
import org.springframework.context.ApplicationContext;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;

import us.codecraft.webmagic.processor.PageProcessor;

import us.codecraft.webmagic.selector.Html;

import java.io.File;

/**
 * @ClassName FiveEightSpiderUtil
 * @Description //TODO
 * @Author xnc
 * @Date 2018/11/294:55 PM
 * @return 1.0
 **/
public class FiveEightSpiderUtil implements PageProcessor {

    private static File file = new File("");
    private static String path = file.getAbsolutePath();

    public void testSelenium() {

        /*System.getProperties().setProperty("webdriver.chrome.driver", path+"/src/main/resources/chrome/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://zh.58.com/ershoufang/36262266405262x.shtml?entinfo=36262266405262_0&fzbref=0&from=1-list-1&params=rankesfjxpclranxuanctrAB5099%5Edesc&psid=183492971202295729578498342&iuType=gz_2&ClickID=1&cookie=%7C%7Chttps%25253A%25252F%25252Fwww.baidu.com%25252Flink%25253Furl%25253Dd0q49jX8CMupkFpPc-0kK7pqhuj1QJu66SKClNIVQaO%252526wd%25253D%252526eqid%25253D83e1452800011dab000000065bfe5253%7Cc5/njVv+UlUoHU7VCR17Ag==&PGTID=0d30000c-0038-e382-a8f1-ae2476182d07&local=910&apptype=0&key=&pubid=51093428&trackkey=36262266405262_efbda79a-65d0-4ee5-9635-de1159def89e_20181128163237_1543393957429&fcinfotype=gz");
        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\"houseChatEntry\"]/div"));
        webElement.click();
        //webElement = webDriver.findElement(By.xpath("//*[@id=\"houseChatEntry\"]/div"));
        //System.out.println(webElement.getAttribute("outerHTML"));
        //System.out.println(webElement.getText());
        String phone = ((ChromeDriver)webDriver).findElementByCssSelector("p.phone-num").getText();
        //System.out.println(str);
        webDriver.close();*/


    }


    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {

        //判断页面类型
        if(page.getHtml().xpath("//*[@id=\"content-title\"]").get() != null && page.getHtml().xpath("//*[@id=\"content-title\"]").get().contains("按省份首字母选择")){
            //获取所有的城市连接
            List<String> links = page.getHtml().xpath("//*[@id=\"content-box\"]/div[3]/div[1]").links().all();
            page.addTargetRequests(links);
        }else if(page.getHtml().xpath("/html/body/div[5]/div[4]/a[2]").get() != null && page.getHtml().xpath("/html/body/div[5]/div[4]/a[2]").get().contains("二手房出售")){
            Html html = page.getHtml();
            //获取列表所有url地址
            List<String> links = html.css(".house-list-wrap .list-info .title a").links().all();
            page.addTargetRequests(links);
            //获取下一页url
            List<String> pageLinks = html.xpath("/html/body/div[5]/div[5]/div[1]/div[2]/a[4]").links().all();
            page.addTargetRequests(pageLinks);
        }else if(page.getHtml().xpath("//*[@id=\"houseChatEntry\"]/div/p[2]").get() != null && page.getHtml().xpath("//*[@id=\"houseChatEntry\"]/div/p[2]").get().contains("电话联系TA")){
            //获取经纪人信息url
            List<String> agentLinks = page.getHtml().xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[1]/a").links().all();
            page.addTargetRequests(agentLinks);
            System.out.println("--------- 当前池中连接数量 -------------" + page.getTargetRequests().size());
        } else if(page.getHtml().xpath("/html/body/div[3]/div[4]").get() != null){
            List<String> agentLinks = page.getHtml().css(".house-list-wrap li").links().all();
            List<String> url = page.getHtml().css(".pager .next").links().all();
            page.addTargetRequests(agentLinks);
            page.addTargetRequests(url);
        } else if (page.getHtml().xpath("/html/body/div[2]/div[2]/div[2]/div[1]/span").get() != null && page.getHtml().xpath("/html/body/div[2]/div[2]/div[2]/div[1]/span").get().contains("经纪人")) {
            Html html = page.getHtml();
            //获取经纪人名称
            String agentName = html.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/text()").get().trim();
            //经纪人电话
            String agentPhone = html.xpath("//*[@id=\"userPhone\"]/text()").get().trim();
            //经纪人公司
            String agentCompany = null ;
            if(html.xpath("/html/body/div[2]/div[2]/div[2]/div[3]/div[3]/span/text()").get().trim() != null){
               agentCompany = html.xpath("/html/body/div[2]/div[2]/div[2]/div[3]/div[3]/span/text()").get().trim();
            }
            //经纪人照片
            String agentPhoto = html.css(".info-head-img").css("img","src").get();
            //经纪人主营区域
            String area =  html.css(".zymk li","text").all().toString().trim();
            //经纪人主营小区
            String location = null;
            if( html.css(".zyxq li a","text").all().toString().trim() != null){
                location = html.css(".zyxq li a","text").all().toString().trim();
            }
            //经纪人工作年限
            String workDay = null ;
            if(html.xpath("/html/body/div[2]/div[2]/div[2]/div[3]/div[2]/span/text()").get().trim() != null ){
                workDay = html.xpath("/html/body/div[2]/div[2]/div[2]/div[3]/div[2]/span/text()").get().trim();
            }
            int work = StringUtil.stringToInt(workDay.substring(0,workDay.length()-1));
            //经纪人link
            String url = page.getUrl().get();
            //经纪人城市
            String city = html.xpath("//*[@id=\"commonTopbar\"]/div/div[1]/h2/text()").get().trim();
            //房源总数
            int count = 0;
            if(html.css(".paging-list .current","text").toString() != null){
                count = StringUtil.stringToInt(html.css(".paging-list .current","text").toString());
            }
            int houseCount = html.css(".agent-list-content li").all().size();
            houseCount = (count-1) * 10 + houseCount;

            AgentServiceImpl agentService = SpringUtil.getBean(AgentServiceImpl.class);
            AgentPlatformServiceImpl agentPlatformService = SpringUtil.getBean(AgentPlatformServiceImpl.class);
            TelephoneServiceImpl telephoneService = SpringUtil.getBean(TelephoneServiceImpl.class);

            //经纪人电话信息
            Telephone telephone = new Telephone();
            telephone.setTeTelephone(agentPhone);
            telephone.setTeCreateDate(new Date());
            int t = telephoneService.save(telephone);
            //经纪人信息
            Agent agent = new Agent();
            agent.setAtActiveDate(new Date());
            agent.setTeId(telephone.getTeId());
            agent.setAtCity(city);
            agent.setAtName(agentName);
            agent.setAtCompany(agentCompany);
            agent.setAtPhoto(agentPhoto);
            agent.setAtMainArea(area);
            agent.setAtMainLocation(location);
            agent.setAtCreateDate(new Date());
            agent.setAtHouseCount(houseCount);
            int i = agentService.save(agent);
            //经纪人平台信息
            AgentPlatform agentPlatform = new AgentPlatform();
            agentPlatform.setAmUpdateDate(new Date());
            agentPlatform.setAtId(agent.getAtId());
            agentPlatform.setPmId(2);
            agentPlatform.setAmWorkDay(work+"");
            agentPlatform.setAmCreateDate(new Date());
            agentPlatform.setAmUrl(url);
            int p = agentPlatformService.save(agentPlatform);
            if(t == 1 && i == 1 && p == 1){
                System.out.println("添加经纪人成功！姓名：" + agentName +" ---------- 电话:"+agentPhone);
            }

        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public void main() {

        ApplicationContext context =SpringUtil.getApplicationContext();
        //获取代理 ip
        ArrayList<EsfToolsSpiderProxyIp> spiderProxyIpList = IPDataCache.getProxyList();
        //设置代理IP
        /*Proxy[] proxyArray = new Proxy[spiderProxyIpList.size()];
        for(int i=0;i<spiderProxyIpList.size();i++){
            EsfToolsSpiderProxyIp spiderProxyIp = spiderProxyIpList.get(i);
            //IP地址
            String proxyIp = spiderProxyIp.getIpAddr();
            //端口
            Integer port = spiderProxyIp.getIpPort();
            //设置代理池
            Proxy proxy = new Proxy(proxyIp,port);
            proxyArray[i] = proxy;
        }*/
        /*//失败后切换代理ip
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader(){
            @Override
            protected void onError(Request request) {
                setProxyProvider(SimpleProxyProvider.from(proxyArray));
            }
        };*/

        String url ="https://gz.58.com/ershoufang/?PGTID=0d00000c-0000-01a2-1245-beb0cd841878&ClickID=1";
        String url1 ="https://broker.58.com/sz/list/pn118/?PGTID=0d00000c-0000-019d-53b8-283b2ced00f7&ClickID=1";
        Spider spider = Spider.create(new FiveEightSpiderUtil());
        spider.setDownloader(new SeleniumDownloader().setSleepTime(1000));
        spider.addUrl(url1);
        spider.thread(5);
        spider.run();

    }



    /*@Test
    public void ProxyUsingChromeDriver()
    {
        //Set the location of the ChromeDriver
        //System.setProperty("webdriver.chrome.driver", "/Users/lao/Downloads/chromedriver");
        System.getProperties().setProperty("webdriver.chrome.driver", path+"/src/main/resources/chrome/chromedriver");
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
    }*/

}


