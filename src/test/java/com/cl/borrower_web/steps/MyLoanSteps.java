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

public class MyLoanSteps extends ObjectBase {

	LoginPage loginPage = new LoginPage();
	MyLoanPage myLoanPage = new MyLoanPage();
	CommonFormsPage commonFormsPage = new CommonFormsPage();
	FormUploadPage formUploadPage = new FormUploadPage();
	
	@When("User Click on Common Forms button")
	public void user_Click_on_Common_Forms_button() {
	    try {
	    	Thread.sleep(2000);
	    	if(myLoanPage.commonFormsTab.isEnabled())
	    	{
	    		myLoanPage.commonFormsTab.click();
	    		reportPass("Able to click on Common forms tab in My loan Page", true);	
	    	}
	    }catch(Exception e){
	    	reportFail("Unable to click on Common forms tab in My loan Page", false);
	    }
	}
	
	@When("User Click on Common Questions button in My Loan Page")
	public void user_Click_on_Common_Questions_button_in_My_Loan_Page() {
		try {
	    	Thread.sleep(2000);
	    	if(myLoanPage.commonQuestionsTab.isEnabled())
	    	{
	    		myLoanPage.commonQuestionsTab.click();
	    		reportPass("Able to click on Common questions tab in My loan Page", true);	
	    	}
	    }catch(Exception e){
	    	reportFail("Unable to click on Common questions tab in My loan Page", false);
	    }
	}

		
}
