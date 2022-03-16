package com.sena.hw02.AdventureGame.location.usuallocation;

import com.sena.hw02.AdventureGame.runner.Player;

public class SafeHouse extends UsualLocation {
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        player.setHealth(player.getHealth());
        System.out.println("You are in SafeHouse" + "\n" +
                "Your health is restored");
        return true;
    }
}
