package entity;
import java.util.*;

import DataHandle.TaxiHandler;
public class Taxi extends BaseEntity {
	
	private String city;
	private String type;
	private int availableTaxiNum;
	private double baseFare;
	

	


	public Taxi(String city,String type,int availableTaxiNum, double baseFare,double cost) {
		super(cost);
		this.city = city;
		this.type = type;
		this.baseFare = baseFare;
		this.availableTaxiNum = availableTaxiNum;
	
	}

	
	
	
        
	
	
	
	
	
	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getAvailableTaxiNum() {
		return availableTaxiNum;
	}


	public void setAvailableTaxiNum(int availableTaxiNum) {
		this.availableTaxiNum = availableTaxiNum;
	}


	public double getBaseFare() {
		return baseFare;
	}


	public void setBaseFare(double baseFare) {
		this.baseFare = baseFare;
	}
}
