/*package com.cl.borrower_web.steps;

import java.util.List;
import java.util.Map;

import com.cl.borrower_web.actions.LoginPageActions;
import com.cl.borrower_web.actions.ObjectBase;
import com.cl.borrower_web.pages.CommonPage;
import com.cl.borrower_web.pages.LoginPage;
import com.cl.borrower_web.testbases.BorrowerTestBase;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class LoginSteps extends ObjectBase {

	LoginPage loginPage = new LoginPage();
	CommonPage commonPage = new CommonPage();
	
	@Given("^As a user I logged into ZeroBank")
	public void As_a_user_I_logged_into_ZeroBank() throws Throwable {

		try {

			waits.waitForPageReadyState();
			reportPass("Navigate to URL");
		} catch (Exception e) {
			LogUtility.logException("Login", "Unable to Login", e, LoggingLevel.ERROR, true);
			reportHardFail("Unable to Login");
		}
	}

}
*/

package com.cl.borrower_web.steps;

import java.util.List;
import java.util.Map;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.borrower_web.pages.BorrowerPortalVerifyPage;
import com.cl.borrower_web.pages.CommonFormsPage;
import com.cl.borrower_web.pages.CommonPage;
import com.cl.borrower_web.pages.FormUploadPage;
import com.cl.borrower_web.pages.LoginPage;
import com.cl.borrower_web.pages.MyLoanPage;
import com.cl.borrower_web.testbases.BorrowerTestBase;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class CommonFormsSteps extends ObjectBase {

	LoginPage loginPage = new LoginPage();
	MyLoanPage myLoanPage = new MyLoanPage();
	CommonFormsPage commonFormsPage = new CommonFormsPage();
	FormUploadPage formUploadPage = new FormUploadPage();
	BorrowerPortalVerifyPage borrowerPortalVerifyPage = new BorrowerPortalVerifyPage();

	@When("User should navigate to CommonForms page and click on the Upload now button")
	public void user_should_navigate_to_CommonForms_page_and_click_on_the_Upload_now_button() {
		try {
			Thread.sleep(2000);
			if (commonFormsPage.uploadNowButton.isEnabled()) {
				commonFormsPage.uploadNowButton.click();
				reportPass("Able to click on Upload Now button in  Common forms Page", true);
			}
		} catch (Exception e) {
			reportFail("Unable to click on Upload Now button in  Common forms Page", false);
		}
	}

	@Then("user navigate to {string} Page")
	public void user_navigate_to_Page(String heading) throws InterruptedException {
		Thread.sleep(2000);
		if (formUploadPage.pageHeading.getText().contains(heading)) {
			reportPass("validation for the form upload page get success", true);
		} else {
			reportFail("validation for the form upload page getting failed", false);
		}
	}

	@When("i click on select form button")
	public void user_click_on_select_form_button() {
		try {
			Thread.sleep(3000);
			if (formUploadPage.DragAndDropFormbutton.isEnabled()) {
				formUploadPage.DragAndDropFormbutton.click();
				reportPass("Able to click on drag and drop button in  upload forms Page", true);
			}
		} catch (Exception e) {
			reportFail("Unable to click on drag and drop button in  upload forms Page", false);
		}
	}
	
	@When("i click on common forms button")
	public void i_click_on_common_forms_button() {
		try {			
			webActions.clickElement(myLoanPage.commonFormsTab);
			reportPass("Able to click on common forms tab");
		} catch (Exception e) {
			LogUtility.logException("Commonform", "Unable to Click on common forms tab", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to Click on common forms tab");
		}
	}

	@Then("verify the landing page should display header as my loan")
	public void verify_the_landing_page_should_display_header_as_my_loan() {

		try {
			waits.staticWait(10000);
			

			if (webActions.getText(borrowerPortalVerifyPage.myLoanText)
					.equalsIgnoreCase(jsonDataParser.getTestDataMap().get("HeaderNameMyLoan"))) {
				reportPass("Verified My Loan text");
			} else {
				reportHardFail("Unable to verify My Loan text");
			}
		} catch (Exception e) {
			LogUtility.logException("CommonPageVerify", "Unable to verify Home Page", e, LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify My Loan text");
		}

	}

	@Then("verify the landing page displays header as How to send us a form")
	public void verify_the_landing_page_displays_header_as_How_to_send_us_a_form() {
		try {
			if (webActions.getText(commonFormsPage.commonFormHeader)
					.contentEquals(jsonDataParser.getTestDataMap().get("commonFormsPageheader"))) {
				reportPass("Common Forms header verification get success");
			} else {
				reportFail("Common Forms header verification get fail -Actual Data :"
						+ webActions.getText(commonFormsPage.commonFormHeader), false);
			}
		} catch (Exception e) {
			reportFail("Unable to validate the common forms page header");
		}
	}

	@Then("verify the static text present at the top left of the page")
	public void verify_the_static_text_present_at_the_top_left_of_the_page() {
		try {
			if (webActions.isDisplayed(commonFormsPage.reverseMortagaeFundingLogo))
				reportPass("Reverse Mortagage funding logo is displayed");
		} catch (Exception e) {
			reportFail("Reverse Mortagage funding logo is not displayed");
		}
	}
	
	@Then("verify the static text as Send from a computer or smart phone and sub content in send item container")
	public void verify_the_static_text_as_Send_from_a_computer_or_smart_phone_and_sub_content_in_send_item_container() {
	    try {
	    	if(webActions.getText(commonFormsPage.sendFormContainerHeader).contentEquals(jsonDataParser.getTestDataMap().get("SendFormContainerHeader")))
	    	{
	    		reportPass("Common forms page send form container Header validation get success");
	    	}
	    	if(webActions.getText(commonFormsPage.sendFormContainerSubHeader).contentEquals(jsonDataParser.getTestDataMap().get("SendFormContainerSubHeader")))
	    	{
	    		reportPass("Common forms page send form container sub Header validation get success");
	    	}
	    	else {
	    		reportFail("validation for the Common forms page send form container get failed");
	    	}
	    }catch(Exception e) {
			reportHardFail("Unable to verify send form container text");
	    }
	}

	@When("i click on upload now button")
	public void i_click_on_upload_now_button() {
	    try {
	    	webActions.clickElement(commonFormsPage.uploadNowButton);
	    	
			reportPass("Able to click on Upload Now button in  Common forms Page", true);
	    }catch(Exception e) {
	    	reportHardFail("Unable to click on upload now button in common forms page");	
	    }
	}

	@Then("user navigate to Form Upload Page label should be validate")
	public void user_navigate_to_Form_Upload_Page_label_should_be_validate() {
		try {
			waits.staticWait(2000);

			if (webActions.getText(formUploadPage.pageHeading)
					.contains(jsonDataParser.getTestDataMap().get("FormUploadPageHeader"))) {
				reportPass("Verified Form Upload Text in Common Forms");
			} else {
				reportHardFail("Unable to verify Form upload text");
			}
		} catch (Exception e) {
			LogUtility.logException("Upload Form", "Unable to validate Upload form page", e, LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify upload form");
		}
	}

	@When("i give the upload document path in available popup")
	public void user_should_Upload_pop_up_will_open_and_give_the_Path_and_click_open() {

		if (formUploadPage.UploadDocument(jsonDataParser.getTestDataMap().get("UploadDocumentPath"))) {
			reportPass("Document upload get success", true);
		} else {
			reportFail("Document upload get fail", false);
		}
	}

	@Then("verify the text as Electronic_Fund_Transfer_Direct_Deposit_Form.pdf should display")
	public void user_should_be_able_to_see_the_text_as_Electronic_Fund_Transfer_Direct_Deposit_Form_pdf() {
		try {
			waits.staticWait(2000);

			if (webActions.getText(formUploadPage.ChosenFileText)
					.contains(jsonDataParser.getTestDataMap().get("ValidateUploadedMessage"))) {
				reportPass("Verified successfull upload message in Common Forms");
			} else {
				reportHardFail("Unable to verify successfully message in upload form page");
			}
		} catch (Exception e) {
			LogUtility.logException("Upload Form", "Unable to verify successfully message in upload form page", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify upload form");
		}
	}
	
	@When("i select LOC Advance Request from Select type of form")
	public void i_select_LOC_Advance_Request_from_Select_type_of_form() {
	    try {
	    	webActions.clickElement(commonFormsPage.loc_Advance_Request);
	    	
			reportPass("Able to click on LOC advance request radio button in upload Page", true);
	    }catch(Exception e) {
	    	reportHardFail("unable to click on LOC advance request radio button in upload Page");	
	    }
	}
	
	@When("i select occupancy certificate from Select type of form")
	public void i_select_occupancy_certificate_from_Select_type_of_form() {
	    try {
	    	webActions.clickElement(commonFormsPage.loc_Advance_Request);
	    	
			reportPass("Able to click on occupancy certificate radio button in upload Page", true);
	    }catch(Exception e) {
	    	reportHardFail("unable to click on occupancy certificate radio button in upload Page");	
	    }
	}
	
	@When("i select repairs extension request from Select type of form")
	public void i_select_repairs_extension_request_from_Select_type_of_form() {
	    try {
	    	webActions.clickElement(commonFormsPage.repairsExtensionRequest);
	    	
			reportPass("Able to click on repairs extension request radio button in upload Page", true);
	    }catch(Exception e) {
	    	reportHardFail("unable to click on repairs extension request radio button in upload Page");	
	    }
	}
	
	@When("i select request for reverse mortage payoff quote from select type of form")
	public void i_select_request_for_reverse_mortage_payoff_quote_from_select_type_of_form() {
	    try {
	    	webActions.clickElement(commonFormsPage.requestForReverseMortgagePayoffQuote);
	    	
			reportPass("Able to click on request for reverse mortgage payoff quote radio button in upload Page", true);
	    }catch(Exception e) {
	    	reportHardFail("unable to click on request for reverse mortgage payoff quote radio button in upload Page");	
	    }
	}
	
	@When("i select tax payment request from Select type of form")
	public void i_select_tax_payment_request_from_Select_type_of_form() {
	    try {
	    	webActions.clickElement(commonFormsPage.taxPaymentRequest);
	    	
			reportPass("Able to click on tax payment request radio button in upload Page", true);
	    }catch(Exception e) {
	    	reportHardFail("unable to click on tax payment request radio button in upload Page");	
	    }
	}
	
	@When("i select short sale from Select type of form")
	public void i_select_short_sale_from_Select_type_of_form() {
	    try {
	    	webActions.clickElement(commonFormsPage.shortSale);
	    	
			reportPass("Able to click on short sale radio button in upload Page", true);
	    }catch(Exception e) {
	    	reportHardFail("unable to click on short sale radio button in upload Page");	
	    }
	}
	
	@When("i select third party authorization from Select type of form")
	public void i_select_third_party_authorization_from_Select_type_of_form() {
	    try {
	    	webActions.clickElement(commonFormsPage.thirdPartyAuthorization);
	    	
			reportPass("Able to click on third party authorization radio button in upload Page", true);
	    }catch(Exception e) {
	    	reportHardFail("unable to click on third party authorization radio button in upload Page");	
	    }
	}

	@When("i click on upload button")
	public void i_click_on_upload_button() {
		try {
	    	webActions.clickElement(commonFormsPage.uploadButton);
	    	
			reportPass("Able to click on upload button in upload Page", true);
	    }catch(Exception e) {
	    	reportHardFail("Unable to click on upload button in upload Page");	
	    }
	}
	
	@Then("verify the successfully upload message")
	public void verify_the_successfully_upload_message() {
		try {
			waits.staticWait(1000);
			if (webActions.getText(commonFormsPage.successfullValidationMessage)
					.contains(jsonDataParser.getTestDataMap().get("SuccessfullValidationMessage"))) {
				reportPass("Verified successfull upload message in Common Forms");
			} else {
				reportHardFail("Unable to verify successfully message in upload form page");
			}
		} catch (Exception e) {
			LogUtility.logException("Upload Form", "Unable to verify successfully message in upload form page", e,
					LoggingLevel.ERROR, true);
			reportHardFail("Unable to verify upload message");
		}
	}

}
