package com.tactfactory.pub;

public class Food extends Product {
    private boolean meat;

    public boolean isMeat() {
        return this.meat;
    }

    public void setMeat(boolean meat) {
        this.meat = meat;
    }
}
