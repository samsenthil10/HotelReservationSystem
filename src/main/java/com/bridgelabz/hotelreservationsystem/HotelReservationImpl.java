package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.bridgelabz.hotelreservationsystem.HotelReservationExceptions.exceptionType;

public class HotelReservationImpl implements HotelReservationIF {

	public static int calculateTotalRate(Hotel hotel, int numberOfWeekdays, int numberOfWeekends) {

		int totalRate=0;
		totalRate = ((hotel.getWeekdayRatesForRegularCustomer()*numberOfWeekdays)+(hotel.getWeekendRatesForRegularCustomer()*numberOfWeekends));
		return totalRate;
	}

	public static int calculateTotalWeekDays(LocalDate start, LocalDate end) {

		int startDate = start.getDayOfWeek().getValue();
		int endDate = end.getDayOfWeek().getValue();

		int days = (int) ChronoUnit.DAYS.between(start, end);
		int result = days - 2*(days/7);

		if (days % 7 != 0) {
			if (startDate == 7) {
				result -= 1;
			} else if (endDate == 7) {  
				result -= 1;
			} else if (endDate < startDate) { 
				result -= 2;
			}
		}
		return result;
	}

	@Override
	public Hotel addNewHotel(String name,Integer weekdayRatesForRegularCustomer, Integer weekendRatesForRegularCustomer, Integer rating) {

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

			if(weekdayRatesForRegularCustomer < 0)
				throw new HotelReservationExceptions(exceptionType.WEEKDAY_RATE_FOR_REGULAR_CUSTOMER_ENTERED_NEGATIVE,"Weekday Rates for regular customer cannot be Negative!");
			hotel.setWeekdayRatesForRegularCustomer(weekdayRatesForRegularCustomer);
		}
		catch(NullPointerException e) {
			throw new HotelReservationExceptions(exceptionType.WEEKDAY_RATE_FOR_REGULAR_CUSTOMER_ENTERED_NULL,"Weekday Rates for regular customer cannot be Null!");
		}
		try {

			if(weekendRatesForRegularCustomer < 0)
				throw new HotelReservationExceptions(exceptionType.WEEKEND_RATE_FOR_REGULAR_CUSTOMER_ENTERED_NEGATIVE,"Weekend Rates for regular customer cannot be Negative!");
			hotel.setWeekendRatesForRegularCustomer(weekendRatesForRegularCustomer);
		}
		catch(NullPointerException e) {
			throw new HotelReservationExceptions(exceptionType.WEEKEND_RATE_FOR_REGULAR_CUSTOMER_ENTERED_NULL,"Weekend Rates for regular customer cannot be Null!");
		}
		try {

			if(rating < 0)
				throw new HotelReservationExceptions(exceptionType.RATING_NEGATIVE,"Hotel rating cannot be Negative!");
			hotel.setRating(rating);
		}
		catch(NullPointerException e) {
			throw new HotelReservationExceptions(exceptionType.RATING_NULL,"Hotel rating cannot be Null!");
		}	
		return hotel;
	}

	@Override
	public ArrayList<String> findBestRatedHotel(LinkedHashSet<Hotel> listOfHotels, String date1, String date2) {

		List<Hotel> ratedHotel = new ArrayList<Hotel>();
		List<Hotel> ratedHotels = new ArrayList<Hotel>();
		List<Hotel> ratedHotelsReversed = new ArrayList<Hotel>();
		ArrayList<String> bestRatedHotels = new ArrayList<String>();
		int numberOfWeekdays,numberOfWeekends;
		try {
			if(date1.length()==0 || date2.length()==0) {
				throw new HotelReservationExceptions(exceptionType.DATE_CANNOT_BE_EMPTY,"Date cannot be Empty!");
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
			try {
				LocalDate startDate = LocalDate.parse(date1,formatter);
				LocalDate endDate = LocalDate.parse(date2,formatter);
				endDate = endDate.plusDays(1);
				int totalDays =  (int) ChronoUnit.DAYS.between(startDate, endDate);
				numberOfWeekdays = calculateTotalWeekDays(startDate, endDate);
				numberOfWeekends = totalDays-calculateTotalWeekDays(startDate, endDate);
				ratedHotel = listOfHotels.stream()
						.sorted(Comparator.comparing(Hotel::getRating).reversed())
						.collect(Collectors.toList());
			}
			catch(DateTimeParseException e) {
				throw new HotelReservationExceptions(exceptionType.DATE_IN_INVALID_FORMAT,"Invalid Date format!");
			}

		}
		catch(NullPointerException e) {
			throw new HotelReservationExceptions(exceptionType.DATE_CANNOT_BE_NULL,"Date cannot be Null!");
		}
		
		ratedHotels.add(ratedHotel.get(0));
		for(int index =1; index<ratedHotel.size(); index++) {
			Hotel hotel = ratedHotel.get(index);
			if(ratedHotels.stream().findFirst().get().getRating()==hotel.getRating()) {
				ratedHotels.add(hotel);
			}
			else {
				break;
			}
		}
		ratedHotelsReversed = ratedHotels.stream()
								.sorted((rate1,rate2) -> ( calculateTotalRate(rate1, numberOfWeekdays, numberOfWeekends) - calculateTotalRate(rate2, numberOfWeekdays, numberOfWeekends)))
								.collect(Collectors.toList());
		bestRatedHotels.add(0, "Hotel Name: "+ratedHotelsReversed.stream().findFirst().get().getHotelName()+" Rating: "+ratedHotelsReversed.stream().findFirst().get().getRating()+" Total Price: "+calculateTotalRate(ratedHotelsReversed.stream().findFirst().get(), numberOfWeekdays, numberOfWeekends));
		int pointer=1;
		for(int index =1;index<ratedHotelsReversed.size();index++) {
			Hotel hotel = ratedHotelsReversed.get(index);
			if(ratedHotelsReversed.stream().findFirst().get().getRating()==hotel.getRating()) {
				bestRatedHotels.add(pointer, "Hotel Name: "+hotel.getHotelName()+" Rating: "+hotel.getRating()+" Total Price: "+calculateTotalRate(hotel, numberOfWeekdays, numberOfWeekends));
				pointer++;
			}
			else
				break;
		}
		return bestRatedHotels;
	}
	
	@Override
	public ArrayList<String> findCheapestHotel(LinkedHashSet<Hotel> listOfHotels, String date1, String date2) {
		
		List<Hotel> cheapestHotel = new ArrayList<Hotel>();
		ArrayList<Hotel> cheapestHotels = new ArrayList<Hotel>();
		ArrayList<Hotel> cheapestHotelsReversed = new ArrayList<Hotel>();
		ArrayList<String> cheapestBestRatedHotels = new ArrayList<String>();
		int numberOfWeekdays,numberOfWeekends;
		try {
			if(date1.length()==0 || date2.length()==0) {
				throw new HotelReservationExceptions(exceptionType.DATE_CANNOT_BE_EMPTY,"Date cannot be Empty!");
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
			try {
				LocalDate startDate = LocalDate.parse(date1,formatter);
				LocalDate endDate = LocalDate.parse(date2,formatter);
				endDate = endDate.plusDays(1);
				int totalDays =  (int) ChronoUnit.DAYS.between(startDate, endDate);
				numberOfWeekdays = calculateTotalWeekDays(startDate, endDate);
				numberOfWeekends = totalDays-calculateTotalWeekDays(startDate, endDate);
				cheapestHotel = listOfHotels.stream()
						.sorted((rate1,rate2) -> ( calculateTotalRate(rate1, numberOfWeekdays, numberOfWeekends) - calculateTotalRate(rate2, numberOfWeekdays, numberOfWeekends)))
						.collect(Collectors.toList());
			}
			catch(DateTimeParseException e) {
				throw new HotelReservationExceptions(exceptionType.DATE_IN_INVALID_FORMAT,"Invalid Date format!");
			}

		}
		catch(NullPointerException e) {
			throw new HotelReservationExceptions(exceptionType.DATE_CANNOT_BE_NULL,"Date cannot be Null!");
		}
		cheapestHotels.add(cheapestHotel.get(0));
		for(int index =1; index<cheapestHotel.size(); index++) {
			Hotel hotel = cheapestHotel.get(index);
			if(calculateTotalRate(cheapestHotels.stream().findFirst().get(), numberOfWeekdays, numberOfWeekends)==calculateTotalRate(hotel, numberOfWeekdays, numberOfWeekends)) {
				cheapestHotels.add(hotel);
			}
			else {
				break;
			}
		}
		cheapestHotelsReversed= (ArrayList<Hotel>) cheapestHotels.stream()
				.sorted(Comparator.comparing(Hotel::getRating).reversed())
				.collect(Collectors.toList());
		cheapestBestRatedHotels.add(0, "Hotel Name: "+cheapestHotelsReversed.stream().findFirst().get().getHotelName()+" Rating: "+cheapestHotelsReversed.stream().findFirst().get().getRating()+" Total Price: "+calculateTotalRate(cheapestHotelsReversed.stream().findFirst().get(), numberOfWeekdays, numberOfWeekends));
		int pointer=1;
		for(int index =1;index<cheapestHotelsReversed.size();index++) {
			Hotel hotel = cheapestHotelsReversed.get(index);
			if(cheapestHotelsReversed.stream().findFirst().get().getRating()==hotel.getRating()) {
				cheapestBestRatedHotels.add(pointer, "Hotel Name: "+hotel.getHotelName()+" Rating: "+hotel.getRating()+" Total Price: "+calculateTotalRate(hotel, numberOfWeekdays, numberOfWeekends));
				pointer++;
			}
			else
				break;
		}
		return cheapestBestRatedHotels;
		
	}
}