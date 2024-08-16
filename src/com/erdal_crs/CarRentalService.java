package com.erdal_crs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CarRentalService {

	private List<Car> cars;

	private List<Customer> customers;

	private List<BookCarInformation> bookCarInformations;

	public CarRentalService() {
		cars = new ArrayList<>();
		customers = new ArrayList<>();
		bookCarInformations = new ArrayList<>();

	}

	public void bookedDays(Car car, Customer customer, int days) {

		if (car.getAmountCarAvailibility() > 0) {
			car.setAmountCarAvailibility(car.getAmountCarAvailibility() - 1);
			bookCarInformations.add(new BookCarInformation(car, customer, days));

		} else {
			System.err.println("Car is not avilable for renta");
		}

	}

	public void returnCar(Car car, BookCarInformation bookCarInformation) {

		car.setAmountCarAvailibility(car.getAmountCarAvailibility() + 1);
		bookCarInformations.remove(bookCarInformation);

	}

	public void addCar(Car car) {

		cars.add(car);

	}

	public void addCustomer(Customer customer) {

		customers.add(customer);

	}

	public void options() {

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("=========== WELCOME TO OUR RENTAL CAR SYSTEM ================");
			System.out.println();
			System.out.println("1. Rent a Car");
			System.out.println("2. Return a Car");
			System.out.println("3. Available Car");
			System.out.println("4. Exit");
			System.out.println();
			System.out.println(" Please pick your choice ");

			int choice = sc.nextInt();

			sc.nextLine();

			if (choice == 1) {
				System.out.println("Please provide your details belove to rent a car ");
				System.out.println();
				System.out.println("Please enter your Full Name");
				System.out.println();
				String customerName = sc.nextLine();

				System.out.println("Please enter the car id that you want to rent");
				System.out.println();
				cars.stream().filter(c -> c.getAmountCarAvailibility() > 0)
						.forEach(c -> System.out.println("\n" + "Car ID : " + c.getId() + "\n" + "Car Brand : "
								+ c.getBrand() + "\n" + "Car Model" + c.getModel() + "\n"
								+ "Amount of Car Availibility : " + c.getAmountCarAvailibility()));

				String carId = sc.nextLine();

				System.out.println("Please enter how many days you would like to rent the car");
				System.out.println();
				int daysRent = sc.nextInt();

				Customer customer = new Customer("CUSTOMER-" + (customers.size() + 1), customerName);

				addCustomer(customer);

				Optional<Car> carsOptional = cars.stream()
						.filter(c -> c.getId().equalsIgnoreCase(carId) && c.getAmountCarAvailibility() > 0).findAny();

				if (carsOptional.isEmpty()) {

					System.out.println("Car is not available, try to book another car");

					options();
					return;

				}
				Car selectedCar = carsOptional.get();
				System.out.println("===== Bill Resipet ====");
				System.out.println("CustomerId : " + customer.getId());
				System.out.println("CustomerName : " + customer.getFullName());
				System.out.println("Car Brand : " + selectedCar.getBrand());
				System.out.println("Model : " + selectedCar.getModel());
				System.out.println("Rental Days : " + daysRent);
				System.out.println("Total price : " + selectedCar.caculatePrice(daysRent));

				System.out.println("Please confirm rental (Y/N)");

				String confirmation = sc.next();

				if (confirmation.equalsIgnoreCase("Y")) {

					bookedDays(selectedCar, customer, daysRent);

					System.out.println("Car rental is success");

				} else {
					System.out.println("Car booking is canceled");

				}

			} else if (choice == 2) {
				System.out.println("===== Return a Car =====");
				System.out.println("Enter the car ID you want to return");

				String carId = sc.nextLine();
				Optional<Car> optionalCar = cars.stream().filter(c -> c.getId().equalsIgnoreCase(carId)).findAny();

				if (optionalCar.isEmpty()) {

					System.out.println("Please provide valid car details");

					options();
					return;

				}

				Car carToReturnCar = optionalCar.get();

				BookCarInformation bookCarInformation = bookCarInformations.stream()
						.filter(b -> b.getCar() == carToReturnCar).findFirst().orElse(null);

				if (bookCarInformation == null) {
					System.out.println("Car information not available, please provide valid detail");
					options();
					return;
				}
				Customer cust = bookCarInformation.getCustomer();

				returnCar(carToReturnCar, bookCarInformation);
				System.out.println("Car returned succesfully by " + cust.getFullName());

			} else if (choice == 3) {

				System.out.println("======= Available Cars ======");

				cars.stream().filter(c -> c.getAmountCarAvailibility() > 0).forEach(c -> System.out.println(
						c.getId() + "/n" + c.getBrand() + "/n" + c.getModel() + "/n" + c.getAmountCarAvailibility()));

			} else if (choice == 4) {

				System.out.println("Thank you for chosing us");
				break;

			} else {
				System.out.println("Please provide valid options");
			}
		}
	}

}
