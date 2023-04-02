package com.itview.testcases;

import org.testng.annotations.Test;

import com.itview.pageobject.FixedDeposit_PageObject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DataDriven_FD_DataProvider {
	
	FixedDeposit_PageObject pageObjectFD=new FixedDeposit_PageObject(); 

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
		new Object[] { "100000", "9" , "5" ,"Simple Interest" }, 
		new Object[] { "300000", "6.5" , "8" ,"Simple Interest" }, 
		new Object[] { "600000", "7" , "2" ,"Simple Interest" }, 
    };
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  pageObjectFD.openBrowser(pageObjectFD.readDataFromPropertiesFile("browser"));
	  pageObjectFD.openApplication(pageObjectFD.readDataFromPropertiesFile("fixedDeposit"));
	  pageObjectFD.callPageFactoryElement();
	  pageObjectFD.handleClickEvent(pageObjectFD.noThanks_window);
  }
  
  @Test(dataProvider = "dp")
  public void f(String principle, String roi, String period, String frequencyValue ) throws Exception {
	  	pageObjectFD.windowScrollDown();		
		pageObjectFD.handleInputEvent(pageObjectFD.principal_textbox, principle);
		//w.findElement(By.id("principal")).clear();
		//w.findElement(By.id("principal")).sendKeys(principle);
				
		pageObjectFD.handleInputEvent(pageObjectFD.interest_textbox, roi);

		//w.findElement(By.name("interest")).clear();
		//w.findElement(By.id("interest")).sendKeys(roi);
				
		pageObjectFD.handleInputEvent(pageObjectFD.tenure_textbox, period);
		//w.findElement(By.id("tenure")).clear();
		//w.findElement(By.id("tenure")).sendKeys(period);
		
		pageObjectFD.handleDropDownEvent(pageObjectFD.tenurePeriod_dropdown, "year(s)");

		//WebElement tenurePeriod = w.findElement(By.id("tenurePeriod"));
		//Select sel_tenurePeriod = new Select(tenurePeriod);
		//sel_tenurePeriod.selectByVisibleText("year(s)");

		Thread.sleep(2000);
		
		pageObjectFD.handleDropDownEvent(pageObjectFD.frequency_dropdown, frequencyValue);
		//WebElement frequency = w.findElement(By.id("frequency"));
		//Select sel_frequency = new Select(frequency);
		//sel_frequency.selectByVisibleText(frequencyValue);
		
		pageObjectFD.handleClickEvent(pageObjectFD.submit_btn);
		//w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();

		Thread.sleep(2000);
		
		String maturityValueUI =pageObjectFD.maturity_Output.getText();

		//String maturityValueUI = w.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();

		System.out.println("Principle Amount " + principle + " | Maturity Value is : "
			+ maturityValueUI);
  }

  @AfterTest
  public void afterTest() {
		pageObjectFD.closeBrowser();
  }

}
