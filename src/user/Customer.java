package user;

import java.io.FileWriter;
import java.util.ArrayList;

import travelPackage.CustomerReservation;

public class Customer {
	
	private int ID;
	private String name;
	private String userName;
	private String password;
	
	private int numOfTotalRes;
	private double amountSpent;
	private int successfulRes;
	private int cancelledRes;
	private double aveSpentPerRes;
	private double resSuccessRate;
	private double cancelRate;
	
	private static CustomerReservation reservations;
	private static ArrayList<CustomerReservation> resList = new ArrayList<>();
	
	
	/**
	 * this is the constructor method of the Customer class it initilizes the values of the attributes of the class with given parameters inside
	 * @param userName : this is the username of the customer object usually taken from the textFields on the GUI
	 * @param password : this is the password of the customer object usually taken from the textFields on the GUI
	 */
	public Customer( String userName, String password) {
		this.userName = userName;
		this.password = password;
	
	}
	
	
	
	

	public static ArrayList<CustomerReservation> getResList() {
		return resList;
	}

	public static void setResList(ArrayList<CustomerReservation> resList) {
		Customer.resList = resList;
	}

	public static CustomerReservation getReservations() {
		return reservations;
	}

	public static void setReservations(CustomerReservation reservations) {
		Customer.reservations = reservations;
	}


	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	

}
