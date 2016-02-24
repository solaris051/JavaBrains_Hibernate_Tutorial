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
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("car");
		
		user.setVehicle(vehicle);
		
		// HIBERNATE STUFF
		
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(user);
		session.save(vehicle);
		
		session.getTransaction().commit();
		session.close();

		
//		retirive the collection of Addresses
		user = null;
		
		session = sessionFactory.openSession();
		user = (UserDetails) session.get(UserDetails.class, 1);
		session.close();
	}
}
