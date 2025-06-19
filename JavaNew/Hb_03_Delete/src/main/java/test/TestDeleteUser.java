package test;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.User;
import util.HibernateteUtil;

public class TestDeleteUser {

	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateteUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction tr = session.beginTransaction();
					// Lay thong tin tu mot bang ten (User) trong CSDL HIbernate
					
					
					List<User> users = session.createQuery("from User",User.class).getResultList();
					System.out.println("Du lieu truoc khi xoa");
					for (User user : users) {
						System.out.println("Id: "+user.getId()+", Name: "+user.getName() +", Age: "+user.getAge()+", Address: "+user.getAddress());
					}
					
					System.out.println("Xoa id");
					int UesrId = 4;
					User user = session.get(User.class, UesrId);
					
					if(user!=null) {
						// xoa person
						session.delete(user);
						System.out.println("Da xoa User co Id: "+ UesrId);
					} else {
						System.out.println("Khong tim thay User co id: "+UesrId);
					}
					
				
					
					System.out.println("Du lieu sau khi xoa ");
					List<User> users0 = session.createQuery("from User",User.class).getResultList();
					for (User user0 : users0) {
						System.out.println("Id: "+user0.getId()+", Name: "+user0.getName() +", Age: "+user0.getAge()+", Address: "+user0.getAddress());
					}
					
					tr.commit();
					
					
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
