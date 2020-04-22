@LoginMyLoan
Feature: User Login to Borrower Portal.

	#Test Scenario-1 :BP_TC01_myLoan_UI_Verify details in My Loan Page
	#TestcasName     : myLoan_UI_Verify details in My Loan Page
	@BP_TC01
	Scenario: In borrower portal verify details in My Loan Page
		Given I load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given As a user I logged into borrower portal
    When User enters username and password and click on SignIn button
    Then Verify user landing page displays header as My Loan
    Then Verify navigational options should be displayed to the top right
    Then Property Address and Loan Information verify
    Then Verify loan information Account number
    Then click on Transaction History Tab
    Then click on Monthly Statement Tab
    Then click on Borrower Details Tab
    Then click on Loan Details Tab
		Then Verify recent transactions details
		
		
		
	#Test Scenario-2 :BP_TC02_myLoan_UI_Verify Property details in My Loan Page
	#TestcasName     :myLoan_UI_Verify Property details in My Loan Page
	
	@BP_TC02
	Scenario: In MyLoan verify property details in MyLoan Page
		Given I load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given As a user I logged into borrower portal
    When User enters username and password and click on SignIn button
    Then Verify user landing page displays header as My Loan
    Then Property Address and Loan Information verify
    Then verify Property Address details
    
    
  #Test Scenario-3 :BP_TC03_myLoan_UI_Verify Loan Information details in My Loan Page
	#TestcasName     :myLoan_UI_Verify Loan Information details in My Loan Page
	
	@BP_TC03
	Scenario: In MyLoan verify property details in MyLoan Page
		Given I load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given As a user I logged into borrower portal
    When User enters username and password and click on SignIn button
    Then Verify user landing page displays header as My Loan
    Then Property Address and Loan Information verify
    Then Verify Loan Information details
    
    
	#Test Scenario-4 :BP_TC04_myLoan_UI_Verify Loan Details tab  in My Loan Page
	#TestcasName     :myLoan_UI_Verify Loan Details tab  in My Loan Page
	
	@BP_TC04
	Scenario: In MyLoan verify property details in MyLoan Page
		Given I load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given As a user I logged into borrower portal
    When User enters username and password and click on SignIn button
    Then Verify user landing page displays header as My Loan
    Then click on Transaction History Tab
    Then click on Monthly Statement Tab
    Then click on Borrower Details Tab
    Then click on Loan Details Tab
    Then Verify amount displayed for field Current Net Principal Limit
		Then Verify amount displayed for field Current Available Line of Credit
		Then Verify amount displayed for field Current Total Loan Balance
		Then Verify amount displayed for field Interest Rate
		Then Verify amount displayed for field Set Aside Funds



	#Test Scenario-5 :BP_TC05_myLoan_UI_Verify Borrower Details tab  in My Loan Page
	#TestcasName     :myLoan_UI_Verify Borrower Details tab  in My Loan Page
	
	@BP_TC05
	Scenario: In MyLoan verify Borrower Details tab  in My Loan Page
		Given I load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given As a user I logged into borrower portal
    When User enters username and password and click on SignIn button
    Then Verify user landing page displays header as My Loan
    Then click on Transaction History Tab
    Then click on Monthly Statement Tab
    Then click on Borrower Details Tab
    Then click on Loan Details Tab
    Then click on Borrower Details Tab
    Then Verify that two sections are displayed in Borrower details tab
		
		
   # Test Scenario-1 : Login with Invalid Password
   # TestcasName     : Demo Test Case -1
  @Demo 
  Scenario:As a user I Login with invalid password and should get Incorrect username or password massage display
    Given I load testdata from: "BorrowerPortalVerifyData.json", "UserLoginPage"
    Given As a user I logged into borrower portal
    When User enters username and invalid password and click on SignIn button
    Then user should be able to view message as Incorrect username or password

  #Test Scenario-2 : Verify landing page on successful login
  #TestcasName     : Demo Test Case -2
  @Demo
  Scenario:As a user I Login with valid email and password and should signin and able to view My Loan heder name
    Given I load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given As a user I logged into borrower portal
    When User enters username and password and click on SignIn button
    Then verify user landing page displays header as My Loan
    Then Verify loan information Account number   