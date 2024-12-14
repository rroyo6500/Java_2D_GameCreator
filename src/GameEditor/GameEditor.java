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

    public static int FrameRate = 60;

    public static int Width = 1000, Height = 1000;
    public static Color BgColor = Color.black;

    Player pj = new Player(475, 0, 50, 50);
    Platform platform = new Platform(495, 900, 10, 100);
    Enemy enemy = new Enemy(10, 950, 50, 50);
    Colectable coin = new Colectable(750, 970, 10, 10);

    /*      AVISO:
            --> Por defecto los Enemigos tienen uno de HP.
                En caso de que se le ponga una cantidad custom verifica que al momento de perder puntos de HP deje de estar en contacto con el jugador y/o lo que le quiete puntos de HP.
                Si continua en contacto los puntos de HP bajaran a la mima belocidad que el FrameRate
                    FrameRate = 60
                    HP -> -60 / Segundo
     */

    boolean Suelo = false;
    boolean enemy_Left = true;

    public JPanel World(){
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);

                if ((K.getLeftKey() || K.getCustomKey("A")) && (K.getRightKey() || K.getCustomKey("D")) && Suelo){
                    Suelo = false;
                    pj.setVelocity(pj.getVelocityX(), -25);
                } else if ((K.getUpKey() || K.getCustomKey("W")) && Suelo) {
                    Suelo = false;
                    pj.setVelocity(pj.getVelocityX(), -25);
                } else {
                    if (K.getLeftKey() || K.getCustomKey("A")) pj.setVelocity(-4, pj.getVelocityY());
                    if (K.getRightKey() || K.getCustomKey("D")) pj.setVelocity(4, pj.getVelocityY());
                }

                pj.setVelocity(0, pj.getVelocityY() + 2);
                if (pj.getFaceDown("y") > Height){
                    Suelo = true;
                    pj.setVelocity(0, 0);
                    pj.setY(Width - pj.getHeight());
                }

                if (C.collide(pj, enemy, "up")){
                    Suelo = true;
                    D.delete(enemy);
                } else if (O.overlap(pj, enemy)) {
                    D.delete(pj);
                }

                if (enemy_Left) enemy.setVelocity(4, 0);
                else enemy.setVelocity(-4, 0);

                if (C.collide(enemy, platform, "left")) enemy_Left = !enemy_Left;
                else if (enemy.getFaceLeft("x") <= 0) enemy_Left = !enemy_Left;

                if (O.overlap(coin, pj)){
                    D.delete(coin);
                }

                C.collide(pj, platform, "all");
                if (C.collide(pj, platform, "up")){
                    Suelo = true;
                }

                D.draw(g, coin);
                D.draw(g, pj);
                D.draw(g, platform);
                D.draw(g, enemy);
            }
        };
    }

}