package com.eugene.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

@SessionScoped
//@ViewScoped
//@RequestScoped
//@Stateless
//@Stateful
public class DbService implements Serializable {
	@Inject 	private Logger logger;

	@Inject
//	@OraTakionEm
	private EntityManager entityManager;

	public DbService() {
		System.out.println("GocDbService Generated");
	}

	@PostConstruct
	public void init(){
		logger.info("DB Service Init : {}");
	}
	

	public <T> List<T> getList(T entity){
		String entityName = entity.getClass().getName();
		String query = "from "+ entityName;
		return entityManager.createQuery(query).getResultList();
	}
	
	public <T> List<T> getList(T entity, LocalDate baseDate ){
		String entityName = entity.getClass().getName();
		String query = "from "+ entityName + " a where a.baseDate = :baseDate";
		return entityManager.createQuery(query).setParameter("baseDate", baseDate).getResultList();
	}

	
	
}
