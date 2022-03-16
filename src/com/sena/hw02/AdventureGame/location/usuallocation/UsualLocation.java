package com.sena.hw02.AdventureGame.location.usuallocation;

import com.sena.hw02.AdventureGame.location.Location;
import com.sena.hw02.AdventureGame.runner.Player;

public abstract class UsualLocation extends Location {

    UsualLocation(Player player, String name) {
        super(player);
        this.name = name;
    }

    @Override
    public boolean onLocation() {
        return true;
    }



}
