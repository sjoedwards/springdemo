package com.sjoedwards.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sjoedwards.springdemo.entity.Customer;

// Means spring can find the DAO when its doing component scanning
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory so the DAO can use it
	// this will look in the spring-mvc-crud-demo-servlet.xml for sessionFactory and
	// inject it for us
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	// @Transactional means that it will begin and commit the transaction for you
	// We've commented it out because this is now at the service layer!
	// @Transactional
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query - note lastName is the property not the column name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// get the list of customers from the query
		List<Customer> customers = theQuery.getResultList();

		// return the list of results
		return customers;

	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get the customer
		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete the customer
		Customer theCustomer = currentSession.load(Customer.class, theId);
		
		if (theCustomer != null) { 
			currentSession.delete(theCustomer);
		}
	}

}
