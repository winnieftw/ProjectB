package com.conventioncenter.bah.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.conventioncenter.bah.domain.Event;
import com.conventioncenter.bah.persistence.InMemoryEventRepository;

@RestController
public class EventAPI {
	
	
	@GetMapping("/events/id/{id}")
	public Event getEvent(@PathVariable("id")Long id) {
		InMemoryEventRepository events = new InMemoryEventRepository();
		return events.findById(id);
	}
	
	@GetMapping("/events")
	public List<Event> getAllEvents(){
		InMemoryEventRepository events = new InMemoryEventRepository();
		return events.getAll();
	}

}