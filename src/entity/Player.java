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
        speed = 3;
        direction = "resting";
    }

    public void update() { // Update player position

        if (keyHandler.downPressed || keyHandler.leftPressed || keyHandler.rightPressed || keyHandler.upPressed) {
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
            } else {
                direction = "right";
                if (x + speed + gamePanel.tileSize <= gamePanel.screenWidth) { // Prevent moving right past the right border
                    x += speed;
                }
            }
            spriteCounter++;
            if (spriteCounter > 7) {
                spriteNumber = (spriteNumber + 1) % 9;
                spriteCounter = 0;
            }
        }

        else {
            spriteNumber = -1;
        }

    }
    public void draw(Graphics2D  g2) {
        BufferedImage image = null;



        if (direction.equals("up")) {

            if (spriteNumber == -1) {
                image = up1;
            }
            if (spriteNumber == 0) {
                image = up6;
            }
            else if (spriteNumber == 1) {
                image = up2;

            }

            else if (spriteNumber == 2) {
                image = up3;
            }

            else if (spriteNumber == 3) {
                image = up4;
            }

            else if (spriteNumber == 4) {
                image = up5;
            }

            else if (spriteNumber == 5) {
                image = up6;
            }

            else if (spriteNumber == 6) {
                image = up7;
            }

            else if (spriteNumber == 7) {
                image = up8;
            }

            else if (spriteNumber == 8) {
                image = up9;
            }
        }

        else if (direction.equals("right")) {
            if (spriteNumber == -1) {
                image = right1;
            }
            else if (spriteNumber == 0) {
                image = right1;

            }
            else if (spriteNumber == 1) {
                image = right2;
            }
            else if (spriteNumber == 2) {
                image = right3;
            }
            else if (spriteNumber == 3) {
                image = right4;
            }
            else if (spriteNumber == 4) {
                image = right5;
            }
            else if (spriteNumber == 5) {
                image = right6;
            }
            else if (spriteNumber == 6) {
                image = right7;
            }
            else if (spriteNumber == 7) {
                image = right8;

            }
            else if (spriteNumber == 8) {
                image = right9;
            }
        }

        else if (direction.equals("left")) {
            if (spriteNumber == -1) {
                image = left1;
            }
            else if (spriteNumber == 0) {
                image = left1;

            }

            else if (spriteNumber == 1) {
                image = left2;
            }
            else if (spriteNumber == 2) {
                image = left3;
            }
            else if (spriteNumber == 3) {
                image = left4;
            }
            else if (spriteNumber == 4) {
                image = left5;
            }
            else if (spriteNumber == 5) {
                image = left6;
            }
            else if (spriteNumber == 6) {
                image = left7;
            }
            else if (spriteNumber == 7) {
                image = left8;
            }
            else if (spriteNumber == 8) {
                image = left9;
            }
        }

        else  {
            if (spriteNumber == -1) {
                image = down1;
            }
            else if (spriteNumber == 0) {
                image = down6;

            }
            else if (spriteNumber == 1) {
                image = down2;

            }

            else if (spriteNumber == 2) {
                image = down3;
            }

            else if (spriteNumber == 3) {
                image = down4;
            }

            else if (spriteNumber == 4) {
                image = down5;
            }

            else if (spriteNumber == 5) {
                image = down6;
            }

            else if (spriteNumber == 6) {
                image = down7;
            }

            else if (spriteNumber == 7) {
                image = down8;
            }

            else if (spriteNumber == 8) {
                image = down9;
            }
        }


        g2.drawImage(image, x, y, gamePanel.tileSize * 2, gamePanel.tileSize * 2, null);
    }

    public void getPlayerImage() {
        try {
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown4.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown5.png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown6.png"));
            down7 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown7.png"));
            down8 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown8.png"));
            down9 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown9.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp5.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp6.png"));
            up7 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp7.png"));
            up8 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp8.png"));
            up9 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp9.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft5.png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft6.png"));
            left7 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft7.png"));
            left8 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft8.png"));
            left9 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft9.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight5.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight6.png"));
            right7 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight7.png"));
            right8 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight8.png"));
            right9 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight9.png"));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
