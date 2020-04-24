@MyLoan
Feature: Borrower portal my loan

	#TestcasName  : BP_TC01_myLoan_UI_Verify details in My Loan Page
	@BP_TC01 @Smoke
	Scenario: In borrower portal verify details in my loan page
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enters username and password and click on signin button
    Then verify the landing page displays header as my loan
    Then verify navigational options should be displayed to the top right
    Then property address and loan information verify
    Then verify loan information account number
    Then click on transaction history tab
    Then click on monthly statement tab
    Then click on borrower details tab
    Then click on loan details tab
		Then verify recent transactions details
		
		
		
	#TestcasName :BP_TC02_myLoan_UI_Verify Property details in My Loan Page
	
	@BP_TC02
	Scenario: In myloan verify property details in myloan page
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enters username and password and click on signin button
    Then verify the landing page displays header as my loan
    Then property address and loan information verify
    Then verify property address details
    
    
  #TestcasName :BP_TC03_myLoan_UI_Verify Loan Information details in My Loan Page
	
	@BP_TC03
	Scenario: In myoan verify property details in myloan page
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enters username and password and click on signin button
    Then verify the landing page displays header as my loan
    Then property address and loan information verify
    Then verify loan information details
    
    
	#TestcasName :BP_TC04_myLoan_UI_Verify Loan Details tab  in My Loan Page
	
	@BP_TC04 @Smoke
	Scenario: In myloan verify property details in myloan Page
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enters username and password and click on signin button
    Then verify the landing page displays header as my loan
    Then click on transaction history tab
    Then click on monthly statement tab
    Then click on borrower details tab
    Then click on loan details tab
    Then verify amount displayed for field current net principal limit
		Then verify amount displayed for field current available line of credit
		Then verify amount displayed for field current total loan balance
		Then verify amount displayed for field interest rate
		Then verify amount displayed for field set aside funds



	#TestcasName :BP_TC05_myLoan_UI_Verify Borrower Details tab  in My Loan Page
	
	@BP_TC05 @Smoke
	Scenario: In myloan verify borrower details tab  in my loan page
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enters username and password and click on signin button
    Then verify the landing page displays header as my loan
    Then click on transaction history tab
    Then click on monthly statement tab
    Then click on borrower details tab
    Then click on loan details tab
    Then click on borrower details tab
    Then verify that two sections are displayed in borrower details tab
		
	#TestcasName :BP_TC06_myLoan_UI_Verify Your Profile section in Borrower Details tab
	@BP_TC06 @Smoke
	Scenario: In myloan verify profile section in borrower details tab
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enters username and password and click on signin button
    Then verify the landing page displays header as my loan
    Then click on transaction history tab
    Then click on monthly statement tab
    Then click on borrower details tab
    Then click on loan details tab
    Then click on borrower details tab
    Then verify that two sections are displayed in borrower details tab
    Then verify that three sections are displayed in borrower details your profile tab
    
    
    
	#TestcasName :BP_TC07_myLoan_UI_Verify Personal Detail sub section under My Profile section
	@BP_TC07
	Scenario: In myloan verify personal detail sub section under my profile section
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enters username and password and click on signin button
    Then verify the landing page displays header as my loan
    Then click on transaction history tab
    Then click on monthly statement tab
    Then click on borrower details tab
    Then click on loan details tab
    Then click on borrower details tab
    Then verify that two sections are displayed in borrower details tab
    Then verify that three sections are displayed in borrower details your profile tab
    Then verify that name and dob are displaying in personal details section
    
    
    
	#TestcasName :BP_TC08_myLoan_UI_Verify Contact Information sub section under My Profile section
	@BP_TC08
	Scenario: In myloan verify contact information sub section under my profile section
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enters username and password and click on signin button
    Then verify the landing page displays header as my loan
    Then click on transaction history tab
    Then click on monthly statement tab
    Then click on borrower details tab
    Then click on loan details tab
    Then click on borrower details tab
    Then verify that two sections are displayed in borrower details tab
    Then verify that three sections are displayed in borrower details your profile tab
    Then verify that mobileno and emailid are displaying in contact information section
    
    
 # TestcasName :BP_TC09_myLoan_UI_Verify Mailing Address sub section under My Profile section
	@BP_TC09
	Scenario: In myloan verify mailing address sub section under my profile section
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enters username and password and click on signin button
    Then verify the landing page displays header as my loan
    Then click on transaction history tab
    Then click on monthly statement tab
    Then click on borrower details tab
    Then click on loan details tab
    Then click on borrower details tab
    Then verify that two sections are displayed in borrower details tab
    Then verify that three sections are displayed in borrower details your profile tab 
    Then verify that mailingaddlineone and mailingaddlineone are displaying in mailing address section
    

 # TestcasName :BP_TC10_myLoan_UI_Verify Other Borrower section in Borrower tab
	@BP_TC010
	Scenario: In myloan verify other borrower section under Borrower tab
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enters username and password and click on signin button
    Then verify the landing page displays header as my loan
    Then click on transaction history tab
    Then click on monthly statement tab
    Then click on borrower details tab
    Then click on loan details tab
    Then click on borrower details tab
    Then verify that two sections are displayed in borrower details tab
    Then verify that three sections are displayed in borrower details your profile tab 
    Then verify personal details name are displaying in personal details section

 #TestcasName :BP_TC11_myLoan_UI_Verify the link  below the Other Borrowers section
	@BP_TC011
	Scenario: In myloan verify the link below the Other Borrowers section
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enters username and password and click on signin button
    Then verify the landing page displays header as my loan
    Then click on transaction history tab
    Then click on monthly statement tab
    Then click on borrower details tab
    Then click on loan details tab
    Then click on borrower details tab
    Then verify that two sections are displayed in borrower details tab
    Then verify that three sections are displayed in borrower details your profile tab   
    Then verify borrower details what is required to change my information above link
    
   
       
  #TestcasName :BP_TC12_myLoan_FUN_Verify that link is clickable
	@BP_TC012
	Scenario: In myloan verify the link text is clickable
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enters username and password and click on signin button
    Then verify the landing page displays header as my loan
    Then click on transaction history tab
    Then click on monthly statement tab
    Then click on borrower details tab
    Then click on loan details tab
    Then click on borrower details tab
    Then verify that two sections are displayed in borrower details tab
    Then verify that three sections are displayed in borrower details your profile tab     
    Then verify borrower details what is required to change my information above link
    Then verify on click mailing address and name changes text
  