package View;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controller.GiaiptListenner;
import Model.Giaiptmodel;
import batloi.showErrorMessage;
import batloi.ab;
import batloi.b;

public class Giaiptview extends JFrame {

	private Giaiptmodel giaiptmodel;
	private JTextField jTextField_a;
	private JTextField jTextField_b;
	private JLabel jLabel_kqduara;
	

	public Giaiptview() throws HeadlessException {
		this.giaiptmodel = new Giaiptmodel();
		this.init();
		

	}
//	private Giaiptview giaiptview = new Giaiptview();

	public void init() {
		this.setTitle("Giai phuong trinh bac 1");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		GiaiptListenner ac = new GiaiptListenner(this);
		
		JLabel jLabel_a = new JLabel("Nhap a: ");
		JLabel jLabel_b = new JLabel("Nhap b: ");
		JLabel jLabel_kq = new JLabel("Ket qua: ");
		jTextField_a = new JTextField();
		jTextField_b = new JTextField();
		jLabel_kqduara = new JLabel();

		JButton button_ok = new JButton("OK");
		button_ok.addActionListener(ac);
		JButton button_cancel = new JButton("Cancel");
		button_cancel.addActionListener(ac);

		this.setLayout(new GridLayout(4, 2));
		this.add(jLabel_a);
		this.add(jTextField_a);
		this.add(jLabel_b);
		this.add(jTextField_b);
		this.add(jLabel_kq);
		this.add(jLabel_kqduara);
		this.add(button_ok);
		this.add(button_cancel);

		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(
                       null,
                        "Bạn có chắc muốn đóng cửa sổ?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    // Đóng ứng dụng khi người dùng chọn "Yes"
                  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    // Ngăn chặn đóng cửa sổ khi người dùng chọn "No"
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
		

	this.setVisible(true);

	}

	public void giaipt() throws showErrorMessage {
		
		String loi = "";
		try {
			try {
				double a = Double.valueOf(jTextField_a.getText());
				this.giaiptmodel.setA(a);
			} catch (Exception e) {
				loi=loi+"loi a";

			}

			try {
				double b = Double.valueOf(jTextField_b.getText());
				this.giaiptmodel.setB(b);
				if (b == 0) {
					loi = loi + " loi b=0";
				}
			} catch (Exception e) {
				loi = loi +" loi b";
			}
		} catch (Exception e) {
			//
		}
		this.giaiptmodel.giaipt();
		if (loi == "") {
			this.jLabel_kqduara.setText(this.giaiptmodel.getKq() + "");
		} else {
			jTextField_a.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					jTextField_a.requestFocus();
					
				}
	        });
			this.jLabel_kqduara.setText(loi);
			this.jTextField_a.setText("");
			this.jTextField_b.setText("");
		}

	}

	public void xoa() {
		this.jTextField_a.setText(0 + "");
		this.jTextField_b.setText(0 + "");
	}
}
