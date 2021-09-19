package com.bridgelabz.hotelreservationsystem;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public interface HotelReservationIF {
	
	public Hotel addNewHotel(String name, Integer weekdayRatesForRegularCustomer, Integer weekendRatesForRegularCustomer);
	public String findCheapestHotel(LinkedHashSet<Hotel> listOfHotels, String startDate, String endDate);
	public ArrayList<String> findCheapestHotelForBothWeekdayAndWeekend(LinkedHashSet<Hotel> listOfHotels, String date1, String date2);
}
