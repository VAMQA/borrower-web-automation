package com.cl.borrower_web.parameters;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonParametersObjectList implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Expose
	@SerializedName (value = "runList")
	public List<JsonParametersObjects> runList = new ArrayList<JsonParametersObjects> ();

	public List<JsonParametersObjects> getRunList() {
		return runList;
	}

	public void setRunList(List<JsonParametersObjects> runList) {
		this.runList = runList;
	}

	@Override
	public String toString() {
		return "Test Data RunList ["+ runList+"]";
	}
}
