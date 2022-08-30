package com.sjoedwards.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sjoedwards.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try { 
			
			// create the student object
			
			System.out.println("Creating new student object");
			// ID is zero to begin with
			Student tempStudent = new Student("Daffy", "Duck", "daffy.duck@test.com");
			
			// begin a transaction
			System.out.println("Beginning transaction");
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving student object" + tempStudent);
			session.save(tempStudent);
			
			// commit the transaction 
			session.getTransaction().commit();
			
			// Get the primary key
			System.out.println("Saved student, generated ID:" + tempStudent.getId());

			
			// Get a session and start transaction - we always use transactions
			session = factory.getCurrentSession();
			session.beginTransaction();			
			
			// Retrieve student based on ID
			System.out.println("\nGetting student with ID:" + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("\nGet complete: " + myStudent.getId());

			// Commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
			
		}finally {
			factory.close();			
		}
	}

}
