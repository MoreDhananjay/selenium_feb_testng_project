package com.itview.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Code_For_Window_Size_5 {
	WebDriver w;
  @BeforeTest
  public void beforeTest() {
	  w = new ChromeDriver();
  }
  @Test
  public void codeWindowSize() throws Exception {
	  w.get("https://www.google.co.in/");
	  Thread.sleep(2000);
	 // w.manage().window().fullscreen();
	  w.manage().window().maximize();
	  Thread.sleep(2000);
  }
  @AfterTest
  public void afterTest() {
	  w.close();
  }

}
