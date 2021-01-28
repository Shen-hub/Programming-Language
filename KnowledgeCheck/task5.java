package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("lorem.txt"));
        HashMap<Character, Integer> symbols = new HashMap<>();
        while(sc.hasNextLine())
        {
            String s = sc.next();
            for (int i = 0; i < s.length(); i++) {
                if(symbols.containsKey(s.charAt(i)))
                    symbols.put(s.charAt(i),symbols.get(s.charAt(i))+1);
                else
                    symbols.put(s.charAt(i), 1);
            }
        }
        System.out.println(symbols);
    }
}
