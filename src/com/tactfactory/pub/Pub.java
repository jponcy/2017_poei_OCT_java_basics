package com.tactfactory.pub;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pub {
    private List<Product> products = createProducts();
    private List<Game> games = createGames();
    private List<Bill> bills = new ArrayList<>();

    public Product getProduct(String name) {
        Product result = null;

        for (Product p : this.products) {
            if (p.getName().toLowerCase().equals(name.toLowerCase())) {
                result = p;
                break;
            }
        }

        return result;
    }

    public void addBill(Bill newBill) {
        this.bills.add(newBill);
    }

    public static List<Game> createGames() {
        List<Game> games = new ArrayList<>();

        games.add(new Game("Flipper", 1, 3));
        games.add(new Game("Billard français", 5, 2));
        games.add(new Game("Jeux de flêchettes"));

        return games;
    }

    public static List<Product> createProducts() {
        List<Product> products = new LinkedList<>();

        products.add(new Food("Saucisson", 6f, 1000));
        products.add(new Food("Chips nature", 3f, 123));
        products.add(new Food("Chips BBQ", 3.5f, 2));

        products.add(new Drink("Cidre", 4f, 32153431, true));
        products.add(new Drink("Cidre breton -- prix touriste", 42f, 42));
        products.add(new Drink("Cidre breton -- prix breton", 2f, 1, true));
        products.add(new Drink("Breizh Cola", 3.2f, 412));
        products.add(new Drink("Coca cola", 25f, 5));
        products.add(new Drink("Vodka", 8f, 32, true));
        products.add(new Drink("Monaco", 5f, 52, true));
        products.add(new Drink("Passoa", 4f, 92, true));
        products.add(new Drink("Kirch", 4f, 2, true));
        products.add(new Drink("Sake", 6f, 5, true));
        products.add(new Drink("Soho", 5.2f, 10, true));
        products.add(new Drink("Eau", 0f, 100000)); // FIXME : Bizarre ce stock.

        return products;
    }
}
