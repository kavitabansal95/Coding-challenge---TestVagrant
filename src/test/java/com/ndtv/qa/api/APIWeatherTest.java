package com.ndtv.qa.api;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ndtv.qa.base.baseclass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import scala.Int;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class APIWeatherTest extends baseclass {
	public APIWeatherTest(){
		super();
	}
static JsonPath jspath;

public static String weatherApi(){
		RestAssured.baseURI="http://api.openweathermap.org";
	   String cityWeatherpayload= given().log().all().queryParam("q","Bengaluru").queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea")
	   .when().get("/data/2.5/weather")
	   .then().log().all().extract().asString();

	    return cityWeatherpayload;
	}
	
	public static String weatherCityApi(){
		jspath = new JsonPath(weatherApi());
		String city =jspath.getString("city");
		return city;
        }

	public static String weatherTempApi(){
		jspath = new JsonPath(weatherApi());
		
        return (jspath.getString("main.temp"));
        }

	public static Float weatherHumidApi() {
		jspath = new JsonPath(weatherApi());
		
        return (Float.parseFloat(jspath.getString("main.humidity")));
        }

}
	

