package travelPackage;

import java.io.FileWriter;
import java.util.*;

import entity.Flight;
import entity.Hotel;
import entity.Taxi;

public class CustomerReservation {
	private LinkedList<Hotel> ReservationHotelList = new LinkedList<>();
	private LinkedList<Taxi> ReservationTaxiList = new LinkedList<>();
	private LinkedList<Flight> ReservationFlightList = new LinkedList<>();
	
	private  String reservationName;
	private String Status = "Active" ;
	
	private  int overallPackagePrice = 0;

	/**
	 * calculateTotalCost(int duration, double distance) method calculates the total cost of the travel package 
	 * by summing up the costs of hotels, taxis, and flights.
	 * 
	 * The cost is calculated as follows:
	 * - Hotels: Cost is multiplied by the duration of stay.
	 * - Taxis: Cost is multiplied by the distance traveled.
	 * - Flights: The cost of each flight is directly added.
	 * 
	 * @param duration : The duration of the stay (e.g., in days) used to calculate the hotel costs.
	 * @param distance : The distance (e.g., in kilometers or miles) used to calculate the taxi costs.
	 * @return the total cost of the travel package as an integer.
	 */
	
	public int calculateTotalCost(int duration, double distance) {
		
		for(Hotel hotel:ReservationHotelList) {
			overallPackagePrice += hotel.getCost()*duration;
		}
		for(Taxi taxi:ReservationTaxiList) {
			overallPackagePrice += taxi.getCost()*distance;
			
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
	public int getOverallPackagePrice() {
		return overallPackagePrice;
	}
	public void setOverallPackagePrice(int overallPackagePrice) {
		this.overallPackagePrice = overallPackagePrice;
	}

	
	
	
	
	
	
	
	
	
}
