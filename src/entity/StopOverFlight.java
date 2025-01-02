package entity;
import java.time.LocalTime;

public class StopOverFlight extends Flight{
	
	private String stopOverCity;
	private String finalArrivalCity;
	private LocalTime leg1DepTime;
	private LocalTime leg1ArriveTime;
	private LocalTime leg2DepTime;
	private LocalTime leg2ArriveTime;
	
	
	/**
	 * StopOverFlight(String flightID, String airline, String departureCity, String classType, 
	 * double cost, int availableSeat, String stopOverCity, String finalArrivalCity, 
	 * LocalTime leg1DepTime, LocalTime leg1ArriveTime, LocalTime leg2DepTime, LocalTime leg2ArriveTime) 
	 * constructor initializes a StopOverFlight object with the specified details.
	 * 
	 * This constructor also invokes the parent class constructor to initialize shared attributes 
	 * like flightID, airline, departureCity, classType, cost, and availableSeat.
	 * 
	 * @param flightID : The unique identifier for the flight.
	 * @param airline : The name of the airline operating the flight.
	 * @param departureCity : The city from which the flight departs.
	 * @param classType : The class type of the flight (e.g., Economy, Business).
	 * @param cost : The cost of the flight.
	 * @param availableSeat : The number of available seats on the flight.
	 * @param stopOverCity : The city where the flight stops over before reaching its final destination.
	 * @param finalArrivalCity : The city where the flight ends its journey.
	 * @param leg1DepTime : The departure time for the first leg of the flight.
	 * @param leg1ArriveTime : The arrival time for the first leg of the flight.
	 * @param leg2DepTime : The departure time for the second leg of the flight.
	 * @param leg2ArriveTime : The arrival time for the second leg of the flight.
	 */

	public StopOverFlight(String flightID,String airline,
			String departureCity,String classType,double cost,int availableSeat,
			String stopOverCity, String finalArrivalCity, LocalTime leg1DepTime,
			LocalTime leg1ArriveTime, LocalTime leg2DepTime, LocalTime leg2ArriveTime) {
		
		super(flightID,airline,departureCity,classType,cost,availableSeat);
		
		this.stopOverCity = stopOverCity;
		this.finalArrivalCity = finalArrivalCity;
		this.leg1DepTime = leg1DepTime;
		this.leg1ArriveTime = leg1ArriveTime;
		this.leg2DepTime = leg2DepTime;
		this.leg2ArriveTime = leg2ArriveTime;
	}
	
	
	
	
	
	
	

	public String getStopOverCity() {
		return stopOverCity;
	}





	public void setStopOverCity(String stopOverCity) {
		this.stopOverCity = stopOverCity;
	}





	public String getFinalArrivalCity() {
		return finalArrivalCity;
	}





	public void setFinalArrivalCity(String finalArrivalCity) {
		this.finalArrivalCity = finalArrivalCity;
	}





	public LocalTime getLeg1DepTime() {
		return leg1DepTime;
	}





	public void setLeg1DepTime(LocalTime leg1DepTime) {
		this.leg1DepTime = leg1DepTime;
	}





	public LocalTime getLeg1ArriveTime() {
		return leg1ArriveTime;
	}





	public void setLeg1ArriveTime(LocalTime leg1ArriveTime) {
		this.leg1ArriveTime = leg1ArriveTime;
	}





	public LocalTime getLeg2DepTime() {
		return leg2DepTime;
	}





	public void setLeg2DepTime(LocalTime leg2DepTime) {
		this.leg2DepTime = leg2DepTime;
	}





	public LocalTime getLeg2ArriveTime() {
		return leg2ArriveTime;
	}





	public void setLeg2ArriveTime(LocalTime leg2ArriveTime) {
		this.leg2ArriveTime = leg2ArriveTime;
	}

	
}
