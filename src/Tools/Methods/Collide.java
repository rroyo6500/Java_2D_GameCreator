package Tools.Methods;

import Tools.Entities.Enemy;
import Tools.Entities.Player;
import Tools.World.Platform;

public class Collide {

    public Collide(){}

    // Player - Platform
    public boolean collide(Player player, Platform platform, String ColisionType){
        boolean R = false;
        if (ColisionType.equalsIgnoreCase("down") || ColisionType.equalsIgnoreCase("all")){
            if (collideDown(player, platform)){
                R = true;
                player.setVelocity(0, 0);
                player.setY((platform.getY() + platform.getHeight()));
            }
        }
        if (ColisionType.equalsIgnoreCase("up") || ColisionType.equalsIgnoreCase("all")){
            if (collideUp(player, platform)){
                R = true;
                player.setVelocity(0, 0);
                player.setY(platform.getY() - player.getHeight());
            }
        }
        if (ColisionType.equalsIgnoreCase("left") || ColisionType.equalsIgnoreCase("all")){
            if (collideLeft(player, platform)){
                R = true;
                player.setVelocity(0, 0);
                player.setX(platform.getX() - player.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")){
            if (collideRight(player, platform)){
                R = true;
                player.setVelocity(0, 0);
                player.setX((platform.getX() + platform.getWidth()));
            }
        }
        return R;
    }

    private boolean collideDown(Player player, Platform platform){
        return (
                (player.getFaceUp("y") <= platform.getFaceDown("y")) &&
                (
                        (
                                (player.getCenter("y") >= platform.getFaceDown("y")) ||
                                (player.getCenter("y") <= platform.getFaceDown("y"))
                        ) &&
                        (player.getFaceDown("y") >= platform.getFaceDown("y"))
                ) &&
                (player.getFaceLeft("x") <= (platform.getFaceRight("x") - 4)) &&
                (player.getFaceRight("x") >= (platform.getFaceLeft("x") + 4))
        );
    }
    private boolean collideUp(Player player, Platform platform){
        return (
                (player.getFaceDown("y") >= platform.getFaceUp("y")) &&
                (
                        (
                                (player.getCenter("y") <= platform.getFaceUp("y")) ||
                                (player.getCenter("y") >= platform.getFaceUp("y"))
                        ) &&
                        (player.getFaceUp("y") <= platform.getFaceUp("y"))
                ) &&
                (player.getFaceLeft("x") <= (platform.getFaceRight("x") - 4)) &&
                (player.getFaceRight("x") >= (platform.getFaceLeft("x") + 4))
        );
    }
    private boolean collideLeft(Player player, Platform platform){
        return (
                (player.getFaceRight("x") >= platform.getFaceLeft("x")) &&
                (
                        (
                                (player.getCenter("X") <= platform.getFaceLeft("x")) ||
                                (player.getCenter("x") >= platform.getFaceLeft("x"))
                        ) &&
                        (player.getFaceLeft("x") <= platform.getFaceLeft("x"))
                ) &&
                (player.getFaceUp("y") <= (platform.getFaceDown("y") - 4)) &&
                (player.getFaceDown("y") >= (platform.getFaceUp("y") + 4))
        );
    }
    private boolean collideRight(Player player, Platform platform){
        return (
                (player.getFaceLeft("x") <= platform.getFaceRight("x")) &&
                (
                        (
                                (player.getCenter("x") >= platform.getFaceRight("x")) ||
                                (player.getCenter("x") <= platform.getFaceRight("x"))
                        ) &&
                        (player.getFaceRight("x") >= platform.getFaceRight("x"))
                ) &&
                (player.getFaceUp("y") <= (platform.getFaceDown("y") - 4)) &&
                (player.getFaceDown("y") >= (platform.getFaceUp("y") + 4))
        );
    }

//----------------------------------------------------------------------------------------------------------------------

    // Player - Player
    public boolean collide(Player player, Player player1, String ColisionType){
        boolean R = false;
        if (ColisionType.equalsIgnoreCase("down") || ColisionType.equalsIgnoreCase("all")){
            if (collideDown(player, player1)){
                R = true;
                player.setVelocity(0, 0);
                player.setY((player1.getY() + player1.getHeight()));
            }
        }
        if (ColisionType.equalsIgnoreCase("up") || ColisionType.equalsIgnoreCase("all")){
            if (collideUp(player, player1)){
                R = true;
                player.setVelocity(0, 0);
                player.setY(player1.getY() - player.getHeight());
            }
        }
        if (ColisionType.equalsIgnoreCase("left") || ColisionType.equalsIgnoreCase("all")){
            if (collideLeft(player, player1)){
                R = true;
                player.setVelocity(0, 0);
                player.setX(player1.getX() - player.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")){
            if (collideRight(player, player1)){
                R = true;
                player.setVelocity(0, 0);
                player.setX((player1.getX() + player1.getWidth()));
            }
        }
        return R;
    }

    private boolean collideDown(Player player, Player player1){
        return (
                (player.getFaceUp("y") <= player1.getFaceDown("y")) &&
                (
                        (
                               (player.getCenter("y") >= player1.getFaceDown("y")) ||
                               (player.getCenter("y") <= player1.getFaceDown("y"))
                        ) &&
                       (player.getFaceDown("y") >= player1.getFaceDown("y"))
                ) &&
                (player.getFaceLeft("x") <= (player1.getFaceRight("x") - 4)) &&
                (player.getFaceRight("x") >= (player1.getFaceLeft("x") + 4))
        );
    }
    private boolean collideUp(Player player, Player player1){
        return (
                (player.getFaceDown("y") >= player1.getFaceUp("y")) &&
                (
                        (
                                (player.getCenter("y") <= player1.getFaceUp("y")) ||
                                (player.getCenter("y") >= player1.getFaceUp("y"))
                        ) &&
                        (player.getFaceUp("y") <= player1.getFaceUp("y"))
                ) &&
                (player.getFaceLeft("x") <= (player1.getFaceRight("x") - 4)) &&
                (player.getFaceRight("x") >= (player1.getFaceLeft("x") + 4))
        );
    }
    private boolean collideLeft(Player player, Player player1){
        return (
                (player.getFaceRight("x") >= player1.getFaceLeft("x")) &&
                (
                        (
                                (player.getCenter("X") <= player1.getFaceLeft("x")) ||
                                (player.getCenter("x") >= player1.getFaceLeft("x"))
                        ) &&
                        (player.getFaceLeft("x") <= player1.getFaceLeft("x"))
                ) &&
                (player.getFaceUp("y") <= (player1.getFaceDown("y") - 4)) &&
                (player.getFaceDown("y") >= (player1.getFaceUp("y") + 4))
        );
    }
    private boolean collideRight(Player player, Player player1){
        return (
                (player.getFaceLeft("x") <= player1.getFaceRight("x")) &&
                (
                        (
                                (player.getCenter("x") >= player1.getFaceRight("x")) ||
                                (player.getCenter("x") <= player1.getFaceRight("x"))
                        ) &&
                        (player.getFaceRight("x") >= player1.getFaceRight("x"))
                ) &&
                (player.getFaceUp("y") <= (player1.getFaceDown("y") - 4)) &&
                (player.getFaceDown("y") >= (player1.getFaceUp("y") + 4))
        );
    }

    //----------------------------------------------------------------------------------------------------------------------

    // Enemy - Platform
    public boolean collide(Enemy enemy, Platform platform, String ColisionType){
        boolean R = false;
        if (ColisionType.equalsIgnoreCase("down") || ColisionType.equalsIgnoreCase("all")){
            if (collideDown(enemy, platform)){
                R = true;
                enemy.setVelocity(0, 0);
                enemy.setY((platform.getY() + platform.getHeight()));
            }
        }
        if (ColisionType.equalsIgnoreCase("up") || ColisionType.equalsIgnoreCase("all")){
            if (collideUp(enemy, platform)){
                R = true;
                enemy.setVelocity(0, 0);
                enemy.setY(platform.getY() - enemy.getHeight());
            }
        }
        if (ColisionType.equalsIgnoreCase("left") || ColisionType.equalsIgnoreCase("all")){
            if (collideLeft(enemy, platform)){
                R = true;
                enemy.setVelocity(0, 0);
                enemy.setX(platform.getX() - enemy.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")){
            if (collideRight(enemy, platform)){
                R = true;
                enemy.setVelocity(0, 0);
                enemy.setX((platform.getX() + platform.getWidth()));
            }
        }
        return R;
    }

    private boolean collideDown(Enemy enemy, Platform platform){
        return (
                (enemy.getFaceUp("y") <= platform.getFaceDown("y")) &&
                (
                        (
                               (enemy.getCenter("y") >= platform.getFaceDown("y")) ||
                               (enemy.getCenter("y") <= platform.getFaceDown("y"))
                        ) &&
                       (enemy.getFaceDown("y") >= platform.getFaceDown("y"))
                ) &&
                (enemy.getFaceLeft("x") <= (platform.getFaceRight("x") - 4)) &&
                (enemy.getFaceRight("x") >= (platform.getFaceLeft("x") + 4))
        );
    }
    private boolean collideUp(Enemy enemy, Platform platform){
        return (
                (enemy.getFaceDown("y") >= platform.getFaceUp("y")) &&
                (
                        (
                                (enemy.getCenter("y") <= platform.getFaceUp("y")) ||
                                (enemy.getCenter("y") >= platform.getFaceUp("y"))
                        ) &&
                        (enemy.getFaceUp("y") <= platform.getFaceUp("y"))
                ) &&
                (enemy.getFaceLeft("x") <= (platform.getFaceRight("x") - 4)) &&
                (enemy.getFaceRight("x") >= (platform.getFaceLeft("x") + 4))
        );
    }
    private boolean collideLeft(Enemy enemy, Platform platform){
        return (
                (enemy.getFaceRight("x") >= platform.getFaceLeft("x")) &&
                (
                        (
                                (enemy.getCenter("X") <= platform.getFaceLeft("x")) ||
                                (enemy.getCenter("x") >= platform.getFaceLeft("x"))
                        ) &&
                        (enemy.getFaceLeft("x") <= platform.getFaceLeft("x"))
                ) &&
                (enemy.getFaceUp("y") <= (platform.getFaceDown("y") - 4)) &&
                (enemy.getFaceDown("y") >= (platform.getFaceUp("y") + 4))
        );
    }
    private boolean collideRight(Enemy enemy, Platform platform){
        return (
                (enemy.getFaceLeft("x") <= platform.getFaceRight("x")) &&
                (
                        (
                                (enemy.getCenter("x") >= platform.getFaceRight("x")) ||
                                (enemy.getCenter("x") <= platform.getFaceRight("x"))
                        ) &&
                        (enemy.getFaceRight("x") >= platform.getFaceRight("x"))
                ) &&
                (enemy.getFaceUp("y") <= (platform.getFaceDown("y") - 4)) &&
                (enemy.getFaceDown("y") >= (platform.getFaceUp("y") + 4))
        );
    }

    //----------------------------------------------------------------------------------------------------------------------

    // Enemy - Platform
    public boolean collide(Enemy enemy, Enemy enemy1, String ColisionType){
        boolean R = false;
        if (ColisionType.equalsIgnoreCase("down") || ColisionType.equalsIgnoreCase("all")){
            if (collideDown(enemy, enemy1)){
                R = true;
                enemy.setVelocity(0, 0);
                enemy.setY((enemy1.getY() + enemy1.getHeight()));
            }
        }
        if (ColisionType.equalsIgnoreCase("up") || ColisionType.equalsIgnoreCase("all")){
            if (collideUp(enemy, enemy1)){
                R = true;
                enemy.setVelocity(0, 0);
                enemy.setY(enemy1.getY() - enemy.getHeight());
            }
        }
        if (ColisionType.equalsIgnoreCase("left") || ColisionType.equalsIgnoreCase("all")){
            if (collideLeft(enemy, enemy1)){
                R = true;
                enemy.setVelocity(0, 0);
                enemy.setX(enemy1.getX() - enemy.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")){
            if (collideRight(enemy, enemy1)){
                R = true;
                enemy.setVelocity(0, 0);
                enemy.setX((enemy1.getX() + enemy1.getWidth()));
            }
        }
        return R;
    }

    private boolean collideDown(Enemy enemy, Enemy enemy1){
        return (
                (enemy.getFaceUp("y") <= enemy1.getFaceDown("y")) &&
                (
                        (
                               (enemy.getCenter("y") >= enemy1.getFaceDown("y")) ||
                               (enemy.getCenter("y") <= enemy1.getFaceDown("y"))
                        ) &&
                       (enemy.getFaceDown("y") >= enemy1.getFaceDown("y"))
                ) &&
                (enemy.getFaceLeft("x") <= (enemy1.getFaceRight("x") - 4)) &&
                (enemy.getFaceRight("x") >= (enemy1.getFaceLeft("x") + 4))
        );
    }
    private boolean collideUp(Enemy enemy, Enemy enemy1){
        return (
                (enemy.getFaceDown("y") >= enemy1.getFaceUp("y")) &&
                (
                        (
                                (enemy.getCenter("y") <= enemy1.getFaceUp("y")) ||
                                (enemy.getCenter("y") >= enemy1.getFaceUp("y"))
                        ) &&
                        (enemy.getFaceUp("y") <= enemy1.getFaceUp("y"))
                ) &&
                (enemy.getFaceLeft("x") <= (enemy1.getFaceRight("x") - 4)) &&
                (enemy.getFaceRight("x") >= (enemy1.getFaceLeft("x") + 4))
        );
    }
    private boolean collideLeft(Enemy enemy, Enemy enemy1){
        return (
                (enemy.getFaceRight("x") >= enemy1.getFaceLeft("x")) &&
                (
                        (
                                (enemy.getCenter("X") <= enemy1.getFaceLeft("x")) ||
                                (enemy.getCenter("x") >= enemy1.getFaceLeft("x"))
                        ) &&
                        (enemy.getFaceLeft("x") <= enemy1.getFaceLeft("x"))
                ) &&
                (enemy.getFaceUp("y") <= (enemy1.getFaceDown("y") - 4)) &&
                (enemy.getFaceDown("y") >= (enemy1.getFaceUp("y") + 4))
        );
    }
    private boolean collideRight(Enemy enemy, Enemy enemy1){
        return (
                (enemy.getFaceLeft("x") <= enemy1.getFaceRight("x")) &&
                (
                        (
                                (enemy.getCenter("x") >= enemy1.getFaceRight("x")) ||
                                (enemy.getCenter("x") <= enemy1.getFaceRight("x"))
                        ) &&
                        (enemy.getFaceRight("x") >= enemy1.getFaceRight("x"))
                ) &&
                (enemy.getFaceUp("y") <= (enemy1.getFaceDown("y") - 4)) &&
                (enemy.getFaceDown("y") >= (enemy1.getFaceUp("y") + 4))
        );
    }
}