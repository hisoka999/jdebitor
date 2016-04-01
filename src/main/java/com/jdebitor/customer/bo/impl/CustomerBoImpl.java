package com.jdebitor.customer.bo.impl;

import java.util.List;

import com.jdebitor.customer.bo.CustomerBo;
import com.jdebitor.customer.dao.CustomerDao;
import com.jdebitor.customer.model.Customer;

public class CustomerBoImpl implements CustomerBo {

	CustomerDao customerDao;

	@Override
	public void save(Customer stock) {
		customerDao.save(stock);
	}

	@Override
	public void update(Customer stock) {
		// TODO Auto-generated method stub
		customerDao.update(stock);
	}

	@Override
	public void delete(Customer stock) {
		// TODO Auto-generated method stub
		customerDao.delete(stock);
	}

	@Override
	public Customer read(Long id) {
		// TODO Auto-generated method stub
		return customerDao.read(id);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

}
