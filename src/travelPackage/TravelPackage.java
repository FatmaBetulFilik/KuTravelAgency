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
	
	
	public TravelPackage(String name) {
		this.packageName = name;
		
	}
	
	public TravelPackage(String Name, double price) {
		this.packageName = Name;
		this.overallPackagePrice = price;
		
	}
	
	
	
	public void addHotel(Hotel hotel) {
		packageHotelList.add(hotel);
	}
	public void addTaxi(Taxi taxi) {
		packageTaxiList.add(taxi);
	}
	public void addFlight(Flight flight) {
		packageFlightList.add(flight);
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
	
	
	
	
