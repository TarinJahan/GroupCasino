package com.github.zipcodewilmington.casino.games.cardgames;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    public Stack<Card> deck = new Stack<>();

    public Deck() {

    }

    public void shuffleDeck(int times) {
        for (int i=0; i<times; i++) {
            Collections.shuffle(deck);
        }
    }

    public void addDeck() {
        for (SUITS suit : SUITS.values()) {
            for (RANKS rank : RANKS.values()) {
                deck.push(new Card(rank.value, suit, rank));
            }
        }
    }

    public void createShoe(int decks) {
        for (int i=0; i<decks; i++) addDeck();
    }

    public Card dealCard() {
        return deck.pop();
    }
}
