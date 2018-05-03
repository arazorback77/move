package com.eugene.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.slf4j.Logger;

import com.eugene.entity.GocMst;
import com.eugene.entity.HierarchyMst;
import com.eugene.qualifiers.SelectedTreeNode;

@Named
//@SessionScoped
//@ViewScoped
public class GocMstTreeBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject 	
	private Logger logger;
	@Inject
	private EntityManager entityManager;
	
	@Inject
	private GocMstBean gocMstBean;  
	
	@Inject @SelectedTreeNode
	private Event<Map<String,String>> hierarchyChangeEventMap;

	@Inject 
	private Event<List<GocMst>> hierarchyChangeEventList;
	
	private String query ;
	
	private List<HierarchyMst> hierList;  
	private HierarchyMst selected;
	
	private TreeNode node;
	private TreeNode upperNode;
	private TreeNode rootNode;
	
	Map<String, List<GocMst>> rst = new HashMap<>();
	
	public GocMstTreeBean() {
	}


	@PostConstruct
	public void getFetch(){
//		query = "select a from HierarchyMst a order by a.seq ";
//		hierList = entityManager.createQuery(query).getResultList();
		query = "select a from HierarchyMst a where a.hierarchyId =:param";
		hierList = entityManager.createQuery(query).setParameter("param", "HH1").getResultList();
//		hierList.stream().map(s->s.getKeyList()).forEach(s -> logger.info("Post :{}", s));
		genTree();
	}

	public List<HierarchyMst> getHierList() {
		return hierList;
	}
	public void setHierList(List<HierarchyMst> hierList) {
		this.hierList = hierList;
	}
	public HierarchyMst getSelected() {
		return selected;
	}
	public void setSelected(HierarchyMst selected) {
		this.selected = selected;
	}
	public TreeNode getNode() {
		return node;
	}
	public void setNode(TreeNode node) {
		this.node = node;
	}
	public TreeNode getRootNode() {
		return rootNode;
	}
	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}
//-------------------------------------------------private method---------------------
	
	private void genTree() {
		Map<String, TreeNode> tempTree = new HashMap<>();
		String mapString="";
		Set<Map<String, String>> tempSet = new HashSet<Map<String,String>>();
		for(HierarchyMst aa : hierList){
			tempTree = new HashMap<>();
			
			rootNode = new DefaultTreeNode(new HashMap<String,String>(){{ put("ROOT", aa.getHierarchyName()); }}, null);
			aa.setRootNode(rootNode);
			aa.setNodeDefineSet(gocMstBean.getGocMstList().stream().map(s ->s.getPropertyMap(aa.getKeyList())).collect(Collectors.toSet()));
			
			tempSet = gocMstBean.getGocMstList().stream().map(s ->s.getPropertyMap(aa.getKeyList())).collect(Collectors.toSet());
			
			for(Map<String, String> bb : tempSet){
				upperNode = rootNode;
				mapString="";
				
				for(String key : aa.getKeyList()){
					mapString=key+"#"+bb.get(key);
					if(!tempTree.containsKey(mapString)){
						node = new DefaultTreeNode(new HashMap<String,String>(){{ put(key, bb.get(key)); }}, upperNode);
//						logger.info("Map11111111 : {},{}", bb.get(key),node);
						tempTree.put(mapString,node);
						upperNode = node;	
					}
					else{
						upperNode = tempTree.get(mapString);
//						logger.info("Mapzzzzzz : {},{}", bb.get(key),node);
					}
					
				}
			}
		}	
		logger.info("Hierarchy Initialized {}, {}");
	}
	
	
/*	private void genTree2() {
		Map<String, TreeNode> tempTree = new HashMap<>();
		String mapString="";
		
		for(HierarchyMst aa : hierList){
			tempTree = new HashMap<>();
			
			rootNode = new DefaultTreeNode(new HashMap<String,String>(){{ put("ROOT", aa.getHierarchyName()); }}, null);
//			aa.setRootNode(rootNode);
//			aa.setNodeDefineSet(gocMstBean.getGocMstList().stream().map(s ->s.getPropertyMap(aa.getKeyList())).collect(Collectors.toSet()));

			for(Map<String, String> bb : aa.getNodeDefineSet()){
				upperNode = rootNode;
				mapString="";
				
				for(String key : aa.getKeyList()){
					mapString=key+"#"+bb.get(key);
					if(!tempTree.containsKey(mapString)){
						node = new DefaultTreeNode(new HashMap<String,String>(){{ put(key, bb.get(key)); }}, upperNode);
//						logger.info("Map11111111 : {},{}", bb.get(key),node);
						tempTree.put(mapString,node);
						upperNode = node;	
					}
					else{
						upperNode = tempTree.get(mapString);
//						logger.info("Mapzzzzzz : {},{}", bb.get(key),node);
					}
					
				}
			}
		}	
		logger.info("Hierarchy Initialized {}, {}");
	}*/
	
	private void onGocMstBeanChange(@Observes GocMstBean bean) {
		genTree();
//		logger.info("Hierarchy baseDate : {},{}", bean.getEntryRstList().get(0).getBaseDate());
	}

	public void onNodeSelect(NodeSelectEvent event) {
		Map<String, String> hierMap = new HashMap<>();
		TreeNode tempNode = event.getTreeNode();
		
		while(tempNode.getParent()!=null){
			hierMap.putAll((Map)tempNode.getData());
			tempNode = tempNode.getParent();
		}
		logger.info("Goc Hierarchy Node String : {},{}", hierMap);
		hierarchyChangeEventMap.fire(hierMap);
	}
	
	
}
