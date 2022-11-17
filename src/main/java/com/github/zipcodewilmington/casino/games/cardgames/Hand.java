package com.github.zipcodewilmington.casino.games.cardgames;

import java.util.Stack;

public class Hand {
    Stack<Card> cards;

    public void Hand(Card c1, Card c2) {
        cards.push(c1);
        cards.push(c2);
    }

    public String getHand() {
        String cards = "";

        return cards;
    }
}
