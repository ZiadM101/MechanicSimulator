import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    protected final int originalTileBase = 32; // 32 * 32 pixels for each tile (graphic)
    protected final double tileScale = 1.5; // Graphic will be scaled by 1.5 to fit screen
    protected final int tileSize = (int) (originalTileBase * tileScale); // The full tile size will be 48 * 48 pixels
    protected final int maxScreenCol = 16; // 16 columns of tiles
    protected final int maxScreenRow = 12; // 12 rows of tiles
    protected final int screenWidth = (int) tileSize * maxScreenCol; // How many columns of pixels = 768
    protected final int screenHeight = (int) tileSize * maxScreenRow; // How many rows of pixels = 576

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;

    //FPS


    public final int FPS = 60;
    //Default Player position


    public int playerX = 100;
    public int playerY = 100;
    public int playerSpeed = 4;
    public GamePanel() {

        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addKeyListener(keyHandler);
        setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {

        double drawInterval = 1000000000.0f / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread.isAlive()) {
            update();


            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000.0f;

                if (remainingTime < 0.0f) {
                    remainingTime =0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);

        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.dispose();
    }

    protected void update() {
        if (keyHandler.upPressed) {
            playerY -= playerSpeed;
        }

        else if (keyHandler.downPressed) {
            playerY += playerSpeed;
        }
        else if (keyHandler.leftPressed) {
            playerX -= playerSpeed;
        }
        else if (keyHandler.rightPressed) {
            playerX += playerSpeed;
        }
    }
}
