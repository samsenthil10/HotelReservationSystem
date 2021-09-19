package com.bridgelabz.hotelreservationsystem;

public class Hotel {
	
	private String hotelName;
	private Integer weekdayRatesForRegularCustomer;
	private Integer weekendRatesForRegularCustomer;
	private Integer rating;
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Integer getWeekdayRatesForRegularCustomer() {
		return weekdayRatesForRegularCustomer;
	}
	public void setWeekdayRatesForRegularCustomer(Integer weekdayRatesForRegularCustomer) {
		this.weekdayRatesForRegularCustomer = weekdayRatesForRegularCustomer;
	}
	public Integer getWeekendRatesForRegularCustomer() {
		return weekendRatesForRegularCustomer;
	}
	public void setWeekendRatesForRegularCustomer(Integer weekendRatesForRegularCustomer) {
		this.weekendRatesForRegularCustomer = weekendRatesForRegularCustomer;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
}
