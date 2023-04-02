package com.itview.testcases;

import org.testng.annotations.Test;

import com.itview.pageobject.EducationalLoanEMI_PageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class EducationalLoanEMI_Test {
	EducationalLoanEMI_PageObject EduLoanEMI = new EducationalLoanEMI_PageObject();
	
  @BeforeTest
  public void beforeTest() throws Exception {
	  EduLoanEMI.openBrowser(EduLoanEMI.readDataFromPropertiesFile("browser"));
	  EduLoanEMI.openApplication(EduLoanEMI.readDataFromPropertiesFile("educationEMI"));
	  EduLoanEMI.callPageFactoryElement();
	  EduLoanEMI.handleClickEvent(EduLoanEMI.noThanks_window);
  }
  
  @Test(priority=0, description="verify edu loan EMI")
  public void EduLoanEMI() throws Exception {
	  EduLoanEMI.windowScrollDown();
	  EduLoanEMI.handleInputEvent(EduLoanEMI.educ_loan_textbox, "500000");
	  EduLoanEMI.handleInputEvent(EduLoanEMI.interest_rate_textbox, "9.3");
	  EduLoanEMI.handleInputEvent(EduLoanEMI.loan_period_textbox, "10");
	  EduLoanEMI.handleClickEvent(EduLoanEMI.submit_Btn);
	  
	  EduLoanEMI.waitForsec(3);
	  System.out.println("EMI value for Edu loan is:"+EduLoanEMI.emi_output.getText());
	  
	  
  }

  @AfterTest
  public void afterTest() {
	  EduLoanEMI.closeBrowser();
  }

}
