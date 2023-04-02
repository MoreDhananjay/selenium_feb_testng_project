package com.itview.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CrossBrowserCode_P1 {
	WebDriver w;
  @Test(priority=0,description="launch google using chrome browser")
  public void chromeBrowser() throws Exception {
	  w=new ChromeDriver();
	  w.get("https://www.google.com/");
	  Thread.sleep(2000);
	  String pageTitle = w.getTitle();
	  Assert.assertEquals(pageTitle, "Google");
	  w.close();
  }
	  
	  @Test(priority=1,description="launch google using edge browser")
	  public void edgeBrowser() throws Exception {
		  w=new EdgeDriver();
		  w.get("https://www.google.com/");
		  Thread.sleep(2000);
		  String pageTitle = w.getTitle();
		  Assert.assertEquals(pageTitle, "Google");
		  w.close();
	  
  }
}
