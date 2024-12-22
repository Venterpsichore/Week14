package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.service.PetStoreService;

@RestController // Expects JSONs
@RequestMapping("/pet_store") // Requires that HTTP URI of each map request begin with /pet_store
@Slf4j // Logger
public class PetStoreController {
	
	@Autowired
	private PetStoreService petStoreService; // Injects petStoreService instance variable
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED) // Maps HTTP POST request
	public PetStoreData insertPetStore(@RequestBody PetStoreData petStoreData) {
		log.info("Creating pet store {}", petStoreData); // Logs request as new pet store
		return petStoreService.savePetStore(petStoreData); // Updates petStoreData
	}
	
	@PutMapping ("/{petStoreId}") // Handles/calls method through HTTP PUT requests from endpoint /{petStoreId}
	public PetStoreData updatePetStore (@PathVariable Long petStoreId,
			@RequestBody PetStoreData petStoreData) { // @RequestBody to designate return type of HTTP request
		petStoreData.setPetStoreId(petStoreId);
		log.info("Updating pet store {}", petStoreData);
		return petStoreService.savePetStore(petStoreData); // Saves and returns to service layer
		
	}
}
