package com.conventioncenter.bah.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.conventioncenter.bah.domain.Customer;
import com.conventioncenter.bah.persistence.InMemoryCustomerRepository;

@RestController
public class CustomerApi {
	@GetMapping("/customers/id/{id}")
	public Customer getCustomer(@PathVariable("id")Long id) {
		InMemoryCustomerRepository customers = new InMemoryCustomerRepository();
		return customers.findById(id);
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		InMemoryCustomerRepository customers = new InMemoryCustomerRepository();
		return customers.getAll();
	}

}
