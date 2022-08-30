package com.sjoedwards.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sjoedwards.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try { 
			
			// create three student objects
			
			System.out.println("Creating new student objects");
			Student tempStudent1 = new Student("Test", "One", "test.one@test.com");
			Student tempStudent2 = new Student("Test", "Two", "test.two@test.com");
			Student tempStudent3 = new Student("Test", "Three", "test.three@test.com");

			
			// begin a transaction
			System.out.println("Beginning transaction");
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving student object");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			
			// commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();			
		}
	}

}
