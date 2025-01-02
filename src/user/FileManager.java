package user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.DirectFlight;
import entity.Flight;
import entity.Hotel;
import entity.StopOverFlight;
import entity.Taxi;
import travelPackage.CustomerReservation;
import travelPackage.TravelPackage;


public abstract class FileManager {
	
	
	private static ArrayList<Customer> systemCustomerList = new ArrayList<>();
	
	private static String travelPackagesFilepath = "src/user/travelPackages.txt";
	private static String UsersFilePath = "src/user/customerReservations.txt";
	private static String customerReservationsFilePath = "src/user/customerReservations.txt";
	
	private static String[][] userNameArray ;


	



	private static File file = new File(UsersFilePath);
	
	
	/**
	 * addPackagetoFile(TravelPackage travelPackage) method get the given travel packages information and writes it into 
	 * the txt file specified by the static path.  
	 * @param travelPackage : TravelPackage object created by the customer on the TravelPackageCreatePage
	 */
	public static void addPackagetoFile(TravelPackage travelPackage) {
		
		try (FileWriter writer = new FileWriter(travelPackagesFilepath,true)){
		    	writer.write(travelPackage.getPackageName()+","+travelPackage.getStatus()+"\n");
		    		
		    }    
		catch (Exception e) {} 
		    }
	
	
	
	/**
	 * WriteToCustomerReservationsFile(Customer customer, CustomerReservation reservation) method writes the given 
	 * reservation object's flight, taxi, and hotel data into customerReservation.txt file. It also takes the customer
	 * object to label the data with its owner.
	 * 
	 * @param customer : Customer object representing the user who made the reservation.
	 * @param reservation : CustomerReservation object containing reservation details like flights, taxis, and hotels.
	 */
	public static void WriteToCustomerReservationsFile(Customer customer, CustomerReservation reservation) {
		
		try (FileWriter writer = new FileWriter(UsersFilePath,true)){
			writer.write("*\n"+"UserName: "+customer.getUserName()+"\nReservation Name: "+reservation.getReservationName()+
					 "\nStatus: "+reservation.getStatus() +"\n");
			
			
		
				int hotelNum = 0;
	    		   for(Hotel hotel:reservation.getReservationHotelList()){
	    			   writer.write("Hotel :"+ hotelNum+","+
	    					   hotel.getName()+","+
	    					   hotel.getCity()+","+
	    					   hotel.getRoomType()+","+
	    					   hotel.getAvailableRooms()+","+
	    					   hotel.getCost()+","+
	    					   hotel.getDistance()+"\n");
	    					   
	    			   hotelNum ++;
	    		   }
	    		   
	    		   int taxiNum = 0;
	    		   for(Taxi taxi:reservation.getReservationTaxiList()){
	    			   writer.write("Taxi :"+ taxiNum+","+
	    					   taxi.getCity()+","+
	    					   taxi.getType()+","+
	    					   taxi.getAvailableTaxiNum()+","+
	    					   taxi.getBaseFare()+","+
	    					   taxi.getCost()+"\n");
	    					   
	    			   taxiNum ++;
	    		   }
	    		   
	    		   
	    		   
	    		   int flightNum = 0;
	    		   for (Flight flight : reservation.getReservationFlightList()) {
	    	            writer.write("Flight :" + flightNum + ",");
	    	            
	    	            if (flight instanceof DirectFlight) {
	    	                DirectFlight directFlight = (DirectFlight) flight;
	    	                writer.write("Type: Direct," +
	    	                             directFlight.getAirline() + "," +
	    	                             directFlight.getDepartureCity() + "," +
	    	                             directFlight.getArrivalCity() + "," +
	    	                             directFlight.getDepartureTime() + "," +
	    	                             directFlight.getArrivalTime() + "," +
	    	                             directFlight.getClassType() + "," +
	    	                             directFlight.getCost() + "," +
	    	                             directFlight.getAvailableSeat()+"\n");
	    	                
	    	                
	    	            } else if (flight instanceof StopOverFlight) {
	    	                StopOverFlight stopOverFlight = (StopOverFlight) flight;
	    	                writer.write("Type: StopOver," +
	    	                             stopOverFlight.getAirline() + "," +
	    	                             stopOverFlight.getDepartureCity() + "," +
	    	                             stopOverFlight.getStopOverCity() + "," +
	    	                             stopOverFlight.getFinalArrivalCity() + "," +
	    	                             stopOverFlight.getLeg1DepTime() + "," +
	    	                             stopOverFlight.getLeg1ArriveTime() + "," +
	    	                             stopOverFlight.getLeg2DepTime() + "," +
	    	                             stopOverFlight.getLeg2ArriveTime() + "," +
	    	                             stopOverFlight.getClassType() + "," +
	    	                             stopOverFlight.getCost() + "," +
	    	                             stopOverFlight.getAvailableSeat()+"\n");
	    	            }
	    	            flightNum++;
	    	        }
	    	    } catch (Exception e) {
	    	        
	    	    }
	    	}
	
	/**
	 * customerListCreator() method reads customer data from the file specified by UsersFilePath 
	 * and populates the systemCustomerList with Customer objects.
	 * 
	 * This method splits each line of the file by commas and uses the resulting data to create 
	 * Customer objects which are then added to the list.
	 */
	public static void customerListCreator() {
		try (Scanner scanner = new Scanner(new File(UsersFilePath))){
			while(scanner.hasNextLine()) {
				String[] line = scanner.nextLine().split(",");
				Customer customer = new Customer(line[0],line[1]);
				systemCustomerList.add(customer);
			}
			
		}catch(Exception e){
			
		}
		
		
	}
	
	/**
	 * getPackages() method reads travel package data from the file specified by travelPackagesFilepath 
	 * and returns the data in a two-dimensional String array.
	 * 
	 * Each line of the file contains the name and status of a travel package, separated by a comma.
	 * 
	 * @return a 2D String array where each row represents a travel package, with columns for name and status.
	 */
	
	public static String[][] getPackages() {
	    try {
	        List<String> lines = Files.readAllLines(Paths.get(travelPackagesFilepath));
	        
	        String[][] PackagesList = new String[lines.size()][2];

	        for (int i = 0; i < lines.size(); i++) {
	            String[] parts = lines.get(i).split(",");
	            if (parts.length >= 2) { 
	                PackagesList[i][0] = parts[0]; 
	                PackagesList[i][1] = parts[1]; 
	            } else {
	                PackagesList[i][0] = ""; 
	                PackagesList[i][1] = "";
	            }
	        }

	        return PackagesList;
	    } catch (Exception e) {
	        return new String[0][0]; 
	    }
	}

	
	
	
	/**
	 * getUser() method populates the userNameArray with the names of all customers from the systemCustomerList.
	 * 
	 * It creates a 2D String array with one column and assigns each customer's name to a row in the array.
	 */
	
	public static void getUser() {
		userNameArray = new String[systemCustomerList.size()][1];
		
		for(int i = 0;i<systemCustomerList.size();i++) {
			userNameArray[i][0] = systemCustomerList.get(i).getName();
		}
	}
	
	
	
	
	
	
	
	

	public static ArrayList<Customer> getSystemCustomerList() {
		return systemCustomerList;
	}

	public static void setSystemCustomerList(ArrayList<Customer> systemCustomerList) {
		FileManager.systemCustomerList = systemCustomerList;
	}

	public static String getTravelPackagesFilepath() {
		return travelPackagesFilepath;
	}

	public static void setTravelPackagesFilepath(String travelPackagesFilepath) {
		FileManager.travelPackagesFilepath = travelPackagesFilepath;
	}

	public static String getUsersFilePath() {
		return UsersFilePath;
	}

	public static void setUsersFilePath(String usersFilePath) {
		UsersFilePath = usersFilePath;
	}
	public static String getCustomerReservationsFilePath() {
		return customerReservationsFilePath;
	}
	public static void setCustomerReservationsFilePath(String customerReservationsFilePath) {
		FileManager.customerReservationsFilePath = customerReservationsFilePath;
	}
	

	public static String[][] getUserNameArray() {
		return userNameArray;
	}
	public static void setUserNameArray(String[][] userNameArray) {
		FileManager.userNameArray = userNameArray;
	}

}
