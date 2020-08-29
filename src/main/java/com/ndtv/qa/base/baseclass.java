package com.ndtv.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.ndtv.qa.testutil.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	
	 public baseclass() {
			
		    prop = new Properties();
			FileInputStream ip;
			try {
				ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/ndtv/qa/config/config.property");
				prop.load(ip);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
	
	 @SuppressWarnings("deprecation")
	public void initlization() throws InterruptedException {
			String browserName = prop.getProperty("browser");
			
			// options.addArguments("window-size=1400,800");
		//	 options.addArguments("headless");
			
			if (browserName.equals("ch")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				}
			else if ((browserName.equals("ff"))){
				WebDriverManager.firefoxdriver().setup();
			
				 driver = new FirefoxDriver();
			}
			else if ((browserName.equals("phantom"))){
				WebDriverManager.phantomjs().setup();
				 driver = new FirefoxDriver();
			}
			else {
				WebDriverManager.iedriver().setup();
				 driver = new InternetExplorerDriver();
			}
	
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait_timeout, TimeUnit.SECONDS);
			
	
	
	

}}
