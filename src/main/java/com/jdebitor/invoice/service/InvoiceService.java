package com.jdebitor.invoice.service;

import java.util.List;

import com.jdebitor.customer.model.Customer;
import com.jdebitor.invoice.model.Invoice;

public interface InvoiceService {
	public Invoice read(int id);

	public List<Invoice> findByCustomer(Customer customer);

	public void create(Invoice invoice);

	public void delete(Invoice invoice);
}
