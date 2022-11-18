package com.github.zipcodewilmington.casino.games.cardgames.blackjack;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.Deck;
import com.github.zipcodewilmington.utils.IOConsole;
import java.util.HashMap;
//need to add splittable and doubleDown
public class BlackJackSingle implements GameInterface {
    IOConsole console = new IOConsole();
    HashMap<Integer, BlackJackPlayer> players = new HashMap<>();
    BlackJackPlayer bjp;
    BlackJackPlayer dealer = new BlackJackPlayer();
    double payout = 0;
    double bet = 10;
    String na;

    public void runBJ() {
        Deck deck = new Deck();
        deck.addDeck();
        deck.shuffleDeck(3);
        printRules();
        placeBet();
        deck = dealCards(deck);
        printStatus();
        if (bjp.bjh.splittable()) {
            na = nextAction(true);
        }
        else { na = nextAction(false); }
        while (!na.equals("STAY")) {
            if (na.equals("HIT")) {
                deck = dealCardPlayer(bjp, deck);
                System.out.println(bjp.bjh.getHand());
            }
            if (bust()) {
                break;
            }
            na = nextAction(false);
        }
        while(dealer.bjh.getValueOfHand()<17) {
            deck = dealCardPlayer(dealer, deck);
        }
        printResults();
        System.out.println(getWinner());
        bjp.transferMoney(payout);

        bjp.discardHand();
        dealer.discardHand();
    }

    private String getWinner() {
        if (bjp.bjh.getValueOfHand()>dealer.bjh.getValueOfHand() || dealer.bjh.getValueOfHand()>21 && bjp.bjh.getValueOfHand()<=21) {
            payout = bet;
            return "Player wins " + payout;
        }
        else if (bjp.bjh.getValueOfHand()<dealer.bjh.getValueOfHand()) {
            payout = -bet;
            return "Player loses " + bet;
        }
        else if (bjp.bjh.getValueOfHand()==dealer.bjh.getValueOfHand()) {
            payout = 0;
            return "Tie, wager returned.";
        }
        else if (bjp.bjh.getValueOfHand()>dealer.bjh.getValueOfHand()) {
            payout = -bet;
            return "BUST! Player loses " + bet;
        }
        else if (blackJack()) {
            payout = (bet + bet*1.5);
            return "BlackJack!! Player wins " + payout;
        }
        else { return "Something bad happened"; }
    }

    private void printStatus() {
        System.out.println("Dealer: [   ] [" + dealer.bjh.showCard1().toString() + "]");
        System.out.println("Player: " + bjp.bjh.getHand());
    }

    private void printResults() {
        System.out.println("Dealer: " + dealer.bjh.getHand());
        System.out.println("Player: " + bjp.bjh.getHand());
    }

    private Deck dealCards(Deck deck) {
        bjp.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        bjp.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        return deck;
    }

    private Deck dealCardPlayer(BlackJackPlayer player, Deck deck) {
        player.addCard(deck.dealCard());
        return deck;
    }

    @Override
    public void add(PlayerInterface player) {
        bjp = (BlackJackPlayer) player;
        players.put(players.size()+1, bjp);
    }

    @Override
    public void remove(PlayerInterface player) {
        players.clear();
    }

    @Override
    public void run() {
        runBJ();
        playAgain();
        players.remove(bjp);
    }

    @Override
    public void printRules() {
        System.out.println("***\nWelcome to BlackJack! Get to 21 without going over. Dealer hits below 17. Beat the Dealer!\n***\n");
    }

    public void playAgain() {
        int pa = console.getIntegerInput("Would you like to play again? [ 1. Yes ], [ 2. No ]");
        if (pa==1) {
            run();
        }
    }

    public String nextAction(boolean split) {
        if (split) {
            for (Actions a : Actions.values()) {
                System.out.printf("[%s] ", a);
            }
        }
        else {
            System.out.println("[HIT] [STAY]");
        }
        return console.getStringInput("").toUpperCase();
    }

    public boolean bust() {
        return (bjp.bjh.getValueOfHand()>21);
    }

    public boolean blackJack() {
        return (bjp.bjh.getValueOfHand()==21 && bjp.bjh.getSize()==2);
    }

    public void placeBet() {
        bet = console.getDoubleInput("Place your bets!");
    }
}
