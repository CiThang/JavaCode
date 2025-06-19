package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Tạo SessionFactory từ hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			// In ra stack trace để dễ dàng debug
			e.printStackTrace();
			System.out.println("Initial SessionFactory creation failed: " + e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

	public static void shutdown() {
		// Đóng caches và connection pools
		getSessionFactory().close();
	}
}
