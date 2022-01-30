package com.sena.hw01;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Odev4 {

    public static void main(String[] args) {
    /*
	    Ödev 4->
	    . . . . .
	    . . . . .
	    . . * . .
	    . . . . .
	    . . . . .
	    Yön Tuşları
		8
	    4       6
		2
	    Yıldız her tuşa basıldığında hareket edecek
	    hareket asla durmayacak, sınır sonuna geldi ise
	    başa dönecek.
    */
        Odev4 object = new Odev4();
        int x, y;
        int direction = 2;
        String exceptionMessage = "Yanlış komut verdiniz!\nTekrar deneyin: ";

        System.out.println("   8   ***Yön Tuşları***");
        System.out.println("   |      Yukarı: 8");
        System.out.println("4--o--6   Sol: 4");
        System.out.println("   |      Sağ: 6");
        System.out.println("   2      Aşağı: 2");
        System.out.println("--çıkış-- : 0   ");
        System.out.println("************************");

        do {
            do {
                x = 2; // varsayılan koordinatlar
                y = 2;
                if (!(direction == 2 || direction == 4 || direction == 6 || direction == 8 )) {
                    System.err.println(exceptionMessage);
                }
                object.toString(x, y);
                boolean error;
                do {
                    try {
                        Scanner scanner = new Scanner(System.in);
                        direction = scanner.nextInt();
                        error = false;
                        if (direction == 0) scanner.close();
                    } catch (InputMismatchException exception) {
                        System.err.println(exceptionMessage);
                        object.toString(x, y);
                        error = true;
                    }
                } while (error);

            } while (!(direction == 2 || direction == 4 || direction == 6 || direction == 8 || direction == 0));

            for (int i = 0; i < 2; i++) {
                //java14 ve üstü sürümlerde switch case arrow notasyonuyla ya da :yield anahtar kelimesiyle yazılabilir.
                //switch-case komuta göre x'in koordinatlarını belirliyor. Koordinatlar toString metoduna gönderilecek.
                switch (direction) {
                    case 2 -> x++;
                    case 4 -> y--;
                    case 6 -> y++;
                    case 8 -> x--;
                }
                if (direction == 0) continue;
                object.toString(x, y);
                System.out.println();
            }

            if (direction != 0)
                System.out.println("Başa dönüldü.");

        } while (direction != 0);
        System.out.println("***Çıkış Yapıldı***");
    }

    public void toString(int x, int y) {
        //Matrisi oluşturma
        String[][] grid = new String[5][5];
        for (String[] i : grid) //for-each
            Arrays.fill(i, ".");
        grid[x][y] = "x";
        //Ekrana yazdırma
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print((grid[i][j]) + " ");
            }
            System.out.println();
        }
    }
}