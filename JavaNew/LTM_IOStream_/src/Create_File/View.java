package Create_File;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldfolder;
	private JTextField textFieldFileName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
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
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FOLDER");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNewLabel.setBounds(10, 37, 79, 32);
		contentPane.add(lblNewLabel);
		
		textFieldfolder = new JTextField();
		textFieldfolder.setBounds(122, 36, 379, 37);
		contentPane.add(textFieldfolder);
		textFieldfolder.setColumns(10);
		
		JButton btnNewButton = new JButton("open");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            JFileChooser flChooser = new JFileChooser();
		            flChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		            int result = flChooser.showOpenDialog(View.this); // Pass reference to the parent component
		            
		            if(result == JFileChooser.APPROVE_OPTION) {
		                String path = flChooser.getSelectedFile().getAbsolutePath();
		                textFieldfolder.setText(path);
		            }
		        } catch (Exception ex) {
		            // Xử lý bất kỳ ngoại lệ nào ở đây
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton.setBounds(513, 37, 79, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblFileNe = new JLabel("File Name");
		lblFileNe.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblFileNe.setBounds(10, 96, 79, 32);
		contentPane.add(lblFileNe);
		
		textFieldFileName = new JTextField();
		textFieldFileName.setColumns(10);
		textFieldFileName.setBounds(122, 95, 379, 37);
		contentPane.add(textFieldFileName);
		
		JButton btnCreate = new JButton("create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = textFieldfolder.getText()+"/"+textFieldFileName.getText();
				File myFile = new File(path);
				
				if(textFieldFileName.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(View.this, "Ban chua nhap tap tin");
					return;
				}
				//Kiem tra file ton tai
				if(myFile.exists()) {
					// Thong bao loi
					JOptionPane.showMessageDialog(View.this, "Tap tin da ton tai");
				} else {
					// Tao file
					// Thong bao tao file thanh cong
					// Error co the xay ra: Ki tu dac biet, o cung het dung luong
					try {
						myFile.createNewFile();
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(View.this, "Khong the tao duoc tap tin");
					}
				}
			}
		});
		btnCreate.setBounds(513, 91, 79, 37);
		contentPane.add(btnCreate);
	}
}

