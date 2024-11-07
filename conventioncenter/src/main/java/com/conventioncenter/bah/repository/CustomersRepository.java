package com.conventioncenter.bah.repository;

import org.springframework.data.repository.CrudRepository;

import com.conventioncenter.bah.domain.Customer;

public interface CustomersRepository extends CrudRepository<Customer, Long> {

}
