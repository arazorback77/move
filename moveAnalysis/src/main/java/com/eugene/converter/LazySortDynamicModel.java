package com.eugene.converter;

import java.util.Comparator;
import java.util.Map;

import org.primefaces.model.SortOrder;

public class LazySortDynamicModel implements Comparator<Map<String,String>> {

    private String sortField;
    private SortOrder sortOrder;
    
    
    public LazySortDynamicModel(String sortField, SortOrder sortOrder) {
    	this.sortField =sortField;
    	this.sortOrder = sortOrder;
//        sortFieldList.add(sortField);
//        sortOrderList.add(sortOrder);
    }
    
//    private List<String> sortFieldList = new ArrayList<String>();
//    private List<SortOrder> sortOrderList = new ArrayList<SortOrder>();
//    public LazySorterVolatilityHis(List<String>  sortFieldList, List<SortOrder> sortOrderList) {
//        this.sortFieldList = sortFieldList;
//        this.sortOrderList = sortOrderList;
//    }
    
    public int compare(Map<String,String> map1, Map<String,String> map2) {
    	System.out.println("In the LazySortDynamicModel");
    	int value = map1.get(sortField).compareTo(map2.get(sortField));
		return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
     }
}
