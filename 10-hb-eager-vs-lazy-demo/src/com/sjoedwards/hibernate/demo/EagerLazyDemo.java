package com.sjoedwards.hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sjoedwards.hibernate.demo.entity.Course;
import com.sjoedwards.hibernate.demo.entity.Instructor;
import com.sjoedwards.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try { 
		
		
			
			// begin a transaction
			System.out.println("Beginning transaction");
			session.beginTransaction();
			
			// get instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
		
			System.out.println("Instructor" + tempInstructor);
			
			// System.out.println("Courses: " + tempInstructor.getCourses());
			
			
			
			// commit the transaction 
			session.getTransaction().commit();
			
			// since the courses are lazy loaded, this should fail! We're closing the session early 
			session.close();
			
			
			System.out.println("\nThe session is now closed!\n");
			// option 1: call getter method when session is open - uncomment line 35. So it was loaded into memory when the session was open. It will still work! 
			
			List<Course> courses = tempInstructor.getCourses();
			System.out.println("Courses" + courses);


			
			System.out.println("Done!");
			
		}finally {
			session.close();
			factory.close();			
		}
	}

}
