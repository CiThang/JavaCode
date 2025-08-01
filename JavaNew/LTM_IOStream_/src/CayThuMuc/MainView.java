package CayThuMuc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Create_File.View;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldFolder;
	private File fileLog;

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
					MainView frame = new MainView();
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
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Folder");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(30, 39, 62, 39);
		contentPane.add(lblNewLabel);

		textFieldFolder = new JTextField();
		textFieldFolder.setBounds(102, 41, 434, 39);
		contentPane.add(textFieldFolder);
		textFieldFolder.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 117, 638, 274);
		contentPane.add(scrollPane);

		JTextPane textPanefile = new JTextPane();
		scrollPane.setViewportView(textPanefile);
// Chon file 
		JButton btnNewButton = new JButton("Chọn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int resuilt = chooser.showOpenDialog(MainView.this);
				if (resuilt == JFileChooser.APPROVE_OPTION) {
					String path = chooser.getSelectedFile().getAbsolutePath();
					textFieldFolder.setText(path);
					textPanefile.setText(listAllFiles(path, 0));
				}

			}

			private String listAllFiles(String path, int level) {
				File myFile = new File(path);
				// Kiem tra tap tin khong ton tai
				if (!myFile.exists())
					return " ";

				String result = "";

				// Tab vao
				for (int i = 0; i < level; i++) {
					result += "\t";
				}
				result += "|" + myFile.getName() + "\n";

				// Tap tin da ton tai
				// 1. Neu la file thi khong lam gi het

				if (myFile.isFile())
					return result + "\n";

				// 2. Luc nay no da la thu muc roi
				// if(myFile.isDirectory()) => kiem tra la thu muc

				// doan code chinh

				for (File f : myFile.listFiles()) {
					result += listAllFiles(f.getAbsolutePath(), level + 1);

				}
				return result + "\n";

			}
		});
		btnNewButton.setBounds(564, 43, 104, 39);
		contentPane.add(btnNewButton);
// Xoa file
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choose = JOptionPane.showConfirmDialog(MainView.this, "Are you sure delete all items? ");
				// Neu khong dong y xoa thi dung
				if (choose == JOptionPane.NO_OPTION)
					return;

				// Dong y xoa
				String path = textPanefile.getText();
				deleteFile(path);

			}

			private void deleteFile(String path) {
				try {
					File myFile = new File(path);
					// Neu la thu muc thi can xoa cac tap tin con truoc
					if (myFile.isDirectory()) {
						for (File f : myFile.listFiles()) {
							deleteFile(f.getAbsolutePath());
						}
					}
					// Xoa chinh ban than no
					myFile.deleteOnExit();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Arial", Font.BOLD, 16));
		btnDelete.setBounds(550, 451, 104, 39);
		contentPane.add(btnDelete);

// Doi ten file
		JButton btnRename = new JButton("Rename");
		btnRename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newFileName = JOptionPane.showInputDialog(MainView.this, "Nhap ten file ");

				try {
					String path = textFieldFolder.getText();
					// Old File
					File myFile = new File(path);

					// New File
					String newPath = myFile.getParent() + "\\" + newFileName;
					File newFile = new File(newPath);

					// Thay doi ten sang tap tin moi
					if (myFile.renameTo(newFile)) {
						textFieldFolder.setText(newFile.getAbsolutePath());
						JOptionPane.showMessageDialog(MainView.this, "Doi ten thanh cong");

					} else {
						JOptionPane.showMessageDialog(MainView.this, "Doi ten khong thanh cong");
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnRename.setFont(new Font("Arial", Font.BOLD, 16));
		btnRename.setBounds(403, 451, 104, 39);
		contentPane.add(btnRename);

		JButton btnCopy = new JButton("Copy");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int result = jFileChooser.showOpenDialog(MainView.this);
				if (result == jFileChooser.APPROVE_OPTION) {
					String source = textFieldFolder.getText();

					String destination = jFileChooser.getSelectedFile().getAbsolutePath();
					copy(source, destination);

				}

			}

			private void copy(String source, String destination) {
				try {
					Path sourcePath = Path.of(source);
					Path destinationPath = Path.of(destination);

					Path newPath = destinationPath.resolve(sourcePath.getFileName()); 
					Files.copy(sourcePath, newPath,StandardCopyOption.COPY_ATTRIBUTES);
					File myFile = new File(source);
					if(myFile.isDirectory()) {
						for(File f : myFile.listFiles()) {
							copy(f.getAbsolutePath(), destination+"\\"+sourcePath.getFileName());
							
						}
					}
					JOptionPane.showMessageDialog(MainView.this, "Copy thành công");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(MainView.this, "Copy không thành công");
				}
			}
		});
		btnCopy.setFont(new Font("Arial", Font.BOLD, 16));
		btnCopy.setBounds(102, 451, 104, 39);
		contentPane.add(btnCopy);

		JButton btnMove = new JButton("Move");
		btnMove.setFont(new Font("Arial", Font.BOLD, 16));
		btnMove.setBounds(227, 451, 104, 39);
		contentPane.add(btnMove);

	}
}	
