package com.eugene.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
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
import com.eugene.service.DbService;
import com.eugene.util.HierarchyKey;

@Named
@SessionScoped
//@ViewScoped
public class GocMstTreeBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject 	private Logger logger;
//	@Inject		private EntityManager entityManager;
	@Inject		private DbService dbService;
	@Inject		private GocMstBean gocMstBean;  
	
	@Inject @SelectedTreeNode
	private Event<HierarchyKey> nodeChangeEvent;
	
//	private String query ;
	
	private List<HierarchyMst> hierList;  
	private List<HierarchyMst> allHierList;  
	private HierarchyMst selected;
	
	private int k;
	
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
//		query = "select a from HierarchyMst a where a.hierarchyId =:param";
//		hierList = entityManager.createQuery(query).setParameter("param", "HH1").getResultList();
		allHierList = dbService.getList(new HierarchyMst());
		hierList = allHierList.stream().filter(s ->s.getHierarchyId().equals("HH1")).collect(Collectors.toList());
		hierList.stream().map(s->s.getKeyList()).forEach(s -> logger.info("Post :{}", s));
		genTree();
//		genTree2();
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
	
	private void genTree2() {
		Map<String, TreeNode> tempTree = new HashMap<>();
		String mapString="";
		Set<Map<String, String>> tempSet = new HashSet<Map<String,String>>();
		for(HierarchyMst aa : hierList){
			tempTree = new HashMap<>();
			
			rootNode = new DefaultTreeNode(new HashMap<String,String>(){{ put("ROOT", aa.getHierarchyName()); }}, null);
			aa.setRootNode(rootNode);
			
			tempSet = gocMstBean.getGocMstList().stream().map(s ->s.getPropertyMap(aa.getKeyList())).collect(Collectors.toSet());
			
			for(Map<String, String> bb : tempSet){
				upperNode = rootNode;
				mapString="";
				
				for(String key : aa.getKeyList()){
					mapString=key+"#"+bb.get(key);
					if(!tempTree.containsKey(mapString)){
						node = new DefaultTreeNode(new HashMap<String,String>(){{ put(key, bb.get(key)); }}, upperNode);
						logger.info("Map11111111 : {},{}", bb.get(key),node);
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
	
	
	/*private void genTreezz() {
		Map<List<String>, TreeNode> treeMap = new HashMap<List<String>, TreeNode>();
		Set<List<String>> propValueList = new HashSet<List<String>>();
		
		for(HierarchyMst aa : hierList){
			rootNode = new DefaultTreeNode("ROOT", null);
			
			for(int i=0; i< aa.getKeyList().size(); i++){
				k=i+1;
				propValueList.addAll(gocMstBean.getGocMstList().stream().map(s -> s.getValueList(aa.getKeyList().subList(0, k))).collect(Collectors.toSet()));
			}
			
			for (List<String> list	: propValueList) {
				treeMap.put(list, new DefaultTreeNode(list.get(list.size()-1)));
			}
			
			for (List<String> list	: propValueList) {
				
				treeMap.get(list).setType(aa.getHierarchyName());
				treeMap.get(list).setParent(treeMap.getOrDefault(list.subList(0, list.size()-1), rootNode));
				treeMap.getOrDefault(list.subList(0, list.size()-1), rootNode).getChildren().add(treeMap.get(list));
			}
			
			aa.setTreeMap(treeMap);
			aa.setRootNode(rootNode);
		}	
		logger.info("Hierarchy Initialized1 {}, {}", treeMap);
	}*/
	
	private void genTree() {
		
		for(HierarchyMst aa : hierList){
			Map<List<String>, TreeNode> treeMap = new HashMap<List<String>, TreeNode>();
			Set<List<String>> propValueList = new HashSet<List<String>>();

			rootNode = new DefaultTreeNode("ROOT", null);
			
			for(int i=0; i< aa.getKeyList().size(); i++){
				k=i+1;
				propValueList.addAll(gocMstBean.getGocMstList().stream().map(s -> s.getValueList(aa.getKeyList().subList(0, k))).collect(Collectors.toSet()));
			}
			
			for (List<String> list	: propValueList) {
				treeMap.put(list, new DefaultTreeNode( new HierarchyKey(list.get(list.size()-1), aa.getKeyList(), list)));
			}
			
			for (List<String> list	: propValueList) {
				
//				treeMap.get(list).setType(aa.getHierarchyName());
				treeMap.get(list).setParent(treeMap.getOrDefault(list.subList(0, list.size()-1), rootNode));
				treeMap.getOrDefault(list.subList(0, list.size()-1), rootNode).getChildren().add(treeMap.get(list));
			}
			
			aa.setTreeMap(treeMap);
			aa.setRootNode(rootNode);
		}	
		logger.info("Hierarchy Initialized1 {}, {}");
	}
	


	
/*	private void onGocMstBeanChange(@Observes GocMstBean bean) {
		genTree();
//		logger.info("Hierarchy baseDate : {},{}", bean.getEntryRstList().get(0).getBaseDate());
	}*/

	
	
	public void onNodeSelect(NodeSelectEvent event) {
		TreeNode tempNode = event.getTreeNode();
		HierarchyKey nodeData = (HierarchyKey)tempNode.getData();
		logger.info("Goc Hierarchy Node Type : {},{}", nodeData.getName(), nodeData.getPropValueList());
		nodeChangeEvent.fire(nodeData);
	}
	
	
}
