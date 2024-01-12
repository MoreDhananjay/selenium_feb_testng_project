package com.itview.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sp1_Udemy_Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");		
		WebDriver driver = new ChromeDriver();
		//providing implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//id locator
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		//name locator
		driver.findElement(By.name("inputPassword")).sendKeys("test");
		//class name locator
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		//linkText locator
		driver.findElement(By.linkText("Forgot your password?")).click();
		//XPath locator
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("rahul");
		//Customized CSS locator
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("test@abc.com");
		//Xpath with index - last option when we don't have unique attributes 
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		//CSS with index  - last option when we don't have unique attributes
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("dhananjay1.more@gmail.com");
		//Customized XPath with tage names- Parent Child
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("12345");
		//CSS with class name
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		//CSS with Parent Child traverse
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		//XPath -parent child traverse
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(2000);
		//CSS using ID locator
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("rahul");
		//CSS using regular expression
		driver.findElement(By.cssSelector("input[placeholder*='Pass']")).sendKeys("rahulshettyacademy");
		//checkbox
		driver.findElement(By.id("chkboxOne")).click();
		//XPath using regular expression
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

		
		
		
	}

}
