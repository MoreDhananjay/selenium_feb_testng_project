package com.itview.assignments;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Assignment1_TS3 {
	WebDriver w;
	SoftAssert sft;
  @BeforeTest
  public void beforeTest() {
	  w = new EdgeDriver();
	  sft = new SoftAssert();
	  w.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	  
  }
  
  @Test(priority=0,description="TC01-Verify Demo Hospital login page")
  public void loginPage() {
	  w.get("http://hospitalnew.bdtask.com/demo6/login");
	  //validate label as "Demo Hospital Limited"
	  WebElement loginPageLabel = w.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[2]/h3"));
	  String loginPageLabelText = loginPageLabel.getText();
	  sft.assertEquals(loginPageLabelText, "Demo Hospital Limited");
	  
	  w.findElement(By.id("email")).sendKeys("admin@demo.com");
	  w.findElement(By.id("password")).sendKeys("12345");
	  
	  WebElement userRole = w.findElement(By.id("user_role"));
	  Select sel = new Select(userRole);
	  sel.selectByVisibleText("Admin");
	  w.findElement(By.cssSelector("button[type='submit']")).click();
	  
	  sft.assertAll();
	  
  }
  
  @Test(priority=1,description="TC02-Verify Demo Hospital home page",dependsOnMethods="loginPage")
  public void homePage() {
	  //validate label as "Dashboard"
	  WebElement homePageLabel = w.findElement(By.xpath("/html/body/div[3]/div/section/div/div[2]/h1"));
	  String homePageLabelText = homePageLabel.getText();
	  sft.assertEquals(homePageLabelText, "Dashboard");
	  //validate title as "Dashboard - Home"
	  String homePageTitle = w.getTitle();
	  sft.assertEquals(homePageTitle, "Dashboard - Home");
	  //validate user profile as "Admin"
	  WebElement userProfile = w.findElement(By.xpath("/html/body/div[3]/aside/div/div/div[2]/a"));
	  String userProfileText =userProfile.getText();
	  sft.assertEquals(userProfileText, "Admin");
	  
	  //Signout operations
	  w.findElement(By.xpath("/html/body/div[3]/header/nav/div/ul/li/a/i")).click();
	  w.findElement(By.xpath("/html/body/div[3]/header/nav/div/ul/li/ul/li[3]/a")).click();
	  
	  //WebElement signOffDropDown = w.findElement(By.xpath("/html/body/div[3]/header/nav/div/ul/li/a/i"));
	  //Select sel=new Select(signOffDropDown);
	  //sel.selectByVisibleText("Log Out");
	  sft.assertAll();
	  
  }

  @AfterTest
  public void afterTest() {
	  w.close();
  }

}
