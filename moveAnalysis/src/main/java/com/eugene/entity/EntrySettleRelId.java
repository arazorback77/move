package com.eugene.entity;
// Generated Mar 27, 2018 9:14:42 PM by Hibernate Tools 5.2.0.CR1 with Custom Template_takion!!!!!! 

import javax.persistence.Id;
import javax.persistence.Transient;
import com.eugene.util.Navigatable;

/**
 * If7EntrySettleRelId generated by hbm2java
 */

public class EntrySettleRelId implements java.io.Serializable, Navigatable {

//	private String entryId;
//	private String settleId;
	private String entryMst;
	private String settleMst;
	private short entrySeq;

	public EntrySettleRelId() {
	}

//	public String getEntryId() {
//		return this.entryId;
//	}
//
//	public void setEntryId(String entryId) {
//		this.entryId = entryId;
//
//	}
//
//	public String getSettleId() {
//		return this.settleId;
//	}
//
//	public void setSettleId(String settleId) {
//		this.settleId = settleId;
//
//	}

	public short getEntrySeq() {
		return this.entrySeq;
	}

	public String getEntryMst() {
		return entryMst;
	}

	public void setEntryMst(String entryMst) {
		this.entryMst = entryMst;
	}

	public String getSettleMst() {
		return settleMst;
	}

	public void setSettleMst(String settleMst) {
		this.settleMst = settleMst;
	}

	public void setEntrySeq(short entrySeq) {
		this.entrySeq = entrySeq;

	}

	/**
	 * idString
	 * @return String
	 */
	public String idString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("#").append(getEntryMst());
		buffer.append("#").append(getSettleMst());
		buffer.append("#").append(getEntrySeq());

		String rst = buffer.toString();

		return rst;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EntrySettleRelId))
			return false;
		EntrySettleRelId castOther = (EntrySettleRelId) other;

		return ((this.getEntryMst() == castOther.getEntryMst()) || (this.getEntryMst() != null && castOther.getEntryMst() != null && this.getEntryMst().equals(castOther.getEntryMst())))
				&& ((this.getSettleMst() == castOther.getSettleMst())
						|| (this.getSettleMst() != null && castOther.getSettleMst() != null && this.getSettleMst().equals(castOther.getSettleMst())))
				&& (this.getEntrySeq() == castOther.getEntrySeq());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getEntryMst() == null ? 0 : this.getEntryMst().hashCode());
		result = 37 * result + (getSettleMst() == null ? 0 : this.getSettleMst().hashCode());
		result = 37 * result + this.getEntrySeq();
		return result;
	}

}
