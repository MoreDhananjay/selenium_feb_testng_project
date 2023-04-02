package com.itview.webobject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Code_For_MouseHandle_7 {
	WebDriver w;
	SoftAssert sft;
  @BeforeTest
  public void beforeTest() {
	  //chrome options -temp solution for fixing web driver socket issue
	  ChromeOptions chromeOptions = new ChromeOptions();
	  chromeOptions.addArguments("--remote-allow-origins=*");
	  
	  w = new ChromeDriver(chromeOptions);
	  //w = new EdgeDriver();
	  sft = new SoftAssert();
	  w.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
  }
  
  @Test
  public void Code_For_MouseHandle_Test() {
	  Actions a = new Actions(w);
	  w.get("https://www.ebay.com/");
	  WebElement electronics = w.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
	  a.moveToElement(electronics).build().perform();
	  w.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[1]/a")).click();
	  
	  //Right click
	  WebElement AppleCellPhoneSmartPhones = w.findElement(By.xpath("//*[@id=\"s0-16-12_2-0-1[0]-0-0\"]/ul/li[2]/a"));
	  a.moveToElement(AppleCellPhoneSmartPhones).contextClick().build().perform();
	  
	  //Drag and Drop
	  w.get("http://crossbrowsertesting.github.io/drag-and-drop.html");
	  WebElement draggable = w.findElement(By.id("draggable"));
	  WebElement droppable = w.findElement(By.id("droppable"));
	  Actions drapDrop = new Actions(w);
	  drapDrop.dragAndDrop(draggable, droppable).build().perform();
  }

  @AfterTest
  public void afterTest() {
	  w.quit();
  }

}
