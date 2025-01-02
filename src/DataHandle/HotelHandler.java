package DataHandle;

import entity.*;
import java.util.*;
import java.io.*;

public class HotelHandler {
	
	private static LinkedList<Hotel> hotelList = new LinkedList<>();
	
	
	/**
	 * createHotelObjList() method reads hotel data from a CSV file and creates Hotel objects based on the information 
	 * in the file. These Hotel objects are then added to the hotelList.
	 * 
	 * The method reads the CSV file line by line, splits each line by commas, and creates a Hotel object using the data 
	 * in each row. The following attributes are used to create each Hotel object:
	 * - Name (String)
	 * - City (String)
	 * - Room type (String)
	 * - Available rooms (int)
	 * - Cost per room (double)
	 * - Distance (double)
	 * 
	 * The created Hotel objects are added to the hotelList.
	 */

	public static void createHotelObjList() {
		
		try {
	
			File file = new File("C:\\Users\\fatma\\OneDrive\\Masaüstü\\FinalKU_Travel_Agency_Dataset_Hotels.csv");
			Scanner scanner = new Scanner(file);
			
			String headingsLine = scanner.nextLine();
			
			while(scanner.hasNextLine()) {
				String[] line = scanner.nextLine().split(",");
				Hotel hotelObj = new Hotel(line[0],line[1],line[2], Integer.parseInt(line[3]),Double.parseDouble(line[4]),Double.parseDouble(line[5]));
				hotelList.add(hotelObj);
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		}
	
	
	
	
	/**
	 * hotelDataCreator(String roomType) method filters the hotel list based on the provided room type and creates 
	 * a 2D array representing the data of hotels that match the given room type.
	 * 
	 * The method iterates through the list of hotels and checks if the room type of each hotel matches the provided roomType. 
	 * If it does, the hotel's details (name, city, room type, available rooms, cost, and distance) are stored in the array.
	 * 
	 * @param roomType : The type of room to filter (e.g., "Single", "Double").
	 * @return a 2D array of strings containing data about the filtered hotels.
	 */
	
	public static String[][] hotelDataCreator(String roomType){
		int LengthOfFilteredList = 0;
		
		
		for(Hotel currentHotel:HotelHandler.getHotelList()) {
			if(currentHotel.getRoomType().equals(roomType)) {
				LengthOfFilteredList+= 1;}}
		
				
			String[][] HotelData = new String[hotelList.size()][];
		
			int j = 0;
			for (Hotel hotel : HotelHandler.getHotelList()) {
				HotelData[j] = new String[] {
						hotel.getName(),
						hotel.getCity(),
						hotel.getRoomType(),
						String.valueOf(hotel.getAvailableRooms()),
						String.valueOf(hotel.getCost()),
						String.valueOf(hotel.getDistance())
				};
				j += 1;
					
			}
			
		return HotelData;
		
	}
	
	/**
	 * HotelDataCreator() method creates a 2D array representing the data of all hotels in the hotel list.
	 * 
	 * The method iterates through the entire hotel list and stores each hotel's details (name, city, room type, available 
	 * rooms, cost, and distance) into the array.
	 * 
	 * @return a 2D array of strings containing data about all hotels in the list.
	 */
	public static String[][] HotelDataCreator() {
		
		String[][] HotelData = new String[hotelList.size()][];
		
		int j = 0;
		for (Hotel hotel : HotelHandler.getHotelList()) {
		    HotelData[j] = new String[] {
		        hotel.getName(),
		        hotel.getCity(),
		        hotel.getRoomType(),
		        String.valueOf(hotel.getAvailableRooms()),
		        String.valueOf(hotel.getCost()),
		        String.valueOf(hotel.getDistance())
		    };
		    j += 1;
		    
		}
		return HotelData;
	
	}
	
	public static LinkedList<Hotel> getHotelList() {
		return hotelList;
	}

	public static void setHotelList(LinkedList<Hotel> hotelList) {
		hotelList = hotelList;
	}
}







