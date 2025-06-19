package Bai5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightSystem1 extends JFrame implements ActionListener {
    private JLabel lightLabel;
    private JButton startButton;
    private Timer timer;
    private int currentLightIndex;

    private final Color[] lightColors = {Color.RED, Color.YELLOW, Color.GREEN};
    private final int[] lightDurations = {5000, 2000, 3000}; // Red: 5s, Yellow: 2s, Green: 3s

    public TrafficLightSystem1() {
        setTitle("Traffic Light Simulator");
        setSize(200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create light label
        lightLabel = new JLabel();
        lightLabel.setOpaque(true);
        lightLabel.setPreferredSize(new Dimension(150, 300));
        lightLabel.setBackground(lightColors[0]); // Set initial color to RED
        add(lightLabel, BorderLayout.CENTER);

        // Create start button
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        add(startButton, BorderLayout.SOUTH);

        // Create timer
        timer = new Timer(lightDurations[0], this); // Initial duration for RED light
        currentLightIndex = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            // Start or stop the simulation
            if (!timer.isRunning()) {
                startButton.setText("Stop");
                timer.start();
            } else {
                startButton.setText("Start");
                timer.stop();
            }
        } else {
            // Change light color
            currentLightIndex = (currentLightIndex + 1) % lightColors.length;
            lightLabel.setBackground(lightColors[currentLightIndex]);
            timer.setDelay(lightDurations[currentLightIndex]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TrafficLightSystem1 simulator = new TrafficLightSystem1();
            simulator.setVisible(true);
        });
    }
}
