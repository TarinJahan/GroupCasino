package com.github.zipcodewilmington.casino.games.cardgames.blackjack;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.Card;
import com.github.zipcodewilmington.casino.games.cardgames.Deck;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.HashMap;

public class BlackJackSingle implements GameInterface {
    IOConsole console = new IOConsole();
    HashMap<Integer, BlackJackPlayer> players = new HashMap<>();
    BlackJackPlayer bjp;
    BlackJackPlayer dealer = new BlackJackPlayer();

    public void runBJ() {
        Deck deck = new Deck();
        deck.addDeck();
        deck.shuffleDeck(3);
        printRules();
        dealCards(deck);
        printStatus();

    }

    private void printStatus() {
        System.out.println("Dealer: [   ] [" + dealer.bjh.showCard1().toString() + "]");
        System.out.println("Player: " + bjp.bjh.getHand());
    }

    private Deck dealCards(Deck deck) {
        bjp.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        bjp.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        return deck;
    }

    @Override
    public void add(PlayerInterface player) {
        bjp = (BlackJackPlayer) player;
        players.put(players.size()+1, bjp);
    }

    @Override
    public void remove(PlayerInterface player) {}

    @Override
    public void run() {
        runBJ();
        bjp.discardHand();
        playAgain();
        players.clear();
    }

    @Override
    public void printRules() {
        System.out.println("***\nWelcome to BlackJack! Get to 21 without going over. Dealer hits below 17. Beat the Dealer!\n***\n");
    }

    public void playAgain() {
        int pa = console.getIntegerInput("Would you like to bet again? [ 1. Yes ], [ 2. No ]");
        if (pa==1) {
            run();
        }
    }
}
