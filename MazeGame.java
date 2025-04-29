import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MazeGame extends JPanel {

    final int rows = 10, cols = 10;
    final int cellSize = 60;
    int[][] maze = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 1, 0, 1},
        {1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
        {1, 0, 1, 1, 1, 0, 1, 0, 1, 1},
        {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
        {1, 1, 1, 0, 1, 1, 1, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
    };

    int playerX = 1, playerY = 1;

    public MazeGame() {
        setPreferredSize(new Dimension(cols * cellSize, rows * cellSize));
        setBackground(Color.WHITE);

        // Key listener
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                int nextX = playerX, nextY = playerY;

                if (key == KeyEvent.VK_UP) nextY--;
                if (key == KeyEvent.VK_DOWN) nextY++;
                if (key == KeyEvent.VK_LEFT) nextX--;
                if (key == KeyEvent.VK_RIGHT) nextX++;

                if (isValidMove(nextX, nextY)) {
                    playerX = nextX;
                    playerY = nextY;
                    repaint();

                    if (playerX == cols - 2 && playerY == rows - 2) {
                        JOptionPane.showMessageDialog(null, "🎉 You reached the goal!");
                    }
                }
            }
        });

        setFocusable(true);
    }

    public boolean isValidMove(int x, int y) {
        return x >= 0 && y >= 0 && x < cols && y < rows && maze[y][x] == 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw maze
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (maze[y][x] == 1) {
                    g.setColor(Color.BLACK); // Wall
                } else {
                    g.setColor(Color.WHITE); // Path
                }
                g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                g.setColor(Color.GRAY);
                g.drawRect(x * cellSize, y * cellSize, cellSize, cellSize);
            }
        }

        // Goal
        g.setColor(Color.RED);
        g.fillRect((cols - 2) * cellSize, (rows - 2) * cellSize, cellSize, cellSize);

        // Player
        g.setColor(Color.GREEN);
        g.fillOval(playerX * cellSize + 10, playerY * cellSize + 10, cellSize - 20, cellSize - 20);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Maze Game - Use Arrow Keys");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MazeGame());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
