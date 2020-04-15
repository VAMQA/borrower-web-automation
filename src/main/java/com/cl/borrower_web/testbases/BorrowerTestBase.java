package com.cl.borrower_web.testbases;

import java.lang.reflect.Method;

import org.testng.ITestContext;

import com.cl.java_af.testbases.CucumberTestBase;

/**
 * This class is supplied to override some of the default behavior of java-af
 * CucumberBase if desired.
 * 
 *
 */
public class BorrowerTestBase extends CucumberTestBase {

	@Override
	public void beforeMethod(ITestContext context, Method method) throws Exception {
		super.beforeMethod(context, method);
	}

}
