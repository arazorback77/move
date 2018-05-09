package com.eugene.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ListIndexBase;
import org.primefaces.model.TreeNode;

import com.eugene.enums.EBoolean;
import com.eugene.util.Navigatable;


@Entity(name="HierarchyMst")
@Table(name = "IF7_HIERARCHY_MST")
public class HierarchyMst implements Serializable, Navigatable {

	private static final long serialVersionUID = 1L;

	private String hierarchyId;
	private String hierarchyName;
	private Long seq;
	private EBoolean useYn;
	
	private List<String> keyList = new ArrayList<String>();
	
	
	private Map<List<String>, TreeNode> treeMap = new HashMap<List<String>, TreeNode>();
	private TreeNode rootNode;
	private TreeNode selectedNode;
	
	private Set<Map<String, String>> nodeDefineSet = new HashSet<Map<String, String>>();   //All Node of the Hierarchy. Node is defined as Property and Value... 날짜별로 달라질수 있다..여기가 아닌것 같다...
	private Map<String, List<GocMst>> nodeMap = new HashMap<>();						   // GocMst of a given Node 여기가 아닌것 같다...	
	
	
	public HierarchyMst() {
	}
	
	@Id
	@Column(name="HIERARCHY_ID", nullable=false)
	public String getHierarchyId() {
		return hierarchyId;
	}

	public void setHierarchyId(String hierarchyId) {
		this.hierarchyId = hierarchyId;
	}

	@Column(name="HIERARCHY_NAME")
	public String getHierarchyName() {
		return hierarchyName;
	}

	public void setHierarchyName(String hierarchyName) {
		this.hierarchyName = hierarchyName;
	}

	@Column(name="SEQ")
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="USE_YN")
	public EBoolean getUseYn() {
		return useYn;
	}

	public void setUseYn(EBoolean useYn) {
		this.useYn = useYn;
	}
	

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "IF7_HIERARCHY_SETTING", joinColumns = @JoinColumn(name = "HIERARCHY_ID"))
	@OrderColumn(name="HIERARCHY_LEVEL")
	@ListIndexBase(value=1)
    @Column(name = "AGGRE_KEY")
	public List<String> getKeyList() {
		return keyList;
	}

	public void setKeyList(List<String> keyList) {
		this.keyList = keyList;
	}

	@Transient
	public Map<String, List<GocMst>> getNodeMap() {
		return nodeMap;
	}
	public void setNodeMap(Map<String, List<GocMst>> nodeMap) {
		this.nodeMap = nodeMap;
	}
	
	@Transient
	public Set<Map<String, String>> getNodeDefineSet() {
		return nodeDefineSet;
	}
	public void setNodeDefineSet(Set<Map<String, String>> nodeDefineSet) {
		this.nodeDefineSet = nodeDefineSet;
	}

	@Transient
	public TreeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}
	
	@Transient
	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}
	
	@Transient
	public Map<List<String>, TreeNode> getTreeMap() {
		return treeMap;
	}
	public void setTreeMap(Map<List<String>, TreeNode> treeMap) {
		this.treeMap = treeMap;
	}

	@Transient
	public String idString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("#").append(getHierarchyId());

		String rst = buffer.toString();

		return rst;
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getHierarchyId() == null) ? 0 : getHierarchyId().hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		HierarchyMst other = (HierarchyMst) obj;
		if (hierarchyId == null) {
			if (other.hierarchyId != null) {
				return false;
			}
		} else if (!hierarchyId.equals(other.hierarchyId)) {
			return false;
		}
		return true;
	}

}
