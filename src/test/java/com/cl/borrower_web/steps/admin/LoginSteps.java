
package com.cl.borrower_web.steps.admin;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.borrower_web.pages.portal.BorrowerPortalVerifyPage;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends ObjectBase {

	BorrowerPortalVerifyPage borrowerPortalVerifyPage = new BorrowerPortalVerifyPage();

	@Given("As a user I logged into borrower portal")
	public void as_a_user_I_logged_into_borrower_portal() {
		try {
			waits.staticWait(2000);
			waits.waitForPageReadyState();
			reportPass("Navigate to URL");
		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to Login", e, LoggingLevel.ERROR, true);
			reportHardFail("Unable to Login");
		}
	}
}
