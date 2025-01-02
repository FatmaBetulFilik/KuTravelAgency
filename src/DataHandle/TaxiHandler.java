package DataHandle;

import java.util.*;
import java.io.*;
import entity.*;
import entity.*
;
public class TaxiHandler{
	
	private static LinkedList<Taxi> taxiList = new LinkedList<>();
	


	/**
	 * CreateTaxiObjList() method reads taxi data from a CSV file and creates Taxi objects 
	 * based on the information in the file. These Taxi objects are then added to the taxiList.
	 * 
	 * The method reads the CSV file line by line, splits each line by commas, and creates a Taxi object 
	 * using the data in each row. The following attributes are used to create each Taxi object:
	 * - City (String)
	 * - Type (String)
	 * - Number of available taxis (int)
	 * - Base fare (double)
	 * - Cost per unit (double)
	 * 
	 * The created Taxi objects are added to the taxiList.
	 */
	
	public static void CreateTaxiObjList(){
		
	try {
		
		File file = new File("C:\\Users\\fatma\\OneDrive\\Masaüstü\\FinalKU_Travel_Agency_Dataset_Taxis.csv");
		Scanner scanner = new Scanner(file);
		
		String headingsLine = scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			String[] line = scanner.nextLine().split(",");
			
			
			Taxi taxiObj = new Taxi(line[0],line[1],Integer.parseInt(line[2]),Double.parseDouble(line[3]),Double.parseDouble(line[4]));
			taxiList.add(taxiObj);
			
			}
		
	}catch(Exception e){
		System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * taxiDataCreator(String color) method filters the taxi list based on the provided color (type of taxi) 
	 * and creates a 2D array representing the data of taxis that match the given color.
	 * 
	 * The method iterates through the list of taxis and checks if the type of each taxi matches the provided color. 
	 * If it does, the taxi's details (city, type, available taxis, base fare, and cost) are stored in the array.
	 * 
	 * @param color : The type of taxi to filter (e.g., "Sedan", "SUV").
	 * @return a 2D array of strings containing data about the filtered taxis.
	 */
	
	public static String[][] taxiDataCreator(String color) {
		int LengthOfFilteredList = 0;
		for(Taxi currentTaxi:TaxiHandler.getTaxiList()) {
			if(currentTaxi.getType().equals(color)) {
				LengthOfFilteredList+= 1;}}
		
				
		String[][] taxiData = new String[LengthOfFilteredList][];
		int i = 0;
		
		for(Taxi taxi:TaxiHandler.getTaxiList()) {
			if(taxi.getType().equals(color)) {
			
			taxiData[i]= new String[] {taxi.getCity(),taxi.getType(),
					String.valueOf(taxi.getAvailableTaxiNum()),
					String.valueOf(taxi.getBaseFare()),
					String.valueOf(taxi.getCost())};
			i ++;}
			
			else {
			}
		}
		
			
		return taxiData;
	
	}
	
	
	/**
	 * taxiDataCreator() method creates a 2D array representing the data of all taxis in the taxi list.
	 * 
	 * The method iterates through the entire taxi list and stores each taxi's details (city, type, available taxis, 
	 * base fare, and cost) into the array.
	 * 
	 * @return a 2D array of strings containing data about all taxis in the list.
	 */
	
	public static String[][] taxiDataCreator() {
		
		String[][] taxiData = new String[taxiList.size()][];
		int i = 0;
		
		for(Taxi taxi:TaxiHandler.getTaxiList()) {
			
			
			taxiData[i]= new String[] {taxi.getCity(),taxi.getType(),
					String.valueOf(taxi.getAvailableTaxiNum()),
					String.valueOf(taxi.getBaseFare()),
					String.valueOf(taxi.getCost())};
			i += 1;
			
			
		}
		return taxiData;
	
	}

	
	
	
	
	
	
	public static LinkedList<Taxi> getTaxiList() {
		return taxiList;
	}


	public static void setTaxiList(LinkedList<Taxi> taxiList) {
		TaxiHandler.taxiList = taxiList;
	}
	
}
	
	
	
	

