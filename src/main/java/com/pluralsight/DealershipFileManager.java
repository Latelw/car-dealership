package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;

public class DealershipFileManager {

    public static final String CAR_FILE = "inventory.csv";

    public Dealership getDealership() {

        try {

            BufferedReader reader = new BufferedReader(new FileReader(CAR_FILE));
            String line;
            //Keeps dealer info separate from car info
            String header = reader.readLine();
            String[] dealerInfo = header.split("\\|");
            String dealerName = dealerInfo[0];
            String dealerAddress = dealerInfo[1];
            String dealerNumber = dealerInfo[2];

            Dealership dealership = new Dealership(dealerName,dealerAddress,dealerNumber);


            while ((line = reader.readLine()) != null) {
                Vehicle vehicle = getVehicle(line);

                dealership.addVehicle(vehicle);




            }
            reader.close();
            return dealership;

        } catch (Exception e) {
            System.out.println("File error. Please check file and try again.");
            return null;
        }


    }

    private static Vehicle getVehicle(String line) {
        String[] inventory = line.split("\\|");
        int vin = Integer.parseInt(inventory[0]);
        int year = Integer.parseInt(inventory[1]);
        String make = inventory[2];
        String model = inventory[3];
        String carType = inventory[4];
        String color = inventory[5];
        int odometer = Integer.parseInt(inventory[6]);
        BigDecimal price = new BigDecimal(inventory[7]);

        Vehicle vehicle = new Vehicle(vin,year,make,model,carType,color,odometer,price);
        return vehicle;
    }

    public void saveDealership() {}
}
