package com.itview.webobject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class Code_For_JavaScriptExecutor_9 {
	WebDriver w;
	SoftAssert sft;
  @BeforeTest
  public void beforeTest() {
	  w = new EdgeDriver();
	  sft = new SoftAssert();
	  w.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
  }
  
  @Test
  public void Code_For_JavaScriptExecutor_Test() {
	  w.get("http://demo.automationtesting.in/Register.html");
	  JavascriptExecutor js= (JavascriptExecutor) w;
	  js.executeScript("alert('Welcome to Register Page ...');");
	  w.switchTo().alert().accept();
	// JavascriptExecutor for input
	  
	  WebElement firstName = w.findElement(By.cssSelector("input[ng-model='FirstName']"));
	  WebElement lastName = w.findElement(By.cssSelector("input[ng-model='LastName']"));
	 
  }
  
  @AfterTest
  public void afterTest() {
	  w.quit();
  }

}
