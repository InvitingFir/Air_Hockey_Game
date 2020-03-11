package com.roman.AirHockey.Player;

import com.roman.AirHockey.FiledParts.Border;
import com.roman.AirHockey.GamePart;
import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Util.Vector;

import java.awt.*;

public class Player implements GamePart {

    private int radius;
    private int x;
    private int y;

    private Color color;

    private double speed;
    //private Strategy strategy;

    public Player(int x, int y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.speed = 0;
        color = Color.GRAY;
    }

    public void update(){
        int x = MainPanel.getMouseX();
        int y = MainPanel.getMouseY();
        Vector vector = new Vector(this.x, this.y, x, y);
        if(x-radius >= Border.BORDER_SIZE && x+radius <= MainPanel.WIDTH- Border.BORDER_SIZE) {
            if(y-radius >= Border.BORDER_SIZE && y+radius <= MainPanel.HEIGHT-Border.BORDER_SIZE) {
                this.y = y;
                this.x = x;
                this.speed = vector.getLength();
            }
        }
    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval(x-radius, y-radius, radius*2, radius*2);
    }


    public int getX(){ return x;}

    public int getY(){ return y;}

    public int getRadius(){ return radius;}

    public double getSpeed() { return speed; }
}
