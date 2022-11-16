package com.github.zipcodewilmington.casino.games.cardgames;

public class Card {
    int value;
    enum Suit {HEARTS, DIAMONDS, CLUBS, SPADES}

    public Card(int value, String suit) {
        this.value = value;
//        this.Suit = suit;
    }
}
