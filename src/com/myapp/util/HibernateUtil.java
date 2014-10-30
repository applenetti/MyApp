package com.myapp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	private HibernateUtil() {
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
