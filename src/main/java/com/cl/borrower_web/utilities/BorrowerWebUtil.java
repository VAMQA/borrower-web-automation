package com.cl.borrower_web.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cl.borrower_web.testbases.BorrowerTestBase;
import com.cl.java_af.setup.ConcurrentEngines;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.testbases.CucumberTestBase;
import com.cl.java_af.utilities.LogUtility;

public class BorrowerWebUtil {

	public static LinkedHashMap<String, String> returnMap;
	public String containsText;
	public int maxTimeOutUtil = 60;

	/**
	 * To click on Menu and Sub Menu
	 * 
	 * @param menu-Top menu outer element,subMenu - Sub menu outer element menuValue
	 *        - Link value from menu, linkValue - Link value from sub menu
	 * @Author:
	 * @Modified on:
	 */

	public void clickMenu(WebElement menu, WebElement subMenu, String menuValue, String linkValue) {
		ConcurrentEngines.getEngine().getWait().staticWait(5);
		boolean flag = false;
		try {
			List<WebElement> links = menu.findElements(By.tagName("span"));
			int menuSize = links.size();
			for (int i = 0; i < menuSize; i++) {
				String linkName = links.get(i).getText();
				if (linkName.equalsIgnoreCase(menuValue)) {
					flag = true;
					links.get(i).click();
					break;
				}
			}
			ConcurrentEngines.getEngine().getWait().staticWait(5);
			if (flag) {
				boolean subflag = false;
				try {
					List<WebElement> linksSubMenu = subMenu.findElements(By.tagName("a"));
					int subMenuSize = linksSubMenu.size();
					for (int i = 0; i < subMenuSize; i++) {
						String linkName = linksSubMenu.get(i).getText();
						if (linkName.equalsIgnoreCase(linkValue)) {
							subflag = true;
							ConcurrentEngines.getEngine().getWebActions().clickElementJS(linksSubMenu.get(i));
							ConcurrentEngines.getEngine().getWait().staticWait(3);
							break;
						}
					}
					ConcurrentEngines.getEngine().getWait().staticWait(5);
					if (subflag) {
						LogUtility.logInfo("Clicked on submenu link");
					} else {
						LogUtility.logError("Failed to click on given sub menu link");
					}

				} catch (Exception e) {
					LogUtility.logException("->clickMenu<--", "Failed to click on sub menu link", e, LoggingLevel.ERROR,
							true);
				}
			} else {
				LogUtility.logError("Failed to click on given link from menu");
				Assert.fail("Failed to click on given link from menu");
			}
		} catch (Exception e) {
			LogUtility.logException("->clickMenu<--", "Failed to click on Menu", e, LoggingLevel.ERROR, true);
		}
	}

	/**
	 * To Verify text value
	 * 
	 * @param element:Element to get actual text, textValue: Expected string value
	 * @Created on:
	 * @Modified on:
	 */
	public boolean verifyText(WebElement element, String textValue) {
		boolean flag = false;
		try {
			ConcurrentEngines.getEngine().getWait().waitUntilElementIsPresent(element, maxTimeOutUtil);
			String text = element.getText().trim();
			if (text.equals(textValue)) {
				flag = true;
				LogUtility.logInfo("Text verified Successfully ." + text);
				return flag;
			}
		} catch (Exception e) {
			LogUtility.logException("->verifyText<--", "Failed to Verify Text", e, LoggingLevel.ERROR, true);
		}
		return flag;
	}

	/**
	 * To Verify text value
	 * 
	 * @param element:Element to get actual text, textValue: Expected string value
	 * @Created on:
	 * @Modified on:
	 */
	public boolean verifyText(WebElement element, String textValue, String methodName) {
		try {
			ConcurrentEngines.getEngine().getWait().waitForDOMready();
			ConcurrentEngines.getEngine().getWait().waitUntilElementIsPresent(element, maxTimeOutUtil);
			return verifyText(element, textValue);
		} catch (Exception e) {
			LogUtility.logException("" + methodName + "", "Failed to Verify the text", e, LoggingLevel.ERROR, true);
			return false;
		}
	}

	public void clickWebElement(WebElement element, String methodName) {
		try {
			ConcurrentEngines.getEngine().getWait().waitUntilElementIsPresent(element, maxTimeOutUtil);
			ConcurrentEngines.getEngine().getWebActions().clickElementJS(element);
			ConcurrentEngines.getEngine().getWait().waitForPageToLoad(maxTimeOutUtil);
			ConcurrentEngines.getEngine().getWait().staticWait(5);
			LogUtility.logInfo("--->" + methodName + "<--- <---", "Clicked on Element");
		} catch (Exception e) {
			LogUtility.logException("" + methodName + "", "Failed to Click on element", e, LoggingLevel.ERROR, true);
			throw (e);
		}
	}

	/**
	 * To return dynamic string value based on time stamp
	 * 
	 * @param
	 * @Created on:
	 * @Modified on:
	 */
	public String dynamicData() {
		String sysDateAndTime = null;
		try {
			Format formatter = new SimpleDateFormat("ssmmHHdd");
			java.util.Date today = Calendar.getInstance().getTime();
			sysDateAndTime = formatter.format(today);
		} catch (Exception e) {
			LogUtility.logException("-->dynamicData<--", "Failed to create dynamic value", e, LoggingLevel.ERROR, true);
		}
		return sysDateAndTime;
	}

	/**
	 * To return all the rows values from web table
	 * 
	 * @param table: web element table id
	 * @Created on:
	 * @Modified on:
	 */
	public ArrayList<String> getTableValues(WebElement table) {
		ArrayList<String> rowsData = null;
		try {
			List<WebElement> rows = table.findElements(By.xpath(".//tbody//tr"));
			rowsData = new ArrayList<String>();

			for (WebElement row : rows) {
				List<WebElement> rowElements = row.findElements(By.xpath(".//td"));

				ArrayList<String> rowData = new ArrayList<String>();

				for (WebElement column : rowElements) {
					rowData.add(column.getText().toString());
				}
				rowsData.addAll(rowData);

			}

		} catch (Exception e) {
			LogUtility.logException("-->getTableValues<--", "Failed to get table rows data", e, LoggingLevel.ERROR,
					true);
		}
		return rowsData;

	}
	
	
	/**
	 * To return all the rows values from web table
	 * 
	 * @param table: web element table id
	 * @Created on: 04282020
	 * @Created by: satish patil
	 */
	public ArrayList<String> getTableheaderValues(WebElement table) {
		ArrayList<String> rowsData = null;
		try {
			List<WebElement> rows = table.findElements(By.xpath(".//thead//tr"));
			rowsData = new ArrayList<String>();

			for (WebElement row : rows) {
				List<WebElement> rowElements = row.findElements(By.xpath(".//th"));

				ArrayList<String> rowData = new ArrayList<String>();

				for (WebElement column : rowElements) {
					rowData.add(column.getText().toString());
				}
				rowsData.addAll(rowData);

			}

		} catch (Exception e) {
			LogUtility.logException("-->getTableValues<--", "Failed to get table rows data", e, LoggingLevel.ERROR,
					true);
		}
		return rowsData;

	}

	/**
	 * To return specified back date
	 * 
	 * @param days: how many days old date and current date, Give either 0 or number
	 * @Created on:
	 * @Modified on:
	 */
	public String getOldDate(String day) {
		String oldDate = "";
		int days = Integer.parseInt(day);
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/YYYY");
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime then = now.minusDays(days);
			oldDate = String.format(then.format(format));

		} catch (Exception e) {
			LogUtility.logException("-->getOldDate<--", "Failed to return old date", e, LoggingLevel.ERROR, true);
		}
		return oldDate;
	}

	/**
	 * To verify given date present in rage of dates or not
	 * 
	 * @param dateValue:verify date, startDate:Range starting date,endDate: Range
	 *        end date
	 * @throws Exception
	 * @Created on:
	 * @Modified on:
	 */
	public boolean verifyDateGivenRange(String dateValue, String startDate, String endDate) throws Exception {
		String sDate[] = dateValue.split("/");
		String ModsDate = sDate[0] + "/" + sDate[1] + "/" + "20" + sDate[2];
		boolean flag = false;
		try {
			SimpleDateFormat objSDF = new SimpleDateFormat("mm/dd/yyyy");
			Date dt_1 = objSDF.parse(ModsDate);
			Date dt_2 = objSDF.parse(startDate);
			Date dt_3 = objSDF.parse(endDate);
			if ((dt_1.after(dt_2)) || (dt_1.before(dt_3)) || (dt_1.equals(dt_2)) || (dt_1.equals(dt_3))) {
				flag = true;
			}
		} catch (Exception e) {
			LogUtility.logException("-->verifyDateGivenRange<--", "Date range failed", e, LoggingLevel.ERROR, true);
			throw new Exception("Date range failed");
		}
		return flag;

	}

	/**
	 * To verify table column value date is present in range or not
	 * 
	 * @param Element:column from table, startDate:Range starting date,endDate:
	 *        Range end date
	 * @Created on:
	 * @Modified on:
	 */
	public void verifyDateInWebTable(List<WebElement> element, String startDate, String endDate) {
		try {

			for (int values = 0; values < element.size(); values++) {
				String dateValue = ((WebElement) element.get(values)).getText();
				boolean resultValue = verifyDateGivenRange(dateValue, startDate, endDate);
				if (resultValue) {
					LogUtility.logInfo("Passed -" + dateValue + " Present in range");
				} else {
					LogUtility.logError("Failed -" + dateValue + " Not Present in range");
				}
			}
		} catch (Exception e) {
			LogUtility.logException("-->verifyDateInWebTable<--", "Failed to verify Date in Web Table", e,
					LoggingLevel.ERROR, true);
		}

	}

	/**
	 * To select a value from list
	 * 
	 * @param Element:list element, listValue:selctable value
	 * @Created on:
	 * @Modified on:
	 */
	public boolean selectListValue(WebElement element, String listValue) {
		boolean flag = false;
		try {
			List<WebElement> selectList = element.findElements(By.tagName("li"));
			int listCount = selectList.size();
			for (int list = 0; list < listCount; list++) {
				String listData = selectList.get(list).getText();
				if (listData.contains(listValue)) {
					selectList.get(list).click();
					flag = true;
					LogUtility.logInfo("-->selectListValue<--", "Selected the value from list");
					break;
				}
			}

		} catch (Exception e) {
			LogUtility.logException("-->selectListValue<--", "Failed to Select List Value", e, LoggingLevel.ERROR,
					true);
		}
		return flag;
	}

	/**
	 * To select a link from list
	 * 
	 * @param Element:list element, listValue:selctable value
	 * @Created on:
	 * @Modified on:
	 */
	public boolean selectLinkFromList(WebElement element, String listValue) {
		boolean flag = false;
		ConcurrentEngines.getEngine().getWait().waitForDOMready();
		try {
			ConcurrentEngines.getEngine().getWait().waitForPageReadyState();
			List<WebElement> selectList = element.findElements(By.tagName("a"));
			int listCount = selectList.size();
			ConcurrentEngines.getEngine().getWait().staticWait(2);
			for (int list = 0; list < listCount; list++) {
				String listData = selectList.get(list).getText();
				ConcurrentEngines.getEngine().getWait().staticWait(1);
				if (listData.contains(listValue)) {
					ConcurrentEngines.getEngine().getWait().staticWait(2);
					ConcurrentEngines.getEngine().getWebActions().clickElementJS(selectList.get(list));
					flag = true;
					LogUtility.logInfo("-->selectLinkFromList<--", "Selected the value from list");
					break;
				}
			}
		} catch (Exception e) {
			LogUtility.logException("-->selectLinkFromList<--", "Failed to Select List Value", e, LoggingLevel.ERROR,
					true);
		}
		return flag;
	}

	/**
	 * To Verify value in the list
	 * 
	 * @param element:Element to get actual value, listValue: Expected string value
	 * @Created on:
	 * @Modified on:
	 */

	public void verifyListValues(WebElement element, List<String> listValue) {
		boolean flag;
		try {
			String listValues = null;
			int listSize = listValue.size();
			List<WebElement> options = element.findElements(By.tagName("li"));
			for (WebElement option : options) {
				for (int listoption = 0; listoption < listSize; listoption++) {
					listValues = listValue.get(listoption);
					if (listValues.equals(option.getText())) {
						flag = true;
						if (flag) {
							LogUtility.logInfo("Option " + listValues + "availabale in given list");
						} else {
							LogUtility.logError("Option " + listValues + " not availabale in given list");
						}
					}
				}
			}
		} catch (Exception e) {
			LogUtility.logException("-->verifyListValues<--", "Failed to Verify List Values", e, LoggingLevel.ERROR,
					true);
		}

	}

	/**
	 * To convert date format yyyy-mm-dd to mm/dd/yyyy
	 * 
	 * @param dateValue:date as a string in the format yyyy-mm-dd
	 * @Created on:
	 * @Modified on:
	 */
	public String convertDateFormat(String dateValue) {
		String dateVal = "";
		try {
			DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			Date date = new Date();
			date = df.parse(dateValue);
			DateFormat df1 = new SimpleDateFormat("mm/dd/yyyy");
			dateVal = df1.format(date);

		} catch (Exception e) {
			LogUtility.logException("-->convertDateFormat<--", "Failed to convert dat format", e, LoggingLevel.ERROR,
					true);
		}

		return dateVal;

	}

	/**
	 * To select a value from drop down based on text contains
	 * 
	 * @param element:drop down element
	 * @Created on:
	 * @Modified on:
	 */
	public void selectByTextContains(WebElement element) {
		boolean flag = false;
		try {
			List<WebElement> selectList = element.findElements(By.tagName("option"));
			int listCount = selectList.size();
			for (int list = 0; list < listCount; list++) {
				String listData = selectList.get(list).getText();
				if (listData.contains("/")) {
					flag = true;
					selectList.get(list).click();
					break;
				}
				if (flag) {
					LogUtility.logInfo("Selected value from the List");
				} else {
					LogUtility.logError("Failed to select value from the list");
				}
			}
		} catch (Exception e) {
			LogUtility.logException("-->selectByTextContains<--", "Failed to Select value", e, LoggingLevel.ERROR,
					true);
		}
	}

	/**
	 * To collect latest modified file from a folder
	 * 
	 * @param floder: Folder name
	 * @Created on:
	 * @Modified on:
	 */
	public File getTheNewestFile(String folder) {
		File lastModifiedFile = null;
		try {
			String filePath = System.getProperty("user.dir") + "\\" + folder;
			File dir = new File(filePath);
			File[] files = dir.listFiles();
			lastModifiedFile = files[0];
			String name = lastModifiedFile.getName();
			LogUtility.logInfo("Downloaded file name is " + name);
			for (int i = 1; i < files.length; i++) {
				if (lastModifiedFile.lastModified() < files[i].lastModified()) {
					lastModifiedFile = files[i];
				}
			}
		} catch (Exception e) {
			LogUtility.logException("-->getTheNewestFile<--", "Not finding downloaded file", e, LoggingLevel.ERROR,
					true);
		}

		return lastModifiedFile;
	}

	/**
	 * To rename latest file from given folder with given extension
	 * 
	 * @param floder: Folder name .extension: file format extension
	 * @Created on:
	 * @Modified on:
	 */
	public File renameFile(String fileType, String extension) {
		File updated = null;
		String folderName = BorrowerTestBase.props.getProperty("file.download.directory");
		try {
			File newfile = getTheNewestFile(folderName);
			String dte = getCurrentTimeStamp();
			String newTimeStamp = dte.replaceAll("[:\\/AM PM ]", "");
			newfile.renameTo(new File(System.getProperty("user.dir") + "\\" + folderName + "\\" + fileType + "-"
					+ newTimeStamp + extension));
			updated = getTheNewestFile(folderName);
			String renamedFile = updated.getName();
			LogUtility.logInfo("File name is renamed to  " + renamedFile);
		} catch (Exception e) {
			LogUtility.logException("-->renameFile<--", "Failed to rename the file", e, LoggingLevel.ERROR, true);
		}
		return updated;
	}

	/**
	 * To verify content from latest down loaded file from given folder
	 * 
	 * @param floder: Folder name .extension: file format extension
	 * @Created on:
	 * @Modified on:
	 */
	public boolean verifyFileContent(String fileType, String extension) {
		boolean flag = false;
		try {

			File file = renameFile(fileType, extension);
			if (file.length() != 0) {
				LogUtility.logInfo("Downloaded File content verified successfully");
				flag = true;
			}
		} catch (Exception e) {
			LogUtility.logException("-->verifyFileContent<--", "Failed to Verify file content", e, LoggingLevel.ERROR,
					true);
		}
		return flag;
	}

	/**
	 * To return string current time stamp
	 * 
	 * @param
	 * @Created on:
	 * @Modified on:
	 */
	public String getCurrentTimeStamp() {
		String CDate = "";
		try {
			SimpleDateFormat CurrentDate = new SimpleDateFormat("MM/dd/yyyy" + " " + "hh:mm:ss" + " " + "a");
			Date now = new Date();
			CDate = CurrentDate.format(now);
		} catch (Exception e) {
			LogUtility.logException("-->getCurrentTimeStamp<--", "Failed to return current time stamp", e,
					LoggingLevel.ERROR, true);
		}
		return CDate;
	}

	/**
	 * verifyPageTitleofChildWindow- To verify the page title of Child Window
	 * 
	 * @param pageTitle- Text need to verify
	 * @return
	 */
	public boolean verifyPageTitleOfChildWindow(String pageTitle) {
		try {
			boolean status = false;
			String ActualpageTitle = null;
			String mainWindow = ConcurrentEngines.getEngine().getWebDriver().getWindowHandle();
			Set<String> window = ConcurrentEngines.getEngine().getWebDriver().getWindowHandles();
			Iterator<String> itr = window.iterator();
			while (itr.hasNext()) {
				ConcurrentEngines.getEngine().getWait().waitForDOMready();
				ConcurrentEngines.getEngine().getWait().waitForPageReadyState();
				ConcurrentEngines.getEngine().getWait().staticWait(5);
				String childWindow = itr.next();
				ActualpageTitle = ConcurrentEngines.getEngine().getWebDriver().switchTo().window(childWindow)
						.getTitle();
				if (ActualpageTitle.equals(pageTitle)) {
					status = true;
					break;
				}
			}
			ConcurrentEngines.getEngine().getWebDriver().switchTo().window(mainWindow);
			return status;
		} catch (Exception e) {
			LogUtility.logException("-->verifyPageTitleOfChildWindow<--", "Failed to verify page Title of Child Window",
					e, LoggingLevel.ERROR, true);
			return false;
		}
	}

	/**
	 * 
	 * @WebElement table – Header of the table (Ex: WebElement
	 *             tableHead=driver.findElement(By.xpath("//*[@id='pendingTable_table']/thead"));)
	 * @WebElement tableBody – Body of the table (Ex: WebElement
	 *             resultsBody=driver.findElement(By.xpath("//*[@id='pendingTable_table']/tbody"));;) @
	 *             String colName – Complete column name @ String value – Value need
	 *             to verify
	 */
	public boolean verifyTableResults(WebElement table, WebElement tableBody, String colName, String value) {
		try {
			Integer columnIndex = 0;
			String completeName = null;
			String completeData = null;
			List<WebElement> columns = table.findElements(By.tagName("tr"));
			List<WebElement> columnNames = columns.get(0).findElements(By.tagName("th"));
			int columnSize = columnNames.size();
			// set column number based on given column name
			for (int colNum = 0; colNum < columnSize; colNum++) {
				String columnName = columnNames.get(colNum).getText();
				// Handling if column name present in more than one div
				if (columnName.contains("\n")) {
					completeName = columnName.replaceAll("\n", " ");
				} else {
					completeName = columnName;
				}
				// Compares column name with given given value
				if (completeName.toLowerCase().equals(colName.trim().toLowerCase())) {
					columnIndex = colNum;
					break;
				}
			}
			List<WebElement> results_rows = tableBody.findElements(By.tagName("tr"));
			int rowsCount = results_rows.size();
			// Get row values from particular identifies column
			for (int rnum = 0; rnum < rowsCount;) {
				try {
					List<WebElement> resultColumns = results_rows.get(rnum).findElements(By.tagName("td"));
					String resultsData = (resultColumns.get(columnIndex)).getText();
					// Handling if cell data present in more than one div
					if (resultsData.contains("\n")) {
						completeData = resultsData.replaceAll("\n", " ");
					} else {
						completeData = resultsData;
					}
					// compares cell data with given value
					if (completeData.toLowerCase().contains(value.trim().toLowerCase())) {
						LogUtility.logInfo(" Value Verified in table successfully");
						return true;
					} else
						rnum++;
				} catch (Exception e) {
					rnum++;
					continue;
				}
			}
		} catch (Exception e) {
			LogUtility.logException("-->verifyTableResults<--", "Failed to Verify Text", e, LoggingLevel.ERROR, true);
			return false;
		}
		return false;
	}

	/**
	 * To scroll to an element
	 * 
	 * @param
	 * @Created on:
	 * @Modified on:
	 */
	public void scrollToElement(WebElement element) {
		try {
			((JavascriptExecutor) ConcurrentEngines.getEngine().getWebDriver())
					.executeScript("arguments[0].scrollIntoView(true);", element);

		} catch (Exception e) {
			LogUtility.logException("-->scrollToElement<--", "Failed to selected value", e, LoggingLevel.ERROR, true);
		}

	}

	/**
	 * To get the location of an element
	 * 
	 * @param
	 * @Created on:
	 * @Modified on:
	 */
	public Point getThePosition(WebElement element) {
		Point point = null;
		try {
			point = element.getLocation();

		} catch (Exception e) {
			LogUtility.logException("-->getThePosition<--", "Failed to get the position", e, LoggingLevel.ERROR, true);
		}
		return point;

	}

	/**
	 * To get the default selected value from list
	 * 
	 * @param
	 * @Created on:
	 * @Modified on:
	 */
	public String getDefaultValueForSelect(WebElement element) {
		String defaultItem = "";
		try {
			Select select = new Select(element);
			WebElement option = select.getFirstSelectedOption();
			defaultItem = option.getText();
			LogUtility.logInfo("default item in wolweb" + defaultItem);

		} catch (Exception e) {
			LogUtility.logException("-->getDefaultValueForSelect<--", "Failed to get the default value for select", e,
					LoggingLevel.ERROR, true);
		}
		return defaultItem;

	}

	/**
	 * To Verify given values in the Select Dropdown or not
	 * 
	 * @param element:Element to get actual value, dropDownValue: Expected string
	 *        value
	 * @Created on:
	 * @Modified on:
	 */
	public boolean verifyGivenValuesInDropDown(WebElement element, List<String> listValue) {
		boolean flag = false;
		try {
			String listValues = null;
			int count = 0;
			List<WebElement> options = element.findElements(By.tagName("option"));
			for (WebElement appList : options) {
				for (int tdList = 0; tdList < listValue.size(); tdList++) {
					listValues = listValue.get(tdList);
					if (appList.getText().contains(listValues)) {
						count++;

					}
				}
			}
			if (count == listValue.size() || count >= listValue.size()) {
				LogUtility.logInfo(listValue + " ---->  Value Matched--->");
				flag = true;
			}
		} catch (Exception e) {
			LogUtility.logException("-->verifyGivenValuesInDropDown<--", "Given values were not in the list", e,
					LoggingLevel.ERROR, true);
		}
		return flag;
	}

	/**
	 * To Verify value not in the list
	 * 
	 * @param element:Element to get actual value, listValue: Expected string value
	 *        not in the list
	 * @Created on:
	 * @Modified on:
	 */
	public boolean valueNotInList(WebElement element, String listValue) {
		try {
			List<WebElement> options = element.findElements(By.tagName("option"));
			int listCount = options.size();
			for (int list = 0; list < listCount; list++) {
				String listData = options.get(list).getText();
				if (listData.equalsIgnoreCase(listValue)) {
					options.get(list).click();
					LogUtility.logError("---> Failed to Select List Value  <---" + listValue);
					return false;
				}
			}
			LogUtility.logError("---> Value not in the list<---" + listValue);
			return true;
		} catch (Exception e) {
			LogUtility.logException("-->valueNotInList<--", "Failed to Select List Value", e, LoggingLevel.ERROR, true);
			return false;
		}
	}

	/**
	 * To verify List column value date is present in range or not
	 * 
	 * @param Element:column from table, startDate:Range starting date,endDate:
	 *        Range end date
	 * @Created on: 
	 * @Modified on:
	 */
	public void verifyDateIntheList(List<WebElement> element, String startDate, String endDate) {
		try {
			int eleSize = element.size();
			for (int values = 1; values < eleSize; values++) {
				String dateValue = ((WebElement) element.get(values)).getText();
				boolean resultValue = verifyDateGivenRange(dateValue, startDate, endDate);
				if (resultValue) {
					LogUtility.logInfo("Passed -" + dateValue + " Present in range");
				} else {
					LogUtility.logError("Failed -" + dateValue + " Not Present in range");
				}
			}
		} catch (Exception e) {
			LogUtility.logException("-->verifyDateIntheList<--", "Failed to return old date", e, LoggingLevel.ERROR,
					true);
		}
	}

	/**
	 * To verify Element is not present
	 * 
	 * @param Element: element
	 * @Created on:
	 * @Modified on:
	 */
	public boolean elementNotDisplay(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed() == true)
				return flag;

		} catch (Exception e) {
			LogUtility.logException("-->elementNotDisplay<--", "Given element is present", e, LoggingLevel.ERROR, true);
			flag = true;
		}
		return flag;

	}

	/**
	 * To Verify text value
	 * 
	 * @param element:Element to get actual text, textValue: Expected string value
	 * @Created on: 
	 * @Modified on:
	 */
	public boolean verifyTextContains(WebElement element, String textValue) {
		try {
			ConcurrentEngines.getEngine().getWait().waitUntilElementIsPresent(element);
			containsText = ConcurrentEngines.getEngine().getWebActions().getTextJS(element);
			if ((containsText.length() > 0)
					&& (containsText.contains(textValue) || (textValue.contains(containsText)))) {
				LogUtility.logInfo("Text verified Successfully " + containsText);
				return true;
			} else
				return false;
		} catch (Exception e) {
			LogUtility.logException("-->verifyTextContains<--", "Failed to Verify Text Contains", e, LoggingLevel.ERROR,
					true);
			return false;
		}
	}

	/**
	 * clickonTableCell:- To Click on link in a table based on the passed unique
	 * value
	 * 
	 * @param tablElement:- Table Element
	 * @param value:- Unique value to identify row
	 */
	public void clickOnTableCell(WebElement tablElement, String value) {
		try {
			int tblRows = tablElement.findElements(By.cssSelector(" tbody tr")).size();
			int tblColumns = tablElement.findElements(By.cssSelector(" thead > tr > th")).size();
			if (tblColumns == 0)
				tblColumns = tablElement.findElements(By.cssSelector(" tbody tr:nth-child(1) td")).size();
			outerloop: for (int row = 1; row <= tblRows; row++) {
				try {
					for (int col = 1; col <= tblColumns; col++) {
						String getValue = tablElement
								.findElement(
										By.cssSelector(" tbody tr:nth-child(" + row + ") td:nth-child(" + col + ")"))
								.getText();
						if (getValue.equals(value) || getValue.contains(value)) {
							for (int colmn = 1; colmn <= tblColumns; colmn++) {
								try {
									WebElement Link = tablElement.findElement(By.cssSelector(
											" tbody tr:nth-child(" + row + ") td:nth-child(" + colmn + ") a"));
									ConcurrentEngines.getEngine().getWait().waitUntilElementIsPresent(Link,
											maxTimeOutUtil);
									ConcurrentEngines.getEngine().getWebActions().clickElement(Link);
									ConcurrentEngines.getEngine().getWait().waitForPageToLoad(maxTimeOutUtil);
									LogUtility.logInfo("clickOnTableCell", "Clicked on the column with value " + value);
									break outerloop;
								} catch (Exception e) {
									continue;
								}
							}
						}
					}
				} catch (Exception e) {
					continue;
				}
			}
			ConcurrentEngines.getEngine().getWait().staticWait(5);
			LogUtility.logInfo("clickOnTableCell", "Clicked on element existed in a table");
		} catch (Exception e) {
			LogUtility.logException("-->clickOnTableCell<--", "Failed to Click on cell value in a Table", e,
					LoggingLevel.ERROR, true);
		}
	}

	/**
	 * selectValueByPartialVisibleText:- To select value in a dropdown based on
	 * Partial visible text
	 * 
	 * @param element: Drop Down Element
	 * @param text: Partial text value to search in Dropdown
	 */
	public void selectValueByPartialVisibleText(WebElement element, String text) {
		try {
			ConcurrentEngines.getEngine().getWait().waitUntilElementIsPresent(element);
			String index = null;
			List<WebElement> elementOptions = element.findElements(By.tagName("option"));
			for (WebElement subElement : elementOptions) {
				if (subElement.getAttribute("innerText").contains(text)) {
					index = subElement.getAttribute("index");
					ConcurrentEngines.getEngine().getWebActions().selectDropDownByIndex(element,
							Integer.parseInt(index));
					break;
				}
			}
			LogUtility.logInfo("selectValueByPartialVisibleText",
					"Selected value by partial visible text in a dropdown");
		} catch (NumberFormatException e) {
			LogUtility.logException("-->selectValueByPartialVisibleText<--",
					"Failed to select the value by partially visible text", e, LoggingLevel.ERROR, true);
		}
	}

	/**
	 * setRequireDate:To edit current date and enter required date

	 * @param element- WebElement
	 * @param Period- Days/Years/Months
	 * @param num- Number to add /delete
	 */
	public void setRequireDate(WebElement element, String Period, int num) {
		try {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			switch (Period) {
			case "Days":
				cal.add(Calendar.DATE, num);
				break;
			case "Months":
				cal.add(Calendar.MONTH, num);
				break;
			case "Years":
				cal.add(Calendar.YEAR, num);
				break;
			default:
				break;
			}
			String requiredDate = dateFormat.format(cal.getTime());
			element.clear();
			ConcurrentEngines.getEngine().getWebActions().setValue(element, requiredDate);
			LogUtility.logInfo("setRequireDate", "Entered required date");
		} catch (Exception e) {
			LogUtility.logException("-->setRequireDate<--", "Failed to enter the required date", e, LoggingLevel.ERROR,
					true);
		}
	}

	/**
	 * mapValuesComaparison: To compare Linked Hash Map values

	 * @param firstMap
	 * @param secondMap
	 * @return
	 */
	public boolean mapValuesComaparison(LinkedHashMap<String, String> firstMap,
			LinkedHashMap<String, String> secondMap) {
		boolean matches = false;
		try {
			returnMap = new LinkedHashMap<String, String>();
			for (String key : firstMap.keySet()) {
				if (secondMap.containsKey(key)) {
					if (firstMap.get(key).contains(secondMap.get(key))) {
						returnMap.put(key, firstMap.get(key));
						matches = true;
					} else if (secondMap.get(key).contains(firstMap.get(key))) {
						returnMap.put(key, firstMap.get(key));
						matches = true;
					}
				}
			}
			LogUtility.logInfo("mapValuesComaparison", "Compared to Linked Hash Map values");
			return matches;
		} catch (Exception e) {
			LogUtility.logException("-->mapValuesComaparison<--", "Failed to Compare to Linked Hash Map values", e,
					LoggingLevel.ERROR, true);
			return false;
		}

	}

	public boolean mapValuesComaparison(LinkedHashMap<String, String> firstMap, Map<String, String> secondMap) {
		boolean matches = false;
		try {
			returnMap = new LinkedHashMap<String, String>();
			for (String key : firstMap.keySet()) {
				if (secondMap.containsKey(key)) {
					if (firstMap.get(key).contains(secondMap.get(key))) {
						returnMap.put(key, firstMap.get(key));
						matches = true;
					} else if (secondMap.get(key).contains(firstMap.get(key))) {
						returnMap.put(key, firstMap.get(key));
						matches = true;
					}
				}
			}
			LogUtility.logInfo("mapValuesComaparison", "Compared to Linked Hash Map values");
			return matches;
		} catch (Exception e) {
			LogUtility.logException("-->mapValuesComaparison<--", "Failed to Compare to Linked Hash Map values", e,
					LoggingLevel.ERROR, true);
			return false;
		}

	}

	/**
	 * To Verify text value is present or not (Not Empty) in the page
	 * 
	 * @param element:Element to get actual text, textValue: Expected string value
	 * @Created on:
	 * @Modified on:
	 */
	public boolean verifyValueIsNotEmpty(WebElement element) {
		boolean flag = false;
		try {
			String text = element.getText();
			String value = "";
			if (!(text.equals(value))) {
				LogUtility.logInfo("Text is Present in the Page" + text);
				flag = true;
			}
		} catch (Exception e) {
			LogUtility.logException("-->verifyValueIsNotEmpty<--", "Text is not displayed", e, LoggingLevel.ERROR,
					true);
			return false;
		}
		return flag;
	}

	/**
	 * clickMenuLinkWebcom: To click on link by link text
	 * 
	 * @param menu- Element
	 * @param linkValue- link Text
	 */
	public void clickMenuLinkWebcom(WebElement menu, String linkValue) {
		boolean flag = false;
		try {
			ConcurrentEngines.getEngine().getWait().waitForDOMready();
			WebElement linksSubMenu = null;
			try {
				linksSubMenu = ConcurrentEngines.getEngine().getWebDriver()
						.findElement(By.xpath("//a[text()='" + linkValue + "']"));
			} catch (Exception e) {
				if (linkValue.equalsIgnoreCase("Actions"))
					linksSubMenu = ConcurrentEngines.getEngine().getWebDriver()
							.findElement(By.cssSelector("div#menu a.more"));
				else if (linkValue.equalsIgnoreCase("Unenroll"))
					linksSubMenu = ConcurrentEngines.getEngine().getWebDriver()
							.findElement(By.cssSelector("li.is-active ul li:nth-child(2)>a"));
				else if (linkValue.equalsIgnoreCase("Unlock"))
					linksSubMenu = ConcurrentEngines.getEngine().getWebDriver()
							.findElement(By.cssSelector("li.is-active ul li:nth-child(1)>a"));
			}
			if (ConcurrentEngines.getEngine().getWait().waitUntilElementIsPresent(linksSubMenu, maxTimeOutUtil)) {
				flag = true;
				ConcurrentEngines.getEngine().getWebActions().clickElementJS(linksSubMenu);
			}
			ConcurrentEngines.getEngine().getWait().staticWait(5);
			if (flag) {
				LogUtility.logInfo("Clicked on link" + linkValue);
			} else {
				LogUtility.logError("clickMenuLinkWebcom:Failed to click on link" + linkValue);
			}

		} catch (Exception e) {
			LogUtility.logException("-->clickMenuLinkWebcom<--", "Failed to click  link" + linkValue, e,
					LoggingLevel.ERROR, true);
		}

	}

	/**
	 * verifyListValues- To verify values in a drop down having Option tag
	 * 
	 * @param element- Element
	 * @param listValue- Value to search
	 * @return
	 */
	public boolean verifyListValues(WebElement element, String listValue) {

		boolean flag = false;
		try {
			List<WebElement> options = element.findElements(By.tagName("option"));
			for (WebElement option : options) {
				if (option.getText().contains(listValue)) {
					flag = true;
					if (flag) {
						LogUtility.logInfo("Option " + option.getText() + "availabale in given list");
					} else {
						LogUtility.logError("Option " + option.getText() + " not availabale in given list");

					}
				}
			}
		} catch (Exception e) {
			LogUtility.logException("-->verifyListValues<--", "Failed to Verify List Values", e, LoggingLevel.ERROR,
					true);
		}
		return flag;
	}

	/**
	 * To generate Random String (Upper case)for given range
	 * 
	 * @param element: Provide range value
	 * @Created on: 
	 * @Modified on:
	 */
	public String getAlphaNumericString(int size) {
		// Lower limit for UpperCase Letters
		int lowerLimit = 65;
		// Upper limit for UpperCase Letters
		int upperLimit = 90;
		Random random = new Random();
		// Create a StringBuffer to store the result
		StringBuffer r = new StringBuffer(size);
		for (int letter = 0; letter < size; letter++) {
			// take a random value between 65 and 90
			int nextRandomChar = lowerLimit + (int) (random.nextFloat() * (upperLimit - lowerLimit + 1));
			// append a character at the end of bs
			r.append((char) nextRandomChar);
		}
		// return the resultant string
		return r.toString();
	}

	/**
	 * To Get the Current System Date
	 * 
	 * @return: System current Date
	 */
	public String getCurrentDate() {
		String sysDate = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY");
			Date currentDate = new Date();
			sysDate = format.format(currentDate);
		} catch (Exception e) {
			LogUtility.logException("-->getCurrentDate<--", "Failed to get current system date", e, LoggingLevel.ERROR,
					true);
		}
		return sysDate;
	}

	/**
	 * This method used for Add/Subtract provided years to current system date
	 * 
	 * @param years
	 * @return : Updated date
	 * @throws Throwable
	 */
	public String dateAddorSubstract(String years) throws Throwable {
		try {
			String updatedDate;
			int yearsToModify = Integer.parseInt(years);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date currentDate = (Date) dateFormat.parse(getCurrentDate());
			Calendar cal = Calendar.getInstance();
			cal.setTime(currentDate);
			cal.add(Calendar.YEAR, yearsToModify);
			Date modifiedDate = cal.getTime();
			updatedDate = dateFormat.format(modifiedDate);
			return updatedDate;
		} catch (Exception e) {
			LogUtility.logException("-->dateAddorSubstract<--", "Failed to add or substract years", e,
					LoggingLevel.ERROR, true);
			return e.getMessage();
		}
	}

	/**
	 * To check the data in a table

	 * @param xpath         -- for the table
	 * @param otherColValue -- otherColValues should be <{1,"A"},{2,"B"}> and
	 * 
	 * @return
	 */
	public boolean checkFromTableDataWithColNumbers(String xpath, Map<Integer, String> otherColValues,
			int clickColNumber) {

		boolean flag = true;
		try {
			int tblRows = ConcurrentEngines.getEngine().getWebDriver().findElements(By.cssSelector(xpath + ">tbody>tr"))
					.size();
			outerloop: for (int row = 1; row <= tblRows; row++) {
				for (int eachCol : otherColValues.keySet()) {
					try {
						WebElement eachCell = ConcurrentEngines.getEngine().getWebDriver().findElement(By.cssSelector(
								xpath + "> tbody > tr:nth-child(" + row + ") > td:nth-child(" + eachCol + ")"));
						if (eachCell.getText().equals(otherColValues.get(eachCol))
								|| eachCell.getText().contains(otherColValues.get(eachCol))) {
							flag = false;
						} else
							break;
					} catch (Exception e) {
						continue;
					}
				}
				if (!flag) {
					LogUtility.logInfo("---> checkFromTableDataWithColNumbers:-",
							"Found all the column values in the table");
					if (clickColNumber != 0) {
						try {
							ConcurrentEngines.getEngine().getWebDriver().findElement(By.cssSelector(
									xpath + ">tbody>tr:nth-child(" + row + ")>td:nth-child(" + clickColNumber + ")>a"))
									.click();
							LogUtility.logInfo("---> checkFromTableDataWithColNumbers:-",
									"Clicked on the column " + clickColNumber);
						} catch (Exception e) {
							ConcurrentEngines
									.getEngine().getWebDriver().findElement(By.cssSelector(xpath
											+ ">tbody>tr:nth-child(" + row + ")>td:nth-child(" + clickColNumber + ")"))
									.click();
						}
					}
					break outerloop;
				}
			}

		} catch (Exception e) {
			LogUtility.logException("-->checkFromTableDataWithColNumbers<--", "Failed to Check the data in the table",
					e, LoggingLevel.ERROR, true);
		}
		return !flag;
	}

	/**
	 * To open a new tab
	 * 
	 * @param
	 * @Created on: 
	 * @Modified on:
	 */
	public void openANewBlankTab() {
		try {
			((JavascriptExecutor) ConcurrentEngines.getEngine().getWebDriver())
					.executeScript("window.open('about:blank','_blank');");
			ConcurrentEngines.getEngine().getWebDriver().manage().window().maximize();
			LogUtility.logInfo("openANewBlankTab", "Created a new tab");
		} catch (Exception e) {
			LogUtility.logException("-->openANewBlankTab<--", "Failed to create a new tab", e, LoggingLevel.ERROR,
					true);
		}

	}

	/**
	 * To close the current tab and switch the focus to new tab
	 * 
	 * @param
	 * @Created on:
	 * @Modified on:
	 */
	public void CloseAndSwitchFocusToNewtab() {
		try {
			Set<String> winSet = ConcurrentEngines.getEngine().getWebDriver().getWindowHandles();
			List<String> winList = new ArrayList<String>(winSet);
			String newTab = winList.get(winList.size() - 1);
			ConcurrentEngines.getEngine().getWebDriver().close();
			ConcurrentEngines.getEngine().getWebDriver().switchTo().window(newTab);
			LogUtility.logInfo("CloseAndSwitchFocusToNewtab",
					"Closed the current tab and switched the focus to new window");
		} catch (Exception e) {
			LogUtility.logException("-->CloseAndSwitchFocusToNewtab<--", "Failed to create a new tab", e,
					LoggingLevel.ERROR, true);
		}

	}

	/**
	 * To close the current tab and switch the focus to new tab
	 * 
	 * @param
	 * @Created on:
	 * @Modified on:
	 */
	public void switchToNewWindow() {
		try {
			Set<String> winSet = ConcurrentEngines.getEngine().getWebDriver().getWindowHandles();
			List<String> winList = new ArrayList<String>(winSet);
			String newTab = winList.get(winList.size() - 1);
			ConcurrentEngines.getEngine().getWebDriver().switchTo().window(newTab);
			LogUtility.logInfo("switchToNewWindow", "switched the focus to new window");
		} catch (Exception e) {
			LogUtility.logException("-->switchToNewWindow<--", "Failed to switch to new tab", e, LoggingLevel.ERROR,
					true);
		}

	}

	/**
	 * To close the current tab and switch the focus to new tab
	 * 
	 * @param
	 * @Created on:
	 * @Modified on:
	 */
	public void switchToMainWindow() {
		try {
			Set<String> winSet = ConcurrentEngines.getEngine().getWebDriver().getWindowHandles();
			List<String> winList = new ArrayList<String>(winSet);
			ConcurrentEngines.getEngine().getWebDriver().switchTo().window(winList.get(0));
			LogUtility.logInfo("switchToMainWindow", "switched the focus to main window");
		} catch (Exception e) {
			LogUtility.logException("-->switchToMainWindow<--", "Failed to switch to main tab", e, LoggingLevel.ERROR,
					true);
		}

	}

	/**
	 * To close the current tab and switch the focus to new tab
	 * 
	 * @param
	 * @Created on:
	 * @Modified on:
	 */
	public String getCurrentWindow() {
		return ConcurrentEngines.getEngine().getWebDriver().getWindowHandle();
	}

	/**
	 * To navigate one page back
	 * 
	 * @param
	 * @Created on:
	 * @Modified on:
	 */
	public void navigateBack() {
		try {
			ConcurrentEngines.getEngine().getWebDriver().navigate().back();
			LogUtility.logInfo("navigateBack", "navigated back to one page");
		} catch (Exception e) {
			LogUtility.logException("-->navigateBack<--", "Failed to navigate back", e, LoggingLevel.ERROR, true);
		}

	}

	/**
	 * Sorts the map by values
	 * 
	 * @param hm
	 * @return
	 */
	public HashMap<String, Integer> sortMapByValue(HashMap<String, Integer> hm) {
		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// put data from sorted list to hashmap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		LogUtility.logInfo("sortMapByValue", "Sorted the map by value");
		return temp;
	}

	/**
	 * To hover on an element
	 * 
	 * @param element
	 * @throws Exception
	 */
	public void hoverOnTheElement(WebElement element) throws Exception {
		try {
			Actions action = new Actions(ConcurrentEngines.getEngine().getWebDriver());
			action.moveToElement(element).build().perform();
			LogUtility.logInfo("hoverOnTheElement", "Hovering is complete");
		} catch (Exception e) {
			LogUtility.logException("-->hoverOnTheElement<--", "Exception in hovering the element", e,
					LoggingLevel.ERROR, true);
			throw new Exception("Exception in hovering the element" + e.getMessage());
		}
	}

	/**
	 * To hover on an element 
	 * 
	 * @param element
	 * @throws Exception
	 */
	public void doubleClickOnTheElement(WebElement element) throws Exception {
		try {
			Actions action = new Actions(ConcurrentEngines.getEngine().getWebDriver());
			action.doubleClick(element).build().perform();
			LogUtility.logInfo("doubleClickOnTheElement", "double clicking is complete");
		} catch (Exception e) {
			LogUtility.logError("doubleClickOnTheElement", e.getMessage());
			throw new Exception("Exception in doble clicking the element" + e.getMessage());
		}
	}

	/*
	 * Sanjay : 02-Aug-2019: Added Methods from Class : WebsterOnlineUtils.java
	 * Deleted WebsterOnlineUtils.java file from project
	 */

	public String getRandomString(int size) {
		String alphaChars = CucumberTestBase.props.getProperty("alphaChars");
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			sb.append(alphaChars.charAt(random.nextInt(alphaChars.length())));
		}
		return sb.toString();
	}

	public String getRandomNumber(int size) {
		String numberChars = CucumberTestBase.props.getProperty("numberChars");
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			sb.append(numberChars.charAt(random.nextInt(numberChars.length())));
		}
		return sb.toString();
	}

	public String getDateInTheFormat(String pattern, int days) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, days);
		return sdf.format(c.getTime());
	}

	public String getTimeStampWithHours(int hours) {
		SimpleDateFormat sdf = new SimpleDateFormat("H");
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.HOUR_OF_DAY, hours);
		return sdf.format(c.getTime());
	}

	/**
	 * To check if the date is in correct format
	 * 
	 * @param date
	 * @return
	 */
	public boolean dateValidation(String date) {
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		format.setLenient(false);
		try {
			format.parse(date);
			return true;
		} catch (ParseException e) {
			LogUtility.logException("-->dateValidation<--", "Date " + date + " is not valid according to "
					+ ((SimpleDateFormat) format).toPattern() + " pattern.", e, LoggingLevel.ERROR, true);
			return false;
		}
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public boolean isAlertPresent() {
		boolean status = false;
		WebDriverWait wait = new WebDriverWait(ConcurrentEngines.getEngine().getWebDriver(), maxTimeOutUtil);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			status = true;
			LogUtility.logInfo("--->isAlertPresent<---", "Alert is present");
		} catch (Exception e) {
			LogUtility.logException("-->isAlertPresent<--", "Failed to verify alert presence", e, LoggingLevel.ERROR,
					true);
		}
		return status;
	}

	/**
	 * 
	 * 
	 * @param pattern
	 * @param dateString
	 * @return
	 */
	public String changeTheDatePattern(String oldPattern, String newPattern, String dateString) {
		DateFormat sdf = new SimpleDateFormat(oldPattern);
		Date date = null;
		String newDatePattern = "";
		try {
			date = sdf.parse(dateString);
			newDatePattern = new SimpleDateFormat(newPattern).format(date);
			LogUtility.logInfo("changeTheDatePattern", "Date in new pattern is " + newDatePattern);
		} catch (ParseException e) {
			LogUtility.logException("-->changeTheDatePattern<--", "Failed to change The Date Pattern", e,
					LoggingLevel.ERROR, true);
		}
		return newDatePattern;
	}

	/**
	 * To check the tool tip message 
	 * 
	 * @param element
	 * @param message
	 * @return
	 */
	public boolean checkTheTooltipMessage(WebElement element, String message) {
		boolean status = false;
		try {
			ConcurrentEngines.getEngine().getWait().waitForDOMready();
			ConcurrentEngines.getEngine().getWait().waitUntilElementIsPresent(element);
			ConcurrentEngines.getEngine().getWebActions().clickElement(element);
			ConcurrentEngines.getEngine().getWait().staticWait(5);
			ConcurrentEngines.getEngine().getWait().waitForPageToLoad(maxTimeOutUtil);
			ConcurrentEngines.getEngine().getWait().waitForDOMready();
			if (!ConcurrentEngines.getEngine().getWebActions().getAttributeValue(element, "aria-describedby")
					.equals("")) {
				if (ConcurrentEngines.getEngine().getWebActions().getAttributeValue(element, "data-title")
						.equals(message))
					status = true;
				LogUtility.logInfo("checkTheTooltipMessage", "Tooltip is present");
			} else
				LogUtility.logError("checkTheTooltipMessage", "Tool tip is not correct ");
		} catch (Exception e) {
			LogUtility.logException("-->checkTheTooltipMessage<--", "Failed to check The Tooltip Message", e,
					LoggingLevel.ERROR, true);
		}
		return status;
	}

	public LocalDate getDateWithoutHolidaysAndWeekend(LocalDate date, int days, String holidays) {
		LocalDate dateExp = null;
		try {
			dateExp = date.plusDays(days);
			dateExp = isWeekendOrHoliday(dateExp, holidays);
		} catch (Exception e) {
			LogUtility.logException("-->getDateWithoutHolidaysAndWeekend<--",
					"Failed to get Date Without Holidays And Weekend", e, LoggingLevel.ERROR, true);
		}
		return dateExp;

	}

	public LocalDate isWeekendOrHoliday(LocalDate localDate, String holidays) {
		LocalDate nonWeekendDate = null;
		try {
			nonWeekendDate = localDate;
			if (nonWeekendDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
				nonWeekendDate = nonWeekendDate.plusDays(2);
			} else if (nonWeekendDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
				nonWeekendDate = nonWeekendDate.plusDays(1);
			}
			while (checkIfHoliday(nonWeekendDate, holidays)) {
				nonWeekendDate = nonWeekendDate.plusDays(1);
			}
		} catch (Exception e) {
			LogUtility.logException("-->isWeekendOrHoliday<--", "Failed to verify Weekend Or Holiday", e,
					LoggingLevel.ERROR, true);
		}
		return nonWeekendDate;

	}

	public boolean checkIfHoliday(LocalDate date, String holidays) {
		boolean status = false;
		try {
			for (String eachHoldaiy : holidays.split(",")) {
				LocalDate dateLocal = LocalDate.parse(eachHoldaiy);
				if (dateLocal.compareTo(date) == 0) {
					status = true;
					break;
				}
			}
		} catch (Exception e) {
			LogUtility.logError("checkIfHoliday", e.getMessage());
		}
		return status;
	}

	/**
	 * To sort the list of strings 
	 * 
	 * @param oldList
	 * @param order
	 * @return
	 */
	public List<String> sortTheList(ArrayList<String> oldList, String order) {
		List<String> sortedList = new ArrayList<String>();
		try {
			if (order.contains("REVERSE"))
				sortedList = oldList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
			else
				sortedList = oldList.stream().sorted().collect(Collectors.toList());
			LogUtility.logInfo("sortTheList", "Sorted list is  :" + sortedList);
		} catch (Exception e) {
			LogUtility.logException("-->sortTheList<--", "Failed to sort The List", e, LoggingLevel.ERROR, true);
		}
		return sortedList;
	}

	/**
	 * verifyNaturalSortingOfElementsWithText: To verify the Elements List with text
	 * in natural sorting order
	 * 
	 * @param oldList
	 * @return
	 */
	public boolean verifyNaturalSortingOfElementsWithText(List<WebElement> oldList) {
		List<String> sortedList = new ArrayList<String>();
		try {
			for (WebElement webElement : oldList) {
				sortedList.add(ConcurrentEngines.getEngine().getWebActions().getText(webElement));
			}
			int size = sortedList.size();
			for (int i = 0; i < size - 1; i++) {
				if (sortedList.get(i).compareTo(sortedList.get(i + 1)) > 0) {
					LogUtility.logError("-->verifyNaturalSortingOfElementsWithText<--",
							"Natural oders is not following the elements Text");
					return false;
				}
			}
		} catch (Exception e) {
			LogUtility.logException("-->verifyNaturalSortingOfElementsWithText<--",
					"Failed to verify natural sorting of elements with text", e, LoggingLevel.ERROR, true);
		}
		return true;
	}

	/**
	 * 
	 * To verify the Table column name with out the tag in table structure
	 * 

	 * 
	 */

	public boolean verifyColumnNamesInHeaderLess(WebElement header, List<String> listValue) {
		boolean flag = false;
		try {
			boolean tblHeaderLess = header.isDisplayed();
			if (tblHeaderLess) {
				List<WebElement> columnNames = header.findElements(By.tagName("td"));
				int colSize = columnNames.size();
				int listSize = listValue.size();
				for (int colNum = 0; colNum < colSize; colNum++) {
					String columnName = columnNames.get(colNum).getText();
					for (int listoption = 0; listoption < listSize; listoption++) {
						String listValues = listValue.get(listoption);
						if (listValues.contains(columnName)) {
							LogUtility.logInfo("---> verifyColumnNamesInHeaderLess <---", "Verified header names");
						}
					}
				}
				flag = true;
			}
		} catch (Exception e) {
			LogUtility.logException("-->verifyColumnNamesInHeaderLess<--",
					"Failed to verify columnNames in Header Less", e, LoggingLevel.ERROR, true);
		}
		return flag;
	}

	/**
	 * To verify last column cell value based on column name
	 * 
	 * 
	 * 
	 * @WebElement table – Header of the table (Ex: WebElement
	 *             tableHead=driver.findElement(By.xpath("//*[@id='pendingTable_table']/thead"));)
	 * @WebElement tableBody – Body of the table (Ex: WebElement
	 *             resultsBody=driver.findElement(By.xpath("//*[@id='pendingTable_table']/tbody"));;) @
	 *             String colName – Complete column name @ String value – Value need
	 *             to verify
	 */
	public boolean verifyTableLastRowValues(WebElement table, WebElement tableBody, String colName, String value) {
		boolean flag = false;
		try {
			Integer columnIndex = 0;
			String completeName = null;
			String completeData = null;
			List<WebElement> columns = table.findElements(By.tagName("tr"));
			List<WebElement> columnNames = columns.get(0).findElements(By.tagName("th"));
			for (int colNum = 0; colNum < columnNames.size(); colNum++) {
				String columnName = columnNames.get(colNum).getText();
				if (columnName.contains("\n")) {
					completeName = columnName.replaceAll("\n", " ");
				} else {
					completeName = columnName;
				}
				if (completeName.toLowerCase().equals(colName.trim().toLowerCase())) {
					columnIndex = colNum;
					break;
				}
			}
			List<WebElement> results_rows = tableBody.findElements(By.tagName("tr"));
			int rowsCount = results_rows.size();
			List<WebElement> resultColumns = results_rows.get(rowsCount - 1).findElements(By.tagName("td"));
			String resultsData = (resultColumns.get(columnIndex)).getText();
			if (resultsData.contains("\n")) {
				completeData = resultsData.replaceAll("\n", " ");
			} else {
				completeData = resultsData;
			}
			if (completeData.toLowerCase().contains(value.trim().toLowerCase())) {
				LogUtility.logInfo("---> verifyTableLastRowValues <---", "Verified user status successfully");
				flag = true;
			}

		} catch (Exception e) {
			LogUtility.logException("-->verifyTableLastRowValues<--", "Failed to verify table last row values", e,
					LoggingLevel.ERROR, true);
		}
		return flag;
	}

	/**
	 * selectValueByPartialText:- To select value in a dropdown based on Partial
	 * visible text
	 * 
	 * @param element: Drop Down Element
	 * @param text: Partial text value to search in Dropdown
	 */
	public boolean selectValueByPartialText(WebElement element, String text) {
		boolean flag = false;
		try {
			ConcurrentEngines.getEngine().getWait().waitUntilElementIsPresent(element);
			String index = null;
			List<WebElement> elementOptions = element.findElements(By.tagName("option"));
			for (WebElement subElement : elementOptions) {
				if (subElement.getAttribute("innerText").contains(text)) {
					index = subElement.getAttribute("index");
					ConcurrentEngines.getEngine().getWebActions().selectDropDownByIndex(element,
							Integer.parseInt(index));
					flag = true;
					LogUtility.logInfo("selectValueByPartialText", "Selected value by partial text in a dropdown");
					break;
				}
			}
		} catch (Exception e) {
			LogUtility.logException("selectValueByPartialText", "Failed to Verify the text", e, LoggingLevel.ERROR,
					true);
		}
		return flag;
	}

	/**
	 * verifyListMesagses: To verify the List of Items in the Statement

	 * 
	 * @param            elements- List of WebElement
	 * @param message
	 * @param keyName
	 * @param methodName
	 * @return
	 */
	public boolean verifyListOfItems(List<WebElement> elements, Map<String, String> message, String keyName,
			String methodName) {
		boolean flag = false;
		int count = 0;
		try {
			String[] value = message.get(keyName).split(";");
			for (WebElement element : elements) {
				String text = element.getText().replaceAll("\n", " ");
				if (text.contains(value[count]) || (value[count]).contains(text)) {
					count = count + 1;
				}
			}
			if (count == elements.size()) {
				flag = true;
				LogUtility.logInfo(methodName + ": Text verified Successfully " + message.get(keyName));
			} else
				LogUtility.logInfo(methodName + ":Text not verified " + message.get(keyName));

		} catch (Exception e) {
			LogUtility.logException("" + methodName + "", "Failed to Verify the text", e, LoggingLevel.ERROR, true);
		}
		return flag;
	}
}
