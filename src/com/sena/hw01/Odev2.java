package com.sena.hw01;

import java.util.Scanner;

public class Odev2 {
    public static void main(String[] args) {
    /*
	Ödev 2-> Aşağıdaki gibi bir metni analiz ederek işlem yapan
	program kodunu yazınız.
	6 ile 9 sayısının toplamı nedir?
	2 den 5 i çıkartırsak kaç kalır?
	işlemler -> 0...9 ve arasında toplama, çıkartma, bölme, carpma
    */
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("***Şeçenekler***");
        System.out.println("1 -> Nasıl kullanılır?");
        System.out.println("2 -> İşlem yap.");
        System.out.println("0 -> Çıkış yap.");
        System.out.println();
        System.out.println("----------------");

        do {
            //Input missmatch exceptionını try catch yerine taşı taşa vurarak kontrol ettiğim blok!
            do {
                System.out.print("Seçiminiz : ");
                String temp = scanner.nextLine();
                if (temp.matches("[0-9]"))
                    option = Integer.parseInt(temp);
                else
                    option = -1;

            } while (!(option == 1 || option == 2 || option == 0));

            switch (option) {
                case 1:
                    System.out.println("İki sayı arasında dört işlem ve kalan hesabı yapabilirsiniz.");
                    System.out.println("Aşağıdaki formatta tanımlama yaparak kullanınız.");
                    System.out.println("	***Örnekler***");
                    System.out.println("63 ile 92 sayısının toplamı nedir?");
                    System.out.println("92nin 4e bölümünden kalan kaçtır?");
                    System.out.println("\n----------------");
                    break;

                case 2:
                    System.out.println("Yapmak istediğiniz işlemi tanımlayınız : ");
                    scanner = new Scanner(System.in);
                    String description = scanner.nextLine();
                    description = description.toLowerCase();
                    String numberOnly = description.replaceAll("[^\\d]", " "); // sadece rakam olması için -> "[^0-9]"
                    String[] numbers = numberOnly.split(" +");

                    try {
                        if (numbers.length == 2) {
                            if (description.contains("topla"))
                                add(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
                            else if (description.contains("çıkar") || description.contains("fark"))
                                subtract(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
                            else if (description.contains("çarp"))
                                multiply(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
                            else if ((description.contains("böl") && description.contains("kal"))
                                    || description.contains("mod"))
                                mod(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
                            else if (description.contains("böl"))
                                divide(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
                            else
                                System.err.println("İşlem algılanamadı.");

                        } else {
                            System.err.println("2 sayı belirtilmedi.");
                        }
                    } catch (ArithmeticException e) {
                        System.err.println("Bölen 0 olamaz.");
                    }
                    System.out.println("\n----------------");
                    System.out.println("Devam etmek için 2'yi seçin.");
                    break;
            }
        } while (option != 0);
        scanner.close();
        System.out.println("***Çıkış Yapıldı***");
    }// Main Sonu

    public static void add(int num1, int num2) {
        System.out.println("Sonuç : " + (num1 + num2));
    }

    public static void subtract(int num1, int num2) {
        System.out.println("Sonuç : " + (num1 - num2));
    }

    public static void multiply(int num1, int num2) {
        System.out.println("Sonuç : " + (num1 * num2));
    }

    //Hem bölme hem mod işlemleri için bölenin 0 olma ihtimali arithmetic exceptiona neden olacak.
    //İki ayrı metoda try catch bloğu açmak yerine bu metodlardan exception fırlatmak ve
    //maindeki try catch bloğuyla exceptionı kontrol etmek daha mantıklı.
    public static void divide(int num1, int num2) throws ArithmeticException {
        System.out.println("Sonuç : " + (num1 / num2));
    }

    public static void mod(int num1, int num2) throws ArithmeticException {
        System.out.println("Sonuç : " + (num1 % num2));
    }
}