package com.itview.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCardEMI_PageObject extends TestBase{
	@FindBy (id="debtpayoff")
	public WebElement debtpayoff_textbox;
	@FindBy (id="payment_plan_every_month")
	public WebElement payment_plan_every_month_textbox;
	@FindBy (id="monthly_interest")
	public WebElement monthly_interest_textbox;
	@FindBy (xpath="/html/body/div[13]/section[1]/div/div/div[1]/div/div/div[2]/div[1]/div/div[3]/a[1]")
	public WebElement submit_btn;
	@FindBy (id="total_payment")
	public WebElement total_payment_output;
	
	@FindBy(id="wzrk-cancel")
	public WebElement noThanks_window;
	
	public void callPageFactoryElement() {
		PageFactory.initElements(w, this);
	}
	
	

}
