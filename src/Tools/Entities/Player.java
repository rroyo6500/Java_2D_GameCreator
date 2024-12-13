package Tools.Entities;

import java.awt.*;

public class Player {

    private int X, Y;
    private final int Width, Height;
    private final double[] Center = new double[2];
    private int VelocityX, VelocityY;
    private Color PlayerColor = Color.CYAN;

    public Player(int x, int y, int width, int height){
        this.Width = width;
        this.Height = height;
        this.X = x;
        this.Y = y;

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
    }

    public void setVelocity(int x, int y){
        this.VelocityX = x;
        this.VelocityY = y;

        this.X += x;
        this.Y += y;

        this.Center[0] = (X + (double) (Width / 2));
        this.Center[1] = (Y + (double) (Height / 2));
    }

    public void setX(int x){this.X = x; this.Center[0] = (x + (double) (Width / 2));}
    public void setY(int y){this.Y = y; this.Center[1] = (Y + (double) (Height / 2));}
    public void setCenter(int x, int y){
        this.Center[0] = x;
        this.Center[1] = y;

        this.X += (int) (Center[0] - ((double) Width / 2));
        this.Y += (int) (Center[1] - ((double) Height / 2));
    }

    public int getVelocityX(){return VelocityX;}
    public int getVelocityY(){return VelocityY;}
    public double getCenter(String x_y){
        double R = 0;
        if (x_y.equalsIgnoreCase("X")) R = Center[0];
        else if (x_y.equalsIgnoreCase("Y")) R = Center[1];
        return R;
    }
    public double[] getCenter(){
        return Center;
    }
    public int getX(){return X;}
    public int getY(){return Y;}
    public int getWidth(){return Width;}
    public int getHeight(){return Height;}

    public void setPlayerColor(Color color){this.PlayerColor = color;}
    public Color getPlayerColor(){return PlayerColor;}
}
