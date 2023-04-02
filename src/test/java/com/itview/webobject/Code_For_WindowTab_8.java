package com.itview.webobject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class Code_For_WindowTab_8 {
	WebDriver w;
	SoftAssert sft;
  @BeforeTest
  public void beforeTest() {
	  w = new EdgeDriver();
	  sft = new SoftAssert();
	  w.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
  }
  
  @Test
  public void tabFlipkart() {
	  w.get("https://www.flipkart.com/home-kitchen/home-appliances/washing-machines/fully-automatic-front-load~function/pr?sid=j9e%2Cabm%2C8qx&otracker=nmenu_sub_TVs%20%26%20Appliances_0_Fully%20Automatic%20Front%20Load");
	  w.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).click();
	  Set<String> windowIDs = w.getWindowHandles();
	  System.out.println(windowIDs);
	  
	  Object [] window = windowIDs.toArray();
	  System.out.println(window[0]);
	  System.out.println(window[1]);
	  w.switchTo().window(window[0].toString());
	  System.out.println("Tab1 title is:"+w.getTitle());
	  w.switchTo().window(window[1].toString());
	  System.out.println("Tab2 title is:"+w.getTitle());
	  
  }

  @AfterTest
  public void afterTest() {
	  w.quit();
  }

}
