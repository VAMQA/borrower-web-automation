
package com.cl.borrower_web.steps;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.borrower_web.pages.BorrowerPortalVerifyPage;
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

	@When("User enters username and password and click on SignIn button")
	public void user_enters_username_and_password_and_click_on_SignIn_button() {
		System.out.println("User enters username and password");
		waits.staticWait(2000);
		if (borrowerPortalVerifyPage.userEmailTextBox != null && borrowerPortalVerifyPage.passwordTextBox != null) {
			webActions.setValue(borrowerPortalVerifyPage.userEmailTextBox, username);
			webActions.setValue(borrowerPortalVerifyPage.passwordTextBox, password);
			webActions.clickElement(borrowerPortalVerifyPage.signIn);
			waits.staticWait(10000);
		}
	}

	@When("User enters username and invalid password and click on SignIn button")
	public void user_enters_username_and_invalid_password_and_click_on_SignIn_button() {
		System.out.println("User enters username and password");
		waits.staticWait(2000);
		if (borrowerPortalVerifyPage.userEmailTextBox != null && borrowerPortalVerifyPage.passwordTextBox != null) {
			webActions.setValue(borrowerPortalVerifyPage.userEmailTextBox, username);
			webActions.setValue(borrowerPortalVerifyPage.passwordTextBox,
					getEnvironmentProperty("test.password.invalid"));
			webActions.clickElement(borrowerPortalVerifyPage.signIn);
			waits.staticWait(10000);
		}
	}

	@Then("user should be able to view message as Incorrect username or password")
	public void user_should_be_able_to_view_message_as_Incorrect_username_or_password() {
		try {
			waits.staticWait(2000);

			if (webActions.getText(borrowerPortalVerifyPage.incorrectUsernamePassword)
					.equalsIgnoreCase(jsonDataParser.getTestDataMap().get("Description"))) {
				reportPass("Verified Incorrect username or password text");
			} else {
				reportHardFail("Unable to verify Incorrect username or password text");
			}

		} catch (Exception e) {
			LogUtility.logException("BorrowerPortalVerify", "Unable to verify Home Page", e, LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify Incorrect username or password text");
			reportHardFail("Unable to verify Home Page");
		}
	}
}
