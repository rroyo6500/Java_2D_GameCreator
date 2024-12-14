package Tools.Methods;

import Tools.Entities.Enemy;
import Tools.Entities.Player;
import Tools.World.Colectable;
import Tools.World.Platform;

public class Overlap {

    public Overlap(){}

    // Player - Enemy

    /**
     * Detecta cuando un objeto {@code [ Player | Colectable | Enemy | Platform ]} esta por encima o por debajo de otro.
     *
     * @param player
     * @param enemy
     * @return True or False
     */
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
    /**
     * Detecta cuando un objeto {@code [ Player | Colectable | Enemy | Platform ]} esta por encima o por debajo de otro.
     *
     * @param player
     * @param colectable
     * @return True or False
     */
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
    /**
     * Detecta cuando un objeto {@code [ Player | Colectable | Enemy | Platform ]} esta por encima o por debajo de otro.
     *
     * @param player
     * @param platform
     * @return True or False
     */
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

    /**
     * Detecta cuando un objeto {@code [ Player | Colectable | Enemy | Platform ]} está por encima o por debajo de otro.
     *
     * @param colectable
     * @param player
     * @return True or False
     */
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

    //----------------------------------------------------------------------------------------------------------------------

    // Colectable - Player
    /**
     * Detecta cuando un objeto {@code [ Player | Colectable | Enemy | Platform ]} esta por encima o por debajo de otro.
     *
     * @param enemy
     * @param player
     * @return True or False
     */
    public boolean overlap(Enemy enemy, Player player){
        return (
                (
                        (enemy.getVertex(0, "x") <= player.getFaceRight("x")) &&
                        (enemy.getVertex(0, "x") >= player.getFaceLeft("x")) &&
                        (enemy.getVertex(0, "y") <= player.getFaceDown("y")) &&
                        (enemy.getVertex(0, "y") >= player.getFaceUp("y"))
                ) ||
                (
                        (enemy.getVertex(1, "x") <= player.getFaceRight("x")) &&
                        (enemy.getVertex(1, "x") >= player.getFaceLeft("x")) &&
                        (enemy.getVertex(1, "y") <= player.getFaceDown("y")) &&
                        (enemy.getVertex(1, "y") >= player.getFaceUp("y"))
                ) ||
                (
                        (enemy.getVertex(2, "x") <= player.getFaceRight("x")) &&
                        (enemy.getVertex(2, "x") >= player.getFaceLeft("x")) &&
                        (enemy.getVertex(2, "y") <= player.getFaceDown("y")) &&
                        (enemy.getVertex(2, "y") >= player.getFaceUp("y"))
                ) ||
                (
                        (enemy.getVertex(3, "x") <= player.getFaceRight("x")) &&
                        (enemy.getVertex(3, "x") >= player.getFaceLeft("x")) &&
                        (enemy.getVertex(3, "y") <= player.getFaceDown("y")) &&
                        (enemy.getVertex(3, "y") >= player.getFaceUp("y"))
                )
        );
    }
}
