package com.cl.borrower_web.parameters;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class XMLParametersObjects implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement (name = "testDataName")
	private String testDataName;
	
	@XmlElement (name = "userName")
	private String userName;
	
	@XmlElement (name = "password")
	private String password;
	
	public XMLParametersObjects() {
	}
	
	public XMLParametersObjects(String testDataName, String userName, String password) {
		this.testDataName = testDataName;
		this.userName = userName;
		this.password = password;
	}

	
	public String getTestDataName() {
		return testDataName;
	}

	public void setTestDataName(String testDataName) {
		this.testDataName = testDataName;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "XML Test Data [testDataName = "+testDataName+", username = "+userName+", password = " + password +"]";
	}
	
}
