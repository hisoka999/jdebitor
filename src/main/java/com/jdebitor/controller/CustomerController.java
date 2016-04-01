package com.jdebitor.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jdebitor.customer.forms.CustomerForm;
import com.jdebitor.customer.model.Customer;
import com.jdebitor.customer.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView login() {

		ModelAndView model = new ModelAndView();
		List<Customer> customers = customerService.findAll();
		model.addObject("customers", customers);
		model.addObject("contentPage", "content/customer_list.jsp");
		model.addObject("customerForm", new CustomerForm());
		model.setViewName("base");

		return model;

	}

	@RequestMapping(value = "/json/all", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Customer> listAll() {
		List<Customer> customers = customerService.findAll();
		logger.debug("customers = <{0}>", customers.size());
		return customers;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(@Valid CustomerForm customerForm, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		if (bindingResult.hasErrors()) {

		} else {
			Customer newCustomer = new Customer();

			newCustomer.setFirstName(customerForm.getFirstName());
			newCustomer.setLastName(customerForm.getLastName());
			newCustomer.setBirthDate(customerForm.getBirthDate());
			customerService.save(newCustomer);
		}
		model.addObject("customerForm", customerForm);

		model.addObject("contentPage", "content/customer_list.jsp");
		model.setViewName("base");

		return model;
	}
}
