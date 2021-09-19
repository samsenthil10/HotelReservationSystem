package com.bridgelabz.hotelreservationsystem;

@SuppressWarnings("serial")
public class HotelReservationExceptions extends RuntimeException {

	enum exceptionType{

		NAME_ENTERED_NULL,
		NAME_ENTERED_EMPTY,
		WEEKDAY_RATE_FOR_CUSTOMER_ENTERED_NULL,
		WEEKDAY_RATE_FOR_CUSTOMER_ENTERED_NEGATIVE,
		WEEKEND_RATE_FOR_CUSTOMER_ENTERED_NULL,
		WEEKEND_RATE_FOR_CUSTOMER_ENTERED_NEGATIVE,
		DATE_CANNOT_BE_NULL,
		DATE_CANNOT_BE_EMPTY,
		DATE_IN_INVALID_FORMAT_BY_REGEX,
		DATE_IN_INVALID_FORMAT,
		RATING_NULL,
		RATING_NEGATIVE
	}

	exceptionType type;

	public HotelReservationExceptions(exceptionType type, String message) {
		super(message);
		this.type = type;
		System.out.println(message);
	}
}