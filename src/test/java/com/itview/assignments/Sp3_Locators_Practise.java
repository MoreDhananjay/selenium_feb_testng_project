package com.itview.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sp3_Locators_Practise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url = "https://rahulshettyacademy.com/locatorspractice/";
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		/*driver.get(url);
		//Locator id
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		//locator name;
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		//locator CSS class id selector -  tagname#id
		driver.findElement(By.cssSelector("input#chkboxOne")).click();
		//locator customized css tagname[attribute=value]
		driver.findElement(By.cssSelector("input[name='chkboxTwo']")).click();
		//locator class name
		driver.findElement(By.className("signInBtn")).click();
		//locator XPath -traversing from parent to child //tagenameParent/tagnameChild
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div/p")).getText());
		//locator customized Xpath
		driver.findElement(By.xpath("//button[@class='logout-btn']")).click();
		driver.close();*/
		
		driver.get(url);
		//Locator id
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		
		//locator CSS class id selector -  tagname#id

		//locator linktext
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		//XPath-Multiple elements are matching with tag, Index is used
		driver.findElement(By.xpath("//form/input[1]")).sendKeys("rahul");
		//locator classname
		driver.findElement(By.className("reset-pwd-btn")).click();
		//XPath using regular expression
		System.out.println(driver.findElement(By.xpath("//p[contains(@class,'Msg')]")).getText());
	}

}
