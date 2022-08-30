package com.sjoedwards.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sjoedwards.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try { 
			
			// create the student object
			
			System.out.println("Creating new student object");
			Student tempStudent = new Student("Paul", "Wall", "paul.wall@test.com");
			
			// begin a transaction
			System.out.println("Beginning transaction");
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving student object");
			session.save(tempStudent);
			
			// commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();			
		}
	}

}
