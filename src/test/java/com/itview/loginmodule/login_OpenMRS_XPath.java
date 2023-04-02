package com.itview.loginmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login_OpenMRS_XPath {
	public static void main(String[] args) throws Exception {
		WebDriver w=new ChromeDriver();
		w.get("https://demo.openmrs.org/openmrs/login.htm");
		w.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Admin");
		w.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Admin123");
		w.findElement(By.xpath("//*[@id=\"Inpatient Ward\"]")).click();
		w.findElement(By.xpath("//*[@id=\"loginButton\"]")).click();
		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a"));
		w.close();
		System.out.println("TC Execution successful");
		
	}
}
