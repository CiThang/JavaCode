package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.Student;
import View.StudentView;

public class Listener implements ActionListener{

	private StudentView studentView;

	public Listener(StudentView studentView) {
		this.studentView = studentView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("Add")) {
			Object [] objects = {studentView.idText.getText(), studentView.nameText.getText(), studentView.addressText.getText()};
			studentView.model.addRow(objects);
			Student stu = new Student(studentView.idText.getText(), studentView.nameText.getText(), studentView.addressText.getText());
			studentView.list.add(stu);
		} else if (button.equals("Delete")) {
			if (studentView.row>=0) {
				studentView.model.removeRow(0);
				studentView.list.remove(studentView.row);
			}
		    // Get the text from text fields
		    Object[] objs = {studentView.idText.getText(), studentView.nameText.getText(), studentView.addressText.getText()};
		    
		    // Remove the corresponding row from the table model
		    studentView.model.removeRow(0);

		    // Create a new Student object
		    Student stu = new Student(studentView.idText.getText(), studentView.nameText.getText(), studentView.addressText.getText());
		    
		    // Remove the Student object from the list
		    studentView.list.remove(stu);
		}
		}
		
	}

	
	
	
