package com.Lab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        printRhombus(n);
    }

    public static void printRhombus(int n) {
        firstPart(n);
        System.out.println(secondPart(n));
    }

    public static void firstPart(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 1; j < i; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    public static String secondPart(int n) {
        StringBuilder out = new StringBuilder();
        for (int r = 1; r < n; r++) {
            out.append(repeatString(r, " "))
                    .append(repeatString(n - r, "* "))
                    .append(System.lineSeparator());
        }
        return out.toString();
    }

    public static String repeatString(int count, String str) {
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < count; i++) {
            out.append(str);
        }
        return out.toString();
    }
}
