package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CasinoAccountTest {
    CasinoAccount ca = new CasinoAccount("star", "man", 50.0);
    CasinoAccount ca1 = new CasinoAccount("mister", "rogers");

    @Test
    void getAccountName() {
        String expected = "star";
        String actual = ca.getAccountName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAccountPassword() {
        String expected = "man";
        String actual = ca.getAccountPassword();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAccountBalance() {
        ca.addMoneys(50);
        double expected = 100.0;
        double actual = ca.getAccount().getAccountBalance();

        Assertions.assertEquals(expected, actual);

        ca.cashOut();
        double act1 = ca.getAccountBalance();

        Assertions.assertEquals(0.0, act1);
    }

    @Test
    void printAccountBalance() {
        String expected = "$50.00";
        String actual = ca.printAccountBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCasinoAccountManager() {
        CasinoAccountManager cam = new CasinoAccountManager();
        CasinoAccount casAcc = cam.createAccount("star", "man");
        String expected = casAcc.getAccountName();
        cam.registerAccount(casAcc);

        CasinoAccount actAcc = cam.getAccount("star", "man");
        String actual = actAcc.getAccountName();

        Assertions.assertEquals(expected, actual);
    }
}