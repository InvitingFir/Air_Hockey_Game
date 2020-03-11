package com.roman.AirHockey.Player;

import com.roman.AirHockey.FiledParts.Border;
import com.roman.AirHockey.GamePart;
import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Util.Vector;

import java.awt.*;
import java.util.ArrayList;

public class Puck implements GamePart {
    public static final double PUCK_ACCELERATION = 0.995;

    //puck
    private int puckX;
    private int puckY;
    private double lastX;
    private double lastY;
    private double deltaX;
    private double deltaY;
    private double puckAngle;
    private double puckSpeed;
    private int radius;
    private Color puckColor;

    //Players
    ArrayList<GamePart> Players;

    public Puck(int x, int y, int radius, int speed, ArrayList<GamePart> Players){
        this.puckX = x;
        this.puckY = y;
        this.puckSpeed = speed;
        this.radius = radius;
        this.Players = Players;
        this.puckAngle = 15*Math.PI/8;
        this.puckColor = Color.CYAN;
        lastCoordinatesUpdate();
    }

    public void draw(Graphics2D g){
        g.setColor(puckColor);
        g.fillArc(puckX-radius, puckY-radius, 2*radius, 2*radius, 0, 360);
    }

    public void update(){
        borderCollision();
        for (GamePart p: Players) { playerCollision((Player) p); }
        puckPositionUpdate();
    }

    private void borderCollision(){
        //Western border
        if(puckX-radius<= Border.BORDER_SIZE) {
            puckAngle = (3*Math.PI - puckAngle)%(2*Math.PI);
            puckX = Border.BORDER_SIZE + 1 + radius;
            lastCoordinatesUpdate();
        }
        //Eastern border
        else if(puckX+radius>= MainPanel.WIDTH-Border.BORDER_SIZE) {
            puckAngle = (3*Math.PI - puckAngle)%(2*Math.PI);
            puckX = MainPanel.WIDTH-Border.BORDER_SIZE - radius - 1;
            lastCoordinatesUpdate();
        }
        //Southern border
        else if(puckY+radius>=MainPanel.HEIGHT-Border.BORDER_SIZE) {
            puckAngle = (2*Math.PI - puckAngle)%(2*Math.PI);
            puckY = MainPanel.HEIGHT-Border.BORDER_SIZE-radius-1;
            lastCoordinatesUpdate();
        }
        //Northern border
        else if(puckY-radius<=Border.BORDER_SIZE) {
            puckAngle = (2*Math.PI - puckAngle)%(2*Math.PI);
            puckY = Border.BORDER_SIZE+1+radius;
            lastCoordinatesUpdate();
        }

    }

    private void playerCollision(Player player){
        Vector distance = new Vector(player.getX(), player.getY(), puckX, puckY);
        Vector puck = new Vector(lastX, lastY, puckX, puckY);
        if(distance.getLength()<= player.getRadius()+radius) {
            if((puckSpeed < 1) || (Vector.angleBetweenVectors(distance, puck) <= Math.PI/2)) {
                puckAngle = distance.getAngle();
                puckSpeed = player.getSpeed();
            }
            else {
                puckAngle = Math.PI + 2 * distance.getAngle() - puckAngle;
                puckSpeed += player.getSpeed();
            }
            puckX += Math.round((radius + player.getRadius() - distance.getLength() + 2) * Math.cos(puckAngle));
            puckY += Math.round((radius + player.getRadius() - distance.getLength() + 2) * Math.sin(puckAngle));
            lastCoordinatesUpdate();
        }
    }

    private void puckPositionUpdate(){
        puckSpeed*=PUCK_ACCELERATION;
        deltaX += Math.cos(puckAngle)*puckSpeed;
        deltaY += Math.sin(puckAngle)*puckSpeed;
        puckX = (int)(Math.round(lastX + deltaX));
        puckY = (int)(Math.round(lastY + deltaY));
    }

    private void lastCoordinatesUpdate(){
        lastX = puckX;
        lastY = puckY;
        deltaX = 0;
        deltaY = 0;
    }
}
