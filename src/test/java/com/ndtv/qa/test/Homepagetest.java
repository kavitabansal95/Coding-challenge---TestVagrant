package com.ndtv.qa.test;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ndtv.qa.base.baseclass;
import com.ndtv.qa.pages.HomePage;
import com.ndtv.qa.pages.weatherpage;


public class Homepagetest extends baseclass {
	
	HomePage homepage;
	weatherpage weatherpage;
	WeatherTest WeatherTest;
	
	public Homepagetest() {
		super();
		}

	//BeforeClass Mthods
	
	@BeforeTest
	public void setup() throws InterruptedException {
		initlization(); 
		homepage = new HomePage();
		weatherpage = new weatherpage();
		WeatherTest = new WeatherTest();
		
		}
	@AfterTest
	public void teardown()  {
		driver.quit(); 
	    }
	
	
	
	@Test(priority=1)
	public void submenuDott() {
		homepage.avoidnotification().click();
		homepage.submenuDots().click();
		Assert.assertTrue(homepage.Weather().isDisplayed());
		}
	
	@Test(dependsOnMethods="submenuDott")
	public void WeatherTab() {
		weatherpage=homepage.WeatherTab();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
