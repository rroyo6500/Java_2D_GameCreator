package Tools.Methods;

import GameEditor.GameEditor;
import Tools.Entities.Player;
import Tools.World.Platform;

public class Collide {

    public Collide(){}

    public void Player_Collide(Player player, Platform platform){
        if (CollideDown(player, platform)){
            player.setVelocity(player.getVelocityX(), 0);
            player.setY((platform.getY() + platform.getHeight()));
        } else if (CollideUp(player, platform)){
            player.setVelocity(player.getVelocityX(), 0);
            player.setY(platform.getY() - player.getHeight());
        } else if (CollideLeft(player, platform)){
            player.setVelocity(0, player.getVelocityY());
            player.setX(platform.getX() - player.getWidth());
        } else if (CollideRight(player, platform)){
            player.setVelocity(0, player.getVelocityY());
            player.setX((platform.getX() + platform.getWidth()));
        }
    }

    public boolean Player_Collide_B(Player player, Platform platform){
        return (
                CollideDown(player, platform) ||
                CollideUp(player, platform) ||
                CollideLeft(player, platform) ||
                CollideRight(player, platform)
                );
    }

    private boolean CollideDown(Player player, Platform platform){
        return (
                (player.getY() <= (platform.getY() + platform.getHeight())) &&
                (player.getY() >= ((platform.getY() + platform.getHeight()) - player.getVelocityY())) &&
                ((player.getCenter("X") - (double) (player.getWidth()) / 2) <= (platform.getX() + platform.getWidth())) &&
                (player.getCenter("X") + ((double) player.getWidth() / 2) >= platform.getX())
        );
    }
    private boolean CollideUp(Player player, Platform platform){
        return (
                ((player.getY() + player.getHeight()) >= platform.getY()) &&
                ((player.getY() + player.getHeight()) <= (platform.getY() + player.getVelocityY())) &&
                ((player.getCenter("X") - (double) (player.getWidth()) / 2) <= (platform.getX() + platform.getWidth())) &&
                (player.getCenter("X") + ((double) player.getWidth() / 2) >= platform.getX())
        );
    }
    private boolean CollideLeft(Player player, Platform platform){
        return (
                ((player.getX() + player.getWidth()) >= platform.getX()) &&
                ((player.getX() + player.getWidth()) <= (platform.getX() + player.getVelocityX())) &&
                ((player.getCenter("Y") - (double) (player.getHeight()) / 2) <= (platform.getY() + platform.getHeight())) &&
                (player.getCenter("Y") + ((double) player.getHeight() / 2) >= platform.getY())
        );
    }
    private boolean CollideRight(Player player, Platform platform){
        return (
                (player.getX() <= (platform.getX() + platform.getWidth())) &&
                (player.getX() >= ((platform.getX() + platform.getWidth()) - player.getVelocityX())) &&
                ((player.getCenter("Y") - (double) (player.getHeight()) / 2) <= (platform.getY() + platform.getHeight())) &&
                (player.getCenter("Y") + ((double) player.getHeight() / 2) >= platform.getY())
        );
    }

}
