package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginMutualFund {
	WebDriver w;
  @BeforeTest
  public void openBrower() {
	  w = new ChromeDriver();
  }
  
  @Test (priority=0, description="Test Case to verify Admin login functionality", groups = "MutualFund")
  public void loginAdmin() throws Exception {
	  	w.get("http://altoromutual.com:8080/login.jsp");
		w.findElement(By.id("uid")).sendKeys("Admin");
		w.findElement(By.id("passw")).sendKeys("Admin");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(3000);
		w.findElement(By.linkText("Sign Off")).click();
  }
  
  @Test (priority=1, description="Test Case to verify TUser login functionality",dependsOnMethods = "loginAdmin",groups = "MutualFund")
  public void loginTUser() throws Exception {
	  	w.get("http://altoromutual.com:8080/login.jsp");
		w.findElement(By.id("uid")).sendKeys("tuser");
		w.findElement(By.id("passw")).sendKeys("tuser");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(3000);
		w.findElement(By.linkText("Sign Off")).click();
  }
  
  @Test (priority=2, description="Test Case to verify JSmith login functionality.",dependsOnMethods = "loginAdmin",groups = "MutualFund")
  public void loginJSmith() throws Exception {
	  	w.get("http://altoromutual.com:8080/login.jsp");
		w.findElement(By.id("uid")).sendKeys("jsmith");
		w.findElement(By.id("passw")).sendKeys("Demo1234");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(3000);
		w.findElement(By.linkText("Sign Off")).click();
  }

  @AfterTest
  public void closeBrowser() {
	  w.close();
  }

}
