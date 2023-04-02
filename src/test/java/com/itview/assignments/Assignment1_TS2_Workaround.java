package com.itview.assignments;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class Assignment1_TS2_Workaround {
	WebDriver w;
	SoftAssert sft;
  @BeforeTest
  public void beforeTest() {
	  w = new EdgeDriver();
	  sft = new SoftAssert();
	  w.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
  }
  
  @Test(priority=1,description="TC02-verify search home page title and url")
  public void verifyHomePage() {
	  w.get("https://www.zoopla.co.uk/for-sale/property/london/?q=London&search_source=home");
	  //verify page title contains "London"
	  String pageTitle = w.getTitle();
	  System.out.println(pageTitle);
	  sft.assertTrue(pageTitle.contains("London"), "Page Title doesn't have London");
	  
	  //## verify page label should be equals to "Property for sale in London"
	  WebElement pageLabel = w.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[4]/div[2]/section/div[1]/h1"));
	  String pageLabelText = pageLabel.getText();
	  sft.assertEquals(pageLabelText, "Properties for sale in London");
	  
	  w.findElement(By.xpath("//*[@id=\"listing_64207833\"]/div[1]/div/div/div/div[2]/div/a/div")).click();
	  sft.assertAll();
	  
  }

  @AfterTest
  public void afterTest() {
	  //w.close();
  }

}
