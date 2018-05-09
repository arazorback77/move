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
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NaturalId;

import com.eugene.converter.StringLocalDateConverter;
import com.eugene.util.Navigatable;


public class IrCurveHisId implements Serializable, Navigatable {

	private static final long serialVersionUID = 1L;

	private LocalDate baseDate;
	private String ircId;
	private String matCd;
	

	public IrCurveHisId() {
	}
	
	@Column(name = "BASE_DATE", nullable = false)
	@Convert(converter = StringLocalDateConverter.class)
	public LocalDate getBaseDate() {
		return baseDate;
	}
	public void setBaseDate(LocalDate baseDate) {
		this.baseDate = baseDate;
	}
	
	@Column(name = "IRC_ID", nullable = false)
	public String getIrcId() {
		return ircId;
	}

	public void setIrcId(String ircId) {
		this.ircId = ircId;
	}
	
	@Column(name = "MAT_CD", nullable = false)
	public String getMatCd() {
		return matCd;
	}

	public void setMatCd(String matCd) {
		this.matCd = matCd;
	}

	public String idString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("#").append(getBaseDate());
		buffer.append("#").append(getIrcId());
		buffer.append("#").append(getMatCd());

		String rst = buffer.toString();

		return rst;
	}

	

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IrCurveHisId))
			return false;
		IrCurveHisId castOther = (IrCurveHisId) other;

		return ((
				this.getBaseDate() == castOther.getBaseDate())
				|| (this.getBaseDate() != null && castOther.getBaseDate() != null && this.getBaseDate().equals(castOther.getBaseDate())))
				&& 
				((this.getIrcId() == castOther.getIrcId())
						|| (this.getIrcId() != null && castOther.getIrcId() != null && this.getIrcId().equals(castOther.getIrcId())))
				&& 
				((this.getMatCd() == castOther.getMatCd())
						|| (this.getMatCd() != null && castOther.getMatCd() != null && this.getMatCd().equals(castOther.getMatCd())))
				;
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBaseDate() == null ? 0 : this.getBaseDate().hashCode());
		result = 37 * result + (getIrcId() == null ? 0 : this.getIrcId().hashCode());
		result = 37 * result + (getMatCd() == null ? 0 : this.getMatCd().hashCode());
		return result;
	}

}
