package travelPackage;

import java.util.*;
import java.io.*;
import user.*;
import entity.*;
import DataHandle.*;


public class TravelPackage {
	
	private String packageName; 
	private  ArrayList<Hotel> packageHotelList = new ArrayList<>();
	private  ArrayList<Taxi> packageTaxiList = new ArrayList<>();
	private  ArrayList<Flight> packageFlightList = new ArrayList<>();
	private double overallPackagePrice;
	private String status = "Available";
	
	/**
	 * TravelPackage(String name) constructor initializes a TravelPackage object with the specified name.
	 * 
	 * @param name : The name of the travel package.
	 */
	public TravelPackage(String name) {
		this.packageName = name;
		
	}

	/**
	 * addHotel(Hotel hotel) method adds a hotel to the list of hotels associated with the travel package.
	 * 
	 * @param hotel : The Hotel object to be added to the package's hotel list.
	 */
	public void addHotel(Hotel hotel) {
		packageHotelList.add(hotel);
	}
	
	
	/**
	 * addTaxi(Taxi taxi) method adds a taxi to the list of taxis associated with the travel package.
	 * 
	 * @param taxi : The Taxi object to be added to the package's taxi list.
	 */
	
	public void addTaxi(Taxi taxi) {
		packageTaxiList.add(taxi);
	}
	
	
	/**
	 * addFlight(Flight flight) method adds a flight to the list of flights associated with the travel package.
	 * 
	 * @param flight : The Flight object to be added to the package's flight list.
	 */
	
	public void addFlight(Flight flight) {
		packageFlightList.add(flight);
	}
				
			
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public ArrayList<Hotel> getPackageHotelList() {
		return packageHotelList;
	}
	public void setPackageHotelList(ArrayList<Hotel> packageHotelList) {
		this.packageHotelList = packageHotelList;
	}
	public ArrayList<Taxi> getPackageTaxiList() {
		return packageTaxiList;
	}
	public void setPackageTaxiList(ArrayList<Taxi> packageTaxiList) {
		this.packageTaxiList = packageTaxiList;
	}
	public ArrayList<Flight> getPackageFlightList() {
		return packageFlightList;
	}
	public void setPackageFlightList(ArrayList<Flight> packageFlightList) {
		this.packageFlightList = packageFlightList;
	}
	public double getOverallPackagePrice() {
		return overallPackagePrice;
	}
	public void setOverallPackagePrice(double overallPackagePrice) {
		this.overallPackagePrice = overallPackagePrice;
	}
	}
	
	
	
	
