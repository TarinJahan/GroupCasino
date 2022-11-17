package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */

public class SlotsGame extends IOConsole implements GameInterface {
    Random generator = new Random();
    String[] slots = new String[3];
    String[] column1 = {"!", "@", "#", "$", "%", "&", "*", "?"};
    String[] column2 = {"!", "@", "#", "$", "%", "&", "*", "?"};
    String[] column3 = {"!", "@", "#", "$", "%", "&", "*", "?"};

    @Override
    public Integer getIntegerInput(String prompt, Object... args) {
        return super.getIntegerInput(prompt, args);
    }

    private void pullLever() {
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
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {
    }

    @Override
    public void run() {
        playAgain();
    }

    @Override
    public void printRules() {
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
}
