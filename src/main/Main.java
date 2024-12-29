package main;
import GUI.*;

import java.util.ArrayList;

import DataHandle.*;
import entity.*;
import user.*;


public class Main {
	private String username;
	public static void main(String[] args) {
		
		TaxiHandler.CreateTaxiObj();
		HotelHandler.createHotelObj();
		FlightHandler.createFlightObj();
		
		
		 LoginPage loginPage = new LoginPage();
	     loginPage.show();
	     
	     

	}

}
