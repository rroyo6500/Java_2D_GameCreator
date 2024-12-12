import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import GameEditor.GameEditor;

public class Main { public static void main(String[] args) {new BaseGame();}}

class BaseGame extends JFrame{

    GameEditor GE = new GameEditor();

    JPanel World = GE.World();
    Timer Repaint, MovPlayer;

    public BaseGame(){
        setLayout(null);

        World.setBounds(0, 0, GameEditor.Width, GameEditor.Height);
        World.setBackground(GameEditor.BgColor);

        World.setFocusable(true);
        World.requestFocusInWindow();
        add(World);

        IniciarJuego();

        setTitle("Java - 2d_GameEditor");
        setBounds(0,0,516,539);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void IniciarJuego(){
        Repaint = new Timer();
        Repaint.schedule(new TimerTask() {
            @Override
            public void run() {
                World.repaint();
            }
        }, 0 , (1000 / GameEditor.FrameRate));
    }

}