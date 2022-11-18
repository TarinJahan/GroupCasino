package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.cardgames.Card;
import com.github.zipcodewilmington.casino.games.cardgames.Deck;
import com.github.zipcodewilmington.casino.games.cardgames.SUITS;
import com.github.zipcodewilmington.casino.games.cardgames.RANKS;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    @Test
    public void cardTest() {
        Card c1 = new Card(1, SUITS.SPADES, RANKS.ACE);

        SUITS suitExpected = SUITS.SPADES;
        RANKS rankExpected = RANKS.ACE;
        SUITS suitActual = c1.getSuit();
        RANKS rankActual = c1.getRank();

        Assert.assertEquals(suitExpected, suitActual);
        Assert.assertEquals(rankExpected, rankActual);
    }

    @Test
    public void DeckTest() {
        int decks = 3;
        Deck d1 = new Deck();
        d1.createShoe(decks);

        Assert.assertEquals(decks*52, d1.deck.size());

        d1.shuffleDeck(3);

        int count=0;
        for (Card cTest : d1.deck) {
            if (cTest.getSuit()==SUITS.HEARTS) count++;
        }
        Assert.assertEquals(decks*13, count);

        Card card = d1.dealCard();
        Assert.assertEquals(decks*52-1, d1.deck.size());
        System.out.println(card.toString());
    }
}
