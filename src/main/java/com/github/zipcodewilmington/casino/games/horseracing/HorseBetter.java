package com.github.zipcodewilmington.casino.games.horseracing;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class HorseBetter implements PlayerInterface {
    CasinoAccount hb = getArcadeAccount();
    @Override
    public CasinoAccount getArcadeAccount() {
        return Casino.casinoAccount;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }

    public void transferMoney(double wager) {
        hb.addMoneys(wager);
    }
}
