package com.bridgelabz.hotelreservationsystem;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.hotelreservationsystem.HotelReservationExceptions.exceptionType;

public class HotelReservationTest {

	public  LinkedHashSet<Hotel> hotelList() {
		LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
		Hotel hotel = new Hotel();
		HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
		hotel = hotelReservationOperations.addNewHotel("LakeWood", 110, 90);
		listOfHotels.add(hotel);
		hotel = hotelReservationOperations.addNewHotel("BridgeWood", 150, 50);
		listOfHotels.add(hotel);
		hotel = hotelReservationOperations.addNewHotel("RidgeWood", 220, 150);
		listOfHotels.add(hotel);
		return listOfHotels;
	}
	@Test
	public void givenName_WhenAddingHotel_ShouldIncreaseSize() {

		LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
		Hotel hotel = new Hotel();
		HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
		hotel = hotelReservationOperations.addNewHotel("Lakewood", 110, 90);
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
			hotel = hotelReservationOperations.addNewHotel(null, 110, 90);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.NAME_ENTERED_NULL);			
		}
	}

	@Test
	public void givenNameEmpty_WhenAddingHotel_ShouldThrowNameEmpty() {

		try {

			LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
			Hotel hotel = new Hotel();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			hotel = hotelReservationOperations.addNewHotel("", 110, 90);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.NAME_ENTERED_EMPTY);			
		}
	}

	@Test
	public void givenProperRatesForRegularCustomer_WhenAddingHotel_ShouldIncreaseSize() {

		LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
		Hotel hotel = new Hotel();
		HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
		hotel = hotelReservationOperations.addNewHotel("Lakewood", 110, 90);
		int size = (int) listOfHotels.stream().count();
		listOfHotels.add(hotel);
		Assert.assertEquals(listOfHotels.size(), size+1);
	}

	@Test
	public void givenWeekdayRateForRegularCustomerNull_WhenAddingHotel_ShouldThrowRateForRegularCustomerNull() {

		try {

			LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
			Hotel hotel = new Hotel();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			hotel = hotelReservationOperations.addNewHotel("LakeWood", null, 90);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.WEEKDAY_RATE_FOR_REGULAR_CUSTOMER_ENTERED_NULL);			
		}
	}

	@Test
	public void givenWeekdayRateForRegularCustomerNegative_WhenAddingHotel_ShouldThrowRateForRegularCustomerEmpty() {

		try {

			LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
			Hotel hotel = new Hotel();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			hotel = hotelReservationOperations.addNewHotel("Lakewood", -100 ,90);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.WEEKDAY_RATE_FOR_REGULAR_CUSTOMER_ENTERED_NEGATIVE);			
		}
	}
	@Test
	public void givenWeekendRateForRegularCustomerNull_WhenAddingHotel_ShouldThrowRateForRegularCustomerNull() {

		try {

			LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
			Hotel hotel = new Hotel();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			hotel = hotelReservationOperations.addNewHotel("LakeWood", 110, null);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.WEEKEND_RATE_FOR_REGULAR_CUSTOMER_ENTERED_NULL);			
		}
	}

	@Test
	public void givenWeekendRateForRegularCustomerNegative_WhenAddingHotel_ShouldThrowRateForRegularCustomerEmpty() {

		try {

			LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
			Hotel hotel = new Hotel();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			hotel = hotelReservationOperations.addNewHotel("Lakewood", 100 ,-90);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.WEEKEND_RATE_FOR_REGULAR_CUSTOMER_ENTERED_NEGATIVE);			
		}
	}


	@Test
	public void givenProperDates_WhenFindingCheapestHotel_ShouldReturnNameOfCheapestHotel() {

		LinkedHashSet<Hotel> listOfHotels = hotelList();
		HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
		String hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,"10Sep2020","11Sep2020");
		Assert.assertTrue(hotelName.equalsIgnoreCase("Lakewood"));
	}

	@Test
	public void givenDate1Null_WhenAddingHotel_ShouldThrowDateNull() {

		try {
			LinkedHashSet<Hotel> listOfHotels = hotelList();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			@SuppressWarnings("unused")
			String hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,"10Sep2020",null);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.DATE_CANNOT_BE_NULL);			
		}
	}

	@Test
	public void givenDate2Null_WhenAddingHotel_ShouldThrowDateNull() {

		try {
			LinkedHashSet<Hotel> listOfHotels = hotelList();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			@SuppressWarnings("unused")
			String hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,null,"10Sep2020");
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.DATE_CANNOT_BE_NULL);			
		}
	}

	@Test
	public void givenDate1Empty_WhenAddingHotel_ShouldThrowDateEmpty() {

		try {
			LinkedHashSet<Hotel> listOfHotels = hotelList();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			@SuppressWarnings("unused")
			String hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,"10Sep2020","");
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.DATE_CANNOT_BE_EMPTY);			
		}
	}

	@Test
	public void givenDate2Empty_WhenAddingHotel_ShouldThrowDateNull() {

		try {
			LinkedHashSet<Hotel> listOfHotels = hotelList();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			@SuppressWarnings("unused")
			String hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,"","10Sep2020");
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.DATE_CANNOT_BE_EMPTY);			
		}
	}

	@Test
	public void givenDate1Invalid_WhenAddingHotel_ShouldThrowDateInvalid() {

		try {
			LinkedHashSet<Hotel> listOfHotels = hotelList();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			@SuppressWarnings("unused")
			String hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,"10/Sep/2020","11Sep2020");
		}
		catch(HotelReservationExceptions e) {
			Assert.assertEquals(e.type,exceptionType.DATE_IN_INVALID_FORMAT);
		}
	}

	@Test
	public void givenDate2Invalid_WhenAddingHotel_ShouldThrowDateInvalid() {

		try {
			LinkedHashSet<Hotel> listOfHotels = hotelList();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			@SuppressWarnings("unused")
			String hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,"10Sep2020","11/Sep/2020");
		}
		catch(HotelReservationExceptions e) {
			Assert.assertEquals(e.type,exceptionType.DATE_IN_INVALID_FORMAT);
		}
	}
	
	@Test
	public void givenProperDates_WhenFindingCheapestHotelForBothWeekdayAndWeekend_ShouldReturnNameOfCheapestHotel() {

		LinkedHashSet<Hotel> listOfHotels = hotelList();
		HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
		ArrayList<String> cheapestHotels = hotelReservationOperations.findCheapestHotelForBothWeekdayAndWeekend(listOfHotels, "11Sep2020", "12Sep2020");
		Assert.assertTrue(("Hotel Name: LakeWood Total Price: 200".equalsIgnoreCase(cheapestHotels.get(0)))&&("Hotel Name: BridgeWood Total Price: 200".equalsIgnoreCase(cheapestHotels.get(1))));
	}
}