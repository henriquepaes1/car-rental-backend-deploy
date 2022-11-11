package com.api.rentalcar.controllers;

import com.api.rentalcar.models.Car;
import com.api.rentalcar.repositories.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/car-creation")
public class CarsCreationController {
	Car currentCar;
	int response;

    @PostMapping("/add-car")
    private ResponseEntity<String> addCar (@RequestParam String model, @RequestParam double rent, @RequestParam String make, 
    		@RequestParam String color, @RequestParam String type, @RequestParam String transmission,
    		@RequestParam String horsepower, @RequestParam double acceleration, @RequestParam int seats,
    		@RequestParam int trunk, @RequestParam double consumption) {
    	
    	currentCar = new Car(null, model, rent, make, color, type, transmission, horsepower, acceleration,
    			seats, trunk, consumption);
    	
    	response = CarRepository.create(currentCar);
    	
    	if(response == 0) {
    		return new ResponseEntity<String>("Carro inserido com sucesso", HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity<String>("Falha ao inserir carro", HttpStatus.BAD_GATEWAY);
    	}    
    }
}
