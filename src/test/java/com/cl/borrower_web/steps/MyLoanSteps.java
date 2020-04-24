
package com.cl.borrower_web.steps;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.borrower_web.pages.BorrowerPortalVerifyPage;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

import cucumber.api.java.en.Then;

public class MyLoanSteps extends ObjectBase {

	BorrowerPortalVerifyPage borrowerPortalVerifyPage = new BorrowerPortalVerifyPage();




	@Then("verify navigational options should be displayed to the top right")
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

	@Then("property address and loan information verify")
	public void property_address_and_loan_information_verify() {
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



	@Then("verify recent transactions details")
	public void verify_recent_transactions_details() {
		try {
			waits.waitForPageReadyState();
			webActions.clickElement(borrowerPortalVerifyPage.ViewAllTransactionsLink);
			reportPass("Clicked on View All Transactions Link");
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to Click on View All Transactions Link", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to Click on View All Transactions Link");
		}
	}




	@Then("verify the landing page displays header as my loan")
	public void verify_the_landing_page_displays_header_as_my_loan() {
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
		}
	}

	@Then("verify loan information account number")
	public void verify_loan_information_account_number() {
		try {
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

	@Then("click on loan details tab")
	public void click_on_loan_details_tab() {
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




	@Then("click on monthly statement tab")
	public void click_on_monthly_statement_tab() {
		try {
			waits.waitForPageReadyState();
			webActions.clickElement(borrowerPortalVerifyPage.MonthlyStatementTab);
			waits.waitForPageReadyState();
			reportPass("Clicked on Monthly Statement tab");
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to Click on Monthly Statement tab", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to Click on Monthly Statement tab");
		}


	}

	@Then("click on transaction history tab")
	public void click_on_transaction_history_tab() {
		try {
			waits.waitForPageReadyState();
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
	
	@Then("verify property address details")
	public void verify_property_address_details() {
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
	
	
	@Then("verify loan information details")
	public void verify_loan_information_details() {
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
	

	@Then("click on borrower details tab")
	public void click_on_borrower_details_tab() {

		try {
			waits.waitForPageReadyState();
			webActions.clickElement(borrowerPortalVerifyPage.borrowerDetailsTab);
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

	

@Then("verify amount displayed for field current net principal limit")
public void verify_amount_displayed_for_field_current_net_principal_limit() {
	waits.waitForPageReadyState();
	try {
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

@Then("verify amount displayed for field current available line of credit")
public void verify_amount_displayed_for_field_current_available_line_of_credit() {
	try {
	waits.waitForPageReadyState();
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

@Then("verify amount displayed for field current total loan balance")
public void verify_amount_displayed_for_field_current_total_loan_balance() {
	try {
		waits.waitForPageReadyState();

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

@Then("verify amount displayed for field interest rate")
public void verify_amount_displayed_for_field_interest_rate() {
	try {
		waits.waitForPageReadyState();

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

@Then("verify amount displayed for field set aside funds")
public void verify_amount_displayed_for_field_set_aside_funds() {
    
	try {
		waits.waitForPageReadyState();

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

@Then("verify that two sections are displayed in borrower details tab")
public void verify_that_two_sections_are_displayed_in_borrower_details_tab() {
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

@Then("verify that three sections are displayed in borrower details your profile tab")
public void verify_that_three_sections_are_displayed_in_borrower_details_your_profile_tab() {
	try {
		if (webActions.getText(borrowerPortalVerifyPage.BorDetPersonalDetails)
				.contains(jsonDataParser.getTestDataMap().get("YourProfilePersonalDetails"))  &&
				webActions.getText(borrowerPortalVerifyPage.BorDetContactInformation)
				.contains(jsonDataParser.getTestDataMap().get("YourProfileContactInformation")) &&
				webActions.getText(borrowerPortalVerifyPage.BorDetMailingAddress)
				.contains(jsonDataParser.getTestDataMap().get("YourProfileMailingAddress"))
				) {
			reportPass("Verified YourProfile details ");
		} else {
			reportHardFail("Unable to verify YourProfile details ");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify YourProfile details", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify YourProfile  details");
	}	
}


@Then("verify that name and dob are displaying in personal details section")
public void verify_that_name_and_dob_are_displaying_in_personal_details_section() { 
	try {
		waits.staticWait(2000);
		String actualBorrower = webActions.getText(borrowerPortalVerifyPage.borrowerDetailsName);
		String actualBorrowerDob = webActions.getText(borrowerPortalVerifyPage.borrowerDetailsDob);
		if (actualBorrower.contains(jsonDataParser.getTestDataMap().get("BorrowerName")) &&
				actualBorrowerDob.contains(jsonDataParser.getTestDataMap().get("BorrowerDob"))
				) {
			reportPass("Expected Borrower Name:" + jsonDataParser.getTestDataMap().get("BorrowerName")
					+ " Actual Borrower" + actualBorrower );
			reportPass("Expected Borrower Dob:" + jsonDataParser.getTestDataMap().get("BorrowerDob")
					+ " Actual Borrower" + actualBorrowerDob );
		} else {
			reportFail("Expected Borrower Name:" + jsonDataParser.getTestDataMap().get("BorrowerName")
					+ " Actual Borrower" + actualBorrower);
			reportFail("Expected Borrower Dob:" + jsonDataParser.getTestDataMap().get("BorrowerDob")
					+ " Actual Borrower" + actualBorrowerDob );
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify borrower details name and Dob text in borrower Details Tab ", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify borrower details name and Dob text in borrower Details Tab ");
	}
}

@Then("verify that mobileno and emailid are displaying in contact information section")
public void verify_that_mobileno_and_emailid_are_displaying_in_contact_information_section() {
	try {
		waits.waitForPageReadyState();
		String borDetContInfoMobNo = webActions.getText(borrowerPortalVerifyPage.borDetContInfoMobNo);
		String borDetContInfoEmailid = webActions.getText(borrowerPortalVerifyPage.borDetContInfoEmailid);
		if (borDetContInfoMobNo.contains(jsonDataParser.getTestDataMap().get("BorDetMobno")) &&
				borDetContInfoEmailid.contains(jsonDataParser.getTestDataMap().get("BorDetEmailid"))
				) {
			reportPass("Expected Borrower Mobile no:" + jsonDataParser.getTestDataMap().get("BorDetMobno")
					+ " Actual Borrower  Mobile no:" + borDetContInfoMobNo );
			reportPass("Expected Borrower Email id:" + jsonDataParser.getTestDataMap().get("BorDetEmailid")
					+ " Actual Borrower Email id" + borDetContInfoEmailid );
		} else {
			reportFail("Expected Borrower Mobile no:" + jsonDataParser.getTestDataMap().get("BorDetMobno")
					+ " Actual Borrower Mobile no" + borDetContInfoMobNo);
			reportFail("Expected Borrower Email id:" + jsonDataParser.getTestDataMap().get("BorDetEmailid")
					+ " Actual Borrower Email id" + borDetContInfoEmailid );
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify borrower details Mobile no and email id text in borrower Details Tab ", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify borrower details Mobile no and email id text in borrower Details Tab ");
	}
}

@Then("verify that mailingaddlineone and mailingaddlineone are displaying in mailing address section")
public void verify_that_mailingaddlineone_and_mailingaddlineone_are_displaying_in_mailing_address_section() {
   
	try {
		waits.waitForPageReadyState();
		String borDetMailingAddL1 = webActions.getText(borrowerPortalVerifyPage.borDetMailingAddL1);
		String borDetMailingAddL2 = webActions.getText(borrowerPortalVerifyPage.borDetMailingAddL2);
		if (borDetMailingAddL1.contains(jsonDataParser.getTestDataMap().get("BorDetMailingAdrLine1")) &&
				borDetMailingAddL2.contains(jsonDataParser.getTestDataMap().get("BorDetMailingAdrLine2"))
				) {
			reportPass("Expected Borrower Mailing Address Line one:" + jsonDataParser.getTestDataMap().get("BorDetMailingAdrLine1")
					+ " Actual Borrower  Mailing Address Line one:" + borDetMailingAddL1 );
			reportPass("Expected Borrower Mailing Address Line two:" + jsonDataParser.getTestDataMap().get("BorDetMailingAdrLine2")
					+ " Actual Borrower Mailing Address Line two" + borDetMailingAddL2 );
		} else {
			reportFail("Mailing Address Line one:" + jsonDataParser.getTestDataMap().get("BorDetMailingAdrLine1")
					+ " Mailing Address Line one" + borDetMailingAddL1);
			reportFail("Mailing Address Line two:" + jsonDataParser.getTestDataMap().get("BorDetMailingAdrLine2")
					+ " Mailing Address Line two" + borDetMailingAddL2 );
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify borrower details Mailing Address Line one text in borrower Details Tab ", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify borrower details Mailing Address Line one text in borrower Details Tab ");
	}
	
}

@Then("verify personal details name are displaying in personal details section")
public void verify_personal_details_name_are_displaying_in_personal_details_section() {
	try {
		waits.waitForPageReadyState();
		String borDetOthBorPerDetailsName = webActions.getText(borrowerPortalVerifyPage.borDetOthBorPerDetailsName);
		if (
				borDetOthBorPerDetailsName.contains(jsonDataParser.getTestDataMap().get("BorDetPerDteName"))
				) {
			reportPass("Expected Borrower Details Name:" + jsonDataParser.getTestDataMap().get("BorDetPerDteName")
					+ " Borrower Details Name:" + borDetOthBorPerDetailsName );
			
		} else {
			reportFail("Borrower Details Name:" + jsonDataParser.getTestDataMap().get("BorDetPerDteName")
					+ " Borrower Details Name" + borDetOthBorPerDetailsName);
			
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify borrower details Mailing Address Line one text in borrower Details Tab ", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify borrower details Mailing Address Line one text in borrower Details Tab ");
	}
	
	
}

@Then("verify borrower details what is required to change my information above link")
public void verify_borrower_details_what_is_required_to_change_my_information_above_link() {
	try {
		waits.waitForPageReadyState();
		webActions.clickElement(borrowerPortalVerifyPage.borDetChangInfoLink);
		waits.waitForPageReadyState();
		reportPass("Clicked on link");
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify", "Unable to Click on link", e,
				LoggingLevel.ERROR, true);
		reportHardFail("Unable to Click on link");
	}
}

@Then("verify on click mailing address and name changes text")
public void verify_on_click_mailing_address_and_name_changes_text() {
	try {
		waits.waitForPageReadyState();
		String ComnQsnMailingAdrsandNameChagText = webActions.getText(borrowerPortalVerifyPage.ComnQsnMailingAdrsandNameChagText);
		if (
				ComnQsnMailingAdrsandNameChagText.contains(jsonDataParser.getTestDataMap().get("MailingAddressandNameChanges"))
				) {
			reportPass("Expected text is:" + jsonDataParser.getTestDataMap().get("MailingAddressandNameChanges")
					+ " Actual text is" + ComnQsnMailingAdrsandNameChagText );
		} else {
			reportFail("Expected text is:" + jsonDataParser.getTestDataMap().get("MailingAddressandNameChanges")
					+ "Actual text is" + ComnQsnMailingAdrsandNameChagText);
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify Mailing Addressand Name Changes text ", e, LoggingLevel.ERROR,true);
		reportHardFail("Unable to verify Mailing Addressand Name Changes text");
	}
}


}
