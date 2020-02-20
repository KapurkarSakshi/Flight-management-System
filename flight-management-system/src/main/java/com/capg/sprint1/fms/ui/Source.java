package com.capg.sprint1.fms.ui;
import com.capg.sprint1.fms.dao.*;

import java.io.ObjectInputStream.GetField;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;
import com.capg.sprint1.fms.model.*;
import com.capg.sprint1.fms.service.BookingServiceImpl;

public class Source {

	public static void main(String[] args) throws BookingException ,InvalidNameException{
		BookingServiceImpl bkngSrvObj=new BookingServiceImpl();
		BookingDaoImpl bkngDaoObj=new BookingDaoImpl();
		Booking bkObj=new Booking();
		
		Scanner in=new Scanner(System.in);
		System.out.println("Choose the modification: \n 1.Cancel \n 2.Modify ");
		int choose1=in.nextInt();
		if(choose1==1) {
			System.out.println("Enter the bookingId");
			long bookingId=in.nextLong();
			try {
				bkngSrvObj.deleteBooking(bookingId);
				System.out.println("Deleted");
				}
			 catch(BookingException ex) {
				 System.out.println(ex.getMessage());
				 }
		}
			
			else {
			System.out.println("Choose the type of Modification :");
			System.out.println("1.Booking Date \n2.List of Passengers \n");
			int choose2=in.nextInt();
//			System.out.println("Enter all the below details: \n bookingId:");
//			long bookingId=in.nextLong();
			switch(choose2) {
			case 1: System.out.println("You have chosed the Booking Date option to change the date");
			        System.out.println("Enter the date in yyyy,mm,dd  order");
			        int yyyy=in.nextInt();
			        int mm=in.nextInt();
			        int dd=in.nextInt();
       		        
			        LocalDate date= LocalDate.of(yyyy,mm,dd);
			        try {
			        System.out.println("Enter all the below details: \n bookingId:");
					long bookingId=in.nextLong();
			        bkngSrvObj.modifyByDate(bookingId,date);
			        System.out.println("Your Updated booking date is :"+date);
			        }
			        catch(BookingException e) {System.out.println(e.getMessage());}
			        
				    break;
				
			case 2: System.out.println("You have choose the Name to add or to delete of Passenger List"+ "\n 1.add"+"\n 2.delete");
			
			int choose3=in.nextInt();
			switch(choose3) {
			case 1:System.out.println("Enter the passenger details :"+"1.PnrNumber");
			        long pnrNumber=in.nextLong();
			        System.out.println("2.PassengerName");
			        String passengerName=in.next();
			        System.out.println("3.PassengerAge");
			        int passengerAge=in.nextInt();
			        System.out.println("4.PassengerUIN");
			        long passengerUIN=in.nextLong();
			        System.out.println("5.Luggage weight");
			        double Luggage=in.nextDouble();
				    Passenger p =new Passenger(pnrNumber,passengerName,passengerAge,passengerUIN,Luggage);
				    System.out.println("Enter the below details: \n bookingId to which the passenger details are to be added:");
					long bookingId=in.nextLong();
					try {
				    bkngSrvObj.addByPassenger(bookingId,p);}
					catch(BookingException e) {System.out.println(e.getMessage());}
				    System.out.println(" Passenger details Added");
				   
				    
				    break;
			case 2 :System.out.println("Enter the Passenger Name ");
			         String passgName=in.next()+in.nextLine();
			         System.out.println("Enter the below details: \n bookingId:");
		 			 bookingId=in.nextLong();
			         try {
			             bkngSrvObj.deleteByPassenger(bookingId,passgName);
			             System.out.println("Deleted successfully");}
			         catch(InvalidNameException ex) {//System.out.println(ex.getMessage());
			        	 ex.printStackTrace();}
			         
			         catch(BookingException e) {//System.out.println(e.getMessage());
			         e.printStackTrace();
			         }
			        break;
			default:System.out.println("Invalid input");
			        break;
			      }
			}
		}
	}

}
