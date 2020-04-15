package com.cl.borrower_web.parameters;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dataProvider")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLParametersObjectList implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement (name = "runList")
	private List<XMLParametersObjects> runList;
	
	public XMLParametersObjectList() {
	}
	
	public XMLParametersObjectList(List<XMLParametersObjects> runList) {
		this.runList = runList;
	}

	public List<XMLParametersObjects> getRunList() {
		return runList;
	}

	public void setRunList(List<XMLParametersObjects> runList) {
		this.runList = runList;
	}
	
	@Override
	public String toString() {
		return "Test Data XML list[runList = "+runList+"]";
	}
}
