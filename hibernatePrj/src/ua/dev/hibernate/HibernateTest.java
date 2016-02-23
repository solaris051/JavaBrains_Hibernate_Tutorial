package ua.dev.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ua.dev.hibernate.dto.UserDetails;

public class HibernateTest {
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("second User");

		
		Configuration conf = new Configuration().configure();
		SessionFactory factory = conf.buildSessionFactory();
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

		
		System.out.println(user.getDescription());
	}
}
