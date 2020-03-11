package com.roman.AirHockey.Main;

import javax.swing.*;

public class Main {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 600;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Air Hockey");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(new MainPanel());
        frame.setSize(WIDTH, HEIGHT);
        frame.pack();
        frame.setVisible(true);
    }
}

//    TO-DO
//    1)написать реакцию на движение мышью
//    3) физика движения шайбы
//          3.1) прописать движение шайбы +
//          3.2) прописать рикошеты от клюжки игрока
//    4) вычисление скорости клюжки пользователя
