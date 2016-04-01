package com.jdebitor.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jdebitor.customer.model.Customer;
import com.jdebitor.invoice.foms.InvoiceForm;
import com.jdebitor.invoice.model.Invoice;
import com.jdebitor.invoice.service.InvoiceService;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/json/findByCustomer/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Invoice> listAll(@RequestParam("id") Long id) {
		Customer customer = new Customer();
		customer.setId(id);
		List<Invoice> invoices = invoiceService.findByCustomer(customer);
		logger.debug("invoices = <{0}>", invoices.size());
		return invoices;
	}

	@RequestMapping(value = "/add")
	public ModelAndView add(@Valid InvoiceForm invoiceForm, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		if (bindingResult.hasErrors()) {

		} else {

		}
		model.addObject("invoiceForm", invoiceForm);

		model.addObject("contentPage", "content/invoice_add.jsp");
		model.setViewName("base");

		return model;
	}

}
