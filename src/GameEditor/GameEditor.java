package GameEditor;

import Tools.Entities.Enemy;
import Tools.Entities.Player;
import Tools.Methods.Collide;
import Tools.Methods.Draw;
import Tools.Methods.Keyboard;
import Tools.Methods.Overlap;
import Tools.World.Colectable;
import Tools.World.Platform;

import javax.swing.*;
import java.awt.*;

public class GameEditor {

    public GameEditor(){}

    private final Draw D = new Draw();
    private final Keyboard K = new Keyboard();
    private final Collide C = new Collide();
    private final Overlap O = new Overlap();

    Player pj = new Player(0, 0, 50, 50);
    Platform platform = new Platform(200, 450, 100, 50);
    Enemy enemy = new Enemy(475, 475, 25, 25);

    /*      AVISO:
            --> El correcto funcionamiento de las colisiones depende del tamaño de la plaraforma (Platform) y el Juegador | Enemigo (Player | Enemy)

            --> Si un enemigo tiene mas de 1 de HP revisa que cuando deva perder vida deje de estar en contacto con lo que le quite vida. Si continua en contacto la vida baja 60 puntos/s
     */

    public static int FrameRate = 60;

    public static int Width = 500, Height = 500;
    public static Color BgColor = Color.black;

    boolean Suelo = false;
    boolean enemy_Left = true;

    public JPanel World(){
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);

                if ((K.getUpKey() || K.getCustomKey("W")) && Suelo) {
                    Suelo = false;
                    pj.setVelocity(0, -15);
                }
                if (K.getLeftKey() || K.getCustomKey("A")) pj.setVelocity(-2, pj.getVelocityY());
                if (K.getRightKey() || K.getCustomKey("D")) pj.setVelocity(2, pj.getVelocityY());

                pj.setVelocity(0, pj.getVelocityY() + 1);
                if (pj.getFaceDown("y") > Height){
                    Suelo = true;
                    pj.setY(Width - pj.getHeight());
                }

                if (C.collide(enemy, platform, "right") || (enemy.getFaceRight("x") > Width)){
                    enemy_Left = !enemy_Left;
                }
                if (enemy_Left) enemy.setVelocity(-2, 0);
                else enemy.setVelocity(2, 0);

                if (O.overlap(pj, enemy)){
                    D.delete(pj);
                }

                C.collide(pj, platform, "all");

                D.draw(g, pj);
                D.draw(g, platform);
                D.draw(g, enemy);
            }
        };
    }

}