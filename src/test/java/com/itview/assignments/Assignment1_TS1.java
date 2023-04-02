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

public class Assignment1_TS1 {
	WebDriver w;
	SoftAssert sft;
  @BeforeTest
  public void beforeTest() {
	  w = new ChromeDriver();
	  w.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
  }
  @Test(priority=0, description="TC01-Verify Home Page Label and Title")
  public void verifyHomePage() {
	  sft = new SoftAssert();
	  w.get("https://www.policyx.com/");
	  
	 //Verify Label on page is equal to "India's Most Trusted Insurance Portal"
	 WebElement pageLabel= w.findElement(By.xpath("//*[@id=\"page1\"]/section[1]/div/div/div[2]/div[1]/h1"));
	 String pageLabelText = pageLabel.getText();
	 System.out.println("Page label text is:"+pageLabelText);
	 sft.assertEquals(pageLabelText, "India's Most Trusted Insurance Portal");
	 //Verify page title contains "Insurance" text .
	 
	 String pageTitle = w.getTitle();
	 System.out.println("Page title is:"+pageTitle);
	 sft.assertTrue(pageTitle.contains("Insurance"), "page title doesn't contain 'Insurance");
	 sft.assertAll();
  }
  
  @Test(priority=1, description="TC02-Verify Claim Page label and Title")
  public void verifyClaimPage() {
	  sft = new SoftAssert();
	  w.get("https://www.policyx.com/");
	  
	 //Verify On-clicking "Claim", and verify Page label is “CLAIM ASSISTANCE”
	  w.findElement(By.xpath("//*[@id=\"page1\"]/header/div/div[4]/div[3]/a")).click();
	  WebElement claimPageLabel = w.findElement(By.xpath("//*[@id=\"page1\"]/div[2]/div/div/div[1]/h1"));
	  String claimPageLabelText = claimPageLabel.getText();
	  sft.assertEquals(claimPageLabelText,"CLAIM ASSISTANCE");
	   
	  
	 //Verify page title contains "Claim Process".
	 String claimPageTitle = w.getTitle();
	 sft.assertTrue(claimPageTitle.contains("Claim Process"), "claim page title doesn't have claim process");
	 
	 sft.assertAll();
  }
  @AfterTest
  public void afterTest() {
	  w.close();
  }

}
