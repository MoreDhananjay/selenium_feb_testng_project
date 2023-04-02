package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CrossBrowserCode {
  WebDriver w;
  
  @Test(priority=0,description="login using chrome")
  public void chromeBrowser() throws Exception {
	  w = new ChromeDriver();
	  w.get("https://www.google.com/");
	  Thread.sleep(2000);
	  
	  String pageTitle = w.getTitle();
	  Assert.assertEquals(pageTitle, "Google");
	  w.close();	
  }
  
  @Test(priority=1,description="login using Edge")
  public void edgeBrowser() throws Exception {
	  w = new EdgeDriver();
	  w.get("https://www.google.com/");
	  Thread.sleep(2000);
	  
	  String pageTitle = w.getTitle();
	  Assert.assertEquals(pageTitle, "Google");
	  w.close();	
  }
  
}
