package entity;

public class Hotel extends BaseEntity{
	
	
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
