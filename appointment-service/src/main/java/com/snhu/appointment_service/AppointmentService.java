package com.snhu.appointment_service;

import java.util.Map;
import java.util.Collection;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppointmentService {

		// Initializes the map that will hold Appointment
		private Map<String, Appointment> mapOfAppointments;
		
		//Constructor that creates a hash map to store all key value pairs of each instance of Appointment
		public AppointmentService() {
		        this.mapOfAppointments = new HashMap<>();
		}
		
		public void addAppt(Appointment appt) {
			
			String apptID = appt.getApptID();
			Date apptDate = appt.getApptDate();
			Date todaysDate = new Date();
			
			// Checks if ID already exists and displays results in CONSOLE
			if(mapOfAppointments.containsKey(apptID)) {
				throw new IllegalArgumentException("Appointment ID already exists. Try again.");
			}
			
			// Checks if the date is in the past. If so, illegal argument will be thrown
			if (apptDate.before(todaysDate) ) {
				throw new IllegalArgumentException("Appointment date " + apptDate + " is in the past. Try again.");
			}
			
			// adds the new instance of appointment to the map if all aspects are valid
	        mapOfAppointments.put(apptID, appt);
		}

		// This method deletes the appointment that has an ID that matches the ID provided
		public void deleteAppt(String apptID) {
	        
			// If appointment doesn't exist, an illegal argument will be thrown
	        if (!mapOfAppointments.containsKey(apptID)) {
	            throw new IllegalArgumentException("Appt does not exist. Try again.");
	        }
	    
	        mapOfAppointments.remove(apptID);
	    }
	
		//Returns the appointment instance inside of the map that has an ID that matches the ID provided 
		 public Appointment getApptInstance(String apptID) {
	            return mapOfAppointments.get(apptID);
	        }
		
		/* Gets all appts in the map. Chose to use Collection to easily iterate through the map of appointments and return their values
		public Collection<Appointment> getAllAppts() {
			
	        return mapOfAppointments.values();
	    }
		*/
		
		 
		 /* Uncomment the following block of code to test in terminal console by adding appointments to the map and printing out all the values. 
	//	

	 public static void main(String[]args) throws ParseException {
	 
		AppointmentService apptService = new AppointmentService();
		
		//THIS BlOCK OF CODE: adds new appts to the map
		// Sets today's date
		Date todaysDate = new Date();
						
		// The string version of appointment date
		String apptDate1_string = "12-10-2024";
		String apptDate2_string = "12-10-2019";
								
		//Instantiating the SimpleDateFormat class
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
							       
		//Parsing the given String to Date object so can pass to Appointment object
		Date apptDate1 = formatter.parse(apptDate1_string); 
		Date apptDate2 = formatter.parse(apptDate2_string);
		
		// Adds first appt
		Appointment appt1 = new Appointment("1", apptDate1 , "Sample first appointment description");
		apptService.addAppt(appt1);
				
		//Adds a second appt
		Appointment appt2 = new Appointment("2", apptDate2, "Sample second appointment description");
		apptService.addAppt(appt2);
		
		// Get all appts from the AppointmentService
	    Collection<Appointment> apptsInMap = apptService.getAllAppts();

	    // Print the values for each instance of Appointments
	     
	    System.out.println("All Appointments in the Map:");
	    for (Appointment appt : apptsInMap) {
	        System.out.println("Appointment ID: " + appt.getApptID());
	        System.out.println("Appointment Date: " + appt.getApptDate() );
	        System.out.println("Appointment Description: " + appt.getApptDescription());
	        System.out.println("****************\n");
	    }
		
	   
		
	} */
	

}

