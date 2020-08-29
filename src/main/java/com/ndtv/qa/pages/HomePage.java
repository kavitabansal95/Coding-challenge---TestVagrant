package com.ndtv.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ndtv.qa.base.baseclass;

public class HomePage extends baseclass{
	
@FindBy(xpath="//a[@class=\"notnow\"]")
static WebElement avoidnotification;

@FindBy(xpath="//a[@id=\"h_sub_menu\"]")
WebElement submenuDots;

@FindBy(xpath="//body//div[contains(@class,'neweleccont ntopnav')]/descendant::a[text()='WEATHER']")
static WebElement Weathermenu;



public HomePage(){
	PageFactory.initElements(driver, this);
}

public static WebElement avoidnotification() {
	return avoidnotification;
}

public WebElement submenuDots() {
	return submenuDots;
}

public static weatherpage WeatherTab() {
	Weathermenu.click();
	return new weatherpage() ;
}


public WebElement Weather() {
	// TODO Auto-generated method stub
	return Weathermenu;
}

	
	
	
	
	
	
	
	
}
