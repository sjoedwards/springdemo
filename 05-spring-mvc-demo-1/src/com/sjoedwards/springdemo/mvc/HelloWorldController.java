package com.sjoedwards.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	// need a controller method to show the initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// new controller method to read form data and add to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) { 
		
			// Read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
			// Convert to all caps
			theName = theName.toUpperCase();
		
			// Create the message
			String result = "Yo! " + theName;
		
			// Add message to the model
			model.addAttribute("message", result);
			return "helloworld";
	}
	

	@RequestMapping("/processFormVersionThree")
	// Dependency injecting in the request parameter
		public String processFormVersionThree(@RequestParam("studentName")String theName, Model model) { 
		
			// No longer need this as DI'd in the param
			// String theName = request.getParameter("studentName");
		
			// Convert to all caps
			theName = theName.toUpperCase();
		
			// Create the message
			String result = "V3: " + theName;
		
			// Add message to the model
			model.addAttribute("message", result);
			return "helloworld";
	}
}
