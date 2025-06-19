package Yelp_Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Yelp_View.YelpMainView;
import Yelp_View.YelpRegisterView;
import Yelp_View.YelpSignInView;

public class YelpMainController implements ActionListener{
	
	public YelpMainView mainView;

	public YelpMainController(YelpMainView mainView) {
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String luachon = e.getActionCommand();
		
		if(luachon=="Thoát") {
			mainView.setVisible(false);
			mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}  else if(luachon=="Hủy") {
			mainView.xoaForm();
		} else if(luachon=="Thêm mới") {
			mainView.taoBaiDang();
		}
		
	}
	

}
