package com.eugene.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.eugene.entity.EntryMst;
import com.eugene.entity.SettleMst;

@Named
@ViewScoped
//@javax.faces.bean.ViewScoped
//@SessionScoped 
//@RequestScoped
public class SettleMstBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

//	@Inject 	private Logger logger;
	
	@Inject
	private EntityManager entityManager;
	
	private String query ;
	
	private List<SettleMst> settleMstList;
	
	
//	private List<ColumnModel> columnList = new ArrayList<ColumnModel>();
	
	@PostConstruct
	public void getFetch(){
		query = "select a from SettleMst a ";
//		query = "select a from NcmLv1Product a where a.finProdId like '%KR%'";
//		query = "select a from NcmLv1Product a where a.intRate.irId =#{selectedProduct.mvId}";
		settleMstList = entityManager.createQuery(query).getResultList();
		System.out.println("Fetch Entity Mst");
	}


	public List<SettleMst> getSettleMstList() {
		return settleMstList;
	}


	public void setSettleMstList(List<SettleMst> settleMstList) {
		this.settleMstList = settleMstList;
	}




		
	
	
	
}
