package com.conventioncenter.bah.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.conventioncenter.bah.domain.Registration;
import com.conventioncenter.bah.persistence.InMemoryRegistrationRepository;

@RestController
public class RegistrationApi {

	
	@GetMapping("/registration/{id}")
	public Registration getCustomer(@PathVariable("id")Long id) {
		System.out.println("ID = " + id);
		InMemoryRegistrationRepository registration = new InMemoryRegistrationRepository();
		return registration.findById(id);
	}
	
	@GetMapping("/registration")
	public List<Registration> getAllRegistrations(){
		InMemoryRegistrationRepository registration = new InMemoryRegistrationRepository();
		return registration.getAll();
	}

}
