package Tools.Methods;

import Tools.Entities.Entity;
import Tools.World.Colectable;
import Tools.World.Platform;

public class Overlap {

    public Overlap(){}

    // Player - Enemy
    public boolean overlap(Entity entity, Entity entity1){
        return (
                (
                        (entity.getVertex(0, "x") <= entity1.getFaceRight("x")) &&
                        (entity.getVertex(0, "x") >= entity1.getFaceLeft("x")) &&
                        (entity.getVertex(0, "y") <= entity1.getFaceDown("y")) &&
                        (entity.getVertex(0, "y") >= entity1.getFaceUp("y"))
                ) ||
                (
                        (entity.getVertex(1, "x") <= entity1.getFaceRight("x")) &&
                        (entity.getVertex(1, "x") >= entity1.getFaceLeft("x")) &&
                        (entity.getVertex(1, "y") <= entity1.getFaceDown("y")) &&
                        (entity.getVertex(1, "y") >= entity1.getFaceUp("y"))
                ) ||
                (
                        (entity.getVertex(2, "x") <= entity1.getFaceRight("x")) &&
                        (entity.getVertex(2, "x") >= entity1.getFaceLeft("x")) &&
                        (entity.getVertex(2, "y") <= entity1.getFaceDown("y")) &&
                        (entity.getVertex(2, "y") >= entity1.getFaceUp("y"))
                ) ||
                (
                        (entity.getVertex(3, "x") <= entity1.getFaceRight("x")) &&
                        (entity.getVertex(3, "x") >= entity1.getFaceLeft("x")) &&
                        (entity.getVertex(3, "y") <= entity1.getFaceDown("y")) &&
                        (entity.getVertex(3, "y") >= entity1.getFaceUp("y"))
                )
        );
    }

    //----------------------------------------------------------------------------------------------------------------------

    // Player - Colectable
    public boolean overlap(Entity entity, Colectable colectable){
        return (
                (
                        (entity.getVertex(0, "x") <= colectable.getFaceRight("x")) &&
                        (entity.getVertex(0, "x") >= colectable.getFaceLeft("x")) &&
                        (entity.getVertex(0, "y") <= colectable.getFaceDown("y")) &&
                        (entity.getVertex(0, "y") >= colectable.getFaceUp("y"))
                ) ||
                (
                        (entity.getVertex(1, "x") <= colectable.getFaceRight("x")) &&
                        (entity.getVertex(1, "x") >= colectable.getFaceLeft("x")) &&
                        (entity.getVertex(1, "y") <= colectable.getFaceDown("y")) &&
                        (entity.getVertex(1, "y") >= colectable.getFaceUp("y"))
                ) ||
                (
                        (entity.getVertex(2, "x") <= colectable.getFaceRight("x")) &&
                        (entity.getVertex(2, "x") >= colectable.getFaceLeft("x")) &&
                        (entity.getVertex(2, "y") <= colectable.getFaceDown("y")) &&
                        (entity.getVertex(2, "y") >= colectable.getFaceUp("y"))
                ) ||
                (
                        (entity.getVertex(3, "x") <= colectable.getFaceRight("x")) &&
                        (entity.getVertex(3, "x") >= colectable.getFaceLeft("x")) &&
                        (entity.getVertex(3, "y") <= colectable.getFaceDown("y")) &&
                        (entity.getVertex(3, "y") >= colectable.getFaceUp("y"))
                )
        );
    }

    //----------------------------------------------------------------------------------------------------------------------

    // Player - Platform
    public boolean overlap(Entity entity, Platform platform){
        return (
                (
                        (entity.getVertex(0, "x") <= platform.getFaceRight("x")) &&
                        (entity.getVertex(0, "x") >= platform.getFaceLeft("x")) &&
                        (entity.getVertex(0, "y") <= platform.getFaceDown("y")) &&
                        (entity.getVertex(0, "y") >= platform.getFaceUp("y"))
                ) ||
                (
                        (entity.getVertex(1, "x") <= platform.getFaceRight("x")) &&
                        (entity.getVertex(1, "x") >= platform.getFaceLeft("x")) &&
                        (entity.getVertex(1, "y") <= platform.getFaceDown("y")) &&
                        (entity.getVertex(1, "y") >= platform.getFaceUp("y"))
                ) ||
                (
                        (entity.getVertex(2, "x") <= platform.getFaceRight("x")) &&
                        (entity.getVertex(2, "x") >= platform.getFaceLeft("x")) &&
                        (entity.getVertex(2, "y") <= platform.getFaceDown("y")) &&
                        (entity.getVertex(2, "y") >= platform.getFaceUp("y"))
                ) ||
                (
                        (entity.getVertex(3, "x") <= platform.getFaceRight("x")) &&
                        (entity.getVertex(3, "x") >= platform.getFaceLeft("x")) &&
                        (entity.getVertex(3, "y") <= platform.getFaceDown("y")) &&
                        (entity.getVertex(3, "y") >= platform.getFaceUp("y"))
                )
        );
    }

    //----------------------------------------------------------------------------------------------------------------------

    // Colectable - Player
    public boolean overlap(Colectable colectable, Entity entity){
        return (
                (
                        (colectable.getVertex(0, "x") <= entity.getFaceRight("x")) &&
                        (colectable.getVertex(0, "x") >= entity.getFaceLeft("x")) &&
                        (colectable.getVertex(0, "y") <= entity.getFaceDown("y")) &&
                        (colectable.getVertex(0, "y") >= entity.getFaceUp("y"))
                ) ||
                (
                        (colectable.getVertex(1, "x") <= entity.getFaceRight("x")) &&
                        (colectable.getVertex(1, "x") >= entity.getFaceLeft("x")) &&
                        (colectable.getVertex(1, "y") <= entity.getFaceDown("y")) &&
                        (colectable.getVertex(1, "y") >= entity.getFaceUp("y"))
                ) ||
                (
                        (colectable.getVertex(2, "x") <= entity.getFaceRight("x")) &&
                        (colectable.getVertex(2, "x") >= entity.getFaceLeft("x")) &&
                        (colectable.getVertex(2, "y") <= entity.getFaceDown("y")) &&
                        (colectable.getVertex(2, "y") >= entity.getFaceUp("y"))
                ) ||
                (
                        (colectable.getVertex(3, "x") <= entity.getFaceRight("x")) &&
                        (colectable.getVertex(3, "x") >= entity.getFaceLeft("x")) &&
                        (colectable.getVertex(3, "y") <= entity.getFaceDown("y")) &&
                        (colectable.getVertex(3, "y") >= entity.getFaceUp("y"))
                )
        );
    }
}
