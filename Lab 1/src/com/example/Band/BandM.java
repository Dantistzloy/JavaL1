package com.example.Band;


import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Singers {
    String name;
    float rating;
    int AlbCount;
}

class Metods {
    static String MostPopular(Singers[] sing) {
        int MaxID = 0;
        for (int i = 0; i < sing.length; i++) {
            if (sing[i].rating > sing[MaxID].rating) {
                MaxID = i;
            }
        }
        return (sing[MaxID].name);
    }

    static float Ser(Singers[] sing) {
        float sum = 0;
        float ser;
        for (int i = 0; i < sing.length; i++) {
            sum = sum + sing[i].AlbCount;
        }
        ser = sum / sing.length;
        return ser;
    }

    static int MoreSer(Singers[] sing) {
        float Ser = Metods.Ser(sing);
        int kol = 0;
        for (int i = 0; i < sing.length; i++) {
            if (sing[i].AlbCount > Ser) {
                kol++;
            }
        }
        return kol;
    }

    static void Sortirovka(Singers[] sing) {
        String[] Asort = new String[sing.length];
        for (int i = 0; i < sing.length; i++) {
            Asort[i] = sing[i].name;
        }
        Arrays.sort(Asort, Collections.reverseOrder());
        for (int i = 0; i < sing.length; i++) {
            System.out.println(Asort[i]);
        }
    }

    static void Poisk(Singers[] sing) {
        int C = 0;
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.println("Введіть псевдонім виконавця, якого потрібно знайти:");
        String psev = sc.nextLine();
        System.out.println("\nВведіть номер поля, яке потрібно змінити:\n \n 1 - псевдонім \n\n 2- рейтинг \n\n 3 - кількість випущених альбомів \n\n інше число якщо нічого не потрібно змінювати \n");
        int change = sc.nextInt();
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

public class BandM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.println("Введіть кількість виконавців: ");
        int count = sc.nextInt();
        sc.nextLine();
        Singers[] sing = new Singers[count];
        for (int i = 0; i < sing.length; i++) {
            sing[i] = new Singers();
            System.out.print("Введіть псевдонім " + (i + 1) + " виконавця - ");
            sing[i].name = sc.nextLine();
            System.out.print("Введіть його рейтинг - ");
            sing[i].rating = sc.nextFloat();
            System.out.print("Введіть кількість випущених альбомів - ");
            sing[i].AlbCount = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("Найпопулярніший виконавець:");
        System.out.println(Metods.MostPopular(sing));
        System.out.println("Середня кількість випущених альбомів:");
        System.out.println(Metods.Ser(sing));
        System.out.println("Кількість виконавців з кількістю альбомів більшою за сердню:");
        System.out.println(Metods.MoreSer(sing));
        System.out.println("Псевдоніми виконавців, упорядковані у порядку, зворотньому алфавітному:");
        Metods.Sortirovka(sing);
        Metods.Poisk(sing);
    }
}

