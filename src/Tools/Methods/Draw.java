package Tools.Methods;

import Tools.Entities.Enemy;
import Tools.Entities.Player;
import Tools.World.Platform;

import java.awt.*;

public class Draw {

    public Draw(){}

    // Draw

    public Graphics draw(Graphics g, Player player, Color color){

        if (player.getAlive()){
            g.setColor(color);
            g.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        }

        return g;
    }
    public Graphics draw(Graphics g, Player player){

        if (player.getAlive()){
            g.setColor(player.getPlayerColor());
            g.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        }

        return g;
    }

    public Graphics draw(Graphics g, Platform platform, Color color){

        g.setColor(color);
        g.fillRect(platform.getX(), platform.getY(), platform.getWidth(), platform.getHeight());

        return g;
    }
    public Graphics draw(Graphics g, Platform platform){

        g.setColor(platform.getPlatformColor());
        g.fillRect(platform.getX(), platform.getY(), platform.getWidth(), platform.getHeight());

        return g;
    }

    public Graphics draw(Graphics g, Enemy enemy, Color color){

        if (enemy.getAlive()){
            g.setColor(color);
            g.fillRect(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
        }

        return g;
    }
    public Graphics draw(Graphics g, Enemy enemy){

        if (enemy.getAlive()){
            g.setColor(enemy.getEnemyColor());
            g.fillRect(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
        }

        return g;
    }

    // Delete
    public void delete(Player player){player.setAlive(false);}
    public void delete(Enemy enemy){enemy.setAlive(false);}

}
