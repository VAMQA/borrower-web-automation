package com.cl.borrower_web.pages.portal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

public class BorrowerPortalVerifyPage extends ObjectBase {

	public BorrowerPortalVerifyPage() {
		PageFactory.initElements(driver, this);
	}


	
	@FindBy(how = How.NAME, using = "email")
	public WebElement userEmailTextBox;
	
	
	@FindBy(how = How.ID, using = "password")
	public WebElement passwordTextBox;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Sign In')]")	
	public WebElement signIn;
	

	@FindBy(how = How.CSS, using = "p[role='alert'] span.error-message")	
	public WebElement incorrectUsernamePassword;
	
	
	@FindBy(how = How.ID, using = "title")
	public WebElement myLoanText;
	
	@FindBy(how = How.XPATH, using = "//div[@class='borrower-account']//p[1]")
	public WebElement accountNumber;
	
	@FindBy(how = How.CSS, using = "a[aria-label='common questions']")
	public WebElement commonQuestionsTab;
	
	@FindBy(how = How.ID, using = "title")
	public WebElement commonQuestionsText;
	
	@FindBy(how = How.ID, using = "my-loan-tabs-tab-loan-details")
	public WebElement loanDetailsTab;
	
	@FindBy(how = How.ID, using = "my-loan-tabs-tab-borrower-details")
	public WebElement borrowerDetailsTab;
	
	
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Current Net Principal Limit')]")
	public WebElement currentNetPrincipalLimitText;
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Your Profile')]//following::p[1]")
	public WebElement borrowerDetailsName;
	
	
	
}