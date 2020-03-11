package com.roman.AirHockey.Strategy;

import com.roman.AirHockey.Player.Puck;

public class MainStrategy implements Strategy{
    private Puck puck;

    public MainStrategy(Puck puck){
        this.puck = puck;
    }
}
