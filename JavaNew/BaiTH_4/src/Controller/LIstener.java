package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Sach;
import View.QLSachView;

public class LIstener implements ActionListener{

	QLSachView sachView;

	public LIstener(QLSachView sachView) {
		this.sachView = sachView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		
		if(button.equals("Add")) {
			Object [] objects = {sachView.idText.getText(), sachView.sachText.getText(), sachView.tacgiaText.getText(), sachView.namXBText.getText()};
			sachView.model.addRow(objects);
			Sach sach = new Sach(sachView.idText.getText(), sachView.sachText.getText(), sachView.tacgiaText.getText(), Integer.valueOf(sachView.namXBText.getText()));
			sachView.qlSach.Add(sach);
			} else if (button.equals("Delete")) {
				Object [] objects = {sachView.idText.getText(), sachView.sachText.getText(), sachView.tacgiaText.getText(), sachView.namXBText.getText()};
				Sach sach = new Sach(sachView.idText.getText(), sachView.sachText.getText(), sachView.tacgiaText.getText(), Integer.valueOf(sachView.namXBText.getText()));
				int rowIndex = findRowIndex(sachView.jTable_nhap,sachView.idText.getText() , 0);
				sachView.model.removeRow(rowIndex);
			    sachView.qlSach.Xoa(sach);
			} else if(button.equals("Clear")) {
				Object [] objects = {sachView.idText.getText(), sachView.sachText.getText(), sachView.tacgiaText.getText(), sachView.namXBText.getText()};
				Sach sach = new Sach(sachView.idText.getText(), sachView.sachText.getText(), sachView.tacgiaText.getText(), Integer.valueOf(sachView.namXBText.getText()));
				DefaultTableModel model = (DefaultTableModel) sachView.jTable_nhap.getModel();
		        model.setRowCount(0);
		        sachView.qlSach.Xoa(sach);
			} else if(button.equals("Cancel")) {
				try {
					String result = String.valueOf(JOptionPane.showConfirmDialog(null, "Ban muon thoat?", "Xac nhan", JOptionPane.YES_NO_OPTION));
					if (Integer.valueOf(result) == JOptionPane.YES_OPTION) {
						System.exit(0);
						sachView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}
				} catch (NumberFormatException ex) {
					sachView.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}

			}
		
	}
	
	
	
	

	private static int findRowIndex(JTable table, Object value, int column) {
        for (int i = 0; i < table.getRowCount(); i++) {
            Object cellValue = table.getValueAt(i, column);
            if (cellValue != null && cellValue.equals(value)) {
                return i;
            }
        }
        // Trả về -1 nếu không tìm thấy
        return -1;
    }
}

	
	

