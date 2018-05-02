package com.eugene.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.event.SelectEvent;

import com.eugene.entity.EntryMst;
import com.eugene.entity.EntryRst;
import com.eugene.entity.EntrySettleRel;
import com.eugene.entity.GocFeRst;
import com.eugene.entity.SettleMst;
import com.eugene.entity.SettleRst;

@Named
@ViewScoped
//@javax.faces.bean.ViewScoped
//@SessionScoped 
//@RequestScoped
public class EntryMstBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

//	@Inject 	private Logger logger;
	
	@Inject
	private EntityManager entityManager;
	
	private String query ;
	
	private List<EntryMst> entryMstList;
	
	private EntryMst selected;
	
	private List<EntryRst> entrySamples;
	
	private List<GocFeRst> feSamples;
	private List<SettleRst> settleSamples;
	
	
//	private List<ColumnModel> columnList = new ArrayList<ColumnModel>();
	
	@PostConstruct
	public void getFetch(){
		query = "select a from EntryMst a ";
//		query = "select a from NcmLv1Product a where a.finProdId like '%KR%'";
//		query = "select a from NcmLv1Product a where a.intRate.irId =#{selectedProduct.mvId}";
		entryMstList = entityManager.createQuery(query).getResultList();
		System.out.println("Fetch Entity Mst");
	}


	public List<EntryMst> getEntryMstList() {
		return entryMstList;
	}


	public void setEntryMstList(List<EntryMst> entryMstList) {
		this.entryMstList = entryMstList;
	}


	public EntryMst getSelected() {
		return selected;
	}


	public void setSelected(EntryMst selected) {
		this.selected = selected;
	}


	public void onRowSelect(SelectEvent event) {
	        FacesMessage msg = new FacesMessage("EntryMst Selected", String.valueOf(((EntryMst) event.getObject()).getEntrySettleRel().size()));
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        
    }	
	
	

	public List<SettleRst> getSettleSamples() {
		return settleSamples;
	}


	public void setSettleSamples(List<SettleRst> settleSamples) {
		this.settleSamples = settleSamples;
	}


	public List<GocFeRst> getFeSamples() {
		return feSamples;
	}


	public void setFeSamples(List<GocFeRst> feSamples) {
		this.feSamples = feSamples;
	}


	public List<EntryRst> getEntrySamples() {
		return entrySamples;
	}


	public void setEntrySamples(List<EntryRst> entrySamples) {
		this.entrySamples = entrySamples;
	}


	/*private void generateEntrySamples(EntryMst entry){
		EntryRst temp ;
		List<EntrySettleRel> calItems =	entry.getEntrySettleRel().stream().filter(s->!s.getUseFeYn().isTrueFalse()).collect(Collectors.toList());
		List<EntrySettleRel> feItems =	entry.getEntrySettleRel().stream().filter(s->s.getUseFeYn().isTrueFalse()).collect(Collectors.toList());
		int sign =1;
		if(calItems.size() ==0){
			for( int i =0 ; i< feItems.size() ; i++){
				sign =  i%2 ==0?-1 : 1;
				for ( EntrySettleRel aa : feItems){
					temp = new EntryRst();
					temp.setSeq(i);
					temp.setEntrySeq(aa.getEntrySeq());
					temp.setSettleId(aa.getSettleMst().getSettleId());
					temp.setEntryResult(new BigDecimal(sign * 100));
					
					
				}
			}
			
		}
	}*/
}
