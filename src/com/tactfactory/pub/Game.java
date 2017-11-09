package com.tactfactory.pub;

public class Game {
    private String name;
    private float price = 0f;
    private int number = 1;

    public Game(String name) {
        this.setName(name);
    }
    public Game(String name, float price) {
        this(name);
        this.setPrice(price);
    }
    public Game(String name, float price, int number) {
        this(name, price);
        this.setNumber(number);
    }

    @Override
    public String toString() {
        String price = (this.price == 0f
                ? " avec partie gratuite"
                : " a " + this.getPrice() + " €/partie");

        return "On a " + this.getNumber() + " " + this.getName() + price;
    }

    private String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }
    private float getPrice() {
        return price;
    }
    private void setPrice(float price) {
        this.price = price;
    }
    private int getNumber() {
        return number;
    }
    private void setNumber(int number) {
        this.number = number;
    }
}
