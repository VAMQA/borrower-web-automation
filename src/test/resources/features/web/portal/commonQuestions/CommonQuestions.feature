#Author: NagaSrinivas
#Date:
#Modified By:
@portal
Feature: Login and Upload a form in common forms Page

  #Test Scenario-3 : Verify the all common questions
  #TestcasName - TC5_Upload Form
  @portal
  Scenario: As a user I want to Login and validate all the questions
    Given I load testdata from: "BorrowerPortalVerifyData.json", "CommonQuestionsBasedOnHeadings"
    Given As a user I logged into borrower portal
    When User enters username and password and click on SignIn button
    When User Click on Common Questions button in My Loan Page
    Then User should navigate to "Common Questions" Page
    And verify all the questions should display
