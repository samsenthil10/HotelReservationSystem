package com.bridgelabz.hotelreservationsystem;

import java.util.LinkedHashSet;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.hotelreservationsystem.HotelReservationExceptions.exceptionType;

public class HotelReservationTest {
	
	@Test
	public void givenName_WhenAddingHotel_ShouldIncreaseSize() {

		try {
			
			LinkedHashSet<Hotel> listOfHotels = new LinkedHashSet<>();
			Hotel hotel = new Hotel();
			HotelReservationIF hotelReservationOperations = new HotelReservationImpl();
			hotel = hotelReservationOperations.addNewHotel("Lakewood", 110);
			int size = (int) listOfHotels.stream().count();
			listOfHotels.add(hotel);
			Assert.assertEquals(listOfHotels.size(), size+1);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals("Name cannot be Null!",exceptionType.NAME_ENTERED_NULL);			
		}
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
			hotel = hotelReservationOperations.addNewHotel(null, 110);
			listOfHotels.add(hotel);
		}
		catch(HotelReservationExceptions e) {

			Assert.assertEquals("Name cannot be Null!",exceptionType.NAME_ENTERED_NULL);			
		}
	}
}