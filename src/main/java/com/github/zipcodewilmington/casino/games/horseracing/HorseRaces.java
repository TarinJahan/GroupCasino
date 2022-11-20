package com.github.zipcodewilmington.casino.games.horseracing;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.HashMap;
import java.util.Map;

public class HorseRaces implements GameInterface<HorseBetter> {
    IOConsole console = new IOConsole();
    HorseBetter hb;
    Map<Integer, Horse> stable = new HashMap<>();
    int[] winner = {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 5, 6, 7, 8, 2, 3, 4, 5, 6, 7, 8, 3, 5, 6, 7, 8, 3, 7, 8, 3, 7, 8, 3, 7, 8, 7, 8, 7};
    int playerPick=1;
    public int winningHorse=1;
    double payout=0;
    double bet=10;

    public HorseRaces() {}

    public void buildStable() {
        stable.put(1, new Horse("Dr. Evil", 1, 8));
        stable.put(2, new Horse("Number 2", 2, 7));
        stable.put(3, new Horse("Three Strikes", 3, 3));
        stable.put(4, new Horse("Fear", 4, 9));
        stable.put(5, new Horse("Golden Ring", 5, 6));
        stable.put(6, new Horse("El Diablo", 6, 6));
        stable.put(7, new Horse("Lucky Number Sleven", 7, 1));
        stable.put(8, new Horse("Kobe", 8, 2));
    }

    public void pickHorse() {
        playerPick = console.getIntegerInput("Pick a Horse: ");
    }

    public int pickWinner() {
        return winner[(int) (Math.random() * (winner.length-1))];
    }

    public double whoWon() {
        if (playerPick == winningHorse) {
            int odds = stable.get(playerPick).getOdds();
            System.out.println("You won " + odds*bet);
            return odds*bet;
        }
        else {
            System.out.printf("You lose. You picked %s, horse %s won.%n", playerPick, winningHorse);
            return -bet;
        }
    }

    @Override
    public void add(PlayerInterface player) {
        hb = (HorseBetter) player;
    }

    @Override
    public void remove(PlayerInterface player) {
        hb = null;
    }

    @Override
    public void printRules() {
        StringBuilder sb = new StringBuilder();
        sb.append("Welcome to the RaceTrack! You will be able to pick one of the following horses.\n\n");
        String horses = "";
        for (int i=1; i<=stable.size(); i++) {
            Horse h1 = stable.get(i);
            sb.append(String.format("Horse %s, %s. Odds of winning: %s:1\n", h1.number, h1.name, h1.odds));
        }
        System.out.println(sb);
    }

    @Override
    public void playAgain() {
        int pa = console.getIntegerInput("Would you like to bet again? [ 1. Yes ], [ 2. No ]");
        if (pa==1) {
            run();
        }
    }

    @Override
    public void run() {
        horseRace();
        playAgain();
        remove(hb);
    }

    public int getStableSize() {
        return stable.size();
    }

    public void horseRace() {
        buildStable();
        printRules();
        pickHorse();
        placeBet();
        winningHorse = pickWinner();
        payout = pickWinner();
        whoWon();
        hb.transferMoney(payout);
    }

    public void placeBet() {
        bet = console.getDoubleInput("How much are you putting on "+playerPick+"?");
    }
}
