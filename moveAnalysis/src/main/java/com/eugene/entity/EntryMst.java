package com.eugene.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.eugene.util.Navigatable;


@Entity(name="EntryMst")
@Table(name = "IF7_ENTRY_MST")
public class EntryMst implements Serializable, Navigatable {

	private static final long serialVersionUID = 1L;

	private String entryId;
	private String entryName;
	private String entryGroup;
//	private Set<EntrySettleRel> entrySettleRel;
	private List<EntrySettleRel> entrySettleRel;

	public EntryMst() {
	}
	
	@Id
	@Column(name = "ENTRY_ID", nullable = false, length = 20)
	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	@Column(name = "ENTRY_NAME", nullable = true, length = 50)
	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	@Column(name = "ENTRY_GROUP", nullable = true, length = 50)
	public String getEntryGroup() {
		return entryGroup;
	}
	public void setEntryGroup(String entryGroup) {
		this.entryGroup = entryGroup;
	}
	
//	@OneToMany(mappedBy="entryMst", fetch=FetchType.EAGER)
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="ENTRY_ID")
	public List<EntrySettleRel> getEntrySettleRel() {
		return entrySettleRel;
	}

	public void setEntrySettleRel(List<EntrySettleRel> other) {
		entrySettleRel = other;
	}
	
	

	@Transient
	public String idString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("#").append(getEntryId());

		String rst = buffer.toString();

		return rst;
	}

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entryId == null) ? 0 : entryId.hashCode());
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
		EntryMst other = (EntryMst) obj;
		if (entryId == null) {
			if (other.entryId != null) {
				return false;
			}
		} else if (!entryId.equals(other.entryId)) {
			return false;
		}
		return true;
	}

}
