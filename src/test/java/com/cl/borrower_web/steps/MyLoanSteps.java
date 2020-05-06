package com.cl.borrower_web.steps;

import java.util.ArrayList;
import java.util.List;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.borrower_web.pages.MyLoanPage;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.emory.mathcs.backport.java.util.Collections;

public class MyLoanSteps extends ObjectBase {


	MyLoanPage myLoanPage = new MyLoanPage();

	
	@Then("verify navigational options should be displayed to the top right")
	public void verify_navigational_options_should_be_displayed_to_the_top_right() {
	  
	  try { waits.waitForPageReadyState();
	  webActions.clickElement(myLoanPage.commonFormTab);
	  waits.waitForPageReadyState();
	  webActions.clickElement(myLoanPage.commonQuestionsTab);
	  waits.waitForPageReadyState(); webActions.clickElement(myLoanPage.myLoanTab);
	  reportPass("Verified navigation options"); } catch (Exception e) {
	  LogUtility.logException("BorrowerPortalVerify",
	  "Unable to click navigation options", e, LoggingLevel.ERROR, true);
	  reportHardFail("Unable to click navigation options"); }
	  
	  }
	 
	@Then("verify property address and loan information")
	public void verify_property_address_and_loan_information() {
		try {
			if (webActions.getText(myLoanPage.propertyAddress)
					.equalsIgnoreCase(jsonDataParser.getTestDataMap().get("PropertyAddress")) && 
					webActions.getText(myLoanPage.loanInformation)
					.equalsIgnoreCase(jsonDataParser.getTestDataMap().get("loanInformation"))) {
				reportPass("Verified propertyaddress text and loanInformation text");
			} else {
				reportHardFail("Unable propertyaddress text and loanInformation text");
			}
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to verify propertyaddress text and loanInformation text", e, LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify propertyaddress text and loanInformation text");

		}
	}

	@Then("verify recent transactions details")
	public void verify_recent_transactions_details() {
		try {
			waits.waitForPageReadyState();
			webActions.clickElement(myLoanPage.ViewAllTransactionsLink);
			reportPass("Clicked on view all transactions link");
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to click on view all transactions link", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to click on view all transactions link");
		}
	}

	@Then("verify the landing page displays header as my loan")
	public void verify_the_landing_page_displays_header_as_my_loan() {
		try {
			waits.staticWait(10000);
			if (webActions.getText(myLoanPage.myLoanText)
					.equalsIgnoreCase(jsonDataParser.getTestDataMap().get("HeaderNameMyLoan"))) {
				reportPass("Verified my loan text");
			} else {
				reportHardFail("Unable to verify my loan text");
			}
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to verify home page", e, LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify my loan text");
		}
	}

	@Then("verify loan information account number")
	public void verify_loan_information_account_number() {
		try {
			if (webActions.getText(myLoanPage.accountNumber)
					.contains(jsonDataParser.getTestDataMap().get("MyLoanAccountNumber"))) {
				reportPass("Verified account number");
			} else {
				reportHardFail("Unable to verify account number");
			}
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to verify account number", e, LoggingLevel.ERROR,
					true);
			reportHardFail("Unable to verify account number");
		}

	}

	@Then("click on common question menu")
	public void click_on_common_question_menu() {
		try {
			waits.waitForPageReadyState();
			webActions.clickElement(myLoanPage.commonQuestionsTab);
			reportPass("Clicked on common question tab");
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to click on common question tab", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to click on common question tab");
		}
	}

	@Then("verify page header common questions title")
	public void verify_page_header_common_questions_title() {
		try {
			waits.waitForPageReadyState();

			if (webActions.getText(myLoanPage.commonQuestionsText)
					.contains(jsonDataParser.getTestDataMap().get("CommonQuestionPageHeader"))) {
				reportPass("Verified common questions text");
			} else {
				reportHardFail("Unable to verify common questions text");
			}
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to Common questions text", e, LoggingLevel.ERROR,
					true);
			reportHardFail("Unable to verify common questions text");
		}
	}

	@When("click on loan details tab")
	public void click_on_loan_details_tab() {
		try {
			waits.waitForPageReadyState();
			webActions.clickElement(myLoanPage.loanDetailsTab);
			waits.waitForPageReadyState();
			reportPass("Clicked on loan details tab");
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to click on loan details tab", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to Click on loan details tab");
		}

	}

	@When("click on monthly statement tab")
	public void click_on_monthly_statement_tab() {
		try {
			waits.waitForPageReadyState();
			webActions.clickElement(myLoanPage.MonthlyStatementTab);
			waits.waitForPageReadyState();
			reportPass("Clicked on monthly statement tab");
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to click on monthly statement tab", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to click on monthly statement tab");
		}


	}

	@When("click on transaction history tab")
	public void click_on_transaction_history_tab() {
		try {
			waits.waitForPageReadyState();
			webActions.clickElement(myLoanPage.TransactionHistoryTab);
			waits.waitForPageReadyState();
			reportPass("Clicked on transaction history tab");
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to click on transaction history tab", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to click on transaction history tab");
		}
	}

	@Then("verify Current Net Principal Limit text")
	public void verify_Current_Net_Principal_Limit_text() {

		try {
			waits.waitForPageReadyState();

			if (webActions.getText(myLoanPage.currentNetPrincipalLimitText)
					.contains(jsonDataParser.getTestDataMap().get("CurrentNetPrincipalLimitText"))) {
				reportPass("Verified current net principal limit text in loan details Tab ");
			} else {
				reportHardFail("Unable to verify current net principal limit text in Loan details tab");
			}
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify",
					"Unable to verify current net principal limit text in loan details tab", e, LoggingLevel.ERROR,
					true);
			reportHardFail("Unable to verify current net principal limit text in loan details tab");
		}

	}
	
	@Then("verify property address details")
	public void verify_property_address_details() {
		try {
			if (webActions.getText(myLoanPage.propertyAddressLineOne)
					.contains(jsonDataParser.getTestDataMap().get("PropertyAddressLine1"))  &&
					webActions.getText(myLoanPage.propertyAddressLineTwo)
					.contains(jsonDataParser.getTestDataMap().get("PropertyAddressLine2")) 
					) {
				reportPass("Verified propertyaddresslineone and propertyaddresslinetwo ");
			} else {
				reportHardFail("Unable to verify propertyaddress details");
			}
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify",
					"Unable to verify propertyaddress details", e, LoggingLevel.ERROR,
					true);
			reportHardFail("Unable to verify propertyaddress details");
		}
	}
		
	@Then("verify loan information details")
	public void verify_loan_information_details() {
		try {
			if (webActions.getText(myLoanPage.LoanType)
					.contains(jsonDataParser.getTestDataMap().get("MyLoanAccountLoanType"))) {
				reportPass("Verified loantype");
			} else {
				reportHardFail("Unable to verify loantype");
			}
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to verify loantype", e, LoggingLevel.ERROR,
					true);
			reportHardFail("Unable to verify loantype");
		}
	}
	
	@When("click on borrower details tab")
	public void click_on_borrower_details_tab() {

		try {
			waits.waitForPageReadyState();
			webActions.clickElement(myLoanPage.borrowerDetailsTab);
			reportPass("Clicked on borrower details tab");
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to click on borrower details tab", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to click on borrower details tab");
		}

	}

	@Then("verify Name in borrower details")
	public void verify_Name_in_borrower_details() {

		try {
			waits.waitForPageReadyState();
			String actualBorrower = webActions.getText(myLoanPage.borrowerDetailsName);

			if (actualBorrower.contains(jsonDataParser.getTestDataMap().get("BorrowerName"))) {
				reportPass("Expected borrower name:" + jsonDataParser.getTestDataMap().get("BorrowerName")
						+ " Actual borrower name" + actualBorrower);
			} else {
				reportFail("Expected borrower name:" + jsonDataParser.getTestDataMap().get("BorrowerName")
						+ " Actual borrower name" + actualBorrower);
			}
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify",
					"Unable to verify borrower details name text in borrower details Tab ", e, LoggingLevel.ERROR,
					true);
			reportHardFail("Unable to verify borrower details name text in borrower details Tab ");
		}
	}

@Then("verify amount displayed for field current net principal limit")
	public void verify_amount_displayed_for_field_current_net_principal_limit() {
	waits.waitForPageReadyState();
	try {
		if (webActions.getText(myLoanPage.currentNetPrincipalLimitValue)
				.contains(jsonDataParser.getTestDataMap().get("CurrentNetPrincipalLimit"))) {
			reportPass("Verified current net principal limit value in loan details tab ");
		} else {
			reportHardFail("Unable to verify current net principal limit value in loan details tab");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify current net principal limit value in loan details tab", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify current net principal limit value in loan details tab");
	}
}

@Then("verify amount displayed for field current available line of credit")
	public void verify_amount_displayed_for_field_current_available_line_of_credit() {
	try {
	waits.waitForPageReadyState();
		if (webActions.getText(myLoanPage.CurrentAvailableLineofCreditValue)
				.contains(jsonDataParser.getTestDataMap().get("CurrentAvailableLineofCredit"))) {
			reportPass("Verified current available line of credit value in loan details tab ");
		} else {
			reportHardFail("Unable to verify current available line of credit value in loan details tab");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify current available line of credit value in loan details tab", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify current available line of credit value in loan details tab");
	}
	
}

@Then("verify amount displayed for field current total loan balance")
	public void verify_amount_displayed_for_field_current_total_loan_balance() {
	try {
		waits.waitForPageReadyState();

		if (webActions.getText(myLoanPage.CurrentTotalLoanBalanceValue)
				.contains(jsonDataParser.getTestDataMap().get("CurrentTotalLoanBalance"))) {
			reportPass("Verified current total loan balance value in loan details tab ");
		} else {
			reportHardFail("Unable to verify current total loan balance value in loan details tab");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify current total loan balance value in loan details tab", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify current total loan balance value in loan details tab");
	}
}

@Then("verify amount displayed for field interest rate")
	public void verify_amount_displayed_for_field_interest_rate() {
	try {
		waits.waitForPageReadyState();

		if (webActions.getText(myLoanPage.InterestRateValue)
				.contains(jsonDataParser.getTestDataMap().get("InterestRate"))) {
			reportPass("Verified interest rate value in loan details tab ");
		} else {
			reportHardFail("Unable to verify interest rate value in loan details tab");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify interest rate value in loan details tab", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify interest rate value in loan details tab");
	}
}

@Then("verify amount displayed for field set aside funds")
	public void verify_amount_displayed_for_field_set_aside_funds() {
    
	try {
		waits.waitForPageReadyState();

		if (webActions.getText(myLoanPage.SetAsideFundsValue)
				.contains(jsonDataParser.getTestDataMap().get("SetAsideFunds"))) {
			reportPass("Verified set aside funds value in loan details tab ");
		} else {
			reportHardFail("Unable to verify set aside funds value in loan details tab ");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify set aside funds value in loan details tab ", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify set aside funds value in loan details tab ");
	}
}

@Then("verify that two sections are displayed in borrower details tab")
	public void verify_that_two_sections_are_displayed_in_borrower_details_tab() {
	try {
		if (webActions.getText(myLoanPage.BorDetYourProfile)
				.contains(jsonDataParser.getTestDataMap().get("YourProfile"))  &&
				webActions.getText(myLoanPage.BorDetOtherBorrowers)
				.contains(jsonDataParser.getTestDataMap().get("OtherBorrowers")) 
				) {
			reportPass("Verified yourprofile and otherborrowers details");
		} else {
			reportHardFail("Unable to verify yourprofile and otherborrowers details");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify yourprofile and otherborrowers details", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify yourprofile and otherborrowers details");
	}
}

@Then("verify that three sections are displayed in borrower details your profile tab")
	public void verify_that_three_sections_are_displayed_in_borrower_details_your_profile_tab() {
	try {
		if (webActions.getText(myLoanPage.BorDetPersonalDetails)
				.contains(jsonDataParser.getTestDataMap().get("YourProfilePersonalDetails"))  &&
				webActions.getText(myLoanPage.BorDetContactInformation)
				.contains(jsonDataParser.getTestDataMap().get("YourProfileContactInformation")) &&
				webActions.getText(myLoanPage.BorDetMailingAddress)
				.contains(jsonDataParser.getTestDataMap().get("YourProfileMailingAddress"))
				) {
			reportPass("Verified yourprofile details ");
		} else {
			reportHardFail("Unable to verify yourprofile details ");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify yourprofile details", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify yourprofile  details");
	}	
}

@Then("verify that name and dob are displaying in personal details section")
	public void verify_that_name_and_dob_are_displaying_in_personal_details_section() { 
	try {
		waits.waitForPageReadyState();
		String actualBorrower = webActions.getText(myLoanPage.borrowerDetailsName);
		String actualBorrowerDob = webActions.getText(myLoanPage.borrowerDetailsDob);
		if (actualBorrower.contains(jsonDataParser.getTestDataMap().get("BorrowerName")) &&
				actualBorrowerDob.contains(jsonDataParser.getTestDataMap().get("BorrowerDob"))
				) {
			reportPass("Expected borrower name:" + jsonDataParser.getTestDataMap().get("BorrowerName")
					+ " Actual borrower" + actualBorrower );
			reportPass("Expected borrower dob:" + jsonDataParser.getTestDataMap().get("BorrowerDob")
					+ " Actual borrower dob" + actualBorrowerDob );
		} else {
			reportFail("Expected borrower name:" + jsonDataParser.getTestDataMap().get("BorrowerName")
					+ " Actual borrower name" + actualBorrower);
			reportFail("Expected borrower dob:" + jsonDataParser.getTestDataMap().get("BorrowerDob")
					+ " Actual borrower dob" + actualBorrowerDob );
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify borrower details name and dob text in borrower details tab ", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify borrower details name and dob text in borrower details tab ");
	}
}

@Then("verify that mobileno and emailid are displaying in contact information section")
	public void verify_that_mobileno_and_emailid_are_displaying_in_contact_information_section() {
	try {
		waits.waitForPageReadyState();
		String borDetContInfoMobNo = webActions.getText(myLoanPage.borDetContInfoMobNo);
		String borDetContInfoEmailid = webActions.getText(myLoanPage.borDetContInfoEmailid);
		if (borDetContInfoMobNo.contains(jsonDataParser.getTestDataMap().get("BorDetMobno")) &&
				borDetContInfoEmailid.contains(jsonDataParser.getTestDataMap().get("BorDetEmailid"))
				) {
			reportPass("Expected borrower mobile no:" + jsonDataParser.getTestDataMap().get("BorDetMobno")
					+ " Actual borrower  mobile no:" + borDetContInfoMobNo );
			reportPass("Expected borrower email id:" + jsonDataParser.getTestDataMap().get("BorDetEmailid")
					+ " Actual borrower email id" + borDetContInfoEmailid );
		} else {
			reportFail("Expected borrower mobile no:" + jsonDataParser.getTestDataMap().get("BorDetMobno")
					+ " Actual borrower mobile no" + borDetContInfoMobNo);
			reportFail("Expected borrower email id:" + jsonDataParser.getTestDataMap().get("BorDetEmailid")
					+ " Actual borrower email id" + borDetContInfoEmailid );
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify borrower details mobile no and email id text in borrower details tab ", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify borrower details mobile no and email id text in borrower details tab ");
	}
}

@Then("verify that mailingaddlineone and mailingaddlineone are displaying in mailing address section")
	public void verify_that_mailingaddlineone_and_mailingaddlineone_are_displaying_in_mailing_address_section() {
   
	try {
		waits.waitForPageReadyState();
		String borDetMailingAddL1 = webActions.getText(myLoanPage.borDetMailingAddL1);
		String borDetMailingAddL2 = webActions.getText(myLoanPage.borDetMailingAddL2);
		if (borDetMailingAddL1.contains(jsonDataParser.getTestDataMap().get("BorDetMailingAdrLine1")) &&
				borDetMailingAddL2.contains(jsonDataParser.getTestDataMap().get("BorDetMailingAdrLine2"))
				) {
			reportPass("Expected borrower mailing address line one:" + jsonDataParser.getTestDataMap().get("BorDetMailingAdrLine1")
					+ " Actual borrower  mailing address line one:" + borDetMailingAddL1 );
			reportPass("Expected borrower mailing address line two:" + jsonDataParser.getTestDataMap().get("BorDetMailingAdrLine2")
					+ " Actual borrower mailing address line two" + borDetMailingAddL2 );
		} else {
			reportFail("Mailing address line one:" + jsonDataParser.getTestDataMap().get("BorDetMailingAdrLine1")
					+ " Mailing address line one" + borDetMailingAddL1);
			reportFail("Mailing address line two:" + jsonDataParser.getTestDataMap().get("BorDetMailingAdrLine2")
					+ " Mailing address line two" + borDetMailingAddL2 );
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify borrower details mailing address line one text in borrower details tab ", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify borrower details mailing address line one text in borrower details tab ");
	}
	
}

@Then("verify personal details name are displaying in personal details section")
	public void verify_personal_details_name_are_displaying_in_personal_details_section() {
	try {
		waits.waitForPageReadyState();
		String borDetOthBorPerDetailsName = webActions.getText(myLoanPage.borDetOthBorPerDetailsName);
		if (
				borDetOthBorPerDetailsName.contains(jsonDataParser.getTestDataMap().get("BorDetPerDteName"))
				) {
			reportPass("Expected borrower details name:" + jsonDataParser.getTestDataMap().get("BorDetPerDteName")
					+ " Borrower details name:" + borDetOthBorPerDetailsName );
			
		} else {
			reportFail("Borrower details name:" + jsonDataParser.getTestDataMap().get("BorDetPerDteName")
					+ " Borrower details name" + borDetOthBorPerDetailsName);
			
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify borrower details mailing address line one text in borrower details tab ", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify borrower details mailing address line one text in borrower details tab ");
	}
	
	
}

@Then("verify borrower details what is required to change my information above link")
	public void verify_borrower_details_what_is_required_to_change_my_information_above_link() {
	try {
		waits.waitForPageReadyState();
		webActions.clickElement(myLoanPage.borDetChangInfoLink);
		waits.waitForPageReadyState();
		reportPass("Clicked on link");
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify", "Unable to click on link", e,
				LoggingLevel.ERROR, true);
		reportHardFail("Unable to click on link");
	}
}

@Then("verify on click mailing address and name changes text")
	public void verify_on_click_mailing_address_and_name_changes_text() {
	try {
		waits.waitForPageReadyState();
		String ComnQsnMailingAdrsandNameChagText = webActions.getText(myLoanPage.ComnQsnMailingAdrsandNameChagText);
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
				"Unable to verify mailing address and name changes text ", e, LoggingLevel.ERROR,true);
		reportHardFail("Unable to verify mailing address and name changes text");
	}
}

@Then("verify the field text choose the year")
	public void verify_the_field_text_choose_the_year() {
	try {
		waits.waitForPageReadyState();

		if (webActions.getText(myLoanPage.ChooseAYearText)
				.contains(jsonDataParser.getTestDataMap().get("ChooseAYearText"))) {
			reportPass("Verified Choose a year text ");
		} else {
			reportHardFail("Unable to verify choose a year text");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify choose a year text", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify choose a year text");
	}
}

@Then("verify default fault year from dropdown")
	public void verify_default_fault_year_from_dropdown() {
	try {
		waits.waitForPageReadyState();

		if (webActions.getText(myLoanPage.ChooseAYearDropDown)
				.contains(jsonDataParser.getTestDataMap().get("MonthlyStmtsYearDefaultDropDownValue"))) {
			reportPass("Verified monthly statements default drop down year");
		} else {
			reportHardFail("Unable to verify monthly statements default drop down year");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify monthly statements default drop down year", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify monthly statements default drop down year");
	}
}

@Then("verify the field text how to read my statement")
	public void verify_the_field_text_how_to_read_my_statement() {
	try {
		waits.waitForPageReadyState();

		if (webActions.getText(myLoanPage.HowToReadMyStatement)
				.contains(jsonDataParser.getTestDataMap().get("HowToReadMyStatement"))) {
			reportPass("Verified monthly statements how to read my statement");
		} else {
			reportHardFail("Unable to verify monthly statements how to read my statement");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify monthly statements how to read my statement", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify monthly statements how to read my statement");
	}
}

@Then("verify the field link how to read my statement is clickable")
	public void verify_the_field_link_how_to_read_my_statement_is_clickable() {
	try {
		waits.waitForPageReadyState();
		webActions.clickElement(myLoanPage.HowToReadMyStatement);
		waits.waitForPageReadyState();
		reportPass("Clicked on link");
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify", "Unable to Click on link", e,
				LoggingLevel.ERROR, true);
		reportHardFail("Unable to click on link");
	}
}

@Then("verify recent transactions contains all the table field names")
	public void verify_recent_transactions_contains_all_the_table_field_names() {
	ArrayList<String> headerValues = BorrowerWebUtil.getTableheaderValues(myLoanPage.LoanDetailsRecentTransactionTableHeader);
	
	List<String> HeaderNamelistbackend = MyLoanPage.headerNamelistbe();
	Collections.sort(HeaderNamelistbackend);
	Collections.sort(headerValues);
	 boolean isEqual = headerValues.equals(HeaderNamelistbackend);
	 if(isEqual) {
		 reportPass("header name matches -"+headerValues);
	 }else {
	
			reportHardFail("header name mismatches "+headerValues);
	 }
}

@Then("verify recent transactions contains all the table field values")
	public void verify_recent_transactions_contains_all_the_table_field_values() {
	
	try {
		waits.waitForPageReadyState();
		
		ArrayList<String> headerValues = BorrowerWebUtil.getTableValues(myLoanPage.LoanDetailsRecentTransactionTableValues);
		System.out.println(headerValues);
		if(headerValues.size()>0) {
		reportPass("Recent Transaction values are" +headerValues);
		}else if(headerValues.isEmpty()) {
			reportHardFail("Recent transaction values are empty");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify", "Unable to click on view all transactions link", e,
				LoggingLevel.ERROR, true);
		reportHardFail("Unable to click on view all transactions link");
	}
	
	
	
}

@When("click on view all transactions link")
	public void click_on_view_all_transactions_link() {
	try {
		waits.waitForPageReadyState();
		webActions.clickElement(myLoanPage.ViewAllTransactionsLink);
		reportPass("Clicked on view all transactions link");
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify", "Unable to click on view all transactions link", e,
				LoggingLevel.ERROR, true);
		reportHardFail("Unable to click on view all transactions link");
	}
}

@Then("verify on click of view all transactions link should navigate to transaction history table")
	public void verify_on_click_of_view_all_transactions_link_should_navigate_to_transaction_history_table() {
	try {
		waits.waitForPageReadyState();
		webActions.clickElement(myLoanPage.ViewAllTransactionsLink);
		waits.waitForPageReadyState();
		webActions.isEnabled(myLoanPage.TransactionHistoryTab);
		reportPass("Navigated to transaction history");
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify", "Unable to navigate to transaction history", e,
				LoggingLevel.ERROR, true);
		reportHardFail("Unable to navigate to transaction history");
	}
}

@Then("verify default transaction history table header names")
	public void verify_default_transaction_history_table_header_names() {
	ArrayList<String> UiheaderValues = BorrowerWebUtil.getTableheaderValues(myLoanPage.TransactionHistoryTransactionTableHeader);
	System.out.println(UiheaderValues);
	
	List<String> HeaderNamelistbackend = MyLoanPage.headerNamelistbe();
	Collections.sort(UiheaderValues);
	Collections.sort(HeaderNamelistbackend);
	 boolean isEqual = UiheaderValues.equals(HeaderNamelistbackend);
	 if(isEqual) {
		 reportPass("header name matches -"+UiheaderValues);
	 }else {
	
			reportHardFail("header name miss matches "+UiheaderValues);
	 }
}

@Then("verify default year displayed in dropdown")
	public void verify_default_year_displayed_in_dropdown() {
	try {
		waits.waitForPageReadyState();

		if (webActions.getText(myLoanPage.TransactionHistorYearDropDown)
				.contains(jsonDataParser.getTestDataMap().get("TransactionHistorYearDropDown"))) {
			reportPass("Verified default transaction histor year drop down");
		} else {
			reportHardFail("Unable to verify default transaction histor year drop down");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify",
				"Unable to verify default transaction histor year drop down", e, LoggingLevel.ERROR,
				true);
		reportHardFail("Unable to verify default transaction histor year drop down");
	}
	
}

@Then("verify default list of year")
	public void verify_default_list_of_year() {
	
	webActions.clickElement(myLoanPage.TransactionHistorYearDropDown);
	waits.waitForPageReadyState();			
	List<String> UiyearList = myLoanPage.getVisibleElementText(myLoanPage.TransactionHistorYearDropDownList);
	System.out.println(UiyearList);	
	List<String> yearListbackend = MyLoanPage.transHistoryYearSet();
	Collections.sort(UiyearList);
	Collections.sort(yearListbackend);
	 boolean isEqual = UiyearList.equals(yearListbackend);
	 if(isEqual) {
		 reportPass("dropdown yearlist matches -"+UiyearList);
	 }else {
	
			reportHardFail("dropdown yearlist miss matches "+UiyearList);
	 }
	
	
	
}

	@Then("verify transaction history header values")
	public void verify_transaction_history_header_values() {
	try {
		waits.waitForPageReadyState();
		
		ArrayList<String> headerValues = BorrowerWebUtil.getTableValues(myLoanPage.TransactionHistoryTransactionTableValues);
		System.out.println(headerValues);
		if(headerValues.size()>0) {
		reportPass("Transaction history transaction table values are" +headerValues);
		}else if(headerValues.isEmpty()) {
			reportHardFail("Transaction history transaction table values are empty");
		}
	} catch (Exception e) {
		LogUtility.logException("BorrowerPortalVerify", "Unable to verify transaction history transaction table values", e,
				LoggingLevel.ERROR, true);
		reportHardFail("Unable to verify transaction history transaction table values");
	}
}
	
	@When("select a year other then default year")
	public void select_a_year_other_then_default_year() {
		
		waits.waitForPageReadyState();
		webActions.clickElement(myLoanPage.TransactionHistorYearDropDownValues);
		waits.waitForPageReadyState();
		
	}

}