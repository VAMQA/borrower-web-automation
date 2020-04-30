package com.cl.borrower_web.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

public class MyLoanPage extends ObjectBase {

	public MyLoanPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "title")
	public WebElement pageHeading;
	
	@FindBy(how = How.CSS, using = "a[aria-label='common forms']")
	public WebElement commonFormsTab;
	

	

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
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Your Profile')]//following::p[2]")
	public WebElement borrowerDetailsDob;
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Your Profile')]//following::p[3]")
	public WebElement borDetContInfoMobNo;
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Your Profile')]//following::p[4]")
	public WebElement borDetContInfoEmailid;
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Your Profile')]//following::p[5]")
	public WebElement borDetMailingAddL1;
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Your Profile')]//following::p[6]")
	public WebElement borDetMailingAddL2;
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Your Profile')]//following::p[7]")
	public WebElement borDetOthBorPerDetailsName;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'What is required to change my information above?')]")
	public WebElement borDetChangInfoLink;	
	
	@FindBy(how = How.XPATH, using = "//h3[contains(text(), 'Mailing Address and Name Changes')]")
	public WebElement ComnQsnMailingAdrsandNameChagText;	
	
	
	
	
	@FindBy(how = How.XPATH, using = "	//a[contains(text(), 'View All Transactions')]")
	public WebElement ViewAllTransactionsLink;


	// Borrower Details
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Your Profile')]")
	public WebElement BorDetYourProfile;
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Other Borrowers')]")
	public WebElement BorDetOtherBorrowers;
	
	// Borrower Details -> Your Profile
	
	@FindBy(how = How.XPATH, using = "	//div[@class='mailing-address']//div//div//h5[contains(text(),'Personal Details')]")
	public WebElement BorDetPersonalDetails;


	@FindBy(how = How.XPATH, using = "//h5[contains(text(), 'Contact Information')]")
	public WebElement BorDetContactInformation;

	@FindBy(how = How.XPATH, using = "//h5[contains(text(), 'Mailing Address')]")
	public WebElement BorDetMailingAddress;
	

	//Monthly Statements
	@FindBy(how = How.XPATH, using = "//*[@id='my-loan-tabs-tabpane-statements']/div/div/div[1]/label[contains(text(), 'Choose A Year')]")
	public WebElement ChooseAYearText;
	
	@FindBy(how = How.XPATH, using = "//div[@class='statement-top-row']//div//div//button")
	public WebElement ChooseAYearDropDown;
	
	@FindBy(how = How.XPATH, using = "//*[@id='statement-download']/a")
	public WebElement HowToReadMyStatement;
	

	@FindBy(how = How.XPATH, using = "//*[@id='my-loan-tabs-tabpane-loan-details']/div/div[2]/div/table")
	public WebElement LoanDetailsRecentTransactionTableHeader;

	
	@FindBy(how = How.XPATH, using = "//*[@id='my-loan-tabs-tabpane-loan-details']/div/div[2]/div")
	public WebElement LoanDetailsRecentTransactionTableValues;

	@FindBy(how = How.XPATH, using = "//*[@id='my-loan-tabs-tabpane-transaction-history']/div/div[2]/table")
	public WebElement TransactionHistoryTransactionTableHeader;
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='year-select']//following::button")
	public WebElement TransactionHistorYearDropDown;
	
	@FindBy(how = How.XPATH, using = "//div[@id='year-select']/div/a[4]")
	public WebElement TransactionHistorYearDropDownValues;
	
	@FindBy(how = How.XPATH, using = "//div[@id='year-select']/div/a")
	public List<WebElement> TransactionHistorYearDropDownList;
	
	////div[@id='my-loan-tabs-tabpane-transaction-history']/div/div[2]
	@FindBy(how = How.XPATH, using = "//div[@id='my-loan-tabs-tabpane-transaction-history']/div/div[2][contains(@class, 'table-responsive')]")
	public WebElement TransactionHistoryTransactionTableValues;
	
	
	
	
	public List<String> getVisibleElementText(List<WebElement> TransactionHistorYearDropDownList) {
		List<String> lstOfText = new ArrayList<String>();
		for (WebElement element : TransactionHistorYearDropDownList) {
			if (element.isDisplayed()) {
				lstOfText.add(webActions.getText(element));
			}
		}
		return lstOfText;
	}
	
	// transaction-history year list
	public static List<String> transHistoryYearSet() {	
		 List<String> yearListbackend = Arrays.asList( "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012");
		
		return yearListbackend;	
	}
	
	
	// transaction-history header name list
		public static List<String> headerNamelistbe() {
		
			 List<String> HeaderNamelistbackend = Arrays.asList( "Date", "Transaction", "Amount", "Interest", "MIP", "Servicing Fees", "Trans. Total", "Ending Balance");
			
			return HeaderNamelistbackend;	
		
		}
	
		
	
}

