package com.erdal_crs;



public class CRSEntry {
	public static void main(String[] args) {
		
		Car toyota = new Car();
		
		toyota.setId("Car-1");
		toyota.setBrand("Toyota");
		toyota.setModel("2018");
		toyota.setPricePerDay(300);
		toyota.setAmountCarAvailibility(1);
		
		Car mercedes = new Car();
		
		mercedes.setId("car-2");
		mercedes.setBrand("Mercedes");
		mercedes.setModel("2020");
		mercedes.setPricePerDay(600);
		mercedes.setAmountCarAvailibility(2);
		
		Car bmw = new Car();
		
		bmw.setId("Car-3");
		bmw.setBrand("BMW");
		bmw.setModel("2023");
		bmw.setPricePerDay(650);
		bmw.setAmountCarAvailibility(2);
		
		CarRentalService cRService =new CarRentalService();
		cRService.addCar(bmw);
		cRService.addCar(mercedes);
		cRService.addCar(toyota);
		cRService.options();
	
	}

}
