package pet.store.entity;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data; // Allows for @Data annotation working w/ dependency
import lombok.EqualsAndHashCode; // Allow for recursion prevention functions
import lombok.ToString;

@Entity // Highlighting the table to be persisted into a diagram
@Data 
public class PetStore {
	
	@Id // Highlighting the ID (primary key) used for the table
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-creates unique number for ID
	private Long petStoreId; // Used instead of Integer because it allows for more numbers
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private String petStoreZip;
	private String petStorePhone;

	@ManyToMany(cascade = CascadeType.PERSIST)
	
	// inverseJoinColumns used for Many Relationships to designate owned and vice versa
	@JoinTable(name = "pet_store_customer", 
		joinColumns = @JoinColumn(name = "pet_store_id"), 
		inverseJoinColumns = @JoinColumn(name = "customer_id"))
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Customer> customers = new HashSet<>();
	
	@OneToMany(mappedBy = "petStore", // Designating owning entity to be petStore
			cascade = CascadeType.ALL, 
			orphanRemoval = true)
	@EqualsAndHashCode.Exclude // Prevents recursion
	@ToString.Exclude
	private Set<Employee> employees = new HashSet<>();
}
