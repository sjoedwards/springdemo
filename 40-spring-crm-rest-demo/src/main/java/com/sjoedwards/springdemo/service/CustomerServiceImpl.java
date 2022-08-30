package com.sjoedwards.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjoedwards.springdemo.dao.CustomerDAO;
import com.sjoedwards.springdemo.entity.Customer;
import com.sjoedwards.springdemo.rest.CustomerNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		Customer customer = customerDAO.getCustomer(theId);
		if (customer == null) {
			throw new CustomerNotFoundException("customer not found");
		}
		customerDAO.deleteCustomer(theId);
	}
}





