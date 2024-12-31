/************** Pledge of Honor ******************************************
 I hereby certify that I have completed this programming project on my own
 without any help from anyone else. The effort in the project thus belongs
 completely to me. I did not search for a solution, or I did not consult any
 program written by others or did not copy any program from other sources. I
 read and followed the guidelines provided in the project description.
 READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
 SIGNATURE: <Fatma Betül Filik, 83125>
 *************************************************************************/


package main;
import GUI.*;

import java.util.ArrayList;

import DataHandle.*;
import entity.*;
import user.*;


public class Main {

	public static void main(String[] args) {
		
		TaxiHandler.CreateTaxiObj();
		HotelHandler.createHotelObj();
		FlightHandler.createFlightObj();
		
		
		 LoginPage loginPage = new LoginPage();
	     loginPage.show();
	     
	     

	}

}
