package com.tactfactory.pub;

public class Drink extends Product {
    public Drink() {
    }

    public Drink(String name, float price, int stock) {
        super(name, price, stock);
    }

    public Drink(String name, float price, int stock, boolean alcohol) {
        super(name, price, stock, alcohol);
    }

    public Drink(String name, float price, int stock, String description, float vat,
            boolean alcohol) {
        super(name, price, stock, description, vat, alcohol);
    }

    @Override
    public String toString() {
        String alcohol = (this.isAlcohol() ? "" : " Pas") + " alcolisée";
        return this.message("Drink", alcohol);
    }
}
