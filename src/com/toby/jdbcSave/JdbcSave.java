package com.toby.jdbcSave;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.toby.model.Student;

public class JdbcSave {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student tempStudent1 = new Student("Toby","Cheung","hang@gmail.com");

			session.beginTransaction();
			
			session.save(tempStudent1);
			
			System.out.println(tempStudent1.getId());
			
			Student readStudent = session.get(Student.class, tempStudent1.getId());
			
			System.out.println(readStudent);
			
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}
		
	}

}
