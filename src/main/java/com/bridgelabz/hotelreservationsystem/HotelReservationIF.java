package com.bridgelabz.hotelreservationsystem;

import java.util.LinkedHashSet;

public interface HotelReservationIF {
	
	public Hotel addNewHotel(String name, Integer ratesForRegularCustomer);
	public String findCheapestHotel(LinkedHashSet<Hotel> listOfHotels, String startDate, String endDate);

}
