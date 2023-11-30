package com.snhu.appointment_service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


class AppointmentServiceTest{

	@Test
	@DisplayName("New, valid appt is added to the map.")
	public void addValidApptTest() {

		Appointment appt = new Appointment("1", new Date(), "This is a sample text appointment description");
		AppointmentService mapOfAppointments = new AppointmentService();
		
		String apptID = appt.getApptID();
		
		// adds the new appt to the map
		mapOfAppointments.addAppt(appt);
		
		/* Calls getApptInstance and returns the Appointment instance that matches the provided appt ID. The 
		   instance is stored in a new variable, newAppt. 
		*/
		Appointment newAppt = mapOfAppointments.getApptInstance(apptID);
		
		/* Compares the original appt with the appt that was added to determine if all of the 
		   correct information was stored 
		*/
		Assertions.assertEquals(appt, newAppt);
	}
	
	@Test
	@DisplayName("Appt has been rejected for having invalid attributes.")
	public void addInvalidApptDateTest() throws ParseException {
		
		// Sets the date in the past and as a string
		String apptDateStr = "12-10-2019";
		
		// Calls the method that allows for the string to be turn
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		// Creates the date variable that will be added to Appointment instance
		Date apptDate = formatter.parse(apptDateStr);
		
		Appointment appt = new Appointment("1", apptDate, "Sample text for the appointment description");
		AppointmentService apptService = new AppointmentService();
		
		// Asserts that an illegal argument exception will be thrown when trying to add the new appointment
		// because the date is in the past
		Assertions.assertThrows(IllegalArgumentException.class, () -> apptService.addAppt(appt) );
	}
	
	@Test
	@DisplayName("Appointment has been sucessfully deleted from the map.")
	public void deleteApptTest() throws ParseException {
		
		// Sets the date in the past and as a string
		String apptDateStr = "12-10-2029";
				
		// Calls the method that allows for the string to be turn
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				
		// Creates the date variable that will be added to Appointment instance
		Date apptDate = formatter.parse(apptDateStr);
		
		Appointment appt = new Appointment("1", apptDate, "Sample text for the appointment description");
		AppointmentService apptService = new AppointmentService();
		
		String apptID = appt.getApptID();
		
		// Adds appt to the map so it's populated
		apptService.addAppt(appt);

		// Deletes the recently added appt
		apptService.deleteAppt(apptID);
		
		// Asserts that null is returned when searching for the ID of the recently deleted task
		Assertions.assertNull(apptService.getApptInstance(apptID));
	}
	


}
