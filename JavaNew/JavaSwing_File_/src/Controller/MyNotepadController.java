package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import javax.swing.JFileChooser;

import View.MyNotepadView;

public class MyNotepadController implements ActionListener {

	MyNotepadView myNotepadView;

	public MyNotepadController(MyNotepadView myNotepadView) {
		this.myNotepadView = myNotepadView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		JFileChooser fc = new JFileChooser();
		if (command.equals("Open")) {
			// Mo cua so 
			int returnVal = fc.showOpenDialog(this.myNotepadView);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				String fileName = file.getName();
				this.myNotepadView.model.setFileName(file.getAbsolutePath());
				this.myNotepadView.lblNewLabel.setText(this.myNotepadView.model.getFileName());
				if (fileName.endsWith(".txt")) {
					try {
						List<String> allText = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
						String result = "";
						for (String line : allText) {
							result += line;
							result += "\n";
						}
						this.myNotepadView.model.setContent(result);
						this.myNotepadView.textArea.setText(this.myNotepadView.model.getContent());
					} catch (Exception E) {
						E.printStackTrace();
					}
				} else {
					this.myNotepadView.textArea.setText("Khong dung dinh dang file");
				}
			}
		} else if (command.equals("Save")) {
			if (this.myNotepadView.model.getFileName().length() > 0) {
				save(this.myNotepadView.model.getFileName());
			} else {
				// Tao cua so de luu file lai
				int returnVal = fc.showSaveDialog(this.myNotepadView);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					save(file.getAbsolutePath());
				}

			}
		}
		}

	public void save(String fileName) {
		try {
			PrintWriter PW = new PrintWriter(fileName, "UTF-8");
			String date = myNotepadView.textArea.getText();
			PW.print(date);
			PW.flush();
			PW.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
	}
	}

