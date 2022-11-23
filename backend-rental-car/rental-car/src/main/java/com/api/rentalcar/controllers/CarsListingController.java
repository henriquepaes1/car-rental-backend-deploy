package com.api.rentalcar.controllers;

import com.api.rentalcar.models.Car;

import com.api.rentalcar.services.Reader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/car-listing")
public class CarsListingController {
    Reader reader;
    
    @CrossOrigin
    @GetMapping("/by-type")
    private ResponseEntity<List<Car>> listCarsByType (@RequestParam String type) {
        List<Car> carsList = new ArrayList<>();
        reader = new Reader();
        carsList = reader.listByType(type);
        return new ResponseEntity<List<Car>>(carsList, HttpStatus.OK);
    }
}
