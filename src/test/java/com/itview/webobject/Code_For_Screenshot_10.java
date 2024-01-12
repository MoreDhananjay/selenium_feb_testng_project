package com.itview.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class Code_For_Screenshot_10 {
	WebDriver w;
  @BeforeTest
  public void beforeTest() {
	  w = new EdgeDriver();
	  w.manage().window().maximize();
	  
  }
  
  @Test
  public void codeForScreenshot () throws Exception {
	  String projectPath = System.getProperty("user.dir");
	  System.out.println(projectPath);
	  String screenshotPath = projectPath+"\\Screenshot\\SeleniumPage.png";
	  w.get("https://www.selenium.dev/");
	  TakesScreenshot ts=(TakesScreenshot) w;
	  File f =ts.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(f, new File(screenshotPath));
	  Thread.sleep(2000);
	  
  }

  @AfterTest
  public void afterTest() {
	  w.close();
  }

}
