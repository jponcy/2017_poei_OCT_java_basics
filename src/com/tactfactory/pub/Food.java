package com.tactfactory.pub;

public class Food extends Product {
    private boolean meat;

    public Food()
    {}

    public Food(String name, float price) {
        super(name, price);
    }

    public Food(String name, float price, boolean meat) {
        this(name, price);

        this.meat = meat;
    }

    @Override
    public String toString() {
        return this.message("Food", "");
    }

    public boolean isMeat() {
        return this.meat;
    }

    public void setMeat(boolean meat) {
        this.meat = meat;
    }
}
