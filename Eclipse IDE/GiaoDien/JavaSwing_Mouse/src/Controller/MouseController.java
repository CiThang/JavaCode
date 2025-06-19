package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import View.MouseView;

public class MouseController implements MouseListener, MouseMotionListener {

	private MouseView mouseView;
	
	public MouseController(MouseView mouseView) {
		this.mouseView = mouseView;
	}

	@Override
	// Khi click chuột thì mình phải làm gì
	public void mouseClicked(MouseEvent e) {
		this.mouseView.click();
		
	}

	@Override
	// Khi nhấn và giữ chuột thì mình phải làm gì
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	// Khi không còn giữ chuột nữa thì mình phải làm gì 
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	// Khi chuột đi vào khu vực quy định thì mình phải làm gì 
	public void mouseEntered(MouseEvent e) {
		this.mouseView.enter();
		
		int x = e.getX();
		int y = e.getY();
		this.mouseView.update(x,y);
	}

	@Override
	// Khi chuột đi ra khỏi khu vực quy định thì mình phải làm gì 
	public void mouseExited(MouseEvent e) {
		this.mouseView.exit();
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		this.mouseView.update(x,y);
		
	}

}
