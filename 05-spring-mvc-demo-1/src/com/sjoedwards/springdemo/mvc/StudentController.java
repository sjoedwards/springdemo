package com.sjoedwards.springdemo.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	// Reading the spring-mvc-demo-servlet.xml file, id of the file is specified there
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a new student object
		Student theStudent = new Student();
		
		// add the student object as a model attribute
		theModel.addAttribute("student", theStudent);
		
	    theModel.addAttribute("theCountryOptions", countryOptions); 

		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {	
	
		// add the student object as a model attribute - must match the form!
		System.out.println("theStudent: " + theStudent.getFirstName() + theStudent.getLastName());
		return "student-confirmation";
	}
}
