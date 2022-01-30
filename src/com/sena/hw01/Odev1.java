package com.sena.hw01;

import java.util.Scanner;

public class Odev1 {

    public static void main(String[] args) {
    /*
	Ödev 1-> Kullanıcıdan alınan değerle aşağıdaki gibi eş kenar üçgen yazdırma
	         1
	        2 2
	       3 3 3
	      4 4 4 4
	     5 5 5 5 5
    */
        int height;
        System.out.print("Yükseklik giriniz: ");
        try {
            Scanner scanner = new Scanner(System.in);
            height = scanner.nextInt();
            scanner.close();
        } catch (Exception exception) {
            System.err.println("  Tam sayı girilmedi.\n***uygulama sonlandı***");
            return;
        }
        System.out.println("Eş kenar üçgen: ");
        for (int i = 0; i < height; i++) {
            System.out.printf("%" + (height - i) * 2 + "s", " ");
            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d", i + 1);
            }
            System.out.println();
        }
        if (height == 0) System.out.println("Yükseklik 0 işlem yapılamadı.");

    }
}