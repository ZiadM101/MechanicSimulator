package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gamePanel;
    Tile[] tile;
    int[][] mapTileNum;
    public TileManager(GamePanel gp) {
        this.gamePanel = gp;
        tile = new Tile[3];// the number of different tiles you could have
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];// changing constant at a later date.
        getTileImage();
    }

    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tile/wallTile.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tile/grassTile.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tile/concreteTile.png"));
            // when adding new tiles copy the two lines above
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){


            int worldCol = 0;
            int worldRow = 0;

            while (worldCol < gamePanel.maxWorldCol && worldRow < gamePanel.maxWorldRow){
                int tileNum = mapTileNum[worldCol][worldRow];
                int worldX = worldCol + gamePanel.tileSize;
                int worldY = worldRow + gamePanel.tileSize;
                int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
                int screenY = worldY - gamePanel.player.worldY + gamePanel.player.worldY;

                g2.drawImage(tile[tileNum].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
                worldCol++;

                if (worldCol == gamePanel.maxWorldCol){
                    worldCol = 0;
                    worldRow++;
                }
            }
        }
    public void loadMap(){
        try {
            InputStream is = getClass().getResourceAsStream("/maps/map.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow){
                String line = br.readLine();

                while(col < gamePanel.maxWorldCol){
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[row][col] = num;
                    col ++;
                }
                if (col == gamePanel.maxWorldCol){
                    col = 0;
                    row ++;
                }
            }
        }
        catch (Exception e){
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
