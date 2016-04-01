package com.jdebitor.customer.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdebitor.customer.dao.CustomerDao;
import com.jdebitor.customer.model.Customer;;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Customer stock) {
		getCurrentSession().save(stock);

	}

	@Override
	public void update(Customer stock) {
		getCurrentSession().update(stock);

	}

	@Override
	public void delete(Customer stock) {
		getCurrentSession().delete(stock);

	}

	@Override
	public Customer read(Long id) {
		Customer ret = getCurrentSession().load(Customer.class, id);
		return ret;
	}

	@Override
	public List<Customer> findAll() {
		Criteria criteria = getCurrentSession().createCriteria(Customer.class);

		return criteria.list();
	}

}
