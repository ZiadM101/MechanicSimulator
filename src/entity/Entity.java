package entity;

import main.GamePanel;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Entity {
    public int worldX, worldY;
    public int speed, tempSpeed;
    ArrayList<BufferedImage> upList = new ArrayList<>();
    ArrayList<BufferedImage> leftList = new ArrayList<>();
    ArrayList<BufferedImage> rightList = new ArrayList<>();
    ArrayList<BufferedImage> downList = new ArrayList<>();
    public BufferedImage down1, down2, down3, down4, down5, down6, down7, down8, down9;

    public BufferedImage up1, up2, up3, up4, up5, up6, up7, up8, up9;

    public BufferedImage left1, left2, left3, left4, left5, left6, left7, left8, left9;

    public BufferedImage right1, right2, right3, right4, right5, right6, right7, right8, right9;
    public String direction = "down";
    public int spriteCounter =0;
    public int spriteNumber =0;
    GamePanel gamePanel;


    public void setDefaultValues(int x, int y, int speed, String direction) {

        //Default values (where the player will initially appear on the screen)
        this.worldX = x;
        this.worldY = y;
        this.speed = speed;
        this.direction = direction;
    }

    public void moveLeftBordered() {
        //if (x - speed >= 0) { // Prevent moving left past the left border
        worldX -= speed;
        //}
    }

    public void moveRightBordered() {
        //if (x + speed + gamePanel.tileSize <= gamePanel.screenWidth) { // Prevent moving right past the right border
        worldX += speed;
        //}
    }

    public void moveUpBordered() {
        //if (y - speed >= 0) { // Prevent moving above the top border
        worldY -= speed;
       // }
    }

    public void moveDownBordered() {
        //if (y + speed + gamePanel.tileSize <= gamePanel.screenHeight) { // Prevent moving below the bottom border
        worldY += speed;
        //}
    }

    public void eightFrameSpriteIncrement() {
        spriteCounter++;
        if (spriteCounter > 3) {
            spriteNumber = (spriteNumber + 1) % 8;
            spriteCounter = 0;
        }
    }

    public void stillSprite() {
        spriteNumber = -1;
    }

    public BufferedImage changeSpritePicture(BufferedImage stillSprite, ArrayList<BufferedImage> spriteList) {

        return switch (spriteNumber) {
            case 0 -> spriteList.get(0);
            case 1 -> spriteList.get(1);
            case 2 -> spriteList.get(2);
            case 3 -> spriteList.get(3);
            case 4 -> spriteList.get(4);
            case 5 -> spriteList.get(5);
            case 6 -> spriteList.get(6);
            case 7 -> spriteList.get(7);
            default -> stillSprite;
        };



    }

}
