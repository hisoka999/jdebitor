package com.jdebitor.customer.dao;

import java.util.List;

import com.jdebitor.customer.model.Customer;

public interface CustomerDao {
	void save(Customer stock);

	void update(Customer stock);

	void delete(Customer stock);

	Customer read(Long id);

	List<Customer> findAll();
}
