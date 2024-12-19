package Tools.Methods;

import Main.BaseGame;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class Keyboard {

    private final Set<Integer> activeKeys = new HashSet<>();
    private final Set<String> LactiveKeys = new HashSet<>();

    JPanel world;

    public Keyboard(){
        new Thread(() -> {
            /*while (true){
                try {
                    world = BaseGame.World;
                    world.setFocusable(true);
                    world.requestFocusInWindow();
                    world.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            activeKeys.add(e.getKeyCode());
                            LactiveKeys.add(KeyEvent.getKeyText(e.getKeyCode()));
                        }

                        @Override
                        public void keyReleased(KeyEvent e) {
                            activeKeys.remove(e.getKeyCode());
                            LactiveKeys.remove(KeyEvent.getKeyText(e.getKeyCode()));
                        }
                    });
                    break;
                } catch (Exception e) {
                    System.out.println(" a");
                }
            }*/
            world = BaseGame.World;
            world.setFocusable(true);
            world.requestFocusInWindow();
            world.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    activeKeys.add(e.getKeyCode());
                    LactiveKeys.add(KeyEvent.getKeyText(e.getKeyCode()));
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    activeKeys.remove(e.getKeyCode());
                    LactiveKeys.remove(KeyEvent.getKeyText(e.getKeyCode()));
                }
            });
        }).start();
    }

    public void PrintActiveKey(){
        System.out.println(activeKeys);
    }

    public boolean getUpKey(){
        return activeKeys.contains(38);
    }
    public boolean getDownKey(){
        return activeKeys.contains(40);
    }
    public boolean getLeftKey(){
        return activeKeys.contains(37);
    }
    public boolean getRightKey(){
        return activeKeys.contains(39);
    }

    public boolean getCustomKey(int KeyCode){
        return activeKeys.contains(KeyCode);
    }

    public boolean getCustomKey(String Key){
        return LactiveKeys.contains(Key);
    }

}