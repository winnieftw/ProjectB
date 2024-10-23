package com.conventioncenter.bah.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.conventioncenter.bah.domain.Customer;
import com.conventioncenter.bah.persistence.InMemoryCustomerRepository;

@RestController
public class CustomerApi {
	
	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable("id")Long id) {
		System.out.println("ID = " + id);
		InMemoryCustomerRepository customers = new InMemoryCustomerRepository();
		return customers.findById(id);
	}

}
