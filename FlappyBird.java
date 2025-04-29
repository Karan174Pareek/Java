import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {

    int width = 800, height = 600;
    Timer timer;
    int birdY = height / 2;
    int velocity = 0;
    final int gravity = 1;
    final int jump = -12;
    ArrayList<Rectangle> pipes;
    Random rand = new Random();
    int score = 0;
    boolean gameOver = false;

    public FlappyBird() {
        JFrame frame = new JFrame("Flappy Bird");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.addKeyListener(this);

        pipes = new ArrayList<>();
        addPipe(true);
        addPipe(true);
        addPipe(true);
        addPipe(true);

        timer = new Timer(20, this);
        timer.start();
    }

    public void addPipe(boolean start) {
        int space = 200;
        int pipeWidth = 100;
        int pipeHeight = 50 + rand.nextInt(300);

        if (start) {
            int x = width + pipes.size() * 300;
            pipes.add(new Rectangle(x, 0, pipeWidth, pipeHeight));
            pipes.add(new Rectangle(x, pipeHeight + space, pipeWidth, height - pipeHeight - space));
        } else {
            Rectangle lastPipe = pipes.get(pipes.size() - 1);
            int x = lastPipe.x + 300;
            pipes.add(new Rectangle(x, 0, pipeWidth, pipeHeight));
            pipes.add(new Rectangle(x, pipeHeight + space, pipeWidth, height - pipeHeight - space));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background
        g.setColor(Color.cyan);
        g.fillRect(0, 0, width, height);

        // Ground
        g.setColor(Color.orange);
        g.fillRect(0, height - 100, width, 100);

        // Grass
        g.setColor(Color.green);
        g.fillRect(0, height - 110, width, 10);

        // Bird
        g.setColor(Color.red);
        g.fillOval(100, birdY, 30, 30);

        // Pipes
        g.setColor(Color.green.darker());
        for (Rectangle pipe : pipes) {
            g.fillRect(pipe.x, pipe.y, pipe.width, pipe.height);
        }

        // Score
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString("Score: " + score, 20, 50);

        if (gameOver) {
            g.setFont(new Font("Arial", Font.BOLD, 60));
            g.drawString("Game Over", width / 2 - 180, height / 2 - 20);
            g.setFont(new Font("Arial", Font.PLAIN, 30));
            g.drawString("Press R to Restart", width / 2 - 130, height / 2 + 30);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        velocity += gravity;
        birdY += velocity;

        ArrayList<Rectangle> toRemove = new ArrayList<>();
        for (Rectangle pipe : pipes) {
            pipe.x -= 5;

            // Check score
            if (pipe.x + pipe.width == 100) {
                score++;
            }

            // Collision detection
            if (pipe.intersects(new Rectangle(100, birdY, 30, 30))) {
                gameOver = true;
            }

            if (pipe.x + pipe.width < 0) {
                toRemove.add(pipe);
            }
        }

        pipes.removeAll(toRemove);

        if (pipes.size() < 6) {
            addPipe(false);
        }

        if (birdY > height - 130 || birdY < 0) {
            gameOver = true;
        }

        repaint();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !gameOver) {
            velocity = jump;
        }

        if (e.getKeyCode() == KeyEvent.VK_R && gameOver) {
            // Restart game
            birdY = height / 2;
            velocity = 0;
            pipes.clear();
            score = 0;
            gameOver = false;
            addPipe(true);
            addPipe(true);
            addPipe(true);
            addPipe(true);
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new FlappyBird();
    }
}
