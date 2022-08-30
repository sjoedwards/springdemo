package com.sjoedwards.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sjoedwards.hibernate.demo.entity.Course;
import com.sjoedwards.hibernate.demo.entity.Instructor;
import com.sjoedwards.hibernate.demo.entity.InstructorDetail;
import com.sjoedwards.hibernate.demo.entity.Review;
import com.sjoedwards.hibernate.demo.entity.Student;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try { 
	
			// begin a transaction
			System.out.println("Beginning transaction");
			session.beginTransaction();
			
			// get the student from the database
			int courseId = 10;
			Course tempCourse = session.get(Course.class, courseId);
			
			System.out.println("tempCourse students "+ tempCourse.getStudents());
			
			// Delete the course - will also delete any lookup table entries which reference the course BUT not the students themselves 
			session.delete(tempCourse);
			
			// commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("tempCourse students "+ tempCourse.getStudents());

			
			System.out.println("Done!");
			
		}finally {
			session.close();
			factory.close();			
		}
	}

}
