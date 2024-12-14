package Tools.Methods;

import GameEditor.GameEditor;
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
                player.setVelocity(0, player.getVelocityY());
                player.setX(platform.getX() - player.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")){
            if (collideRight(player, platform)){
                R = true;
                player.setVelocity(0, player.getVelocityY());
                player.setX((platform.getX() + platform.getWidth()));
            }
        }
        return R;
    }

    private boolean collideUp(Player player, Platform platform){
        return (
                (player.getVelocityY() >= 0) &&
                (
                        (player.getFaceDown("y") >= platform.getFaceUp("y")) &&
                        (
                                (player.getFaceDown("y") <= platform.getFaceDown("y")) ||
                                (player.getFaceDown("y") <= GameEditor.Height)
                        ) &&
                        (player.getFaceUp("y") < platform.getFaceUp("y"))
                ) &&
                (player.getFaceLeft("x") < (platform.getFaceRight("x") - 5)) &&
                (player.getFaceRight("x") > (platform.getFaceLeft("x") + 5))
        );
    }
    private boolean collideDown(Player player, Platform platform){
        return (
                (player.getVelocityY() <= 0) &&
                (
                        (player.getFaceUp("y") <= platform.getFaceDown("y")) &&
                        (
                                (player.getFaceUp("y") >= platform.getFaceUp("y")) ||
                                (player.getFaceUp("y") >= 0)
                        ) &&
                        (player.getFaceDown("y") > platform.getFaceDown("y"))
                ) &&
                (player.getFaceLeft("x") < (platform.getFaceRight("x") - 5)) &&
                (player.getFaceRight("x") > (platform.getFaceLeft("x") + 5))
        );
    }
    private boolean collideLeft(Player player, Platform platform){
        return (
                (player.getVelocityX() >= 0) &&
                (
                        (player.getFaceRight("x") >= platform.getFaceLeft("x")) &&
                        (
                                (player.getFaceRight("x") <= platform.getFaceRight("x")) ||
                                (player.getFaceRight("x") <= GameEditor.Width)
                        ) &&
                        (player.getFaceLeft("x") < platform.getFaceLeft("x"))
                ) &&
                (player.getFaceDown("y") > (platform.getFaceUp("y") + 5)) &&
                (player.getFaceUp("y") < (platform.getFaceDown("y") - 5))
        );
    }
    private boolean collideRight(Player player, Platform platform){
        return (
                (player.getVelocityX() <= 0) &&
                (
                        (player.getFaceLeft("x") <= platform.getFaceRight("x")) &&
                        (
                                (player.getFaceLeft("x") >= platform.getFaceLeft("x")) ||
                                (player.getFaceLeft("x") >= 0)
                        ) &&
                        (player.getFaceRight("x") > platform.getFaceRight("x"))
                ) &&
                (player.getFaceDown("y") > (platform.getFaceUp("y") + 5)) &&
                (player.getFaceUp("y") < (platform.getFaceDown("y") - 5))
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
                player.setVelocity(0, player.getVelocityY());
                player.setX(player1.getX() - player.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")){
            if (collideRight(player, player1)){
                R = true;
                player.setVelocity(0, player.getVelocityY());
                player.setX((player1.getX() + player1.getWidth()));
            }
        }
        return R;
    }

    private boolean collideUp(Player player, Player player1){
        return (
                (player.getVelocityY() >= 0) &&
                (
                        (player.getFaceDown("y") >= player1.getFaceUp("y")) &&
                        (
                                (player.getFaceDown("y") <= player1.getFaceDown("y")) ||
                                (player.getFaceDown("y") <= GameEditor.Height)
                        ) &&
                        (player.getFaceUp("y") < player1.getFaceUp("y"))
                ) &&
                (player.getFaceLeft("x") < (player1.getFaceRight("x") - 5)) &&
                (player.getFaceRight("x") > (player1.getFaceLeft("x") + 5))
        );
    }
    private boolean collideDown(Player player, Player player1){
        return (
                (player.getVelocityY() <= 0) &&
                (
                        (player.getFaceUp("y") <= player1.getFaceDown("y")) &&
                        (
                                (player.getFaceUp("y") >= player1.getFaceUp("y")) ||
                                (player.getFaceUp("y") >= 0)
                        ) &&
                        (player.getFaceDown("y") > player1.getFaceDown("y"))
                ) &&
                (player.getFaceLeft("x") < (player1.getFaceRight("x") - 5)) &&
                (player.getFaceRight("x") > (player1.getFaceLeft("x") + 5))
        );
    }
    private boolean collideLeft(Player player, Player player1){
        return (
                (player.getVelocityX() >= 0) &&
                (
                        (player.getFaceRight("x") >= player1.getFaceLeft("x")) &&
                        (
                                (player.getFaceRight("x") <= player1.getFaceRight("x")) ||
                                (player.getFaceRight("x") <= GameEditor.Width)
                        ) &&
                        (player.getFaceLeft("x") < player1.getFaceLeft("x"))
                ) &&
                (player.getFaceDown("y") > (player1.getFaceUp("y") + 5)) &&
                (player.getFaceUp("y") < (player1.getFaceDown("y") - 5))
        );
    }
    private boolean collideRight(Player player, Player player1){
        return (
                (player.getVelocityX() <= 0) &&
                (
                        (player.getFaceLeft("x") <= player1.getFaceRight("x")) &&
                        (
                                (player.getFaceLeft("x") >= player1.getFaceLeft("x")) ||
                                (player.getFaceLeft("x") >= 0)
                        ) &&
                        (player.getFaceRight("x") > player1.getFaceRight("x"))
                ) &&
                (player.getFaceDown("y") > (player1.getFaceUp("y") + 5)) &&
                (player.getFaceUp("y") < (player1.getFaceDown("y") - 5))
        );
    }

    //----------------------------------------------------------------------------------------------------------------------

    // Player - Enemy
    public boolean collide(Player player, Enemy enemy, String ColisionType){
        boolean R = false;
        if (ColisionType.equalsIgnoreCase("down") || ColisionType.equalsIgnoreCase("all")){
            if (collideDown(player, enemy)){
                R = true;
                player.setVelocity(0, 0);
                player.setY((enemy.getY() + enemy.getHeight()));
            }
        }
        if (ColisionType.equalsIgnoreCase("up") || ColisionType.equalsIgnoreCase("all")){
            if (collideUp(player, enemy)){
                R = true;
                player.setVelocity(0, 0);
                player.setY(enemy.getY() - player.getHeight());
            }
        }
        if (ColisionType.equalsIgnoreCase("left") || ColisionType.equalsIgnoreCase("all")){
            if (collideLeft(player, enemy)){
                R = true;
                player.setVelocity(0, player.getVelocityY());
                player.setX(enemy.getX() - player.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")){
            if (collideRight(player, enemy)){
                R = true;
                player.setVelocity(0, player.getVelocityY());
                player.setX((enemy.getX() + enemy.getWidth()));
            }
        }
        return R;
    }

    private boolean collideUp(Player player, Enemy enemy){
        return (
                (player.getVelocityY() >= 0) &&
                (
                        (player.getFaceDown("y") >= enemy.getFaceUp("y")) &&
                        (
                                (player.getFaceDown("y") <= enemy.getFaceDown("y")) ||
                                (player.getFaceDown("y") <= GameEditor.Height)
                        ) &&
                        (player.getFaceUp("y") < enemy.getFaceUp("y"))
                ) &&
                (player.getFaceLeft("x") < (enemy.getFaceRight("x") - 5)) &&
                (player.getFaceRight("x") > (enemy.getFaceLeft("x") + 5))
        );
    }
    private boolean collideDown(Player player, Enemy enemy){
        return (
                (player.getVelocityY() <= 0) &&
                (
                        (player.getFaceUp("y") <= enemy.getFaceDown("y")) &&
                        (
                                (player.getFaceUp("y") >= enemy.getFaceUp("y")) ||
                                (player.getFaceUp("y") >= 0)
                        ) &&
                        (player.getFaceDown("y") > enemy.getFaceDown("y"))
                ) &&
                (player.getFaceLeft("x") < (enemy.getFaceRight("x") - 5)) &&
                (player.getFaceRight("x") > (enemy.getFaceLeft("x") + 5))
        );
    }
    private boolean collideLeft(Player player, Enemy enemy){
        return (
                (player.getVelocityX() >= 0) &&
                (
                        (player.getFaceRight("x") >= enemy.getFaceLeft("x")) &&
                        (
                                (player.getFaceRight("x") <= enemy.getFaceRight("x")) ||
                                (player.getFaceRight("x") <= GameEditor.Width)
                        ) &&
                        (player.getFaceLeft("x") < enemy.getFaceLeft("x"))
                ) &&
                (player.getFaceDown("y") > (enemy.getFaceUp("y") + 5)) &&
                (player.getFaceUp("y") < (enemy.getFaceDown("y") - 5))
        );
    }
    private boolean collideRight(Player player, Enemy enemy){
        return (
                (player.getVelocityX() <= 0) &&
                (
                        (player.getFaceLeft("x") <= enemy.getFaceRight("x")) &&
                        (
                                (player.getFaceLeft("x") >= enemy.getFaceLeft("x")) ||
                                (player.getFaceLeft("x") >= 0)
                        ) &&
                        (player.getFaceRight("x") > enemy.getFaceRight("x"))
                ) &&
                (player.getFaceDown("y") > (enemy.getFaceUp("y") + 5)) &&
                (player.getFaceUp("y") < (enemy.getFaceDown("y") - 5))
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
                enemy.setVelocity(0, enemy.getVelocityY());
                enemy.setX(platform.getX() - enemy.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")){
            if (collideRight(enemy, platform)){
                R = true;
                enemy.setVelocity(0, enemy.getVelocityY());
                enemy.setX((platform.getX() + platform.getWidth()));
            }
        }
        return R;
    }

    private boolean collideUp(Enemy enemy, Platform platform){
        return (
                (enemy.getVelocityY() >= 0) &&
                (
                        (enemy.getFaceDown("y") >= platform.getFaceUp("y")) &&
                        (
                                (enemy.getFaceDown("y") <= platform.getFaceDown("y")) ||
                                (enemy.getFaceDown("y") <= GameEditor.Height)
                        ) &&
                        (enemy.getFaceUp("y") < platform.getFaceUp("y"))
                ) &&
                (enemy.getFaceLeft("x") < (platform.getFaceRight("x") - 5)) &&
                (enemy.getFaceRight("x") > (platform.getFaceLeft("x") + 5))
        );
    }
    private boolean collideDown(Enemy enemy, Platform platform){
        return (
                (enemy.getVelocityY() <= 0) &&
                (
                        (enemy.getFaceUp("y") <= platform.getFaceDown("y")) &&
                        (
                                (enemy.getFaceUp("y") >= platform.getFaceUp("y")) ||
                                (enemy.getFaceUp("y") >= 0)
                        ) &&
                        (enemy.getFaceDown("y") > platform.getFaceDown("y"))
                ) &&
                (enemy.getFaceLeft("x") < (platform.getFaceRight("x") - 5)) &&
                (enemy.getFaceRight("x") > (platform.getFaceLeft("x") + 5))
        );
    }
    private boolean collideLeft(Enemy enemy, Platform platform){
        return (
                (enemy.getVelocityX() >= 0) &&
                (
                        (enemy.getFaceRight("x") >= platform.getFaceLeft("x")) &&
                        (
                                (enemy.getFaceRight("x") <= platform.getFaceRight("x")) ||
                                (enemy.getFaceRight("x") <= GameEditor.Width)
                        ) &&
                        (enemy.getFaceLeft("x") < platform.getFaceLeft("x"))
                ) &&
                (enemy.getFaceDown("y") > (platform.getFaceUp("y") + 5)) &&
                (enemy.getFaceUp("y") < (platform.getFaceDown("y") - 5))
        );
    }
    private boolean collideRight(Enemy enemy, Platform platform){
        return (
                (enemy.getVelocityX() <= 0) &&
                (
                        (enemy.getFaceLeft("x") <= platform.getFaceRight("x")) &&
                        (
                                (enemy.getFaceLeft("x") >= platform.getFaceLeft("x")) ||
                                (enemy.getFaceLeft("x") >= 0)
                        ) &&
                        (enemy.getFaceRight("x") > platform.getFaceRight("x"))
                ) &&
                (enemy.getFaceDown("y") > (platform.getFaceUp("y") + 5)) &&
                (enemy.getFaceUp("y") < (platform.getFaceDown("y") - 5))
        );
    }

    //----------------------------------------------------------------------------------------------------------------------

    // Enemy - Enemy
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
                enemy.setVelocity(0, enemy.getVelocityY());
                enemy.setX(enemy1.getX() - enemy.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")){
            if (collideRight(enemy, enemy1)){
                R = true;
                enemy.setVelocity(0, enemy.getVelocityY());
                enemy.setX((enemy1.getX() + enemy1.getWidth()));
            }
        }
        return R;
    }

    private boolean collideUp(Enemy enemy, Enemy enemy1){
        return (
                (enemy.getVelocityY() >= 0) &&
                (
                        (enemy.getFaceDown("y") >= enemy1.getFaceUp("y")) &&
                        (
                                (enemy.getFaceDown("y") <= enemy1.getFaceDown("y")) ||
                                (enemy.getFaceDown("y") <= GameEditor.Height)
                        ) &&
                        (enemy.getFaceUp("y") < enemy1.getFaceUp("y"))
                ) &&
                (enemy.getFaceLeft("x") < (enemy1.getFaceRight("x") - 5)) &&
                (enemy.getFaceRight("x") > (enemy1.getFaceLeft("x") + 5))
        );
    }
    private boolean collideDown(Enemy enemy, Enemy enemy1){
        return (
                (enemy.getVelocityY() <= 0) &&
                (
                        (enemy.getFaceUp("y") <= enemy1.getFaceDown("y")) &&
                        (
                                (enemy.getFaceUp("y") >= enemy1.getFaceUp("y")) ||
                                (enemy.getFaceUp("y") >= 0)
                        ) &&
                        (enemy.getFaceDown("y") > enemy1.getFaceDown("y"))
                ) &&
                (enemy.getFaceLeft("x") < (enemy1.getFaceRight("x") - 5)) &&
                (enemy.getFaceRight("x") > (enemy1.getFaceLeft("x") + 5))
        );
    }
    private boolean collideLeft(Enemy enemy, Enemy enemy1){
        return (
                (enemy.getVelocityX() >= 0) &&
                (
                        (enemy.getFaceRight("x") >= enemy1.getFaceLeft("x")) &&
                        (
                                (enemy.getFaceRight("x") <= enemy1.getFaceRight("x")) ||
                                (enemy.getFaceRight("x") <= GameEditor.Width)
                        ) &&
                        (enemy.getFaceLeft("x") < enemy1.getFaceLeft("x"))
                ) &&
                (enemy.getFaceDown("y") > (enemy1.getFaceUp("y") + 5)) &&
                (enemy.getFaceUp("y") < (enemy1.getFaceDown("y") - 5))
        );
    }
    private boolean collideRight(Enemy enemy, Enemy enemy1){
        return (
                (enemy.getVelocityX() <= 0) &&
                (
                        (enemy.getFaceLeft("x") <= enemy1.getFaceRight("x")) &&
                        (
                                (enemy.getFaceLeft("x") >= enemy1.getFaceLeft("x")) ||
                                (enemy.getFaceLeft("x") >= 0)
                        ) &&
                        (enemy.getFaceRight("x") > enemy1.getFaceRight("x"))
                ) &&
                (enemy.getFaceDown("y") > (enemy1.getFaceUp("y") + 5)) &&
                (enemy.getFaceUp("y") < (enemy1.getFaceDown("y") - 5))
        );
    }

    //----------------------------------------------------------------------------------------------------------------------

    // Enemy - Player
    public boolean collide(Enemy enemy, Player player, String ColisionType){
        boolean R = false;
        if (ColisionType.equalsIgnoreCase("down") || ColisionType.equalsIgnoreCase("all")){
            if (collideDown(enemy, player)){
                R = true;
                enemy.setVelocity(0, 0);
                enemy.setY((player.getY() + player.getHeight()));
            }
        }
        if (ColisionType.equalsIgnoreCase("up") || ColisionType.equalsIgnoreCase("all")){
            if (collideUp(enemy, player)){
                R = true;
                enemy.setVelocity(0, 0);
                enemy.setY(player.getY() - enemy.getHeight());
            }
        }
        if (ColisionType.equalsIgnoreCase("left") || ColisionType.equalsIgnoreCase("all")){
            if (collideLeft(enemy, player)){
                R = true;
                enemy.setVelocity(0, enemy.getVelocityY());
                enemy.setX(player.getX() - enemy.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")){
            if (collideRight(enemy, player)){
                R = true;
                enemy.setVelocity(0, enemy.getVelocityY());
                enemy.setX((player.getX() + player.getWidth()));
            }
        }
        return R;
    }

    private boolean collideUp(Enemy enemy, Player player){
        return (
                (enemy.getVelocityY() >= 0) &&
                (
                        (enemy.getFaceDown("y") >= player.getFaceUp("y")) &&
                        (
                                (enemy.getFaceDown("y") <= player.getFaceDown("y")) ||
                                (enemy.getFaceDown("y") <= GameEditor.Height)
                        ) &&
                        (enemy.getFaceUp("y") < player.getFaceUp("y"))
                ) &&
                (enemy.getFaceLeft("x") < (player.getFaceRight("x") - 5)) &&
                (enemy.getFaceRight("x") > (player.getFaceLeft("x") + 5))
        );
    }
    private boolean collideDown(Enemy enemy, Player player){
        return (
                (enemy.getVelocityY() <= 0) &&
                (
                        (enemy.getFaceUp("y") <= player.getFaceDown("y")) &&
                        (
                                (enemy.getFaceUp("y") >= player.getFaceUp("y")) ||
                                (enemy.getFaceUp("y") >= 0)
                        ) &&
                        (enemy.getFaceDown("y") > player.getFaceDown("y"))
                ) &&
                (enemy.getFaceLeft("x") < (player.getFaceRight("x") - 5)) &&
                (enemy.getFaceRight("x") > (player.getFaceLeft("x") + 5))
        );
    }
    private boolean collideLeft(Enemy enemy, Player player){
        return (
                (enemy.getVelocityX() >= 0) &&
                (
                        (enemy.getFaceRight("x") >= player.getFaceLeft("x")) &&
                        (
                                (enemy.getFaceRight("x") <= player.getFaceRight("x")) ||
                                (enemy.getFaceRight("x") <= GameEditor.Width)
                        ) &&
                        (enemy.getFaceLeft("x") < player.getFaceLeft("x"))
                ) &&
                (enemy.getFaceDown("y") > (player.getFaceUp("y") + 5)) &&
                (enemy.getFaceUp("y") < (player.getFaceDown("y") - 5))
        );
    }
    private boolean collideRight(Enemy enemy, Player player){
        return (
                (enemy.getVelocityX() <= 0) &&
                (
                        (enemy.getFaceLeft("x") <= player.getFaceRight("x")) &&
                        (
                                (enemy.getFaceLeft("x") >= player.getFaceLeft("x")) ||
                                (enemy.getFaceLeft("x") >= 0)
                        ) &&
                        (enemy.getFaceRight("x") > player.getFaceRight("x"))
                ) &&
                (enemy.getFaceDown("y") > (player.getFaceUp("y") + 5)) &&
                (enemy.getFaceUp("y") < (player.getFaceDown("y") - 5))
        );
    }

}