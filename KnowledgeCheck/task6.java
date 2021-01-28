package com.company;

import java.util.Scanner;

public class Main {

    static double coefSimilarity(String w1, String w2)
    {
        double result;
        int nc = 0;
        for (int i = 0; i < w1.length(); i++) {
            for (int j = 0; j < w2.length(); j++) {
               if (w1.charAt(i)==w2.charAt(j))
               {
                   nc++;
                   break;
               }
            }
        }
        result = Double.valueOf(nc)/(w1.length() + w2.length() - nc);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Введите первое слово: ");
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        sc.reset();
        System.out.println("Введите второе слово: ");
        String word2 = sc.next();
        System.out.println(coefSimilarity(word1,word2));
    }
}
