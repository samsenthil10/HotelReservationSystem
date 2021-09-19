package com.bridgelabz.hotelreservationsystem;

public class Hotel {
	
	private String hotelName;
	private Integer weekdayRatesForCustomer;
	private Integer weekendRatesForCustomer;
	private Integer rating;
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Integer getWeekdayRatesForCustomer() {
		return weekdayRatesForCustomer;
	}
	public void setWeekdayRatesForCustomer(Integer weekdayRatesForCustomer) {
		this.weekdayRatesForCustomer = weekdayRatesForCustomer;
	}
	public Integer getWeekendRatesForCustomer() {
		return weekendRatesForCustomer;
	}
	public void setWeekendRatesForCustomer(Integer weekendRatesForCustomer) {
		this.weekendRatesForCustomer = weekendRatesForCustomer;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
}