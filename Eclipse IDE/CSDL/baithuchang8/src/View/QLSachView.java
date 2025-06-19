package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.Key;
import Controller.LIstener;
import Model.QLSach;
import Model.Sach;

public class QLSachView extends JFrame {

	public Sach sach;
	public QLSach qlSach = new QLSach();
	public DefaultTableModel model;
	public JTextField idText;
	public JTextField sachText;
	public JTextField tacgiaText;
	public JTextField namXBText;
	public JTable jTable_nhap;
	public JLabel jLabel;
	private int row;
	public QLSachView qlSachView;
	
	public QLSachView() throws HeadlessException {
		this.qlSach = qlSach;
		this.init();
	}
	public void init() {
		this.setTitle("Quan ly sach");
		this.setSize(600,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
				
		JLabel jLabel_gt = new JLabel("STUDENT MANAGEMENT");
		
		String[] cols = { "ID", "TenSach", "TenTG","NamXB" };
		model = new DefaultTableModel(cols, 0);
		jTable_nhap = new JTable(model);
		JScrollPane jScrollPane = new JScrollPane(jTable_nhap);
		
		ActionListener ac = new LIstener(this);
		KeyListener kc = new Key(this);
		
		jLabel = new JLabel("Ket qua tim kiem");
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(7, 2));
		jPanel.add(new JLabel("ID sach: "));
		idText = new JTextField(12);
		jPanel.add(idText);
		jPanel.add(new JLabel("Ten Sach : "));
		sachText = new JTextField(12);
		jPanel.add(sachText);
		jPanel.add(new JLabel("Ten Tac gia: "));
		tacgiaText = new JTextField(12);
		jPanel.add(tacgiaText);
		jPanel.add(new JLabel("Nam XB: "));
		namXBText = new JTextField(12);
		jPanel.add(namXBText);
		JButton b1 = new JButton("Add");	
		jPanel.add(b1);
		b1.addActionListener(ac);
		JButton b2 = new JButton("Delete");
		jPanel.add(b2);
		b2.addActionListener(ac);
		JButton b3 = new JButton("Edit");
		jPanel.add(b3);
		b3.addKeyListener(kc);;
		JButton b4 = new JButton("Search");
		jPanel.add(b4);
		b4.addActionListener(ac);
		JButton b5 = new JButton("Clear");
		jPanel.add(b5);
		b5.addActionListener(ac);
		JButton b6 = new JButton("Cancel");
		jPanel.add(b6);
		b6.addActionListener(ac);
		
		b3.addActionListener((ActionEvent e) -> {
            if (row >= 0) {model.setValueAt(idText.getText(), row, 0);
            model.setValueAt(sachText.getText(), row, 1);
            model.setValueAt(tacgiaText.getText(), row, 2);
            model.setValueAt(namXBText.getText(), row, 3);
            Sach sach = new Sach(idText.getText(), sachText.getText(), tacgiaText.getText(), Integer.valueOf(idText.getText()));
            idText.setText("");
            sachText.setText("");
            tacgiaText.setText("");
            namXBText.setText("");
         
        }
    });
		  b4.addActionListener((ActionEvent e) -> {
	            String searchQuery = JOptionPane.showInputDialog(this, "Enter Book ID to search:");
	            if (searchQuery != null && !searchQuery.isEmpty()) {
	                boolean found = false;
	                for (int i = 0; i < model.getRowCount(); i++) {
	                    if (model.getValueAt(i, 0).equals(searchQuery)) {
	                        jTable_nhap.setRowSelectionInterval(i, i);
	                        found = true;
	                        break;
	                    }
	                }
	                if (!found) {
	                    JOptionPane.showMessageDialog(this, "Book ID not found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
	                }
	            }
	        });
		  
		  jTable_nhap.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mousePressed(MouseEvent e) {
	                row = jTable_nhap.getSelectedRow();
	                idText.setText((String) model.getValueAt(row, 0));
	                sachText.setText((String) model.getValueAt(row, 1));
	                tacgiaText.setText((String) model.getValueAt(row, 2));
	                namXBText.setText((String) model.getValueAt(row, 3));
	            }
	        });

	        this.addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	            	 int n = JOptionPane.showConfirmDialog(qlSachView, "Bạn muốn thoát", "Xác nhận", JOptionPane.YES_OPTION);
	                if (n == 0) {
	                   qlSachView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                   System.exit(0);
	                }else {
	                	qlSachView.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	                }
	            }
	        });



		this.add(jLabel_gt, BorderLayout. NORTH);
		this.add(jScrollPane, BorderLayout.CENTER);
		this.add(jPanel, BorderLayout.WEST);
		
		
		this.setVisible(true);
		
		
	}

}
