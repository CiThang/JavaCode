package test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Person;
import util.HibernateUtil;

public class test {

	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				try {
					
					Scanner sc = new Scanner(System.in);
					int luachon=0; 
					do {
						Transaction tr = session.beginTransaction();
						System.out.println("Nhap lua chon");
						System.out.println("1.Nhap thong tin");
						System.out.println("2.In thong tin");
						System.out.println("3.Tim thong tin theo ten");
						System.out.println("4.Xoa theo ten");
						System.out.println("5.Thoat");
						System.out.println("Lua chon: "); luachon = sc.nextInt();
						
						if(luachon == 1) {
							
							System.out.println("Name: "); String name = sc.next(); sc.nextLine();
							System.out.println("Age: "); Integer age = sc.nextInt(); sc.nextLine();
							System.out.println("Address"); String address = sc.next(); sc.nextLine();
							System.out.println("Salary: "); Double salary = sc.nextDouble(); sc.nextLine();
							
							Person person = new Person(null, name, age, address, salary);
							session.save(person);
							tr.commit();
						} else if(luachon == 2) {
							List<Person> listPerson = session.createQuery("from Person",Person.class).getResultList();
							for (Person person : listPerson) {
								System.out.println("Id: "+person.getId()+",Name: "+person.getName()+",Age: "+person.getAge()+",Addess: "+person.getAddress());
							}
							tr.commit();
						} else if(luachon==3) {
							System.out.println("Nhap ten muon tim: "); String name = sc.next(); sc.nextLine();
							Query<Person> query = session.createQuery("from Person where name=:personName",Person.class);
							query.setParameter("personName", name);
							
							  // Thực thi truy vấn và lấy kết quả danh sách
				            List<Person> persons = query.getResultList();
				            tr.commit();
				            if (persons != null && !persons.isEmpty()) {
				                for (Person person : persons) {
				                    System.out.println("Person found: " + "Id: "+person.getId()+",Name: "+person.getName()+",Age: "+person.getAge()+",Addess: "+person.getAddress());
				                }
				            } else {
				                System.out.println("No persons found with the given name.");
				            }
						} else if(luachon==4) {
							System.out.println("Nhap ten muon tim: "); String name = sc.next(); sc.nextLine();
				            Query query = session.createQuery("delete from Person where name=:personName");
				            query.setParameter("personName", name);
				            // Thực thi truy vấn
				            int result = query.executeUpdate();
				            tr.commit();
				         // Kiểm tra kết quả
				            if (result > 0) {
				                System.out.println("Person(s) with name '" + name + "' were deleted.");
				            } else {
				                System.out.println("No person found with the given name.");
				            }

						} else if(luachon==5) {
							break;
						}
						
					} while (luachon!=5);
					
					
					
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
