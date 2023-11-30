package com.snhu.appointment_service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {
	
	// Following block of code initializes the attributes
	private String apptID;
	private Date apptDate;
	private String apptDescription;
	
	// Sets the rules that the variable must have a length of 1-10
	private static final String APPT_ID_REGEX = "^.{1,10}$";
	private static final String APPT_DESCRIPTION_REGEX = "^.{1,50}$";
	
	public Appointment (String apptID, Date apptDate, String apptDescription) {
		this.apptID = apptID;
		this.apptDate = apptDate;
		this.apptDescription = apptDescription;
	}
	
	// Following method returns the value for the appt's ID
	public String getApptID () {
		
		// Uses regex to check if the string is not null and 10 chars or less
		if (!apptID.matches(APPT_ID_REGEX)) {
            throw new IllegalArgumentException("Appt ID must be a non-null string of up to 10 characters.");
        }
		else {
			return apptID;	
		}
	}
	
	// Following method sets the apptDate attribute
	public void setApptDate(Date apptDate) {
		
		// Sets the appointment date
		 this.apptDate = apptDate;

	}
	
	// Following method returns the value for the appt's date
	public Date getApptDate() {
		
		// Returns the appt date stored
			return apptDate;	
	}
	
	// Following method sets the appt description attribute
	public void setApptDescription(String apptDescription) {
		
		// Uses regex to check if the string is not null and 50 chars or less
		if (!apptDescription.matches(APPT_DESCRIPTION_REGEX)) {
			throw new IllegalArgumentException("Appt description must be a non-null string of up to 50 characters.");
		}
		else {
			this.apptDescription = apptDescription;
		}
	}
		
	// Following method returns the value for the appt's description
	public String getApptDescription() {
		
		// Uses regex to check if the string is not null and 50 chars or less
		if (!apptDescription.matches(APPT_DESCRIPTION_REGEX)) {
			throw new IllegalArgumentException("Appt description must be a non-null string of up to 50 characters.");
		}
		else {
			return apptDescription;	
		}
	}
	

	/* Uncomment the following block if want to test in console
//
    public static void main( String[] args )throws ParseException
    {
    	// Sets today's date
    	Date todaysDate = new Date();
		
    	// The string version of appointment date
		String apptDate_string = "12-09-2023";
		
	    //Instantiating the SimpleDateFormat class
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
	       
	    //Parsing the given String to Date object so can pass to Appointment object
	    Date apptDate = formatter.parse(apptDate_string);  
    	
    	// Initializes new instance of appt class
    	Appointment appt = new Appointment("1", apptDate, "This is a sample text appointment description");
    	
    	// Prints out the appt's attribute values in the terminal console 
    	System.out.println( "Hello World! The appointment id is " + appt.getApptID() + " and the appt date is \n --" + appt.getApptDate() + "-- \n and todays date is \n--" 
    	+ todaysDate +"-- \n the description is \n\n" + appt.getApptDescription());
    	
    	System.out.println("This is should print true if today's date is before the appointment: " + todaysDate.before(apptDate) );
    }
    */
    
}
