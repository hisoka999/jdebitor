package com.jdebitor.users.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdebitor.users.dao.RoleDAO;
import com.jdebitor.users.model.Role;
import com.jdebitor.users.services.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDAO;

	@Override
	public Role getRole(int id) {
		return roleDAO.getRole(id);
	}

}