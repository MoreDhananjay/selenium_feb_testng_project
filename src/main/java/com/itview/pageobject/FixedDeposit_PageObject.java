package com.itview.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FixedDeposit_PageObject extends TestBase{
	@FindBy (id="principal")
	public WebElement principal_textbox;
	
	@FindBy (id="interest")
	public WebElement interest_textbox;
	
	@FindBy (id="tenure")
	public WebElement tenure_textbox;
	
	@FindBy (id="tenurePeriod")
	public WebElement tenurePeriod_dropdown;
	
	@FindBy (id="frequency")
	public WebElement frequency_dropdown;
	
	@FindBy (xpath="//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")
	public WebElement submit_btn;
	
	
	@FindBy (xpath="//*[@id=\"resp_matval\"]/strong")
	public WebElement maturity_Output;
	
	@FindBy(id="wzrk-cancel")
	public WebElement noThanks_window;
	
	public void callPageFactoryElement() {
		PageFactory.initElements(w, this);
	}
	
	

}
