package com.capg.sprint1.fms.service;

import java.time.LocalDate;

import com.capg.sprint1.fms.service.InvalidNameException;

import com.capg.sprint1.fms.dao.BookingDaoImpl;
import com.capg.sprint1.fms.service.BookingIdException;
import com.capg.sprint1.fms.model.Booking;
import com.capg.sprint1.fms.model.Passenger;

public class BookingServiceImpl implements BookingService {
	BookingDaoImpl bookingDao=new BookingDaoImpl();

	public Booking modifyBooking(Booking booking) {
		return bookingDao.modifyBooking(booking);
	}

	public boolean deleteBooking(long bookingId) throws BookingIdException {
		if(!BookingDaoImpl.bookingNo.containsKey(bookingId)) {
			throw new BookingIdException("Error :BookingId not found");
		}
		return bookingDao.deleteBooking(bookingId);
	}

	public LocalDate modifyByDate(long bookingId, LocalDate date) throws BookingIdException {
		if(!BookingDaoImpl.bookingNo.containsKey(bookingId)) {
			throw new BookingIdException("Error : Booking Id not found, Please enter a valid booking Id");
		}
		return bookingDao.modifyByDate(bookingId, date);
	}

	public Passenger deleteByPassenger(long bookingId, String passengerName) throws BookingIdException,InvalidNameException{
		if(!BookingDaoImpl.bookingNo.containsKey(bookingId)) {
			throw new BookingIdException("Error : Booking Id not found, Please enter a valid booking Id");
		}
		else {
			if(BookingDaoImpl.bookingNo.get(bookingId).getPassengerList().stream().filter(p->p.getPassengerName().equalsIgnoreCase(passengerName)).count()==0) {
				throw new InvalidNameException("Error: Name not found, Please enter valid name");
			}
		}
			return   bookingDao.deleteByPassenger(bookingId,passengerName);
		
	}

	public  Passenger addByPassenger(long bookingId, Passenger p) throws BookingIdException {
		if(!BookingDaoImpl.bookingNo.containsKey(bookingId)) {
			throw new BookingIdException("Error : Booking Id not found, Please enter a valid booking Id");
		}
		return bookingDao.addByPassenger(bookingId, p);
	}


}
