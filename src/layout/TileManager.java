package layout;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[3];// the number of different tiles you could have
        getTileImage();
    }

    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/gamelayout/wallTile.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/gamelayout/grasstile.png"));
            // when adding new tiles copy the two lines above
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        // Vertical lines of stone
        drawVerticalLine(g2, tile[0].image, 448, 278, 5, gp.tileSize);
        drawVerticalLine(g2, tile[0].image, 800, 278, 5, gp.tileSize);
        // Horizontal lines of stone
        drawHorizontalLine(g2, tile[0].image, 448, 228, -12, gp.tileSize); // Left side
        drawHorizontalLine(g2, tile[0].image, 800, 228, 16, gp.tileSize); // Right side

        drawHorizontalLine(g2,tile[0].image,0,60,30,gp.tileSize);
        drawVerticalLine(g2,tile[1].image,560,0,20,gp.tileSize);

        // Vertical lines of grass Left side
        for (int i = 400; i >= 0; i-=50) {
            drawVerticalLine(g2, tile[1].image, i, 278, 5, gp.tileSize);
        }
        // Vertical lines of grass right side
        for (int i = 1500; i >= 850; i-=50) {
            drawVerticalLine(g2, tile[1].image, i, 278, 5, gp.tileSize);
        }
    }

    // Helper method for vertical lines
    private void drawVerticalLine(Graphics2D g2, Image image, int x, int startY, int count, int tileSize) {
        for (int i = 0; i < count; i++) {
            g2.drawImage(image, x, startY + (i * tileSize), tileSize, tileSize, null);
        }
    }

// Helper method for horizontal lines
    private void drawHorizontalLine(Graphics2D g2, Image image, int startX, int y, int count, int tileSize) {
        for (int i = 0; i < Math.abs(count); i++) {
            int x = startX + (i * tileSize * (count > 0 ? 1 : -1));
            g2.drawImage(image, x, y, tileSize, tileSize, null);
        }
    }
}
