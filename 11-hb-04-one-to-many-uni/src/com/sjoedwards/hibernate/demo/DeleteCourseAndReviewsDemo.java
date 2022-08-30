package com.sjoedwards.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sjoedwards.hibernate.demo.entity.Course;
import com.sjoedwards.hibernate.demo.entity.Instructor;
import com.sjoedwards.hibernate.demo.entity.InstructorDetail;
import com.sjoedwards.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try { 
	
			// begin a transaction
			System.out.println("Beginning transaction");
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("Pacman1");
			
			// add reviews
			tempCourse.addReview(new Review("Great course, loved it"));
			tempCourse.addReview(new Review("Great course, loved it 2"));
			tempCourse.addReview(new Review("Great course, loved it 3"));
			
			System.out.println("Saving the course" + tempCourse + tempCourse.getReviews());

			
			// save course - leverage the cascading all - will save all reviews!
			session.save(tempCourse);
			
			
			// delete course 
			session.delete(tempCourse);
			
			// commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			session.close();
			factory.close();			
		}
	}

}
