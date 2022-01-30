package com.sena.hw01;

public class Odev3 {

    public static void main(String[] args) {
    /*
	Ödev 3-> {1, 2,5,5,6,6,7, 2,1,3}
	Şeklinde bir dizi var. Bu dizi içindeki
	tekrar eden sayıları bulup listeleyin.
    */

        int[] numArray = {1, 2, 5, 5, 6, 6, 7, 2, 1, 3};
        int[] duplicates = new int[10];

        System.out.print("Sayı dizisi : ");
        for (int num : numArray)
            System.out.print(num + " ");
        System.out.println();

        for (int i = 0; i < numArray.length - 1; i++) {
            duplicates[numArray[i]]++;
        }
        for (int i = 0; i < numArray.length - 1; i++) {
            if (duplicates[i] > 1)
                System.out.println(i + " değeri " + duplicates[i] + " kez tekrar ediyor.");
        }
        System.out.println();
    }

}