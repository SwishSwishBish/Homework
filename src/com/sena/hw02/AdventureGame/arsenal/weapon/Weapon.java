package com.sena.hw02.AdventureGame.arsenal.weapon;

public abstract class Weapon {
    protected int damage;
    protected int money;

    public Weapon(){
    }

    public int getDamage() {
        return damage;
    }

    public int getMoney() {
        return money;
    }
}
