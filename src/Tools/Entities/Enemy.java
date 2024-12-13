package Tools.Entities;

import java.awt.*;

public class Enemy {

    private int X, Y;
    private final int Width, Height;
    private final double[] Center = new double[2];
    private final double[][] Faces = new double[4][2];
    private int VelocityX, VelocityY;
    private Color EnemyColor;

    public Enemy(int x, int y, int width, int height){
        this.Width = width;
        this.Height = height;
        this.X = x;
        this.Y = y;

        this.Faces[0][0] = (x + ((double) width / 2)); this.Faces[0][1] = y;
        this.Faces[1][0] = (x + ((double) width / 2)); this.Faces[1][1] = (y + height);
        this.Faces[2][0] = x; this.Faces[2][1] = (y + ((double) height / 2));
        this.Faces[3][0] = (x + width); this.Faces[3][1] = (y + ((double) height / 2));

        this.Center[0] = (x + (double) (width / 2));
        this.Center[1] = (Y + (double) (height / 2));
    }

    public Enemy(double CenterX, double CenterY, int width, int height){
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
    }

    public void setVelocity(int x, int y){
        this.VelocityX = x;
        this.VelocityY = y;

        this.X += x;
        this.Y += y;

        this.Faces[0][0] = (X + ((double) Width / 2)); this.Faces[0][1] = Y;
        this.Faces[1][0] = (X + ((double) Width / 2)); this.Faces[1][1] = (Y + Height);
        this.Faces[2][0] = X; this.Faces[2][1] = (Y + ((double) Height / 2));
        this.Faces[3][0] = (X + Width); this.Faces[3][1] = (Y + ((double) Height / 2));

        this.Center[0] = (x + (double) (Width / 2));
        this.Center[1] = (Y + (double) (Height / 2));
    }
    public void setVelocity(double x, double y){
        this.VelocityX = Integer.parseInt(String.format("%.0f", x));
        this.VelocityY = Integer.parseInt(String.format("%.0f", y));

        this.X += Integer.parseInt(String.format("%.0f", x));
        this.Y += Integer.parseInt(String.format("%.0f", y));

        this.Faces[0][0] = (X + ((double) Width / 2)); this.Faces[0][1] = Y;
        this.Faces[1][0] = (X + ((double) Width / 2)); this.Faces[1][1] = (Y + Height);
        this.Faces[2][0] = X; this.Faces[2][1] = (Y + ((double) Height / 2));
        this.Faces[3][0] = (X + Width); this.Faces[3][1] = (Y + ((double) Height / 2));

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
    }
    public void setY(int y){
        this.Y = y;
        this.Center[1] = (Y + (double) (Height / 2));

        this.Faces[0][1] = y;
        this.Faces[1][1] = (y + Height);
        this.Faces[2][1] = (y + ((double) Height / 2));
        this.Faces[3][1] = (y + ((double) Height / 2));
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

    public void setEnemyColor(Color color){this.EnemyColor = color;}
    public Color getEnemyColor(){return EnemyColor;}
}
