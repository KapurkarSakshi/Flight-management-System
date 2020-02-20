package com.capg.sprint1.fms.dao;
import java.math.BigInteger;
import java.time.LocalDate;

import com.capg.sprint1.fms.model.*;

public interface BookingDao {
	 public Booking modifyBooking(Booking booking);
	 public boolean deleteBooking(long bookingId) throws BookingException;
	 public  LocalDate modifyByDate(long bookingId,LocalDate date) throws BookingException;
	 public  Passenger addByPassenger(long bookingId,Passenger p) throws BookingException;
	 public  Passenger deleteByPassenger(long bookingId,String passengerName) throws BookingException,InvalidNameException;

}
