package com.ndtv.qa.test;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ndtv.qa.base.baseclass;
import com.ndtv.qa.pages.HomePage;
import com.ndtv.qa.pages.weatherpage;

public class WeatherTest extends baseclass{
	HomePage homepage;
	Homepagetest Homepagetest;
	
	weatherpage weatherpage;
	com.ndtv.qa.api.APIWeatherTest APIWeatherTest;
	
	
	
	public WeatherTest(){
		super();
	}	
	
	
	@BeforeTest
	public void setup() throws InterruptedException{
		initlization();
		homepage = new HomePage();
		weatherpage = new weatherpage();
		Homepagetest = new Homepagetest();
		APIWeatherTest = new com.ndtv.qa.api.APIWeatherTest();
		homepage.avoidnotification().click();
		homepage.submenuDots().click();
		weatherpage=homepage.WeatherTab();
		
		}
	
	@AfterTest
	public void teardown(){
	//	driver.quit();
		}
	
	
	
	@Test(priority=1)
	public void uncheckdefaultcity() {
		weatherpage.uncheckdefaultcity();
	//	Assert.assertEquals(false, weatherpage.cityOnMapValidate().isDisplayed());
	}
	@Test(dependsOnMethods ="uncheckdefaultcity" )
	public void searchcity() {
		weatherpage.citysearchbox();
		weatherpage.searchcity();
		Assert.assertEquals(true, weatherpage.cityOnMapValidate().isDisplayed());
		Assert.assertEquals(weatherpage.cityOnMapValidate().getAttribute("title"), prop.getProperty("city1"));
		
	}
	
	@Test(dependsOnMethods ="searchcity")
	public void weatherinfoOnmap() {
		weatherpage.tempinfo();
		assertEquals(true, weatherpage.extendedweatherinfo().isDisplayed());
		
	}
	

}
