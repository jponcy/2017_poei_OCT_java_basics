package com.tactfactory.pub;

public class NoEnoughStockException extends Exception {
    private static final long serialVersionUID = 1L;

    public NoEnoughStockException() {
        super("Pas suffisament de produits en stocks");
    }
}
