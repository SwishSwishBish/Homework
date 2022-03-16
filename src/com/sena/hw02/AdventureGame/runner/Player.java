package com.sena.hw02.AdventureGame.runner;

import com.sena.hw02.AdventureGame.character.*;
import com.sena.hw02.AdventureGame.character.Character;
import com.sena.hw02.AdventureGame.inventory.Inventory;


import java.util.Scanner;

public class Player {
    private String name;
    private String charName;
    private int damage, health, money, defaultHealth;
    Character[] character = {new Samurai(), new Archer(), new Knight()};
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
    }

    public void selectChar() {
        Scanner scanner = new Scanner(System.in);
        inventory = new Inventory();
        showScreen();
        System.out.print("-->");
        int choice = scanner.nextInt();
        while (choice < 0 || choice > 3) {
            System.out.print("Please enter valid number! ");
            choice = scanner.nextInt();
        }
        this.setDamage(character[choice].getDamage());
        this.setHealth(character[choice].getHealth());
        this.setMoney(character[choice].getMoney());
        this.setDefaultHealth(character[choice].getHealth());

        printInfo();
    }
    public void showScreen() {
        System.out.println("=======================================================================");
        System.out.println("Character classes stats:" + "\n" +
                "Samurai damage: " + character[0].getDamage() + "\t" +
                "Samurai health: " + character[0].getHealth() + "\t" +
                "Samurai money: " + character[0].getMoney() + "\n" +
                "Archer damage: " + character[1].getDamage() + "\t" +
                "Archer health: " + character[1].getHealth() + "\t" +
                "Archer money: " + character[1].getMoney() + "\n" +
                "Knight damage: " + character[2].getDamage() + "\t" +
                "Knight health: " + character[2].getHealth() + "\t" +
                "Knight money: " + character[2].getMoney());
        System.out.println("=======================================================================");
        System.out.println(" Please choose your character:" + "\n" +
                "1-Samurai" + "\n" +
                "2-Archer" + "\n" +
                "3-Knight");
        System.out.println("=======================================================================");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public void printInfo() {

        System.out.println("Player name: " + this.getName() + "\t" + "Player damage: " + this.getDamage() + "\t" +
                "Player health: " + this.getHealth() + "\t" +
                "Player money: " + this.getMoney() + "\t" +
                "Player armor set: " + this.getInventory().getArmorName() + "\t" +
                "Player weapon set: " + this.getInventory().getWeaponName());
    }

    public boolean isPrize() {
        return this.getInventory().isWater() && this.getInventory().isFirewood() && this.getInventory().isFood();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
