package Tools.Entities;

import Tools.Sprites.Sprites;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {

    private Sprites sprites = new Sprites();

    private int X, Y;
    private final int Width, Height;
    private final double[] Center = new double[2];
    private final double[][] Faces = new double[4][2];
    private final int[][] Vertex = new int[4][2];
    private int VelocityX, VelocityY;
    private boolean Alive = true;
    private Color PlayerColor = Color.CYAN;

    public Player(int x, int y, int width, int height){
        this.Width = width;
        this.Height = height;
        this.X = x;
        this.Y = y;

        this.Faces[0][0] = (x + ((double) width / 2)); this.Faces[0][1] = y;
        this.Faces[1][0] = (x + ((double) width / 2)); this.Faces[1][1] = (y + height);
        this.Faces[2][0] = x; this.Faces[2][1] = (y + ((double) height / 2));
        this.Faces[3][0] = (x + width); this.Faces[3][1] = (y + ((double) height / 2));

        this.Vertex[0][0] = x; this.Vertex[0][1] = y;
        this.Vertex[1][0] = (x + width); this.Vertex[1][1] = y;
        this.Vertex[2][0] = x; this.Vertex[2][1] = (y + height);
        this.Vertex[3][0] = (x + width); this.Vertex[3][1] = (y + height);

        this.Center[0] = (x + (double) (width / 2));
        this.Center[1] = (y + (double) (height / 2));
    }
    public Player(double CenterX, double CenterY, int width, int height){
        this.Width = width;
        this.Height = height;

        this.Center[0] = (CenterX);
        this.Center[1] = (CenterY);

        this.X = (int) (CenterX - ((double) width / 2));
        this.Y = (int) (CenterY - ((double) height / 2));

        this.Faces[0][0] = (X + ((double) width / 2)); this.Faces[0][1] = Y;
        this.Faces[1][0] = (X + ((double) width / 2)); this.Faces[1][1] = (Y + height);
        this.Faces[2][0] = X; this.Faces[2][1] = (Y + ((double) height / 2));
        this.Faces[3][0] = (X + width); this.Faces[3][1] = (Y + ((double) height / 2));

        this.Vertex[0][0] = X; this.Vertex[0][1] = Y;
        this.Vertex[1][0] = (X + width); this.Vertex[1][1] = Y;
        this.Vertex[2][0] = X; this.Vertex[2][1] = (Y + height);
        this.Vertex[3][0] = (X + width); this.Vertex[3][1] = (Y + height);
    }

    public void setVelocity(int x, int y){

        if (x > 48) x = 48;
        if (x < -48) x = -48;
        if (y > 48) y = 48;
        if (y < -48) y = -48;

        this.VelocityX = x;
        this.VelocityY = y;

        this.X += x;
        this.Y += y;

        this.Faces[0][0] = (X + ((double) Width / 2)); this.Faces[0][1] = Y;
        this.Faces[1][0] = (X + ((double) Width / 2)); this.Faces[1][1] = (Y + Height);
        this.Faces[2][0] = X; this.Faces[2][1] = (Y + ((double) Height / 2));
        this.Faces[3][0] = (X + Width); this.Faces[3][1] = (Y + ((double) Height / 2));

        this.Vertex[0][0] = X; this.Vertex[0][1] = Y;
        this.Vertex[1][0] = (X + Width); this.Vertex[1][1] = Y;
        this.Vertex[2][0] = X; this.Vertex[2][1] = (Y + Height);
        this.Vertex[3][0] = (X + Width); this.Vertex[3][1] = (Y + Height);

        this.Center[0] = (X + (double) (Width / 2));
        this.Center[1] = (Y + (double) (Height / 2));
    }

    public void setX(int x){
        this.X = x;
        this.Center[0] = (x + (double) (Width / 2));

        this.Faces[0][0] = (x + ((double) Width / 2));
        this.Faces[1][0] = (x + ((double) Width / 2));
        this.Faces[2][0] = x;
        this.Faces[3][0] = (x + Width);

        this.Vertex[0][0] = X;
        this.Vertex[1][0] = (X + Width);
        this.Vertex[2][0] = X;
        this.Vertex[3][0] = (X + Width);
    }
    public void setY(int y){
        this.Y = y;
        this.Center[1] = (Y + (double) (Height / 2));

        this.Faces[0][1] = y;
        this.Faces[1][1] = (y + Height);
        this.Faces[2][1] = (y + ((double) Height / 2));
        this.Faces[3][1] = (y + ((double) Height / 2));

        this.Vertex[0][1] = Y;
        this.Vertex[1][1] = Y;
        this.Vertex[2][1] = (Y + Height);
        this.Vertex[3][1] = (Y + Height);
    }

    public int getVelocityX(){return VelocityX;}
    public int getVelocityY(){return VelocityY;}
    public double getCenter(String x_y){
        double R = 0;
        if (x_y.equalsIgnoreCase("X")) R = Center[0];
        else if (x_y.equalsIgnoreCase("Y")) R = Center[1];
        return R;
    }
    public double[] getCenter(){return Center;}
    public int getX(){return X;}
    public int getY(){return Y;}
    public int getWidth(){return Width;}
    public int getHeight(){return Height;}

    public double getFaceUp(String x_y) {
        double R = 0;
        if (x_y.equalsIgnoreCase("X")) R = Faces[0][0];
        else if (x_y.equalsIgnoreCase("Y")) R = Faces[0][1];
        return R;
    }
    public double getFaceDown(String x_y) {
        double R = 0;
        if (x_y.equalsIgnoreCase("X")) R = Faces[1][0];
        else if (x_y.equalsIgnoreCase("Y")) R = Faces[1][1];
        return R;
    }
    public double getFaceLeft(String x_y) {
        double R = 0;
        if (x_y.equalsIgnoreCase("X")) R = Faces[2][0];
        else if (x_y.equalsIgnoreCase("Y")) R = Faces[2][1];
        return R;
    }
    public double getFaceRight(String x_y) {
        double R = 0;
        if (x_y.equalsIgnoreCase("X")) R = Faces[3][0];
        else if (x_y.equalsIgnoreCase("Y")) R = Faces[3][1];
        return R;
    }

    public int getVertex(int vertex, String x_y){
        int R = 0;
        if (x_y.equalsIgnoreCase("x")) R = Vertex[vertex][0];
        else if (x_y.equalsIgnoreCase("y")) R = Vertex[vertex][1];
        return R;
    }

    public void setAlive(boolean Alive){this.Alive = Alive;}
    public boolean getAlive(){return Alive;}

    public void setPlayerColor(Color color){this.PlayerColor = color;}
    public Color getPlayerColor(){return PlayerColor;}

    // Sprites
    public Sprites Sprites(){return sprites;}
}