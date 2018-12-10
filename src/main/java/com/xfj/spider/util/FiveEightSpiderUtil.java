package com.xfj.spider.util;

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
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.processor.PageProcessor;

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


    }

    @Override
    public Site getSite() {
        return null;
    }

    public static void main(String[] args) {

        System.setProperty("selenuim_config", "D://config.ini");
        String url ="https://www.58.com/changecity.html?catepath=ershoufang&catename=%E4%BA%8C%E6%89%8B%E6%88%BF&fullpath=1,12&PGTID=0d30000c-0038-f227-b760-34098987f1da&ClickID=1";
        Spider.create(new FiveEightSpiderUtil())
                .setDownloader(new SeleniumDownloader("D://chromedriver.exe"))
                .addUrl(url).thread(5).run();



    }


}


