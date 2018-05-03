package com.eugene.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.eugene.converter.StringLocalDateConverter;
import com.eugene.util.AbstractEntity;
import com.eugene.util.Navigatable;


@Entity(name="GocMst")
@Table(name = "IF7_GOC_MST")
public class GocMst extends AbstractEntity implements Serializable, Navigatable {

	private static final long serialVersionUID = 1L;

	private String gocId;
	
	private String gocName;
	private String portfolio;
	private String lossTestType;
	private String cohort;
	private LocalDate initDate;
	

	public GocMst() {
	}
	
	@Id
	@Column(name="GOC_ID", nullable=false)
	public String getGocId() {
		return gocId;
	}

	public void setGocId(String gocId) {
		this.gocId = gocId;
	}

	@Column(name="GOC_NAME")
	public String getGocName() {
		return gocName;
	}

	public void setGocName(String gocName) {
		this.gocName = gocName;
	}

	@Column(name="INIT_DATE")
	@Convert(converter = StringLocalDateConverter.class)
	public LocalDate getInitDate() {
		return initDate;
	}

	public void setInitDate(LocalDate initDate) {
		this.initDate = initDate;
	}
	@Column(name="PORTFOLIO")
	public String getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}
	
	@Column(name="LOSS_TEST_TYPE")
	public String getLossTestType() {
		return lossTestType;
	}

	public void setLossTestType(String lossTestType) {
		this.lossTestType = lossTestType;
	}
	
	@Column(name="COHORT")
	public String getCohort() {
		return cohort;
	}

	public void setCohort(String cohort) {
		this.cohort = cohort;
	}

	@Transient
	public String idString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("#").append(getGocId());

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
		result = prime * result + ((gocId == null) ? 0 : gocId.hashCode());
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
		GocMst other = (GocMst) obj;
		if (gocId == null) {
			if (other.gocId != null) {
				return false;
			}
		} else if (!gocId.equals(other.gocId)) {
			return false;
		}
		return true;
	}

//	------------------------------------------------------------------------------------------------------------
	/*public String getKeyValue(List<String> keyList){
		String mName;
		String nodeString ="#";
		Class klass = GocMst.class;
		
		for(String key : keyList){
			mName = ENamingConvention.SNAKE_CASE.convertToCamelCase("get_" +key);
			
			try {
				nodeString = nodeString + klass.getDeclaredMethod(mName).invoke(this) +"#";
//						logger.info("invoke: {} ", klass.getDeclaredMethod(mName).invoke(zz));
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		return nodeString;
	}
	
	public Map<String,String> getKeyMap(List<String> keyList){
		Map<String, String> rst = new LinkedHashMap<String, String>();
		Class klass = GocMst.class;
		String mName;
		System.out.println("KeyList order : "+ keyList);
		for(String key : keyList){
			mName = ENamingConvention.SNAKE_CASE.convertToCamelCase("get_" +key);
			try {
				 rst.put(key, klass.getDeclaredMethod(mName).invoke(this).toString());
//						logger.info("invoke: {} ", klass.getDeclaredMethod(mName).invoke(zz));
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return rst;
	}
	
	public boolean filter(Map<String,String> nodeMap){
		Class klass = GocMst.class;
		String mName;
		boolean trueFalse=false;
//		System.out.println("KeyList order : "+ nodeMap);
			
		for(Map.Entry<String, String> entry	 : nodeMap.entrySet()){
			mName = ENamingConvention.SNAKE_CASE.convertToCamelCase("get_" +entry.getKey());
			try {
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
