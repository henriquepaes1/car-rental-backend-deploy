package com.api.rentalcar.controllers;

import com.api.rentalcar.models.Car;

import com.api.rentalcar.services.Reader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/car-creation")
public class CarsCreationController {
//    Reader reader;

    @PostMapping("/add-car")
    private void addCar (@RequestParam String a, @RequestParam String b) {
        
    }
}
