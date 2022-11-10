package com.api.rentalcar.services;

import com.api.rentalcar.models.Car;
import com.api.rentalcar.repositories.CarRepository;

import java.util.ArrayList;
import java.util.List;

public class Reader {
    CarRepository carRepository;

    public List<Car> listByType(String type) {
        List<Car> carsList = new ArrayList<>();
        carRepository = new CarRepository();
        carsList = carRepository.readAllBy("type", type);
        return carsList;
    }
}
