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
                ((player.getCenter()[1] - ((double) player.getHeight() / 2)) <= (platform.getY() + platform.getHeight())) &&
                ((player.getCenter()[1] - ((double) player.getHeight() / 2)) >= (platform.getCenter()[1]) &&
                ((player.getCenter()[0] - (double) (player.getWidth()) / 2) <= (platform.getX() + platform.getWidth())) &&
                (player.getCenter()[0] + ((double) player.getWidth() / 2) >= platform.getX()))
        );
    }
    private boolean CollideUp(Player player, Platform platform){
        return (
                ((player.getCenter()[1] + ((double) player.getHeight() / 2)) >= platform.getY()) &&
                ((player.getCenter()[1] + ((double) player.getHeight() / 2)) <= (platform.getY() + platform.getHeight())) &&
                ((player.getCenter()[0] - (double) (player.getWidth()) / 2) <= (platform.getX() + platform.getWidth())) &&
                (player.getCenter()[0] + ((double) player.getWidth() / 2) >= platform.getX())
        );
    }
    private boolean CollideLeft(Player player, Platform platform){
        return (
                ((player.getCenter()[0] + ((double) player.getWidth() / 2)) >= platform.getX()) &&
                ((player.getCenter()[0] + ((double) player.getWidth() / 2)) <= platform.getX() + 5) &&
                ((player.getCenter()[1] - (double) (player.getHeight()) / 2) <= (platform.getY() + platform.getHeight())) &&
                (player.getCenter()[1] + ((double) player.getHeight() / 2) >= platform.getY())
        );
    }
    private boolean CollideRight(Player player, Platform platform){
        return (
                ((player.getCenter()[0] - ((double) player.getWidth() / 2)) <= (platform.getX() + platform.getWidth())) &&
                ((player.getCenter()[0] - ((double) player.getWidth() / 2)) >= (platform.getX() + platform.getWidth()) - 5) &&
                ((player.getCenter()[1] - (double) (player.getHeight()) / 2) <= (platform.getY() + platform.getHeight())) &&
                (player.getCenter()[1] + ((double) player.getHeight() / 2) >= platform.getY())
        );
    }

}
