package user;


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
	
	public Customer( String userName, String password, int ID, String name) {
		this.userName = userName;
		this.password = password;
		this.ID = ID;
		this.name = name;
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
