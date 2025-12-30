import javax.swing.JFrame;

public class CarRacingGame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Racing Game");
        GamePanel game = new GamePanel();

        frame.add(game);
        frame.setSize(400, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
