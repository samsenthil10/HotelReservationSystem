package com.bridgelabz.hotelreservationsystem;

import java.util.LinkedHashSet;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.hotelreservationsystem.HotelReservationExceptions.exceptionType;

public class HotelReservationTest {

	public  LinkedHashSet<Hotel> hotelList() {
		LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
		Hotel hotel = new Hotel();
		HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
		hotel = hotelReservationOperations.addNewHotel("LakeWood", 3110);
		listOfHotels.add(hotel);
		hotel = hotelReservationOperations.addNewHotel("BridgeWood", 150);
		listOfHotels.add(hotel);
		hotel = hotelReservationOperations.addNewHotel("RidgeWood", 220);
		listOfHotels.add(hotel);
		return listOfHotels;
	}
	@Test
	public void givenName_WhenAddingHotel_ShouldIncreaseSize() {

		LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
		Hotel hotel = new Hotel();
		HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
		hotel = hotelReservationOperations.addNewHotel("Lakewood", 110);
		int size = (int) listOfHotels.stream().count();
		listOfHotels.add(hotel);
		Assert.assertEquals(listOfHotels.size(), size+1);
	}

	@Test
	public void givenNameNull_WhenAddingHotel_ShouldThrowNameNull() {

		try {

			LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
			Hotel hotel = new Hotel();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			hotel = hotelReservationOperations.addNewHotel(null, 110);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals("Name cannot be Null!",exceptionType.NAME_ENTERED_NULL);			
		}
	}

	@Test
	public void givenNameEmpty_WhenAddingHotel_ShouldThrowNameEmpty() {

		try {

			LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
			Hotel hotel = new Hotel();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			hotel = hotelReservationOperations.addNewHotel("", 110);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals("Name cannot be Empty!",exceptionType.NAME_ENTERED_EMPTY);			
		}
	}

	@Test
	public void givenRateForRegularCustomer_WhenAddingHotel_ShouldIncreaseSize() {

		LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
		Hotel hotel = new Hotel();
		HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
		hotel = hotelReservationOperations.addNewHotel("Lakewood", 110);
		int size = (int) listOfHotels.stream().count();
		listOfHotels.add(hotel);
		Assert.assertEquals(listOfHotels.size(), size+1);
	}

	@Test
	public void givenRateForRegularCustomerNull_WhenAddingHotel_ShouldThrowRateForRegularCustomerNull() {

		try {

			LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
			Hotel hotel = new Hotel();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			hotel = hotelReservationOperations.addNewHotel("LakeWood", null);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals("Rate for regular customer cannot be Null!",exceptionType.RATE_FOR_REGULAR_CUSTOMER_ENTERED_NULL);			
		}
	}

	@Test
	public void givenRateForRegularCustomerNegative_WhenAddingHotel_ShouldThrowRateForRegularCustomerEmpty() {

		try {

			LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
			Hotel hotel = new Hotel();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			hotel = hotelReservationOperations.addNewHotel("Lakewood", -100);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals("Rate for regular customer cannot be negative!",exceptionType.RATE_FOR_REGULAR_CUSTOMER_ENTERED_NEGATIVE);			
		}
	}


	@Test
	public void givenProperDates_WhenFindingCheapestHotel_ShouldReturnNameOfCheapestHotel() {
		
		LinkedHashSet<Hotel> listOfHotels = hotelList();
		HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
		String hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,"10Sep2020","11Sep2020");
		Assert.assertTrue(hotelName.equalsIgnoreCase("Bridgewood"));
	}
	
	@Test
	public void givenDate1Null_WhenAddingHotel_ShouldThrowDateNull() {

		try {
			LinkedHashSet<Hotel> listOfHotels = hotelList();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			try {
				String hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,"10Sep2020",null);
			}
			catch (Exception e) {
				
			}
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals("Date cannot be Null!",exceptionType.DATE_CANNOT_BE_NULL);			
		}
	}

	@Test
	public void givenDate2Null_WhenAddingHotel_ShouldThrowDateNull() {

		try {
			LinkedHashSet<Hotel> listOfHotels = hotelList();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			try {
				String hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,null,"10Sep2020");
			}
			catch (Exception e) {
				
			}
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals("Date cannot be Null!",exceptionType.DATE_CANNOT_BE_NULL);			
		}
	}
}