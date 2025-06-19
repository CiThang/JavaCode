package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Person;
import util.HibernateUtil;

public class Controller implements ActionListener {

	private ViewInfo Vf;

	public Controller(ViewInfo vf) {
		
		this.Vf =vf;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction tr =session.beginTransaction();
					if(command.equals("Add")) {
						Person person = Vf.getInfo();
						session.save(person);
						System.out.println(person.toString());
						tr.commit();
					} else if(command.equals("Show")) {
						int namesearch = Integer.valueOf(Vf.tx_name_search.getText());
						Person person = session.get(Person.class, namesearch);
						Vf.setInfo(person);
						tr.commit();
					} else if(command.equals("Delete")) {
						int namesearch = Integer.valueOf(Vf.tx_name_search.getText());
						Person person = session.get(Person.class, namesearch);
						session.delete(person);
						tr.commit();
					}
					
					
					
				} finally {
					
				}
				
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(Vf, "Khong the thuc hien");
			e2.printStackTrace();
		}
		
		
		
	
		
	}
	
	
}
