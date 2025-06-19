package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import View.Giaiptview;
import batloi.showErrorMessage;
import batloi.ab;
import batloi.b;

public class GiaiptListenner implements ActionListener {

	private Giaiptview giaiptview;

	public GiaiptListenner(Giaiptview giaiptview) {
		this.giaiptview = giaiptview;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("OK")) {
			try {
				this.giaiptview.giaipt();
			} catch (Exception e1) {
				//
			}
		} else if (button.equals("Cancel")) {
			try {
				String result = String.valueOf(JOptionPane.showConfirmDialog(null, "Ban muon thoat?", "Xac nhan", JOptionPane.YES_NO_OPTION));
				if (Integer.valueOf(result) == JOptionPane.YES_OPTION) {
					System.exit(0);
					giaiptview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			} catch (NumberFormatException ex) {
				giaiptview.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}

		}
	}}

	
	