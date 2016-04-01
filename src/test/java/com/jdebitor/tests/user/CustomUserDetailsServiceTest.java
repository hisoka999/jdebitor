package com.jdebitor.tests.user;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import config.RootConfig;
import config.WebAppConfig;

@ContextConfiguration(classes = { RootConfig.class, WebAppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration

public class CustomUserDetailsServiceTest {

	@Autowired
	private UserDetailsService service;

	@Test
	public void testLoadUserByUsername() {
		UserDetails userDetails = service.loadUserByUsername("admin");
		assertEquals(userDetails.getUsername(), "admin");
		// TODO more tests
		userDetails = service.loadUserByUsername("admin2");
		assertEquals(userDetails, null);
	}
}
