package com.eugene.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
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
import com.eugene.entity.IrCurveHis;
import com.eugene.qualifiers.SelectedTreeNode;
import com.eugene.service.DbService;
import com.eugene.util.HierarchyKey;

@Named
@ViewScoped
//@javax.faces.bean.ViewScoped
//@SessionScoped 
//@RequestScoped
public class IrCurveHisBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject 	private Logger logger;
//	@Inject		private EntityManager entityManager;
	@Inject		private DbService dbService;
	@Inject		private BaseDateBean baseDateBean;
	
//	@Inject		private Event<GocMst> gocMstEvent;
//	@Inject 	private Event<List<GocMst>> gocListEvent;
	
	private List<IrCurveHis> irCurveHisList;
//	private List<GocMst> selectedGocMstList;
	private IrCurveHis selected;
	
	public IrCurveHisBean() {
	}
	
	@PostConstruct
	public void getFetch(){
		irCurveHisList = dbService.getList(new IrCurveHis(), baseDateBean.getBaseDate());
		logger.info("IrCurveHis Fetch 1: {},{}", baseDateBean.getBaseDate(), irCurveHisList.size());
	}
	public List<IrCurveHis> getIrCurveHisList() {
		return irCurveHisList;
	}
	public void setIrCurveHisList(List<IrCurveHis> irCurveHisList) {
		this.irCurveHisList = irCurveHisList;
	}

//-------------------------------------------------------------------------------------------------------------
/*	public void onRowSelect(SelectEvent event) {
		GocMst sel = (GocMst)event.getObject();
        FacesMessage msg = new FacesMessage("GocMst Selected", String.valueOf(((GocMst) event.getObject())));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println(sel.getGocName());
        
        gocMstEvent.fire(sel);
	}*/
	
	public void onBaseDateChange(@Observes LocalDate baseDate){
		irCurveHisList = dbService.getList(new IrCurveHis(), baseDateBean.getBaseDate());
		logger.info("Re fectch Entry Result on the baseDate Change Event to {}", baseDate);
	}

}
