package com.sena.hw02.AdventureGame.obstacle;

public abstract class Obstacle {
    protected int id,
            damage,
            health,
            money;
    protected final int defaultHealth;
    protected String prize;

    public Obstacle(int id, int damage, int health, int money) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.defaultHealth = health;
    }

    public int getId() {
        return id;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
       return health;
    }

    public int getMoney() {
        return money;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public String getPrize() {
        return prize;
    }

    public void setHealth(int health) {
        this.health = health;
        if(health<0) health = 0;
    }
}
