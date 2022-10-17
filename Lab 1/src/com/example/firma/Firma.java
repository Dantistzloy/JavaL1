package com.example.firma;

import java.util.Scanner;
class Sotrudnik
        {
         String fam,im,otch,doljnost;
         int oklad;
        }

public class Firma
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.println("Введіть кількість співробітників: ");
        int kol = sc.nextInt();
        sc.nextLine();
        Sotrudnik[]sotr = new Sotrudnik[kol];
        System.out.println("Введіть інформацію про кожного співробітника:");
        for (int i = 0; i < sotr.length; i++)
        {
            sotr[i] = new Sotrudnik();
            System.out.print("Введіть прізвище " + (i + 1) + " співробітника - ");
            sotr[i].fam = sc.nextLine();
            System.out.print("Введіть його ім'я - ");
            sotr[i].im = sc.nextLine();

            System.out.print("Введіть його по батькові - ");
            sotr[i].otch = sc.nextLine();

            System.out.print("Введіть його посаду - ");
            sotr[i].doljnost = sc.nextLine();

            System.out.print("Введіть його оклад - ");
            sotr[i].oklad = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("\nСпівробітники фірми:\n фамілія\tім'я\tпо батькові\t посада \tОклад");
        for (int i = 0; i < sotr.length; i++)
        {
            System.out.println(sotr[i].fam + "\t" + sotr[i].im + "\t" + sotr[i].otch
                    + "\t" + sotr[i].doljnost + "\t\t" + sotr[i].oklad);
        }
    }
}
