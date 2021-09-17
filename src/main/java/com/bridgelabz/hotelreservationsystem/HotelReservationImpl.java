package com.bridgelabz.hotelreservationsystem;

public class HotelReservationImpl implements HotelReservationIF {

	@Override
	public Hotel addNewHotel(String name, int ratesForRegularCustomer) {
		
		Hotel hotel = new Hotel();
		hotel.setHotelName(name);
		hotel.setRatesForRegularCustomer(ratesForRegularCustomer);
		return hotel;
	}
}