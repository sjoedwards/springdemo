package com.sjoedwards.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sjoedwards.hibernate.demo.entity.Instructor;
import com.sjoedwards.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try { 
			
			// create the objects
			Instructor tempInstructor = new Instructor("Sam", "Edwards", "sam.edwards@test.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://test.com", "Running");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			// begin a transaction
			System.out.println("Beginning transaction");
			session.beginTransaction();
			
			// save the instructor - will ALSO save the details object because of the cascade type on Instructor
			System.out.println("Saving instructor" + tempInstructor);
			session.save(tempInstructor);
			
			// commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();			
		}
	}

}
