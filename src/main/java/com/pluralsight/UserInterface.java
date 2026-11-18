package com.pluralsight;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    Scanner scanner = new Scanner(System.in);

    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);
        System.out.println("========== Menu ==========");
        System.out.println("Choose from the follow: ");
        System.out.println("1 - Get By Price");
        System.out.println("2 - Get By Make Model");
        System.out.println("3 - Get By Year");
        System.out.println("4 - Get By Color");
        System.out.println("5 - Get By Mileage");
        System.out.println("6 - Get By Vehicle Type");
        System.out.println("7 - Get By All Vehicle");
        System.out.println("8 - Add Vehicle");
        System.out.println("9 - Remove Vehicle");

        try {
            boolean displaying = true;

            while (displaying) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> processGetByPriceRequest();
                    case 2 -> processGetByMakeModelRequest();
                    case 3 -> processGetByYearRequest();
                    case 4 -> processGetByColorRequest();
                    case 5 -> processGetByMileageRequest();
                    case 6 -> processGetByVehicleTypeRequest();
                    case 7 -> processGetByAllVehicleRequest();
                    case 8 -> processAddVehicleRequest();
                    case 9 -> processRemoveVehicleRequest();
                    case 0 -> displaying = false;
                    default -> System.out.println("Invalid option. Try again");
                }


            }

        } catch (Exception e) {
            System.out.println("An error has occurred. Try again.");
        }
    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();

    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

    }

    private void processGetByPriceRequest() {

        System.out.println("Enter the price: ");

        List<Vehicle> vehicles = dealership.getAllVehicles();
        BigDecimal input = scanner.nextBigDecimal();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice().compareTo(input) == 0) {
                System.out.println(vehicle);
            } else {
                System.out.println("No Vehicles Found.");
            }
        }
    }

    private void processGetByMakeModelRequest() {

        System.out.println("Enter the make or model: ");

        List<Vehicle> vehicles = dealership.getAllVehicles();
        String input = scanner.nextLine();

        for (Vehicle vehicle : vehicles) {
            if (input.equalsIgnoreCase(vehicle.getMake()) || input.equalsIgnoreCase(vehicle.getModel())) {
                System.out.println(vehicle);
            }
        }

    }




    private void processGetByYearRequest() {
        System.out.println("Enter the year: ");

        List<Vehicle> vehicles = dealership.getAllVehicles();
        int input = scanner.nextInt();
        System.out.println("Vehicles: ");
        try {
        for (Vehicle vehicle : vehicles) {
            if (input == vehicle.getYear()) {
                System.out.println(vehicle);
            }

         }
        } catch (Exception e) {
            System.out.println("Invalid Input.");
        }
    }

    private void processGetByColorRequest(){
        System.out.println("Enter the color: ");
        List<Vehicle> vehicles = dealership.getAllVehicles();
        String input = scanner.nextLine().trim();
        System.out.println("Vehicles: ");
        for (Vehicle vehicle : vehicles) {
            if (input.equalsIgnoreCase(vehicle.getColor())){
                System.out.println(vehicle);

            }
        }
    }
    private void processGetByMileageRequest(){
        System.out.println("Enter the mileage: ");

        List<Vehicle> vehicles = dealership.getAllVehicles();
        int input = scanner.nextInt();
        System.out.println("Vehicles: ");

        for (Vehicle vehicle : vehicles) {
            if (input == vehicle.getOdometer()) {
                System.out.println(vehicle);
            }
        }
    }

    private void processGetByVehicleTypeRequest(){
        System.out.println("Enter Vehicle Type: ");

        List<Vehicle> vehicles = dealership.getAllVehicles();
        System.out.println("Vehicles: ");
       try {
           String input = scanner.nextLine().trim();

           for (Vehicle vehicle : vehicles) {
               if (input.equalsIgnoreCase(vehicle.getVehicleType())) {
                   System.out.println(vehicle);
               }

           }
       } catch (Exception e) {
           System.out.println("Invalid input");
       }
    }

    private void processGetByAllVehicleRequest(){
        displayVehicles(dealership.getAllVehicles());
    }
    private void processAddVehicleRequest(){}
    private void processRemoveVehicleRequest(){}}
