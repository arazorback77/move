package com.eugene.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;

@Named
@SessionScoped
public class BaseDateBean implements Serializable {
	@Inject	private Logger logger;
	@Inject	private EntityManager entityManager;
	

	
	private LocalDate baseDate;
	private LocalDate prevDate;
	private Date pCalendar;

	@Inject private Event<LocalDate> baseDateChangeEvent;
	
	public BaseDateBean() {
	}

	@PostConstruct
	public void initNew() {
		pCalendar = new Date();
		
		prevDate = pCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().minusMonths(1);
		baseDate =prevDate.withDayOfMonth(prevDate.lengthOfMonth());
		
		logger.info("Gen baseDate {} for CurrentDate {}", baseDate, pCalendar);
	}


	
	public LocalDate getBaseDate() {
		return baseDate;
	}

	public void setBaseDate(LocalDate baseDate) {
		this.baseDate = baseDate;
	}
	
	public Date getpCalendar() {
		return pCalendar;
	}

	public void setpCalendar(Date pCalendar) {
		this.pCalendar = pCalendar;
	}

	public void handleDateSelect(SelectEvent  event) {

		pCalendar = (Date)event.getObject();
		prevDate = pCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().minusMonths(1);
		baseDate =prevDate.withDayOfMonth(prevDate.lengthOfMonth());
		
		logger.info("baseDate({}) for CurrentDate {}", baseDate, pCalendar);
		
//	
		baseDateChangeEvent.fire(baseDate);
	}
	


//	 ****************************************************



	



}
