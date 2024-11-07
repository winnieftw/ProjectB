package com.conventioncenter.bah.api;

import java.util.Optional;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.conventioncenter.bah.domain.Customer;
import com.conventioncenter.bah.repository.CustomersRepository;

@RestController
@RequestMapping("/customers")
public class CustomerAPI {
	@Autowired
	CustomersRepository repo;

	@GetMapping
	public Iterable<Customer> getAll() {
		return repo.findAll();   
	}

	@GetMapping("/{customerId}")
	public Optional<Customer> getCustomerById(@PathVariable("customerId") long id) {
		return repo.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer, UriComponentsBuilder uri) {
		if (newCustomer.getId()!=0
			|| newCustomer.getName()==null
			|| newCustomer.getEmail() == null
			|| newCustomer.getPassword() == null) { // Reject - we'll assign the customer id
			    return ResponseEntity.badRequest().build();
		}
	  newCustomer=repo.save(newCustomer);
	  URI location=ServletUriComponentsBuilder.fromCurrentRequest()
	    .path("/{id}").buildAndExpand(newCustomer.getId()).toUri();
	  ResponseEntity<?> response=ResponseEntity.created(location).build();
	  return response;
	}

	/*
	//lookupCustomerByName GET
	@GetMapping("/byname/{username}")
	public ResponseEntity<?> lookupCustomerByNameGet(@PathVariable("username") String username,
			UriComponentsBuilder uri) {
		//  Workshop:  Write an implemenatation to look up a customer by name.  Think about what
		//  your response should be if no customer matches the name the caller is searching for.
		//  With the data model implemented in CustomersRepository, do you need to handle more than
		//  one match per request?
		Iterable<Customer> customers = repo.findAll();
		for(Customer customer: customers) {
			if(customer.getName().equals(username)) {
				URI location=ServletUriComponentsBuilder.fromCurrentRequest()
					    .path("/{username}").buildAndExpand(customer.getName()).toUri();
				ResponseEntity<?> response=ResponseEntity.created(location).build();
				return response;
			}
		}
		return null;
	}
	
	//lookupCustomerByName POST
	@PostMapping("/byname")
	public ResponseEntity<?> lookupCustomerByNamePost(@RequestBody String username, UriComponentsBuilder uri) {
		//  Workshop:  Write an implementation to look up a customer by name, using POST semantics
		//  rather than GET.  You should be able to make use of most of your implmentation for
		//  lookupCustomerByNameGet().  
		return null;
	}	
	*/
	
	@PutMapping("/{customerId}")
	public ResponseEntity<?> putCustomer(
			@RequestBody Customer newCustomer,
			@PathVariable("customerId") long customerId) 
	{
		//  Workshop:  Write an implementation to update or create a new customer with an HTTP PUT, with the 
		//  requestor specifying the customer ID.  Are there error conditions to be handled?  How much data
		//  validation should you implement considering that customers are stored in a CustomersRepository object.
		if(newCustomer.getId() != customerId ||
				newCustomer.getName() == null ||
				newCustomer.getEmail() == null ||
				newCustomer.getPassword() == null) {
			return ResponseEntity.badRequest().build();
		}
		newCustomer=repo.save(newCustomer);
		return ResponseEntity.ok().build();
	}	
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("customerId") long id) {
		//  Implement a method to delete a customer.  What is an appropriate response? 
		//
		//  For discussion (do not worry about implementation):  What are some ways of handling 
		//  a "delete"?  Is it always the right thing from a business point of view to literally 
		//  delete a customer entry?  If you did actually delete a customer entry, are there issues
		//  you could potentially run into later? 
//		if (repo.findById(id).isPresent()) { // Reject - we'll assign the customer id
//				    return ResponseEntity.badRequest().build();
//			}
		repo.deleteById(id);
		return ResponseEntity.noContent().build();
				
	}	
	
	
}
