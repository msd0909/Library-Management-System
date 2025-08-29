package com.wipro.libsystem.controller;
import com.wipro.libsystem.entity.Address;
import com.wipro.libsystem.repository.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/addresses")
@CrossOrigin(origins = "http://localhost:4200") 
public class AddressController {
private final AddressRepository repo;
public AddressController(AddressRepository repo) {
	this.repo = repo; 
	}


@GetMapping public List<Address> all(){ 
	return repo.findAll(); 
	}
@GetMapping("/{id}") 
public Address one(@PathVariable Long id){ 
	return repo.findById(id).orElseThrow();
	}
@PostMapping @ResponseStatus(HttpStatus.CREATED)
public Address create(@RequestBody Address a){ 
	return repo.save(a); 
	}
@PutMapping("/{id}") 
public Address update(@PathVariable Long id, @RequestBody Address a){
Address addrss = repo.findById(id).orElseThrow();
addrss.setDoorNo(a.getDoorNo()); 
addrss.setStreet(a.getStreet()); 
addrss.setCity(a.getCity()); 
addrss.setState(a.getState()); 
addrss.setPincode(a.getPincode());
return repo.save(addrss);
}
@DeleteMapping("/{id}") 
public ResponseEntity<Void> delete(@PathVariable Long id){ 
	repo.deleteById(id); return ResponseEntity.noContent().build(); 
	}
}

