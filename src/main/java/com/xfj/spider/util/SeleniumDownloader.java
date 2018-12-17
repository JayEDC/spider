package com.xfj.spider.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.Downloader;

import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.PlainText;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 使用Selenium调用浏览器进行渲染。目前仅支持chrome。<br>
 * 需要下载Selenium driver支持。<br>
 *
 * @author code4crafter@gmail.com <br>
 *         Date: 13-7-26 <br>
 *         Time: 下午1:37 <br>
 */
public class SeleniumDownloader implements Downloader, Closeable {

	private volatile WebDriverPool webDriverPool;

	private Logger logger = Logger.getLogger(getClass());

	private int sleepTime = 0;

	private int poolSize = 1;

	private static final String DRIVER_PHANTOMJS = "phantomjs";

	private Integer retry = 0;

	/**
	 * 新建
	 *
	 * @param chromeDriverPath chromeDriverPath
	 */
	public SeleniumDownloader(String chromeDriverPath) {
		System.getProperties().setProperty("webdriver.chrome.driver",
				chromeDriverPath);
	}

	/**
	 * Constructor without any filed. Construct PhantomJS browser
	 * 
	 * @author bob.li.0718@gmail.com
	 */
	public SeleniumDownloader() {
		// System.setProperty("phantomjs.binary.path",
		// "/Users/Bingo/Downloads/phantomjs-1.9.7-macosx/bin/phantomjs");
	}

	/**
	 * set sleep time to wait until load success
	 *
	 * @param sleepTime sleepTime
	 * @return this
	 */
	public SeleniumDownloader setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
		return this;
	}

    /**
     * set rety 重试次数
     * @param retry
     */
    public SeleniumDownloader(Integer retry) {
        this.retry = retry;
    }

	@Override
	public Page download(Request request, Task task) {
		checkInit();
		WebDriver webDriver;
        try {
            webDriver = webDriverPool.get();
        } catch (InterruptedException e) {
            logger.warn("interrupted", e);
            return null;
        }

		/*
		 * TODO You can add mouse event or other processes
		 * 
		 * @author: bob.li.0718@gmail.com
		 */


        Page page;
		/**
		 * 这里对58同城ip封禁做处理，ip 封了之后获取页面会有异常抛出（有待改进）
		 */
		try {

            logger.info("downloading page " + request.getUrl());
            webDriver.get(request.getUrl());
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebDriver.Options manage = webDriver.manage();
            Site site = task.getSite();
            if (site.getCookies() != null) {
                for (Map.Entry<String, String> cookieEntry : site.getCookies()
                        .entrySet()) {
                    Cookie cookie = new Cookie(cookieEntry.getKey(),
                            cookieEntry.getValue());
                    manage.addCookie(cookie);
                }
            }

			/**
			 * 如果页面中出现 经纪人电话 进行点击事件，动态获取电话
			 */
            WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\"userPhone\"]"));
            if(null != webElement) {
                webElement.click();
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
			/**
			 * 如果经纪人存在房源则进行点击，获取最后一页，计算总数
			 */
			webElement = webDriver.findElement(By.xpath("/html"));
			String content = webElement.getAttribute("outerHTML");
			Html html = new Html(content, request.getUrl());
			int count = html.css(".paging-list li").all().size();
			webElement = webDriver.findElement(By.xpath("//*[@id=\"gent-list\"]/div[1]/div/ul/li["+count+"]"));
            if (null != webElement){
				webElement.click();
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			/**
			 * 最后获取html 页面返回
			 */
			webElement = webDriver.findElement(By.xpath("/html"));
            content = webElement.getAttribute("outerHTML");
            page = new Page();
            page.setRawText(content);
            page.setHtml(new Html(content, request.getUrl()));
            page.setUrl(new PlainText(request.getUrl()));
            page.setRequest(request);
			/**
			 * 如果获取到验证页面，递归换 ip 后继续获取
			 */
			if(page.getHtml().xpath("//*[@id=\"btnSubmit\"]").get() != null){
				/**
				 * 将这个ip 被封的 webDiver从池中干掉
				 */
                webDriverPool.closeWebDriverList(webDriver);
                webDriver.quit();
				/**
				 * 继续调用download方法，会重新在WebDiverPool类中创建新的webDiver，又是一条好汉 -.-
				 */
				return download(request,task);
            }
            webDriverPool.returnToPool(webDriver);
        }catch (Exception exception){
            webDriverPool.closeWebDriverList(webDriver);
            webDriver.quit();
            return download(request,task);
        }

		return page;
	}

	private void checkInit() {
		if (webDriverPool == null) {
			synchronized (this) {
				webDriverPool = new WebDriverPool(poolSize);
			}
		}
	}

	@Override
	public void setThread(int thread) {
		this.poolSize = thread;
	}

	@Override
	public void close() throws IOException {
		webDriverPool.closeAll();
	}
}
