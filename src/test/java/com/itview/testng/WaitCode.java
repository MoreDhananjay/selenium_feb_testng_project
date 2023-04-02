package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class WaitCode {
	WebDriver w;
  @BeforeTest
  public void beforeTest() {
	  w = new ChromeDriver();
	  w.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

  }
  @Test
  public void f() {
	  w.get("https://in.via.com/flight-tickets");
	  //select source location
	  w.findElement(By.id("source")).sendKeys("Mumbai");
	  w.findElement(By.id("ui-id-48")).click();
	  w.findElement(By.id("destination")).sendKeys("Pune");
	  w.findElement(By.id("ui-id-99")).click();
	  w.findElement(By.id("search-flight-btn")).click();
  }
  @AfterTest
  public void afterTest() {
  }

}
