package com.cl.borrower_web.pages;

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
	
	@FindBy(how = How.ID, using = "title")
	public WebElement commonFormHeader;
	
	
	@FindBy(how = How.CSS, using = "a[aria-label='Home Link'] img")
	public WebElement reverseMortagaeFundingLogo;
	
	@FindBy(how = How.CSS, using = "a[class='upload-button']")
	public WebElement uploadNowButton;
	
	@FindBy(how = How.XPATH, using = "//*[text()='Send from a computer or smart phone']")
	public WebElement sendFormContainerHeader;
	
	
	@FindBy(how = How.XPATH, using = "//*[text()='Send from a computer or smart phone']//parent::div//p")
	public WebElement sendFormContainerSubHeader;
	
	@FindBy(how = How.ID, using = "loc-draw-request")
	public WebElement loc_Advance_Request;
	
	@FindBy(how = How.ID, using = "occupancy-certificate")
	public WebElement occupancyCertificate;
	
	@FindBy(how = How.ID, using = "repairs-extension-request")
	public WebElement repairsExtensionRequest;
	
	@FindBy(how = How.ID, using = "request-for-reverse-mortgage-payoff-quote")
	public WebElement requestForReverseMortgagePayoffQuote;
	
	@FindBy(how = How.ID, using = "tax-payment-request")
	public WebElement taxPaymentRequest;
	
	@FindBy(how = How.ID, using = "short-sale")
	public WebElement shortSale;
	
	@FindBy(how = How.ID, using = "a3p")
	public WebElement thirdPartyAuthorization;
	
	
	
	@FindBy(how = How.CSS, using = "button[class='upload-button']")
	public WebElement uploadButton;

	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'Successfully uploaded file')]")
	public WebElement successfullValidationMessage;

}