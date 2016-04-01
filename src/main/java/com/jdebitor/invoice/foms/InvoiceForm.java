package com.jdebitor.invoice.foms;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.format.annotation.DateTimeFormat;

import com.jdebitor.customer.model.Customer;
import com.jdebitor.invoice.model.InvoiceItem;

public class InvoiceForm {

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public InvoiceForm() {
		// TODO Auto-generated constructor stub
	}

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dueDate;

	@NotNull
	private Customer customer;

	@Valid
	private List<InvoiceItem> invoiceItems;

	@Null
	private String invoiceNumber;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
