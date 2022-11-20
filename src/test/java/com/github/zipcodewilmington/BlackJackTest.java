package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.cardgames.Deck;
import com.github.zipcodewilmington.casino.games.cardgames.blackjack.BlackJackPlayer;
import com.github.zipcodewilmington.casino.games.cardgames.blackjack.BlackJackSingle;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BlackJackTest {

    @Test
    public void testBlackJack() {
        BlackJackPlayer bjp = new BlackJackPlayer();
        BlackJackSingle bjs = new BlackJackSingle();
        BlackJackPlayer dealer = new BlackJackPlayer();
        Deck deck = new Deck();
        deck.addDeck();

        bjs.add(bjp);
        bjs.add(dealer);
        bjs.dealCards(deck);

        Assertions.assertTrue(bjs.blackJack());

        bjp.discardHand();
        bjs.remove(bjp);
    }

    @Test
    public void testBust() {
        BlackJackPlayer bjp = new BlackJackPlayer();
        BlackJackSingle bjs = new BlackJackSingle();
        BlackJackPlayer dealer = new BlackJackPlayer();
        Deck deck = new Deck();
        deck.addDeck();

        bjs.add(dealer);
        bjs.add(bjp);
        bjs.dealCards(deck);

        Assertions.assertFalse(bjs.bust());

        bjs.dealCardPlayer(bjp, deck);
        bjs.dealCardPlayer(bjp, deck);
        Assertions.assertTrue(bjs.bust());
    }

    @Test
    public void testPrintStatus() {
        BlackJackPlayer bjp = new BlackJackPlayer();
        BlackJackSingle bjs = new BlackJackSingle();
        BlackJackPlayer dealer = new BlackJackPlayer();
        Deck deck = new Deck();
        deck.addDeck();

        bjs.add(bjp);
        bjs.add(dealer);
        bjs.dealCards(deck);

        String expected = "Dealer: [   ] [J \u2667]\nPlayer: [A \u2667] [Q \u2667] ";
        String actual = bjs.printStatus();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrintResults() {
        BlackJackPlayer bjp = new BlackJackPlayer();
        BlackJackSingle bjs = new BlackJackSingle();
        BlackJackPlayer dealer = new BlackJackPlayer();
        Deck deck = new Deck();
        deck.addDeck();

        bjs.add(bjp);
        bjs.add(dealer);
        bjs.dealCards(deck);

        String expected = "Dealer: [K \u2667] [J \u2667] \nPlayer: [A \u2667] [Q \u2667] ";
        String actual = bjs.printResults();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetWinnerBlackJack() {
        BlackJackPlayer bjp = new BlackJackPlayer();
        BlackJackSingle bjs = new BlackJackSingle();
        BlackJackPlayer dealer = new BlackJackPlayer();
        Deck deck = new Deck();
        deck.addDeck();

        bjs.add(bjp);
        bjs.add(dealer);
        bjs.dealCards(deck);

        String expected = "BlackJack!! Player wins 25.0";
        String actual = bjs.getWinner();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetWinnerBust() {
        BlackJackPlayer bjp = new BlackJackPlayer();
        BlackJackSingle bjs = new BlackJackSingle();
        BlackJackPlayer dealer = new BlackJackPlayer();
        Deck deck = new Deck();
        deck.addDeck();

        bjs.add(bjp);
        bjs.add(dealer);
        deck = bjs.dealCards(deck);
        deck = bjs.dealCardPlayer(bjp, deck);
        deck = bjs.dealCardPlayer(bjp, deck);

        deck = bjs.dealCardPlayer(dealer, deck);
        deck = bjs.dealCardPlayer(dealer, deck);

        String expected = "BUST! Player loses 10.0";
        String actual = bjs.getWinner();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetWinnerWin() {
        BlackJackPlayer bjp = new BlackJackPlayer();
        BlackJackSingle bjs = new BlackJackSingle();
        BlackJackPlayer dealer = new BlackJackPlayer();
        Deck deck = new Deck();
        deck.addDeck();

        bjs.add(bjp);
        bjs.add(dealer);
        bjs.dealCards(deck);
        bjs.dealCardPlayer(dealer, deck);

        String expected = "Player wins 10.0";
        String actual = bjs.getWinner();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetWinnerLose() {
        BlackJackPlayer bjp = new BlackJackPlayer();
        BlackJackSingle bjs = new BlackJackSingle();
        BlackJackPlayer dealer = new BlackJackPlayer();
        Deck deck = new Deck();
        Deck d1 = new Deck();
        deck.addDeck();

        bjs.add(bjp);
        bjs.add(dealer);
        bjs.dealCards(deck);
        deck = bjs.dealCardPlayer(bjp, deck);
        deck = bjs.dealCardPlayer(bjp, deck);

        deck = bjs.dealCardPlayer(dealer, deck);

        String expected = "Player loses 10.0";
        String actual = bjs.getWinner();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetWinnerTie() {
        BlackJackPlayer bjp = new BlackJackPlayer();
        BlackJackSingle bjs = new BlackJackSingle();
        BlackJackPlayer dealer = new BlackJackPlayer();
        Deck deck = new Deck();
        deck.addDeck();

        bjs.add(bjp);
        bjs.add(dealer);

        String expected = "Tie, wager returned.";
        String actual = bjs.getWinner();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNextAction() {
        BlackJackSingle bjs = new BlackJackSingle();

        String exp1 = "[HIT] [STAY]";
        String exp2 = "[HIT] [STAY] [SPLIT] ";

        String act1 = bjs.nextAction(false);
        String act2 = bjs.nextAction(true);

        Assertions.assertEquals(exp1, act1);
        Assertions.assertEquals(exp2, act2);
    }
}