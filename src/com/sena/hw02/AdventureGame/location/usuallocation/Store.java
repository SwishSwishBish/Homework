package com.sena.hw02.AdventureGame.location.usuallocation;

import com.sena.hw02.AdventureGame.arsenal.armor.Armor;
import com.sena.hw02.AdventureGame.arsenal.armor.HeavyArmor;
import com.sena.hw02.AdventureGame.arsenal.armor.LightArmor;
import com.sena.hw02.AdventureGame.arsenal.armor.MediumArmor;
import com.sena.hw02.AdventureGame.arsenal.weapon.Gun;
import com.sena.hw02.AdventureGame.arsenal.weapon.Rifle;
import com.sena.hw02.AdventureGame.arsenal.weapon.Sword;
import com.sena.hw02.AdventureGame.arsenal.weapon.Weapon;
import com.sena.hw02.AdventureGame.location.Location;
import com.sena.hw02.AdventureGame.runner.Player;

import java.util.Scanner;

public class Store extends UsualLocation{


    public Store(Player player) {
        super(player, "Store");
    }
    @Override
    public boolean onLocation() {
        int choice;
        do{
            System.out.println(" Welcome to the Store! ");
            System.out.println(" 1-Weapons \n" +
                    " 2-Armors \n" +
                    " 3-Exit ");
            System.out.print("-->");
            choice = Location.scanner.nextInt();
            while (choice < 1 || choice > 3) {
                System.out.println("Please enter valid option");
                choice = Location.scanner.nextInt();
            }

            switch (choice) {
                case 1 -> printWeapons();
                case 2 -> printArmors();
                case 3 -> System.out.println(" Hope to see you again soon adventurer ");
            }
        }while(choice!=3);
        return true;
    }
    public void printWeapons(){
        Weapon[] weapons = {new Gun(), new Sword(), new Rifle()};
        System.out.println("Weapon classes shop:" + "\n" +
                "Gun damage: " + (weapons[0].getDamage() + "\t" +
                "Gun money: " + (weapons[0].getMoney() + "\n" +
                "Sword damage: " + weapons[1].getDamage() + "\t" +
                "Sword money: " + weapons[1].getMoney() + "\n" +
                "Rifle damage: " + weapons[2].getDamage() + "\t" +
                "Rifle money: " + weapons[2].getMoney())));
        System.out.println("#################################################### ");
        System.out.println("Please choose the weapon you want to buy" + "\n" +
                " 1-Gun   " + "\n" +
                " 2-Sword " + "\n" +
                " 3-Rifle ");
        int weaponChoice = Location.scanner.nextInt();
        while (weaponChoice < 1 || weaponChoice > weapons.length) {
            System.out.println("Please enter valid number!");
            weaponChoice = Location.scanner.nextInt();
        }

        buyWeapons(weapons, weaponChoice);
    }
    public void printArmors(){
        Armor[] armors = {new LightArmor(), new MediumArmor(), new HeavyArmor()};

        System.out.println("Armor classes shop:" + "\n" +
                "Light Armor block:  " + (armors[0].getBlock() + "\t" +
                "Light Armor money:  " + (armors[0].getMoney() + "\n" +
                "Medium Armor block: " + armors[1].getBlock() + "\t" +
                "Medium Armor money: " + armors[1].getMoney() + "\n" +
                "Heavy Armor block:  " + armors[2].getBlock() + "\t" +
                "Heavy Armor money:  " + armors[2].getMoney())));
        System.out.println("#################################################### ");
        System.out.println("Please choose the armor you want to buy" + "\n" +
                " 1-Light Armor  " + "\n" +
                " 2-Medium Armor " + "\n" +
                " 3-Heavy Armor  ");
        int armorChoice = Location.scanner.nextInt();
        while (armorChoice < 1 || armorChoice > armors.length) {
            System.out.println("Please enter valid number!");
            armorChoice = Location.scanner.nextInt();
        }

        buyArmors(armors, armorChoice);
    }

    public void buyWeapons(Weapon[] weapons, int weaponChoice) {

        if (weapons[weaponChoice - 1].getMoney() > getPlayer().getMoney()) {
            System.out.println("You don't have enough money");
        } else {
            getPlayer().getInventory().setWeaponDamage(weapons[weaponChoice - 1].getDamage());
            getPlayer().getInventory().setWeaponName(weapons[weaponChoice - 1].getClass().getSimpleName());
            getPlayer().setMoney(getPlayer().getMoney() - weapons[weaponChoice - 1].getMoney());
            getPlayer().setDamage(this.getPlayer().getDamage() +  this.getPlayer().getInventory().getWeaponDamage());
            System.out.println("Remaining money: " + getPlayer().getMoney() + "\n" +
                    "Your new weapon set: " + this.getPlayer().getInventory().getWeaponName());




        }

    }

    public void buyArmors(Armor[] armors, int armorChoice) {

        if (armors[armorChoice - 1].getMoney() > getPlayer().getMoney()) {
            System.out.println("You don't have enough money");
        } else {
            this.getPlayer().getInventory().setArmorDefence(armors[armorChoice - 1].getBlock());
            this.getPlayer().getInventory().setArmorName(armors[armorChoice - 1].getClass().getSimpleName());
            this.getPlayer().setMoney(this.getPlayer().getMoney() - armors[armorChoice - 1].getMoney());
            System.out.println("Remaining money: " + this.getPlayer().getMoney() + "\n" +
                    "Your new armor set: " +  this.getPlayer().getInventory().getArmorName() + "\n" +
                    "Your new armor defence: " + this.getPlayer().getInventory().getArmorDefence());



        }

    }
}
