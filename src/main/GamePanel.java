package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //Initialize tile size values and how many tiles are the screen at one time
    public final int originalTileBase = 64; // 32 * 32 pixels for each tile (graphic)
    public final double tileScale = 0.75; // Graphic will be scaled by 1.5 to fit screen
    public final int tileSize = (int) (originalTileBase * tileScale); // The full tile size will be 48 * 48 pixels
    public final int maxScreenCol = 40; // 16 columns of tiles
    public final float maxScreenRow = 22.5f; // 12 rows of tiles
    public final int screenWidth = (int) tileSize * maxScreenCol; // How many columns of pixels = 1920
    public final int screenHeight = (int) (tileSize * maxScreenRow); // How many rows of pixels = 1080

    //Create key handler, thread, and player objects
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    public Player player = new Player(this, keyHandler);
    TileManager tilemanager = new TileManager(this);

    //World Settings
    public final int worldMaxCol = 50;
    public final int worldMaxRow = 50;
    public final int worldWidth = tileSize * worldMaxCol;
    public final int worldHeight = tileSize * worldMaxRow;

    public final int FPS = 60;
    //Default Player position


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
            player.update();


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

        tilemanager.draw(g2);
        player.draw(g2);

        g2.dispose();
    }



}
