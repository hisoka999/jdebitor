package com.jdebitor.users.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdebitor.users.dao.UserDAO;
import com.jdebitor.users.model.User;
import com.jdebitor.users.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public User getUser(String login) {
		return userDAO.getUser(login);
	}

}