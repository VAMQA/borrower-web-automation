
package com.cl.borrower_web.steps.portal;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.borrower_web.pages.portal.BorrowerPortalVerifyPage;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BorrowerPortalMyLoanSteps extends ObjectBase {

	BorrowerPortalVerifyPage borrowerPortalVerifyPage = new BorrowerPortalVerifyPage();

	@Then("verify user landing page display's header as My Loan")
	public void verify_user_landing_page_display_s_header_as_My_Loan() {
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
			reportPass("Clicked on Loan Details tab");
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to Click on common question tab", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to Click on common question tab");
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

	@Then("click on Borrower Details Tab")
	public void click_on_Borrower_Details_Tab() {

		try {
			waits.staticWait(2000);
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

}
