package com.github.zipcodewilmington.casino.games.cardgames;

public enum SUITS {
    SPADES("\u2660"),
    HEARTS("\u2665"),
    DIAMONDS("\u2666"),
    CLUBS("\u2663");

    final String symbol;

    private SUITS(String symbol) { this.symbol = symbol; }
}
