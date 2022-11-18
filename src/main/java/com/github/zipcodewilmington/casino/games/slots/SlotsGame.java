package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */

public class SlotsGame extends IOConsole implements GameInterface {
    SlotsPlayer sp;
    double bet = 5;
    double payout = 0;
    Random generator = new Random();
    String[] slots = new String[3];
    String[] column1 = {"!", "@", "#", "$", "%", "&", "*", "?"};
    String[] column2 = {"!", "@", "#", "$", "%", "&", "*", "?"};
    String[] column3 = {"!", "@", "#", "$", "%", "&", "*", "?"};

    @Override
    public Integer getIntegerInput(String prompt, Object... args) {
        return super.getIntegerInput(prompt, args);
    }

    public void pullLever() {
        slots[0] = column1[generator.nextInt(8)];
        slots[1] = column2[generator.nextInt(8)];
        slots[2] = column3[generator.nextInt(8)];
        System.out.println("[" + slots[0] + "][" + slots[1] + "][" + slots[2] + "]");

        if (slots[0] == slots[1] && slots[1] != slots[2]) {
            System.out.println("2 MATCHES");
        } else if (slots[0] == slots[2] && slots[1] != slots[2]) {
            System.out.println("2 MATCHES");
        } else if (slots[2] == slots[1] && slots[0] != slots[2]) {
            System.out.println("2 MATCHES");
        } else if (slots[0] == slots[1] && slots[0] == slots[2]) {
            System.out.println("$$$ JACKPOT $$$");
            payout += (bet * 5);
        } else {
            System.out.println("NO MATCHES");
            payout -= bet;
        }
    }

    @Override
    public void add(PlayerInterface player) {
        sp = (SlotsPlayer) player;
    }

    @Override
    public void remove(PlayerInterface player) {
        sp = null;
    }

    @Override
    public void run() {
        printRules();
        playAgain();
    }

    @Override
    public void printRules() {
       System.out.println("Welcome to slots! It will cost 5 dollars per play."
                +"\nPull the lever and try to get 2 or 3 matches!"
                +"\nIf you get 2 matches, you get"
                +"\nIf you get 3 matches it's a JACKPOT!"
                +"\nIf there's no matches, you lose your bet and the game.");
    }

    @Override
    public void playAgain() {
        Integer lever = getIntegerInput("Would you like to pull the lever? Type 1 for \"YES\" or 2 for \"NO\"");
        if(lever.equals(1)){
            pullLever();
        } else if (lever.equals(2)) {
            System.exit(0);
        }
    }

    public String[] slotsArray() {
        return slots;
    }
}
