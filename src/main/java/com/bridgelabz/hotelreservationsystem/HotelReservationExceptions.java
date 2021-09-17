package com.bridgelabz.hotelreservationsystem;

@SuppressWarnings("serial")
public class HotelReservationExceptions extends RuntimeException {

	enum exceptionType{

		NAME_ENTERED_NULL,
		NAME_ENTERED_EMPTY,
		RATE_FOR_REGULAR_CUSTOMER_ENTERED_NULL,
		RATE_FOR_REGULAR_CUSTOMER_ENTERED_EMPTY
	}

	exceptionType type;

	public HotelReservationExceptions(String message, exceptionType type) {
		super(message);
		this.type = type;
	}
}