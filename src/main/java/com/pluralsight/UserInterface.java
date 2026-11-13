package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

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

            while (displaying){
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 ->  processGetByPriceRequest();
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
            throw new RuntimeException(e);
        }
    }
    private void init(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();

    }
    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }

    }
    private void processGetByPriceRequest() {}
    private void processGetByMakeModelRequest(){}
    private void processGetByYearRequest(){}
    private void processGetByColorRequest(){}
    private void processGetByMileageRequest(){}
    private void processGetByVehicleTypeRequest(){}
    private void processGetByAllVehicleRequest(){
        displayVehicles(dealership.getAllVehicles());
    }
    private void processAddVehicleRequest(){}
    private void processRemoveVehicleRequest(){}}
