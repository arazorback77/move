package com.eugene.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.eugene.converter.StringLocalDateConverter;
import com.eugene.util.Navigatable;


@Entity(name="GocPv")
@IdClass(value = GocCashFlowId.class)
@Table(name = "IF7_GOC_PV")
public class GocPv implements Serializable, Navigatable {

	private static final long serialVersionUID = 1L;

	private LocalDate baseDate;
	private String gocId;
	private String eventType;
	private String cfType;
	private LocalDate cfDate;
	
	private double cfAmt;
	
	private double initRate;
	private double prevRate;
	private double currRate;
	private double irrRate;
	
	private double initPvBegin;
	private double prevPvBegin;
	private double initPv;
//	private double prevPv;
	private double currPv;
	private double intAmt;
	
	public GocPv() {
	}

	@Id
	public LocalDate getBaseDate() {
		return baseDate;
	}
	public void setBaseDate(LocalDate baseDate) {
		this.baseDate = baseDate;
	}

	@Id
	public String getGocId() {
		return gocId;
	}
	public void setGocId(String gocId) {
		this.gocId = gocId;
	}

	@Id
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	@Id
	public String getCfType() {
		return cfType;
	}
	public void setCfType(String cfType) {
		this.cfType = cfType;
	}

	@Id
	public LocalDate getCfDate() {
		return cfDate;
	}
	public void setCfDate(LocalDate cfDate) {
		this.cfDate = cfDate;
	}

	@Column(name = "CF_AMT", nullable = false)
	public double getCfAmt() {
		return cfAmt;
	}
	public void setCfAmt(double cfAmt) {
		this.cfAmt = cfAmt;
	}

	@Column(name = "INIT_RATE")
	public double getInitRate() {
		return initRate;
	}

	public void setInitRate(double initRate) {
		this.initRate = initRate;
	}
	@Column(name = "PREV_RATE")
	public double getPrevRate() {
		return prevRate;
	}

	public void setPrevRate(double prevRate) {
		this.prevRate = prevRate;
	}
	@Column(name = "CURR_RATE")
	public double getCurrRate() {
		return currRate;
	}

	public void setCurrRate(double currRate) {
		this.currRate = currRate;
	}
	
	@Transient
	public double getIrrRate() {
		return irrRate;
	}
	public void setIrrRate(double irrRate) {
		this.irrRate = irrRate;
	}
	
	@Column(name = "PV_INIT_BEGIN")
	public double getInitPvBegin() {
		return initPvBegin;
	}

	public void setInitPvBegin(double initPvBegin) {
		this.initPvBegin = initPvBegin;
	}
	
	@Column(name = "PV_PREV_BEGIN")
	public double getPrevPvBegin() {
		return prevPvBegin;
	}

	public void setPrevPvBegin(double prevPvBegin) {
		this.prevPvBegin = prevPvBegin;
	}
	
	@Column(name = "PV_INIT")
	public double getInitPv() {
		return initPv;
	}

	public void setInitPv(double initPv) {
		this.initPv = initPv;
	}

	@Column(name = "PV_CURR")
	public double getCurrPv() {
		return currPv;
	}

	public void setCurrPv(double currPv) {
		this.currPv = currPv;
	}
	
	@Transient
//	@Column(name = "PV_CURR")
	public double getIntAmt() {
		return intAmt;
	}
	public void setIntAmt(double intAmt) {
		this.intAmt = intAmt;
	}

	@Transient
	public String idString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("#").append(getBaseDate());
		buffer.append("#").append(getGocId());
		buffer.append("#").append(getEventType());
		buffer.append("#").append(getCfType());
		buffer.append("#").append(getCfDate());

		String rst = buffer.toString();

		return rst;
	}

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBaseDate() == null ? 0 : this.getBaseDate().hashCode());
		result = 37 * result + (getGocId() == null ? 0 : this.getGocId().hashCode());
		result = 37 * result + (getEventType() == null ? 0 : this.getEventType().hashCode());
		result = 37 * result + (getCfType() == null ? 0 : this.getCfType().hashCode());
		result = 37 * result + (getCfDate() == null ? 0 : this.getCfDate().hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
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
		GocPv other = (GocPv) obj;
		
			
		return ((this.getBaseDate() == other.getBaseDate())
				|| (this.getBaseDate() != null && other.getBaseDate() != null && this.getBaseDate().equals(other.getBaseDate())))
				&& ((this.getGocId() == other.getGocId())
						|| (this.getGocId() != null && other.getGocId() != null && this.getGocId().equals(other.getGocId())))
				&& ((this.getEventType() == other.getEventType())
						|| (this.getEventType() != null && other.getEventType() != null && this.getEventType().equals(other.getEventType())))
				&& ((this.getCfType() == other.getCfType())
						|| (this.getCfType() != null && other.getCfType() != null && this.getCfType().equals(other.getCfType())))
				&& ((this.getCfDate() == other.getCfDate())
						|| (this.getCfDate() != null && other.getCfDate() != null && this.getCfDate().equals(other.getCfDate())));
		
				
	}

}
