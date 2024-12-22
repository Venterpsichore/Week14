package pet.store.dao; // Data Layer Interface that creates SQL statements for CRUD operations

import org.springframework.data.jpa.repository.JpaRepository; // Allows for basic CRUD, pagination, and sorting

public interface PetStoreDao extends JpaRepository <PetStore, Long> { // Long is the ID type manipulated

}
