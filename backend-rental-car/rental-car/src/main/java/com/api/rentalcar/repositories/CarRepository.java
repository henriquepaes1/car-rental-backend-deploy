package com.api.rentalcar.repositories;

import com.api.rentalcar.models.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;


public class CarRepository extends Repository {
    String query;

    public List<Car> readAllBy(String field, String value) {
        List<Car> carsList = new ArrayList<>();
        query = "SELECT * FROM car WHERE " + field + " = " + "'" + value + "'";
        PreparedStatement ps = null;

        try {
            ps = CarRepository.databaseConn.prepareStatement(query);
            System.out.println("Successfully ");
        } catch (SQLException e) {
            System.out.println("Could not generate query" + e);
        }

        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                String carID = rs.getString("carID");
                String model = rs.getString("model");
                Double rent = rs.getDouble("rent");
                String make = rs.getString("make");
                String color = rs.getString("color");
                String type = rs.getString("type");
                String transmission = rs.getString("transmission");
                String horsepower = rs.getString("horsepower");
                Double acceleration = rs.getDouble("acceleration");
                Integer seats = rs.getInt("seats");
                Integer trunk = rs.getInt("trunk");
                Double consumption = rs.getDouble("consumption");

                Car car = new Car (carID, model, rent, make, color, type, transmission, horsepower, acceleration, seats, trunk, consumption);
                System.out.println(carID + model + make + color + type + transmission + horsepower);
                carsList.add(car);
            }
        } catch (SQLException e) {
            System.out.println("Could not execute query" + e);
        }

        return carsList;
    }
    
    public static int create(Car car) {
    	PreparedStatement ps = null;
    	String sql = "INSERT INTO car (model, rent, make, color, type, transmission, "
    			+ "horsepower, acceleration, seats, trunk, consumption) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	try {
			ps = CarRepository.databaseConn.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("Could not generate query" + e);
			return 1;
		}
    	
    	try {
			ps.setString(1, car.model);
			ps.setDouble(2, car.rent);
			ps.setString(3, car.make);
			ps.setString(4, car.color);
			ps.setString(5, car.type);
			ps.setString(6, car.transmission);
			ps.setString(7, car.horsepower);
			ps.setDouble(8, car.acceleration);
			ps.setInt(9, car.seats);
			ps.setInt(10, car.trunk);
			ps.setDouble(11, car.consumption);
		} catch (SQLException e) {
			System.out.println("Could not execute query" + e);
			return 1;
		}
    	
    	try {
			ps.execute();
			return 0;
		} catch (SQLException e) {
			System.out.println("Could not execute query" + e);
			return 1;
		}
    }
}
