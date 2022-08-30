package com.sjoedwards.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sjoedwards.hibernate.demo.entity.Course;
import com.sjoedwards.hibernate.demo.entity.Instructor;
import com.sjoedwards.hibernate.demo.entity.InstructorDetail;
import com.sjoedwards.hibernate.demo.entity.Review;
import com.sjoedwards.hibernate.demo.entity.Student;

public class AddCoursesForTestDemo {

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
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("tempStudent "+ tempStudent);
			
			System.out.println("tempStudent "+ tempStudent);

			
			// create more courses
			Course tempCourse1 = new Course("Course 1");
			Course tempCourse2 = new Course("Course 2");
			
			// add student to the courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);


			// commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			session.close();
			factory.close();			
		}
	}

}
