package main;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        GamePanel gamePanel = new GamePanel();
        gameWindow.add(gamePanel);

        SwingUtilities.invokeLater(() -> {

            gameWindow.setVisible(true);
        });

        gamePanel.startGameThread();
    }
}