package Tools.Methods;

import GameEditor.GameEditor;
import Tools.Entities.Entity;
import Tools.World.Platform;

public class Collide {

    private static final Overlap o = new Overlap();

    public Collide() {
    }

    // Entity - Platform
    public boolean collide(Entity entity, Platform platform, String ColisionType) {
        boolean R = false;
        if (ColisionType.equalsIgnoreCase("down") || ColisionType.equalsIgnoreCase("all")) {
            if (collideDown(entity, platform)) {
                R = true;
                entity.setVelocity(0, 0);
                entity.setY((platform.getY() + platform.getHeight()));
            }
        }
        if (ColisionType.equalsIgnoreCase("up") || ColisionType.equalsIgnoreCase("all")) {
            if (collideUp(entity, platform)) {
                R = true;
                entity.setVelocity(0, 0);
                entity.setY(platform.getY() - entity.getHeight());
            }
        }
        if (ColisionType.equalsIgnoreCase("left") || ColisionType.equalsIgnoreCase("all")) {
            if (collideLeft(entity, platform)) {
                R = true;
                entity.setVelocity(0, entity.getVelocityY());
                entity.setX(platform.getX() - entity.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")) {
            if (collideRight(entity, platform)) {
                R = true;
                entity.setVelocity(0, entity.getVelocityY());
                entity.setX((platform.getX() + platform.getWidth()));
            }
        }
        return R;
    }

    private boolean collideUp(Entity entity, Platform platform) {
        return (
                o.overlap(entity, platform) &&
                        entity.getVelocityY() > 0 &&
                        entity.getY() < platform.getCenter("y")
        );
    }

    private boolean collideDown(Entity entity, Platform platform) {
        return (
                o.overlap(entity, platform) &&
                        entity.getVelocityY() < 0 &&
                        entity.getY() > platform.getCenter("y")
        );
    }

    private boolean collideLeft(Entity entity, Platform platform) {
        return (
                o.overlap(entity, platform) &&
                        entity.getVelocityX() > 0 &&
                        entity.getX() < platform.getCenter("x")
        );
    }

    private boolean collideRight(Entity entity, Platform platform) {
        return (
                o.overlap(entity, platform) &&
                        entity.getVelocityX() < 0 &&
                        entity.getX() > platform.getCenter("x")
        );
    }

    // Entity - Platform
    public boolean collide(Entity entity, Entity entity_, String ColisionType) {
        boolean R = false;
        if (ColisionType.equalsIgnoreCase("down") || ColisionType.equalsIgnoreCase("all")) {
            if (collideDown(entity, entity_)) {
                R = true;
                entity.setVelocity(0, 0);
                entity.setY((entity_.getY() + entity_.getHeight()));
            }
        }
        if (ColisionType.equalsIgnoreCase("up") || ColisionType.equalsIgnoreCase("all")) {
            if (collideUp(entity, entity_)) {
                R = true;
                entity.setVelocity(0, 0);
                entity.setY(entity_.getY() - entity.getHeight());
            }
        }
        if (ColisionType.equalsIgnoreCase("left") || ColisionType.equalsIgnoreCase("all")) {
            if (collideLeft(entity, entity_)) {
                R = true;
                entity.setVelocity(0, entity.getVelocityY());
                entity.setX(entity_.getX() - entity.getWidth());
            }
        }
        if (ColisionType.equalsIgnoreCase("right") || ColisionType.equalsIgnoreCase("all")) {
            if (collideRight(entity, entity_)) {
                R = true;
                entity.setVelocity(0, entity.getVelocityY());
                entity.setX((entity_.getX() + entity_.getWidth()));
            }
        }
        return R;
    }

    private boolean collideUp(Entity entity, Entity entity_) {
        return (
                o.overlap(entity, entity_) &&
                        entity.getVelocityY() > 0 &&
                        entity.getY() < entity_.getCenter("y")
        );
    }

    private boolean collideDown(Entity entity, Entity entity_) {
        return (
                o.overlap(entity, entity_) &&
                        entity.getVelocityY() < 0 &&
                        entity.getY() > entity_.getCenter("y")
        );
    }

    private boolean collideLeft(Entity entity, Entity entity_) {
        return (
                o.overlap(entity, entity_) &&
                        entity.getVelocityX() > 0 &&
                        entity.getX() < entity_.getCenter("x")
        );
    }

    private boolean collideRight(Entity entity, Entity entity_) {
        return (
                o.overlap(entity, entity_) &&
                        entity.getVelocityX() < 0 &&
                        entity.getX() > entity_.getCenter("x")
        );
    }
}