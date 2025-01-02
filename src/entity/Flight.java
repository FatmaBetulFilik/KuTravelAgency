package entity;

public abstract class Flight extends BaseEntity{
	
	private String flightID;
	private String airline;
	private String departureCity;
	private String classType;
	private int availableSeat;

	/**
	 * Flight(String flightID, String airline, String departureCity, String classType, double cost, int availableSeat) 
	 * constructor initializes a Flight object with the specified details.
	 * 
	 * This constructor also calls the parent class constructor to initialize the cost attribute.
	 * 
	 * @param flightID : The unique identifier for the flight.
	 * @param airline : The name of the airline operating the flight.
	 * @param departureCity : The city from which the flight departs.
	 * @param classType : The class type of the flight (e.g., Economy, Business).
	 * @param cost : The cost of the flight.
	 * @param availableSeat : The number of available seats on the flight.
	 */

		public Flight(String flightID,String airline,String departureCity,String classType,double cost,int availableSeat){
		super(cost);
		this.flightID = flightID;
		this.airline = airline;
		this.departureCity = departureCity;
		this.classType = classType;
		this.availableSeat = availableSeat;
	}

		
		
		
		
		
		
		public String getFlightID() {
			return flightID;
		}


		public void setFlightID(String flightID) {
			this.flightID = flightID;
		}


		public String getAirline() {
			return airline;
		}


		public void setAirline(String airline) {
			this.airline = airline;
		}


		public String getDepartureCity() {
			return departureCity;
		}


		public void setDepartureCity(String departureCity) {
			this.departureCity = departureCity;
		}


		public String getClassType() {
			return classType;
		}


		public void setClassType(String classType) {
			this.classType = classType;
		}


		public int getAvailableSeat() {
			return availableSeat;
		}


		public void setAvailableSeat(int availableSeat) {
			this.availableSeat = availableSeat;
		}
}
