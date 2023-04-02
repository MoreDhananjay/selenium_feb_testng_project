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

public class Assignment2 {
	WebDriver w;
	SoftAssert sft;
  @BeforeTest
  public void beforeTest() {
	  w = new EdgeDriver();
	  sft = new SoftAssert();
	  w.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
  }
  
  @Test(priority=0, description="Verify functionalities of Blazedemo")
  public void verifyBlazeDemo() {
	  w.get("https://blazedemo.com/");
	  //Validate page title should be "BlazeDemo"
	  String pageTitle = w.getTitle();
	  sft.assertEquals(pageTitle, "BlazeDemo");
	  
	  WebElement departureCity = w.findElement(By.xpath("/html/body/div[3]/form/select[1]"));
	  Select departureCityDropDown = new Select(departureCity);
	  departureCityDropDown.selectByVisibleText("Boston");
	  	  
	  WebElement destinationCity = w.findElement(By.xpath("/html/body/div[3]/form/select[2]"));
	  Select destinationCityDropDown = new Select(destinationCity);
	  destinationCityDropDown.selectByVisibleText("London");
	  w.findElement(By.cssSelector("input[type='submit']")).click();
	  
	  //Validate page label "Flights from Boston to London:"
	  
	  WebElement homePageLabel = w.findElement(By.xpath("/html/body/div[2]/h3"));
	  String homePageLabelText = homePageLabel.getText();
	  sft.assertEquals(homePageLabelText, "Flights from Boston to London:");
	  w.findElement(By.cssSelector("input[type='submit']")).click();
	  //Validate page title: "BlazeDemo Purchase"
	  String homePageTitle = w.getTitle();
	  System.out.println(homePageTitle);
	  sft.assertEquals(homePageTitle, "BlazeDemo Purchase");
	  
	  //Validate Page label: "Your flight from TLV to SFO has been reserved."
	  WebElement flightPageLabel = w.findElement(By.xpath("/html/body/div[2]/h2"));
	  String flightPageLabelText = flightPageLabel.getText();
	  System.out.println(flightPageLabelText);
	  sft.assertEquals(flightPageLabelText, "Your flight from TLV to SFO has been reserved.");
	  
	  w.findElement(By.id("inputName")).sendKeys("Jones Pence");
	  w.findElement(By.id("address")).sendKeys("Observatory Circle, U.S");
	  w.findElement(By.id("city")).sendKeys("Phoenix");
	  w.findElement(By.id("state")).sendKeys("Arizona (AZ");
	  w.findElement(By.id("zipCode")).sendKeys("85001");
	  WebElement cardType = w.findElement(By.id("cardType"));
	  Select CardTypeDD = new Select(cardType);
	  CardTypeDD.selectByVisibleText("American Express");
	  w.findElement(By.id("creditCardNumber")).sendKeys("12345678");
	  w.findElement(By.id("creditCardMonth")).sendKeys("12");
	  w.findElement(By.id("creditCardYear")).sendKeys("2018");
	  w.findElement(By.id("nameOnCard")).sendKeys("Jones Pence");
	  w.findElement(By.id("rememberMe")).click();
	  w.findElement(By.cssSelector("input[type='submit']")).click();
	  
	  //Validate page title as "BlazeDemo Confirmation"
	  String cPageTitle = w.getTitle();
	  sft.assertEquals(cPageTitle, "BlazeDemo Confirmation");
	  
	  
	  sft.assertAll();
  }

  @AfterTest
  public void afterTest() {
	  w.close();
  }

}
