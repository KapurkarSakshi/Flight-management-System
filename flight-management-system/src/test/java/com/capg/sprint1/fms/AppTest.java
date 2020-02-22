package com.capg.sprint1.fms;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDate;
import java.util.*;
import org.junit.jupiter.api.*;
import com.capg.sprint1.fms.dao.BookingDaoImpl;
import com.capg.sprint1.fms.model.*;
import com.capg.sprint1.fms.service.*;

public class AppTest 
{
   BookingService service=new BookingServiceImpl();
   static BookingDaoImpl dao=new BookingDaoImpl();
   static Map<Long,Booking> bookingNo= BookingDaoImpl.bookingNo;
	
	
   @BeforeAll
   public void BookingDaoImpl() {
	   Flight f1=new Flight(880,"Model1","Carrier1",100);
	   User u1=new User("Type1",1239,"Sak","passwrd",964090742,"sakshikapurkar@gmail.com");
	   List<Passenger> l1=new ArrayList<Passenger>();
	 		Passenger p1=new Passenger(1,"chinnu",20,20201205,10.55);
	 		Passenger p2=new Passenger(2,"shivani",21,20201206,20.05);
	 		Passenger p3=new Passenger(3,"koustubh",28,20201207,50.5);
	  l1.add(p1);
	  l1.add(p2);
	  l1.add(p3);
	  LocalDate dt1= LocalDate.of(2001,1,1);
	  Booking b1= new Booking(1234,u1,dt1,l1,2000,f1,20);
	 		bookingNo.put(b1.getBookingId(),b1);
	 	}
   
   // Checking for Booking Id Exception 
   @Test
   public void BookingIdException() {
	 assertThrows(BookingIdException.class,()->{service.deleteBooking(1234567);});
   }  
    @Test
   public void InvalidNameException() {
	   assertThrows(InvalidNameException.class,()->{service.deleteByPassenger(1235, "chinnu");});   
   }
   
}
