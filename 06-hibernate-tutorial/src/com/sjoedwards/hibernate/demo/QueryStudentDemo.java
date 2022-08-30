package com.sjoedwards.hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sjoedwards.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try { 
					
			
			// begin a transaction
			System.out.println("Beginning transaction");
			session.beginTransaction();
			
			// query the students 
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// Display the students
			displayStudents(theStudents);
			
			 theStudents = session.createQuery("from Student s where s.lastName='One'").getResultList();

			System.out.println("\nStudents with lastname of Doe");

			displayStudents(theStudents);
			
			
			// query students: lastname='Doe' or firstname='Daffy'
			theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
		

			displayStudents(theStudents);
			
			System.out.println("Here!");

			
			theStudents = session.createQuery("from Student s where s.email like '%test.com'").getResultList();

			displayStudents(theStudents);

			
			// commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();			
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents) { 
			System.out.println(tempStudent);
		}
	}

}
