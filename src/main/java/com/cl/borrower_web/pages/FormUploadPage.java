package com.cl.borrower_web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.borrower_web.actions.Keyboard;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;

public class FormUploadPage extends ObjectBase {

	public FormUploadPage() {
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(how = How.ID, using = "title")
	public WebElement pageHeading;
	
	@FindBy(how = How.CSS, using = "div[class='drag-n-drop'] p")
	public WebElement DragAndDropFormbutton;
	
	@FindBy(how = How.CSS, using = "h3.chosen-file")
	public WebElement ChosenFileText;
	
//	@FindBy(how = How.CSS, using = "div[class='drag-n-drop'] p")
//	public WebElement DragAndDropFormbutton;
	
	public boolean UploadDocument(String path)
	{
		try {
			Thread.sleep(1000);
			
			Keyboard keyboard = new Keyboard();
			keyboard.type(path.trim());
			Thread.sleep(1000);
			keyboard.enter();
			return true;
			
		}catch(Exception ex){
			System.out.println("Exception while upload the document");
			return false;	
		}
		
	}
	
}