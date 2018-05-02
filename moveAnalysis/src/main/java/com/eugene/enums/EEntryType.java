package com.eugene.enums;

public enum EEntryType {
	
	EPV(true)
,	RA(true)
,   CSM(true)	
,   COCI(true)
,   SURPLUS(true)
, 	CASH	(false)
, 	ASSET	(false)
,   LOSS_COMP(true)
,   LOSS_ALLC(true)
,   DAC	(true)
,   DMC	(true)
,   CSM_AC(true)
,   CSM_MC(true)
,   EXP_ADJ(true)
,   INS_REV(true)
,   INS_COST(true)
,   FIN_COST(true)
,   OCI(true)
;
	private boolean creditEntryYn;
	
	private EEntryType(boolean creditEntryYn) {
		this.creditEntryYn =creditEntryYn;
	}
	
	
	public boolean isCreditEntry() {
		return creditEntryYn;
	}
	
	
}
