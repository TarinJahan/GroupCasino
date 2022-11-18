package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.blackjack.BlackJackPlayer;
import com.github.zipcodewilmington.casino.games.cardgames.blackjack.BlackJackSingle;
import com.github.zipcodewilmington.casino.games.horseracing.HorseBetter;
import com.github.zipcodewilmington.casino.games.horseracing.HorseRaces;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.casino.games.wordguess.WordGuessGame;
import com.github.zipcodewilmington.casino.games.wordguess.WordGuessPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    public static CasinoAccount casinoAccount;
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
                casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {
                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    while (!gameSelectionInput.equals("0")) {
                        if (gameSelectionInput.equals("1")) {
                            play(new NumberGuessGame(), new NumberGuessPlayer());
                            gameSelectionInput = getGameSelectionInput();
                        }
                        else if (gameSelectionInput.equals("2")) {
                            play(new WordGuessGame(), new WordGuessPlayer());
                            gameSelectionInput = getGameSelectionInput();
                        }
                        else if (gameSelectionInput.equals("3")) {
                            play(new SlotsGame(), new SlotsPlayer());
                            gameSelectionInput = getGameSelectionInput();
                        }
                        else if (gameSelectionInput.equals("4")) {
                            play(new HorseRaces(), new HorseBetter());
                            gameSelectionInput = getGameSelectionInput();
                        }
                        else if (gameSelectionInput.equals("5")) {
                            play(new BlackJackSingle(), new BlackJackPlayer());
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
        return console.getStringInput("Welcome to Casino ZETA!" +
                "\nFrom here, you can select any of the following options:" +
                "\n\t[ 1. Login ] [ 2. Create Account ] [ 0. Exit ]");
    }

    private String getGameSelectionInput() {
        return console.getStringInput("Welcome to the Game Selection Dashboard!" +
                "\nFrom here, you can select any of the following options:" +
                "\n\t[ 1. Number Guess ] [ 2. Word Guess ] [ 3. Slots ][ 4. Horse Racing ] [ 5. BlackJack ] [ 7. See Balance ] [ 8. Add Funds ] [ 9. Cash Out ] [ 0. Logout ]");
    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        game.add(player);
        game.run();
    }
}
