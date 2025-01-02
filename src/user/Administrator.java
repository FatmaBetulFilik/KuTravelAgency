package user;
import travelPackage.*;

import java.util.*;
import java.io.*;
import java.nio.file.Files;

public class Administrator {
	
	private static String userName = "ffilik22";
	private static String password = "Fatma123";
	//CurrentUserName and Current Customer hold the reference of the user that has registred in the system
	private static String currentUsersName; 
	public static Customer currentCustomer;
	
	private static LinkedList<CustomerReservation> customerReservationList = new LinkedList<>(); 

	

	
	
	
	public static Customer getCurrentCustomer() {
		return currentCustomer;
	}
	public static String getCurrentUsersName() {
		return currentUsersName;
	}
	public static void setCurrentUsersName(String currentUsersName) {
		Administrator.currentUsersName = currentUsersName;
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

	
}
