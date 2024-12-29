package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int[][] mapTileNum;
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[3];// the number of different tiles you could have
        mapTileNum = new int[MapAttributes.MAX_WORLD_COL.getIntValue()][MapAttributes.MAX_WORLD_ROW.getIntValue()];// changing constant at a later date.
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

            while(col < MapAttributes.MAX_WORLD_COL.getIntValue() && row < MapAttributes.MAX_WORLD_ROW.getIntValue()){
                String line = br.readLine();

                while(col < MapAttributes.MAX_WORLD_COL.getIntValue()){
                   String[] numbers = line.split(" ");
                   int num = Integer.parseInt(numbers[col]);
                   mapTileNum[row][col] = num;
                   col ++;
                }
                if (col == MapAttributes.MAX_WORLD_COL.getIntValue()){
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

       while(worldCol < MapAttributes.MAX_WORLD_COL.getIntValue() && worldRow < MapAttributes.MAX_WORLD_ROW.getIntValue()){
           int tileNum = mapTileNum[worldRow][worldCol];

           int worldX = worldCol * gp.tileSize;
           int worldY = worldRow * gp.tileSize;
           int screenY;
           int screenX;



           if (gp.player.getScreenBorderRight() >= MapAttributes.RIGHT_BORDER.getIntValue() ) {
               screenX = worldX - (MapAttributes.RIGHT_BORDER.getIntValue() - gp.player.centerScreenX * 2);
               screenY = worldY - gp.player.worldY + gp.player.screenY;
               gp.player.screenX = gp.player.worldX - (MapAttributes.RIGHT_BORDER.getIntValue() - gp.player.centerScreenX * 2);;
           }
           if (gp.player.getScreenBorderLeft() <= MapAttributes.LEFT_BORDER.getIntValue() ) {
               screenX = worldX;
               screenY = worldY - gp.player.worldY + gp.player.screenY;
               gp.player.screenX = gp.player.worldX;
           }
           if (gp.player.getScreenBorderBottom() >= MapAttributes.BOTTOM_BORDER.getIntValue() ) {
               screenY = worldY - (MapAttributes.BOTTOM_BORDER.getIntValue() - gp.player.centerScreenY * 2);
               screenX = worldX - gp.player.worldX + gp.player.screenX;
               gp.player.screenY = gp.player.worldY - (MapAttributes.BOTTOM_BORDER.getIntValue() - gp.player.centerScreenY* 2);
           }


           if (gp.player.getScreenBorderTop() <= MapAttributes.TOP_BORDER.getIntValue() ) {
               screenY = worldY;
               screenX = worldX - gp.player.worldX + gp.player.screenX;
               gp.player.screenY = gp.player.worldY;
           }

           else {
               screenX = worldX - gp.player.worldX + gp.player.screenX;
               screenY = worldY - gp.player.worldY + gp.player.screenY;
           }

           g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
           worldCol ++;


           if (worldCol == MapAttributes.MAX_WORLD_COL.getIntValue()){
               worldCol = 0;
               worldRow ++;

           }
       }

    }
}
