package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SoftAssertCode_P2 {
	WebDriver w;
	SoftAssert sft;
	
  @BeforeTest
  public void preCondition() {
	  w =new ChromeDriver();
	  sft =new SoftAssert();
	  
  }

  
  @Test(priority=0,description="Test login Funcationality")
  public void testLogin() {
	  
	  w.get("http://altoromutual.com:8080/login.jsp");
	  //1. verify Title should be Altoro Mutual
	  String pageTitle = w.getTitle();
	  sft.assertEquals(pageTitle, "Altoro Mutual");
	  //2. verify webURL
	  String webURL = w.getCurrentUrl();
	  sft.assertEquals(webURL, "http://altoromutual.com:8080/login.jsp");
	  //3. verify login page should contain 'Login'
	  WebElement loginPageLabel = w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
	  String loginPageLabelText = loginPageLabel.getText();
	  sft.assertTrue(loginPageLabelText.contains("Login"), "Login page label doesn't contain Login");
	  w.findElement(By.id("uid")).sendKeys("Admin");
	  w.findElement(By.id("passw")).sendKeys("Admin");
	  w.findElement(By.name("btnSubmit")).click();
	  sft.assertAll();
  }
  
  
  @Test(priority=1,description="Test logout Funcationality")
  public void testLogout() throws Exception {
	  
	  //home page label should contain 'Admin'
	  WebElement homePagelabel = w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
	  String homePageLabelText = homePagelabel.getText();
	  sft.assertTrue(homePageLabelText.contains("Admin"), "Home page doesn't have Admin");
	  //verify Sign Off link is present 
	  WebElement signOffLink = w.findElement(By.linkText("Sign Off"));
	  sft.assertTrue(signOffLink.isDisplayed(), "Sign off link is not present");
	  Thread.sleep(2000);
	  signOffLink.click();
	  sft.assertAll();
  }
  
  
  @AfterTest
  public void postCondition() {
	  w.close();
  }

}
