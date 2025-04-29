import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Game");
        GamePanel panel = new GamePanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class GamePanel extends JPanel implements ActionListener, KeyListener {

    final int WIDTH = 800, HEIGHT = 600;
    Timer timer;
    Paddle paddle1, paddle2;
    Ball ball;
    int score1 = 0, score2 = 0;

    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(this);

        paddle1 = new Paddle(20, HEIGHT / 2 - 50);
        paddle2 = new Paddle(WIDTH - 40, HEIGHT / 2 - 50);
        ball = new Ball(WIDTH / 2, HEIGHT / 2);

        timer = new Timer(10, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // Paddles and Ball
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);

        // Middle line
        g.setColor(Color.GRAY);
        g.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);

        // Scores
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 36));
        g.drawString(String.valueOf(score1), WIDTH / 4, 50);
        g.drawString(String.valueOf(score2), WIDTH * 3 / 4, 50);
    }

    public void move() {
        paddle1.move(HEIGHT);
        paddle2.move(HEIGHT);
        ball.move();

        // Bounce off top/bottom
        if (ball.y <= 0 || ball.y >= HEIGHT - ball.size) {
            ball.dy = -ball.dy;
        }

        // Paddle collision
        if (ball.getBounds().intersects(paddle1.getBounds()) || ball.getBounds().intersects(paddle2.getBounds())) {
            ball.dx = -ball.dx;
        }

        // Scoring
        if (ball.x <= 0) {
            score2++;
            ball.reset(WIDTH / 2, HEIGHT / 2);
        } else if (ball.x >= WIDTH - ball.size) {
            score1++;
            ball.reset(WIDTH / 2, HEIGHT / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    // Key controls
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) paddle1.setUp(true);
        if (code == KeyEvent.VK_S) paddle1.setDown(true);
        if (code == KeyEvent.VK_UP) paddle2.setUp(true);
        if (code == KeyEvent.VK_DOWN) paddle2.setDown(true);
    }

    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) paddle1.setUp(false);
        if (code == KeyEvent.VK_S) paddle1.setDown(false);
        if (code == KeyEvent.VK_UP) paddle2.setUp(false);
        if (code == KeyEvent.VK_DOWN) paddle2.setDown(false);
    }

    public void keyTyped(KeyEvent e) {}
}

class Paddle {
    int x, y;
    int width = 20, height = 100;
    int speed = 5;
    boolean up, down;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    public void move(int panelHeight) {
        if (up && y > 0) y -= speed;
        if (down && y < panelHeight - height) y += speed;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}

class Ball {
    int x, y;
    int size = 20;
    int dx = 4, dy = 4;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, size, size);
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }

    public void reset(int x, int y) {
        this.x = x;
        this.y = y;
        dx = -dx;
    }
}
