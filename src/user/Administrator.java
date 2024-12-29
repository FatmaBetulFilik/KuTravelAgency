package user;

import java.util.*;
import java.io.*;

public class Administrator {
	
	private static String userName = "ffilik22";
	private static String password = "123654";
	
	
	private static ArrayList<Customer> customersList = new ArrayList<>();
	private static String currentUser;
	
	
	private static Customer currentCustomer;
	
	
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
	
}
