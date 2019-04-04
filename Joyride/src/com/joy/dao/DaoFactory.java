package com.joy.dao;

import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.joy.entity.Cars;
import com.joy.entity.User;

public class DaoFactory {
	static SessionFactory sf=new Configuration().configure().buildSessionFactory();

	public static ArrayList<Cars> searchCars(String from, int seater) {
		Session session=sf.openSession();
		session.beginTransaction();
		System.out.println(from);
        Query query=session.createQuery("select c from Cars c where c.source=:source and c.seater=:seater");
		query.setParameter("source",from);
		query.setParameter("seater",seater);

		ArrayList<Cars> cars=(ArrayList<Cars>)query.list();
		System.out.println(cars.size());
		session.getTransaction().commit();
		session.close();
		return cars;
		
		
	}

	public static void registerUser(String name, int dob1, long dlnumber, int dlvalidity1, String email,
			String password, long mobile) {
		User newuser=new User();
		newuser.setName(name);
		newuser.setDob(dob1);
		newuser.setDlnumber(dlnumber);
		newuser.setDlvalidity(dlvalidity1);
		newuser.setEmail(email);
		newuser.setPassword(password);
		newuser.setMobile(mobile);
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(newuser);
		session.getTransaction().commit();
		session.close();
		
	}

	public static String getPassword(String email) {
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createNativeQuery("select password from user where email=:email");
		query.setParameter("email", email);
		String password=(String) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		if(password==null) {
			System.out.println("hello"+password);
			return "invalid";
		}
		else{System.out.println(password);
		return password;}
		
		
		
	}

	public static User getUserdata(String email) {
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("select u from User u where u.email=:email").setParameter("email", email);
		User userdata=(User)query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return userdata;
	}

	public static void bookCar(String registrationnumber, int id, int fromdate, int todate) {
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createNativeQuery("update cars set bookedfromdate=:fromdate, bookedtilldate=:todate, bookedbyid=:id where registrationnumber=:registrationnumber");
		query.setParameter("fromdate", fromdate);
		query.setParameter("todate", todate);
		query.setParameter("id", id);
		query.setParameter("registrationnumber", registrationnumber);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		
	}

}
