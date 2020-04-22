package com.cl.borrower_web.pages;

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
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Property Address')]")
	public WebElement propertyAddress;
	
	@FindBy(how = How.XPATH, using = "//div[@class='borrower-address']//p[1]")
	public WebElement propertyAddressLineOne;
	
	@FindBy(how = How.XPATH, using = "//div[@class='borrower-address']//p[2]")
	public WebElement propertyAddressLineTwo;
	
	 
	//div[@class='borrower-address']//p[1]
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Loan Information')]")
	public WebElement loanInformation;
	

	
	
	@FindBy(how = How.XPATH, using = "//div[@class='borrower-account']//p[1]")
	public WebElement accountNumber;
	
	@FindBy(how = How.XPATH, using = "//div[@class='borrower-account']//p[2]")
	public WebElement LoanType;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'My Loan')]")
	public WebElement myLoanTab;
	
	@FindBy(how = How.CSS, using = "a[aria-label='common questions']")
	public WebElement commonQuestionsTab;
	
	@FindBy(how = How.CSS, using = "a[aria-label='common forms']")
	public WebElement commonFormTab;
	
	@FindBy(how = How.ID, using = "title")
	public WebElement commonQuestionsText;
	
	@FindBy(how = How.ID, using = "my-loan-tabs-tab-loan-details")
	public WebElement loanDetailsTab;
	
	@FindBy(how = How.ID, using = "my-loan-tabs-tab-borrower-details")
	public WebElement borrowerDetailsTab;
	
	@FindBy(how = How.ID, using = "my-loan-tabs-tab-statements")
	public WebElement MonthlyStatementTab;
	
	@FindBy(how = How.ID, using = "my-loan-tabs-tab-transaction-history")
	public WebElement TransactionHistoryTab;
	
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Current Net Principal Limit')]")
	public WebElement currentNetPrincipalLimitText;
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Current Net Principal Limit')]//following::p[1]")
	public WebElement currentNetPrincipalLimitValue;
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Current Available Line-of-Credit')]//following::p[1]")
	public WebElement CurrentAvailableLineofCreditValue;
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Current Total Loan Balance')]//following::p[1]")
	public WebElement CurrentTotalLoanBalanceValue;
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Interest Rate')]//following::p[1]")
	public WebElement InterestRateValue;
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Set Aside Funds')]//following::p[1]")
	public WebElement SetAsideFundsValue;
	
	
	
	
	
	
	
	
	
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Your Profile')]//following::p[1]")
	public WebElement borrowerDetailsName;
	
	@FindBy(how = How.XPATH, using = "	//a[contains(text(), 'View All Transactions')]")
	public WebElement ViewAllTransactionsLink;


	// Borrower Details
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Your Profile')]")
	public WebElement BorDetYourProfile;
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Other Borrowers')]")
	public WebElement BorDetOtherBorrowers;
	
	
	
}