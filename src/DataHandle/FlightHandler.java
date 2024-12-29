package DataHandle;

import java.io.File;
import java.time.LocalTime;
import java.util.*;

import entity.DirectFlight;
import entity.Hotel;
import entity.StopOverFlight;


public class FlightHandler {
	
	private static LinkedList<StopOverFlight> stopOverFlightList = new LinkedList<>();
	private static LinkedList<DirectFlight> directFlightList = new LinkedList<>();

			
			
		
	



	public static void createFlightObj() {
		
		
	try {
		
		File file = new File("C:\\Users\\fatma\\OneDrive\\Masaüstü\\FinalKU_Travel_Agency_Dataset_Flights.csv");
		Scanner scanner = new Scanner(file);
		
		
		String headingsLine = scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			
			String[] line = scanner.nextLine().split(",");
			
			System.out.println(line.length);
			
			if(line.length == 15) {
		
				StopOverFlight stopOverFlightObj = new StopOverFlight(line[0],line[1],line[2],line[6],
										Double.parseDouble(line[7]),Integer.parseInt(line[8]),
										line[9],line[10],LocalTime.parse(line[11]),LocalTime.parse(line[12]),
										LocalTime.parse(line[13]),LocalTime.parse(line[14]));
			
				stopOverFlightList.add(stopOverFlightObj);
				
			}else {
				
				DirectFlight directFlightObj = new DirectFlight(line[0],line[1],line[2],
					line[3],LocalTime.parse(line[4]),LocalTime.parse(line[5]),
					line[6],Double.parseDouble(line[7]),Integer.parseInt(line[8]));
				
				directFlightList.add(directFlightObj);
				
			}
		}
		
		
		
		
		
		
		
		
	}catch(Exception e){
		System.out.println(e.getMessage());
		}
	}
	

	


	public static LinkedList<StopOverFlight> getStopOverFlightList() {
		return stopOverFlightList;
	}




	public static void setStopOverFlightList(LinkedList<StopOverFlight> stopOverFlightList) {
		FlightHandler.stopOverFlightList = stopOverFlightList;
	}




	public static LinkedList<DirectFlight> getDirectFlightList() {
		return directFlightList;
	}




	public static void setDirectFlightList(LinkedList<DirectFlight> directFlightList) {
		FlightHandler.directFlightList = directFlightList;
	}


	

	}
	
	
	