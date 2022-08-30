package com.sjoedwards.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sjoedwards.hibernate.demo.entity.Instructor;
import com.sjoedwards.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try { 
	
			
			
			// begin a transaction
			System.out.println("Beginning transaction");
			session.beginTransaction();
			
			// get the instructor detail
			int theInt = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theInt);
			
			// print the associated instructor
			System.out.println("tempInstructorDetail: "+ tempInstructorDetail);
			
			System.out.println("the associated instructor: "+ tempInstructorDetail.getInstructor());
			System.out.println("Deleting temp instructor detail");
			// now lets delete the instructor detail
			session.delete(tempInstructorDetail);
			
			// remove the associated object reference 
			// break the bidirectional link - removes the reference from instructor
			// So Instructor does not reference instructorDetail. But instructorDetail does reference Instructor
			// DELETE on Instructor -> now means you can delete the instructor detail as the bidirectonal link is broken
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			// commit the transaction 
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}catch (Exception err) {
			err.printStackTrace();
			
		} finally {
			session.close();
		
			factory.close();			
		}
	}

}
