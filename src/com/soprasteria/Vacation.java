package com.soprasteria;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import Exceptions.*;

public class Vacation {
	private final String destination;
	private LocalDate startDate = LocalDate.of(2022, 10, 11);
	private LocalDate endDate;
	
	//Constructor
	
	public Vacation(String destination) throws IncorrectDestinationException {
		if (isDestinationValid(destination)) {
			this.destination = destination;
		}
		else {
			throw new IncorrectDestinationException();
		}
	}
	
	//Getters and Setters
	
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) throws IncorrectDateException {
		if(isStartingDateValid(startDate)) {
			this.startDate = startDate;
		}
		else {
			throw new IncorrectDateException();
		}
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) throws IncorrectDateException {
		if(isEndDateValid(endDate)) {
			this.endDate = endDate;
		}
		else {
			throw new IncorrectDateException();
		}
	}

	public String getDestination() {
		return destination;
	}
	
	//Methods to Check the attributes;
	
	public boolean isStartingDateValid(LocalDate insertedDate) {
		if(insertedDate == null) {
			return false;
		}
		if(ChronoUnit.DAYS.between(LocalDate.now(), insertedDate) < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean isDestinationValid(String destination) {
		if(destination.equals("") || destination == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean isEndDateValid(LocalDate insertedDate) {
		if(insertedDate == null) {
			return false;
		}
		if(ChronoUnit.DAYS.between(startDate, insertedDate) < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//Other Methods
	
	private long calculateDaysOfVacation() {
		return ChronoUnit.DAYS.between(startDate, endDate);
	}
	
	@Override
	public String toString() {
		return ("Ok, you have reserved a vacation of " + calculateDaysOfVacation() + " in " + destination + " from " + startDate + " to " + endDate);
	}
	
}
