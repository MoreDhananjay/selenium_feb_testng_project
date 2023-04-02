package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HardAssertCode_P {
	WebDriver w;
  @BeforeTest
  public void preCondition() {
	  w =new ChromeDriver();
  }

  @Test(priority=0, description="Test login functionality")
  public void loginTest() {
	 w.get("http://altoromutual.com:8080/login.jsp"); 
	 //1. verify page title
	 String pageTitle = w.getTitle();
	 Assert.assertEquals(pageTitle, "Altoro Mutual");
	 
	 //2. verify web url
	 String pageUrl = w.getCurrentUrl();
	 Assert.assertEquals(pageUrl, "http://altoromutual.com:8080/login.jsp");
	 
	 //3. verify home page should contain Admin
	 WebElement homePageLabel = w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
	 String homePageLabelText = homePageLabel.getText();
	 Assert.assertTrue(homePageLabelText.contains("Login"), "Home page label doesn't contains 'Login'");
	 w.findElement(By.id("uid")).sendKeys("Admin");
	 w.findElement(By.id("passw")).sendKeys("Admin");
	 w.findElement(By.name("btnSubmit")).click();
	 w.findElement(By.linkText("Sign Off"));
  }
  
  @AfterTest
  public void postCondition() {
	  w.close();
  }

}
