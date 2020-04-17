package com.cl.borrower_web.pages.portal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

public class LoginPage extends ObjectBase {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.NAME, using = "email")
	public WebElement usernameTextBox;

	@FindBy(how = How.NAME, using = "password")
	public WebElement passwordTextBox;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Sign In')]")
	public WebElement signIn;
}