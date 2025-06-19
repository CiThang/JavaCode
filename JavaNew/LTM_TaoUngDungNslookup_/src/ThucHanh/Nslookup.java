package ThucHanh;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.awt.event.ActionEvent;

public class Nslookup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_tenmien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nslookup frame = new Nslookup();
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
	public Nslookup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ten mien");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(20, 26, 103, 34);
		contentPane.add(lblNewLabel);
		
		textField_tenmien = new JTextField();
		textField_tenmien.setBounds(133, 26, 218, 34);
		contentPane.add(textField_tenmien);
		textField_tenmien.setColumns(10);
		JTextArea textAreaKetqua = new JTextArea();
		textAreaKetqua.setBounds(38, 91, 469, 263);
		contentPane.add(textAreaKetqua);
		
		JButton btnip = new JButton("Tra cuu ip");
		btnip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenmien = textField_tenmien.getText();
				try {
					InetAddress ipAddress = InetAddress.getByName(tenmien);
					String ip = ipAddress.getHostAddress();
					textAreaKetqua.setText("ip: "+ip);
				} catch (Exception e2) {
					// TODO: handle exception
					textAreaKetqua.setText("Khong tim thay ip");
				}
				
			}
		});
		btnip.setBounds(379, 26, 113, 34);
		contentPane.add(btnip);
		
		
	}
}
