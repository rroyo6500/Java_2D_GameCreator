package Tools.Methods;

import Tools.Entities.Enemy;
import Tools.Entities.Player;
import Tools.World.Colectable;
import Tools.World.Platform;

public class Overlap {

    public Overlap(){}

    // Player - Enemy
    public boolean overlap(Player player, Enemy enemy){
        return (
                (
                        (player.getVertex(0, "x") <= enemy.getFaceRight("x")) &&
                        (player.getVertex(0, "x") >= enemy.getFaceLeft("x")) &&
                        (player.getVertex(0, "y") <= enemy.getFaceDown("y")) &&
                        (player.getVertex(0, "y") >= enemy.getFaceUp("y"))
                ) ||
                (
                        (player.getVertex(1, "x") <= enemy.getFaceRight("x")) &&
                        (player.getVertex(1, "x") >= enemy.getFaceLeft("x")) &&
                        (player.getVertex(1, "y") <= enemy.getFaceDown("y")) &&
                        (player.getVertex(1, "y") >= enemy.getFaceUp("y"))
                ) ||
                (
                        (player.getVertex(2, "x") <= enemy.getFaceRight("x")) &&
                        (player.getVertex(2, "x") >= enemy.getFaceLeft("x")) &&
                        (player.getVertex(2, "y") <= enemy.getFaceDown("y")) &&
                        (player.getVertex(2, "y") >= enemy.getFaceUp("y"))
                ) ||
                (
                        (player.getVertex(3, "x") <= enemy.getFaceRight("x")) &&
                        (player.getVertex(3, "x") >= enemy.getFaceLeft("x")) &&
                        (player.getVertex(3, "y") <= enemy.getFaceDown("y")) &&
                        (player.getVertex(3, "y") >= enemy.getFaceUp("y"))
                )
        );
    }

    //----------------------------------------------------------------------------------------------------------------------

    // Player - Colectable
    public boolean overlap(Player player, Colectable colectable){
        return (
                (
                        (player.getVertex(0, "x") <= colectable.getFaceRight("x")) &&
                        (player.getVertex(0, "x") >= colectable.getFaceLeft("x")) &&
                        (player.getVertex(0, "y") <= colectable.getFaceDown("y")) &&
                        (player.getVertex(0, "y") >= colectable.getFaceUp("y"))
                ) ||
                (
                        (player.getVertex(1, "x") <= colectable.getFaceRight("x")) &&
                        (player.getVertex(1, "x") >= colectable.getFaceLeft("x")) &&
                        (player.getVertex(1, "y") <= colectable.getFaceDown("y")) &&
                        (player.getVertex(1, "y") >= colectable.getFaceUp("y"))
                ) ||
                (
                        (player.getVertex(2, "x") <= colectable.getFaceRight("x")) &&
                        (player.getVertex(2, "x") >= colectable.getFaceLeft("x")) &&
                        (player.getVertex(2, "y") <= colectable.getFaceDown("y")) &&
                        (player.getVertex(2, "y") >= colectable.getFaceUp("y"))
                ) ||
                (
                        (player.getVertex(3, "x") <= colectable.getFaceRight("x")) &&
                        (player.getVertex(3, "x") >= colectable.getFaceLeft("x")) &&
                        (player.getVertex(3, "y") <= colectable.getFaceDown("y")) &&
                        (player.getVertex(3, "y") >= colectable.getFaceUp("y"))
                )
        );
    }

    //----------------------------------------------------------------------------------------------------------------------

    // Player - Platform
    public boolean overlap(Player player, Platform platform){
        return (
                (
                        (player.getVertex(0, "x") <= platform.getFaceRight("x")) &&
                        (player.getVertex(0, "x") >= platform.getFaceLeft("x")) &&
                        (player.getVertex(0, "y") <= platform.getFaceDown("y")) &&
                        (player.getVertex(0, "y") >= platform.getFaceUp("y"))
                ) ||
                (
                        (player.getVertex(1, "x") <= platform.getFaceRight("x")) &&
                        (player.getVertex(1, "x") >= platform.getFaceLeft("x")) &&
                        (player.getVertex(1, "y") <= platform.getFaceDown("y")) &&
                        (player.getVertex(1, "y") >= platform.getFaceUp("y"))
                ) ||
                (
                        (player.getVertex(2, "x") <= platform.getFaceRight("x")) &&
                        (player.getVertex(2, "x") >= platform.getFaceLeft("x")) &&
                        (player.getVertex(2, "y") <= platform.getFaceDown("y")) &&
                        (player.getVertex(2, "y") >= platform.getFaceUp("y"))
                ) ||
                (
                        (player.getVertex(3, "x") <= platform.getFaceRight("x")) &&
                        (player.getVertex(3, "x") >= platform.getFaceLeft("x")) &&
                        (player.getVertex(3, "y") <= platform.getFaceDown("y")) &&
                        (player.getVertex(3, "y") >= platform.getFaceUp("y"))
                )
        );
    }

    //----------------------------------------------------------------------------------------------------------------------

    // Colectable - Player
    public boolean overlap(Colectable colectable, Player player){
        return (
                (
                        (colectable.getVertex(0, "x") <= player.getFaceRight("x")) &&
                                (colectable.getVertex(0, "x") >= player.getFaceLeft("x")) &&
                                (colectable.getVertex(0, "y") <= player.getFaceDown("y")) &&
                                (colectable.getVertex(0, "y") >= player.getFaceUp("y"))
                ) ||
                        (
                                (colectable.getVertex(1, "x") <= player.getFaceRight("x")) &&
                                        (colectable.getVertex(1, "x") >= player.getFaceLeft("x")) &&
                                        (colectable.getVertex(1, "y") <= player.getFaceDown("y")) &&
                                        (colectable.getVertex(1, "y") >= player.getFaceUp("y"))
                        ) ||
                        (
                                (colectable.getVertex(2, "x") <= player.getFaceRight("x")) &&
                                        (colectable.getVertex(2, "x") >= player.getFaceLeft("x")) &&
                                        (colectable.getVertex(2, "y") <= player.getFaceDown("y")) &&
                                        (colectable.getVertex(2, "y") >= player.getFaceUp("y"))
                        ) ||
                        (
                                (colectable.getVertex(3, "x") <= player.getFaceRight("x")) &&
                                        (colectable.getVertex(3, "x") >= player.getFaceLeft("x")) &&
                                        (colectable.getVertex(3, "y") <= player.getFaceDown("y")) &&
                                        (colectable.getVertex(3, "y") >= player.getFaceUp("y"))
                        )
        );
    }
}
