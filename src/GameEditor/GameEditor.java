package GameEditor;

import Tools.Entities.Player;
import Tools.Methods.Collide;
import Tools.World.Platform;

import javax.swing.*;
import java.awt.*;

public class GameEditor {

    private final Collide collide = new Collide();
    private final Player pj = new Player(450, 225, 50, 50);
    private final Platform plataforma1 = new Platform(245, 245, 10, 10);

    public static int FrameRate = 60;

    public static int Width = 500, Height = 500;
    public static Color BgColor = Color.black;

    public GameEditor(){}

    public JPanel World(){
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);

                pj.setVelocity(pj.getVelocityX() - 1, 0);
                if (pj.getY() > (Height - pj.getHeight())){
                    pj.setY(Height - pj.getHeight());
                }

                collide.Player_Collide(pj, plataforma1, true);

                g.setColor(pj.getPlayerColor());
                g.fillRect(pj.getX(), pj.getY(), pj.getWidth(), pj.getHeight());

                g.setColor(plataforma1.getPlatformColor());
                g.fillRect(plataforma1.getX(), plataforma1.getY(), plataforma1.getWidth(), plataforma1.getHeight());

            }
        };
    }

}
