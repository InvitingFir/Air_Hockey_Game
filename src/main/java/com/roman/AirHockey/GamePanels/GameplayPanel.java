package com.roman.AirHockey.GamePanels;

import com.roman.AirHockey.FiledParts.Border;
import com.roman.AirHockey.GamePart;
import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Player.Player;
import com.roman.AirHockey.Player.Puck;

import java.awt.*;
import java.util.ArrayList;

public class GameplayPanel implements GamePanel {
    private ArrayList<GamePart> GameParts;
    private ArrayList<GamePart> Players;
    private ArrayList<GamePart> Pucks;

    //PanelManager
    private GameStateManager gsm;

    public GameplayPanel(GameStateManager gsm){
        this.gsm = gsm;
        GameParts = new ArrayList<>();
        Players = new ArrayList<>();
        Pucks = new ArrayList<>();
        Players.add(new Player(MainPanel.WIDTH-40, MainPanel.HEIGHT/2, 30));
        Pucks.add(new Puck(80, MainPanel.HEIGHT-80, 20, 3, Players));
        GameParts.add(new Border(Color.YELLOW, 0));
        GameParts.add(new Border(Color.RED, 1));
        GameParts.add(new Border(Color.BLUE, 2));
        GameParts.add(new Border(Color.GREEN, 3));
    }

    public void update() {
        for (GamePart g: Players) { g.update(); }
        for (GamePart g: Pucks) { g.update();}
        for (GamePart g: GameParts) { g.update();}
    }

    public void redraw(Graphics2D g) {
        for (GamePart gg: Players) { gg.draw(g); }
        for (GamePart gg: Pucks) { gg.draw(g);}
        for (GamePart gg: GameParts) { gg.draw(g);}
    }
}
