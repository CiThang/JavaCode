package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Person;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ViewInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField tx_name;
	public JTextField tx_age;
	public JTextField tx_salary;
	public JTextField tx_address;
	public JTextField tx_name_search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewInfo frame = new ViewInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		ActionListener ac = new Controller(this);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Age");
		lblNewLabel.setBounds(39, 89, 57, 34);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(39, 43, 57, 34);
		contentPane.add(lblNewLabel_1);

		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setBounds(39, 145, 57, 34);
		contentPane.add(lblSalary);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(39, 201, 57, 34);
		contentPane.add(lblAddress);

		tx_name = new JTextField();
		tx_name.setBounds(106, 50, 110, 20);
		contentPane.add(tx_name);
		tx_name.setColumns(10);

		tx_age = new JTextField();
		tx_age.setColumns(10);
		tx_age.setBounds(106, 96, 110, 20);
		contentPane.add(tx_age);

		tx_salary = new JTextField();
		tx_salary.setColumns(10);
		tx_salary.setBounds(106, 152, 110, 20);
		contentPane.add(tx_salary);

		tx_address = new JTextField();
		tx_address.setColumns(10);
		tx_address.setBounds(106, 208, 110, 20);
		contentPane.add(tx_address);

		JButton btn_add = new JButton("Add");
		btn_add.setBounds(308, 61, 89, 23);
		contentPane.add(btn_add);
		btn_add.addActionListener(ac);

		JButton btn_show = new JButton("Show");
		btn_show.setBounds(246, 107, 89, 23);
		contentPane.add(btn_show);
		btn_show.addActionListener(ac);

		tx_name_search = new JTextField();
		tx_name_search.setBounds(345, 125, 86, 23);
		contentPane.add(tx_name_search);
		tx_name_search.setColumns(10);

		JButton btn_delete = new JButton("Delete");
		btn_delete.setBounds(246, 151, 89, 23);
		contentPane.add(btn_delete);
		btn_delete.addActionListener(ac);
	}

	public Person getInfo() {
		String name = tx_name.getName();
		int age = Integer.valueOf(tx_age.getText());
		String address = tx_address.getText();
		int salary = Integer.valueOf(tx_salary.getText());

		return new Person(null, name, age, address, salary);
	}

	public void setInfo(Person person) {
		tx_name.setText(person.getName());
		tx_age.setText(person.getAge() + "");
		tx_address.setText(person.getAddress());
		tx_salary.setText(person.getSalary() + "");
	}

}
