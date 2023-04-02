package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SoftAssertCode_P1 {
	WebDriver w;
	SoftAssert sft;
  @BeforeTest
  public void preCondition() {
	  w =new ChromeDriver();
  }
  
  @Test (priority=0, description="Test login functionality")
  public void testLogin() {
	  sft =new SoftAssert();
	  w.get("http://altoromutual.com:8080/login.jsp");
	  //1. verify page title should be "Altoro Login"
	  String pageTitle = w.getTitle();
	  sft.assertEquals(pageTitle, "Altoro Mutual");
	  
	  //2. verify web url
	  String pageUrl = w.getCurrentUrl();
	  sft.assertEquals(pageUrl, "http://altoromutual.com:8080/login.jsp");
	  
	  //3. verify login page should contain 'Login'
	  WebElement loginPageLabel = w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
	  String loginPageLabelText = loginPageLabel.getText();
	  sft.assertTrue(loginPageLabelText.contains("Login"), "home page doesn't contain 'Login'");
	  w.findElement(By.id("uid")).sendKeys("Admin");
	  w.findElement(By.id("passw")).sendKeys("Admin");
	  w.findElement(By.name("btnSubmit")).click();
	  sft.assertAll();
  }
  
  @Test (priority=1, description="Test logout functionality")
  public void testLogout() throws Exception {
	  sft =new SoftAssert();
	  
	  //home page label should contain Admin
	  WebElement homePageLabel = w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
	  String homePageLabelText = homePageLabel.getText();
	  sft.assertTrue(homePageLabelText.contains("Admin"), "home page doesn't contain 'Admin'");
	  
	 	  
	  WebElement signOffLink = w.findElement(By.linkText("Sign Off"));
	  sft.assertTrue(signOffLink.isDisplayed(), "home page doesn't have Sign Off link");
	  
	  Thread.sleep(2000);
	  
	  signOffLink.click();
	  sft.assertAll();
	  
  }
  
  
  

  @AfterTest
  public void postCondition() {
	  w.close();
  }

}
