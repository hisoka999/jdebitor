package com.jdebitor.users.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdebitor.users.dao.RoleDAO;
import com.jdebitor.users.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Role getRole(int id) {
		Role role = getCurrentSession().load(Role.class, id);
		return role;
	}

}