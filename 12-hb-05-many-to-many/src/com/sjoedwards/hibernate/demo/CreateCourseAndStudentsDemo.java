package com.sjoedwards.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sjoedwards.hibernate.demo.entity.Course;
import com.sjoedwards.hibernate.demo.entity.Instructor;
import com.sjoedwards.hibernate.demo.entity.InstructorDetail;
import com.sjoedwards.hibernate.demo.entity.Review;
import com.sjoedwards.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try { 
	
			// begin a transaction
			System.out.println("Beginning transaction");
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("Pacman");
			
			// save course - leverage the cascading all - will save all reviews!
			session.save(tempCourse);
			
			
			// create students 
			Student tempStudent1 = new Student("Test", "Test1", "test.test1@test.com");
			Student tempStudent2 = new Student("Test", "Test1", "test.test1@test.com");

			
			// add to course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);

			
			// save the students
	
			System.out.println("\nSaving students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved students: " + tempCourse.getStudents());

			

			// commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			session.close();
			factory.close();			
		}
	}

}
