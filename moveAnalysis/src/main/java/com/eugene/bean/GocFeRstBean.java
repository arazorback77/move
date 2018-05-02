package com.eugene.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.eugene.entity.GocFeRst;

@Named
@ViewScoped
//@javax.faces.bean.ViewScoped
//@SessionScoped 
//@RequestScoped
public class GocFeRstBean implements Serializable{
	
	
//	@Inject 	private Logger logger;
	
	@Inject
	private EntityManager entityManager;
	
	private String query ;
	
//	private NcmLv1Product selectProduct;
	
	private List<GocFeRst> feRstList;
	
	
//	private List<ColumnModel> columnList = new ArrayList<ColumnModel>();
	
	@PostConstruct
	public void getFetch(){
		query = "select a from GocFeRst a ";
//		query = "select a from NcmLv1Product a where a.finProdId like '%KR%'";
//		query = "select a from NcmLv1Product a where a.intRate.irId =#{selectedProduct.mvId}";
		feRstList = entityManager.createQuery(query).getResultList();
		System.out.println("Fetch Goc Fe Result");
	}


	public List<GocFeRst> getFeRstList() {
		return feRstList;
	}


	public void setFeRstList(List<GocFeRst> feRstList) {
		this.feRstList = feRstList;
	}

	
	
	
	
}
