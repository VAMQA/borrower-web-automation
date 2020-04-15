package com.cl.borrower_web.parameters.init;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.testng.annotations.DataProvider;

import com.cl.borrower_web.parameters.XMLParametersObjectList;
import com.cl.borrower_web.parameters.XMLParametersObjects;

public class XMLParametersInit {

	public List<XMLParametersObjects> initialize(String filePath) {
		ClassLoader classLoader = getClass().getClassLoader();
		List<XMLParametersObjects> runList = null;
		try {
			JAXBContext context = JAXBContext.newInstance(XMLParametersObjectList.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			XMLParametersObjectList parameters = (XMLParametersObjectList) unmarshaller
					.unmarshal(new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(filePath))));
			runList = parameters.getRunList();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return runList;
	}

	public static void main(String[] args) {
		
	  new XMLParametersInit().initialize("data/dataProvider.xml").stream()
		  .filter(t ->
		  t.getTestDataName().equals("Test Data for valid user credentials 1"))
		  .forEach(c -> System.out.println(c.getUserName() + "--" + c.getPassword()));
		 		 
		new XMLParametersInit().getData();
	}

	/**
	 * This is a sample script for XML DataProvider returning a two dimensional
	 * object array.
	 * 
	 * @return Object[][]
	 */
	@DataProvider
	public Object[][] getData() {
		List<XMLParametersObjects> list = new XMLParametersInit().initialize("data/dataProvider.xml");
		Object[][] data = new Object[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			data[i][0] = list.get(i).getUserName();
			data[i][1] = list.get(i).getPassword();
			System.out.println("Test Data is " + data[i][0] + "----" + data[i][1]);
		}
		return data;
	}

}
