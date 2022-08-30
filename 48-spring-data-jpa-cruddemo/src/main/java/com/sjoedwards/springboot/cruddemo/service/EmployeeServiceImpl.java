package com.sjoedwards.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjoedwards.springboot.cruddemo.dao.EmployeeRepository;
import com.sjoedwards.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	// Dont need transactional! Its included by default in the JPARepository
//	@Transactional
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

//	@Transactional
	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new RuntimeException("Employee not found");
		}
	}

//	@Transactional
	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
//	@Transactional
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
