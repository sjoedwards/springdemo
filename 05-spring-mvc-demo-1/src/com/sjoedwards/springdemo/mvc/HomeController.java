package com.sjoedwards.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	// Map a request to this method
	@RequestMapping("/")
	public String showPage() {
		// Reads web.xml and injects this into '/WEB-INF/view/main-menu.jsp'
		return "main-menu";
	}

}
