package com.github.zipcodewilmington.casino.games.horseracing;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.HashMap;
import java.util.Map;

public class HorseRaces extends IOConsole implements GameInterface<HorseBetter> {
    Map<Integer, Horse> stable = new HashMap<>();
    int[] winner = {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 5, 6, 7, 8, 2, 3, 4, 5, 6, 7, 8, 3, 5, 6, 7, 8, 3, 7, 8, 3, 7, 8, 3, 7, 8, 7, 8, 7};
    int playerPick;
    int winningHorse;

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

    public int pickHorse() {
        return getIntegerInput("Pick a Horse: ");
    }

    public int pickWinner() {
        return winner[(int) (Math.random() * (winner.length-1))];
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        PlayerInterface player = new HorseBetter();
        GameInterface<HorseBetter> game = new HorseRaces();
        game.add(player);
        buildStable();
        playerPick = pickHorse();
        winningHorse = pickWinner();
        if (playerPick == winningHorse) {
            int odds = stable.get(playerPick).getOdds();
        }
//        payout(wager*odds);
    }

    public int getStableSize() {
        return stable.size();
    }
}
