package com.github.zipcodewilmington.casino.games.cardgames;

import java.util.Stack;

import static com.github.zipcodewilmington.casino.games.cardgames.RANKS.ACE;

public class Hand {
    Stack<Card> cards = new Stack<>();

    public Hand(Card c1, Card c2) {
        cards.push(c1);
        cards.push(c2);
    }

    public Hand() {

    }

    public String getHand() {
        StringBuilder hand = new StringBuilder();
        for (Card c : cards) {
            hand.append("[").append(c.toString()).append("] ");
        }
        return hand.toString();
    }

    public void addCard(Card c) {
        cards.push(c);
    }

    public Card showCard1() {
        return cards.peek();
    }

    public int getValueOfHand() {
        int sum = 0;
        int aces = 0;
        for (Card c : cards) {
            if (c.getRank().equals(ACE)) {
                aces++;
            }
            sum += c.getValue();
        }
        int total = aceValue(sum, aces);
        return Math.max(total, sum);
    }

    public int aceValue(int sum, int aces) {
        int newTotal = sum;
        for (int i = aces; i>0; i--) {
            if ((sum + 10) <= 21) {
                newTotal = (sum + 10);
            }
        }
        return newTotal;
    }

    public void discard() {
        cards.empty();
    }
}
