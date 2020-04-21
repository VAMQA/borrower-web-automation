package com.cl.borrower_web.runners;

import com.cl.java_af.testbases.CucumberTestBase;

import cucumber.api.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features/web" }, glue = "com.cl.borrower_web.steps", plugin = { "pretty",
		"json:target/cucumber-reports/CucumberTestReport.json",
		"rerun:target/cucumber-reports/rerun.txt" }, monochrome = true, strict = false, dryRun = false)


///transferFunds
///payBills
public class WebTestRunner extends CucumberTestBase {
}