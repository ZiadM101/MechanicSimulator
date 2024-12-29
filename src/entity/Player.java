package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        super.setDefaultValues(PlayerAttributes.START_X.getIntValue(), PlayerAttributes.START_Y.getIntValue(),PlayerAttributes.START_SPEED.getIntValue(), PlayerAttributes.START_DIRECTION.getStringValue());
        getPlayerImage();
        screenX = (gamePanel.tileSize * 30) / 2 ;
        screenY = (gamePanel.tileSize * 14) / 2;
    }



    public void update() { // Update player position

        if (keyHandler.downPressed || keyHandler.leftPressed || keyHandler.rightPressed || keyHandler.upPressed) {
            if (keyHandler.upPressed && keyHandler.leftPressed) {
                direction = "up";
                tempSpeed = speed;
                speed = (int) (speed * 0.75);
                moveUpBordered();
                moveLeftBordered();
                speed = tempSpeed;
            }
            else if (keyHandler.upPressed && keyHandler.rightPressed) {
                direction = "up";
                tempSpeed = speed;
                speed = (int) (speed * 0.75);
                moveRightBordered();
                moveUpBordered();
                speed = tempSpeed;
            }

            else if (keyHandler.downPressed && keyHandler.leftPressed) {
                direction = "down";
                tempSpeed = speed;
                speed = (int) (speed * 0.75);
                moveLeftBordered();
                moveDownBordered();
                speed = tempSpeed;
            }

            else if (keyHandler.downPressed && keyHandler.rightPressed) {
                direction = "down";
                tempSpeed = speed;
                speed = (int) (speed * 0.75);
                moveDownBordered();
                moveRightBordered();
                speed = tempSpeed;
            }
            else if (keyHandler.upPressed) {
                direction = "up";
                moveUpBordered();
            } else if (keyHandler.downPressed) {
                direction = "down";
                moveDownBordered();
            } else if (keyHandler.leftPressed) {
                direction = "left";
                moveLeftBordered();
            } else {
                direction = "right";
                super.moveRightBordered();

            }
            eightFrameSpriteIncrement();
        }

        else {
            stillSprite();
        }
    }
    public void draw(Graphics2D  g2) {
        BufferedImage image = null;


        switch (direction) {
            case "up" -> image = changeSpritePicture(up1, upList);
            case "right" -> image =changeSpritePicture(right1, rightList);
            case "left" -> image =changeSpritePicture(left1, leftList);
            default -> image =changeSpritePicture(down1, downList);//down


        }
        g2.drawImage(image, screenX, screenY, gamePanel.tileSize * PlayerAttributes.PLAYER_SCALE.getIntValue(), gamePanel.tileSize * PlayerAttributes.PLAYER_SCALE.getIntValue(), null);
    }

    public void getPlayerImage() {
        try {
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown2.png"));
            downList.add(down2);
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown3.png"));
            downList.add(down3);
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown4.png"));
            downList.add(down4);
            down5 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown5.png"));
            downList.add(down5);
            down6 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown6.png"));
            downList.add(down6);
            down7 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown7.png"));
            downList.add(down7);
            down8 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown8.png"));
            downList.add(down8);
            down9 = ImageIO.read(getClass().getResourceAsStream("/player/playerDown9.png"));
            downList.add(down9);
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp2.png"));
            upList.add(up2);
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp3.png"));
            upList.add(up3);
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp4.png"));
            upList.add(up4);
            up5 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp5.png"));
            upList.add(up5);
            up6 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp6.png"));
            upList.add(up6);
            up7 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp7.png"));
            upList.add(up7);
            up8 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp8.png"));
            upList.add(up8);
            up9 = ImageIO.read(getClass().getResourceAsStream("/player/playerUp9.png"));
            upList.add(up9);
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft1.png"));
            leftList.add(left1);
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft2.png"));
            leftList.add(left2);
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft3.png"));
            leftList.add(left3);
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft4.png"));
            leftList.add(left4);
            left5 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft5.png"));
            leftList.add(left5);
            left6 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft6.png"));
            leftList.add(left6);
            left7 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft7.png"));
            leftList.add(left7);
            left8 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft8.png"));
            leftList.add(left8);
            left9 = ImageIO.read(getClass().getResourceAsStream("/player/playerLeft9.png"));
            leftList.add(left9);
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight1.png"));
            rightList.add(right1);
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight2.png"));
            rightList.add(right2);
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight3.png"));
            rightList.add(right3);
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight4.png"));
            rightList.add(right4);
            right5 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight5.png"));
            rightList.add(right5);
            right6 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight6.png"));
            rightList.add(right6);
            right7 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight7.png"));
            rightList.add(right7);
            right8 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight8.png"));
            rightList.add(right8);
            right9 = ImageIO.read(getClass().getResourceAsStream("/player/playerRight9.png"));
            rightList.add(right9);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
