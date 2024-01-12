package com.itview.webobject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class Code_For_JavaScriptExecutor_P {
	WebDriver w;
	SoftAssert sft;
  @BeforeTest
  public void beforeTest() {
	  
	  w=new EdgeDriver();
	  sft = new SoftAssert();
	  w.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
  }
  
  @Test
  public void f() {
	  w.get("http://www.web-source.net/web_design_tips/alert_message_web_page_load.htm");
	  JavascriptExecutor js=(JavascriptExecutor) w;
	  js.executeScript("Example Alert Message");
	  w.switchTo().alert().accept();
	  w.findElement(By.xpath("/html/body/center/table[2]/tbody/tr[1]/td/a[2]/img")).click();
  }

  @AfterTest
  public void afterTest() {
	  w.close();
  }

}
