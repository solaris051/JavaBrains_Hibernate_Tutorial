package ua.dev.hibernate;

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
		
		Address addr1 = new Address();
		addr1.setCity("New York");
		addr1.setState("NY");
		addr1.setStreet("5th ave.");
		addr1.setZipCode("1123");
		
		Address workAddr = new Address();
		workAddr.setCity("Vienna");
		workAddr.setState("W");
		workAddr.setStreet("Hebbelpl. 5");
		workAddr.setZipCode("1100");
		
		user.getListOfAddresses().add(addr1);
		user.getListOfAddresses().add(workAddr);
		
		// HIBERNATE STUFF
		
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

		
//		retirive the collection of Addresses
		user = null;
		
		session = sessionFactory.openSession();
		user = (UserDetails) session.get(UserDetails.class, 1);
		session.close();
		System.out.println(user.getListOfAddresses().size());
//		session.close();
	}
}
