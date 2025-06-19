package Yelp_View;

import javax.swing.*;
import java.awt.*;

public class TEst extends JLabel {
    private Color circleColor;

    public TEst(Color circleColor) {
        this.circleColor = circleColor;
        this.setPreferredSize(new Dimension(50, 50)); // Đặt kích thước cho JLabel
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int diameter = Math.min(getWidth(), getHeight()); // Đường kính của hình tròn là tối thiểu của chiều rộng và chiều cao
        int x = (getWidth() - diameter) / 2; // Tọa độ x của hình tròn
        int y = (getHeight() - diameter) / 2; // Tọa độ y của hình tròn
        g.setColor(circleColor);
        g.fillOval(x, y, diameter, diameter); // Vẽ hình tròn
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Circular JLabel Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            TEst circularLabel = new TEst(Color.RED); // Tạo một JLabel hình tròn màu đỏ
            frame.getContentPane().add(circularLabel);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
