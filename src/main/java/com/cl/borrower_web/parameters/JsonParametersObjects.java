package com.cl.borrower_web.parameters;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonParametersObjects implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Expose
	@SerializedName (value = "testDataName")
	public String testDataName;
	
	@Expose
	@SerializedName (value = "userName")
	private String userName;
	
	@Expose
	@SerializedName (value = "password")
	private String password;
	
	public JsonParametersObjects(String testDataName, String userName, String password) {
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
		return "Test Data[testDataName = "+testDataName + ", userName = "+userName + ", password = "+password + "]";
	}
	
}
