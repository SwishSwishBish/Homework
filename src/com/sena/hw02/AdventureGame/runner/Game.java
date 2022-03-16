package com.sena.hw02.AdventureGame.runner;

import com.sena.hw02.AdventureGame.location.Location;
import com.sena.hw02.AdventureGame.location.combatlocation.Cave;
import com.sena.hw02.AdventureGame.location.combatlocation.Forest;
import com.sena.hw02.AdventureGame.location.combatlocation.River;
import com.sena.hw02.AdventureGame.location.usuallocation.SafeHouse;
import com.sena.hw02.AdventureGame.location.usuallocation.Store;

import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    Player player;

    public void start() {
        System.out.println("Welcome to the game!");
        System.out.print("Please enter your name: ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);
        System.out.println(player.getName() + ", you'll forge a new destiny for yourself as an adventurer shipwrecked " +
                "on the supernatural island of Terra!");
        player.selectChar();
        selectLocation();
    }

    public void selectLocation() {
        Scanner scanner = new Scanner(System.in);
        Location location = new SafeHouse(player);
        int choice;
        do{
            System.out.println("Starting Zones:" + "\n" +
                    "0-Exit --> You can quit" + "\n" +
                    "1-Safe House --> You can rest here" + "\n" +
                    "2-ToolStore --> You can buy arsenal" + "\n" +
                    "3-Cave --> < Prize:Food >Enter the Cave , beware zombies roaming !" + "\n" +
                    "4-Forest --> < Prize:Wood > Enter the Forest , beware bears roaming !" + "\n" +
                    "5-River --> < Prize:Water > Enter the River , beware vampires roaming !" + "\n" +
                    "6-Mine --> < Prize:Item,Gold > Enter the Cave , beware snakes roaming !");
            System.out.println("=======================================================================");
            System.out.print("-->");
            choice = scanner.nextInt();
            while (choice < -1 || choice > 6) {
                System.out.print("Please enter valid number! ");
                choice = scanner.nextInt();
            }
            switch (choice) {
                case 1 -> location = new SafeHouse(player);
                case 2 -> location = new Store(player);
                case 3 -> location = new Cave(player);
                case 4 -> location = new Forest(player);
                case 5 -> location = new River(player);
                default -> choice=0;
            }


            if (!location.onLocation()) {
                System.out.println("Game Over !");
                break;
            }

            if (location.getClass().getName().equals(SafeHouse.class.getName()) && player.isPrize()) {
                System.out.println("You have fulfilled all the conditions and won the game!");
                break;
            }


        }while(choice!=0);

    }
}
