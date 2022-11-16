package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.utils.IOConsole;

import java.io.*;
import java.util.*;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager extends IOConsole {
    HashMap<String, CasinoAccount> accounts = new HashMap<>();
    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount getAccount(String accountName, String accountPassword) {
        readFromFile();
        for (Map.Entry<String, CasinoAccount> stringCasinoAccountEntry : accounts.entrySet()) {
            CasinoAccount acc = stringCasinoAccountEntry.getValue();
            if (accounts.containsKey(accountName) && accountPassword.equals(acc.getAccountPassword())) {
                return acc;
            }
        }
        return null;
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount createAccount(String accountName, String accountPassword) {
        return new CasinoAccount(accountName, accountPassword);
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(CasinoAccount casinoAccount) {
        readFromFile();
        accounts.put(casinoAccount.getAccountName(), casinoAccount);
        writeToFile();
    }

    public void writeToFile() {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter("/Users/zachary/Projects/GroupProjects/GroupCasino/players.txt"))) {

            for (Map.Entry<String, CasinoAccount> entry : accounts.entrySet()) {
                String name = entry.getKey();
                String pass = accounts.get(entry.getKey()).getAccountPassword();
                double balance = accounts.get(entry.getKey()).getAccountBalance();
                bf.write(name + ":" + pass + ":" + balance);
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/zachary/Projects/GroupProjects/GroupCasino/players.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                String name = parts[0];
                String pass = parts[1];
                double balance = Double.parseDouble(parts[2]);
                accounts.put(name, new CasinoAccount(name, pass, balance));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
