package com.sjoedwards.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sjoedwards.springdemo.mvc.validation.CourseCode;

public class Customer {
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	
	private String lastName;
	
	// Need to use the wrapper class 	
	@NotNull(message="is required")
	@Min(value=0, message="must be greater to or equal to zero")
	@Max(value=10, message="must be less than or equal to 10")
	private Integer freePasses;
	
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="Only 5 numbers or letters allowed")
	private String postalCode;
	
	
	public String getPostalCode() {
		return postalCode;
	}
	
	// Defined in com.sjoedwards.springdemo.mvc.validation
	@CourseCode(value={"TOPS", "LUV"}, message="must start with TOPS or LUV")
	private String courseCode;
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
