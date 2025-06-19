package Dongcuaso;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JFrame Example");

        // Thêm WindowListener để theo dõi sự kiện đóng cửa sổ
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        frame,
                        "Bạn có chắc muốn đóng cửa sổ?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    // Đóng ứng dụng khi người dùng chọn "Yes"
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    // Ngăn chặn đóng cửa sổ khi người dùng chọn "No"
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

        // Cài đặt kích thước và hiển thị JFrame
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
