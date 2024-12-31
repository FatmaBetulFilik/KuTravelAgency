package travelPackage;

import java.util.*;

import entity.Flight;
import entity.Hotel;
import entity.Taxi;

public class CustomerReservation {
	private  static LinkedList<Hotel> ReservationHotelList = new LinkedList<>();
	private static LinkedList<Taxi> ReservationTaxiList = new LinkedList<>();
	private static LinkedList<Flight> ReservationFlightList = new LinkedList<>();
	
	private  String reservationName;
	private String Status ;
	



	private  double overallPackagePrice = 0.0;
	

	
	public double calculateTotalCost() {
		for(Hotel hotel:ReservationHotelList) {
			overallPackagePrice += hotel.getCost();
		}
		for(Taxi taxi:ReservationTaxiList) {
			overallPackagePrice += taxi.getCost();
			
		}
		for(Flight flight:ReservationFlightList) {
			overallPackagePrice += flight.getCost();
		}
		return overallPackagePrice;
	}
	
	
	
	public  LinkedList<Hotel> getReservationHotelList() {
		return ReservationHotelList;
	}
	public  void setReservationHotelList(LinkedList<Hotel> reservationHotelList) {
		ReservationHotelList = reservationHotelList;
	}
	public  LinkedList<Taxi> getReservationTaxiList() {
		return ReservationTaxiList;
	}
	public  void setReservationTaxiList(LinkedList<Taxi> reservationTaxiList) {
		ReservationTaxiList = reservationTaxiList;
	}
	public  LinkedList<Flight> getReservationFlightList() {
		return ReservationFlightList;
	}
	public  void setReservationFlightList(LinkedList<Flight> reservationFlightList) {
		ReservationFlightList = reservationFlightList;
	}
	
	
	public  String getReservationName() {
		return reservationName;
	}



	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}
	
	
	public String getStatus() {
		return Status;
	}



	public void setStatus(String status) {
		Status = status;
	}
	
	
	
	
	
	
	
	
	
	
	
}
