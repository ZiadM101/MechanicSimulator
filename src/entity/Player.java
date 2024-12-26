package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        //Default x and y values (where the player will initially appear on the screen)
        x = 100;
        y = 100;

        //Default speed
        speed = 4;
        direction = "resting";
    }

    public void update() {
        if (keyHandler.upPressed) {
            y -= speed;
        }

        else if (keyHandler.downPressed) {
            y += speed;
        }
        else if (keyHandler.leftPressed) {
            x -= speed;
        }
        else if (keyHandler.rightPressed) {
            x += speed;
        }
        spriteCounter++;
        if (spriteCounter > 20) {
            spriteNumber = (spriteNumber + 1) % 2;
            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D  g2) {
//        g2.setColor(Color.WHITE);
//
//        g2.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);

        BufferedImage image = null;

        if (spriteNumber == 0) {
            image = resting1;
        }
        else {
            image = resting2;

        }

        g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }

    public void getPlayerImage() {
        try {
            resting1 = ImageIO.read(getClass().getResourceAsStream("/player/playerResting.png"));
            resting2 = ImageIO.read(getClass().getResourceAsStream("/player/playerResting2.png"));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
