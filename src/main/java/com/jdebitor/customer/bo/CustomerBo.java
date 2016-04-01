package com.jdebitor.customer.bo;

import java.util.List;

import com.jdebitor.customer.model.Customer;

public interface CustomerBo {

	void save(Customer stock);

	void update(Customer stock);

	void delete(Customer stock);

	Customer read(Long id);

	List<Customer> findAll();
}
