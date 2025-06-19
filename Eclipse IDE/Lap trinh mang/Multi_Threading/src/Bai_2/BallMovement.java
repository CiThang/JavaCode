package Bai_2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;


/*	Nguyên tắc hoạt động
 * - Ban đầu sẽ random ra true/false xong sẽ trả về giá trị 1/-1 rồi nhân với SPEED lúc đó ta sẽ có cặp giá trị (speedX,speedY) = (5,5) or (5,-5) or ..... 
 * Đây là cặp giá trị cố định xuyên suốt chương trình 
 * 
 * - Tiếp theo quả bóng sẽ duy chuyển theo hướng cố định và đến khi chạm vào tường thì lập tức thay đổi dấu của cặp giá trị (speedX,speedY)=>quả bóng di chuyển theo hướng khác 
  */
public class BallMovement extends JFrame {

	private static final int WIDTH = 600;
	private static final int HEIGHT = 400;
	private static final int BALL_RADIUS  = 20;
	private static final int SPEED = 5;
	
	private int ballX, ballY;
	private int speedX, speedY;
	
	public BallMovement() {
		setTitle("Quả bóng di chuyển");
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		BallPanel ballPanel = new BallPanel();
		add(ballPanel);
		
		setVisible(true);
		
		// Khởi tạo vị trí  và tốc độ ban đầu của quả bóng
		resetBall();
		
		// Tạo vào khởi chạy Thread để di chuyển quả bóng
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					updateBallPosition();
					repaint();
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				
			}
		});
		thread.start();
	}
	
	// Tạo hướng di chuyển ngẫu nhiên ban đầu
	private void resetBall() {
		ballX = WIDTH / 2;
		ballY = HEIGHT / 2;
		Random random = new Random();
		// Tốc độ di chuyển ngẫu nhiên tương ứng với hướng ngẫu nhiên
		speedX = SPEED*(random.nextBoolean()?1:-1); 
		speedY = SPEED*(random.nextBoolean()?1:-1);
		
	}
	// Ve qua bong
	class BallPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillOval(ballX, ballY, 2*BALL_RADIUS, 2*BALL_RADIUS);
		}
	}
	private void updateBallPosition() {
		ballX += speedX;
		ballY += speedY;
		// Kiểm tra va chạm với cạnh màn hình
		if(ballX<=0 || ballX >= WIDTH-3*BALL_RADIUS) {
			speedX = -speedX;
		} 
		if(ballY<=0 || ballY >=HEIGHT-4*BALL_RADIUS) {
			speedY =-speedY;
		}
	}
	
	public static void main(String[] args) {
		new BallMovement();
	}
}
