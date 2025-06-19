package Bai_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FlappyBird extends JPanel implements KeyListener {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int BIRD_SIZE = 20;
    private static final int PIPE_WIDTH = 50;
    private static final int PIPE_GAP = 200;

    private int birdY;
    private int birdVelocity;
    private int pipeX;
    private int pipeY;

    private Timer timer;

    public FlappyBird() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.CYAN);
        setFocusable(true);
        addKeyListener(this);

        birdY = HEIGHT / 2;
        birdVelocity = 0;
        pipeX = WIDTH;
        pipeY = (int) (Math.random() * (HEIGHT - PIPE_GAP));

        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGame();
                repaint();
            }
        });
        timer.start();
    }

    private void updateGame() {
        birdVelocity += 1;
        birdY += birdVelocity;

        if (birdY <= 0 || birdY + BIRD_SIZE >= HEIGHT) {
            gameOver();
        }

        pipeX -= 2;
        if (pipeX <= 0) {
            pipeX = WIDTH;
            pipeY = (int) (Math.random() * (HEIGHT - PIPE_GAP));
        }

        if (birdY <= pipeY || birdY + BIRD_SIZE >= pipeY + PIPE_GAP) {
            if (pipeX <= BIRD_SIZE) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        timer.stop();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(50, birdY, BIRD_SIZE, BIRD_SIZE);

        g.setColor(Color.GRAY);
        g.fillRect(pipeX, 0, PIPE_WIDTH, pipeY);
        g.fillRect(pipeX, pipeY + PIPE_GAP, PIPE_WIDTH, HEIGHT - pipeY - PIPE_GAP);

        if (timer.isRunning() == false) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            String gameOverText = "Game Over";
            FontMetrics fontMetrics = g.getFontMetrics();
            int x = (WIDTH - fontMetrics.stringWidth(gameOverText)) / 2;
            int y = HEIGHT / 2;
            g.drawString(gameOverText, x, y);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            birdVelocity = -10;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");
        FlappyBird game = new FlappyBird();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
