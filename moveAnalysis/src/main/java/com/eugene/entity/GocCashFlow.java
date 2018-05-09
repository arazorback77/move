package com.eugene.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.eugene.util.AbstractEntity;
import com.eugene.util.ENamingConvention;
import com.eugene.util.Navigatable;


@Entity(name="GocCashFlow")
@IdClass(value = GocCashFlowId.class)
@Table(name = "IF7_GOC_CF")
public class GocCashFlow extends AbstractEntity implements Serializable, Navigatable {

	private static final long serialVersionUID = 1L;

	private LocalDate baseDate;
	private String gocId;
	private String eventType;
	private String cfType;
	private LocalDate cfDate;
	private double cfAmt;
	

	public GocCashFlow() {
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
		GocCashFlow other = (GocCashFlow) obj;
		
			
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

	
/*	public boolean filter(Map<String,String> nodeMap){
		Class klass = this.getClass();
		String mName;
		boolean trueFalse=false;
		System.out.println("KeyList order : "+ nodeMap);
			
		for(Map.Entry<String, String> entry	 : nodeMap.entrySet()){
			mName = ENamingConvention.SNAKE_CASE.convertToCamelCase("get_" +entry.getKey());
			System.out.println("aaa" + entry.getKey() +":"+ entry.getValue());
			try {
				System.out.println(klass.getDeclaredMethod(mName).invoke(this).toString());
				trueFalse = entry.getValue().equals(klass.getDeclaredMethod(mName).invoke(this).toString());
				if(!trueFalse){
					break;
				}
//				System.out.println(entry.getKey() +"_" + entry.getValue()+"_"+ klass.getDeclaredMethod(mName).invoke(this).toString() + trueFalse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return trueFalse;
	}*/
}
