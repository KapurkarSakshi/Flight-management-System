package com.capg.sprint1.fms.service;

import java.time.LocalDate;

import com.capg.sprint1.fms.dao.InvalidNameException;

import com.capg.sprint1.fms.dao.BookingDaoImpl;
import com.capg.sprint1.fms.dao.BookingException;
import com.capg.sprint1.fms.model.Booking;
import com.capg.sprint1.fms.model.Passenger;

public class BookingServiceImpl implements BookingService {
	BookingDaoImpl bookingDao=new BookingDaoImpl();

	public Booking modifyBooking(Booking booking) {
		return bookingDao.modifyBooking(booking);
	}

	public boolean deleteBooking(long bookingId) throws BookingException {
		return bookingDao.deleteBooking(bookingId);
	}

	public LocalDate modifyByDate(long bookingId, LocalDate date) throws BookingException {
		return bookingDao.modifyByDate(bookingId, date);
	}

	public Passenger deleteByPassenger(long bookingId, String passengerName) throws BookingException,InvalidNameException{
			return   bookingDao.deleteByPassenger(bookingId, passengerName) ;
		
	}

	public Passenger addByPassenger(long bookingId, Passenger p) throws BookingException {
		
		return bookingDao.addByPassenger(bookingId, p);
	}


}
