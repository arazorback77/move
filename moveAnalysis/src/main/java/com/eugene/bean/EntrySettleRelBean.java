package com.eugene.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.eugene.entity.EntryMst;
import com.eugene.entity.EntryRst;
import com.eugene.entity.EntrySettleRel;

@Named
@ViewScoped
//@javax.faces.bean.ViewScoped
//@SessionScoped 
//@RequestScoped
public class EntrySettleRelBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

//	@Inject 	private Logger logger;
	
	@Inject
	private EntityManager entityManager;
	private String query ;
	private TreeNode root;
	
	private List<EntrySettleRel> entrySettleRelList;
	
	
	
	
	
//	private List<ColumnModel> columnList = new ArrayList<ColumnModel>();
	
	@PostConstruct
	public void getFetch(){
		query = "select a from EntrySettleRel a ";
//		query = "select a from NcmLv1Product a where a.finProdId like '%KR%'";
//		query = "select a from NcmLv1Product a where a.intRate.irId =#{selectedProduct.mvId}";
		entrySettleRelList = entityManager.createQuery(query).getResultList();

		
		System.out.println("Fetch entrySettleRelList");
	}


	public List<EntrySettleRel> getEntrySettleRelList() {
		return entrySettleRelList;
	}


	public void setEntrySettleRelList(List<EntrySettleRel> entrySettleRelList) {
		this.entrySettleRelList = entrySettleRelList;
	}

    
     
 
//    public TreeNode getRoot() {
//        return root;
//    }
//    
//    private TreeNode create(){
//    	TreeNode root;
//    	
//    	Map<EntryMst, List<EntrySettleRel>> rst = entrySettleRelList.stream().collect(Collectors.groupingBy(EntrySettleRel::getEntryMst, Collectors.toList()));
////    	for(EntrySettleRel ls : entrySettleRelList){
////    		root = 
////    	}
//    	for(Map.Entry<EntryMst, List<EntrySettleRel>> ee : rst.entrySet()){
//    		root = new DefaultTreeNode( ee.getKey(), null);
//    		
//    	}
//    }
	
	
	
}
