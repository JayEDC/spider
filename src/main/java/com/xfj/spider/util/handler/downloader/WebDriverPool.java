package com.xfj.spider.util.handler.downloader;

import com.xfj.spider.cache.IPDataCache;
import com.xfj.spider.model.EsfToolsSpiderProxyIp;
import org.apache.log4j.Logger;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;

/**
 * @author code4crafter@gmail.com <br>
 *         Date: 13-7-26 <br>
 *         Time: 下午1:41 <br>
 */
class WebDriverPool {
	private Logger logger = Logger.getLogger(getClass());

	private final static int DEFAULT_CAPACITY = 20;

	private final int capacity;

	private final static int STAT_RUNNING = 1;

	private final static int STAT_CLODED = 2;

	private AtomicInteger stat = new AtomicInteger(STAT_RUNNING);

	private static File file = new File("");
	private static String path = file.getAbsolutePath();

	/*
	 * new fields for configuring phantomJS
	 */
	private WebDriver mDriver = null;
	private boolean mAutoQuitDriver = true;

	private static final String DEFAULT_CONFIG_FILE = path+"/src/main/resources/config.ini";
	private static final String DRIVER_FIREFOX = "firefox";
	private static final String DRIVER_CHROME = "chrome";
	private static final String DRIVER_PHANTOMJS = "phantomjs";

	protected static Properties sConfig;
	protected static DesiredCapabilities sCaps;

	/**
	 * Configure the GhostDriver, and initialize a WebDriver instance. This part
	 * of code comes from GhostDriver.
	 * https://github.com/detro/ghostdriver/tree/master/test/java/src/test/java/ghostdriver
	 * 
	 * @author bob.li.0718@gmail.com
	 * @throws IOException
	 */
	public void configure() throws IOException {
		// Read config file
		sConfig = new Properties();
		String configFile = DEFAULT_CONFIG_FILE;
		if (System.getProperty("selenuim_config")!=null){
			configFile = System.getProperty("selenuim_config");
		}
		sConfig.load(new FileReader(DEFAULT_CONFIG_FILE));

		// Prepare capabilities
		sCaps = new DesiredCapabilities();
		sCaps.setJavascriptEnabled(true);
		sCaps.setCapability("takesScreenshot", false);

		String driver = sConfig.getProperty("driver", DRIVER_PHANTOMJS);

		// Fetch PhantomJS-specific configuration parameters
		if (driver.equals(DRIVER_PHANTOMJS)) {
			// "phantomjs_exec_path"
			if (sConfig.getProperty("phantomjs_exec_path") != null) {
				sCaps.setCapability(
						PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
						sConfig.getProperty("phantomjs_exec_path"));
			} else {
				throw new IOException(
						String.format(
								"Property '%s' not set!",
								PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY));
			}
			// "phantomjs_driver_path"
			if (sConfig.getProperty("phantomjs_driver_path") != null) {
				System.out.println("Test will use an external GhostDriver");
				sCaps.setCapability(
						PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_PATH_PROPERTY,
						sConfig.getProperty("phantomjs_driver_path"));
			} else {
				System.out
						.println("Test will use PhantomJS internal GhostDriver");
			}
		}

		// Disable "web-security", enable all possible "ssl-protocols" and
		// "ignore-ssl-errors" for PhantomJSDriver
		// sCaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new
		// String[] {
		// "--web-security=false",
		// "--ssl-protocol=any",
		// "--ignore-ssl-errors=true"
		// });

		ArrayList<String> cliArgsCap = new ArrayList<String>();
		cliArgsCap.add("--web-security=false");
		cliArgsCap.add("--ssl-protocol=any");
		cliArgsCap.add("--ignore-ssl-errors=true");
		sCaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,
				cliArgsCap);

		// Control LogLevel for GhostDriver, via CLI arguments
		sCaps.setCapability(
				PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS,
				new String[] { "--logLevel="
						+ (sConfig.getProperty("phantomjs_driver_loglevel") != null ? sConfig
								.getProperty("phantomjs_driver_loglevel")
								: "INFO") });

		// String driver = sConfig.getProperty("driver", DRIVER_PHANTOMJS);

		// Start appropriate Driver
		if (isUrl(driver)) {
			sCaps.setBrowserName("phantomjs");
			mDriver = new RemoteWebDriver(new URL(driver), sCaps);
		} else if (driver.equals(DRIVER_FIREFOX)) {
			mDriver = new FirefoxDriver(sCaps);
		} else if (driver.equals(DRIVER_CHROME)) {
			//System.getProperties().setProperty("webdriver.chrome.driver", path+"/src/main/resources/chrome/chromedriver");
			Proxy proxy = new Proxy();
			//获取代理 ip
//			EsfToolsSpiderProxyIp proxyIp = IPDataCache.getRandomProxyIp();
//			proxy.setSocksUsername("1459792453@qq.com");
//			proxy.setSocksPassword("Qwertyuiop123");
//			proxy.setHttpProxy(proxyIp.getIpAddr()+":"+proxyIp.getIpPort());
			ChromeOptions chromeOptions = new ChromeOptions();
			//chromeOptions.addArguments("Proxy-Authorization:Basic MTQ1OTc5MjQ1M0BxcS5jb20lM0FRd2VydHl1aW9wMTIz");
			chromeOptions.addArguments("--user-agent='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36'");
			//chromeOptions.addArguments("--Proxy-Authorization='Basic MTQ1OTc5MjQ1M0BxcS5jb20lM0FRd2VydHl1aW9wMTIz'");
			//
			//chromeOptions.setHeadless(true);
			//为了获取console的日志输出
			/*DesiredCapabilities caps = DesiredCapabilities.chrome();
			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.BROWSER, Level.INFO);
			caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);*/
			//chromeOptions.setCapability("proxy",proxy);
			mDriver  = new ChromeDriver(chromeOptions);
			//logger.info("---------重置ip！当前 ip-------------" + proxyIp.getIpAddr());
		} else if (driver.equals(DRIVER_PHANTOMJS)) {
			mDriver = new PhantomJSDriver(sCaps);
		}
	}

	/**
	 * check whether input is a valid URL
	 * 
	 * @author bob.li.0718@gmail.com
	 * @param urlString urlString
	 * @return true means yes, otherwise no.
	 */
	private boolean isUrl(String urlString) {
		try {
			new URL(urlString);
			return true;
		} catch (MalformedURLException mue) {
			return false;
		}
	}

	/**
	 * store webDrivers created
	 */
	private List<WebDriver> webDriverList = Collections
			.synchronizedList(new ArrayList<WebDriver>());

	/**
	 * store webDrivers available
	 */
	private BlockingDeque<WebDriver> innerQueue = new LinkedBlockingDeque<WebDriver>();

	public WebDriverPool(int capacity) {
		this.capacity = capacity;
	}

	public WebDriverPool() {
		this(DEFAULT_CAPACITY);
	}
	public void closeWebDriverList(WebDriver webDriver){
		webDriverList.remove(webDriver);
		logger.info("---------删除失效webDriver-------------" + webDriver.getCurrentUrl());
	}

	/**
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public WebDriver get() throws InterruptedException {
		checkRunning();
		WebDriver poll = innerQueue.poll();
		if (poll != null) {
			return poll;
		}
		if (webDriverList.size() < capacity) {
			synchronized (webDriverList) {
				if (webDriverList.size() < capacity) {

					// add new WebDriver instance into pool
					try {
						configure();
						innerQueue.add(mDriver);
						webDriverList.add(mDriver);
					} catch (IOException e) {
						e.printStackTrace();
					}

					// ChromeDriver e = new ChromeDriver();
					// WebDriver e = getWebDriver();
					// innerQueue.add(e);
					// webDriverList.add(e);
				}
			}

		}
		return innerQueue.take();
	}

	public void returnToPool(WebDriver webDriver) {
		checkRunning();
		innerQueue.add(webDriver);
	}

	protected void checkRunning() {
		if (!stat.compareAndSet(STAT_RUNNING, STAT_RUNNING)) {
			throw new IllegalStateException("Already closed!");
		}
	}

	public void closeAll() {
		boolean b = stat.compareAndSet(STAT_RUNNING, STAT_CLODED);
		if (!b) {
			throw new IllegalStateException("Already closed!");
		}
		for (WebDriver webDriver : webDriverList) {
			logger.info("Quit webDriver" + webDriver);
			webDriver.quit();
			webDriver = null;
		}
	}

}
