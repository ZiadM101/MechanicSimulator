package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
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

    public void update() { // Update player position
        if (keyHandler.upPressed) {
            direction = "up";
            if (y - speed >= 0) { // Prevent moving above the top border
                y -= speed;
            }
        } else if (keyHandler.downPressed) {
            direction = "down";
            if (y + speed + gamePanel.tileSize <= gamePanel.screenHeight) { // Prevent moving below the bottom border
                y += speed;
            }
        } else if (keyHandler.leftPressed) {
            direction = "left";
            if (x - speed >= 0) { // Prevent moving left past the left border
                x -= speed;
            }
        } else if (keyHandler.rightPressed) {
            direction = "right";
            if (x + speed + gamePanel.tileSize <= gamePanel.screenWidth) { // Prevent moving right past the right border
                x += speed;
            }
        }
        spriteCounter++;
        if (spriteCounter > 20) {
            spriteNumber = (spriteNumber + 1) % 2;
            spriteCounter = 0;
        }
    }
    public void draw(Graphics2D  g2) {
        BufferedImage image = null;

        if (direction.equals("up")) {
            if (spriteNumber == 0) {
                image = up1;
            }
            else {
                image = up2;

            }
        }

        else if (direction.equals("right")) {
            if (spriteNumber == 0) {
                image = right1;
            }
            else {
                image = right2;

            }
        }

        else if (direction.equals("left")) {
            if (spriteNumber == 0) {
                image = left1;
            }
            else {
                image = left2;

            }
        }

        else {
            if (spriteNumber == 0) {
                image = down1;
            }
            else {
                image = down2;

            }
        }


        g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }

    public void getPlayerImage() {
        try {
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/playerResting1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/playerResting2.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight2.png"));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
