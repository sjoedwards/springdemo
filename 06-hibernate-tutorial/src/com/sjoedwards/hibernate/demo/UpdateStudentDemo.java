package com.sjoedwards.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sjoedwards.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try { 
			
			
			int studentId = 1;
			
			session.beginTransaction();
			
			
			// Retrieve student based on ID
			System.out.println("\nGetting student with ID:" + studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("\nGet complete:" + myStudent);
			
			System.out.println("\nUpdating student..." + myStudent);
			myStudent.setFirstName("Scooby");

			// Commit the transaction
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			// Update email for all students
			
			System.out.println("Updating all students to foo@test.com");
			session.createQuery("Update Student set email='foo@gmail.com'").executeUpdate();
			session.getTransaction().commit();

			
			
			
			System.out.println("Done!");
			
		}finally {
			factory.close();			
		}
	}

}
