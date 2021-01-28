package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	    ArrayList<Double> numbers = new ArrayList<Double>();
        double max = 1000;
        double min = 0;

        Comparator<Double> comp = new Comparator<Double>() {
            @Override
            public int compare(Double a, Double b) {
                int ia = a.intValue();
                int ib = b.intValue();
                a = a - ia;
                b = b - ib;
                if (a>b)
                    return 1;
                if (a<b)
                    return -1;
                else
                    return 0;
            }
        };

        for (int i = 0; i < 10; i++) {
            numbers.add(Math.random() * ((max - min) + 1) + min);
        }

        numbers.sort(comp);

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }
}
