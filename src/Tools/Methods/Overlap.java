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
                OverlpV1(player, enemy) ||
                OverlapV2(player, enemy) ||
                OverlapV3(player, enemy) ||
                OverlapV4(player, enemy)
        );
    }

    private boolean OverlpV1(Player player, Enemy enemy){
        return (
                (player.getVertex(0, "x") <= enemy.getFaceRight("x")) &&
                (player.getVertex(0, "x") >= enemy.getFaceLeft("x")) &&
                (player.getVertex(0, "y") <= enemy.getFaceDown("y")) &&
                (player.getVertex(0, "y") >= enemy.getFaceUp("y"))
        );
    }
    private boolean OverlapV2(Player player, Enemy enemy){
        return (
                (player.getVertex(1, "x") <= enemy.getFaceRight("x")) &&
                (player.getVertex(1, "x") >= enemy.getFaceLeft("x")) &&
                (player.getVertex(1, "y") <= enemy.getFaceDown("y")) &&
                (player.getVertex(1, "y") >= enemy.getFaceUp("y"))
        );
    }
    private boolean OverlapV3(Player player, Enemy enemy){
        return (
                (player.getVertex(2, "x") <= enemy.getFaceRight("x")) &&
                (player.getVertex(2, "x") >= enemy.getFaceLeft("x")) &&
                (player.getVertex(2, "y") <= enemy.getFaceDown("y")) &&
                (player.getVertex(2, "y") >= enemy.getFaceUp("y"))
        );
    }
    private boolean OverlapV4(Player player, Enemy enemy){
        return (
                (player.getVertex(3, "x") <= enemy.getFaceRight("x")) &&
                (player.getVertex(3, "x") >= enemy.getFaceLeft("x")) &&
                (player.getVertex(3, "y") <= enemy.getFaceDown("y")) &&
                (player.getVertex(3, "y") >= enemy.getFaceUp("y"))
        );
    }

    //----------------------------------------------------------------------------------------------------------------------

    // Player - Colectable
    public boolean overlap(Player player, Colectable colectable){
        return (
                OverlpV1(player, colectable) ||
                        OverlapV2(player, colectable) ||
                        OverlapV3(player, colectable) ||
                        OverlapV4(player, colectable)
        );
    }

    private boolean OverlpV1(Player player, Colectable colectable){
        return (
                (player.getVertex(0, "x") <= colectable.getFaceRight("x")) &&
                        (player.getVertex(0, "x") >= colectable.getFaceLeft("x")) &&
                        (player.getVertex(0, "y") <= colectable.getFaceDown("y")) &&
                        (player.getVertex(0, "y") >= colectable.getFaceUp("y"))
        );
    }
    private boolean OverlapV2(Player player, Colectable colectable){
        return (
                (player.getVertex(1, "x") <= colectable.getFaceRight("x")) &&
                        (player.getVertex(1, "x") >= colectable.getFaceLeft("x")) &&
                        (player.getVertex(1, "y") <= colectable.getFaceDown("y")) &&
                        (player.getVertex(1, "y") >= colectable.getFaceUp("y"))
        );
    }
    private boolean OverlapV3(Player player, Colectable colectable){
        return (
                (player.getVertex(2, "x") <= colectable.getFaceRight("x")) &&
                        (player.getVertex(2, "x") >= colectable.getFaceLeft("x")) &&
                        (player.getVertex(2, "y") <= colectable.getFaceDown("y")) &&
                        (player.getVertex(2, "y") >= colectable.getFaceUp("y"))
        );
    }
    private boolean OverlapV4(Player player, Colectable colectable){
        return (
                (player.getVertex(3, "x") <= colectable.getFaceRight("x")) &&
                        (player.getVertex(3, "x") >= colectable.getFaceLeft("x")) &&
                        (player.getVertex(3, "y") <= colectable.getFaceDown("y")) &&
                        (player.getVertex(3, "y") >= colectable.getFaceUp("y"))
        );
    }

    //----------------------------------------------------------------------------------------------------------------------

    // Player - Platform
    public boolean overlap(Player player, Platform platform){
        return (
                OverlpV1(player, platform) ||
                        OverlapV2(player, platform) ||
                        OverlapV3(player, platform) ||
                        OverlapV4(player, platform)
        );
    }

    private boolean OverlpV1(Player player, Platform platform){
        return (
                (player.getVertex(0, "x") <= platform.getFaceRight("x")) &&
                        (player.getVertex(0, "x") >= platform.getFaceLeft("x")) &&
                        (player.getVertex(0, "y") <= platform.getFaceDown("y")) &&
                        (player.getVertex(0, "y") >= platform.getFaceUp("y"))
        );
    }
    private boolean OverlapV2(Player player, Platform platform){
        return (
                (player.getVertex(1, "x") <= platform.getFaceRight("x")) &&
                        (player.getVertex(1, "x") >= platform.getFaceLeft("x")) &&
                        (player.getVertex(1, "y") <= platform.getFaceDown("y")) &&
                        (player.getVertex(1, "y") >= platform.getFaceUp("y"))
        );
    }
    private boolean OverlapV3(Player player, Platform platform){
        return (
                (player.getVertex(2, "x") <= platform.getFaceRight("x")) &&
                        (player.getVertex(2, "x") >= platform.getFaceLeft("x")) &&
                        (player.getVertex(2, "y") <= platform.getFaceDown("y")) &&
                        (player.getVertex(2, "y") >= platform.getFaceUp("y"))
        );
    }
    private boolean OverlapV4(Player player, Platform platform){
        return (
                (player.getVertex(3, "x") <= platform.getFaceRight("x")) &&
                        (player.getVertex(3, "x") >= platform.getFaceLeft("x")) &&
                        (player.getVertex(3, "y") <= platform.getFaceDown("y")) &&
                        (player.getVertex(3, "y") >= platform.getFaceUp("y"))
        );
    }

}
