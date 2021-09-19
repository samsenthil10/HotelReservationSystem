package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public interface HotelReservationIF {
	
	public LinkedHashSet<Hotel> hotelListForRegularCustomer();
	public LinkedHashSet<Hotel> hotelListForRewardCustomer();
	public int calculateTotalRate(Hotel hotel, int numberOfWeekdays, int numberOfWeekends);
	public int calculateTotalWeekDays(LocalDate start, LocalDate end);
	public Hotel addNewHotel(String name, Integer weekdayRatesForCustomer, Integer weekendRatesForCustomer, Integer rating);
	public ArrayList<String> findCheapestHotel(LinkedHashSet<Hotel> listOfHotels, String date1, String date2);
	public ArrayList<String> findBestRatedHotel(LinkedHashSet<Hotel> listOfHotels, String date1, String date2);
}