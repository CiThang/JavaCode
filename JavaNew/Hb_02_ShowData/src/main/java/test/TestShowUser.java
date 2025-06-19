package test;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.User;
import util.HibernateUtil;

public class TestShowUser {

	public static void main(String[] args) {
		
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction tr = session.beginTransaction();
					
					// Lay thong tin tu mot bang ten (User) trong CSDL HIbernate
					List<User> users = session.createQuery("from User",User.class).getResultList();
					
					for (User user : users) {
						System.out.println("Id: "+user.getId()+", Name: "+user.getName() +", Age: "+user.getAge()+", Address: "+user.getAddress());
					}
					
					tr.commit();
				} finally {
					session.close();
					sessionFactory.close();
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
