package ro.mycode.carmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ro.mycode.carmanagement.view.View;

@SpringBootApplication
public class CarManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarManagementApplication.class, args);
	}



	@Bean
	CommandLineRunner commandLineRunner(View view) {
		return args -> {




			view.play();

		};

	}
}
