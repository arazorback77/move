package com.eugene.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;

import com.eugene.entity.GocMst;
import com.eugene.qualifiers.SelectedTreeNode;
import com.eugene.util.HierarchyKey;

@Named
@ViewScoped
//@javax.faces.bean.ViewScoped
//@SessionScoped 
//@RequestScoped
public class GocMstBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject 	private Logger logger;
	
	@Inject
	private EntityManager entityManager;
	
	@Inject 
	private Event<GocMst> gocMstEvent;
	
	@Inject 
	private Event<List<GocMst>> gocListEvent;
	
	
	private String query ;
	
	private List<GocMst> gocMstList;
	private List<GocMst> selectedGocMstList;
	private GocMst selected;
	
	private Map<String, List<GocMst>> entryMap = new HashMap<>();
	
//	private List<ColumnModel> columnList = new ArrayList<ColumnModel>();
	
	@PostConstruct
	public void getFetch(){
		query = "select a from GocMst a ";
//		query = "select a from NcmLv1Product a where a.finProdId like '%KR%'";
//		query = "select a from NcmLv1Product a where a.intRate.irId =#{selectedProduct.mvId}";
		gocMstList = entityManager.createQuery(query).getResultList();
		selectedGocMstList =gocMstList;
		System.out.println("Fetch Goc Mst");
	}



	public List<GocMst> getGocMstList() {
		return gocMstList;
	}
	public void setGocMstList(List<GocMst> gocMstList) {
		this.gocMstList = gocMstList;
	}



	public GocMst getSelected() {
		return selected;
	}
	public void setSelected(GocMst selected) {
		this.selected = selected;
	}
	
	
	public List<GocMst> getSelectedGocMstList() {
		return selectedGocMstList;
	}



	public void setSelectedGocMstList(List<GocMst> selectedGocMstList) {
		this.selectedGocMstList = selectedGocMstList;
	}


//-------------------------------------------------------------------------------------------------------------
	public void onRowSelect(SelectEvent event) {
		GocMst sel = (GocMst)event.getObject();
        FacesMessage msg = new FacesMessage("GocMst Selected", String.valueOf(((GocMst) event.getObject())));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println(sel.getGocName());
        
        gocMstEvent.fire(sel);
	}
	


	public Map<String, List<GocMst>> groupingBy(List<String> propList){
		entryMap = getGocMstList().stream().collect(Collectors.groupingBy(item->item.getPropertyValue(propList), Collectors.toList()));
		 return entryMap;
	}

	/*public void onHierarchyNodeChange(@Observes @SelectedTreeNode TreeNode node){
		
		selecteEntryRstList = entryRstList.stream().filter(s->s.filter(nodeMap)).collect(Collectors.toList());
		logger.info("Hierarchy Node Change Event : {}, {}", nodeMap, selecteEntryRstList.size());
	}*/
	
	public void onHierarchyNodeChange(@Observes @SelectedTreeNode HierarchyKey node){
		
		selectedGocMstList = gocMstList.stream().filter(s->s.filter(node.getKeyList(), node.getPropValueList())).collect(Collectors.toList());
		node.getPropValueList().forEach(s ->logger.info("list : {}", s));
		logger.info("Hierarchy Node Change Event In GocMstBean : {}, {}", node.getPropValueList(), selectedGocMstList.size());
		gocListEvent.fire(selectedGocMstList);
	}
	
}
