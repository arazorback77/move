package com.eugene.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
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
import com.eugene.qualifiers.SelectedTreeNode;
import com.eugene.service.DbService;
import com.eugene.util.HierarchyKey;

@Named
@ViewScoped
//@javax.faces.bean.ViewScoped
//@SessionScoped 
//@RequestScoped
public class GocCashFlowBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject 	private Logger logger;
	@Inject		private EntityManager entityManager;
	@Inject		private DbService dbService;
	@Inject		private BaseDateBean baseDateBean;
	
	private String query ;
	
	private List<GocCashFlow> gocCfList;
	private List<GocCashFlow> filteredList;
	private List<GocCashFlow> selectedGocCfList;
	
	
	private GocCashFlow selected;
	
//	private List<ColumnModel> columnList = new ArrayList<ColumnModel>();
	
	@PostConstruct
	public void getFetch(){
		gocCfList = dbService.getList(new GocCashFlow());
		selectedGocCfList = gocCfList;
		System.out.println("Fetch Goc CashFlow ");
	}

	public List<GocCashFlow> getGocCfList() {
		return gocCfList;
	}

	public void setGocCfList(List<GocCashFlow> gocCfList) {
		this.gocCfList = gocCfList;
	}
	
	public List<GocCashFlow> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<GocCashFlow> filteredList) {
		this.filteredList = filteredList;
	}
	public List<GocCashFlow> getSelectedGocCfList() {
		return selectedGocCfList;
	}

	public void setSelectedGocCfList(List<GocCashFlow> selectedGocCfList) {
		this.selectedGocCfList = selectedGocCfList;
	}

	/*public void onChangeGoc(@Observes GocMst gocMst){
		System.out.println(gocMst.getGocId());
		query = "select a from GocCashFlow a where a.baseDate = :baseDate and a.gocId =:gocId";
		gocCfList = entityManager.createQuery(query)
				.setParameter("baseDate", baseDateBean.getBaseDate())
				.setParameter("gocId", gocMst.getGocId())
				.getResultList();
	}*/
	
	public void onChangeGocNode(@Observes @SelectedTreeNode Map<String,String> gocMap){
//		selectedGocCfList = gocCfList.stream().filter(s->s.filter(gocMap)).collect(Collectors.toList());
		List<GocCashFlow> temp = gocCfList.stream().filter(s->s.filter(gocMap)).collect(Collectors.toList());
		selectedGocCfList = temp;
		logger.info("Hierarchy Node Change Event bef : {}, {}",filteredList);
		filteredList = temp;
		logger.info("Hierarchy Node Change Event aft : {}, {}",filteredList);
		logger.info("Hierarchy Node Change Event : {}, {}", gocMap, selectedGocCfList.size());
		  
	}
	
	/*public void onHierarchyNodeChange(@Observes @SelectedTreeNode HierarchyKey node){
		
		selectedGocCfList = gocCfList.stream().filter(s->s.filter(node.getKeyList(), node.getPropValueList())).collect(Collectors.toList());
		logger.info("Hierarchy Node Change Event In GocMstBean : {}, {}", node.getPropValueList(), selectedGocCfList.size());
	}*/

	public void onGocListChange(@Observes List<GocMst> list){
		list.forEach(s->logger.info("list : {}", s.getGocName()));
		List<String> names = list.stream().map(s -> s.getGocId()).collect(Collectors.toList());
		selectedGocCfList = gocCfList.stream().filter(s-> names.contains(s.getGocId())).collect(Collectors.toList());
		logger.info("Hierarchy Node Change Event bef : {}, {}",filteredList);
//		filteredList=gocCfList.stream().filter(s-> names.contains(s.getGocId())).collect(Collectors.toList());
		logger.info("Hierarchy Node Change Event aft : {}, {}",filteredList);
		logger.info("Hierarchy Node Change Event In GocCf : {}, {}",  selectedGocCfList.size());
	}
}
