package com.cl.borrower_web.steps;

import java.util.List;
import com.cl.borrower_web.actions.ObjectBase;
import com.cl.borrower_web.pages.CommonQuestionsPage;
import com.cl.borrower_web.pages.MyLoanPage;
import com.cl.java_af.engine.WebActions;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonQuestionsSteps extends ObjectBase {

	CommonQuestionsPage commonQuestionsPage = new CommonQuestionsPage();
	MyLoanPage myLoanPage = new MyLoanPage();

	@Then("verify the page displays header as common questions")
	public void verify_the_page_displays_header_as_common_questions() {
		try {
			waits.waitUntilElementExistence(commonQuestionsPage.CommonQuestionsPageHeading);

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

	@When("i click on common questions button in my loan page")
	public void i_click_on_common_questions_button_in_my_loan_page() {
		try {
			waits.waitUntilElementExistence(myLoanPage.commonQuestionsTab);
			webActions.clickElement(myLoanPage.commonQuestionsTab);
			reportPass("Clicked on common question tab");
		} catch (Exception e) {
			LogUtility.logException("MyLoanPage", "Unable to Click on common question tab", e, LoggingLevel.ERROR,
					true);
			reportHardFail("Unable to Click on common question tab");
		}
	}

	@Then("verify the label of the first topic displayed as popular")
	public void verify_the_label_of_the_first_topic_displayed_as_popular() {
		try {
			if (commonQuestionsPage.GetHeaderElement(jsonDataParser.getTestDataMap().get("PopularHeader"))
					.isDisplayed()) {
				reportPass("Verified popular header in common questions page");
			} else {
				reportHardFail("verify popular header in common questions page get failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonPageVerify", "Unable to verify the first topic displayed as popular", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify popular header in common questions page");
		}
	}

	@Then("verify the Question one displayed under popular section as How do I request an advance from my Line of Credit\\(LOC)?")
	public void verify_the_Q_displayed_under_popular_section_as_How_do_I_request_an_advance_from_my_Line_of_Credit_LOC() {
		try {
			if (commonQuestionsPage.GetQuestion_withheader_Element(jsonDataParser.getTestDataMap().get("PopularHeader"),
					jsonDataParser.getTestDataMap().get("popular_RequestAdvanceFromLOC")).isDisplayed()) {
				reportPass("Verified popular header in common questions page");
			}
			else {
				reportHardFail("Verified Request Advance form LOC in common questions page failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonPageVerify", "Unable to verify Question one under popular", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify Question one under popular");
		}
	}

	@When("i click on Question one - How do I request an advance from my Line of Credit\\(LOC)?")
	public void i_click_on_Q_How_do_I_request_an_advance_from_my_Line_of_Credit_LOC() {
		try {
			webActions.clickElement(commonQuestionsPage.GetQuestion_withheader_Element(
					jsonDataParser.getTestDataMap().get("PopularHeader"),
					jsonDataParser.getTestDataMap().get("popular_RequestAdvanceFromLOC")));
			reportPass("Clicked on Question one - How do I request an advance from my Line of Credit");
		} catch (Exception e) {
			LogUtility.logException("CommonQuestions page",
					"Unable to click Question one - How do I request an advance from my Line of Credit", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to Click on Question one - How do I request an advance from my Line of Credit");
		}
	}

	@Then("verify the Question one answer should display")
	public void verify_the_Q_answer_should_display() {
		try {
			if (webActions
					.getText(commonQuestionsPage.GetAnswer_withheader_Element(
							jsonDataParser.getTestDataMap().get("PopularHeader"),
							jsonDataParser.getTestDataMap().get("popular_RequestAdvanceFromLOC")))
					.equalsIgnoreCase(jsonDataParser.getTestDataMap().get("polular_RequestAdvanceFromLOC_collapse"))) {
				reportPass("verified the Question one answer should display");
			} else {
				reportHardFail("verified the Question one answer should display failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonPageVerify", "Unable to verify the Question one answer should display", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify the Question one answer should display");
		}
	}

	@When("i click on the link LOC Advance request form")
	public void i_click_on_the_link_LOC_Advance_request_form() {
		try {
			webActions.clickElement(commonQuestionsPage.popular_LOCAdvanceRequestForm_pdflink);
			reportPass("Clicked on the link LOC Advance request form");
		} catch (Exception e) {
			LogUtility.logException("CommonQuestions page", "Unable to click the link LOC Advance request form", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to Click the link LOC Advance request form");
		}
	}

	@Then("verify LOC advance request form is opend")
	public void verify_LOC_advance_request_form_is_opend() {
		try {
			if (driver.getCurrentUrl()
					.equalsIgnoreCase(jsonDataParser.getTestDataMap().get("popular_RequestLOC_link_url"))) {
				reportPass("Verified LOC advance request form is opend");
			} else {
				reportHardFail("Verified LOC advance request form is opend failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonPageVerify", "LOC advance request form is opend", e, LoggingLevel.ERROR,
					true);
			reportHardFail("Unable to LOC advance request form is opend");
		}
	}	
	
	@When("verify the second header dispalay as How Do Reverse Mortgages Work?")
	public void verify_the_second_header_dispalay_as_How_Do_Reverse_Mortgages_Work() {
		try {
			if (commonQuestionsPage.GetHeaderElement(jsonDataParser.getTestDataMap().get("ReverseMortageHeader"))
					.isDisplayed()) {
				reportPass("Verified the second header dispalay as How Do Reverse Mortgages Work");
			} else {
				reportHardFail("verify the second header dispalay as How Do Reverse Mortgages Work get failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonQuestionPageVerify", "Unable to verify the second header dispalay as How Do Reverse Mortgages Work", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify the second header dispalay as How Do Reverse Mortgages Work");
		}
	}

	@When("verify the sub header display as Home ownership under header How Do Reverse Mortgages work")
	public void verify_the_sub_header_display_as_Home_ownership_under_header_How_Do_Reverse_Mortgages_work() {
		try {
			if (commonQuestionsPage.GetSubheader_Element(jsonDataParser.getTestDataMap().get("ReverseMortageHeader"),jsonDataParser.getTestDataMap().get("ReverseMortagSubHeader_GrowthHECMLoan"))
					.isDisplayed()) {
				reportPass("Verified the sub header display as Home ownership under header How Do Reverse Mortgages work");
			} else {
				reportHardFail("verify the sub header display as Home ownership under header How Do Reverse Mortgages work get failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonQuestionPageVerify", "Unable to verify the sub header display as Home ownership under header How Do Reverse Mortgages work", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify the sub header display as Home ownership under header How Do Reverse Mortgages work");
		}
	}

	@When("verify the question displayed as I was told that my loan might grow What does that mean?")
	public void verify_the_question_displayed_as_I_was_told_that_my_loan_might_grow_What_does_that_mean() {
		try {
			if (commonQuestionsPage.GetQuestion_withSubheader_Element(jsonDataParser.getTestDataMap().get("ReverseMortageHeader"),jsonDataParser.getTestDataMap().get("ReverseMortagSubHeader_GrowthHECMLoan"),jsonDataParser.getTestDataMap().get("QuestionUnder_GrowthHECMLoan"))
					.isDisplayed()) {
				reportPass("Verified the question displayed as I was told that my loan might grow What does that mean");
			} else {
				reportHardFail("verify the question displayed as I was told that my loan might grow What does that mean get failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonQuestionPageVerify", "Unable to verify the question displayed as I was told that my loan might grow What does that mean", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify the question displayed as I was told that my loan might grow What does that mean");
		}
	}

	@When("i click on question I was told that my loan might grow What does that mean?")
	public void i_click_on_question_I_was_told_that_my_loan_might_grow_What_does_that_mean() {
		try {
			webActions.clickElement(commonQuestionsPage.GetQuestion_withSubheader_Element(jsonDataParser.getTestDataMap().get("ReverseMortageHeader"),jsonDataParser.getTestDataMap().get("ReverseMortagSubHeader_GrowthHECMLoan"),jsonDataParser.getTestDataMap().get("QuestionUnder_GrowthHECMLoan")));
			reportPass("Clicked on question I was told that my loan might grow What does that mean");
		} catch (Exception e) {
			LogUtility.logException("CommonQuestions page",
					"Unable to click on question I was told that my loan might grow What does that mean", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to click on question I was told that my loan might grow What does that mean");
		}
	}

	@Then("verify the ansswer for the question I was told my loan might grow What does that mean?")
	public void verify_the_ansswer_for_the_question_I_was_told_my_loan_might_grow_What_does_that_mean() {
		try {
			String actual = commonQuestionsPage.GetAnswer_withSubheader_Element(jsonDataParser.getTestDataMap().get("ReverseMortageHeader"),jsonDataParser.getTestDataMap().get("ReverseMortagSubHeader_GrowthHECMLoan"),jsonDataParser.getTestDataMap().get("QuestionUnder_GrowthHECMLoan")).getText();
			String expect = jsonDataParser.getTestDataMap().get("Answer_GrowthHECMLoan");
						
			actual = actual.replace("\n", "").replace("\r", "");
			expect = expect.replace("\n", "").replace("\r", "");
						
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified the ansswer for the question I was told my loan might grow What does that mean");
			} else {
				reportHardFail("verify the ansswer for the question I was told my loan might grow What does that mean");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonQuestionPageVerify", "Unable to verify the ansswer for the question I was told my loan might grow What does that mean", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify the ansswer for the question I was told my loan might grow What does that mean");
		}
	}

	@Then("verify the some part of the text display as bold")
	public void verify_the_some_part_of_the_text_display_as_bold() {
		try {
			String actual = commonQuestionsPage.GetAnswer_withSubheader_Element(jsonDataParser.getTestDataMap().get("ReverseMortageHeader"),jsonDataParser.getTestDataMap().get("ReverseMortagSubHeader_GrowthHECMLoan"),jsonDataParser.getTestDataMap().get("QuestionUnder_GrowthHECMLoan"), "Bold").getText();
			String expect = jsonDataParser.getTestDataMap().get("BoldtextAnswer");
						
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified some part of the text display as bold");
			} else {
				reportHardFail("verify some part of the text display as bold failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonQuestionPageVerify", "Unable to verify some part of the text display as bold", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify some part of the text display as bold");
		}	    
	}
	
	@When("i click on Advancing Funds from Your Reverse Mortgage topic under List of Topics")
	public void i_click_on_Advancing_Funds_from_Your_Reverse_Mortgage_topic_under_List_of_Topics() {
		try {
			webActions.clickElement(commonQuestionsPage.GetTopic_Element(jsonDataParser.getTestDataMap().get("Topic_AdvancingFunds")));
			reportPass("Clicked on Advancing Funds from Your Reverse Mortgage topic under List of Topics");
		} catch (Exception e) {
			LogUtility.logException("CommonQuestions page",
					"Unable to click on Advancing Funds from Your Reverse Mortgage topic under List of Topics", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to click on Advancing Funds from Your Reverse Mortgage topic under List of Topics");
		}
	}

	@Then("verify page is navigated to Advancing Funds from Your Reverse Mortgage section present to the right side")
	public void verify_page_is_navigated_to_Advancing_Funds_from_Your_Reverse_Mortgage_section_present_to_the_right_side() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetHeaderElement(jsonDataParser.getTestDataMap().get("Header_advanceFunds")));
			String expect = jsonDataParser.getTestDataMap().get("Header_advanceFunds");
						
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified page is navigated to Advancing Funds from Your Reverse Mortgage section present to the right side");
			} else {
				reportHardFail("verify page is navigated to Advancing Funds from Your Reverse Mortgage section present to the right side failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonQuestionPageVerify", "Unable to verify page is navigated to Advancing Funds from Your Reverse Mortgage section present to the right side", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify page is navigated to Advancing Funds from Your Reverse Mortgage section present to the right side");
		}
	}

	@Then("verify the subheader is displayed as Requesting Funds")
	public void verify_the_subheader_is_displayed_as_Requesting_Funds() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetSubheader_Element("Advancing Funds from Your Reverse Mortgage","Requesting Funds"));
			String expect = jsonDataParser.getTestDataMap().get("Subheader_advanceFunds_RequestingFunds");
						
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified the subheader is displayed as Requesting Funds");
			} else {
				reportHardFail("verify the subheader is displayed as Requesting Funds failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonQuestionPageVerify", "Unable to verify the subheader is displayed as Requesting Funds", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify the subheader is displayed as Requesting Funds");
		}
	}

	@When("i click on question Can an Attorney-in-Fact who has Power of Attorney sign the Line of Credit Advance Request form for the borrower\\(s)?")
	public void i_click_on_question_Can_an_Attorney_in_Fact_who_has_Power_of_Attorney_sign_the_Line_of_Credit_Advance_Request_form_for_the_borrower_s() {
		try {
			webActions.clickElement(commonQuestionsPage.GetQuestion_withSubheader_Element("Advancing Funds from Your Reverse Mortgage", "Requesting Funds", "Can an Attorney-in-Fact who has Power of Attorney sign the Line of Credit Advance Request form for the borrower(s)?"));
			reportPass("Clicked on question Can an Attorney-in-Fact who has Power of Attorney sign the Line of Credit Advance Request form for the borrower");
		} catch (Exception e) {
			LogUtility.logException("CommonQuestions page",
					"Unable to click on question Can an Attorney-in-Fact who has Power of Attorney sign the Line of Credit Advance Request form for the borrower", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to click on question Can an Attorney-in-Fact who has Power of Attorney sign the Line of Credit Advance Request form for the borrower");
		}
	}

	@Then("verify question should get expanded and answer should be displayed as Yes, the attorney etc")
	public void verify_question_should_get_expanded_and_answer_should_be_displayed_as_Yes_the_attorney_etc() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetAnswer_withSubheader_Element("Advancing Funds from Your Reverse Mortgage", "Requesting Funds", "Can an Attorney-in-Fact who has Power of Attorney sign the Line of Credit Advance Request form for the borrower(s)?"));
			String expect = jsonDataParser.getTestDataMap().get("Answer_For_AttoneyInFact");
						
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified question should get expanded and answer should be displayed as Yes, the attorney etc");
			} else {
				reportHardFail("verify question should get expanded and answer should be displayed as Yes, the attorney etc failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonQuestionPageVerify", "Unable to verify question should get expanded and answer should be displayed as Yes, the attorney etc", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify question should get expanded and answer should be displayed as Yes, the attorney etc");
		}
	}

	@Then("verify the subheader is displayed as monthly payments")
	public void verify_the_subheader_is_displayed_as_monthly_payments() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetSubheader_Element("Advancing Funds from Your Reverse Mortgage","Monthly Payments"));
			String expect = jsonDataParser.getTestDataMap().get("SubHeader_advanceFunds_Monthlystmts");
						
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified the subheader is displayed as monthly payments");
			} else {
				reportHardFail("verify the subheader is displayed as monthly payments failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonQuestionPageVerify", "Unable to verify the subheader is displayed as monthly payments", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify the subheader is displayed as monthly payments");
		}
	}
	
	@Then("verify the header display as Advancing Funds from Your Reverse Mortgage")
	public void verify_the_header_display_as_Advancing_Funds_from_Your_Reverse_Mortgage() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetHeaderElement(jsonDataParser.getTestDataMap().get("Header_advanceFunds")));
			String expect = jsonDataParser.getTestDataMap().get("Header_advanceFunds");
						
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified header display as Advancing Funds from Your Reverse Mortgage");
			} else {
				reportHardFail("verify header display as Advancing Funds from Your Reverse Mortgage failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonQuestionPageVerify", "Unable to verify header display as Advancing Funds from Your Reverse Mortgage", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify header display as Advancing Funds from Your Reverse Mortgage");
		}
	}

	@When("i click on question when will I receive my monthly payment if I have elected EFT\\/Direct Deposit? If I receive a check in the mail?")
	public void i_click_on_question_when_will_I_receive_my_monthly_payment_if_I_have_elected_EFT_Direct_Deposit_If_I_receive_a_check_in_the_mail() {
		try {
			webActions.clickElement(commonQuestionsPage.GetQuestion_withSubheader_Element("Advancing Funds from Your Reverse Mortgage", "Monthly Payments", "When will I receive my monthly payment if I have elected EFT/Direct Deposit? If I receive a check in the mail?"));
			reportPass("Clicked on question when will I receive my monthly payment if I have elected EFT\\\\/Direct Deposit? If I receive a check in the mail?");
		} catch (Exception e) {
			LogUtility.logException("CommonQuestions page",
					"Unable to click on question when will I receive my monthly payment if I have elected EFT\\\\/Direct Deposit? If I receive a check in the mail?", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to click on question when will I receive my monthly payment if I have elected EFT\\\\/Direct Deposit? If I receive a check in the mail?");
		}
	}

	@Then("verify question should get expanded and answer should be displayed as All monthly payments etc")
	public void verify_question_should_get_expanded_and_answer_should_be_displayed_as_All_monthly_payments_etc() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetAnswer_withSubheader_Element("Advancing Funds from Your Reverse Mortgage", "Monthly Payments", "When will I receive my monthly payment if I have elected EFT/Direct Deposit? If I receive a check in the mail?"));
			String expect = jsonDataParser.getTestDataMap().get("Answer_advanceFunds_Monthlystmts_EFTDepos");
						
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified question should get expanded and answer should be displayed as All monthly payments etc");
			} else {
				reportHardFail("verify question should get expanded and answer should be displayed as All monthly payments etc failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonQuestionPageVerify", "Unable to verify question should get expanded and answer should be displayed as All monthly payments etc", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify question should get expanded and answer should be displayed as All monthly payments etc");
		}
	}
	
	@Then("verify the subheader is displayed as EFT\\/Direct Deposit")
	public void verify_the_subheader_is_displayed_as_EFT_Direct_Deposit() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetSubheader_Element("Advancing Funds from Your Reverse Mortgage","EFT/Direct Deposit"));
			String expect = jsonDataParser.getTestDataMap().get("Subheader_EFTDirectDeposit");
						
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified the subheader is displayed as EFTDirectDeposit");
			} else {
				reportHardFail("verify the subheader is displayed as EFTDirectDeposit failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonQuestionPageVerify", "Unable to verify the subheader is displayed as EFTDirectDeposit", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify the subheader is displayed as EFTDirectDeposit");
		}
	}

	@When("i click on question How long does it take to set up or change my EFT\\/Direct Deposit information?")
	public void i_click_on_question_How_long_does_it_take_to_set_up_or_change_my_EFT_Direct_Deposit_information() {
		try {
			webActions.clickElement(commonQuestionsPage.GetQuestion_withSubheader_Element("Advancing Funds from Your Reverse Mortgage", "EFT/Direct Deposit", "How long does it take to set up or change my EFT/Direct Deposit information?"));
			reportPass("Clicked on question How long does it take to set up or change my EFT");
		} catch (Exception e) {
			LogUtility.logException("CommonQuestions page",
					"Unable to click How long does it take to set up or change my EFT", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to click How long does it take to set up or change my EFT");
		}
	}

	@Then("verify question should get expanded and answer should be displayed as turn time is typically etc")
	public void verify_question_should_get_expanded_and_answer_should_be_displayed_as_turn_time_is_typically_etc() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetAnswer_withSubheader_Element("Advancing Funds from Your Reverse Mortgage", "EFT/Direct Deposit", "How long does it take to set up or change my EFT/Direct Deposit information?"));
			String expect = jsonDataParser.getTestDataMap().get("Answer_turntimeis5days");
						
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified question should get expanded and answer should be displayed as turn time is typically etc");
			} else {
				reportHardFail("verify question should get expanded and answer should be displayed as turn time is typically etc failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonQuestionPageVerify", "Unable to verify question should get expanded and answer should be displayed as turn time is typically etc", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify question should get expanded and answer should be displayed as turn time is typically etc");
		}
	}
	
	@Then("verify the subheader is displayed as Payment Plan Changes \\(PPCs)")
	public void verify_the_subheader_is_displayed_as_Payment_Plan_Changes_PPCs() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetSubheader_Element("Advancing Funds from Your Reverse Mortgage","Payment Plan Changes (PPCs)"));
			String expect = jsonDataParser.getTestDataMap().get("Subheader_PaymentPlanChanges");
						
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified the subheader is displayed as Payment plan changes ppcs");
			} else {
				reportHardFail("verify the subheader is displayed as Payment plan changes ppcs");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonQuestionPageVerify", "Unable to verify the subheader is displayed as Payment plan changes ppcs", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify the subheader is displayed as Payment plan changes ppcs");
		}
	}

	@When("i click on question What types of Payment Plans are available?")
	public void i_click_on_question_What_types_of_Payment_Plans_are_available() {
		try {
			webActions.clickElement(commonQuestionsPage.GetQuestion_withSubheader_Element("Advancing Funds from Your Reverse Mortgage", "Payment Plan Changes (PPCs)", "What types of Payment Plans are available?"));
			reportPass("Clicked on question What types of Payment Plans are available?");
		} catch (Exception e) {
			LogUtility.logException("CommonQuestions page",
					"Unable to click What types of Payment Plans are available?", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to click What types of Payment Plans are available?");
		}
	}

	@Then("verify question should get expanded and answer should be displayed as for most reverse mortagages etc")
	public void verify_question_should_get_expanded_and_answer_should_be_displayed_as_for_most_reverse_mortagages_etc() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetAnswer_withSubheader_Element("Advancing Funds from Your Reverse Mortgage", "Payment Plan Changes (PPCs)", "What types of Payment Plans are available?"));
			String expect = jsonDataParser.getTestDataMap().get("Answer_for_PaymentPlans");
			
			actual = actual.replace("\n", "").replace("\r", "");
			expect = expect.replace("\n", "").replace("\r", "");
			
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified question should get expanded and answer should be displayed as for most reverse mortagages etc");
			} else {
				reportHardFail("verify question should get expanded and answer should be displayed as for most reverse mortagages etc failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonQuestionPageVerify", "Unable to verify question should get expanded and answer should be displayed as for most reverse mortagages etcetc", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify question should get expanded and answer should be displayed as for most reverse mortagages etc");
		}
	}
	
	@Then("verify the header display as Statements, Loan Documents, and Fees")
	public void verify_the_header_display_as() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetHeaderElement("Statements, Loan Documents, and Fees"));
			String expect = jsonDataParser.getTestDataMap().get("Header_Sttments_loan_fees");
						
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified header display as Statements, Loan Documents, and Fees");
			} else {
				reportHardFail("verify header display as Statements, Loan Documents, and Fees failed");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonQuestionPageVerify", "Unable to verify header display as Statements, Loan Documents, and Fees", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify header display as Statements, Loan Documents, and Fees");
		}
	}

	@Then("verify the subheader is displayed as Receiving Loan Documents")
	public void verify_the_subheader_is_displayed_as_Receiving_Loan_Documents() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetSubheader_Element("Statements, Loan Documents, and Fees","Receiving Loan Documents"));
			String expect = jsonDataParser.getTestDataMap().get("Subheader_ReceivingLoanDoc");
						
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified the subheader is displayed as Receiving Loan Documents");
			} else {
				reportHardFail("verify the subheader is displayed as Receiving Loan Documents");
			}
		} catch (Exception e) {
			reportHardFail("Unable to verify the subheader is displayed as Receiving Loan Documents");
		}
	}

	@When("i click on question I need to request a copy of my loan document\\(s)")
	public void i_click_on_question_I_need_to_request_a_copy_of_my_loan_document_s() {
		try {
			webActions.clickElement(commonQuestionsPage.GetQuestion_withSubheader_Element("Statements, Loan Documents, and Fees","Receiving Loan Documents", "I need to request a copy of my loan document(s)."));
			reportPass("Clicked on question I need to request a copy of my loan document");
		} catch (Exception e) {
			reportHardFail("Unable to click I need to request a copy of my loan document");
		}
	}

	@Then("verify answer should be displayed as Document requests may be etc")
	public void verify_answer_should_be_displayed_as_Document_requests_may_be_etc() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetAnswer_withSubheader_Element("Statements, Loan Documents, and Fees","Receiving Loan Documents", "I need to request a copy of my loan document(s)."));
			String expect = jsonDataParser.getTestDataMap().get("Answer_for_CorpyOfLoanDoc");
			
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified answer should be displayed as Document requests may be etc");
			} else {
				reportHardFail("verify answer should be displayed as Document requests may be etc failed");
			}
		} catch (Exception e) {
			reportHardFail("Unable to verify answer should be displayed as Document requests may be etc");
		}
	}
	
	@Then("verify the subheader is displayed as Loan Terminology and Numbers")
	public void verify_the_subheader_is_displayed_as_Loan_Terminology_and_Numbers() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetSubheader_Element("Statements, Loan Documents, and Fees","Loan Terminology and Numbers"));
			String expect = jsonDataParser.getTestDataMap().get("Subheader_LoanTerminology");
						
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified the subheader is displayed as Loan Terminology and Numbers");
			} else {
				reportHardFail("verify the subheader is displayed as Loan Terminology and Numbers");
			}
		} catch (Exception e) {
			reportHardFail("Unable to verify the subheader is displayed as Loan Terminology and Numbers");
		}
	}

	@When("i click on question What is the Current Outstanding Principal Balance?")
	public void i_click_on_question_What_is_the_Current_Outstanding_Principal_Balance() {
		try {
			webActions.clickElement(commonQuestionsPage.GetQuestion_withSubheader_Element("Statements, Loan Documents, and Fees","Loan Terminology and Numbers","What is the Current Outstanding Principal Balance?"));
			reportPass("Clicked on question What is the Current Outstanding Principal Balance?");
		} catch (Exception e) {
			reportHardFail("Unable to click What is the Current Outstanding Principal Balance?");
		}
	}

	@Then("verify answer should be displayed as The total amount owed as of current statement.")
	public void verify_answer_should_be_displayed_as_The_total_amount_owed_as_of_current_statement() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetAnswer_withSubheader_Element("Statements, Loan Documents, and Fees","Loan Terminology and Numbers","What is the Current Outstanding Principal Balance?"));
			String expect = jsonDataParser.getTestDataMap().get("Answer_For_CurrentOutstanding");
			
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified answer should be displayed as The total amount owed as of current statement.");
			} else {
				reportHardFail("verify answer should display as The total amount owed as of current statement. failed");
			}
		} catch (Exception e) {
			reportHardFail("Unable to verify answer should be displayed as The total amount owed as of current statement.");
		}
	}
	
	@Then("verify the subheader is displayed as Interest and Loan Fees")
	public void verify_the_subheader_is_displayed_as_Interest_and_Loan_Fees() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetSubheader_Element("Statements, Loan Documents, and Fees","Interest and Loan Fees"));
			String expect = jsonDataParser.getTestDataMap().get("Subheader_IntereLoanFees");
						
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified the subheader is displayed as Loan Terminology and Numbers");
			} else {
				reportHardFail("verify the subheader is displayed as Loan Terminology and Numbers");
			}
		} catch (Exception e) {
			reportHardFail("Unable to verify the subheader is displayed as Loan Terminology and Numbers");
		}
	}

	@When("i click on question What is the Interest Rate Change Notice and where can I find it?")
	public void i_click_on_question_What_is_the_Interest_Rate_Change_Notice_and_where_can_I_find_it() {
		try {
			webActions.clickElement(commonQuestionsPage.GetQuestion_withSubheader_Element("Statements, Loan Documents, and Fees","Interest and Loan Fees","What is the Interest Rate Change Notice and where can I find it?"));
			reportPass("Clicked on question What is the Current Outstanding Principal Balance?");
		} catch (Exception e) {
			reportHardFail("Unable to click What is the Current Outstanding Principal Balance?");
		}
	}

	@Then("verify If your loan has an adjustable interest rate \\(ARM), the change notice etc")
	public void if_your_loan_has_an_adjustable_interest_rate_ARM_the_change_notice_etc() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetAnswer_withSubheader_Element("Statements, Loan Documents, and Fees","Interest and Loan Fees","What is the Interest Rate Change Notice and where can I find it?"));
			String expect = jsonDataParser.getTestDataMap().get("Answer_InterestLoanFees");
			
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified answer should be displayed as The total amount owed as of current statement.");
			} else {
				reportHardFail("verify answer should display as The total amount owed as of current statement. failed");
			}
		} catch (Exception e) {
			reportHardFail("Unable to verify answer should be displayed as The total amount owed as of current statement.");
		}
	}
	
	@Then("verify the subheader is displayed as MIP -- Mortgage Insurance Premium")
	public void verify_the_subheader_is_displayed_as_MIP_Mortgage_Insurance_Premium() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetSubheader_Element("Statements, Loan Documents, and Fees","MIP -- Mortgage Insurance Premium"));
			String expect = jsonDataParser.getTestDataMap().get("Subheader_MIP");
						
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified the subheader is displayed as MIP -- Mortgage Insurance Premium");
			} else {
				reportHardFail("verify the subheader is displayed as MIP -- Mortgage Insurance Premium");
			}
		} catch (Exception e) {
			reportHardFail("Unable to verify the subheader is displayed as MIP -- Mortgage Insurance Premium");
		}
	}

	@When("i click on question Why do I have to pay MIP on my HECM loan?")
	public void i_click_on_question_Why_do_I_have_to_pay_MIP_on_my_HECM_loan() {
		try {
			webActions.clickElement(commonQuestionsPage.GetQuestion_withSubheader_Element("Statements, Loan Documents, and Fees","MIP -- Mortgage Insurance Premium","Why do I have to pay MIP on my HECM loan?"));
			reportPass("Clicked on question Why do I have to pay MIP on my HECM loan?");
		} catch (Exception e) {
			reportHardFail("Unable to click on question Why do I have to pay MIP on my HECM loan?");
		}
	}

	@Then("verify answer should be displayed as MIP \\(Mortgage Insurance Premium) is a fee etc")
	public void verify_answer_should_be_displayed_as_MIP_Mortgage_Insurance_Premium_is_a_fee_etc() {
		try {
			String actual = webActions.getText(commonQuestionsPage.GetAnswer_withSubheader_Element("Statements, Loan Documents, and Fees","MIP -- Mortgage Insurance Premium","Why do I have to pay MIP on my HECM loan?"));
			String expect = jsonDataParser.getTestDataMap().get("Answer_MIP");
			
			if (expect.contentEquals(actual)) 
					{
				reportPass("Verified answer should be displayed as MIP (Mortgage Insurance Premium) is a fee etc");
			} else {
				reportHardFail("verify answer should display as MIP (Mortgage Insurance Premium) is a fee etc. failed");
			}
		} catch (Exception e) {
			reportHardFail("Unable to verify answer should be displayed as MIP (Mortgage Insurance Premium) is a fee etc");
		}
	}
}
