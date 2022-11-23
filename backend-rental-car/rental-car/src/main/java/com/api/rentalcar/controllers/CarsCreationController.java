package com.api.rentalcar.controllers;

import com.api.rentalcar.models.Car;
import com.api.rentalcar.repositories.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value = "/car-creation")
public class CarsCreationController {
	Car currentCar;
	int response;

    @PostMapping("/add-car")
    private ResponseEntity<String> addCar (@RequestBody Car car) {
    	currentCar = car;
    	
    	response = CarRepository.create(currentCar);
    	
    	if(response == 0) {
    		return new ResponseEntity<String>("Carro inserido com sucesso", HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity<String>("Falha ao inserir carro", HttpStatus.BAD_GATEWAY);
    	}    
    }
}
