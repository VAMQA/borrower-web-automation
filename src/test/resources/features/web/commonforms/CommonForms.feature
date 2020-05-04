#Author: Nagasrinivas
#Date:
#Modified By:
@CommonForms
Feature: Common Forms

  #TestcaseName  : BP_TC01_myLoan_UI_Verify details in My Loan Page
  @Smoke
  Scenario: Verify that user is able to navigate to Common Forms page successfully
    Given i load testdata from: "CommonFormsData.json", "CommonFormsValidationData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page should display header as my loan
    When i click on common forms button
    Then verify the landing page displays header as How to send us a form
    And verify navigational options should be displayed to the top right
    And verify the static text present at the top left of the page

  #TestCaseName : BP_TC17_commonForms_FUN_Verify that LOC Advance Request form can be uploaded successfully
  @Smoke2
  Scenario: Verify that user is able to navigate to Common Forms page successfully
    Given i load testdata from: "CommonFormsData.json", "CommonFormsValidationData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page should display header as my loan
    When i click on common forms button
    Then verify the landing page displays header as How to send us a form
    And verify the static text present at the top left of the page
    And verify the static text as Send from a computer or smart phone and sub content in send item container
    When i click on upload now button
    Then user navigate to Form Upload Page label should be validate
    When i click on select form button
    When i give the upload document path in available popup
    Then verify the text as Electronic_Fund_Transfer_Direct_Deposit_Form.pdf should display
    When i select LOC Advance Request from Select type of form
    When i click on upload button
    Then verify the successfully upload message

  #TestCaseName : BP_TC18_commonForms_FUN_Verify that Occupancy Certification form can be uploaded successfully
  @Smoke
  Scenario: Verify that user is able to navigate to Common Forms page successfully
    Given i load testdata from: "CommonFormsData.json", "CommonFormsValidationData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page should display header as my loan
    When i click on common forms button
    Then verify the landing page displays header as How to send us a form
    And verify the static text present at the top left of the page
    And verify the static text as Send from a computer or smart phone and sub content in send item container
    When i click on upload now button
    Then user navigate to Form Upload Page label should be validate
    When i click on select form button
    When i give the upload document path in available popup
    Then verify the text as Electronic_Fund_Transfer_Direct_Deposit_Form.pdf should display
    When i select occupancy certificate from Select type of form
    When i click on upload button
    Then verify the successfully upload message

  #TestCaseName : BP_TC20_commonForms_FUN_Verify that Repairs Extension Request form can be uploaded successfully
  @Smoke
  Scenario: Verify that user is able to navigate to Common Forms page successfully
    Given i load testdata from: "CommonFormsData.json", "CommonFormsValidationData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page should display header as my loan
    When i click on common forms button
    Then verify the landing page displays header as How to send us a form
    And verify the static text present at the top left of the page
    And verify the static text as Send from a computer or smart phone and sub content in send item container
    When i click on upload now button
    Then user navigate to Form Upload Page label should be validate
    When i click on select form button
    When i give the upload document path in available popup
    Then verify the text as Electronic_Fund_Transfer_Direct_Deposit_Form.pdf should display
    When i select repairs extension request from Select type of form
    When i click on upload button
    Then verify the successfully upload message

  #TestCaseName : BP_TC23_commonForms_FUN_Verify that  Request for Reverse Mortgage Payoff Quote form can be uploaded successfully
  @Smoke
  Scenario: Verify that user is able to navigate to Common Forms page successfully
    Given i load testdata from: "CommonFormsData.json", "CommonFormsValidationData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page should display header as my loan
    When i click on common forms button
    Then verify the landing page displays header as How to send us a form
    And verify the static text present at the top left of the page
    And verify the static text as Send from a computer or smart phone and sub content in send item container
    When i click on upload now button
    Then user navigate to Form Upload Page label should be validate
    When i click on select form button
    When i give the upload document path in available popup
    Then verify the text as Electronic_Fund_Transfer_Direct_Deposit_Form.pdf should display
    When i select request for reverse mortage payoff quote from select type of form
    When i click on upload button
    Then verify the successfully upload message

  #TestCaseName : BP_TC25_commonForms_FUN_Verify that  Tax Payment Request form can be uploaded successfully
  @Smoke
  Scenario: Verify that user is able to navigate to Common Forms page successfully
    Given i load testdata from: "CommonFormsData.json", "CommonFormsValidationData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page should display header as my loan
    When i click on common forms button
    Then verify the landing page displays header as How to send us a form
    And verify the static text present at the top left of the page
    And verify the static text as Send from a computer or smart phone and sub content in send item container
    When i click on upload now button
    Then user navigate to Form Upload Page label should be validate
    When i click on select form button
    When i give the upload document path in available popup
    Then verify the text as Electronic_Fund_Transfer_Direct_Deposit_Form.pdf should display
    When i select tax payment request from Select type of form
    When i click on upload button
    Then verify the successfully upload message

  #TestCaseName : BP_TC26_commonForms_FUN_Verify that  Short Sale form can be uploaded successfully
  @Smoke
  Scenario: Verify that user is able to navigate to Common Forms page successfully
    Given i load testdata from: "CommonFormsData.json", "CommonFormsValidationData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page should display header as my loan
    When i click on common forms button
    Then verify the landing page displays header as How to send us a form
    And verify the static text present at the top left of the page
    And verify the static text as Send from a computer or smart phone and sub content in send item container
    When i click on upload now button
    Then user navigate to Form Upload Page label should be validate
    When i click on select form button
    When i give the upload document path in available popup
    Then verify the text as Electronic_Fund_Transfer_Direct_Deposit_Form.pdf should display
    When i select short sale from Select type of form
    When i click on upload button
    Then verify the successfully upload message

  #TestCaseName : BP_TC27_commonForms_FUN_Verify that  Third Party Authorization form can be uploaded successfully
  @Smoke
  Scenario: Verify that user is able to navigate to Common Forms page successfully
    Given i load testdata from: "CommonFormsData.json", "CommonFormsValidationData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    Then verify the landing page should display header as my loan
    When i click on common forms button
    Then verify the landing page displays header as How to send us a form
    And verify the static text present at the top left of the page
    And verify the static text as Send from a computer or smart phone and sub content in send item container
    When i click on upload now button
    Then user navigate to Form Upload Page label should be validate
    When i click on select form button
    When i give the upload document path in available popup
    Then verify the text as Electronic_Fund_Transfer_Direct_Deposit_Form.pdf should display
    When i select third party authorization from Select type of form
    When i click on upload button
    Then verify the successfully upload message
