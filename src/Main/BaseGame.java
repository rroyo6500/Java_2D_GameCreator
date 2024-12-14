package Main;

import GameEditor.GameEditor;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class BaseGame extends JFrame {

    static GameEditor GE = new GameEditor();

    public static JPanel World = GE.World();
    java.util.Timer Repaint;

    public BaseGame(){
        setLayout(null);

        World.setBounds(0, 0, GameEditor.Width, GameEditor.Height);
        World.setBackground(GameEditor.BgColor);

        World.setFocusable(true);
        World.requestFocusInWindow();
        add(World);

        IniciarJuego();

        setTitle("Java - 2d_GameEditor");
        setBounds(0,0,1016,1039);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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