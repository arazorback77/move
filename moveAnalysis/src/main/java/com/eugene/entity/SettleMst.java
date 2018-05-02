package com.eugene.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.eugene.util.Navigatable;

@Entity(name="SettleMst")
@Table(name = "IF7_SETTLE_MST")
public class SettleMst implements Serializable, Navigatable {

	private static final long serialVersionUID = 1L;
	private String settleId;
	private String settleName;
//	private SettleMst upperSettleMst;
	private String settleGroup;
//	private FeMst FeMst;
	private String feCode;
	private String accountCode;
	private Integer accountSeq;
	private String settleType;
//	private Set<EntrySettleRel> EntrySettleRelSet;
//	private Set<SettleMst> SettleMstSet;
//	private Set<SettleRst> SettleRstSet;

	public SettleMst() {
	}
	
	@Id
	@Column(name = "SETTLE_ID", nullable = false, length = 20)
	public String getSettleId() {
		return settleId;
	}

	public void setSettleId(String settleId) {
		this.settleId = settleId;
	}

	
	@Column(name = "SETTLE_NAME", nullable = false, length = 50)
	public String getSettleName() {
		return settleName;
	}

	public void setSettleName(String settleName) {
		this.settleName = settleName;
	}

//	@Column(name = "UPPER_SETTLE_ID", nullable = false, length = 50)
//	public SettleMst getUpperSettleMst() {
//		return upperSettleMst;
//	}
//
//	public void setUpperSettleMst(SettleMst upperSettleMst) {
//		this.upperSettleMst = upperSettleMst;
//	}

	@Column(name = "SETTLE_GROUP", nullable = false, length = 50)
	public String getSettleGroup() {
		return settleGroup;
	}

	public void setSettleGroup(String settleGroup) {
		this.settleGroup = settleGroup;
	}

//	@Column(name = "SETTLE_GROUP", nullable = false, length = 50)
//	public FeMst getFeMst() {
//		return FeMst;
//	}
//
//	public void setFeMst(FeMst feMst) {
//		FeMst = feMst;
//	}

	@Column(name = "ACCOUNT_CODE", nullable = false, length = 50)
	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	@Column(name = "ACCOUNT_SEQ")
	public Integer getAccountSeq() {
		return accountSeq;
	}

	public void setAccountSeq(Integer accountSeq) {
		this.accountSeq = accountSeq;
	}

	@Column(name = "SETTLE_TYPE")
	public String getSettleType() {
		return settleType;
	}

	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}

	@Column(name = "FE_CODE")
	public String getFeCode() {
		return feCode;
	}

	public void setFeCode(String feCode) {
		this.feCode = feCode;
	}

	@Transient
	public String idString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("#").append(getSettleId());

		String rst = buffer.toString();

		return rst;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((settleId == null) ? 0 : settleId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SettleMst other = (SettleMst) obj;
		if (settleId == null) {
			if (other.settleId != null) {
				return false;
			}
		} else if (!settleId.equals(other.settleId)) {
			return false;
		}
		return true;
	}

}
