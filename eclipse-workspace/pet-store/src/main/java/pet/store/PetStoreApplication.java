package pet.store; // Made outside pet.store.entity package to evade Component Scan conflict

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Allows Component Scan of annotations
public class PetStoreApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PetStoreApplication.class, args); // Bootstraps the app
	}
}