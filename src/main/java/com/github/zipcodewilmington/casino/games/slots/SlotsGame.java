package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */

public class SlotsGame extends IOConsole implements GameInterface {
    Random generator = new Random();
    int[] slots = new int[3];
    int[] column1 = new int[Integer.parseInt("!\", \"@\", \"#\", \"$\", \"%\", \"&\", \"*\", \"?\"")];
    int[] column2 = new int[Integer.parseInt("!\", \"@\", \"#\", \"$\", \"%\", \"&\", \"*\", \"?\"")];
    int[] column3 = new int[Integer.parseInt("!\", \"@\", \"#\", \"$\", \"%\", \"&\", \"*\", \"?\"")];

    @Override
    public Integer getIntegerInput(String prompt, Object... args) {
        return super.getIntegerInput(prompt, args);
    }

    private boolean pullLever() {
        slots[0] = column1[generator.nextInt(8)];
        slots[1] = column2[generator.nextInt(8)];
        slots[2] = column3[generator.nextInt(8)];

        if (slots[0] == slots[1] || slots[1] == slots[2] || slots[0] == slots[2]) {
            System.out.println("2 WINS!");
        } else if (slots[0] == slots[1] && slots[0] == slots[2]) {
            System.out.println("$$$ JACKPOT $$$");
        } else {
            System.out.println("NO MATCHES: GAME OVER");
        }
        return true;
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        Integer lever = getIntegerInput("Would you like to pull the lever? Type 1 for \"YES\" or 2 for \"NO\"");
        if(lever.equals(1)){
            pullLever();
        } else if (lever.equals(2)) {
            System.out.println("Would you like to exit the game?");
        }

    }
}
