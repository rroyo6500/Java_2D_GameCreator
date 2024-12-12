package Tools.World;

import java.awt.*;

public class Platform {

    private int X, Y;
    private final int Width, Height;
    private final double[] Center = new double[2];
    private Color PlatformColor = Color.GRAY;

    public Platform(int x, int y, int width, int height){
        this.Width = width;
        this.Height = height;
        this.X = x;
        this.Y = y;

        this.Center[0] = (x + (double) (width / 2));
        this.Center[1] = (Y + (double) (height / 2));
    }

    public void setX(int x){this.X = x; this.Center[0] = (x + (double) (Width / 2));}
    public void setY(int y){this.Y = y; this.Center[1] = (Y + (double) (Height / 2));}
    public void setCenter(int x, int y){
        this.Center[0] = x;
        this.Center[1] = y;

        this.X += (x - (Width / 2));
        this.Y += (y - (Height / 2));
    }

    public double getCenter(String x_y){
        if (x_y.equalsIgnoreCase("X")) return Center[0];
        else if (x_y.equalsIgnoreCase("Y")) return Center[1];
        return 0;
    }
    public int getX(){return X;}
    public int getY(){return Y;}
    public int getWidth(){return Width;}
    public int getHeight(){return Height;}

    public void setPlatformColor(Color color){this.PlatformColor = color;}
    public Color getPlatformColor(){return PlatformColor;}
}
