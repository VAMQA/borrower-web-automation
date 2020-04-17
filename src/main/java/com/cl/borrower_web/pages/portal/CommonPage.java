package com.cl.borrower_web.pages.portal;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.java_af.setup.ConcurrentEngines;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

public class CommonPage extends ObjectBase {

	public String userName = "";

	public CommonPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='userid' or @name='username']")
	private WebElement txtUserName;
	
	@FindBy(name = "password")
	private WebElement txtPassword;

	@FindBy(xpath = "//*[contains(text(),'Continue') and contains(@id,'button')]")
	private WebElement btnContinue;
	
	/**
	 * To load URL
	 */
	public void loadURL() {
		try {
			navigator.goToUrl(appURL);

		} catch (Exception e) {
			LogUtility.logException("->loadURL<--", "Unable to load URL", e, LoggingLevel.ERROR, true);
		}
	}


	/**
	 * To enter Username
	 * 
	 * @param userName
	 */
	public boolean enterUserName(String userName) {
		boolean flag = false;
		try {
			waits.waitForPageToLoad(maxTimeOut);
			waits.waitUntilElementIsPresent(txtUserName);
			if (webActions.isDisplayed(txtUserName)) {
				webActions.setValue(txtUserName, userName);
				waits.staticWait(3);
			}
			LogUtility.logInfo("---> enterUserName <---", "Entered the username " + userName);
			if (webActions.getText(txtUserName).equals(userName))
				flag = true;
		} catch (Exception e) {
			LogUtility.logException("->enterUserName<--", "username is not entered", e, LoggingLevel.ERROR, true);
		}
		return flag;
	}

	
	/**
	 * switchToFrameIndex : Switch to frame based on Index
	 * 
	 * @param index
	 * @return
	 */
	public boolean switchToFrameByIndex(String index) {
		try {
			waits.waitForDOMready();
			waits.waitForPageReadyState();
			driver.switchTo().frame(Integer.parseInt(index));
			LogUtility.logInfo("--->switchToFrameByIndex<---", "Switched to " + index + " frame");
			return true;
		} catch (Exception e) {
			LogUtility.logException("->switchToFrameByIndex<--", "Failed to switch to frame by index", e,
					LoggingLevel.ERROR, true);
		}
		return false;
	}

	/**
	 * switchToDefaultContent: To switch back to Default content
	 * 
	 * @return
	 */
	public boolean switchToDefaultContent() {
		try {
			waits.waitForDOMready();
			waits.waitForPageReadyState();
			driver.switchTo().defaultContent();
			LogUtility.logInfo("--->switchToDefaultContent<---", "Switched to default content");
			return true;
		} catch (Exception e) {
			LogUtility.logException("->switchToDefaultContent<--", "Failed to switch to Default content", e,
					LoggingLevel.ERROR, true);
		}
		return false;
	}


	/**
	 * switchToChildWindow : To switch to child window
	 * 
	 * @return boolean
	 */
	public boolean switchToChildWindow() {
		waits.waitForDOMready();
		waits.waitForPageReadyState();
		try {
			BorrowerWebUtil.switchToNewWindow();
			LogUtility.logInfo("-->switchToChildWindow<--", "Switched to Child Window");
			return true;
		} catch (Exception e) {
			LogUtility.logException("--->switchToChildWindow<---", "Failed in switch to Child Window", e,
					LoggingLevel.ERROR, true);
		}
		return false;
	}

	/**
	 * switchToParentWindow: To switch to parent window
	 * 
	 * @return boolean
	 */
	public boolean switchToParentWindow() {
		waits.waitForDOMready();
		waits.waitForPageReadyState();
		try {
			BorrowerWebUtil.switchToMainWindow();
			LogUtility.logInfo("-->switchToParentWindow<--", "Switched to Parent Window");
			return true;
		} catch (Exception e) {
			LogUtility.logException("--->switchToParentWindow<---", "Failed in switch to Parent Window", e,
					LoggingLevel.ERROR, true);
		}
		return false;
	}
}