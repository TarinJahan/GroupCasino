package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.cardgames.Card;
import com.github.zipcodewilmington.casino.games.cardgames.Deck;
import com.github.zipcodewilmington.casino.games.cardgames.Hand;
import org.junit.Test;

public class HandTest {

    @Test
    public void handTest() {
        Deck deck = new Deck();
        deck.addDeck();
        deck.shuffleDeck(3);
        Card c1 = deck.dealCard();
        Card c2 = deck.dealCard();
        Card c3 = deck.dealCard();
        Hand hand = new Hand(c1, c2);

        System.out.println(hand.getHand());
        System.out.println(hand.getValueOfHand());
        hand.addCard(c3);
        System.out.println(hand.getHand());
        System.out.println(hand.getValueOfHand());
    }
}
