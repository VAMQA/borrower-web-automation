@Footer
Feature: Login to borrower portal

    #TestcasName  : BP_TC01_footer_UI_Verify Footer Section
		#Automation Test ID : BP_AUTO_REF_216

    Scenario: In login page navigation to privacy policy page
    Given i load testdata from: "FooterData.json", "FooterPageDetails"
    Given i logged into borrower portal
    Then verify all the five footerlink text

    #TestcasName  : BP_TC02_footer_FUN_Navigation to Privacy Policy page
		#Automation Test ID : BP_AUTO_REF_217

    Scenario: In login page navigation to privacy policy page
    Given i load testdata from: "FooterData.json", "FooterPageDetails"
    Given i logged into borrower portal
    Then verify all the five footerlink text
    When i click on privacy policy link
    
    
  #  TestcasName  : BP_TC03_footer_FUN_Navigation to Terms and Conditions Page
		#Automation Test ID : BP_AUTO_REF_218

  	@Smoke
    Scenario: In login page navigation to terms and conditions page
    Given i load testdata from: "FooterData.json", "FooterPageDetails"
    Given i logged into borrower portal
    Then verify all the five footerlink text
     When i click on terms and conditions link
    
 #   TestcasName  : BP_TC04_footer_FUN_Navigation to Schedule of Borrower Fees page
		#Automation Test ID : BP_AUTO_REF_219

    Scenario: In login page navigation to schedule of borrower fees page
    Given i load testdata from: "FooterData.json", "FooterPageDetails"
    Given i logged into borrower portal
    Then verify all the five footerlink text
     When i click on schedule of borrower fees link
    
  #  TestcasName  :BP_TC05_footer_FUN_Navigation to License Page
		#Automation Test ID : BP_AUTO_REF_220

    Scenario: In login page navigation to license page
    Given i load testdata from: "FooterData.json", "FooterPageDetails"
    Given i logged into borrower portal
    Then verify all the five footerlink text
    When i click on licenses link
    
 #   TestcasName  : BP_TC06_footer_FUN_Navigation to Accessibility Statement Page
		#Automation Test ID : BP_AUTO_REF_221

  	@Smoke
    Scenario: In login page navigation to accessibility statement page
    Given i load testdata from: "FooterData.json", "FooterPageDetails"
    Given i logged into borrower portal
    Then verify all the five footerlink text
    When i click on accessibility statement link
    
    
    
   # TestcasName  : BP_TC09_footer_FUN_Verify that user is able to navigate to My Loan Page
		#Automation Test ID : BP_AUTO_REF_224

  	@Smoke
    Scenario: Verify that user is able to navigate to my loan page
    Given i load testdata from: "FooterData.json", "FooterPageDetails"
    Given i logged into borrower portal
    When i enters username and password and click on signin button
    Then verify the landing page displays header as my loan
    
   
   
   
   
   
    
    
    