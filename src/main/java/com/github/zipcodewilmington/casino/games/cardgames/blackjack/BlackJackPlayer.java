package com.github.zipcodewilmington.casino.games.cardgames.blackjack;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.Card;
import com.github.zipcodewilmington.casino.games.cardgames.Hand;

public class BlackJackPlayer implements PlayerInterface {
    CasinoAccount bjp = getArcadeAccount();
    Hand bjh = new Hand();

    public BlackJackPlayer() {
    }


    @Override
    public CasinoAccount getArcadeAccount() {
        return Casino.casinoAccount;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }

    public void addCard(Card c1) {
        bjh.addCard(c1);
    }

    public void discardHand() {
        bjh = new Hand();
    }

    public void transferMoney(double wager) {
        bjp.addMoneys(wager);
    }
}
