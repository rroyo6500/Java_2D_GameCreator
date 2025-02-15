package Tools.Entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EntitySprites {

    private Entity entity;

    private BufferedImage Jump, JumpLeft, JumpRight;
    private BufferedImage Still, StillLeft, StillRight;
    private BufferedImage Crouched, CrouchedLeft, CrouchedRight;
    private BufferedImage Movement, MovementLeft, MovementRight;
    private BufferedImage Death;

    public EntitySprites(){}

    public void setEntity(Entity entity){
        this.entity = entity;
    }

    // Jump

    /**
     * Permite añadir una textura para el salto de la entidad.
     *
     * @param ImagePath {@code ImagePath} == '{@code C:\Users\<user>\Sprites\<sprite>.<png | gif | jpg>}'.
     * @param Orientation {@code Orientation} == '{@code Left - L | Right - R}'.
     */
    public void setJump(String ImagePath, String Orientation){
        try {
            if (Orientation.equalsIgnoreCase("left") || Orientation.equalsIgnoreCase("l")) {
                this.JumpLeft = ImageIO.read(new File(ImagePath));
            } else if (Orientation.equalsIgnoreCase("right") || Orientation.equalsIgnoreCase("r")) {
                this.JumpRight = ImageIO.read(new File(ImagePath));
            }
            if ((int) (Math.random() * 2) == 0) Jump = JumpLeft;
            else Jump = JumpRight;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public BufferedImage getJump(){
        if (entity.getVelocityX() < 0) Jump = JumpLeft;
        else if (entity.getVelocityX() > 0) Jump = JumpRight;
        return Jump;
    }

    // Still

    /**
     * Permite añadir una textura para cuando la entidad esté quieta
     *
     * @param ImagePath {@code ImagePath} == '{@code C:\Users\<user>\Sprites\<sprite>.<png | gif | jpg>}'.
     * @param Orientation {@code Orientation} == '{@code Left - L | Right - R}'.
     */
    public void setStill(String ImagePath, String Orientation){
        try {
            if (Orientation.equalsIgnoreCase("left") || Orientation.equalsIgnoreCase("l")) {
                this.StillLeft = ImageIO.read(new File(ImagePath));
            } else if (Orientation.equalsIgnoreCase("right") || Orientation.equalsIgnoreCase("r")) {
                this.StillRight = ImageIO.read(new File(ImagePath));
            }
            if ((int) (Math.random() * 2) == 0) Still = StillLeft;
            else Still = StillRight;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public BufferedImage getStill(){
        /*
        Crear forma de que mire al mismo lado al que miraba al moverse
         */
        return Still;
    }

    // Crouched

    /**
     * Permite añadir una textura para cuando la entidad esté agachada.
     *
     * @param ImagePath {@code ImagePath} == '{@code C:\Users\<user>\Sprites\<sprite>.<png | gif | jpg>}'.
     * @param Orientation {@code Orientation} == '{@code Left - L | Right - R}'.
     */
    public void setCrouched(String ImagePath, String Orientation){
        try {
            if (Orientation.equalsIgnoreCase("left") || Orientation.equalsIgnoreCase("l")) {
                this.CrouchedLeft = ImageIO.read(new File(ImagePath));
            } else if (Orientation.equalsIgnoreCase("right") || Orientation.equalsIgnoreCase("r")) {
                this.CrouchedRight = ImageIO.read(new File(ImagePath));
            }
            if ((int) (Math.random() * 2) == 0) Crouched = CrouchedLeft;
            else Crouched = CrouchedRight;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public BufferedImage getCrouched(){
        if (entity.getVelocityX() < 0) Crouched = CrouchedLeft;
        else if (entity.getVelocityX() > 0) Crouched = CrouchedRight;
        return Crouched;
    }

    // Movement

    /**
     * Permite añadir una textura para el movimiento de la entidad.
     *
     * @param ImagePath {@code ImagePath} == '{@code C:\Users\<user>\Sprites\<sprite>.<png | gif | jpg>}'.
     * @param Orientation {@code Orientation} == '{@code Left - L | Right - R}'.
     */
    public void setMovement(String ImagePath, String Orientation){
        try {
            if (Orientation.equalsIgnoreCase("left") || Orientation.equalsIgnoreCase("l")) {
                this.MovementLeft = ImageIO.read(new File(ImagePath));
            } else if (Orientation.equalsIgnoreCase("right") || Orientation.equalsIgnoreCase("r")) {
                this.MovementRight = ImageIO.read(new File(ImagePath));
            }
            if ((int) (Math.random() * 2) == 0) Movement = MovementLeft;
            else Movement = MovementRight;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public BufferedImage getMovement(){
        if (entity.getVelocityX() < 0) Movement = MovementLeft;
        else if (entity.getVelocityX() > 0) Movement = MovementRight;
        return Movement;
    }

    // Death

    /**
     * Permite añadir una textura para cuando la entidad sea eliminada.
     *
     * @param ImagePath {@code ImagePath} == '{@code C:\Users\<user>\Sprites\<sprite>.<png | gif | jpg>}'.
     */
    public void setDeath(String ImagePath){
        try {
            Death = ImageIO.read(new File(ImagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public BufferedImage getDeath(){return Death;}
}
