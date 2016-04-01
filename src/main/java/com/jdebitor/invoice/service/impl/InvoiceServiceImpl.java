package com.jdebitor.invoice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdebitor.customer.model.Customer;
import com.jdebitor.invoice.dao.InvoiceDAO;
import com.jdebitor.invoice.model.Invoice;
import com.jdebitor.invoice.service.InvoiceService;

@Repository
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceDAO dao;

	@Override
	public Invoice read(int id) {
		return dao.read(id);
	}

	@Override
	public List<Invoice> findByCustomer(Customer customer) {
		return dao.findByCustomer(customer);
	}

	@Override
	public void create(Invoice invoice) {
		dao.create(invoice);
	}

	@Override
	public void delete(Invoice invoice) {
		dao.delete(invoice);
	}

}
