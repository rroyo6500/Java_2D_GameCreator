package Tools.Methods;

import GameEditor.GameEditor;
import Tools.Entities.Entity;
import Tools.World.Platform;

public class Collide {

    public Collide(){}

    // Player - Platform
    public boolean collide(Entity entity, Platform platform, String ColisionType){
        boolean R = false;
        if (ColisionType.equalsIgnoreCase("down") || ColisionType.equalsIgnoreCase("all")){
            if (collideDown(entity, platform)){
                R = true;
                entity.setVelocity(0, 0);
                entity.setY((platform.getY() + platform.getHeight()));
            }
        }
        if (ColisionType.equalsIgnoreCase("up") || ColisionType.equalsIgnoreCase("all")){
            if (collideUp(entity, platform)){
                R = true;
                entity.setVelocity(0, 0);
                entity.setY(platform.getY() - entity.getHeight());
            }
        }
        if (ColisionType.equalsIgnoreCase("left") || ColisionType.equalsIgnoreCase("all")){
            if (collideLeft(entity, platform)){
                R = true;
                entity.setVelocity(0, entity.getVelocityY());
                entity.setX(platform.getX() - entity.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")){
            if (collideRight(entity, platform)){
                R = true;
                entity.setVelocity(0, entity.getVelocityY());
                entity.setX((platform.getX() + platform.getWidth()));
            }
        }
        return R;
    }

    private boolean collideUp(Entity entity, Platform platform){
        return (
                (entity.getVelocityY() >= 0) &&
                (
                        (entity.getFaceDown("y") >= platform.getFaceUp("y")) &&
                        (
                                (entity.getFaceDown("y") <= platform.getFaceDown("y")) ||
                                (entity.getFaceDown("y") <= GameEditor.Height)
                        ) &&
                        (entity.getFaceUp("y") < platform.getFaceUp("y"))
                ) &&
                (entity.getFaceLeft("x") < (platform.getFaceRight("x") - 5)) &&
                (entity.getFaceRight("x") > (platform.getFaceLeft("x") + 5))
        );
    }
    private boolean collideDown(Entity entity, Platform platform){
        return (
                (entity.getVelocityY() <= 0) &&
                (
                        (entity.getFaceUp("y") <= platform.getFaceDown("y")) &&
                        (
                                (entity.getFaceUp("y") >= platform.getFaceUp("y")) ||
                                (entity.getFaceUp("y") >= 0)
                        ) &&
                        (entity.getFaceDown("y") > platform.getFaceDown("y"))
                ) &&
                (entity.getFaceLeft("x") < (platform.getFaceRight("x") - 5)) &&
                (entity.getFaceRight("x") > (platform.getFaceLeft("x") + 5))
        );
    }
    private boolean collideLeft(Entity entity, Platform platform){
        return (
                (entity.getVelocityX() >= 0) &&
                (
                        (entity.getFaceRight("x") >= platform.getFaceLeft("x")) &&
                        (
                                (entity.getFaceRight("x") <= platform.getFaceRight("x")) ||
                                (entity.getFaceRight("x") <= GameEditor.Width)
                        ) &&
                        (entity.getFaceLeft("x") < platform.getFaceLeft("x"))
                ) &&
                (entity.getFaceDown("y") > (platform.getFaceUp("y") + 5)) &&
                (entity.getFaceUp("y") < (platform.getFaceDown("y") - 5))
        );
    }
    private boolean collideRight(Entity entity, Platform platform){
        return (
                (entity.getVelocityX() <= 0) &&
                (
                        (entity.getFaceLeft("x") <= platform.getFaceRight("x")) &&
                        (
                                (entity.getFaceLeft("x") >= platform.getFaceLeft("x")) ||
                                (entity.getFaceLeft("x") >= 0)
                        ) &&
                        (entity.getFaceRight("x") > platform.getFaceRight("x"))
                ) &&
                (entity.getFaceDown("y") > (platform.getFaceUp("y") + 5)) &&
                (entity.getFaceUp("y") < (platform.getFaceDown("y") - 5))
        );
    }

//----------------------------------------------------------------------------------------------------------------------

    // Player - Player
    public boolean collide(Entity entity, Entity entity1, String ColisionType){
        boolean R = false;
        if (ColisionType.equalsIgnoreCase("down") || ColisionType.equalsIgnoreCase("all")){
            if (collideDown(entity, entity1)){
                R = true;
                entity.setVelocity(0, 0);
                entity.setY((entity1.getY() + entity1.getHeight()));
            }
        }
        if (ColisionType.equalsIgnoreCase("up") || ColisionType.equalsIgnoreCase("all")){
            if (collideUp(entity, entity1)){
                R = true;
                entity.setVelocity(0, 0);
                entity.setY(entity1.getY() - entity.getHeight());
            }
        }
        if (ColisionType.equalsIgnoreCase("left") || ColisionType.equalsIgnoreCase("all")){
            if (collideLeft(entity, entity1)){
                R = true;
                entity.setVelocity(0, entity.getVelocityY());
                entity.setX(entity1.getX() - entity.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")){
            if (collideRight(entity, entity1)){
                R = true;
                entity.setVelocity(0, entity.getVelocityY());
                entity.setX((entity1.getX() + entity1.getWidth()));
            }
        }
        return R;
    }

    private boolean collideUp(Entity entity, Entity entity1){
        return (
                (entity.getVelocityY() >= 0) &&
                (
                        (entity.getFaceDown("y") >= entity1.getFaceUp("y")) &&
                        (
                                (entity.getFaceDown("y") <= entity1.getFaceDown("y")) ||
                                (entity.getFaceDown("y") <= GameEditor.Height)
                        ) &&
                        (entity.getFaceUp("y") < entity1.getFaceUp("y"))
                ) &&
                (entity.getFaceLeft("x") < (entity1.getFaceRight("x") - 5)) &&
                (entity.getFaceRight("x") > (entity1.getFaceLeft("x") + 5))
        );
    }
    private boolean collideDown(Entity entity, Entity entity1){
        return (
                (entity.getVelocityY() <= 0) &&
                (
                        (entity.getFaceUp("y") <= entity1.getFaceDown("y")) &&
                        (
                                (entity.getFaceUp("y") >= entity1.getFaceUp("y")) ||
                                (entity.getFaceUp("y") >= 0)
                        ) &&
                        (entity.getFaceDown("y") > entity1.getFaceDown("y"))
                ) &&
                (entity.getFaceLeft("x") < (entity1.getFaceRight("x") - 5)) &&
                (entity.getFaceRight("x") > (entity1.getFaceLeft("x") + 5))
        );
    }
    private boolean collideLeft(Entity entity, Entity entity1){
        return (
                (entity.getVelocityX() >= 0) &&
                (
                        (entity.getFaceRight("x") >= entity1.getFaceLeft("x")) &&
                        (
                                (entity.getFaceRight("x") <= entity1.getFaceRight("x")) ||
                                (entity.getFaceRight("x") <= GameEditor.Width)
                        ) &&
                        (entity.getFaceLeft("x") < entity1.getFaceLeft("x"))
                ) &&
                (entity.getFaceDown("y") > (entity1.getFaceUp("y") + 5)) &&
                (entity.getFaceUp("y") < (entity1.getFaceDown("y") - 5))
        );
    }
    private boolean collideRight(Entity entity, Entity entity1){
        return (
                (entity.getVelocityX() <= 0) &&
                (
                        (entity.getFaceLeft("x") <= entity1.getFaceRight("x")) &&
                        (
                                (entity.getFaceLeft("x") >= entity1.getFaceLeft("x")) ||
                                (entity.getFaceLeft("x") >= 0)
                        ) &&
                        (entity.getFaceRight("x") > entity1.getFaceRight("x"))
                ) &&
                (entity.getFaceDown("y") > (entity1.getFaceUp("y") + 5)) &&
                (entity.getFaceUp("y") < (entity1.getFaceDown("y") - 5))
        );
    }
}