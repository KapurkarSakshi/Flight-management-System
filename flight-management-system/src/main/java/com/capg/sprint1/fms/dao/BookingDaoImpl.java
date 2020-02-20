package com.capg.sprint1.fms.dao;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;
import com.capg.sprint1.fms.model.*;


public class BookingDaoImpl implements BookingDao {

	static Map<Long,Booking> bookingNo=new HashMap<Long,Booking>();
	public BookingDaoImpl() {
		addDetails();
	}
	public void addDetails() {
//User ::String userType, long userId, String userName, String userPassword, long userPhone,
	//		String userEmail	     
	     User u1=new User("Type1",1239,"Sak","passwrd",964090742,"sakshikapurkar@gmail.com");
	     User u2=new User("Type1",1238,"Sak","passwrd",964090742,"sakshikapurkar@gmail.com");
	     User u3=new User("Type1",1237,"Sak","passwrd",964090742,"sakshikapurkar@gmail.com");
	     
//Passenger:long pnrNumber, String passengerName, int passengerAge, long passengerUIN, double luggage		
     	List<Passenger> l1=new ArrayList<Passenger>();
		Passenger p1=new Passenger(1,"chinnu",20,20201205,10.55);
		Passenger p2=new Passenger(2,"shivani",21,20201206,20.05);
		Passenger p3=new Passenger(3,"koustubh",28,20201207,50.5);
		l1.add(p1);
		l1.add(p2);
		l1.add(p3);
		
		List<Passenger> l2=new ArrayList<Passenger>();
		Passenger p11=new Passenger(1,"sakku",20,20201205,10.55);
		Passenger p22=new Passenger(2,"chinnu",21,20201206,20.05);
		Passenger p33=new Passenger(3,"shashi",28,20201207,50.5);
		l2.add(p11);
		l2.add(p22);
		l2.add(p33);
		
		List<Passenger> l3=new ArrayList<Passenger>();
		Passenger p111=new Passenger(1,"charan",20,20201205,10.55);
		Passenger p222=new Passenger(2,"nidhi",21,20201206,20.05);
		Passenger p333=new Passenger(3,"neeta",28,20201207,50.5);
		l3.add(p111);
		l3.add(p222);
		l3.add(p333);
//long flightNumber, String flightModel, String carrierName, Integer seatCapacity
		  Flight f;
		Flight f1=new Flight(880,"Model1","Carrier1",100);
		Flight f2=new Flight(881,"Model2","Carrier2",200);
		Flight f3=new Flight(882,"Model3","Carrier3",300);
		
		LocalDate dt1= LocalDate.of(2001,1,1);
		LocalDate dt2= LocalDate.of(2002,2,2);
		LocalDate dt3= LocalDate.of(2003,3,3);
////Booking ::long bookingId, User userId,LocalDate bookingDate, List<Passenger> passengerList,
//	double ticketCost, Flight flight, Integer noOfPassengers
		
		Booking b1= new Booking(1234,u1,dt1,l1,2000,f1,20);
		Booking b2= new Booking(1235,u2,dt2,l2,4000,f2,40);
		Booking b3= new Booking(1236,u3,dt3,l3,5000,f3,80);
		
	
		bookingNo.put(b1.getBookingId(),b1);
		bookingNo.put(b2.getBookingId(),b2);
		bookingNo.put(b3.getBookingId(),b3);
		}
   
	public Booking modifyBooking(Booking booking) {
			return null;
	}

	public boolean deleteBooking(long bookingId) throws BookingException{
		if(!bookingNo.containsKey(bookingId)) {
			throw new BookingException("Error :BookingId not found");
		}
		bookingNo.remove(bookingId);
		return true;
		}
  
	public  LocalDate modifyByDate(long bookingId,LocalDate date) throws BookingException{
		if(!bookingNo.containsKey(bookingId)) {
			throw new BookingException("Error : Booking Id not found, Please enter a valid booking Id");
		}
		else {
		 bookingNo.get(bookingId).setBookingDate(date); 
		}
		return date;
	}
	Passenger passenger=new Passenger();
	
	public  Passenger addByPassenger(long bookingId,Passenger p) throws BookingException{
		if(!bookingNo.containsKey(bookingId)) {
			throw new BookingException("Error : Booking Id not found, Please enter a valid booking Id");
		}
		else {
		   bookingNo.get(bookingId).getPassengerList().add(p);
			}
		return p;
	
	}
	public  Passenger deleteByPassenger(long bookingId,String passengerName) throws BookingException,InvalidNameException{
		if(!	bookingNo.containsKey(bookingId)) {
			throw new BookingException("Error : Booking Id not found, Please enter a valid booking Id");
		}
		else {
			if(bookingNo.get(bookingId).getPassengerList().stream().filter(p->p.getPassengerName().equalsIgnoreCase(passengerName)).count()==0) {
				throw new InvalidNameException("Error: Name not found, Please enter valid name");
			}
		   bookingNo.get(bookingId).getPassengerList().remove(passenger);	
		      }
		return passenger;
		}
	

}