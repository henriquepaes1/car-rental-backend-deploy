package com.api.rentalcar;

import com.api.rentalcar.services.DatabaseConnectionCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RentalCarApplication {
	DatabaseConnectionCreator databaseConnectionCreator;

	public static void main(String[] args) {
		SpringApplication.run(RentalCarApplication.class, args);
		RentalCarApplication program = new RentalCarApplication();
		program.databaseConnectionCreator = new DatabaseConnectionCreator();
		program.databaseConnectionCreator.createConnection();
	}




}
