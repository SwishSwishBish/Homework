package com.sena.hw02.AdventureGame.location.combatlocation;

import com.sena.hw02.AdventureGame.obstacle.Bear;
import com.sena.hw02.AdventureGame.runner.Player;

public class River extends CombatLocation{
    public River(Player player) {
        super(player, "River", new Bear(),"Water");}
}
