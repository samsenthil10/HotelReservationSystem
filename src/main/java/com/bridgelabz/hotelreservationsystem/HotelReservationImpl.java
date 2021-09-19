package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashSet;

import com.bridgelabz.hotelreservationsystem.HotelReservationExceptions.exceptionType;

public class HotelReservationImpl implements HotelReservationIF {

	@Override
	public Hotel addNewHotel(String name, Integer ratesForRegularCustomer) {

		Hotel hotel = new Hotel();
		try {

			if(name == null)
				throw new HotelReservationExceptions("Hotel name cannot be Null!", exceptionType.NAME_ENTERED_NULL);
			if(name.length()==0)
				throw new HotelReservationExceptions("Hotel name cannot be Empty!", exceptionType.NAME_ENTERED_EMPTY);
			if(ratesForRegularCustomer == null)
				throw new HotelReservationExceptions("Rates for regular customer cannot be Null!", exceptionType.RATE_FOR_REGULAR_CUSTOMER_ENTERED_NULL);
			if(ratesForRegularCustomer < 0)
				throw new HotelReservationExceptions("Rates for regular customer cannot be Negative!", exceptionType.RATE_FOR_REGULAR_CUSTOMER_ENTERED_NEGATIVE);
			else {
				hotel.setHotelName(name);
				hotel.setRatesForRegularCustomer(ratesForRegularCustomer);
			}
		}
		catch(RuntimeException e) {

		}
		return hotel;
	}


	@Override
	public String findCheapestHotel(LinkedHashSet<Hotel> listOfHotels, String date1, String date2) {

		if(date1==null || date2==null) {
			throw new HotelReservationExceptions("Date cannot be Null!",exceptionType.DATE_CANNOT_BE_NULL);
		}
		if(date1.length()==0 || date2.length()==0) {
			throw new HotelReservationExceptions("Date cannot be Empty!",exceptionType.DATE_CANNOT_BE_EMPTY);
		}
		else {
			Hotel cheapestHotel = null;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
			LocalDate startDate = LocalDate.parse(date1,formatter);
			LocalDate endDate = LocalDate.parse(date2,formatter);
			int totalDays =  (int) ChronoUnit.DAYS.between(startDate, endDate);
			cheapestHotel = listOfHotels.stream()
					.min((rate1,rate2) -> rate1.getRatesForRegularCustomer()*totalDays - rate2.getRatesForRegularCustomer()*totalDays)
					.get();

			if(cheapestHotel == null)
				return "No Hotels Found";
			return cheapestHotel.getHotelName();
		} 
	}
}