package Test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.User;
import util.HibernateUtil;

public class TestUser {

	public static void main(String[] args) {

		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction tr = session.beginTransaction();
//					User us1 = new User();
//					us1.setName("null");
//					us1.setAge(14);
//					us1.setAddress("da nang");
//					session.save(us1);
//					tr.commit();

					int id = 2;
					User us = session.get(User.class, id);
					if(us!=null) {
						// Update usser
						us.setName("Chis Thawnsg");
					} else {
						System.out.println("khhong tim thay Id");
					}
					
					List<User> users = session.createQuery("from User", User.class).getResultList();
					for (User user : users) {
						System.out.println("Id: "+user.getId()+", Name: "+ user.getName()+ ", Age: "+user.getAge());
					}
					
				} finally {
					// Close session
					session.close();
					sessionFactory.close();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
