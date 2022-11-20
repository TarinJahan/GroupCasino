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
        System.out.println(printStatus());
        if (bjp.bjh.splittable()) {
            na = nextAction(true);
        }
        else { na = nextAction(false); }
        na = console.getStringInput("").toUpperCase();
        while (!na.equals("STAY")) {
            if (na.equals("HIT")) {
                deck = dealCardPlayer(bjp, deck);
            }
            if (bust()) {
                break;
            }
            na = nextAction(false);
        }
        while(dealer.bjh.getValueOfHand()<17) {
            deck = dealCardPlayer(dealer, deck);
        }
        System.out.println(printResults());
        System.out.println(getWinner());
        bjp.transferMoney(payout);

        bjp.discardHand();
        dealer.discardHand();
    }

    public String getWinner() {
        if (blackJack()) {
            payout = (bet + bet*1.5);
            return "BlackJack!! Player wins " + payout;
        }
        else if (bjp.bjh.getValueOfHand()>21) {
            payout = -bet;
            return "BUST! Player loses " + bet;
        }
        else if (bjp.bjh.getValueOfHand()>dealer.bjh.getValueOfHand() || dealer.bjh.getValueOfHand()>21) {
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
        else { return "Something bad happened"; }
    }

    public String printStatus() {
        return "Dealer: [   ] [" + dealer.bjh.showCard1().toString() + "]\nPlayer: " + bjp.bjh.getHand();
    }

    public String printResults() {
        return "Dealer: " + dealer.bjh.getHand() + "\nPlayer: " + bjp.bjh.getHand();
    }

    public Deck dealCards(Deck deck) {
        bjp.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        bjp.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        return deck;
    }

    public Deck dealCardPlayer(BlackJackPlayer player, Deck deck) {
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
        bjp = null;
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
        int pa = console.getIntegerInput("Would you like to play again? [ 1. Yes ] [ 2. No ]");
        if (pa==1) {
            run();
        }
    }

    public String nextAction(boolean split) {
        if (split) {
            StringBuilder sb = new StringBuilder();
            for (Actions a : Actions.values()) {
                sb.append("[").append(a).append("] ");
            }
            return sb.toString();
        }
        else return ("[HIT] [STAY]");
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
