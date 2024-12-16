package pet.store; // Made outside pet.store.entity package to evade Component Scan conflict

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Allows Component Scan of annotations
public class PetStoreApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PetStoreApplication.class, args); // Bootstraps the app
	}
	
/* Pending DBeaver integration & connection after attempts to each preceding web & AI search of given errors.
 * 
 * Schema was made and Allow Public Key Retrieval was toggled on after error.
 * 
 * spring-boot-starter dependency was added to no resolution.
 * 
 * Log in checked to see if connection matched and dialect checked to see if matched Run error advice. */
	
	
}