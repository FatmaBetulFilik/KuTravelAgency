package user;
import travelPackage.*;

import java.util.*;
import java.io.*;
import java.nio.file.Files;

public class Administrator {
	
	private static String userName = "ffilik22";
	private static String password = "123654";
	
	private static String travelPackagepath = "src/user/travelPackages.txt";
	
	
	private static ArrayList<Customer> customersList = new ArrayList<>();
	private static String currentUser;
	private static Customer currentCustomer;
	
	
	private static LinkedList<CustomerReservation> customerReservationList = new LinkedList<>(); 


	
	private static LinkedList <TravelPackage> customerTravelPackage = new LinkedList<>();
	

	public void addCustomer(Customer customer) {
		customersList.add(customer);
		
	}
	
	public static void setCurrentCustomer(String currentUsername,String currentPassword) {
		try(Scanner scanner = new Scanner(Login.getFile())) {
	            	while(scanner.hasNextLine()) {
	            		String[] line = scanner.nextLine().split(" "); 
	            		currentCustomer = new Customer(line[0],line[1],Integer.parseInt(line[2]),line[3]);}
		}  
		catch (Exception e) {}
	}
			
	public static boolean cancelReservation(CustomerReservation reservation) {
	    if (reservation != null) {
	    	
	        reservation.setStatus("Cancelled");
	        
	        List<CustomerReservation> reservations = getCustomerReservationList();
	        reservations.remove(reservation);

	  

	        return true;
	    }
	    return false;
	}
	
	
	
	
	public static String[] getUsers() {
		try (Scanner scanner = new Scanner(new File(Login.getPath()))) {
			List<String> userList = new ArrayList<>();
	        
	        while (scanner.hasNextLine()) {
	            String[] line = scanner.nextLine().split(" "); // Split the line by spaces
	            if (line.length > 0) {
	                userList.add(line[0]);
	            }
	        }
	        
	        // Convert the list to an array and return it
	        return userList.toArray(new String[0]);
	    } catch (FileNotFoundException e) {
	        // Handle the case where the file is not found
	        e.printStackTrace();
	        return new String[0]; // Return an empty array in case of an error
	    }
	}
	
	
		
	public static void addPackagetoFile(TravelPackage travelPackage) {
		
		try (FileWriter writer = new FileWriter(travelPackagepath, true)){
		    	writer.write(travelPackage.getPackageName()+","+travelPackage.getOverallPackagePrice()+"\n");
		    		
		    		
		    		
		    }    
		catch (Exception e) {} 
		    }
			
	
	
	
	public static String[][] travelPackageLister() {
		
		try{
			Scanner scanner = new Scanner(new File(travelPackagepath));
			
			int lineNum = 0;
			while(new Scanner(new File(travelPackagepath)).hasNextLine()){
				lineNum += 1;
			}
			String[][] packagesArray = new String[lineNum][2];
			int index = 0;
			while(scanner.hasNextLine()) {
				String[] line = scanner.next().split(",");
				packagesArray[index] = line;
				TravelPackage tp = new TravelPackage(line[0],Integer.parseInt(line[1]));
				customerTravelPackage.add(tp);
				
			}
			return packagesArray;
		
		}catch(Exception e){
			return null;
		}
		
	}
	
	
			
			

	public static Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public static String getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(String currentUser) {
		Administrator.currentUser = currentUser;
	}

	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		Administrator.userName = userName;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Administrator.password = password;
	}
	public static ArrayList<Customer> getCustomersList() {
		return customersList;
	}
	public static void setCustomersList(ArrayList<Customer> customersList) {
		Administrator.customersList = customersList;
	}
	public static LinkedList<CustomerReservation> getCustomerReservationList() {
		return customerReservationList;
	}

	public static void setCustomerReservationList(LinkedList<CustomerReservation> customerReservationList) {
		Administrator.customerReservationList = customerReservationList;
	}
}
