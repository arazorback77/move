package com.eugene.bean;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.eugene.entity.GocCashFlow;
import com.eugene.entity.GocMst;
import com.eugene.entity.GocPv;

@Named
@ViewScoped
//@javax.faces.bean.ViewScoped
//@SessionScoped 
//@RequestScoped
public class GocPvBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject 	private Logger logger;
	
	@Inject
	private BaseDateBean baseDateBean;
	@Inject
	private EntityManager entityManager;
	
	private String query ;
	
	private List<GocPv> gocPvList;
	private List<GocPv> filteredList;
	private List<GocPv> selectedGocPvList;
	
	
	private GocPv selected;
	
//	private List<ColumnModel> columnList = new ArrayList<ColumnModel>();
	
	@PostConstruct
	public void getFetch(){
		query = "select a from GocPv a";
		gocPvList = entityManager.createQuery(query).getResultList();
//		query = "select a from GocCashFlow a where a.baseDate = :baseDate";
//		gocCfList = entityManager.createQuery(query).setParameter("baseDate", baseDateBean.getBaseDate()).getResultList();
		
		System.out.println("Fetch Goc Pv ");
	}

	public List<GocPv> getGocPvList() {
		return gocPvList;
	}

	public void setGocPvList(List<GocPv> gocPvList) {
		this.gocPvList = gocPvList;
	}

	public List<GocPv> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<GocPv> filteredList) {
		this.filteredList = filteredList;
	}

	public List<GocPv> getSelectedGocPvList() {
		return selectedGocPvList;
	}

	public void setSelectedGocPvList(List<GocPv> selectedGocPvList) {
		this.selectedGocPvList = selectedGocPvList;
	}

	public void onGocListChange(@Observes List<GocMst> list){
		list.forEach(s->logger.info("list : {}", s.getGocName()));
		List<String> names = list.stream().map(s -> s.getGocId()).collect(Collectors.toList());
		selectedGocPvList = gocPvList.stream().filter(s-> names.contains(s.getGocId())).collect(Collectors.toList());
//		logger.info("Hierarchy Node Change Event bef : {}, {}",filteredList);
//		filteredList=gocCfList.stream().filter(s-> names.contains(s.getGocId())).collect(Collectors.toList());
//		logger.info("Hierarchy Node Change Event aft : {}, {}",filteredList);
		logger.info("Hierarchy Node Change Event In GocPv : {}, {}",  selectedGocPvList.size());
	}
}
