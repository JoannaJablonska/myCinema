package pl.training.mycinema.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyCinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCinemaApplication.class, args);
	}

	//TODO GetSeats (for the selected screening) e.g. byId
	//TODO Business Rules
}
