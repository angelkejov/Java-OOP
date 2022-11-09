package com.Exersices.CardSuit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        System.out.println("Card Suits: ");
//        for (CardSuit s : CardSuit.values()) {
//            System.out.printf("Ordinal value: %d; Name value: %s%n", s.ordinal(), s.name());
//        }

//        System.out.println("Card Ranks: ");
//        for (CardRanks cardRanks : CardRanks.values()) {
//            System.out.printf("Ordinal value: %d; Name value: %s%n",
//                    cardRanks.ordinal(), cardRanks.name());

        Scanner sc = new Scanner(System.in);
        CardRanks cardRank = CardRanks.valueOf(sc.nextLine());
        CardSuit cardSuit = CardSuit.valueOf(sc.nextLine());

        Card card = new Card(cardSuit, cardRank);
        System.out.printf("Card name: %s of %s; Card power: %d", cardRank, cardSuit,
                card.getPower());
    }
}
