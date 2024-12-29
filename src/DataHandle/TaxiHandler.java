package DataHandle;

import java.util.*;
import java.io.*;
import entity.*;
import entity.*
;
public class TaxiHandler{
	
	private static LinkedList<Taxi> taxiList = new LinkedList<>();
	



	public static void CreateTaxiObj(){
		
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
	
	
	
	
	
	
	
	
	
	
	public static LinkedList<Taxi> getTaxiList() {
		return taxiList;
	}


	public static void setTaxiList(LinkedList<Taxi> taxiList) {
		TaxiHandler.taxiList = taxiList;
	}
	
}
	
	
	
	

