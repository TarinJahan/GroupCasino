package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.cardgames.Card;
import com.github.zipcodewilmington.casino.games.cardgames.Deck;
import com.github.zipcodewilmington.casino.games.cardgames.Hand;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class HandTest {

    @Test
    public void handTest() {
        Deck deck = new Deck();
        deck.addDeck();
        Card c1 = deck.dealCard();
        Card c2 = deck.dealCard();
        Hand hand = new Hand(c1, c2);

        String expected = "[A \u2667] [K \u2667] ";
        int exp = 21;

        String actual = hand.getHand();
        int act = hand.getValueOfHand();

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void testAddCard() {
        Deck deck = new Deck();
        deck.addDeck();
        Card c1 = deck.dealCard();
        Card c2 = deck.dealCard();
        Card c3 = deck.dealCard();
        Hand hand = new Hand(c1, c2);

        hand.addCard(c3);
        int expSize1 = 3;
        int actSize1 = hand.getSize();
        Assertions.assertEquals(expSize1, actSize1);
    }

    @Test
    public void testDiscard() {
        Deck deck = new Deck();
        deck.addDeck();
        Card c1 = deck.dealCard();
        Card c2 = deck.dealCard();
        Hand hand = new Hand(c1, c2);

        hand.discard();
        int expected = 0;
        int actual = hand.getSize();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPeek() {
        Deck deck = new Deck();
        deck.addDeck();
        Card c1 = deck.dealCard();
        Card c2 = deck.dealCard();
        Hand hand = new Hand(c1, c2);

        String expected = "K \u2667";
        String actual = String.valueOf(hand.showCard1());
        Assertions.assertEquals(expected, actual);
        Assertions.assertFalse(hand.splittable());
    }
}
