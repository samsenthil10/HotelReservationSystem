package com.bridgelabz.hotelreservationsystem;

@SuppressWarnings("serial")
public class HotelReservationExceptions extends RuntimeException {

	enum exceptionType{

		NAME_ENTERED_NULL,
		NAME_ENTERED_EMPTY,
		RATE_FOR_REGULAR_CUSTOMER_ENTERED_NULL,
		RATE_FOR_REGULAR_CUSTOMER_ENTERED_NEGATIVE,
		DATE_CANNOT_BE_NULL,
		DATE_CANNOT_BE_EMPTY,
		DATE_IN_INVALID_FORMAT
	}

	exceptionType type;

	public HotelReservationExceptions(exceptionType type, String message) {
		super(message);
		this.type = type;
		System.out.println(message);
	}
}