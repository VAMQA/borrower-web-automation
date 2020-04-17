package com.cl.borrower_web.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.cl.borrower_web.actions.ObjectBase;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;
import com.cl.java_af.engine.WebActions;

public class CommonQuestionsPage extends ObjectBase {

	public CommonQuestionsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "title")
	public WebElement CommonQuestionsPageHeading;

	@FindBy(how = How.XPATH, using = "//div[@class='questions']/h3")
	public List<WebElement> CommonQuestionsTopicsHeadings;

	@FindBy(how = How.CSS, using = "div.card-header button")
	public List<WebElement> CommonQuestionsList;

	public List<String> GetAllTheHeadingsForTheQuestions() {
		return getVisibleElementText(CommonQuestionsTopicsHeadings);
	}

	public List<String> GetAllTheQuestionsList() {
		return getVisibleElementText(CommonQuestionsList);
	}

	private List<String> getVisibleElementText(List<WebElement> commonQuestionsTopicsHeadings2) {
		List<String> lstOfText = new ArrayList<String>();
		for (WebElement element : commonQuestionsTopicsHeadings2) {
			if (element.isDisplayed()) {
				lstOfText.add(webActions.getText(element));
			}
		}
		return lstOfText;
	}

	public boolean verifyCommonQuestionsList(String[] expectedjsonSeperatedValues, List<String> actualquestionsList) {
		try {
			boolean result = false;
			for (int i = 0; i <= expectedjsonSeperatedValues.length; i++) {
				if (actualquestionsList.get(i).trim().contains(expectedjsonSeperatedValues[i].trim())) {
					reportPass("CommonQuestion for "+ expectedjsonSeperatedValues[i] +" is equal to " +actualquestionsList.get(i) , true);
					result = true;					
				} else {
					reportFail("CommonQuestion for "+ expectedjsonSeperatedValues[i] +" is not equal to " +actualquestionsList.get(i) , false);
					result = false;
				}
			}
			return result;
		} catch (Exception ex) {
			reportFail("Exception got occured while validating all the common questions" , false);
			return false;
		}

	}

}