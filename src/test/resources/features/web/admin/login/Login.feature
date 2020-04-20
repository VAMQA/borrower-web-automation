@admin
Feature: User Login to Borrower Portal.

  #  Test Scenario-1 : Login with Invalid Password
  #  TestcasName     : Demo Test Case -1
  @admin
  Scenario: 
    As a user I Login with invalid password and should get Incorrect username or password massage display

    Given I load testdata from: "BorrowerPortalVerifyData.json", "UserLoginPage"
    Given As a user I logged into borrower portal
    When User enters username and invalid password and click on SignIn button
    Then user should be able to view message as Incorrect username or password

  #Test Scenario-2 : Verify landing page on successful login
  #TestcasName     : Demo Test Case -2
  @admin
  Scenario: 
    As a user I Login with valid email and password and should signin and able to view My Loan heder name

    Given I load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given As a user I logged into borrower portal
    When User enters username and password and click on SignIn button
    Then verify user landing page display's header as My Loan
    Then Verify loan information Account number
