package com.github.zipcodewilmington.casino.games.cardgames;

public class Card {
    int value;
    RANKS rank;
    SUITS suit;

    public Card(int value, SUITS suit, RANKS rank) {
        this.value = value;
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public RANKS getRank() {
        return rank;
    }

    public SUITS getSuit() { return suit; }

    public String getSymbol() {
        return suit.symbol;
    }
}
