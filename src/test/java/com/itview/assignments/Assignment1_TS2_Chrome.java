package com.itview.assignments;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Assignment1_TS2_Chrome {
	WebDriver w;
	SoftAssert sft;
  @BeforeTest
  public void beforeTest() {
	  
	  w = new ChromeDriver();
	  sft = new SoftAssert();
	  w.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	  
  }
  @Test(priority=0,description="TC01-verify home page title, url and search button ")
  public void verifyHomepage() {
	  w.get("https://www.zoopla.co.uk/");
	  String pageTitle = w.getTitle();
	  sft.assertTrue(pageTitle.contains("Zoopla"), "Page title doesn't contain Zoopla");
	  String pageURL = w.getCurrentUrl();
	  sft.assertEquals(pageURL, "https://www.zoopla.co.uk/");
	  WebElement searchButton = w.findElement(By.xpath("//*[@id=\"radix-4-content-for-sale\"]/div/form/div/div[2]/button/div/div[2]"));
	  sft.assertTrue(searchButton.isDisplayed(), "Search button is not displayed");
	  sft.assertAll();
	  
  }
  @AfterTest
  public void afterTest() {
	  w.close();
	  
  }

}
