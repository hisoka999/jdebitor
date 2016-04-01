package com.jdebitor.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdebitor.customer.dao.CustomerDao;
import com.jdebitor.customer.model.Customer;
import com.jdebitor.customer.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDAO;

	@Override
	public Customer read(Long id) {
		return customerDAO.read(id);
	}

	@Override
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	@Override
	public void save(Customer customer) {
		customerDAO.save(customer);

	}
}