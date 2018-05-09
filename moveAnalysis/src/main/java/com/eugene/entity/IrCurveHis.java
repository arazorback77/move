package com.eugene.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.eugene.util.Navigatable;


@Entity(name="IrCurveHis")
@IdClass(value = IrCurveHisId.class)
@Table(name = "IF7_IR_CURVE_HIS")
public class IrCurveHis implements Serializable, Navigatable{
	private static final long serialVersionUID = 1L;

	private LocalDate baseDate;
	private String ircId;
	private String matCd;
	private double intRate;
	public IrCurveHis() {
	}
	@Id
	public LocalDate getBaseDate() {
		return baseDate;
	}
	public void setBaseDate(LocalDate baseDate) {
		this.baseDate = baseDate;
	}
	@Id
	public String getIrcId() {
		return ircId;
	}
	public void setIrcId(String ircId) {
		this.ircId = ircId;
	}
	@Id
	public String getMatCd() {
		return matCd;
	}
	public void setMatCd(String matCd) {
		this.matCd = matCd;
	}
	
	@Column(name = "IR_RATE")
	public double getIntRate() {
		return intRate;
	}
	public void setIntRate(double intRate) {
		this.intRate = intRate;
	}
	
	
	@Transient
	public String idString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("#").append(getBaseDate());
		buffer.append("#").append(getIrcId());
		buffer.append("#").append(getMatCd());

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
		if (!(other instanceof FeMst))
			return false;
		IrCurveHis castOther = (IrCurveHis) other;

		return this.idString().equals(castOther.idString());
	}

	@Transient
	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (idString() == null ? 0 : this.idString().hashCode());
		return result;
	}
	
	

}
