package com.cl.borrower_web.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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

	@FindBy(how = How.CSS, using = "h3[id='popular']")
	public WebElement popularHeader;

	@FindBy(how = How.XPATH, using = "//h3[@id='popular']//following::div[1]//button[text()='How do I request an advance from my Line of Credit (LOC)?']")
	public WebElement popular_advanceLOC;

	@FindBy(how = How.XPATH, using = "//h3[@id='popular']//following::div[1]//button[text()='How do I request an advance from my Line of Credit (LOC)?']//following::div[1]")
	public WebElement popular_advanceLOC_collapse;

	@FindBy(how = How.XPATH, using = "//h3[@id='popular']//following::div[1]//a[text()='LOC Advance Request form']")
	public WebElement popular_LOCAdvanceRequestForm_pdflink;

	@FindBy(how = How.XPATH, using = "//h3[@id='popular']//following::div[1]//a[text()='lineofcredit@reversedepartment.com']")
	public WebElement popular_lineofcredit_email;

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
					reportPass("CommonQuestion for " + expectedjsonSeperatedValues[i] + " is equal to "
							+ actualquestionsList.get(i), true);
					result = true;
				} else {
					reportFail("CommonQuestion for " + expectedjsonSeperatedValues[i] + " is not equal to "
							+ actualquestionsList.get(i), false);
					result = false;
				}
			}
			return result;
		} catch (Exception ex) {
			reportFail("Exception got occured while validating all the common questions", false);
			return false;
		}

	}

	public WebElement GetTopic_Element(String topicName) {
		return driver.findElement(By.xpath("//div[@id='sidebar']//a[text()='" + topicName + "']"));
	}

	public WebElement GetHeaderElement(String questionMainheadding) {
		return driver.findElement(By.xpath("//h3[text()='" + questionMainheadding + "']"));
	}

	public WebElement GetSubheader_Element(String questionMainheadding, String questionSubHeader) {
		// h3[text()='How Do Reverse Mortgages
		// Work?']//following-sibling::h5[text()='Home ownership']
		return driver.findElement(By.xpath("//h3[text()='" + questionMainheadding + "']//following-sibling::h5[text()='"
				+ questionSubHeader + "']"));
	}

	public WebElement GetQuestion_withSubheader_Element(String questionMainheadding, String questionSubHeader,
			String question) {
		// h3[text()='How Do Reverse Mortgages
		// Work?']//following-sibling::h5[text()='Home
		// ownership']//following-sibling::div//button[text()='Who owns my home?']
		return driver.findElement(By.xpath("//h3[text()='" + questionMainheadding + "']//following-sibling::h5[text()='"
				+ questionSubHeader + "']//following-sibling::div//button[text()='" + question + "']"));
	}

	public WebElement GetQuestion_withheader_Element(String questionMainheadding, String question) {
		//// h3[@id='popular']//following::div[1]//button[text()='How do I request an
		//// advance from my Line of Credit (LOC)?']
		return driver.findElement(By.xpath(
				"//h3[text()='" + questionMainheadding + "']//following::div[1]//button[text()='" + question + "']"));
	}

	public WebElement GetAnswer_withheader_Element(String questionMainheadding, String question) {
		// h3[@id='popular']//following::div[1]//button[text()='How do I request an
		// advance from my Line of Credit (LOC)?']//following::div[1]
		return driver.findElement(By.xpath("//h3[text()='" + questionMainheadding
				+ "']//following::div[1]//button[text()='" + question + "']//following::div[1]"));
	}

	public WebElement GetAnswer_withSubheader_Element(String questionMainheadding, String questionSubHeader,
			String question) {
		// h3[text()='How Do Reverse Mortgages
		// Work?']//following-sibling::h5[text()='Home
		// ownership']//following-sibling::div//button[text()='Who owns my
		// home?']//following::div[1]
		return driver.findElement(By
				.xpath("//h3[text()='" + questionMainheadding + "']//following-sibling::h5[text()='" + questionSubHeader
						+ "']//following-sibling::div//button[text()='" + question + "']//following::div[1]"));
	}

	public WebElement GetAnswer_withSubheader_Element(String questionMainheadding, String questionSubHeader,
			String question, String textType) {
		String locator = "//h3[text()='" + questionMainheadding + "']//following-sibling::h5[text()='"
				+ questionSubHeader + "']//following-sibling::div//button[text()='" + question
				+ "']//following::div[1]";
		if (textType.equalsIgnoreCase("Bold"))
			locator = locator + "//strong";

		return driver.findElement(By.xpath(locator));
	}

	public String GetAnswerCommonQuestion(String header, String subheader, String question) {
		String actualAnswer = null;

		for (WebElement headerElement : CommonQuestionsList) {
			if (webActions.getText(headerElement).contains(header)) {
				List<WebElement> lstSubHeaderElements = headerElement.findElements(By.xpath("//following-sibling::h5"));
				for (WebElement subheaderElement : lstSubHeaderElements) {
					if (webActions.getText(subheaderElement).equals(subheader)) {
						List<WebElement> lstquestionElements = subheaderElement.findElements(
								By.xpath("//following-sibling::div[1]//div[@class='card-header']//buttton"));
						for (WebElement questionElement : lstquestionElements) {
							if (webActions.getText(questionElement).equals(question)) {
								WebElement answerElement = questionElement
										.findElement(By.xpath("//following-sibling::div[1]//div[@class='collapse']"));
								return webActions.getText(answerElement);
							}
						}
					}
				}

			}
		}

		return actualAnswer;
	}

}