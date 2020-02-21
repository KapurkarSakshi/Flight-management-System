package com.capg.sprint1.fms.dao;
import com.capg.sprint1.fms.service.BookingIdException;
import com.capg.sprint1.fms.service.InvalidNameException;
import java.time.LocalDate;
import com.capg.sprint1.fms.model.*;

public interface BookingDao {
	 public Booking modifyBooking(Booking booking);
	 public boolean deleteBooking(long bookingId) throws BookingIdException, BookingIdException;
	 public  LocalDate modifyByDate(long bookingId,LocalDate date) throws BookingIdException;
	 public  Passenger addByPassenger(long bookingId,Passenger p) throws BookingIdException;
	 public  Passenger deleteByPassenger(long bookingId,String passengerName) throws BookingIdException,InvalidNameException;

}
