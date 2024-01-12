package com.itview.assignments;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sp3_Udemy_Locators_Siblings_ChildToChildTraverse {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//finding element besides another element, hit login button besides pracise button
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:MM:SS");
		Date d=new Date();
		System.out.println(sdf.format(d));
		
		System.out.println("Provide a input num to calculate factorial of number");
		Scanner sc= new Scanner(System.in);
		int num = sc.nextInt();
		int facto=1;
		for (int i=num;i>0;i--) 
		{
			facto=facto*i;
		}
		System.out.println("factorial of given nun is:"+facto);
		System.out.println("check whether string is palindrome or not");
		boolean flag=true;
		String s="kayak";
		s=s.toLowerCase();
		for (int i=0;i<s.length()/2;i++) 
		{
			if(s.charAt(i) != s.charAt(s.length()-i-1)) 
			{
				flag=false;
				System.out.println("Given string is not a palindrome");
				break;
			}
			
			
		}
		System.out.println("Given string is a palindrome");
		
		System.out.println("---Printing unique words---");
		String inpString ="This is a This is a unique word word";
		String[] words = inpString.split(" ");
		HashSet<String> uniqueWords = new HashSet<String>(Arrays.asList(words));
		for(String s:uniqueWords) 
		{
			System.out.println(s);
		}
		*/
		
		System.out.println("--get today's date and save into text file--");
		String fPath = "E:\\Automation\\Java\\ITView_Class\\Training\\15Jan2023\\MyIno.txt";
		FileWriter fw= new FileWriter(fPath);
		SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
		Date d=new Date();
		System.out.println(sdf.format(d));
		fw.write(sdf.format(d));
		fw.write(System.getProperty("line.separator"));
		SimpleDateFormat sdf2= new SimpleDateFormat("MMM dd,YYYY");
		System.out.println(sdf2.format(d));
		fw.write(sdf2.format(d));
		fw.close();
		
		FileReader fr=new FileReader(fPath);
		int i;
		while((i=fr.read()) != -1) 
		{
			System.out.print((char) i);
		}
		
		
		
	}

}
