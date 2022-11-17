package com.github.zipcodewilmington.casino.games.cardgames;

public enum SUITS {
    SPADES("\u2664"),
    HEARTS("\u2661"),
    DIAMONDS("\u2662"),
    CLUBS("\u2667");

    final String symbol;

    private SUITS(String symbol) { this.symbol = symbol; }
}
