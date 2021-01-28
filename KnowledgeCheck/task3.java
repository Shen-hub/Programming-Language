package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("words.txt"));
        String long_word = "";
        int max_size = 0;
        while (sc.hasNextLine()){
            String word = sc.nextLine();
            if (word.length() > max_size)
            {
                max_size = word.length();
                long_word = word;
            }
        }
        System.out.println("Самое длинное слово: " + long_word + ", количество символов в слове: " + max_size);
    }
}
