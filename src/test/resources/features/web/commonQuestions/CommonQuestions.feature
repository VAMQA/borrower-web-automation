#Author: NagaSrinivas
#Date:
#Modified By:
@CommonQuestions
Feature: Login and Upload a form in common forms Page

  #TestCaseName : BP_TC01-commonQuestions_FUN_Navigate to Common questions Page
  @Smoke
  Scenario: Verify that user is able to navigate to Common Questions page successfully
    Given i load testdata from: "CommonQuestionsData.json", "CommonQuestionsTestData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    And i click on common questions button in my loan page
    Then verify the page displays header as common questions
    #And verify navigational options should be displayed to the top right
    And verify the static text present at the top left of the page
    And verify the label of the first topic displayed as popular

  #And verify the static text present at the top left of the page
  #And verify the static text as Send from a computer or smart phone and sub content in send item container
  #When i click on upload now button
  #Then user navigate to Form Upload Page label should be validate
  #When i click on select form button
  #When i give the upload document path in available popup
  #Then verify the text as Electronic_Fund_Transfer_Direct_Deposit_Form.pdf should display
  #When i select third party authorization from Select type of form
  #When i click on upload button
  #Then verify the successfully upload message
  #TestCaseName : BP_TC06-commonQuestions_UI_Verify the question 1 and its associated answer under Popular section
  @Smoke
  Scenario: Verify the question 1 and its associated answer under Popular section
    Given i load testdata from: "CommonQuestionsData.json", "CommonQuestionsTestData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    And i click on common questions button in my loan page
    Then verify the page displays header as common questions
    When i click on common questions button in my loan page
    And verify the label of the first topic displayed as popular
    And verify the Question one displayed under popular section as How do I request an advance from my Line of Credit(LOC)?
    When i click on Question one - How do I request an advance from my Line of Credit(LOC)?
    Then verify the Question one answer should display
    When i click on the link LOC Advance request form
    Then verify LOC advance request form is opend

  #TestCaseName : BP_TC16-commonQuestions_UI_Verify the question1 and its associated answer under Growth of a HECM Loan  sub section
  @Smoke
  Scenario: Verify that question 1 and its associated answer is  displaying correctly under Growth of a HECM Loan  sub section
    Given i load testdata from: "CommonQuestionsData.json", "CommonQuestionsTestData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    And i click on common questions button in my loan page
    Then verify the page displays header as common questions
    When i click on common questions button in my loan page
    And verify the second header dispalay as How Do Reverse Mortgages Work?
    And verify the sub header display as Home ownership under header How Do Reverse Mortgages work
    And verify the question displayed as I was told that my loan might grow What does that mean?
    When i click on question I was told that my loan might grow What does that mean?
    Then verify the ansswer for the question I was told my loan might grow What does that mean?
    Then verify the some part of the text display as bold

  #TestCaseName : BP_TC23-commonQuestions_UI_Verify the question 4 and its associated answer under Requesting Funds  sub section
  @Smoke
  Scenario: Verify that question 4 and its associated answer is  displaying correctly under Requesting Funds  sub section
    Given i load testdata from: "CommonQuestionsData.json", "CommonQuestionsTestData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    And i click on common questions button in my loan page
    Then verify the page displays header as common questions
    When i click on Advancing Funds from Your Reverse Mortgage topic under List of Topics
    Then verify Page contains header subheader 
    Then verify page is navigated to Advancing Funds from Your Reverse Mortgage section present to the right side
    Then verify the subheader is displayed as Requesting Funds
    When i click on question Can an Attorney-in-Fact who has Power of Attorney sign the Line of Credit Advance Request form for the borrower(s)?
    Then verify question should get expanded and answer should be displayed as Yes, the attorney etc

  #TestCaseName : BP_TC29-commonQuestions_UI_Verify the question 2 and its associated answer under Monthly Payments sub section
  @Smoke
  Scenario: Verify that question 2 and its associated answer is  displaying correctly under Monthly Payments  sub section
    Given i load testdata from: "CommonQuestionsData.json", "CommonQuestionsTestData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    And i click on common questions button in my loan page
    Then verify the page displays header as common questions
    When i click on common questions button in my loan page
    Then verify the page displays header as common questions
    When i click on Advancing Funds from Your Reverse Mortgage topic under List of Topics
    Then verify page is navigated to Advancing Funds from Your Reverse Mortgage section present to the right side
    Then verify the subheader is displayed as monthly payments
    When i click on question when will I receive my monthly payment if I have elected EFT/Direct Deposit? If I receive a check in the mail?
    Then verify question should get expanded and answer should be displayed as All monthly payments etc

  #TestCaseName : BP_TC31-commonQuestions_UI_Verify the question 2 and its associated answer under EFT/Direct Deposit sub section
  @Smoke
  Scenario: Verify that question 2 and its associated answer is  displaying correctly under EFT/Direct Deposit sub section
    Given i load testdata from: "CommonQuestionsData.json", "CommonQuestionsTestData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    And i click on common questions button in my loan page
    Then verify the page displays header as common questions
    Then verify the header display as Advancing Funds from Your Reverse Mortgage
    Then verify the subheader is displayed as EFT/Direct Deposit
    When i click on question How long does it take to set up or change my EFT/Direct Deposit information?
    Then verify question should get expanded and answer should be displayed as turn time is typically etc

  #TestCaseName : BP_TC37-commonQuestions_UI_Verify the question 1 and its associated answer under Payment Plan Changes (PPCs) sub section
  @Smoke
  Scenario: Verify that question 1 and its associated answer is  displaying correctly under Payment Plan Changes (PPCs)  sub section
    Given i load testdata from: "CommonQuestionsData.json", "CommonQuestionsTestData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    And i click on common questions button in my loan page
    Then verify the page displays header as common questions
    Then verify the header display as Advancing Funds from Your Reverse Mortgage
    Then verify the subheader is displayed as Payment Plan Changes (PPCs)
    When i click on question What types of Payment Plans are available?
    Then verify question should get expanded and answer should be displayed as for most reverse mortagages etc

  #TestCaseName : BP_TC46-commonQuestions_UI_Verify the question 1 under Receiving Loan Documents subsection
  @Smoke
  Scenario: Verify that subsections are   displaying correctly under Statements, Loan Documents, and Fees section
    Given i load testdata from: "CommonQuestionsData.json", "CommonQuestionsTestData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    And i click on common questions button in my loan page
    Then verify the page displays header as common questions
    Then verify the header display as Statements, Loan Documents, and Fees
    Then verify the subheader is displayed as Receiving Loan Documents
    When i click on question I need to request a copy of my loan document(s)
    Then verify answer should be displayed as Document requests may be etc

  #TestCaseName : BP_TC50-commonQuestions_UI_Verify the question 2 under Loan Terminology and Numbers subsection
  @Smoke
  Scenario: Verify that question 2 and its associated answer is  displaying correctly under Loan Terminology and Numbers  sub section
    Given i load testdata from: "CommonQuestionsData.json", "CommonQuestionsTestData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    And i click on common questions button in my loan page
    Then verify the page displays header as common questions
    Then verify the header display as Advancing Funds from Your Reverse Mortgage
    Then verify the subheader is displayed as Loan Terminology and Numbers
    When i click on question What is the Current Outstanding Principal Balance?
    Then verify answer should be displayed as The total amount owed as of current statement.

  #TestCaseName : BP_TC62-commonQuestions_UI_Verify the question 2 under Interest and Loan Fees subsection
  @Smoke
  Scenario: Verify that question 2  and its associated answer is  displaying correctly under Interest and Loan Fees  sub section
    Given i load testdata from: "CommonQuestionsData.json", "CommonQuestionsTestData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    And i click on common questions button in my loan page
    Then verify the page displays header as common questions
    Then verify the header display as Advancing Funds from Your Reverse Mortgage
    Then verify the subheader is displayed as Interest and Loan Fees
    When i click on question What is the Interest Rate Change Notice and where can I find it?
    Then verify If your loan has an adjustable interest rate (ARM), the change notice etc

  #TestCaseName : BP_TC74-commonQuestions_UI_Verify the question 3 under MIP -- Mortgage Insurance Premium subsection.
  #@CommonQuestionsTest1
  #Scenario: Verify that question 3 and its associated answer is  displaying correctly under MIP -- Mortgage Insurance Premium  sub section
    #Given i load testdata from: "CommonQuestionsData.json", "CommonQuestionsTestData"
    #Given i logged into borrower portal
    #When i enter username and password and click on signin button
    #And i click on common questions button in my loan page
    #Then verify the page displays header as common questions
    #Then verify the header display as Advancing Funds from Your Reverse Mortgage
    #Then verify the subheader is displayed as MIP -- Mortgage Insurance Premium
    #When i click on question Why do I have to pay MIP on my HECM loan?
    #Then verify answer should be displayed as MIP (Mortgage Insurance Premium) is a fee etc

  #TestCaseName : BP_TC79-commonQuestions_UI_Verify question 5 in Income Taxes and 1098 Forms section
  @CommonQuestionsTest
  Scenario: Verify that question 1 and its associated answer is  displaying correctly under Payment Plan Changes (PPCs)  sub section
    Given i load testdata from: "CommonQuestionsData.json", "CommonQuestionsTestData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    And i click on common questions button in my loan page
    Then verify the page displays header as common questions
    Then verify the header display as Advancing Funds from Your Reverse Mortgage
    Then verify the subheader is displayed as Payment Plan Changes (PPCs)
    When i click on question What types of Payment Plans are available?
    Then verify question should get expanded and answer should be displayed as for most reverse mortagages etc

  #TestCaseName : BP_TC86-commonQuestions_UI_Verify question 7 in Set Asides subsection
  @CommonQuestionsTest
  Scenario: Verify that question 1 and its associated answer is  displaying correctly under Payment Plan Changes (PPCs)  sub section
    Given i load testdata from: "CommonQuestionsData.json", "CommonQuestionsTestData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    And i click on common questions button in my loan page
    Then verify the page displays header as common questions
    Then verify the header display as Advancing Funds from Your Reverse Mortgage
    Then verify the subheader is displayed as Payment Plan Changes (PPCs)
    When i click on question What types of Payment Plans are available?
    Then verify question should get expanded and answer should be displayed as for most reverse mortagages etc

  #TestCaseName : BP_TC94-commonQuestions_UI_Verify question 6 in Repairs subsection
  @CommonQuestionsTest
  Scenario: Verify that question 1 and its associated answer is  displaying correctly under Payment Plan Changes (PPCs)  sub section
Given i load testdata from: "CommonQuestionsData.json", "CommonQuestionsTestData"
    Given i logged into borrower portal
    When i enter username and password and click on signin button
    And i click on common questions button in my loan page
    Then verify the page displays header as common questions
    When i click on Advancing Funds from Your Reverse Mortgage topic under List of Topics
    Then verify Page contains header subheader 
    Then verify page is navigated to Advancing Funds from Your Reverse Mortgage section present to the right side
    Then verify the subheader is displayed as Requesting Funds
    When i click on question Can an Attorney-in-Fact who has Power of Attorney sign the Line of Credit Advance Request form for the borrower(s)?
    Then verify question should get expanded and answer should be displayed as Yes, the attorney etc
