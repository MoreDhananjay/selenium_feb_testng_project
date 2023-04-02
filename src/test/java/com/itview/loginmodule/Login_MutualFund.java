package com.itview.loginmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_MutualFund {

	public static void main(String[] args) throws Exception{
		WebDriver w=new ChromeDriver();
		w.get("http://altoromutual.com:8080/login.jsp");
		w.findElement(By.id("uid")).sendKeys("Admin");
		w.findElement(By.id("passw")).sendKeys("Admin");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(3000);
		w.findElement(By.linkText("Sign Off")).click();
		w.close();
		System.out.println("Login to Mutual Fund successfully");
	}

}
