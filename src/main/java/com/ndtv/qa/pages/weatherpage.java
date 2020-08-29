package com.ndtv.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ndtv.qa.base.baseclass;

public class weatherpage extends baseclass{
String city= prop.getProperty("city1");

@FindBy(xpath="//input[@id=\"searchBox\"]")
WebElement citysearchbox;

@FindBy(xpath="//div[@class=\"outerContainer\"]")
WebElement cityOnMapValidate;

@FindBy(xpath="//span[@class=\"tempWhiteText\"]")
WebElement tempinfo;

@FindBy(xpath="//div[@class=\"leaflet-popup-content-wrapper\"]")
WebElement extendedWeatherinfo;

@FindBy(xpath="//b[contains(text(),'Humidity')]")
WebElement humiditydetail;






	


	
	
	
	
	
	
	
	
	
public weatherpage(){
	PageFactory.initElements(driver, this);
		}
	
public void searchcity() {
	List<WebElement> citynames = driver.findElements(By.xpath("//div[@id=\"messages\"]/descendant::label"));
	for (int i = 0; i < citynames.size(); i++) {
		if (citynames.get(i).getText().contains(prop.getProperty("city1"))){
			driver.findElement(By.xpath("//div[@id=\"messages\"]/descendant::input[@id='"+ city +"']")).click();
		}}}

public void citysearchbox() {
	citysearchbox.sendKeys(prop.getProperty("city1"));
}

public String pointedcityname() {
	String city1 = null;
	List<WebElement> cityname = driver.findElements(By.xpath("//div[@id=\"map_canvas\"]/descendant::div[@class=\"outerContainer\"]/descendant::div[@class=\"cityText\"]"));
    for (int i = 0; i < cityname.size(); i++) {
		if(cityname.get(i).getText().equalsIgnoreCase(prop.getProperty("city1"))) {
			 city1 = cityname.get(i).getText();
		}}
return city1;
}

public float pointedcityTempCentegrade() {
	float cityTempCentegrade = 0 ;
	List<WebElement> cityTempCen = driver.findElements(By.xpath("//div[@id=\"map_canvas\"]/descendant::div[@class=\"outerContainer\"]/descendant::span[@class=\"tempRedText\"]"));
    for (int i = 0; i < cityTempCen.size(); i++) {
    	String tempNum= cityTempCen.get(i).getText().substring(0, 2);
    	cityTempCentegrade=  Float.parseFloat(tempNum)   ; }
return cityTempCentegrade;}



public float pointedcityTempFaran() {
	float cityTempFaranhite = 0 ;
	List<WebElement> cityTempFaran = driver.findElements(By.xpath("//div[@id=\"map_canvas\"]/descendant::div[@class=\"outerContainer\"]/descendant::span[@class=\"tempWhiteText\"]"));
    for (int i = 0; i < cityTempFaran.size(); i++) {
    	String tempNum= cityTempFaran.get(i).getText().substring(0, 2);
    	cityTempFaranhite = Float.parseFloat(tempNum);
		}
return cityTempFaranhite;
}


public WebElement cityOnMapValidate() {
	
	return cityOnMapValidate;
}


public WebElement extendedweatherinfo() {
	
	return extendedWeatherinfo;}


public void uncheckdefaultcity() {
	List<WebElement> defaultcitychecked = driver.findElements(By.xpath("//div[@id=\"messages\"]/descendant::input[@class=\"defaultChecked\"]"));
    for (int i = 0; i < defaultcitychecked.size(); i++) {
    	defaultcitychecked.get(i).click();
		}}

public void tempinfo(){
	tempinfo.click();}


	
public Float humiddetail() {
	String temph= humiditydetail.getText().substring(10, 12);
	Float Humidity = Float.parseFloat(temph);
	return Humidity;
}	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
