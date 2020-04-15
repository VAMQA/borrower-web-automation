package com.cl.borrower_web.steps;

import java.util.Map;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.borrower_web.pages.CommonPage;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;
import com.cl.borrower_web.testbases.BorrowerTestBase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonSteps extends ObjectBase {

	CommonPage commonpage = new CommonPage();
	public String fileName = "";
	public String testCaseName = "";

	@Given("I load testdata from: {string}, {string}")
	public void i_load_testdata_from(String fileName, String testCaseName) throws Exception {
		jsonDataParser.parseJsonTestData(fileName, testCaseName);
	}

	@Given("I load multiple testdata from: {string}, {string}, {string}")
	public void i_load_multiple_testdata_from(String fileName, String testCaseName, String testDataName)
			throws Exception {
		testDataMap = jsonDataParser.parseJsonTestData(fileName, testCaseName, testDataName);
	}

	@Given("I load Environment specific testdata from: {string}, {string}, {string}")
	public void i_load_Environment_specific_testdata_from(String fileName, String testCaseName, String environmentName)
			throws Exception {
		if (environmentName.equalsIgnoreCase("pom.xml"))
			environmentName = System.getProperty("environment");
		jsonDataParser.parseJsonTestDataByEnvironment(fileName, testCaseName, environmentName);

	}

	@Given("I load Environment specific multiple testdata from: {string}, {string}, {string}, {string}")
	public void i_load_Environment_specific_multiple_testdata_from(String fileName, String testCaseName,
			String environmentName, String testDataName) throws Exception {
		if (environmentName.equalsIgnoreCase("pom.xml"))
			environmentName = System.getProperty("environment");
		jsonDataParser.parseJsonTestDataByEnvironment(fileName, testCaseName, environmentName, testDataName);
	}

	@When("^I Enter username \"([^\"]*)\"$")
	public void i_Enter_username(String userKey) throws Throwable {
		String userName = BorrowerTestBase.envProps.getProperty(userKey);
		boolean flag = commonpage.enterUserName(userName);
		if (flag)
			reportPass("Entered the username {" + userName + "}");
		else
			reportHardFail(
					"Incorrect username entered, Terminating execution. Please verify the username and re-execute the script.");
	}

	@And("^I refresh the page$")
	public void pageRefresh() {
		driver.navigate().refresh();
	}

	@When("^I navigate back to the previous page$")
	public void pageNavigateBack() {
		waits.waitForPageReadyState();
		driver.navigate().back();
	}

	@Then("I switch to the {string} index frame")
	public void i_switch_to_the_index_frame(String index) {
		if (commonpage.switchToFrameByIndex(index))
			reportPass("Switched to " + index + " frame in page");
		else
			reportHardFail("Not switched to " + index + " frame in page");
	}

	@Then("I switch back to default")
	public void i_switch_back_to_default() {
		if (commonpage.switchToDefaultContent())
			reportPass("Switched to default content in page");
		else
			reportHardFail("Not switched to default content in page");
	}

	@When("I switch to child window")
	public void i_switch_to_child_window() {
		if (commonpage.switchToChildWindow())
			reportPass("Switched to Child Window");
		else
			reportHardFail("Failed in switch to Child Window");
	}

	@When("I switch back to main window")
	public void i_switch_back_to_main_window() {
		if (commonpage.switchToParentWindow())
			reportPass("Switched to Parent Window");
		else
			reportHardFail("Failed in switch to parent Window");
	}

}
