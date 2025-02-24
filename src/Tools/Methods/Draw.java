package Tools.Methods;

import Tools.Entities.Entity;
import Tools.World.Colectable;
import Tools.World.Platform;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Draw {

    public Draw(){}

    // Draw
    public void draw(Graphics g, Entity entity, Color color){

        if (entity.getVisible()){
            g.setColor(color);
            g.fillRect(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());
        }

    }
    public void draw(Graphics g, Entity entity){

        if (entity.getVisible()){
            g.setColor(entity.getPlayerColor());
            g.fillRect(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());
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

    // Draw WithSprite
    public void drawSprite(Graphics g, Entity entity, BufferedImage sprite){

        if (entity.getVisible()){
            g.drawImage(sprite, entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight(), null);
        }

    }

    public void drawSprite(Graphics g, Platform platform, BufferedImage sprite){

        g.drawImage(sprite, platform.getX(), platform.getY(), platform.getWidth(), platform.getHeight(), null);

    }

    public void drawSprite(Graphics g, Colectable colectable, BufferedImage sprite){

        if (!colectable.getObtained()){
            g.drawImage(sprite, colectable.getX(), colectable.getY(), colectable.getWidth(), colectable.getHeight(), null);
        }

    }

    // Delete
    public void delete(Entity entity){
        if (entity.getHP() <= 1){
            entity.setVisible(false);
            entity.setX(-100000000);
            entity.setY(-100000000);
        } else entity.setHP(entity.getHP() - 1);
    }
    public void delete(Colectable colectable){
        colectable.setObtained(true);
        colectable.setX(-10000000);
        colectable.setY(-10000000);
    }

}
