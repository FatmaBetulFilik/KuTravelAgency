package entity;

import java.time.LocalTime;

public class DirectFlight extends Flight{
	
	private String arrivalCity;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	
	/**
	 * DirectFlight(String flightID, String airline, String departureCity, String arrivalCity, 
	 * LocalTime departureTime, LocalTime arrivalTime, String classType, double cost, int availableSeat) 
	 * constructor initializes a DirectFlight object with the specified details.
	 * 
	 * This constructor also invokes the parent class (Flight) constructor to initialize 
	 * shared attributes like flightID, airline, departureCity, classType, cost, and availableSeat.
	 * 
	 * @param flightID : The unique identifier for the flight.
	 * @param airline : The name of the airline operating the flight.
	 * @param departureCity : The city from which the flight departs.
	 * @param arrivalCity : The city where the flight arrives.
	 * @param departureTime : The departure time of the flight.
	 * @param arrivalTime : The arrival time of the flight.
	 * @param classType : The class type of the flight (e.g., Economy, Business).
	 * @param cost : The cost of the flight.
	 * @param availableSeat : The number of available seats on the flight.
	 */

	public DirectFlight(String flightID,String airline,
			String departureCity,String arrivalCity,LocalTime departureTime, LocalTime arrivalTime, String classType,double cost,int availableSeat) {
		super(flightID,airline,departureCity,classType,cost,availableSeat);
		
		this.arrivalCity = arrivalCity;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		
		
	}
	
	
	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivaTime) {
		this.arrivalTime = arrivaTime;
	}
	
	
	

}