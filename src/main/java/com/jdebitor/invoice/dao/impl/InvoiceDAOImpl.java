package com.jdebitor.invoice.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jdebitor.customer.model.Customer;
import com.jdebitor.invoice.dao.InvoiceDAO;
import com.jdebitor.invoice.model.Invoice;

@Repository
public class InvoiceDAOImpl implements InvoiceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Invoice read(int id) {
		return openSession().get(Invoice.class, id);
	}

	@Override
	public List<Invoice> findByCustomer(Customer customer) {
		Criteria criteria = openSession().createCriteria(Invoice.class);
		criteria.add(Restrictions.eq("customer_id", customer.getId()));
		criteria.addOrder(Order.desc("dueDate"));
		return criteria.list();
	}

	@Override
	public void create(Invoice invoice) {
		openSession().save(invoice);
		// for
	}

	@Override
	public void delete(Invoice invoice) {
		openSession().delete(invoice);
	}

}
