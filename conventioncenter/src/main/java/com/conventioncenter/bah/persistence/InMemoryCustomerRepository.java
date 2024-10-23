package com.conventioncenter.bah.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.conventioncenter.bah.domain.Customer;

public class InMemoryCustomerRepository {
	private List<Customer> accountData = new ArrayList<>(Arrays.asList(
			new Customer(1L, "Fox", "fox@bah.com", "pass"),
			new Customer(2L, "Lexi", "lexi@bah.com", "pass"),
			new Customer(3L, "Winston", "winston@bah.com", "pass")));

	
	public Customer findById(Long id) {
		Optional<Customer> accountOptional = accountData.stream().filter(account -> account.getId().equals(id))
				.findAny();
		return accountOptional.orElse(null); // Returns item if found, else returns null
	}
	
	public List<Customer> getAll(){
		return accountData;
	}

	/*
	public Collection<StockAccount> findAll() {
		return Collections.unmodifiableCollection(accountData);
	}

	public Collection<StockAccount> findByName(String name) {
		return accountData.stream().filter(account -> account.getName().toLowerCase().equals(name.toLowerCase()))
				.collect(Collectors.toList());
	}

	public long count() {
		return accountData.size();
	}

	public StockAccount save(StockAccount account) {
		throw new UnsupportedOperationException();
	}

	public void delete(StockAccount account) {
		throw new UnsupportedOperationException();
	}
	*/
}
