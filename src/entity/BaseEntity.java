package entity;

public abstract class BaseEntity {
	
	private double cost;
	
	public BaseEntity(double cost) {
		this.cost = cost;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	
	
}
