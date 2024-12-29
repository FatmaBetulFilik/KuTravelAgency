package DataHandle;

import entity.*;
import java.util.*;
import java.io.*;

public class HotelHandler {
	
	private static LinkedList<Hotel> hotelList = new LinkedList<>();
	
	public static LinkedList<Hotel> getHotelList() {
		return hotelList;
	}

	public static void setHotelList(LinkedList<Hotel> hotelList) {
		hotelList = hotelList;
	}

	public static void createHotelObj() {
		
		
		
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
	
}







