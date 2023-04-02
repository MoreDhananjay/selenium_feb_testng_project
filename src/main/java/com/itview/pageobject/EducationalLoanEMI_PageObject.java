package com.itview.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EducationalLoanEMI_PageObject extends TestBase {
	@FindBy (id="educ_loan")
	public WebElement educ_loan_textbox;
	@FindBy (id="interest_rate")
	public WebElement interest_rate_textbox;
	@FindBy (id="loan_period")
	public WebElement loan_period_textbox;
	@FindBy (id="emi_start_from")
	public WebElement emi_start_from_textbox;
	@FindBy (xpath="//*[@id=\"InvestingPlanning\"]/div[2]/div[1]/div[2]/div[4]/a[1]")
	public WebElement submit_Btn;
	
	@FindBy (id="emi")
	public WebElement emi_output;
	
	
	@FindBy(id="wzrk-cancel")
	public WebElement noThanks_window;
	
	public void callPageFactoryElement() {
		PageFactory.initElements(w, this);
	}

}
