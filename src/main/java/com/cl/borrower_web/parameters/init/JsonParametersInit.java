package com.cl.borrower_web.parameters.init;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.cl.borrower_web.parameters.JsonParametersObjectList;
import com.cl.borrower_web.parameters.JsonParametersObjects;
import com.cl.java_af.setup.Enums.LoggingLevel;
import com.cl.java_af.utilities.LogUtility;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import gherkin.deps.com.google.gson.JsonIOException;

public class JsonParametersInit {

	private Gson gson;

	public JsonParametersInit() {
		gson = new Gson();
	}

	public List<JsonParametersObjects> initialize(String filePath) {
		ClassLoader classLoader = getClass().getClassLoader();
		List<JsonParametersObjects> runList = null;
		try {
			JsonParametersObjectList parameters = gson.fromJson(
					new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(filePath))),
					JsonParametersObjectList.class);
			runList = parameters.getRunList();
		} catch (JsonSyntaxException jse) {
			LogUtility.logException("JsonParametersInit.initialize",
					"Incorrect Json syntax. Please check the json " + filePath, jse, LoggingLevel.ERROR, true);
		} catch (JsonIOException jio) {
			LogUtility.logException("JsonParametersInit.initialize",
					"Json File not found or inaccessible at " + filePath, jio, LoggingLevel.ERROR, true);
			jio.printStackTrace();
		}
		return runList;
	}
	
	/**
	 * This is a sample script for Json DataProvider returning a two dimensional object array.
	 * @return Object[][]
	 */
	@DataProvider
	public Object[][] getData(){
		List<JsonParametersObjects> list = new JsonParametersInit().initialize("data/dataProvider.json");
		Object[][] data = new Object[list.size()][3];
		for(int i=0; i<list.size(); i++) {
			data[i][0] = list.get(i).getUserName();
			data[i][1] = list.get(i).getPassword();
			System.out.println("Test Data is "+data[i][0] + "----"+ data[i][1]);
		}
		return data;
	}

}
