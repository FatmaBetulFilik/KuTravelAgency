package travelPackage;

import java.util.*;
import java.io.*;
import user.*;
import entity.*;
import DataHandle.*;


public class TravelPackage {
	
	private static ArrayList<Hotel> packageHotelList = new ArrayList<>();
	private static ArrayList<Taxi> packageTaxiList = new ArrayList<>();
	private static ArrayList<Flight> packageFlightList = new ArrayList<>();
	
	private double taxiPrice;
	private double hotelPrice;
	private double flightPrice;
	private double overallPackagePrice = taxiPrice + hotelPrice + flightPrice;
	
	public static void addHotel(Hotel hotel) {
		packageHotelList.add(hotel);
	}
	public static void addTaxi(Taxi taxi) {
		packageTaxiList.add(taxi);
	}
	public static void addFlight(Flight flight) {
		packageFlightList.add(flight);
	}
	
	
	
	public void createTravelPackage() {
		
	}
	
	
	
}
