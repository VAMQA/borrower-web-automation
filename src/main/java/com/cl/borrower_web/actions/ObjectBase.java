package com.cl.borrower_web.actions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import com.cl.borrower_web.testbases.BorrowerTestBase;
import com.cl.borrower_web.utilities.BorrowerWebUtil;
import com.cl.java_af.capabilities.CapabilityParser;
import com.cl.java_af.engine.Alerts;
import com.cl.java_af.engine.Engine;
import com.cl.java_af.engine.Navigator;
import com.cl.java_af.engine.Waits;
import com.cl.java_af.engine.WebActions;
import com.cl.java_af.parameters.JsonDataParser;
import com.cl.java_af.reporting.ReportLibrary;
import com.cl.java_af.setup.ConcurrentEngines;
import com.cl.java_af.testbases.CucumberTestBase;

public class ObjectBase {

	public Capabilities caps;
	public Engine customEngine;
	public static WebDriver customeDriver;
	public WebActions customWebActions;
	public Waits customWaits;

	protected static ConcurrentMap<String, String> runtimeDataMap = new ConcurrentHashMap<>();

	public WebDriver driver = ConcurrentEngines.getEngine().getWebDriver();
	public WebActions webActions = ConcurrentEngines.getEngine().getWebActions();
	public Waits waits = ConcurrentEngines.getEngine().getWait();
	public Navigator navigator = ConcurrentEngines.getEngine().getNavigator();
	public Alerts alerts = ConcurrentEngines.getEngine().getAlerts();

	public JsonDataParser jsonDataParser = ConcurrentEngines.getEngine().getJsonDataParser();
	public Map<String, String> testDataMap = ConcurrentEngines.getEngine().getJsonDataParser().getTestDataMap();

	public ReportLibrary reportLibrary = ConcurrentEngines.getEngine().getReportLibrary();

	public String appURL = ConcurrentEngines.envParams.getAppUrl();
	public String username = ConcurrentEngines.envParams.getUsername();
	public String password = ConcurrentEngines.envParams.getPassword();
	
	public String browserName = ConcurrentEngines.getEngine().getBrowser();
	public String browserVersion = ConcurrentEngines.getEngine().getBrowserVersion();
	public Long maxTimeOut = Long.parseLong(CucumberTestBase.props.getProperty("sync.max.timeout"));

	public BorrowerWebUtil BorrowerWebUtil = new BorrowerWebUtil();

	public void createCustomEngine(String browserName) throws Exception {
		try {
			String appUrl = ConcurrentEngines.envParams.getAppUrl();

			caps = CapabilityParser.parseBrowserCapabilities("capabilities/browserCapabilities.json", "local",
					browserName);
			ConcurrentEngines.createCustomEngine(caps, browserName, false, false, false);
			customEngine = ConcurrentEngines.getCustomEngine();
			customeDriver = customEngine.getWebDriver();
			customWebActions = ConcurrentEngines.getCustomEngine().getWebActions();
			customWaits = ConcurrentEngines.getCustomEngine().getWait();

			// customEngine.getNavigator().goToUrl(appUrl);
		} catch (Exception e) {

		}
	}

	public String getValueFromRuntimeDataMap(String key) {
		return runtimeDataMap.get(key);
	}

	public void setValueInRuntimeDataMap(String key, String value) {
		runtimeDataMap.put(key, value);
	}

	public String getEnvironmentProperty(String key) {
		return BorrowerTestBase.envProps.getProperty(key);
	}

	public String getTestProperty(String key) {
		return BorrowerTestBase.props.getProperty(key);
	}

	public void reportInfo(String message) {
		reportLibrary.reportInfo(message);
	}

	public void reportPass(String message) {
		reportLibrary.reportPass(message);
	}

	public void reportPass(String message, boolean flag) {
		reportLibrary.reportPass(message, flag);
	}

	public void reportFail(String message) {
		reportLibrary.reportFail(message);
	}

	public void reportFail(String message, boolean flag) {
		reportLibrary.reportFail(message, flag);
	}

	public void reportHardFail(String message) {
		reportLibrary.reportHardFail(message);
	}

	public void reportHardFail(String message, boolean flag) {
		reportLibrary.reportHardFail(message);
	}

	public void reportPassWithFullPageScreenshot(String message) {
		reportLibrary.reportPassWithFullPageScreenshot(message);
	}

	public void reportPassWithFullPageScreenshot(String message, boolean flag) {
		reportLibrary.reportPassWithFullPageScreenshot(message, flag);
	}

	public void reportFailWithFullPageScreenshot(String message) {
		reportLibrary.reportFailWithFullPageScreenshot(message);
	}

	public void reportFailWithFullPageScreenshot(String message, boolean flag) {
		reportLibrary.reportFailWithFullPageScreenshot(message, flag);
	}

	public void reportHardFailWithFullPageScreenshot(String message) {
		reportLibrary.reportHardFailWithFullPageScreenshot(message);
	}

	public void reportHardFailWithFullPageScreenshot(String message, boolean flag) {
		reportLibrary.reportHardFailWithFullPageScreenshot(message, flag);
	}

}