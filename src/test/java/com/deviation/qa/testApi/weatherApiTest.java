package com.deviation.qa.testApi;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ndtv.qa.api.APIWeatherTest;
import com.ndtv.qa.base.baseclass;
import com.ndtv.qa.pages.HomePage;
import com.ndtv.qa.pages.weatherpage;


public class weatherApiTest extends baseclass {
	
	weatherpage weatherpage ;
	APIWeatherTest APIweathertest;
	
	
	weatherApiTest(){
		super();
	}
	
	@BeforeTest
	public void start() throws InterruptedException{
		initlization();
		weatherpage = new weatherpage();
		APIweathertest = new APIWeatherTest();
		HomePage homepage = new HomePage();
		baseclass baseclass = new baseclass();
		HomePage.avoidnotification().click();
		homepage.submenuDots().click();
		weatherpage=HomePage.WeatherTab();
		weatherpage.uncheckdefaultcity();
		weatherpage.citysearchbox();
		weatherpage.searchcity();
		weatherpage.tempinfo();
	}
	
	@AfterTest()
	public void teardown() {
		driver.quit();
	}
	
	
	
	@Test
	public void compareTemp() {
		float Tempdeviation= Float.parseFloat(APIWeatherTest.weatherTempApi()) - weatherpage.pointedcityTempCentegrade() ;    
		if(Tempdeviation<50) {
			System.out.println(">>>>>>>>>>>>>Test Pass");}
		else {
				System.out.println(">>>>>>>>>>>>>>Test Fail");}
			
		}

	@Test
	public void compareHumidity() {
		
		
		Float humidityDeviation= weatherpage.humiddetail() - APIWeatherTest.weatherHumidApi();
		if(humidityDeviation<10) {
			System.out.println("@@@@@@@@  Test Pass");}
		else {
				System.out.println("@@@@@@@@@ Test Fail");}
			
		}
	}
	
	
	


