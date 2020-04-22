
package com.cl.borrower_web.steps;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.borrower_web.pages.BorrowerPortalVerifyPage;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

import cucumber.api.java.en.Then;

public class BorrowerPortalMyLoanSteps extends ObjectBase {

	BorrowerPortalVerifyPage borrowerPortalVerifyPage = new BorrowerPortalVerifyPage();




	@Then("Verify navigational options should be displayed to the top right")
	public void verify_navigational_options_should_be_displayed_to_the_top_right() {

		try {
			waits.waitForPageReadyState();
			webActions.clickElement(borrowerPortalVerifyPage.commonFormTab);
			waits.waitForPageReadyState();
			webActions.clickElement(borrowerPortalVerifyPage.commonQuestionsTab);
			waits.waitForPageReadyState();
			webActions.clickElement(borrowerPortalVerifyPage.myLoanTab);
			reportPass("Verified navigation options");
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to Click navigation options", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to Click navigation options");
		}

	}

	@Then("Property Address and Loan Information verify")
	public void property_Address_and_Loan_Information_verify() {
		try {
			if (webActions.getText(borrowerPortalVerifyPage.propertyAddress)
					.equalsIgnoreCase(jsonDataParser.getTestDataMap().get("PropertyAddress")) && 
					webActions.getText(borrowerPortalVerifyPage.loanInformation)
					.equalsIgnoreCase(jsonDataParser.getTestDataMap().get("loanInformation"))) {
				reportPass("Verified PropertyAddress text and loanInformation text");
			} else {
				reportHardFail("Unable PropertyAddress text and loanInformation text");
			}
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to verify PropertyAddress text and loanInformation text", e, LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify PropertyAddress text and loanInformation text");

		}
	}



	@Then("Verify recent transactions details")
	public void verify_recent_transactions_details() {
		try {
			
			webActions.clickElement(borrowerPortalVerifyPage.ViewAllTransactionsLink);
			waits.waitForPageReadyState();
			waits.staticWait(2000);
			reportPass("Clicked on View All Transactions Link");
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to Click on View All Transactions Link", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to Click on View All Transactions Link");
		}
	}




	@Then("Verify user landing page displays header as My Loan")
	public void verify_user_landing_page_displays_header_as_My_Loan() {
		try {
			waits.staticWait(10000);

			if (webActions.getText(borrowerPortalVerifyPage.myLoanText)
					.equalsIgnoreCase(jsonDataParser.getTestDataMap().get("HeaderNameMyLoan"))) {
				reportPass("Verified My Loan text");
			} else {
				reportHardFail("Unable to verify My Loan text");
			}
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to verify Home Page", e, LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify My Loan text");
			reportHardFail("Unable to verify Home Page");
		}
	}

	@Then("Verify loan information Account number")
	public void verify_loan_information_Account_number() {
		try {
			waits.staticWait(2000);

			if (webActions.getText(borrowerPortalVerifyPage.accountNumber)
					.contains(jsonDataParser.getTestDataMap().get("MyLoanAccountNumber"))) {
				reportPass("Verified Account Number");
			} else {
				reportHardFail("Unable to verify Account Number");
			}
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to verify Account Number", e, LoggingLevel.ERROR,
					true);
			reportHardFail("Unable to verify Account Number");
		}

	}

	@Then("click on common question menu")
	public void click_on_common_question_menu() {
		try {
			waits.staticWait(2000);
			webActions.clickElement(borrowerPortalVerifyPage.commonQuestionsTab);
			reportPass("Clicked on common question tab");
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to Click on common question tab", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to Click on common question tab");
		}
	}

	@Then("verify page header common questions title")
	public void verify_page_header_common_questions_title() {
		try {
			waits.staticWait(2000);

			if (webActions.getText(borrowerPortalVerifyPage.commonQuestionsText)
					.contains(jsonDataParser.getTestDataMap().get("CommonQuestionPageHeader"))) {
				reportPass("Verified Common Questions text");
			} else {
				reportHardFail("Unable to verify Common Questions text");
			}
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to Common Questions text", e, LoggingLevel.ERROR,
					true);
			reportHardFail("Unable to verify Common Questions text");
		}
	}

	@Then("click on Loan Details Tab")
	public void click_on_Loan_Details_Tab() {
		try {
			waits.staticWait(2000);
			webActions.clickElement(borrowerPortalVerifyPage.loanDetailsTab);
			waits.waitForPageReadyState();
			reportPass("Clicked on Loan Details tab");
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to Click on Loan Details tab", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to Click on Loan Details tab");
		}

	}




	@Then("click on Monthly Statement Tab")
	public void click_on_Monthly_Statement_Tab() {
		try {
			waits.staticWait(2000);
			webActions.clickElement(borrowerPortalVerifyPage.MonthlyStatementTab);
			waits.waitForPageReadyState();
			reportPass("Clicked on Monthly Statement tab");
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to Click on Monthly Statement tab", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to Click on Monthly Statement tab");
		}


	}

	@Then("click on Transaction History Tab")
	public void click_on_Transaction_History_Tab() {
		try {
			waits.staticWait(2000);
			webActions.clickElement(borrowerPortalVerifyPage.TransactionHistoryTab);
			waits.waitForPageReadyState();
			reportPass("Clicked on Transaction History Tab");
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to Click on Transaction History Tab", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to Click on Transaction History Tab");
		}
	}


	@Then("verify Current Net Principal Limit text")
	public void verify_Current_Net_Principal_Limit_text() {

		try {
			waits.staticWait(2000);

			if (webActions.getText(borrowerPortalVerifyPage.currentNetPrincipalLimitText)
					.contains(jsonDataParser.getTestDataMap().get("CurrentNetPrincipalLimitText"))) {
				reportPass("Verified Current Net Principal Limit text in Loan Details Tab ");
			} else {
				reportHardFail("Unable to verify Current Net Principal Limit text in Loan Details Tab");
			}
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify",
					"Unable to verify Current Net Principal Limit text in Loan Details Tab", e, LoggingLevel.ERROR,
					true);
			reportHardFail("Unable to verify Current Net Principal Limit text in Loan Details Tab");
		}

	}
	
	@Then("verify Property Address details")
	public void verify_Property_Address_details() {
		try {

			if (webActions.getText(borrowerPortalVerifyPage.propertyAddressLineOne)
					.contains(jsonDataParser.getTestDataMap().get("PropertyAddressLine1"))  &&
					webActions.getText(borrowerPortalVerifyPage.propertyAddressLineTwo)
					.contains(jsonDataParser.getTestDataMap().get("PropertyAddressLine2")) 
					) {
				reportPass("Verified propertyAddressLineOne and propertyAddressLineTwo ");
			} else {
				reportHardFail("Unable to verify propertyAddress details");
			}
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify",
					"Unable to verify propertyAddress details", e, LoggingLevel.ERROR,
					true);
			reportHardFail("Unable to verify propertyAddress details");
		}
	}
	
	
	@Then("Verify Loan Information details")
	public void verify_Loan_Information_details() {
		try {
			if (webActions.getText(borrowerPortalVerifyPage.LoanType)
					.contains(jsonDataParser.getTestDataMap().get("MyLoanAccountLoanType"))) {
				reportPass("Verified LoanType");
			} else {
				reportHardFail("Unable to verify LoanType");
			}
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to verify LoanType", e, LoggingLevel.ERROR,
					true);
			reportHardFail("Unable to verify LoanType");
		}
	}
	

	@Then("click on Borrower Details Tab")
	public void click_on_Borrower_Details_Tab() {

		try {
			waits.staticWait(2000);
			webActions.clickElement(borrowerPortalVerifyPage.borrowerDetailsTab);
			waits.waitForPageReadyState();
			reportPass("Clicked on borrower Details tab");
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to Click on borrower Details tab", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to Click on borrower Details tab");
		}

	}

	@Then("verify Name in borrower details")
	public void verify_Name_in_borrower_details() {

		try {
			waits.staticWait(2000);
			String actualBorrower = webActions.getText(borrowerPortalVerifyPage.borrowerDetailsName);

			if (actualBorrower.contains(jsonDataParser.getTestDataMap().get("BorrowerName"))) {
				// reportPass("Verified borrower details name text in borrower Details Tab ");
				reportPass("Expected Borrower Name:" + jsonDataParser.getTestDataMap().get("BorrowerName")
						+ " Actual Borrower" + actualBorrower);
				// Verified borrower details name text in borrower Details Tab ");
			} else {
				reportFail("Expected Borrower Name:" + jsonDataParser.getTestDataMap().get("BorrowerName")
						+ " Actual Borrower" + actualBorrower);
			}
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify",
					"Unable to verify borrower details name text in borrower Details Tab ", e, LoggingLevel.ERROR,
					true);
			reportHardFail("Unable to verify borrower details name text in borrower Details Tab ");
		}
	}

	

@Then("Verify amount displayed for field Current Net Principal Limit")
public void verify_amount_displayed_for_field_Current_Net_Principal_Limit() {
	try {
		waits.staticWait(2000);

		if (webActions.getText(borrowerPortalVerifyPage.currentNetPrincipalLimitValue)
				.contains(jsonDataParser.getTestDataMap().get("CurrentNetPrincipalLimit"))) {
			reportPass("Verified Current Net Principal Limit value in Loan Details Tab ");
		} else {
			reportHardFail("Unable to verify Current Net Principal Limit value in Loan Details Tab");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify Current Net Principal Limit value in Loan Details Tab", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify Current Net Principal Limit value in Loan Details Tab");
	}
}

@Then("Verify amount displayed for field Current Available Line of Credit")
public void verify_amount_displayed_for_field_Current_Available_Line_of_Credit() {
	try {
		waits.staticWait(2000);

		if (webActions.getText(borrowerPortalVerifyPage.CurrentAvailableLineofCreditValue)
				.contains(jsonDataParser.getTestDataMap().get("CurrentAvailableLineofCredit"))) {
			reportPass("Verified Current Available Line of Credit value in Loan Details Tab ");
		} else {
			reportHardFail("Unable to verify Current Available Line of Credit value in Loan Details Tab");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify Current Available Line of Credit value in Loan Details Tab", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify Current Available Line of Credit value in Loan Details Tab");
	}
	
}

@Then("Verify amount displayed for field Current Total Loan Balance")
public void verify_amount_displayed_for_field_Current_Total_Loan_Balance() {
	try {
		waits.staticWait(2000);

		if (webActions.getText(borrowerPortalVerifyPage.CurrentTotalLoanBalanceValue)
				.contains(jsonDataParser.getTestDataMap().get("CurrentTotalLoanBalance"))) {
			reportPass("Verified Current Total Loan Balance value in Loan Details Tab ");
		} else {
			reportHardFail("Unable to verify Current Total Loan Balance value in Loan Details Tab");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify Current Total Loan Balance value in Loan Details Tab", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify Current Total Loan Balance value in Loan Details Tab");
	}
}

@Then("Verify amount displayed for field Interest Rate")
public void verify_amount_displayed_for_field_Interest_Rate() {
	try {
		waits.staticWait(2000);

		if (webActions.getText(borrowerPortalVerifyPage.InterestRateValue)
				.contains(jsonDataParser.getTestDataMap().get("InterestRate"))) {
			reportPass("Verified Interest Rate value in Loan Details Tab ");
		} else {
			reportHardFail("Unable to verify Interest Rate value in Loan Details Tab");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify Interest Rate value in Loan Details Tab", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify Interest Rate value in Loan Details Tab");
	}
}

@Then("Verify amount displayed for field Set Aside Funds")
public void verify_amount_displayed_for_field_Set_Aside_Funds() {
    
	try {
		waits.staticWait(2000);

		if (webActions.getText(borrowerPortalVerifyPage.SetAsideFundsValue)
				.contains(jsonDataParser.getTestDataMap().get("SetAsideFunds"))) {
			reportPass("Verified Set Aside Funds value in Loan Details Tab ");
		} else {
			reportHardFail("Unable to verify Set Aside Funds value in Loan Details Tab");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify Set Aside Funds value in Loan Details Tab", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify Set Aside Funds value in Loan Details Tab");
	}
}

@Then("Verify that two sections are displayed in Borrower details tab")
public void verify_that_two_sections_are_displayed_in_Borrower_details_tab() {
 
	try {
		if (webActions.getText(borrowerPortalVerifyPage.BorDetYourProfile)
				.contains(jsonDataParser.getTestDataMap().get("YourProfile"))  &&
				webActions.getText(borrowerPortalVerifyPage.BorDetOtherBorrowers)
				.contains(jsonDataParser.getTestDataMap().get("OtherBorrowers")) 
				) {
			reportPass("Verified YourProfile and OtherBorrowers ");
		} else {
			reportHardFail("Unable to verify YourProfile and OtherBorrowers ");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify YourProfile and OtherBorrowers ", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify YourProfile and OtherBorrowers  details");
	}
	
	
}

}
