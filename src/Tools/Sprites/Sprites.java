package Tools.Sprites;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Sprites {

    public Sprites(){}

    // Static Sprites
    private BufferedImage jump, still, MoveLeft, MoveRight, crouched;

    public void setJumpSprite(String ImagePath){
        try {
            this.jump = ImageIO.read(new File(ImagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setStillSprite(String ImagePath){
        try {
            this.still = ImageIO.read(new File(ImagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setCrouchedSprite(String ImagePath){
        try {
            this.crouched = ImageIO.read(new File(ImagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setLeftMovementSprite(String ImagePath){
        try {
            this.MoveLeft = ImageIO.read(new File(ImagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setRightMovementSprite(String ImagePath){
        try {
            this.MoveRight = ImageIO.read(new File(ImagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage jump(){return jump;}
    public BufferedImage still(){return still;}
    public BufferedImage coruched(){return crouched;}
    public BufferedImage left(){return MoveLeft;}
    public BufferedImage right(){return MoveRight;}

    // Animated Sprites
}
