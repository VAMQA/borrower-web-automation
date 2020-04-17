package com.cl.borrower_web.steps.portal;

import java.util.List;
import com.cl.borrower_web.actions.ObjectBase;
import com.cl.borrower_web.pages.CommonQuestionsPage;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

import cucumber.api.java.en.Then;

public class CommonQuestionsSteps extends ObjectBase {

	CommonQuestionsPage commonQuestionsPage = new CommonQuestionsPage();

	@Then("User should navigate to {string} Page")
	public void user_should_navigate_to_Page(String heading) {
		try {
			waits.staticWait(10000);

			if (webActions.getText(commonQuestionsPage.CommonQuestionsPageHeading)
					.equalsIgnoreCase(jsonDataParser.getTestDataMap().get("PageHeader"))) {
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

	@Then("verify all the questions should display")
	public void verify_all_the_questions_should_display() {
		List<String> ActualquestionsList = commonQuestionsPage.GetAllTheQuestionsList();

		String jsonValues = jsonDataParser.getTestDataMap().get("QuestionsList");

		String[] ExpectedjsonSeperatedValues = jsonValues.split(";");

		boolean result = commonQuestionsPage.verifyCommonQuestionsList(ExpectedjsonSeperatedValues,
				ActualquestionsList);

		if (result == true) {
			reportPass("validation for all the Common Questions get success", true);
		} else {
			reportFail("validation for all the Common Questions get failed", false);
		}

	}

}
