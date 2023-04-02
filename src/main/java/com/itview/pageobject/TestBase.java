package com.itview.pageobject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestBase {
	WebDriver w;
	String baseUrl = "https://www.moneycontrol.com";
	
	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			w = new ChromeDriver(co);
		} else if (browserName.equalsIgnoreCase("edge")) {
			w = new EdgeDriver();
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			w =new FirefoxDriver();
			
		}
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		w.manage().window().maximize();
			
	}	
	
	public void closeBrowser() {
		w.quit();
	}
	
	public void openApplication(String htmlPage) {
		w.get(baseUrl+htmlPage);
	}
	
	public void handleInputEvent(WebElement we, String value) {
		we.clear();
		we.sendKeys(value);
	}
	
	public void handleClickEvent(WebElement we) {
		we.click();
	}
	
	public void handleDropDownEvent(WebElement we, String value) {
		Select se = new Select(we);
		se.selectByVisibleText(value);
	}
	
	public void handleAlert () {
		try {
			w.switchTo().alert().accept();
		}
		catch (Exception e){}
	}
	
	public void waitForsec(int sec) throws Exception {
		Thread.sleep(sec*3000);
	}
	
	public void windowScrollDown() {
		JavascriptExecutor js=(JavascriptExecutor) w;
		js.executeScript("window.scrollBy(0,400)");
	}
	
	public String readDataFromPropertiesFile(String key) throws Exception {
		String projectPath=System.getProperty("user.dir");
		String configFilePath = projectPath+"\\Config\\config.properties";
		FileInputStream fi = new FileInputStream(configFilePath);
		Properties prop = new Properties();
		prop.load(fi);
		String value = prop.getProperty(key);
		fi.close();
		return value;
	}
	
	
	
}
