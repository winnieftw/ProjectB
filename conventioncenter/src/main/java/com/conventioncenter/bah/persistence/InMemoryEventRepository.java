package com.conventioncenter.bah.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.conventioncenter.bah.domain.Event;

public class InMemoryEventRepository {
	private List<Event> accountData = new ArrayList<>(Arrays.asList(
			new Event(1L, "CNF001", "All Java Conference", "Lectures and exhibits covering all Java topics"),
			new Event(2L, "WKS002", "Spring Boot Workshop", "Hands-on Spring Boot Workshop"),
			new Event(3L, "TRN003", "Angular Training Course", "Five day introductory training in Angular"),
			new Event(4L, "RNR004", "Rock n Roll Concert", "BAH Employees Social Concert")));

	
	public Event findById(Long id) {
		Optional<Event> accountOptional = accountData.stream().filter(account -> account.getId().equals(id))
				.findAny();
		return accountOptional.orElse(null); // Returns item if found, else returns null
	}
	
	public List<Event> getAll(){
		return accountData;
	}
}