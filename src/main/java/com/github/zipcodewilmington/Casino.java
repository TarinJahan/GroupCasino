package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.horseracing.HorseBetter;
import com.github.zipcodewilmington.casino.games.horseracing.HorseRaces;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Objects;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    @Override
    public void run() {
        String CasinoInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        do {
            CasinoInput = getCasinoInput();
            if ("1".equals(CasinoInput)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {
                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    while (!gameSelectionInput.equals("0")) {
                        if (gameSelectionInput.equals("1")) {
                            play(new SlotsGame(), new SlotsPlayer());
                            gameSelectionInput = getGameSelectionInput();
                        }
                        else if (gameSelectionInput.equals("2")) {
                            play(new NumberGuessGame(), new NumberGuessPlayer());
                            gameSelectionInput = getGameSelectionInput();
                        }
                        else if (gameSelectionInput.equals("3")) {
                            play(new HorseRaces(), new HorseBetter());
                            gameSelectionInput = getGameSelectionInput();
                        }
                        else if (gameSelectionInput.equals("7")) {
                            casinoAccount.printAccountBalance();
                            gameSelectionInput = getGameSelectionInput();
                        }
                        else if (gameSelectionInput.equals("8")) {
                            double money = console.getDoubleInput("How much would you like to add?");
                            casinoAccount.addMoneys(money);
                            gameSelectionInput = getGameSelectionInput();
                        }
                        else if (gameSelectionInput.equals("9")) {
                            System.out.println("You're walking away with ");
                            casinoAccount.printAccountBalance();
                            casinoAccount.cashOut();
                            gameSelectionInput = getGameSelectionInput();
                        }
                        else {
                            // TODO - implement better exception handling
                            String errorMessage = "[ %s ] is an invalid game selection";
                            throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
                        }
                    }
                } else {
                    // TODO - implement better exception handling
                    String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
                    throw new RuntimeException(String.format(errorMessage, accountName, accountPassword));
                }
            } else if ("2".equals(CasinoInput)) {
                console.println("Welcome to the account-creation screen.");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
                casinoAccountManager.registerAccount(newAccount);
            }
        } while (!"0".equals(CasinoInput));
    }

    private String getCasinoInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to Casino ZETA!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ 1. Login ] [ 2. Create Account ] [ 0. Exit ]")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ 1. Slots ] [ 2. Number Guess ] [ 3. Horse Racing ] [ 7. See Balance ] [ 8. Add Funds ] [ 9. Cash Out ] [ 0. Logout ]")
                .toString());
    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        game.add(player);
        game.run();
    }
}
