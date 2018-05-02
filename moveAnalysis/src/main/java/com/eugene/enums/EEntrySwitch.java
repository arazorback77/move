package com.eugene.enums;

public enum EEntrySwitch {
	
	ALL ("all")
,   POS_ONLY("+")	
,   NEG_ONLY("-")
;
	private String alias;
	
	private EEntrySwitch(String alias) {
		this.alias =alias;
	}
	
	
	public String getAlias() {
		return alias;
	}
	
	
}
