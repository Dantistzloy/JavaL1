package com.example.Band;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Singer {
    String name;
    float rating;
    int AlbCount;
}

public class BandC {
    public static void main(String[] args) {
        int MaxID = 0;
        float Ser;
        float Sum = 0;
        int kol = 0;
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.println("Введіть кількість виконавців: ");
        int count = sc.nextInt();
        sc.nextLine();
        Singer[] sing = new Singer[count];
        for (int i = 0; i < sing.length; i++) {
            sing[i] = new Singer();
            System.out.print("Введіть псевдонім " + (i + 1) + " виконавця - ");
            sing[i].name = sc.nextLine();
            System.out.print("Введіть його рейтинг - ");
            sing[i].rating = sc.nextFloat();
            System.out.print("Введіть кількість випущених альбомів - ");
            sing[i].AlbCount = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("Найпопулярніший виконавець:");
        for (int i = 0; i < sing.length; i++) {
            if (sing[i].rating > sing[MaxID].rating) {
                MaxID = i;
            }
        }
        System.out.println(sing[MaxID].name);

        System.out.println("Середня кількість випущених альбомів:");
        for (int i = 0; i < sing.length; i++) {
            Sum = Sum + sing[i].AlbCount;
        }
        Ser = Sum / count;
        System.out.println(Ser);
        System.out.println("Кількість виконавців з кількістю альбомів більшою за сердню:");
        for (int i = 0; i < sing.length; i++) {
            if (sing[i].AlbCount > Ser) {
                kol++;
            }
        }
        System.out.println(kol);
        String[] Asort = new String[count];
        for (int i = 0; i < sing.length; i++) {
            Asort[i] = sing[i].name;
        }
        Arrays.sort(Asort, Collections.reverseOrder());
        System.out.println("Псевдоніми виконавців, упорядковані у порядку, зворотньому алфавітному:");
        for (int i = 0; i < Asort.length; i++) {
            System.out.println(Asort[i]);
        }
        System.out.println("Введіть псевдонім виконавця, якого потрібно знайти:");
        String psev = sc.nextLine();
        System.out.println("\nВведіть номер поля, яке потрібно змінити:\n \n 1 - псевдонім \n\n 2- рейтинг \n\n 3 - кількість випущених альбомів \n\n інше число якщо нічого не потрібно змінювати \n");
        int change = sc.nextInt();
        int C = 0;
        for (int i = 0; i < sing.length; i++) {
            if (psev.equals(sing[i].name)) {
                switch (change) {
                    case 1:
                        System.out.println("Введіть новий псевдонім:");
                        sing[i].name = sc.nextLine();
                        break;
                    case 2:
                        System.out.println("Введіть новий рейтинг:");
                        sing[i].rating = sc.nextFloat();
                        break;
                    case 3:
                        System.out.println("Введіть нову кількість альбомів:");
                        sing[i].AlbCount = sc.nextInt();
                    default:
                        break;
                }
                System.out.println("Інформація про цього виконавця:");
                System.out.println("Псевдонім:");
                System.out.println(sing[i].name);
                System.out.println("Рейтинг:");
                System.out.println(sing[i].rating);
                System.out.println("Кількість випущених альбомів:");
                System.out.println(sing[i].AlbCount);
                C++;
            }
        }
        if (C == 0) {
            System.out.println("Виконавця не знайдено!");
        }
    }
}
