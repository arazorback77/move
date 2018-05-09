package com.eugene.util;

import java.util.ArrayList;
import java.util.List;

public class HierarchyKey {
	private String name;
	private List<String> keyList = new ArrayList<String>();
	private List<String> propValueList = new ArrayList<String>();
	public HierarchyKey() {
	}
	
	public HierarchyKey(String name, List<String> keyList, List<String> propValueList) {
		super();
		this.name = name;
		this.keyList = keyList;
		this.propValueList = propValueList;
	}
	public HierarchyKey(String name,  List<String> propValueList) {
		super();
		this.name = name;
		this.propValueList = propValueList;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getKeyList() {
		return keyList;
	}
	public void setKeyList(List<String> keyList) {
		this.keyList = keyList;
	}
	public List<String> getPropValueList() {
		return propValueList;
	}
	public void setPropValueList(List<String> propValueList) {
		this.propValueList = propValueList;
	}

	

}
