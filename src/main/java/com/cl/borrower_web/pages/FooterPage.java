package com.cl.borrower_web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

public class FooterPage extends ObjectBase {

	public FooterPage() {
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Privacy Policy')]")
	public WebElement privacyPolicy;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Terms & Conditions')]")
	public WebElement termsConditions;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Schedule of Borrower Fees')]")
	public WebElement scheduleofBorrowerFees;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Licenses')]")
	public WebElement license;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Accessibility Statement')]")
	public WebElement accessibilityStatement;
	
	@FindBy(how = How.CSS, using = ".navbar-brand")
	public WebElement reverseMortSerDeptTopLeft;
	
	@FindBy(how = How.CSS, using = ".top-footer h3")
	public WebElement reverseMortSerDeptFootertext;
	
	
	
	
	
}