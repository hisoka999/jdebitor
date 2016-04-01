package com.jdebitor.tests.customer;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jdebitor.customer.model.Customer;
import com.jdebitor.customer.service.CustomerService;

import config.RootConfig;
import config.WebAppConfig;

@ContextConfiguration(classes = { RootConfig.class, WebAppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
public class CustomerServiceTest {

	@Autowired
	private CustomerService service;

	@Test
	public void testRead() {
		Customer cst = service.read(1L);
		assertEquals(cst.getFirstName(), "Stefan");

		// customer does not exists
		// cst = service.read(99L);
		// assertNull("customer does not exists", cst);
	}

	@Test
	public void testFindAll() {
		List<Customer> list = service.findAll();
		assertEquals(list.size(), 2);
	}

	@Test
	@Rollback
	public void testSave() {
		Customer cst = service.read(1L);
		Date testDate = new Date(2000, 10, 10);
		cst.setBirthDate(testDate);
		assertEquals(testDate, cst.getBirthDate());
		service.save(cst);
		Customer cst2 = service.read(1L);
		assertEquals(testDate, cst2.getBirthDate());

	}

}
