package Tools.Methods;

import GameEditor.GameEditor;
import Tools.Entities.Enemy;
import Tools.Entities.Player;
import Tools.World.Platform;

public class Collide {

    public Collide(){}

    // Player - Platform
    public void Collide(Player player, Platform platform, String ColisionType){
        if (ColisionType.equalsIgnoreCase("down") || ColisionType.equalsIgnoreCase("all")){
            if (CollideDown(player, platform)){
                player.setVelocity(0, 0);
                player.setY((platform.getY() + platform.getHeight()));
            }
        }
        if (ColisionType.equalsIgnoreCase("up") || ColisionType.equalsIgnoreCase("all")){
            if (CollideUp(player, platform)){
                player.setVelocity(0, 0);
                player.setY(platform.getY() - player.getHeight());
            }
        }
        if (ColisionType.equalsIgnoreCase("left") || ColisionType.equalsIgnoreCase("all")){
            if (CollideLeft(player, platform)){
                player.setVelocity(0, 0);
                player.setX(platform.getX() - player.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")){
            if (CollideRight(player, platform)){
                player.setVelocity(0, 0);
                player.setX((platform.getX() + platform.getWidth()));
            }
        }
    }

    public boolean Collide_B(Player player, Platform platform){
        return (
                CollideDown(player, platform) ||
                CollideUp(player, platform) ||
                CollideLeft(player, platform) ||
                CollideRight(player, platform)
        );
    }

    private boolean CollideDown(Player player, Platform platform){
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
    private boolean CollideUp(Player player, Platform platform){
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
    private boolean CollideLeft(Player player, Platform platform){
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
    private boolean CollideRight(Player player, Platform platform){
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
    public void Collide(Player player, Player player1, String ColisionType){
        if (ColisionType.equalsIgnoreCase("down") || ColisionType.equalsIgnoreCase("all")){
            if (CollideDown(player, player1)){
                player.setVelocity(0, 0);
                player.setY((player1.getY() + player1.getHeight()));
            }
        }
        if (ColisionType.equalsIgnoreCase("up") || ColisionType.equalsIgnoreCase("all")){
            if (CollideUp(player, player1)){
                player.setVelocity(0, 0);
                player.setY(player1.getY() - player.getHeight());
            }
        }
        if (ColisionType.equalsIgnoreCase("left") || ColisionType.equalsIgnoreCase("all")){
            if (CollideLeft(player, player1)){
                player.setVelocity(0, 0);
                player.setX(player1.getX() - player.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")){
            if (CollideRight(player, player1)){
                player.setVelocity(0, 0);
                player.setX((player1.getX() + player1.getWidth()));
            }
        }
    }

    public boolean Collide_B(Player player, Player player1){
        return (
                CollideDown(player, player1) ||
                CollideUp(player, player1) ||
                CollideLeft(player, player1) ||
                CollideRight(player, player1)
        );
    }

    private boolean CollideDown(Player player, Player player1){
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
    private boolean CollideUp(Player player, Player player1){
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
    private boolean CollideLeft(Player player, Player player1){
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
    private boolean CollideRight(Player player, Player player1){
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
    public void Collide(Enemy enemy, Platform platform, String ColisionType){
        if (ColisionType.equalsIgnoreCase("down") || ColisionType.equalsIgnoreCase("all")){
            if (CollideDown(enemy, platform)){
                enemy.setVelocity(0, 0);
                enemy.setY((platform.getY() + platform.getHeight()));
            }
        }
        if (ColisionType.equalsIgnoreCase("up") || ColisionType.equalsIgnoreCase("all")){
            if (CollideUp(enemy, platform)){
                enemy.setVelocity(0, 0);
                enemy.setY(platform.getY() - enemy.getHeight());
            }
        }
        if (ColisionType.equalsIgnoreCase("left") || ColisionType.equalsIgnoreCase("all")){
            if (CollideLeft(enemy, platform)){
                enemy.setVelocity(0, 0);
                enemy.setX(platform.getX() - enemy.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")){
            if (CollideRight(enemy, platform)){
                enemy.setVelocity(0, 0);
                enemy.setX((platform.getX() + platform.getWidth()));
            }
        }
    }

    public boolean Collide_B(Enemy enemy, Platform platform){
        return (
                CollideDown(enemy, platform) ||
                CollideUp(enemy, platform) ||
                CollideLeft(enemy, platform) ||
                CollideRight(enemy, platform)
        );
    }

    private boolean CollideDown(Enemy enemy, Platform platform){
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
    private boolean CollideUp(Enemy enemy, Platform platform){
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
    private boolean CollideLeft(Enemy enemy, Platform platform){
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
    private boolean CollideRight(Enemy enemy, Platform platform){
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
    public void Collide(Enemy enemy, Enemy enemy1, String ColisionType){
        if (ColisionType.equalsIgnoreCase("down") || ColisionType.equalsIgnoreCase("all")){
            if (CollideDown(enemy, enemy1)){
                enemy.setVelocity(0, 0);
                enemy.setY((enemy1.getY() + enemy1.getHeight()));
            }
        }
        if (ColisionType.equalsIgnoreCase("up") || ColisionType.equalsIgnoreCase("all")){
            if (CollideUp(enemy, enemy1)){
                enemy.setVelocity(0, 0);
                enemy.setY(enemy1.getY() - enemy.getHeight());
            }
        }
        if (ColisionType.equalsIgnoreCase("left") || ColisionType.equalsIgnoreCase("all")){
            if (CollideLeft(enemy, enemy1)){
                enemy.setVelocity(0, 0);
                enemy.setX(enemy1.getX() - enemy.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")){
            if (CollideRight(enemy, enemy1)){
                enemy.setVelocity(0, 0);
                enemy.setX((enemy1.getX() + enemy1.getWidth()));
            }
        }
    }

    public boolean Collide_B(Enemy enemy, Enemy enemy1){
        return (
                CollideDown(enemy, enemy1) ||
                CollideUp(enemy, enemy1) ||
                CollideLeft(enemy, enemy1) ||
                CollideRight(enemy, enemy1)
        );
    }

    private boolean CollideDown(Enemy enemy, Enemy enemy1){
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
    private boolean CollideUp(Enemy enemy, Enemy enemy1){
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
    private boolean CollideLeft(Enemy enemy, Enemy enemy1){
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
    private boolean CollideRight(Enemy enemy, Enemy enemy1){
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