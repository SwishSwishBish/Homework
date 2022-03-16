package com.sena.hw02.AdventureGame.location;

import com.sena.hw02.AdventureGame.runner.Player;

import java.util.Scanner;

public abstract class Location {
    protected Player player;
    protected String name;
    public static Scanner scanner = new Scanner(System.in);

    public Location(Player player){
        this.player=player;
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public String getName() {
        return name;
    }
}
