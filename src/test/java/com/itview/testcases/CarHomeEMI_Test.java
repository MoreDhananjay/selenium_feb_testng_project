package com.itview.testcases;

import org.testng.annotations.Test;

import com.itview.pageobject.CarHomeEMI_PageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CarHomeEMI_Test {
	CarHomeEMI_PageObject carHomeEmi = new CarHomeEMI_PageObject();

  @BeforeTest
  public void beforeTest() throws Exception {
	  carHomeEmi.openBrowser(carHomeEmi.readDataFromPropertiesFile("browser"));
	  carHomeEmi.openApplication(carHomeEmi.readDataFromPropertiesFile("carHomeEMI"));
	  carHomeEmi.callPageFactoryElement();
	  carHomeEmi.handleClickEvent(carHomeEmi.noThanks_window);
	  
  }
  
  @Test(priority = 0,description = "verify Loan amount for 1 lakhs")
  public void oneLakhLoanAmount() throws Exception {
	  carHomeEmi.windowScrollDown();
	  carHomeEmi.handleInputEvent(carHomeEmi.carhome_loan_textbox, "100000");
	  carHomeEmi.handleInputEvent(carHomeEmi.loan_period_textbox, "5");
	  carHomeEmi.handleDropDownEvent(carHomeEmi.emi_start_from_dropdown, "From next month after disbursement");
	  carHomeEmi.handleInputEvent(carHomeEmi.interest_rate_textbox, "9.2");
	  carHomeEmi.handleInputEvent(carHomeEmi.upfront_charges_textbox, "5000");
	  carHomeEmi.handleClickEvent(carHomeEmi.submit_btn);
	  carHomeEmi.waitForsec(3);
	  
	  System.out.println("EMI Value for 1 lakh Loan Amount :"+carHomeEmi.emi_Output.getText());
	  
  }

  @AfterTest
  public void afterTest() {
	  carHomeEmi.closeBrowser();
  }

}
