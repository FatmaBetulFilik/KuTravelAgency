package entity;

public class Hotel extends BaseEntity{
	
	/**
	 * Hotel(String name, String city, String roomType, int availableRooms, double cost, double distance) 
	 * constructor initializes a Hotel object with the specified details.
	 * 
	 * This constructor also calls the parent class constructor to initialize the cost attribute.
	 * 
	 * @param name : The name of the hotel.
	 * @param city : The city where the hotel is located.
	 * @param roomType : The type of room (e.g., Single, Double, Suite).
	 * @param availableRooms : The number of rooms available in the hotel.
	 * @param cost : The cost of a room per night.
	 * @param distance : The distance of the hotel from a specified point (e.g., city center).
	 */
	public Hotel(String name,String city,String roomType,
			int availableRooms,double cost,double distance) {
		super(cost);
		this.name = name;
		this.city = city;
		this.roomType = roomType;
		this.availableRooms = availableRooms;
		this.distance = distance;
	}
	
	
	
	
	
	
	
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getAvailableRooms() {
		return availableRooms;
	}

	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	private String city;
	private String roomType;
	private int availableRooms;
	private double distance;
	

	
	

}
