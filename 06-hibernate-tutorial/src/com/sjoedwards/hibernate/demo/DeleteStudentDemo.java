package com.sjoedwards.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sjoedwards.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try { 
			
			
			
			session.beginTransaction();
			
			
			// Retrieve student based on ID
//			System.out.println("\nGetting student with ID:" + studentId);
//			Student myStudent = session.get(Student.class, studentId);
//			System.out.println("\nGet complete:" + myStudent);
//			
//			System.out.println("\nDelete student..." + myStudent);
//			session.delete(myStudent);
//			
			
			session = factory.getCurrentSession();
			session.createQuery("delete from Student where id=2").executeUpdate();

			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();			
		}
	}

}
