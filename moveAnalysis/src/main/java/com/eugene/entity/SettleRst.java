package com.eugene.entity;
// Generated Mar 27, 2018 9:14:42 PM by Hibernate Tools 5.2.0.CR1 with Custom Template_takion!!!!!! 

import javax.persistence.Id;
import javax.persistence.Transient;
import com.eugene.util.Navigatable;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * If7SettleRst generated by hbm2java
 */

@Entity(name = "SettleRst")
@IdClass(value = SettleRstId.class)
@Table(name = "IF7_SETTLE_RST", schema = "TAKION79")
public class SettleRst implements java.io.Serializable, Navigatable {

	private String baseDate;
	private String gocId;
	private String settleId;
//	private SettleMst settleMst;
	private BigDecimal settleAmt;

	public SettleRst() {
	}

	@Id
	@Column(name = "BASE_DATE", nullable = false, length = 8)
	public String getBaseDate() {
		return this.baseDate;
	}

	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}

	@Id
	@Column(name = "GOC_ID", nullable = false, length = 20)
	public String getGocId() {
		return this.gocId;
	}

	public void setGocId(String gocId) {
		this.gocId = gocId;
	}


	@Id
	@Column(name = "SETTLE_ID", nullable = false, length = 20)
	public String getSettleId() {
		return this.settleId;
	}

	public void setSettleId(String settleId) {
		this.settleId = settleId;
	}

	@Column(name = "SETTLE_AMT", scale = 4)
	public BigDecimal getSettleAmt() {
		return this.settleAmt;
	}

	public void setSettleAmt(BigDecimal settleAmt) {
		this.settleAmt = settleAmt;

	}

	/**
	 * idString
	 * @return String
	 */
	@Transient
	public String idString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("#").append(getBaseDate());
		buffer.append("#").append(getGocId());
		buffer.append("#").append(getSettleId());
//		buffer.append("#").append(getSettleMst().getSettleId());
		

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
		if (!(other instanceof SettleRst))
			return false;
		SettleRst castOther = (SettleRst) other;

		return this.idString().equals(castOther.idString());
	}

	@Transient
	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBaseDate() == null ? 0 : this.getBaseDate().hashCode());
		result = 37 * result + (getGocId() == null ? 0 : this.getGocId().hashCode());
		result = 37 * result + (getSettleId() == null ? 0 : this.getSettleId().hashCode());
//		result = 37 * result + (getSettleMst().getSettleId() == null ? 0 : this.getSettleMst().getSettleId().hashCode());
		return result;
	}

}