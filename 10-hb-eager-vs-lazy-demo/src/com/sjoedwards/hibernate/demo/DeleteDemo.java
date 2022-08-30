package com.sjoedwards.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sjoedwards.hibernate.demo.entity.Instructor;
import com.sjoedwards.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try { 
	
			
			
			// begin a transaction
			System.out.println("Beginning transaction");
			session.beginTransaction();
			
			// get an instructor by their primary key
			
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("The instructor" + tempInstructor);
			
			if (tempInstructor != null) {
				// Note will also cascade the delete to the instructorDetails object, because of the Cascade.ALL
				System.out.println(tempInstructor);
				session.delete(tempInstructor);
			}
					
			
			// delete the instructors
			
			
			// commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();			
		}
	}

}
