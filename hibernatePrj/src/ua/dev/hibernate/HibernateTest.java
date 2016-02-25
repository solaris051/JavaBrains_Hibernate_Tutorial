package ua.dev.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ua.dev.hibernate.dto.Address;
import ua.dev.hibernate.dto.UserDetails;
import ua.dev.hibernate.dto.Vehicle;

public class HibernateTest {
	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserName("second User");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("car");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");
		
		user.getVehicles().add(vehicle1);
		user.getVehicles().add(vehicle2);
		vehicle1.setUser(user);
		vehicle2.setUser(user);
		// HIBERNATE STUFF
		
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(user);
		
		session.save(vehicle1);
		session.save(vehicle2);
		
		session.getTransaction().commit();
		session.close();

		
//		retirive the collection of Addresses
		user = null;
		
		session = sessionFactory.openSession();
		user = (UserDetails) session.get(UserDetails.class, 1);
		session.close();
	}
}
