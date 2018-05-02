package com.eugene.enums;

public enum ESettleType {
	
	SETTLE_START("0")
,	ENTRY_RST ("+")
,   ENTRY_SUM("99")	

;
	private String alias;
	
	private ESettleType(String alias) {
		this.alias =alias;
	}
	
	
	public String getAlias() {
		return alias;
	}
	
	
}
