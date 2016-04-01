package com.jdebitor.customer.service;

import java.util.List;

import com.jdebitor.customer.model.Customer;

public interface CustomerService {
	public Customer read(Long id);

	public List<Customer> findAll();

	public void save(Customer customer);
}
