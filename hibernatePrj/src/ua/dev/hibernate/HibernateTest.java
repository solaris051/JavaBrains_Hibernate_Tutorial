package ua.dev.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ua.dev.hibernate.dto.Address;
import ua.dev.hibernate.dto.UserDetails;

public class HibernateTest {
	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("second User");
		
		Address addr = new Address();
		addr.setCity("New York");
		addr.setState("NY");
		addr.setStreet("5th ave.");
		addr.setZipCode("1123");
		user.setHomeAddress(addr);
		
		Address workAddr = new Address();
		addr.setCity("Vienna");
		addr.setState("W");
		addr.setStreet("Hebbelpl. 5");
		addr.setZipCode("1100");
		user.setWorkAddress(workAddr);

		
		Configuration conf = new Configuration().configure();
		SessionFactory factory = conf.buildSessionFactory();
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

		
//		System.out.println(user.getDescription());
	}
}
