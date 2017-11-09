package com.tactfactory.pub;

public class Drink extends Product {
    public Drink() {
    }

    public Drink(String name, float price) {
        super(name, price);
    }

    public Drink(String name, float price, boolean alcohol) {
        super(name, price, alcohol);
    }

    public Drink(String name, float price, String description, float vat,
            boolean alcohol) {
        super(name, price, description, vat, alcohol);
    }

    @Override
    public String toString() {
        String alcohol = (this.isAlcohol() ? "" : " Pas") + " alcolisée";
        return this.message("Drink", alcohol);
    }
}
