package entity;

import java.time.LocalTime;

public class DirectFlight extends Flight{
	
	private String arrivalCity;
	private LocalTime departureTime;
	private LocalTime arrivaTime;
	


	public DirectFlight(String flightID,String airline,
			String departureCity,String arrivalCity,LocalTime departureTime, LocalTime arrivalTime, String classType,double cost,int availableSeat) {
		super(flightID,airline,departureCity,classType,cost,availableSeat);
		
		this.arrivalCity = arrivalCity;
		this.arrivaTime = arrivalTime;
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

	public LocalTime getArrivaTime() {
		return arrivaTime;
	}

	public void setArrivaTime(LocalTime arrivaTime) {
		this.arrivaTime = arrivaTime;
	}
	
	
	

}