package Yelp_View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class YelpAdvertisementView {
    private static final String[] IMAGE_PATHS = {"img1.jpg", "img2.jpg", "img3.jpg"}; // Đường dẫn của các ảnh
    private static final int DELAY = 1000; // Độ trễ giữa các lần đổi ảnh (ms)

    private JLabel imageLabel;
    private int currentImageIndex = 0;

    public YelpAdvertisementView() {
        JFrame frame = new JFrame("Image Label Timer Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLabel = new JLabel();
        updateImage(); // Cập nhật ảnh đầu tiên

        Timer timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndex = (currentImageIndex + 1) % IMAGE_PATHS.length; // Chuyển đến ảnh tiếp theo
                updateImage(); // Cập nhật ảnh mới
            }
        });
        timer.start(); // Bắt đầu Timer

        frame.getContentPane().add(imageLabel);
        frame.pack();
        frame.setVisible(true);
    }

    private void updateImage() {
        ImageIcon icon = new ImageIcon(getClass().getResource(IMAGE_PATHS[currentImageIndex])); // Tạo ImageIcon từ đường dẫn
        imageLabel.setIcon(icon); // Đặt ImageIcon cho JLabel
    }
}
