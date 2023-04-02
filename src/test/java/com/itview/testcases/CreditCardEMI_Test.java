package com.itview.testcases;

import org.testng.annotations.Test;

import com.itview.pageobject.CreditCardEMI_PageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CreditCardEMI_Test {
	CreditCardEMI_PageObject creditCardEMI = new CreditCardEMI_PageObject();
  @BeforeTest
  public void beforeTest() throws Exception {
	  creditCardEMI.openBrowser(creditCardEMI.readDataFromPropertiesFile("browser"));
	  creditCardEMI.openApplication(creditCardEMI.readDataFromPropertiesFile("creditCardEMI"));
	  creditCardEMI.callPageFactoryElement();
	  creditCardEMI.handleClickEvent(creditCardEMI.noThanks_window);
  }
  @Test(priority=0, description = "verfiy credit card EMI")
  public void creditCardEMI () throws Exception {
	  creditCardEMI.windowScrollDown();
	  creditCardEMI.handleInputEvent(creditCardEMI.debtpayoff_textbox, "50000");
	  creditCardEMI.handleInputEvent(creditCardEMI.payment_plan_every_month_textbox, "5000");
	  creditCardEMI.handleInputEvent(creditCardEMI.monthly_interest_textbox, "1");
	  creditCardEMI.handleClickEvent(creditCardEMI.submit_btn);
	  creditCardEMI.waitForsec(3);
	  
	  System.out.println("Total paymemt is:"+creditCardEMI.total_payment_output.getText());
	  
  }
  @AfterTest
  public void afterTest() {
	  creditCardEMI.closeBrowser();
  }

}
