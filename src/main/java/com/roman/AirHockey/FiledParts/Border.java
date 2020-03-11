package com.roman.AirHockey.FiledParts;

import com.roman.AirHockey.GamePart;
import com.roman.AirHockey.Main.MainPanel;

import java.awt.*;

public class Border implements GamePart {
    public static final int BORDER_SIZE = 15;
    public static final int SOUTH = 0;
    public static final int NORTH = 1;
    public static final int WEST = 2;
    public static final int EAST = 3;

    private Color color;
    private int side;

    public Border(Color c, int side){
        this.color = c;
        this.side = side;
    }

    @Override
    public void update() { }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        switch (side){
            case 0:
                g.fillRect(0, MainPanel.HEIGHT-BORDER_SIZE, MainPanel.WIDTH, BORDER_SIZE);
                break;
            case 1:
                g.fillRect(0, 0, MainPanel.WIDTH, BORDER_SIZE); //North
                break;
            case 2:
                g.fillRect(0, BORDER_SIZE, BORDER_SIZE, MainPanel.HEIGHT-2*BORDER_SIZE);
                break;
            case 3:
                g.fillRect(MainPanel.WIDTH-BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, MainPanel.HEIGHT-2*BORDER_SIZE);
                break;
        }
    }
}
