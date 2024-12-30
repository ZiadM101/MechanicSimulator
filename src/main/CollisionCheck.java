package main;
import entity.Entity;;

public class CollisionCheck {
    GamePanel gamePanel;
    public CollisionCheck(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gamePanel.tileSize;
        int entityRightCol = entityRightWorldX / gamePanel.tileSize;
        int entityTopRow = entityTopWorldY / gamePanel.tileSize;
        int entityBottomRow = entityBottomWorldY / gamePanel.tileSize;

        int tileNum1,tileNum2;
        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tilemanager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tilemanager.mapTileNum[entityRightCol][entityTopRow];
                if(gamePanel.tilemanager.tile[tileNum1].collision || gamePanel.tilemanager.tile[tileNum2].collision){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tilemanager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gamePanel.tilemanager.mapTileNum[entityRightCol][entityBottomRow];
                if(gamePanel.tilemanager.tile[tileNum1].collision || gamePanel.tilemanager.tile[tileNum2].collision){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tilemanager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tilemanager.mapTileNum[entityLeftCol][entityBottomRow];
                if(gamePanel.tilemanager.tile[tileNum1].collision || gamePanel.tilemanager.tile[tileNum2].collision){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tilemanager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gamePanel.tilemanager.mapTileNum[entityRightCol][entityBottomRow];
                if(gamePanel.tilemanager.tile[tileNum1].collision || gamePanel.tilemanager.tile[tileNum2].collision){
                    entity.collisionOn = true;
                }
                break;
        }
    }
}
