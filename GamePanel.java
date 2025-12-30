import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    Timer timer;
    int playerX = 170;
    int playerY = 450;

    int enemyX = 170;
    int enemyY = 0;

    int score = 0;
    Random rand = new Random();

    public GamePanel() {
        setBackground(Color.BLACK);
        timer = new Timer(15, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Road
        g.setColor(Color.DARK_GRAY);
        g.fillRect(100, 0, 200, 600);

        // Lane lines
        g.setColor(Color.WHITE);
        for (int i = 0; i < 600; i += 40) {
            g.fillRect(195, i, 10, 25);
        }

        // Player car
        g.setColor(Color.RED);
        g.fillRect(playerX, playerY, 40, 70);

        // Enemy car
        g.setColor(Color.BLUE);
        g.fillRect(enemyX, enemyY, 40, 70);

        // Score
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.setColor(Color.YELLOW);
        g.drawString("Score: " + score, 10, 25);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        enemyY += 6;

        if (enemyY > 600) {
            enemyY = -80;
            enemyX = 100 + rand.nextInt(160);
            score++;
        }

        Rectangle player = new Rectangle(playerX, playerY, 40, 70);
        Rectangle enemy = new Rectangle(enemyX, enemyY, 40, 70);

        if (player.intersects(enemy)) {
            timer.stop();
            JOptionPane.showMessageDialog(this,
                    "Game Over!\nYour Score: " + score);
            System.exit(0);
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT && playerX > 100) {
            playerX -= 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && playerX < 260) {
            playerX += 10;
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
