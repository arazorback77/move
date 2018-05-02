package com.eugene.service;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

//@SessionScoped
//@ViewScoped
//@RequestScoped
@Stateless
//@Stateful
public class GocDbService implements Serializable {
//	@Inject
//	private Logger logger;

	@Inject
//	@OraTakionEm
	private EntityManager entityManager;

	public GocDbService() {
		System.out.println("GocDbService Generated");
	}

	@PostConstruct
	public void init(){
	}
	


	
	
}
