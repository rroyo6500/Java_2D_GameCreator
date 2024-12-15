package Tools.Methods;

import Tools.Entities.Enemy;
import Tools.Entities.Player;
import Tools.World.Colectable;
import Tools.World.Platform;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Draw {

    public Draw(){}

    // Draw
    public void draw(Graphics g, Player player, Color color){

        if (player.getAlive()){
            g.setColor(color);
            g.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        }

    }
    public void draw(Graphics g, Player player){

        if (player.getAlive()){
            g.setColor(player.getPlayerColor());
            g.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        }

    }

    public void draw(Graphics g, Platform platform, Color color){

        g.setColor(color);
        g.fillRect(platform.getX(), platform.getY(), platform.getWidth(), platform.getHeight());

    }
    public void draw(Graphics g, Platform platform){

        g.setColor(platform.getPlatformColor());
        g.fillRect(platform.getX(), platform.getY(), platform.getWidth(), platform.getHeight());

    }

    public void draw(Graphics g, Enemy enemy, Color color){

        if (enemy.getAlive()){
            g.setColor(color);
            g.fillRect(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
        }

    }
    public void draw(Graphics g, Enemy enemy){

        if (enemy.getAlive()){
            g.setColor(enemy.getEnemyColor());
            g.fillRect(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
        }

    }

    public void draw(Graphics g, Colectable colectable, Color color){

        if (!colectable.getObtained()){
            g.setColor(color);
            g.fillRect(colectable.getX(), colectable.getY(), colectable.getWidth(), colectable.getHeight());
        }

    }
    public void draw(Graphics g, Colectable colectable){

        if (!colectable.getObtained()){
            g.setColor(colectable.getColectableColor());
            g.fillRect(colectable.getX(), colectable.getY(), colectable.getWidth(), colectable.getHeight());
        }

    }

    // DrawSprites
    public void drawSprites(Graphics g, Player player, BufferedImage sprite){

        g.drawImage(sprite, player.getX(), player.getY(), player.getWidth(), player.getHeight(), null);

    }
    public void drawRotatedSprites(Graphics g, Player player, BufferedImage sprite, String rotation){

        if (rotation.equalsIgnoreCase("x")) {
            int X = (player.getX() + player.getWidth());
            g.drawImage(sprite, X, player.getY(), -player.getWidth(), player.getHeight(), null);
        } else if (rotation.equalsIgnoreCase("y")) {
            int Y = (player.getY() + player.getHeight());
            g.drawImage(sprite, player.getX(), Y, player.getWidth(), -player.getHeight(), null);
        } else if (rotation.equalsIgnoreCase("xy") || rotation.equalsIgnoreCase("yx")) {
            int X = (player.getX() + player.getWidth());
            int Y = (player.getY() + player.getHeight());
            g.drawImage(sprite, X, Y, -player.getWidth(), -player.getHeight(), null);
        }

    }

    // Delete
    public void delete(Player player){
        player.setAlive(false);
        player.setX(-10000000);
        player.setY(-10000000);
    }
    public void delete(Colectable colectable){
        colectable.setObtained(true);
        colectable.setX(-10000000);
        colectable.setY(-10000000);
    }
    public void delete(Enemy enemy){enemy.hit();}

}
