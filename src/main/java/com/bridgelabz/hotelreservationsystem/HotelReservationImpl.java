package com.bridgelabz.hotelreservationsystem;

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
}