
package com.cl.borrower_web.utilities;

import com.aventstack.extentreports.Status;
import com.cl.java_af.reporting.ExtentTestManager;
import com.cl.java_af.utilities.LogUtility;

public class GenericLibrary {

	public static void reportInfo(String message) {
		ExtentTestManager.getTest().log(Status.INFO, message);
		LogUtility.logInfo(message);
	}

	public static void reportPass(String message) {
		ExtentTestManager.getTest().log(Status.PASS, message);
		LogUtility.logInfo(message);
	}

	public static void reportFail(String message) {
		ExtentTestManager.getTest().log(Status.FAIL, message);
		LogUtility.logInfo(message);
	}
}

