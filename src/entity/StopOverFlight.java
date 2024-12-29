package entity;
import java.time.LocalTime;

public class StopOverFlight extends Flight{
	
	private String stopOverCity;
	private String finalArrivalCity;
	private LocalTime leg1DepTime;
	private LocalTime leg1ArriveTime;
	private LocalTime leg2DepTime;
	private LocalTime leg2ArriveTime;
	
	
	
	
	




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
