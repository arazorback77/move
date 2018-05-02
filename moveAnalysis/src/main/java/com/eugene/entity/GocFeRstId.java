package com.eugene.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GocFeRstId implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String baseDate;
	private String gocId;
	private String feCode;

	public GocFeRstId() {
	}

	
	public GocFeRstId(String baseDate, String gocId, String feCode) {
		this.baseDate = baseDate;
		this.gocId = gocId;
		this.feCode = feCode;
	}


	@Column(name = "BASE_DATE", nullable = false, length = 8)
	public String getBaseDate() {
		return this.baseDate;
	}
	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}


	@Column(name = "GOC_ID", nullable = false, length = 20)
	public String getGocId() {
		return this.gocId;
	}
	public void setGocId(String gocId) {
		this.gocId = gocId;
	}

	
	@Column(name = "FE_CODE", nullable = false, length = 20)
	public String getFeCode() {
		return feCode;
	}

	public void setFeCode(String feCode) {
		this.feCode = feCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseDate == null) ? 0 : baseDate.hashCode());
		result = prime * result + ((gocId == null) ? 0 : gocId.hashCode());
		result = prime * result + ((feCode == null) ? 0 : feCode.hashCode());
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
		GocFeRstId other = (GocFeRstId) obj;
		if (baseDate == null) {
			if (other.baseDate != null) {
				return false;
			}
		} else if (!baseDate.equals(other.baseDate)) {
			return false;
		}
		if (gocId == null) {
			if (other.gocId != null) {
				return false;
			}
		} else if (!gocId.equals(other.gocId)) {
			return false;
		}
		if (feCode == null) {
			if (other.feCode != null) {
				return false;
			}
		} else if (!feCode.equals(other.feCode)) {
			return false;
		}
		return true;
	}

}
