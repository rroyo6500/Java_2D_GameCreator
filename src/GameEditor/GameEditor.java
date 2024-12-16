package GameEditor;

import Main.Utils;
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

    private final Utils U = new Utils();
    private final Draw D = new Draw();
    private final Keyboard K = new Keyboard();
    private final Collide C = new Collide();
    private final Overlap O = new Overlap();

    public static int FrameRate = 60;

    public static int Width = 1000, Height = 1000;
    public static Color BgColor = Color.black;

    Player player = new Player(475, 0, 50, 50);
    Platform platform = new Platform(495, 900, 10, 100);
    Enemy enemy = new Enemy(10, 950, 50, 50);
    Colectable coin = new Colectable(750, 970, 10, 10);

    /*      AVISO:
            --> Por defecto los Enemigos tienen uno de HP.
                En caso de que se le ponga una cantidad custom verifica que al momento de perder puntos de HP deje de estar en contacto con el jugador y/o lo que le quite puntos de HP.
                Si continúa en contacto los puntos de HP bajarán a la misma belocidad que el FrameRate
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
                    player.setVelocity(player.getVelocityX(), -10);
                } else if ((K.getUpKey() || K.getCustomKey("W")) && Suelo) {
                    Suelo = false;
                    player.setVelocity(player.getVelocityX(), -25);
                } else {
                    if (K.getLeftKey() || K.getCustomKey("A")) player.setVelocity(-4, player.getVelocityY());
                    if (K.getRightKey() || K.getCustomKey("D")) player.setVelocity(4, player.getVelocityY());
                }

                player.setVelocity(0, player.getVelocityY() + 2);
                if (player.getFaceDown("y") > Height){
                    Suelo = true;
                    player.setVelocity(0, 0);
                    player.setY(Width - player.getHeight());
                }

                if (C.collide(player, enemy, "up")){
                    Suelo = true;
                    D.delete(enemy);
                } else if (O.overlap(player, enemy)) {
                    D.delete(player);
                }

                if (enemy_Left) enemy.setVelocity(4, 0);
                else enemy.setVelocity(-4, 0);

                if (C.collide(enemy, platform, "left")) enemy_Left = !enemy_Left;
                else if (enemy.getFaceLeft("x") <= 0) enemy_Left = !enemy_Left;

                if (O.overlap(coin, player)){
                    D.delete(coin);
                }

                C.collide(player, platform, "all");
                if (C.collide(player, platform, "up")){
                    Suelo = true;
                }

                D.draw(g, player);
                D.draw(g, coin);
                D.draw(g, platform);
                D.draw(g, enemy);
            }
        };
    }
}