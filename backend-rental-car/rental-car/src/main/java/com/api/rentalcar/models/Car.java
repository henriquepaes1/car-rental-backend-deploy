package com.api.rentalcar.models;

public class Car {
    public String carID;
    public String model;
    public Double rent;
    public String make;
    public String color;
    public String type;
    public String transmission;
    public String horsepower;
    public Double acceleration;
    public Integer seats;
    public Integer trunk;
    public Double consumption;
    public String imagepath;

    public Car (String carID, String model, Double rent, String make, String color, String type, String transmission,
                String horsepower, Double acceleration, Integer seats, Integer trunk, Double consumption, String imagepath) {
        this.carID = carID;
        this.model = model;
        this.rent = rent;
        this.make = make;
        this.color = color;
        this.type = type;
        this.transmission = transmission;
        this.horsepower = horsepower;
        this.acceleration = acceleration;
        this.seats = seats;
        this.trunk = trunk;
        this.consumption = consumption;
        this.imagepath = imagepath;
    }

	public Car() {
		// default constructor for mapper
	}
}
