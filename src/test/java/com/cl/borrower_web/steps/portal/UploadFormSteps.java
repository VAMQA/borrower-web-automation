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

package com.cl.borrower_web.steps.portal;

import java.util.List;
import java.util.Map;

import com.cl.borrower_web.actions.ObjectBase;
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

public class UploadFormSteps extends ObjectBase {

	LoginPage loginPage = new LoginPage();
	MyLoanPage myLoanPage = new MyLoanPage();
	CommonFormsPage commonFormsPage = new CommonFormsPage();
	FormUploadPage formUploadPage = new FormUploadPage();
	

	@When("User should navigate to CommonForms page and click on the Upload now button")
	public void user_should_navigate_to_CommonForms_page_and_click_on_the_Upload_now_button() {
		try {
			Thread.sleep(2000);
	    	if(commonFormsPage.uploadNowButton.isEnabled())
	    	{
	    		commonFormsPage.uploadNowButton.click();
	    		reportPass("Able to click on Upload Now button in  Common forms Page", true);	
	    	}
	    }catch(Exception e){
	    	reportFail("Unable to click on Upload Now button in  Common forms Page", false);
	    }
	}

	@Then("user navigate to {string} Page")
	public void user_navigate_to_Page(String heading) throws InterruptedException {
		Thread.sleep(2000);
		if(formUploadPage.pageHeading.getText().contains(heading))
        {
        	reportPass("validation for the form upload page get success", true);	
        }else {
        	reportFail("validation for the form upload page getting failed", false);
        }
	}

	@When("User click on select form button")
	public void user_click_on_select_form_button() {
		try {
			Thread.sleep(3000);
	    	if(formUploadPage.DragAndDropFormbutton.isEnabled())
	    	{
	    		formUploadPage.DragAndDropFormbutton.click();
	    		reportPass("Able to click on drag and drop button in  upload forms Page", true);	
	    	}
	    }catch(Exception e){
	    	reportFail("Unable to click on drag and drop button in  upload forms Page", false);
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
			LogUtility.logException("Upload Form", "Unable to validate Upload form page", e, LoggingLevel.ERROR,
					true);
			reportHardFail("Unable to verify upload form");
		}
	}

	@Then("User should Upload pop up will open and give the Path and click open")
	public void user_should_Upload_pop_up_will_open_and_give_the_Path_and_click_open() {
		
	    if(formUploadPage.UploadDocument(jsonDataParser.getTestDataMap().get("UploadDocumentPath")))
	    {
	    	reportPass("Document upload get success", true);	
	    }
	    else {
	    	reportFail("Document upload get fail", false);
	    }
	}

	@Then("User should be able to see the text as Electronic_Fund_Transfer_Direct_Deposit_Form.pdf")
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
			LogUtility.logException("Upload Form", "Unable to verify successfully message in upload form page", e, LoggingLevel.ERROR,
					true);
			reportHardFail("Unable to verify upload form");
		} 
	}
	
}
