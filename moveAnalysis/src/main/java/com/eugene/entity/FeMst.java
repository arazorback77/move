package com.eugene.entity;
// Generated Mar 27, 2018 9:14:42 PM by Hibernate Tools 5.2.0.CR1 with Custom Template_takion!!!!!! 

import javax.persistence.Id;
import javax.persistence.Transient;
import com.eugene.util.Navigatable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * If7FeMst generated by hbm2java
 */

@Entity(name = "FeMst")
@Table(name = "IF7_FE_MST", schema = "TAKION79")
public class FeMst implements java.io.Serializable, Navigatable {

	private String feCode;
	private String feCodeName;

	public FeMst() {
	}

	@Id
	@Column(name = "FE_CODE", unique = true, nullable = false, length = 20)
	public String getFeCode() {
		return this.feCode;
	}

	public void setFeCode(String feCode) {
		this.feCode = feCode;

	}

	@Column(name = "FE_CODE_NAME", length = 50)
	public String getFeCodeName() {
		return this.feCodeName;
	}

	public void setFeCodeName(String feCodeName) {
		this.feCodeName = feCodeName;

	}

	/**
	 * idString
	 * @return String
	 */
	@Transient
	public String idString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("#").append(getFeCode());

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
		FeMst castOther = (FeMst) other;

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
