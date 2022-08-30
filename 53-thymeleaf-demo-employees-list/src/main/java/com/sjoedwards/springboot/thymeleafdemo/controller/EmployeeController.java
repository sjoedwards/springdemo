package com.sjoedwards.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sjoedwards.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	// load employee data
	
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		// create employees
		Employee emp1 = new Employee(1, "one", "oneSur", "one@test.com");
		Employee emp2 = new Employee(2, "two", "twoSur", "two@test.com");
		Employee emp3 = new Employee(3, "three", "threeSur", "three@test.com");
		theEmployees = new ArrayList<>();
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		// add to spring model
		theModel.addAttribute("employees", theEmployees);
		return "list-employees";
	}

}
