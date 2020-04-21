package com.cl.borrower_web.pages.portal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

public class MyLoanPage extends ObjectBase {

	public MyLoanPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "title")
	public WebElement pageHeading;
	
	@FindBy(how = How.CSS, using = "a[aria-label='common forms']")
	public WebElement commonFormsTab;
	
	@FindBy(how = How.CSS, using = "a[aria-label='common questions']")
	public WebElement commonQuestionsTab;
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(), 'Property Address')]")
	public WebElement propAddress;
	
	
}