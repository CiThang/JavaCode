package Test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.User;
import util.HibernateUtil;

public class TestUser {

	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction tr = session.beginTransaction();
					User user1 = new User();
					user1.setName("chiu");
					user1.setAge(19);
					user1.setAddress("Hue");
					
//					User user2 = new User();
//					user2.setName("Chi Thang");
//					user2.setAddress("Hue");
//					user2.setAge(19);
//					
//					
//					session.save(user2);
					session.save(user1);
					tr.commit();
				} finally {
					// TODO: handle finally clause
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
