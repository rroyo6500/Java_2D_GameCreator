package Tools.World;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WorldSprites {

    private Platform platform;
    private Colectable colectable;

    private BufferedImage Sprite;

    public WorldSprites(){}

    public void setObject(Platform platform){
        this.platform = platform;
    }
    public void setObject(Colectable colectable){
        this.colectable = colectable;
    }

    /**
     * Permite añadir una textura al Objeto {@code [ Platform | Colectable ]}.
     *
     * @param ImagePath {@code ImagePath} == '{@code C:\Users\<user>\Sprites\<sprite>.<png | gif | jpg>}'.
     */
    public void setTexture(String ImagePath){
        try {
            this.Sprite = ImageIO.read(new File(ImagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public BufferedImage getTexture(){return Sprite;}
}
