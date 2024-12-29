package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int[][] mapTileNum;
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[3];// the number of different tiles you could have
        mapTileNum = new int[gp.worldMaxCol][gp.worldMaxRow];// changing constant at a later date.
        getTileImage();
        loadMap("/maps/map.txt");
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
    public void loadMap(String filePath ){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.worldMaxCol && row < gp.worldMaxRow){
                String line = br.readLine();

                while(col < gp.worldMaxCol){
                   String[] numbers = line.split(" ");
                   int num = Integer.parseInt(numbers[col]);
                   mapTileNum[row][col] = num;
                   col ++;
                }
                if (col == gp.worldMaxCol){
                    col = 0;
                    row ++;
                }
            }
        }
        catch (Exception e){
        }
    }

    public void draw(Graphics2D g2){
       int worldCol = 0;
       int worldRow = 0;

       while(worldCol < gp.worldMaxCol && worldRow < gp.worldMaxRow){
           int tileNum = mapTileNum[worldRow][worldCol];

           int worldX = worldCol * gp.tileSize;
           int worldY = worldRow * gp.tileSize;
           int screenX = worldX - gp.player.worldX + gp.player.screenX;
           int screenY = worldY - gp.player.worldY + gp.player.screenY;

           g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
           worldCol ++;


           if (worldCol == 50){
               worldCol = 0;
               worldRow ++;

           }
       }

    }
}
