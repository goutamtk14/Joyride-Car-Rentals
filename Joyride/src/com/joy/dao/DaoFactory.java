package com.joy.dao;

import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.joy.entity.Cars;

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

}
