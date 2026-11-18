package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String address, String name, String phone) {
        this.address = address;
        this.name = name;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void addVehicle(Vehicle vehicle) {

        inventory.add(vehicle);
    }
    public List<Vehicle> getAllVehicles() {
        return inventory;
    }
    public void removeVehicle(Vehicle vehicle) {
    }



}
