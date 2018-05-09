package com.eugene.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NaturalId;

import com.eugene.converter.StringLocalDateConverter;
import com.eugene.util.Navigatable;

public class GocCashFlowId implements Serializable, Navigatable {

	private static final long serialVersionUID = 1L;

	private LocalDate baseDate;
	private String gocId;
	private String eventType;
	private String cfType;
	private LocalDate cfDate;
	

	public GocCashFlowId() {
	}
	
	@Column(name = "BASE_DATE", nullable = false)
	@Convert(converter = StringLocalDateConverter.class)
	public LocalDate getBaseDate() {
		return baseDate;
	}
	public void setBaseDate(LocalDate baseDate) {
		this.baseDate = baseDate;
	}
	
	@Column(name = "GOC_ID", nullable = false)
	public String getGocId() {
		return gocId;
	}
	public void setGocId(String gocId) {
		this.gocId = gocId;
	}
	
	@Column(name = "EVENT_TYPE", nullable = false)
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	@Column(name = "CF_TYPE", nullable = false)
	public String getCfType() {
		return cfType;
	}
	public void setCfType(String cfType) {
		this.cfType = cfType;
	}
	
	@Column(name = "CF_DATE", nullable = false)
	@Convert(converter = StringLocalDateConverter.class)
	public LocalDate getCfDate() {
		return cfDate;
	}

	public void setCfDate(LocalDate cfDate) {
		this.cfDate = cfDate;
	}


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

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GocCashFlowId))
			return false;
		GocCashFlowId castOther = (GocCashFlowId) other;

		return ((
				this.getBaseDate() == castOther.getBaseDate())
				|| (this.getBaseDate() != null && castOther.getBaseDate() != null && this.getBaseDate().equals(castOther.getBaseDate())))
				&& 
				((this.getGocId() == castOther.getGocId())
						|| (this.getGocId() != null && castOther.getGocId() != null && this.getGocId().equals(castOther.getGocId())))
				&& ((this.getEventType() == castOther.getEventType())
						|| (this.getEventType() != null && castOther.getEventType() != null && this.getEventType().equals(castOther.getEventType())))
				&& ((this.getCfType() == castOther.getCfType())
						|| (this.getCfType() != null && castOther.getCfType() != null && this.getCfType().equals(castOther.getCfType())))
				&& ((this.getCfDate() == castOther.getCfDate())
						|| (this.getCfDate() != null && castOther.getCfDate() != null && this.getCfDate().equals(castOther.getCfDate())))
				
				;
	}

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

}
