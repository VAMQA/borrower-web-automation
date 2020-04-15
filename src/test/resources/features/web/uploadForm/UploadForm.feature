#Author: Nagasrinivas
#Date:
#Modified By:
@Demo
Feature: Login and Upload a form in common forms Page

  #Test Scenario-4 : Upload a form in Common forms page
  #TestcasName - TC5_Upload Form
  @Demo
  Scenario: As a user I want to Login and upload documents in common forms page
    Given I load testdata from: "BorrowerPortalVerifyData.json", "CommonFormsPage"
    Given As a user I logged into borrower portal
    When User enters username and password and click on SignIn button
    When User Click on Common Forms button
    And User should navigate to CommonForms page and click on the Upload now button
    Then user navigate to Form Upload Page label should be validate
    When User click on select form button
    Then User should Upload pop up will open and give the Path and click open
    And User should be able to see the text as Electronic_Fund_Transfer_Direct_Deposit_Form.pdf
