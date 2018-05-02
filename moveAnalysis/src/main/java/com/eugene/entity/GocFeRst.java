package com.eugene.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.eugene.util.Navigatable;


@Entity(name="GocFeRst")
@IdClass(value = GocFeRstId.class)
@Table(name = "IF7_GOC_FE_RST")
public class GocFeRst implements Serializable, Navigatable {

	private static final long serialVersionUID = 1L;
//	private GocFeRstId GocFeRstId;
	private String baseDate;
	private String gocId;
	private String feCode;
//	private FeMst FeMst;
	
	private Double feResult;

	public GocFeRst() {
	}

//	@EmbeddedId
//	@AttributeOverrides({
//			@AttributeOverride(name = "baseDate", column = @Column(name = "BASE_DATE", nullable = false, length = 8) ) ,
//			@AttributeOverride(name = "gocId", column = @Column(name = "GOC_ID", nullable = false, length = 20) ),
//			@AttributeOverride(name = "feCode", column = @Column(name = "FE_CODE", nullable = false, length = 20) )
//			})
//	public GocFeRstId getGocFeRstId() {
//		return this.GocFeRstId;
//	}
//	
//	public void setGocFeRstId(GocFeRstId GocFeRstId) {
//		this.GocFeRstId = GocFeRstId;
//	}


//	public void setFeMst(FeMst FeMst) {
//		this.FeMst = FeMst;
//	}
//
//	public FeMst getFeMst() {
//		return this.FeMst;
//	}

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
	@Column(name = "FE_CODE", nullable = false, length = 20)
	public String getFeCode() {
		return feCode;
	}

	public void setFeCode(String feCode) {
		this.feCode = feCode;
	}
	
	
	@Column(name ="FE_RESULT" , nullable=true)
	public Double getFeResult() {
		return this.feResult;
	}

	public void setFeResult(Double feResult) {
		this.feResult = feResult;
	}
	
	@Transient
	public String idString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("#").append(getBaseDate());
		buffer.append("#").append(getGocId());
		buffer.append("#").append(getFeCode());

		String rst = buffer.toString();

		return rst;
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
		GocFeRst other = (GocFeRst) obj;
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

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((GocFeRstId == null) ? 0 : GocFeRstId.hashCode());
//		return result;
//	}
//
//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (obj == null) {
//			return false;
//		}
//		if (getClass() != obj.getClass()) {
//			return false;
//		}
//		GocFeRst other = (GocFeRst) obj;
//		if (GocFeRstId == null) {
//			if (other.GocFeRstId != null) {
//				return false;
//			}
//		} else if (!GocFeRstId.equals(other.GocFeRstId)) {
//			return false;
//		}
//		return true;
//	}

}
