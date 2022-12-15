package com.api.rentalcar.controllers;

import com.api.rentalcar.models.Car;
import com.api.rentalcar.repositories.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/car-creation")
public class CarsCreationController {
	Car currentCar;

    @PostMapping("/add-car")
    private ResponseEntity<String> addCar (@RequestBody Car car) {
    	currentCar = car;
    	
    	int response = CarRepository.create(currentCar);
    	
    	if(response == 0) {
    		return new ResponseEntity<String>("{\"message\": \"Carro inserido com sucesso\"}", HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity<String>("Falha ao inserir carro", HttpStatus.BAD_GATEWAY);
    	}    
    }
}
