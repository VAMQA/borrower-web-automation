@Login
Feature: My loan details and borrower details verification.

  #Test Scenario-3 : Verify Common question page title
  #TestcasName     : Demo Test Case -3
  @Demo
  Scenario: 
    As a user I Login to celink and verify common question page title

    Given I load testdata from: "BorrowerPortalVerifyData.json", "CommonQuestion"
    Given As a user I logged into borrower portal
    When User enters username and password and click on SignIn button
    Then click on common question menu
    And verify page header common questions title

  #Test Scenario-4 : Validate clicking on button "View Loan Details" takes to My Loan - Loan Details
  #TestcasName     : Demo Test Case -4
  @Demo
  Scenario: 
    As a user I Login to celink and navigated to View Loan Details and verified Current Net Principal Limit text

    Given I load testdata from: "BorrowerPortalVerifyData.json", "MyLoanDetails"
    Given As a user I logged into borrower portal
    When User enters username and password and click on SignIn button
    Then click on Loan Details Tab
    And verify Current Net Principal Limit text

  #Test Scenario-5 : Verify borrower information fields and data for errors
  #TestcasName     : Demo Test Case -4
  @Demo
  Scenario: 
    As a user I Login to celink and navigated to borrower details and verified name

    Given I load testdata from: "BorrowerPortalVerifyData.json", "BorrowerDetails"
    Given As a user I logged into borrower portal
    When User enters username and password and click on SignIn button
    Then click on Borrower Details Tab
    And verify Name in borrower details
