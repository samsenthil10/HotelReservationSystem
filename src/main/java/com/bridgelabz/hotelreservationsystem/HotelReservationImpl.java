package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashSet;

import com.bridgelabz.hotelreservationsystem.HotelReservationExceptions.exceptionType;

public class HotelReservationImpl implements HotelReservationIF {

	@Override
	public Hotel addNewHotel(String name, Integer ratesForRegularCustomer) {

		Hotel hotel = new Hotel();
		try {

			if(name.length()==0)
				throw new HotelReservationExceptions(exceptionType.NAME_ENTERED_EMPTY, "Hotel name cannot be Empty!");
			hotel.setHotelName(name);

		}
		catch(NullPointerException e) {
			throw new HotelReservationExceptions(exceptionType.NAME_ENTERED_NULL,"Hotel name cannot be Null!");
		}
		try {

			if(ratesForRegularCustomer < 0)
				throw new HotelReservationExceptions(exceptionType.RATE_FOR_REGULAR_CUSTOMER_ENTERED_NEGATIVE,"Rates for regular customer cannot be Negative!");
			hotel.setRatesForRegularCustomer(ratesForRegularCustomer);
		}
		catch(NullPointerException e) {
			throw new HotelReservationExceptions(exceptionType.RATE_FOR_REGULAR_CUSTOMER_ENTERED_NULL,"Rates for regular customer cannot be Null!");
		}
		return hotel;
	}


	@Override
	public String findCheapestHotel(LinkedHashSet<Hotel> listOfHotels, String date1, String date2) {

		Hotel cheapestHotel = null;
		try {
			if(date1.length()==0 || date2.length()==0) {
				throw new HotelReservationExceptions(exceptionType.DATE_CANNOT_BE_EMPTY,"Date cannot be Empty!");
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
			try {
				LocalDate startDate = LocalDate.parse(date1,formatter);
				LocalDate endDate = LocalDate.parse(date2,formatter);
				int totalDays =  (int) ChronoUnit.DAYS.between(startDate, endDate);
				cheapestHotel = listOfHotels.stream()
						.min((rate1,rate2) -> rate1.getRatesForRegularCustomer()*totalDays - rate2.getRatesForRegularCustomer()*totalDays)
						.get();

			}
			catch(DateTimeParseException e) {
				throw new HotelReservationExceptions(exceptionType.DATE_IN_INVALID_FORMAT,"Invalid Date format!");
			}

		}
		catch(NullPointerException e) {
			throw new HotelReservationExceptions(exceptionType.DATE_CANNOT_BE_NULL,"Date cannot be NULL!");
		}
		if(cheapestHotel == null)
			return "No Hotels Found";
		return cheapestHotel.getHotelName();
	} 
}