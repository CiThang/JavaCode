package Bai4;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class MultiClock extends JFrame implements ActionListener, Runnable
{
	JButton createClock = new JButton("new Clock");
	JLabel clock = new JLabel();
	Thread t;
	
	
	
	public MultiClock()
	{
		/*Khoi tao cac thanh phan cua GUI */
		// Co the hieu: container tuong tu nhu jpanel -> chua cac jlabel, jbutton,...
        Container cont = this.getContentPane();
     
        // lay thoi gian hien tai 
        Calendar cal = Calendar.getInstance();
        // dinh dang calendar 
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	clock = new JLabel(sdf.format(cal.getTime()),JLabel.CENTER);
        
    	 /*Thiet lap kich thuoc va mau hien chu hien thi*/
    	clock.setFont(new Font(clock.getFont().getName(), Font.PLAIN, 40));
    	clock.setForeground(Color.RED);
    	
    	// Them cac thanh phan vao cont(Container)
        cont.add(createClock,"North");
    	cont.add(clock);
    	this.pack();
    	this.setVisible(true);
    	
    	createClock.addActionListener(this);
    	
    	/*Bat dau luong dong ho*/
    	Thread t = new Thread(this);
    	t.start();
	}

	 /*Cap nhat lai thoi gian sau 1 giay*/
	public void tick()
	{
		try{
			
	        Calendar cal = Calendar.getInstance();
	    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	    	clock.setText(sdf.format(cal.getTime()));
	
	    	// do tre
			Thread.sleep(1000);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	 /*Tuyen hoat dong*/
	public void run()
	{
		while (true)
		{
	      tick();
		}
		
	}
	 /*Tao mot dong ho moi khi an nut New Clock*/
	public void actionPerformed(ActionEvent e)
	{
		Thread t = new Thread(new MultiClock());
		t.start();
		
	}
	public static void main(String[] a)
	{
		new MultiClock();
	}

}