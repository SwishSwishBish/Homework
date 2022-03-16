package com.sena.hw02.AdventureGame.location.combatlocation;


import com.sena.hw02.AdventureGame.obstacle.Vampire;
import com.sena.hw02.AdventureGame.runner.Player;

public class Forest extends CombatLocation{
    public Forest(Player player) {
        super(player, "Forest", new Vampire(),"Wood");
    }
}
