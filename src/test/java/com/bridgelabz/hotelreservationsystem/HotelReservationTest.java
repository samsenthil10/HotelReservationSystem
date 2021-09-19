package com.bridgelabz.hotelreservationsystem;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.hotelreservationsystem.HotelReservationExceptions.exceptionType;

public class HotelReservationTest {

	@Test
	public void givenName_WhenAddingHotel_ShouldIncreaseSize() {

		LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
		Hotel hotel = new Hotel();
		HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
		hotel = hotelReservationOperations.addNewHotel("Lakewood", 110, 90, 3);
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
			hotel = hotelReservationOperations.addNewHotel(null, 110, 90, 3);
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
			hotel = hotelReservationOperations.addNewHotel("", 110, 90, 3);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.NAME_ENTERED_EMPTY);			
		}
	}

	@Test
	public void givenProperRatesForCustomer_WhenAddingHotel_ShouldIncreaseSize() {

		LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
		Hotel hotel = new Hotel();
		HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
		hotel = hotelReservationOperations.addNewHotel("Lakewood", 110, 90, 3);
		int size = (int) listOfHotels.stream().count();
		listOfHotels.add(hotel);
		Assert.assertEquals(listOfHotels.size(), size+1);
	}

	@Test
	public void givenWeekdayRateForCustomerNull_WhenAddingHotel_ShouldThrowRateForCustomerNull() {

		try {

			LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
			Hotel hotel = new Hotel();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			hotel = hotelReservationOperations.addNewHotel("LakeWood", null, 90, 3);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.WEEKDAY_RATE_FOR_CUSTOMER_ENTERED_NULL);			
		}
	}

	@Test
	public void givenWeekdayRateForCustomerNegative_WhenAddingHotel_ShouldThrowRateForCustomerNegative() {

		try {

			LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
			Hotel hotel = new Hotel();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			hotel = hotelReservationOperations.addNewHotel("Lakewood", -100 ,90, 3);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.WEEKDAY_RATE_FOR_CUSTOMER_ENTERED_NEGATIVE);			
		}
	}
	@Test
	public void givenWeekendRateForCustomerNull_WhenAddingHotel_ShouldThrowRateForCustomerNull() {

		try {

			LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
			Hotel hotel = new Hotel();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			hotel = hotelReservationOperations.addNewHotel("LakeWood", 110, null, 3);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.WEEKEND_RATE_FOR_CUSTOMER_ENTERED_NULL);			
		}
	}

	@Test
	public void givenWeekendRateForCustomerNegative_WhenAddingHotel_ShouldThrowRateForCustomerNegative() {

		try {

			LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
			Hotel hotel = new Hotel();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			hotel = hotelReservationOperations.addNewHotel("Lakewood", 100 ,-90, 3);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.WEEKEND_RATE_FOR_CUSTOMER_ENTERED_NEGATIVE);			
		}
	}

	@Test
	public void givenRatingNull_WhenAddingHotel_ShouldThrowRateForRatingNull() {

		try {

			LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
			Hotel hotel = new Hotel();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			hotel = hotelReservationOperations.addNewHotel("LakeWood", 110, 90, null);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.RATING_NULL);			
		}
	}

	@Test
	public void givenRatingNegative_WhenAddingHotel_ShouldThrowRatingNegative() {

		try {

			LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
			Hotel hotel = new Hotel();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			hotel = hotelReservationOperations.addNewHotel("Lakewood", 100 ,90, -3);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.RATING_NEGATIVE);			
		}
	}

	@Test
	public void givenDate1Null_WhenAddingHotel_ShouldThrowDateNull() {

		try {
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			LinkedHashSet<Hotel> listOfHotels = hotelReservationOperations.hotelListForRegularCustomer();
			@SuppressWarnings("unused")
			ArrayList<String> hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,"10Sep2020",null);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.DATE_CANNOT_BE_NULL);			
		}
	}

	@Test
	public void givenDate2Null_WhenAddingHotel_ShouldThrowDateNull() {

		try {
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			LinkedHashSet<Hotel> listOfHotels = hotelReservationOperations.hotelListForRegularCustomer();
			@SuppressWarnings("unused")
			ArrayList<String> hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,null,"10Sep2020");
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.DATE_CANNOT_BE_NULL);			
		}
	}

	@Test
	public void givenDate1Empty_WhenAddingHotel_ShouldThrowDateEmpty() {

		try {
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			LinkedHashSet<Hotel> listOfHotels = hotelReservationOperations.hotelListForRegularCustomer();
			@SuppressWarnings("unused")
			ArrayList<String> hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,"10Sep2020","");
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.DATE_CANNOT_BE_EMPTY);			
		}
	}

	@Test
	public void givenDate2Empty_WhenAddingHotel_ShouldThrowDateNull() {

		try {
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			LinkedHashSet<Hotel> listOfHotels = hotelReservationOperations.hotelListForRegularCustomer();
			@SuppressWarnings("unused")
			ArrayList<String> hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,"","10Sep2020");
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals(e.type,exceptionType.DATE_CANNOT_BE_EMPTY);			
		}
	}

	@Test
	public void givenDate1Invalid_WhenAddingHotel_ShouldThrowDateInvalid() {

		try {
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			LinkedHashSet<Hotel> listOfHotels = hotelReservationOperations.hotelListForRegularCustomer();
			@SuppressWarnings("unused")
			ArrayList<String> hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,"10/Sep/2020","11Sep2020");
		}
		catch(HotelReservationExceptions e) {
			Assert.assertEquals(e.type,exceptionType.DATE_IN_INVALID_FORMAT_BY_REGEX);
		}
	}

	@Test
	public void givenDate2Invalid_WhenAddingHotel_ShouldThrowDateInvalid() {

		try {
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			LinkedHashSet<Hotel> listOfHotels = hotelReservationOperations.hotelListForRegularCustomer();
			@SuppressWarnings("unused")
			ArrayList<String> hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,"10Sep2020","11/Sep/2020");
		}
		catch(HotelReservationExceptions e) {
			Assert.assertEquals(e.type,exceptionType.DATE_IN_INVALID_FORMAT_BY_REGEX);
		}
	}

	@Test
	public void givenDate1Invalid_WhenAddingHotel_ShouldThrowDateInvalidByRegex() {

		try {
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			LinkedHashSet<Hotel> listOfHotels = hotelReservationOperations.hotelListForRegularCustomer();
			@SuppressWarnings("unused")
			ArrayList<String> hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,"test","user");
		}
		catch(HotelReservationExceptions e) {
			Assert.assertEquals(e.type,exceptionType.DATE_IN_INVALID_FORMAT_BY_REGEX);
		}
	}

	@Test
	public void givenProperDates_WhenFindingCheapestHotelForRegularCustomerInWeekdays_ShouldReturnNameOfCheapestHotel() {

		HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
		LinkedHashSet<Hotel> listOfHotels = hotelReservationOperations.hotelListForRegularCustomer();
		ArrayList<String> hotelName = hotelReservationOperations.findCheapestHotel(listOfHotels,"10Sep2020","11Sep2020");
		Assert.assertTrue(hotelName.stream().findFirst().get().equalsIgnoreCase("Hotel Name: LakeWood Rating: 3 Total Price: 220"));
	}

	@Test
	public void givenProperDates_WhenFindingCheapestHotelForRegularCustomer_ShouldReturnNameOfCheapestHotel() {

		HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
		LinkedHashSet<Hotel> listOfHotels = hotelReservationOperations.hotelListForRegularCustomer();
		ArrayList<String> cheapestHotels = hotelReservationOperations.findCheapestHotel(listOfHotels, "11Sep2020", "12Sep2020");
		Assert.assertTrue(("Hotel Name: BridgeWood Rating: 4 Total Price: 200".equalsIgnoreCase(cheapestHotels.get(0))));
	}
	@Test
	public void givenProperDates_WhenFindingBestRatedHotelForRegularCustomer_ShouldReturnNameOfBestRatedHotel() {

		HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
		LinkedHashSet<Hotel> listOfHotels = hotelReservationOperations.hotelListForRegularCustomer();
		ArrayList<String> bestRatedHotels = hotelReservationOperations.findBestRatedHotel(listOfHotels, "11Sep2020", "12Sep2020");
		Assert.assertTrue(("Hotel Name: RidgeWood Rating: 5 Total Price: 370".equalsIgnoreCase(bestRatedHotels.get(0))));
	}
	@Test
	public void givenProperDates_WhenFindingBestRatedHotelForRewardCustomer_ShouldReturnNameOfBestRatedHotel() {

		HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
		LinkedHashSet<Hotel> listOfHotels = hotelReservationOperations.hotelListForRewardCustomer();
		ArrayList<String> bestRatedHotels = hotelReservationOperations.findBestRatedHotel(listOfHotels, "11Sep2020", "12Sep2020");
		Assert.assertTrue(("Hotel Name: RidgeWood Rating: 5 Total Price: 140".equalsIgnoreCase(bestRatedHotels.get(0))));
	}
}