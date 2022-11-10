package com.api.rentalcar;

import com.api.rentalcar.services.DatabaseConnectionCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RentalCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalCarApplication.class, args);
		DatabaseConnectionCreator.createConnection();
	}

}
