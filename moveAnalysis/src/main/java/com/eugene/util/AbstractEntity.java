package com.eugene.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractEntity {

	public String getPropertyValue(List<String> propList){
		String mName;
		String nodeString ="#";
		Class klass = this.getClass();
		
		for(String key : propList){
			mName = ENamingConvention.SNAKE_CASE.convertToCamelCase("get_" +key);
			try {
				nodeString = nodeString + klass.getDeclaredMethod(mName).invoke(this) +"#";
//				logger.info("invoke: {} ", klass.getDeclaredMethod(mName).invoke(zz));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return nodeString;
	}
	
	public List<String> getValueList(List<String> propList){
		List<String> rst  = new ArrayList<String>();
		
		String mName;
		Class klass = this.getClass();
		for (int i = 0; i < propList.size(); i++) {
			mName = ENamingConvention.SNAKE_CASE.convertToCamelCase("get_" +propList.get(i));
			try {
				rst.add(i, klass.getDeclaredMethod(mName).invoke(this).toString());
//				logger.info("invoke: {} ", klass.getDeclaredMethod(mName).invoke(zz));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		/*for(String key : propList){
			mName = ENamingConvention.SNAKE_CASE.convertToCamelCase("get_" +key);
			try {
				rst.add(klass.getDeclaredMethod(mName).invoke(this).toString());
//						logger.info("invoke: {} ", klass.getDeclaredMethod(mName).invoke(zz));
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}*/
		
		return rst;
	}
	
	public Map<String,String> getPropertyMap(List<String> propList){
		Map<String, String> rst = new LinkedHashMap<String, String>();
		Class klass = this.getClass();
		String mName;
//		System.out.println("KeyList order : "+ keyList);
		for(String key : propList){
			mName = ENamingConvention.SNAKE_CASE.convertToCamelCase("get_" +key);
			try {
				 rst.put(key, klass.getDeclaredMethod(mName).invoke(this).toString());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return rst;
	}
	
	public boolean filter(List<String> key, List<String> propValue){
		Class klass = this.getClass();
		String mName;
		boolean trueFalse=false;
//		System.out.println("KeyList order : "+ propMap);
			
		for(int i=0; i<key.size(); i++){
			mName = ENamingConvention.SNAKE_CASE.convertToCamelCase("get_" +key.get(i));
			try {
//				System.out.println(klass.getDeclaredMethod(mName).invoke(this).toString());
				trueFalse = propValue.get(i).equals(klass.getDeclaredMethod(mName).invoke(this).toString());
				if(!trueFalse){
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		return trueFalse;
	}
	public boolean filter(Map<String,String> propMap){
		Class klass = this.getClass();
		String mName;
		boolean trueFalse=false;
//		System.out.println("KeyList order : "+ propMap);
			
		for(Map.Entry<String, String> entry	 : propMap.entrySet()){
			mName = ENamingConvention.SNAKE_CASE.convertToCamelCase("get_" +entry.getKey());
//			System.out.println("aaa" + entry.getKey() +":"+ entry.getValue());
			try {
//				System.out.println(klass.getDeclaredMethod(mName).invoke(this).toString());
				trueFalse = entry.getValue().equals(klass.getDeclaredMethod(mName).invoke(this).toString());
				if(!trueFalse){
					break;
				}
//				System.out.println(entry.getKey() +"_" + entry.getValue()+"_"+ klass.getDeclaredMethod(mName).invoke(this).toString() + trueFalse);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return trueFalse;
	}
}
