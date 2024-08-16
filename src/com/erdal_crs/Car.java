package com.erdal_crs;

public class Car {
	
	private String id;
	
	private String brand;
	
	private String model;
	
	private double pricePerDay;
	
	private int amountCarAvailibility;
	
	

	public Car() {
		
		
	}

	public Car(String id, String brand, String model, double pricePerDay, int amountCarAvailibility) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.pricePerDay = pricePerDay;
		this.amountCarAvailibility = amountCarAvailibility;
	}

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public double getPricePerDay() {
		return pricePerDay;
	}



	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}



	public int getAmountCarAvailibility() {
		return amountCarAvailibility;
	}



	public void setAmountCarAvailibility(int amountCarAvailibility) {
		this.amountCarAvailibility = amountCarAvailibility;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", model=" + model + ", pricePerDay=" + pricePerDay
				+ ", amountCarAvailibility=" + amountCarAvailibility + "]";
	}




	public double caculatePrice(int daysRent) {
		
		return pricePerDay*daysRent;
		
	}
	
	

}
