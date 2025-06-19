import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Game2048 extends JFrame implements KeyListener {
    private static final int SIZE = 4;
    private static final int TILE_SIZE = 100;

    private int[][] board;
    private boolean gameOver;

    public Game2048() {
        setTitle("2048 Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SIZE * TILE_SIZE, SIZE * TILE_SIZE);
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(this);

        initGame();

        setVisible(true);
    }

    private void initGame() {
        board = new int[SIZE][SIZE];
        addRandomTile();
        addRandomTile();
        gameOver = false;
    }

    private void addRandomTile() {
        Random random = new Random();
        int value = random.nextDouble() < 0.9 ? 2 : 4;

        int row, col;
        do {
            row = random.nextInt(SIZE);
            col = random.nextInt(SIZE);
        } while (board[row][col] != 0);

        board[row][col] = value;
    }

    private void moveTilesLeft() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE - 1; col++) {
                if (board[row][col] != 0 && board[row][col] == board[row][col + 1]) {
                    board[row][col] *= 2;
                    board[row][col + 1] = 0;
                }
            }
        }
    }

    private void moveTilesRight() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = SIZE - 1; col > 0; col--) {
                if (board[row][col] != 0 && board[row][col] == board[row][col - 1]) {
                    board[row][col] *= 2;
                    board[row][col - 1] = 0;
                }
            }
        }
    }

    private void moveTilesUp() {
        for (int col = 0; col < SIZE; col++) {
            for (int row = 0; row < SIZE - 1; row++) {
                if (board[row][col] != 0 && board[row][col] == board[row + 1][col]) {
                    board[row][col] *= 2;
                    board[row + 1][col] = 0;
                }
            }
        }
    }

    private void moveTilesDown() {
        for (int col = 0; col < SIZE; col++) {
            for (int row = SIZE - 1; row > 0; row--) {
                if (board[row][col] != 0 && board[row][col] == board[row - 1][col]) {
                    board[row][col] *= 2;
                    board[row - 1][col] = 0;
                }
            }
        }
    }

    private void moveTiles(int direction) {
        switch (direction) {
            case KeyEvent.VK_LEFT:
                moveTilesLeft();
                break;
            case KeyEvent.VK_RIGHT:
                moveTilesRight();
                break;
            case KeyEvent.VK_UP:
                moveTilesUp();
                break;
            case KeyEvent.VK_DOWN:
                moveTilesDown();
                break;
        }
        addRandomTile();
    }

    private boolean isGameOver() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    return false;
                }
                if (col < SIZE - 1 && board[row][col] == board[row][col + 1]) {
                    return false;
                }
                if (row < SIZE - 1 && board[row][col] == board[row + 1][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void drawTile(Graphics g, int value, int row, int col) {
        if (value == 0) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        } else {
            g.setColor(getTileColor(value));
            g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            String text = Integer.toString(value);
            FontMetrics fm = g.getFontMetrics();
            int x = col * TILE_SIZE + (TILE_SIZE - fm.stringWidth(text)) / 2;
            int y = row * TILE_SIZE + (TILE_SIZE + fm.getAscent()) / 2;
            g.drawString(text, x, y);
        }
    }

    private Color getTileColor(int value) {
        switch (value) {
            case 2:
                return new Color(0xFFE4C4);
            case 4:
                return new Color(0xFFDAB9);
            case 8:
                return new Color(0xFFC0CB);
            case 16:
                return new Color(0xFFB6C1);
            case 32:
                return new Color(0xFFA07A);
            case 64:
                return new Color(0xFF7F50);
            case 128:
                return new Color(0xFF4500);
            case 256:
                return new Color(0xFF8C00);
            case 512:
                return new Color(0xFFD700);
            case 1024:
                return new Color(0xFFFF00);
            case 2048:
                return new Color(0xFFFFE0);
            default:
                return Color.BLACK;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                drawTile(g, board[row][col], row, col);
            }
        }

        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            String text = "Game Over! Press R to restart";
            FontMetrics fm = g.getFontMetrics();
            int x = (WIDTH - fm.stringWidth(text)) / 2;
            int y = HEIGHT / 2;
            g.drawString(text, x, y);
        }
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new Game2048();
	}
}
