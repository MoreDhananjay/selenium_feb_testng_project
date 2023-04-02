package com.itview.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarHomeEMI_PageObject extends TestBase {
	@FindBy (id="carhome_loan")
	public WebElement carhome_loan_textbox;
	
	@FindBy (id= "loan_period")
	public WebElement loan_period_textbox;
	
	@FindBy (id="emi_start_from")
	public WebElement emi_start_from_dropdown;
	
	@FindBy (id="interest_rate")
	public WebElement interest_rate_textbox;
	
	@FindBy (id="upfront_charges")
	public WebElement upfront_charges_textbox;
	
	
	@FindBy (xpath="/html/body/div[13]/section[1]/div/div/div[1]/div[1]/div/div[2]/div/div[5]/a[1]")
	
	public WebElement submit_btn;
	
	@FindBy (id="emi")
	public WebElement emi_Output;
	
	@FindBy(id="wzrk-cancel")
	public WebElement noThanks_window;
	
	public void callPageFactoryElement() {
		PageFactory.initElements(w, this);
	}
	

}
