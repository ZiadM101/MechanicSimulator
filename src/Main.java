//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        GamePanel gamePanel = new GamePanel();
        gameWindow.add(gamePanel);
        //Hello
        SwingUtilities.invokeLater(() -> {

            gameWindow.setVisible(true);
        });

        gamePanel.startGameThread();


        //TestEdit

        
    }
}