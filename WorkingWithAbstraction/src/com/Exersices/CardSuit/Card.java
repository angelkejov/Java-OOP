package com.Exersices.CardSuit;

public class Card {

    private CardSuit cardSuit;
    private CardRanks cardRanks;

    public Card(CardSuit cardSuit, CardRanks cardRanks) {
        this.cardRanks = cardRanks;
        this.cardSuit = cardSuit;
    }

    public int getPower() {
        return cardRanks.getRankPower() + cardSuit.getSuitPower();
    }
}
