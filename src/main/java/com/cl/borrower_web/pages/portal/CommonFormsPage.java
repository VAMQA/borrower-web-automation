package com.cl.borrower_web.pages.portal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

public class CommonFormsPage extends ObjectBase {

	public CommonFormsPage() {
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(how = How.CSS, using = "a[class='upload-button']")
	public WebElement uploadNowButton;
	
	

}