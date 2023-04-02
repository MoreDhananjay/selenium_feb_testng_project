package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HardAssertCode {
	WebDriver w;
  @BeforeTest
  public void preCondition() {
	w =new ChromeDriver();
  }
  
  @Test (priority=0,description="Test login functionality")
  public void loginTest() {
	  	w.get("http://altoromutual.com:8080/login.jsp");
	  //1. verify page title should be "Altoro Login"	
	  	String loginPageTitle =w.getTitle();
	  	Assert.assertEquals(loginPageTitle, "Altoro Mutual");
	  	
	  //2. verify page url should be -> http://altoromutual.com:8080/login.jsp
	  	String loginPageURL = w.getCurrentUrl();
	  	Assert.assertEquals(loginPageURL,"http://altoromutual.com:8080/login.jsp");
	  	
	  //3. verify page label should contain "Login"
	  	WebElement loginPageLabel = w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
	  	String loginPageLabelText = loginPageLabel.getText();
	  	Assert.assertTrue(loginPageLabelText.contains("Login"), "Login Page Label doesn't contains 'Login'");
	  	//WebElement loginPageLabel =w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
		//String loginPageLabelText = loginPageLabel.getText();
	  	//Assert.assertTrue(loginPageLabelText.contains("Admin"), "Login Page Label doesn't contains 'Login'");
		w.findElement(By.id("uid")).sendKeys("Admin");
		w.findElement(By.id("passw")).sendKeys("Admin");
		w.findElement(By.name("btnSubmit")).click();
  }

  @AfterTest
  public void postCondition() {
	  w.close();
  }

}
