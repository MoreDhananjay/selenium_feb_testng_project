package com.itview.assignments;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class Assignment1_TS2 {
	WebDriver w;
	SoftAssert sft;
  @BeforeTest
  public void beforeTest() {
	  w = new EdgeDriver();
	  //w = new ChromeDriver();
	  
	  w.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
  }
  @Test(priority=0,description="TC01-verify home page title, url and search button ")
  public void verifyHomePage() {
	  sft = new SoftAssert();
	  w.get("https://www.zoopla.co.uk/");
	  //verify page title contains "Zoopla" 
	  String pageTitle = w.getTitle();
	  sft.assertTrue(pageTitle.contains("Zoopla"), "pageTitle doesn't have Zoopla");
	  //verify page url should be equals to "https://www.zoopla.co.uk/"
	  String pageURL = w.getCurrentUrl();
	  sft.assertEquals(pageURL, "https://www.zoopla.co.uk/");
	  //verify search button is present on opened page
	  WebElement searchButton = w.findElement(By.xpath("//*[@id=\"radix-4-content-for-sale\"]/div/form/div/div[2]/button/div/div[2]"));
	  sft.assertTrue(searchButton.isDisplayed(), "earch button is not present on opened page");
	  sft.assertAll();
	  
  }
  
  @Test(priority=1,description="TC02-verify search home page title and url",dependsOnMethods="verifyHomePage")
  public void verifySearchHomePage() {
	  sft = new SoftAssert();
	  //w.get("https://www.zoopla.co.uk/");
	  // verify page label should be equals to "Property for sale in London"
	  //w.findElement(By.xpath("//*[@id=\"downshift-35-input\"]")).sendKeys("London");
	  //w.findElement(By.id("downshift-8-input")).sendKeys("London");
	  w.findElement(By.cssSelector("input[aria-autocomplete='list']")).sendKeys("London");
	
	  
	  WebElement searchButton = w.findElement(By.xpath("//*[@id=\"radix-4-content-for-sale\"]/div/form/div/div[2]/button/div/div[2]"));
	  searchButton.click();
	  
	  
	  WebElement searchPageLabel = w.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[4]/div[2]/section/div[1]/h1"));
	  String searchPageLabelText = searchPageLabel.getText();
	  sft.assertEquals(searchPageLabelText, "Search page label doesn't have Property for sale in London");
	  
	  //verify page title contains "London"
	  String searchPageTitle =  w.getTitle();
	  sft.assertTrue(searchPageTitle.contains("London"), "Search page title doesn't contains London");
	  
	  sft.assertAll();
	  
  }
  

  @AfterTest
  public void afterTest() {
	  //w.close();
  }

}
