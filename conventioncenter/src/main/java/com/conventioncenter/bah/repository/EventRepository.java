package com.conventioncenter.bah.repository;

import org.springframework.data.repository.CrudRepository;

import com.conventioncenter.bah.domain.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
