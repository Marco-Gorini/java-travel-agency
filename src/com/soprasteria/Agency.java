package com.soprasteria;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Exceptions.IncorrectDateException;
import Exceptions.IncorrectDestinationException;

public class Agency {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Do you want to reserve a vacation? (yes/no): ");
		String confirmation = in.nextLine();
		if(confirmation.equalsIgnoreCase("yes")) {
			Vacation vacation;
			while(true) {
				try {
					System.out.print("Insert the destination: ");
					String destination = in.nextLine();
					vacation = new Vacation(destination);
					break;
				} catch (IncorrectDestinationException e) {
					System.out.println("The destination can't be null!");
				}
			}
			while(true) {
				try {
					System.out.println("INSERT THE STARTING DATE");
					System.out.print("Insert the day: ");
					int dayStart = in.nextInt();
					in.nextLine();
					System.out.print("Insert the month: ");
					int monthStart = in.nextInt();
					in.nextLine();
					System.out.print("Insert the year: ");
					int yearStart = in.nextInt();
					in.nextLine();
					vacation.setStartDate(LocalDate.of(yearStart, monthStart, dayStart));
					break;
				} catch (IncorrectDateException e) {
					System.out.println("The date is not valid because it is before of today!");
				} catch (InputMismatchException e) {
					System.out.println("You probably inserted a wrong input.");
				} catch (NoSuchElementException e) {
					System.out.println("There are some problems with the input.");
				} catch (DateTimeException e) {
					System.out.println("The date is not valid!");
				}
			}
			while(true) {
				try {
					System.out.println("INSERT THE ENDING DATE");
					System.out.print("Insert the day: ");
					int dayEnd = in.nextInt();
					in.nextLine();
					System.out.print("Insert the month: ");
					int monthEnd = in.nextInt();
					in.nextLine();
					System.out.print("Insert the year: ");
					int yearEnd = in.nextInt();
					in.nextLine();
					vacation.setEndDate(LocalDate.of(yearEnd, monthEnd, dayEnd));
					break;
				} catch (IncorrectDateException e) {
					System.out.println("The date is not valid because it is before of the starting date!");
				} catch (InputMismatchException e) {
					System.out.println("You probably inserted a wrong input.");
				} catch (NoSuchElementException e) {
					System.out.println("There are some problems with the input.");
				} catch (DateTimeException e) {
					System.out.println("The date is not valid!");
				}
			}
			
			System.out.println(vacation.toString());
			
		}
		in.close();
	}
}
