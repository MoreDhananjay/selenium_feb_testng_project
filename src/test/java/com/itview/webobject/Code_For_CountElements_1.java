package com.itview.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Code_For_CountElements_1 {
	WebDriver w;
	@BeforeTest
	public void beforeTest() {
	w =new ChromeDriver();	
	
	
  }
  @Test(priority=0,description="Test case to count web elements")
  public void CountWebElements() throws Exception {
	  w.get("http://demo.automationtesting.in/Register.html");
	  Thread.sleep(2000);
	  //count no of radio buttons on the web page
	  List<WebElement> radioButton = w.findElements(By.name("radiooptions"));
	  System.out.println("No of radio buttons:"+radioButton.size());
	  //count no of checkboxes on the web page
	  List<WebElement> checkBox = w.findElements(By.cssSelector("input[type='checkbox']"));
	  System.out.println("No of check boxes:"+checkBox.size());
	  //count no of drop downs
	  List<WebElement> dropDown = w.findElements(By.tagName("Select"));
	  System.out.println("No of drop downs:"+dropDown.size());
	  //count no of links on the web page
	  List<WebElement> links = w.findElements(By.tagName("a"));
	  System.out.println("No of links:"+links.size());
	  //print value from drop down list
	  WebElement monthDropDown = w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select"));
	  Select sel=new Select(monthDropDown);
	  List<WebElement> monthDropDown_Values = sel.getOptions();
	  for (int i=1;i<monthDropDown_Values.size();i++) {
		  System.out.println(monthDropDown_Values.get(i).getText());
	  }
		  
	  
  }
 

  @AfterTest
  public void afterTest() {
	  w.close();
  }

}
