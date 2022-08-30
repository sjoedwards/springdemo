package com.sjoedwards.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{
	private String[] coursePrefixes;
	
	@Override
	public void initialize(CourseCode theCourseCodes) {
		coursePrefixes = theCourseCodes.value();
	}

	@Override
	// So here you can do whatever validation you like!
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		boolean result = false;
		if (theCode != null) {
			for (String tempPrefix: coursePrefixes ) {
				result = theCode.startsWith(tempPrefix);	
				
				if (result) {
					break;
				}
			}
		} else {	
			return true;
		}	
		return result;
	}
}
