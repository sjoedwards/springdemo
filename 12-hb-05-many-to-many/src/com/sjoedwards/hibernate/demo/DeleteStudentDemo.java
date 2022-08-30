package com.sjoedwards.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sjoedwards.hibernate.demo.entity.Course;
import com.sjoedwards.hibernate.demo.entity.Instructor;
import com.sjoedwards.hibernate.demo.entity.InstructorDetail;
import com.sjoedwards.hibernate.demo.entity.Review;
import com.sjoedwards.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			int studentId = 1;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("tempStudent courses"+ tempStudent.getCourses());
			
			// delete student
			System.out.println("\n Deleting student: " + tempStudent);
			session.delete(tempStudent);
			
			// commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			session.close();
			factory.close();			
		}
	}

}
