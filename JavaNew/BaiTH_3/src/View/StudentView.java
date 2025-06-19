package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.Listener;
import Model.List;
import Model.Student;

public class StudentView extends JFrame {

	public Student student;
	public List list ;
	public JTextField idText;
	public JTextField nameText;
	public JTextField addressText;
	public DefaultTableModel model;
	
	public int row = -1;

	public StudentView() throws HeadlessException {
		this.student = student;
		this.init();
//		this.list.getList();
	}

	public void init() {
		this.setTitle("Danh sach");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);

		JLabel jLabel_gt = new JLabel("STUDENT MANAGEMENT");
		
		String[] cols = { "ID", "Name", "Address" };
		model = new DefaultTableModel(cols, 0);
		JTable jTable_nhap = new JTable(model);
		JScrollPane jScrollPane = new JScrollPane(jTable_nhap);
		
		ActionListener ac = new Listener(this);
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(6, 2));
		jPanel.add(new JLabel("StuID: "));
		idText = new JTextField(12);
		jPanel.add(idText);
		jPanel.add(new JLabel("StuName: "));
		nameText = new JTextField(12);
		jPanel.add(nameText);
		jPanel.add(new JLabel("StuAddress: "));
		addressText = new JTextField(12);
		jPanel.add(addressText);
		JButton b1 = new JButton("Add");	
		jPanel.add(b1);
		b1.addActionListener(ac);
		JButton b2 = new JButton("Delete");
		jPanel.add(b2);
		JButton b3 = new JButton("Edit");
		jPanel.add(b3);
		JButton b4 = new JButton("Search");
		jPanel.add(b4);
		JButton b5 = new JButton("Clear");
		jPanel.add(b5);
		JButton b6 = new JButton("Cancel");
		jPanel.add(b6);
		
		
		

//		jTable.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				row = jTable.getSelectedRow();
//				idText.setText((String) model.getValueAt(row, 0));
//				nameText.setText((String) model.getValueAt(row, 1));
//				addressText.setText((String) model.getValueAt(row, 2));
//			}
//		});
		
		this.add(jLabel_gt, BorderLayout. NORTH);
		this.add(jScrollPane, BorderLayout.CENTER);
		this.add(jPanel, BorderLayout.WEST);
		
		this.setVisible(true);

}
	
}
