package com.snhu.appointment_service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class AppointmentTest {
	
	@Test
	@DisplayName("Appt ID has 10 chars or less and is valid.")
	public void validID (){
		
		Appointment appt = new Appointment("1", new Date(), "Sample text for the appointment description");
		String apptID= appt.getApptID();
		
		int apptIDLength = apptID.length();
		
		Assertions.assertTrue( apptIDLength <= 10, "The appt ID has 10 chars or less and is valid and not null.");
	}
	
	@Test
	@DisplayName("Appt ID has 10 chars or more or is null and is invalid.")
	public void invalidID () {
		Appointment appt = new Appointment("123456789034", new Date(), "Sample text for the appointment description");

		Assertions.assertThrows(IllegalArgumentException.class, () -> appt.getApptID());
	}
	
	@Test
	@DisplayName("Appt date is in the present or future and is valid.")
	public void validApptDate () throws ParseException{
		
		// Sets today's date
		Date todaysDate = new Date();
				
		// The string version of appointment date
		String apptDate_string = "12-09-2023";
				
		//Instantiating the SimpleDateFormat class
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
			       
		//Parsing the given String to Date object so can pass to Appointment object
		Date apptDate = formatter.parse(apptDate_string);  
				
		Appointment appt = new Appointment("1", apptDate, "Sample text for the appointment description");
		
		Date retrivedDate = appt.getApptDate();
		
		Assertions.assertTrue(todaysDate.before(retrivedDate));
	}
	
	@Test
	@DisplayName("Description happens in the past or is null and is invalid.")
	public void invalidApptDate () throws ParseException{
		// Sets today's date
		Date todaysDate = new Date();
				
		// The string version of appointment date
		String apptDate_string = "12-09-2012";
				
		//Instantiating the SimpleDateFormat class
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
			       
		//Parsing the given String to Date object so can pass to Appointment object
		Date apptDate = formatter.parse(apptDate_string);  
				
		Appointment appt = new Appointment("1", apptDate, "Sample text for the appointment description");
		
		Date retrivedDate = appt.getApptDate();
		
		// Asserts that today's date is not before the retrieved date meaning the appointment date stored is in the past
		Assertions.assertTrue(!todaysDate.before(retrivedDate));
	}
	
	@Test
	@DisplayName("Appt description has 50 chars or less and is valid.")
	public void validApptDescription () {
		
		Appointment appt = new Appointment("1", new Date(), "Sample text for the appointment description");
		String apptDescription= appt.getApptDescription();
		
		int apptDescriptionLength = apptDescription.length();
		
		Assertions.assertTrue( apptDescriptionLength <= 50, "The appt description has 10 chars or less and is valid and not null.");
	}
	
	@Test
	@DisplayName("Appt description has 50 chars or more or is null and is invalid.")
	public void invalidApptDescription () {
		Appointment appt = new Appointment("1", new Date(), "Sample text for the appointmentdescription.  THis is illegal and more than 50 characters. Should be rejected and not accepted. Adding a little more for length");

		Assertions.assertThrows(IllegalArgumentException.class, () -> appt.getApptDescription() );
	} 
	
}



