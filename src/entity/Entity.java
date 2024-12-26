package entity;

import main.GamePanel;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;
    public BufferedImage down1, down2, up1, up2;
    public String direction = "down";
    public int spriteCounter =0;
    public int spriteNumber =0;
    GamePanel gamePanel;
}
