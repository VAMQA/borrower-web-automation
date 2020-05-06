@MyLoan
Feature: Borrower portal my loan

	#TestcaseName  : BP_TC01_myLoan_UI_Verify details in My Loan Page
	#Automation Test ID : BP_AUTO_REF_001
	@BP_TC01 @Smoke
	Scenario: In borrower portal verify details in my loan page
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
    Then verify navigational options should be displayed to the top right
    Then verify property address and loan information
    Then verify loan information account number
    When click on transaction history tab
    When click on monthly statement tab
    When click on borrower details tab
    When click on loan details tab
		Then verify recent transactions details		
			
		
	#TestcaseName :BP_TC02_myLoan_UI_Verify Property details in My Loan Page
	#Automation Test ID : BP_AUTO_REF_002
	@BP_TC02 @Regression
	Scenario: In myloan verify property details in myloan page
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
    Then verify property address and loan information
    Then verify property address details
    
    
  #TestcaseName :BP_TC03_myLoan_UI_Verify Loan Information details in My Loan Page
	#Automation Test ID : BP_AUTO_REF_003
	@BP_TC03 @Regression
	Scenario: In myoan verify property details in myloan page
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
    Then verify property address and loan information
    Then verify loan information details
    
    
	#TestcasName :BP_TC04_myLoan_UI_Verify Loan Details tab  in My Loan Page
	#Automation Test ID : BP_AUTO_REF_004
	@BP_TC04 @Smoke
	Scenario: In myloan verify property details in myloan Page
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
    When click on transaction history tab
    When click on monthly statement tab
    When click on borrower details tab
    When click on loan details tab
    Then verify amount displayed for field current net principal limit
		Then verify amount displayed for field current available line of credit
		Then verify amount displayed for field current total loan balance
		Then verify amount displayed for field interest rate
		Then verify amount displayed for field set aside funds


	#TestcaseName :BP_TC05_myLoan_UI_Verify Borrower Details tab  in My Loan Page
	#Automation Test ID : BP_AUTO_REF_005
	@BP_TC05 @Smoke
	Scenario: In myloan verify borrower details tab  in my loan page
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
    When click on transaction history tab
    When click on monthly statement tab
    When click on borrower details tab
    When click on loan details tab
    When click on borrower details tab
    Then verify that two sections are displayed in borrower details tab
		
		
	#TestcaseName :BP_TC06_myLoan_UI_Verify Your Profile section in Borrower Details tab
	#Automation Test ID : BP_AUTO_REF_006
	@BP_TC06 @Smoke
	Scenario: In myloan verify profile section in borrower details tab
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
    When click on transaction history tab
    When click on monthly statement tab
    When click on borrower details tab
    When click on loan details tab
    When click on borrower details tab
    Then verify that two sections are displayed in borrower details tab
    Then verify that three sections are displayed in borrower details your profile tab
    
     
	#TestcaseName :BP_TC07_myLoan_UI_Verify Personal Detail sub section under My Profile section
	#Automation Test ID : BP_AUTO_REF_007
	@BP_TC07 @Regression
	Scenario: In myloan verify personal detail sub section under my profile section
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
    When click on transaction history tab
    When click on monthly statement tab
    When click on borrower details tab
    When click on loan details tab
    When click on borrower details tab
    Then verify that two sections are displayed in borrower details tab
    Then verify that three sections are displayed in borrower details your profile tab
    Then verify that name and dob are displaying in personal details section
    
        
	#TestcaseName :BP_TC08_myLoan_UI_Verify Contact Information sub section under My Profile section
	#Automation Test ID : BP_AUTO_REF_008
	@BP_TC08 @Regression
	Scenario: In myloan verify contact information sub section under my profile section
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
    When click on transaction history tab
    When click on monthly statement tab
    When click on borrower details tab
    When click on loan details tab
    When click on borrower details tab
    Then verify that two sections are displayed in borrower details tab
    Then verify that three sections are displayed in borrower details your profile tab
    Then verify that mobileno and emailid are displaying in contact information section
    
    
  #TestcaseName :BP_TC09_myLoan_UI_Verify Mailing Address sub section under My Profile section
  #Automation Test ID : BP_AUTO_REF_009
	@BP_TC09 @Regression
	Scenario: In myloan verify mailing address sub section under my profile section
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
    When click on transaction history tab
    When click on monthly statement tab
    When click on borrower details tab
    When click on loan details tab
    When click on borrower details tab
    Then verify that two sections are displayed in borrower details tab
    Then verify that three sections are displayed in borrower details your profile tab 
    Then verify that mailingaddlineone and mailingaddlineone are displaying in mailing address section
    

  #TestcaseName :BP_TC10_myLoan_UI_Verify Other Borrower section in Borrower tab
  #Automation Test ID : BP_AUTO_REF_010
	@BP_TC010 @Regression
	Scenario: In myloan verify other borrower section under Borrower tab
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
    When click on transaction history tab
    When click on monthly statement tab
    When click on borrower details tab
    When click on loan details tab
    When click on borrower details tab
    Then verify that two sections are displayed in borrower details tab
    Then verify that three sections are displayed in borrower details your profile tab 
    Then verify personal details name are displaying in personal details section

 #TestcaseName :BP_TC11_myLoan_UI_Verify the link  below the Other Borrowers section
 #Automation Test ID : BP_AUTO_REF_011
 @BP_TC011 @Regression
	Scenario: In myloan verify the link below the Other Borrowers section
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
    When click on transaction history tab
    When click on monthly statement tab
    When click on borrower details tab
    When click on loan details tab
    When click on borrower details tab
    Then verify that two sections are displayed in borrower details tab
    Then verify that three sections are displayed in borrower details your profile tab   
    Then verify borrower details what is required to change my information above link
    
          
  #TestcaseName :BP_TC12_myLoan_FUN_Verify that link is clickable
  #Automation Test ID : BP_AUTO_REF_012
	@BP_TC012 @Regression
	Scenario: In myloan verify the link text is clickable
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
    When click on transaction history tab
    When click on monthly statement tab
    When click on borrower details tab
    When click on loan details tab
    When click on borrower details tab
    Then verify that two sections are displayed in borrower details tab
    Then verify that three sections are displayed in borrower details your profile tab     
    Then verify borrower details what is required to change my information above link
    Then verify on click mailing address and name changes text
    
    
  #TestcaseName :BP_TC13_myLoan_UI_Verify Monthly Statements tab in My Loan page
  #Automation Test ID : BP_AUTO_REF_013
  @BP_TC013 @Smoke
	  Scenario: In monthly statements verify fields
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
    When click on monthly statement tab
    Then verify the field text choose the year
    Then verify default fault year from dropdown
    Then verify the field text how to read my statement 
    
    
  #TestcaseName :BP_TC14_myLoan_UI_Verify that link present in Monthly Statements tab is clickable
  #Automation Test ID : BP_AUTO_REF_014
	@BP_TC014 @Regression
	Scenario: In monthly statements verify the link text is clickable
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
    When click on monthly statement tab
    Then verify the field link how to read my statement is clickable
  
  
  #TestcasName :BP_TC15_myLoan_UI_Verify Recent Transactions in My Loan Page
  #Automation Test ID : BP_AUTO_REF_015
	@BP_TC015 @Regression
	Scenario: In myloan verify recent transactions contains table field names
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
    Then verify property address and loan information
    Then verify loan information account number
    When click on transaction history tab
    When click on monthly statement tab
    When click on borrower details tab
    When click on loan details tab
    Then verify recent transactions contains all the table field names

    
  #TestcaseName :BP_TC16_myLoan_UI_Verify values under Recent Transactions table
  #Automation Test ID : BP_AUTO_REF_016
	@BP_TC016 @Smoke
	Scenario: In myloan verify recent transactions contains table field names and values
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
    Then verify property address and loan information
    Then verify loan information account number
    When click on transaction history tab
    When click on monthly statement tab
    When click on borrower details tab
    When click on loan details tab
    Then verify recent transactions contains all the table field names
    Then verify recent transactions contains all the table field values
    
    
  #TestcaseName :BP_TC17_myLoan_FUN_Navigation to Transaction History Page
  #Automation Test ID : BP_AUTO_REF_017
	@BP_TC017 @Regression
	Scenario: In myloan on click on recent transactions navigate to transaction history table
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
		When click on view all transactions link
		Then verify on click of view all transactions link should navigate to transaction history table
		
			
	#TestcaseName :BP_TC18_myLoan_UI_Verify  Transaction  History Page
  #Automation Test ID : BP_AUTO_REF_018

	@BP_TC018 @Regression
	Scenario: Navigate to transaction history table
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
		When click on transaction history tab
		Then verify default transaction history table header names
		Then verify default year displayed in dropdown
		Then verify default list of year
    When select a year other then default year
		Then verify transaction history header values
    
	#TestcaseName :BP_TC19_myLoan_UI_Verify  Transactions table in  Transaction History Page
  #Automation Test ID : BP_AUTO_REF_019
	@BP_TC019 @Smoke
	Scenario: In transaction history table verify table values
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
		When click on transaction history tab
    Then verify default transaction history table header names
    Then verify transaction history header values 
    
    
  #TestcaseName :BP_TC20_myLoan_UI_Verify  the totals displayed for the columns
  #Automation Test ID : BP_AUTO_REF_20
	@BP_TC020 @Smoke
	Scenario: In transaction history verify total values in the last column
		Given i load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page displays header as my loan
		When click on transaction history tab
		Then verify default transaction history table header names
    Then verify transaction history header values