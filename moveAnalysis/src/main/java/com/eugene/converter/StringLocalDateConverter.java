package com.eugene.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.inject.Inject;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.slf4j.Logger;

@Converter(autoApply=true)
public class StringLocalDateConverter  implements AttributeConverter<LocalDate, String> {
	
	@Inject	private Logger logger;
	@Override
    public String convertToDatabaseColumn(LocalDate	date) {

		return date.format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString();
    }


    @Override
    public LocalDate convertToEntityAttribute(String dateString) {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    	try {
    		LocalDate localDate = LocalDate.parse(dateString, formatter);
    		return localDate;
			
		} catch (Exception e) {
			logger.error("Input Text {}  could not be parsed", dateString);
			return LocalDate.now();
		}
        
//    	if(dateString.length()==8){
//    		int year = Integer.valueOf(dateString.substring(0, 4));
//    		int month = Integer.valueOf(dateString.substring(4, 6));
//    		int dayOfMonth = Integer.valueOf(dateString.substring(6, 8));
////    		System.out.println(year + "_" + month +"_"+ dayOfMonth);
//    		return LocalDate.of(year, month, dayOfMonth);
//    	}
//    	else {
//    		return LocalDate.now();
//    	}
    }

}
