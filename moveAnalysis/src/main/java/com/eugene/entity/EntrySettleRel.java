package com.eugene.entity;
// Generated Mar 27, 2018 9:14:42 PM by Hibernate Tools 5.2.0.CR1 with Custom Template_takion!!!!!! 

import javax.persistence.Id;
import javax.persistence.Transient;

import com.eugene.enums.EBoolean;
import com.eugene.enums.EEntrySwitch;
import com.eugene.enums.EEntryType;
import com.eugene.util.Navigatable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity(name = "EntrySettleRel")
@IdClass(value = EntrySettleRelId.class)
@Table(name = "IF7_ENTRY_SETTLE_REL", schema = "TAKION79")
public class EntrySettleRel implements java.io.Serializable, Navigatable {

//	private String entryId;
//	private String settleId;
	private EntryMst entryMst;
	private SettleMst settleMst;
	private short entrySeq;
	private EBoolean useFeYn;
	private EBoolean feConvertYn;
	private EEntrySwitch entryApplyType;
	private EBoolean showEntryYn;
	private EBoolean validItemYn;

	public EntrySettleRel() {
	}

//	@Id
//	@Column(name = "ENTRY_ID", nullable = false, length = 20)
//	public String getEntryId() {
//		return this.entryId;
//	}
//
//	public void setEntryId(String entryId) {
//		this.entryId = entryId;
//	}
//	@Id
//	@Column(name = "SETTLE_ID", nullable = false, length = 20)
//	public String getSettleId() {
//		return this.settleId;
//	}
//
//	public void setSettleId(String settleId) {
//		this.settleId = settleId;
//	}
	
	@Id
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="ENTRY_ID")
	public EntryMst getEntryMst() {
		return entryMst;
	}

	public void setEntryMst(EntryMst entryMst) {
		this.entryMst = entryMst;
	}

	@Id
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="SETTLE_ID" )
	public SettleMst getSettleMst() {
		return settleMst;
	}

	public void setSettleMst(SettleMst settleMst) {
		this.settleMst = settleMst;
	}


	@Id
	@Column(name = "ENTRY_SEQ", nullable = false, precision = 4, scale = 0)
	public short getEntrySeq() {
		return this.entrySeq;
	}

	public void setEntrySeq(short entrySeq) {
		this.entrySeq = entrySeq;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "USE_FE_YN", length = 1)
	public EBoolean getUseFeYn() {
		return useFeYn;
	}
	
	public void setUseFeYn(EBoolean useFeYn) {
		this.useFeYn = useFeYn;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "FE_CONVERT_YN", length = 1)
	public EBoolean getFeConvertYn() {
		return this.feConvertYn;
	}


	public void setFeConvertYn(EBoolean feConvertYn) {
		this.feConvertYn = feConvertYn;

	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ENTRY_APPLY_TYPE", length = 20)
	public EEntrySwitch getEntryApplyType() {
		return this.entryApplyType;
	}

	public void setEntryApplyType(EEntrySwitch entryApplyType) {
		this.entryApplyType = entryApplyType;

	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SHOW_ENTRY_YN", length = 1)
	public EBoolean getShowEntryYn() {
		return this.showEntryYn;
	}

	public void setShowEntryYn(EBoolean showEntryYn) {
		this.showEntryYn = showEntryYn;

	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "VALID_ITEM_YN", length = 1)
	public EBoolean getValidItemYn() {
		return this.validItemYn;
	}

	public void setValidItemYn(EBoolean validItemYn) {
		this.validItemYn = validItemYn;

	}

	/**
	 * idString
	 * @return String
	 */
	@Transient
	public String idString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("#").append(getEntryMst().getEntryId());
		buffer.append("#").append(getSettleMst().getSettleId());
		buffer.append("#").append(getEntrySeq());

		String rst = buffer.toString();

		return rst;
	}

	@Transient
	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EntrySettleRel))
			return false;
		EntrySettleRel castOther = (EntrySettleRel) other;

		return this.idString().equals(castOther.idString());
	}

	@Transient
	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getEntryMst().getEntryId() == null ? 0 : this.getEntryMst().getEntryId().hashCode());
		result = 37 * result + (getSettleMst().getSettleId() == null ? 0 : this.getSettleMst().getSettleId().hashCode());
		result = 37 * result + this.getEntrySeq();
		return result;
	}

}
