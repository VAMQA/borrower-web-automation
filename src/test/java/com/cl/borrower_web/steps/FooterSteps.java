
package com.cl.borrower_web.steps;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.borrower_web.pages.BorrowerPortalVerifyPage;
import com.cl.borrower_web.pages.FooterPage;
import com.cl.borrower_web.pages.LoginPage;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FooterSteps extends ObjectBase {

	
	FooterPage footerPage = new FooterPage();
	
	@Then("verify all the five footerlink text")
	public void verify_all_the_five_footerlink_text() {
		try {
			if (webActions.getText(footerPage.privacyPolicy)
					.contentEquals(jsonDataParser.getTestDataMap().get("PrivacyPolicy")) &&
				webActions.getText(footerPage.termsConditions)
					.contentEquals(jsonDataParser.getTestDataMap().get("TermsAndConditions")) && 
				webActions.getText(footerPage.scheduleofBorrowerFees)
					.contentEquals(jsonDataParser.getTestDataMap().get("ScheduleofBorrowerFees")) && 
				webActions.getText(footerPage.license)
					.contentEquals(jsonDataParser.getTestDataMap().get("Licenses")) && 
				webActions.getText(footerPage.accessibilityStatement)
					.contentEquals(jsonDataParser.getTestDataMap().get("AccessibilityStatement")) 
					) {
				reportPass("Verifyed footer links text");
			} else {
				reportHardFail("Unable to verify footer links text :", false);
			}
		} catch (Exception e) {
			reportHardFail("Unable to verify footer links text");
		}
	}

	@When("i click on privacy policy link")
	public void i_click_on_privacy_policy_link() {
		try {			
			webActions.clickElement(footerPage.privacyPolicy);
			waits.waitForPageReadyState();
			reportPass("Able to click on privacy policy link");
		} catch (Exception e) {
			LogUtility.logException("Commonform", "Unable to click on privacy policy link", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to click on privacy policy link");
		}
	}

	@When("i click on terms and conditions link")
	public void i_click_on_terms_and_conditions_link() {
		try {			
			webActions.clickElement(footerPage.termsConditions);
			waits.waitForPageReadyState();
			reportPass("Able to click on terms and conditions link");
		} catch (Exception e) {
			LogUtility.logException("Commonform", "Unable to click on terms and conditions link", e,
					LoggingLevel.ERROR, true);
			reportHardFail(" Unable to click on terms and conditions link");
		}
	}

	@When("i click on schedule of borrower fees link")
	public void i_click_on_schedule_of_borrower_fees_link() {
		try {			
			webActions.clickElement(footerPage.scheduleofBorrowerFees);
			waits.waitForPageReadyState();
			reportPass("Able to click on schedule of borrower fees link");
		} catch (Exception e) {
			LogUtility.logException("Commonform", "Unable to click on schedule of borrower fees link", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to click on schedule of borrower fees link");
		}
	}

	@When("i click on licenses link")
	public void i_click_on_licenses_link() {
		try {			
			webActions.clickElement(footerPage.license);
			waits.waitForPageReadyState();
			reportPass("Able to click on licence link");
		} catch (Exception e) {
			LogUtility.logException("Commonform", "Unable to click on licence link", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to click on licence link");
		}
	}

	@When("i click on accessibility statement link")
	public void i_click_on_accessibility_statement_link() {
		try {			
			webActions.clickElement(footerPage.accessibilityStatement);
			waits.waitForPageReadyState();
			reportPass("Able to click on accessibility statement link");
		} catch (Exception e) {
			LogUtility.logException("Commonform", "Unable to click on accessibility statement link", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to click on accessibility statement link");
		}
	}
}
