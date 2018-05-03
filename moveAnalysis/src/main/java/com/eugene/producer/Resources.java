/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.eugene.producer;


import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eugene.qualifiers.MessageBundle;
import com.eugene.qualifiers.QueryResource;

/**
 * This class uses CDI to alias Java EE resources, such as the persistence context, to CDI beans
 * 
 * <p>
 * Example injection on a managed bean field:
 * </p>
 * 
 * <pre>
 * &#064;Inject
 * private EntityManager em;
 * </pre>
 */
//@ApplicationScoped
public class Resources {
//	@Inject
//	FacesContext facesContext;
	
//    @Produces
//    @PersistenceContext(unitName="primary")
//    @DefaultEm
//    private EntityManager em;
//
//    @Produces
//    @PersistenceContext(unitName="secondary")
//    @SecondEm
//    private EntityManager emRel;
//    
    @Produces 
    public Logger produceLog(InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

//    @Produces
//    @RequestScoped
//    public FacesContext produceFacesContext() {
//        return FacesContext.getCurrentInstance();
//    }
//    
    

//	@Produces
//	@MessageBundle
//	public ResourceBundle getBundle() {
//		FacesContext context = FacesContext.getCurrentInstance();
//		return context.getApplication().getResourceBundle(context, "msg");
//	}

	/*@Produces
	@ColumnHeaderBundle
	public ResourceBundle getHeaderBundle() {
		return facesContext.getApplication().getResourceBundle(facesContext, "column");
	}*/

//	@Produces
//	@QueryResource
//	public ResourceBundle getQueryBundle() {
//		/*
//		 * if (bundle == null) { FacesContext context =
//		 * FacesContext.getCurrentInstance(); bundle =
//		 * context.getApplication().getResourceBundle(context, "msgs"); }
//		 */
//		FacesContext context = FacesContext.getCurrentInstance();
//		// return context.getApplication().getResourceBundle(context, "msg");
//		return facesContext.getApplication().getResourceBundle(context, "query");
//	}

    
   

}
