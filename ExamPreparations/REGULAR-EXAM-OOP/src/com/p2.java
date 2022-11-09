package com;

import java.util.Scanner;

public class p2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double teglotoNaPratkataVKg = Double.parseDouble(sc.nextLine());
        String tipUsluga = sc.nextLine();
        int razstoqnieVKilometri = Integer.parseInt(sc.nextLine());

        double stotinkiNaKilometur = 0;
        double procentNaKilogram = 0;
        if (tipUsluga.equals("standard")) {
            if (teglotoNaPratkataVKg < 1) {
                stotinkiNaKilometur += 0.03;
            } else if (teglotoNaPratkataVKg >= 1 && teglotoNaPratkataVKg < 10) {
                stotinkiNaKilometur += 0.05;
            } else if (teglotoNaPratkataVKg >= 10 && teglotoNaPratkataVKg < 40) {
                stotinkiNaKilometur += 0.10;
            } else if (teglotoNaPratkataVKg >= 40 && teglotoNaPratkataVKg < 90) {
                stotinkiNaKilometur += 0.15;
            } else if (teglotoNaPratkataVKg >= 90 && teglotoNaPratkataVKg < 150) {
                stotinkiNaKilometur += 0.20;
            }
        }

        if (tipUsluga.equals("express")) {
            if (teglotoNaPratkataVKg < 1) {
                procentNaKilogram = 0.80;
            } else if (teglotoNaPratkataVKg >= 1 && teglotoNaPratkataVKg < 10) {
                procentNaKilogram = 0.40;
            } else if (teglotoNaPratkataVKg >= 10 && teglotoNaPratkataVKg < 40) {
                procentNaKilogram = 0.05;
            } else if (teglotoNaPratkataVKg >= 40 && teglotoNaPratkataVKg < 90) {
                procentNaKilogram = 0.02;
            } else if (teglotoNaPratkataVKg >= 90 && teglotoNaPratkataVKg < 150) {
                procentNaKilogram = 0.01;
            }
        }

        double krainaCena = stotinkiNaKilometur;
        System.out.println(krainaCena);
    }
}
