package com.sena.hw02.AdventureGame.location.combatlocation;

import com.sena.hw02.AdventureGame.obstacle.Zombie;
import com.sena.hw02.AdventureGame.runner.Player;

public class Cave extends CombatLocation {

    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "Food");
    }
}
