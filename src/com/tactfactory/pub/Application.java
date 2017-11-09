package com.tactfactory.pub;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Pour chaque question, faire l'UML, puis l'implémentation en Java.
 *
 * 1) Nous allons gérer un pub. Notre pub vends des victuailles : bouffe +
 * breuvages. Chaque produit vendu a : un nom, un prix HT/TCC, une description,
 * si c'est alcolisé ou non.
 *
 * 2) Nous avons eu des soucis avec la communauté végane, ils veulent savoir si
 * les différents produit contiennent de la viande.
 *
 * 3) Nous allons faire un programme qui initialise nos données avec plusieurs
 * boissons et nourritures
 *
 * 4) Nous mettons à disposition 3 flippers, 2 billard français, 1 jeux de
 * flêchettes L'accès au flipper coûte 1 €, billard => 5 €, flêchettes =>
 * gratuit
 *
 * 5) Nous allons gérer nos stocks de produits ainsi que les factures des
 * clients
 *
 * 6) En fait, les véganes n'ont pas des soucis qu'avec la viande. Qui aurait pu
 * deviner ? Afin d'éviter d'autres soucis, et gérer en même temps les
 * allergies/régimes/... nous concerverrons la liste précise des ingrédients de
 * nos produits.
 */
public class Application {
    public static void main(String[] args) {
        List<Product> products = createProducts();
        List<Game> games = createGames();

        printAll(products);
        printAll(games);
    }

    private static List<Game> createGames() {
        List<Game> games = new ArrayList<>();

        games.add(new Game("Flipper", 1, 3));
        games.add(new Game("Billard français", 5, 2));
        games.add(new Game("Jeux de flêchettes"));

        return games;
    }

    private static void printAll(List<?> collection) {
        for (Object instance : collection) {
            // if (product.getClass().getName().equals(Drink.class.getName()))

            // if (product instanceof Drink) {
            // System.out.println("drink drink");
            // } else {
            // System.out.println("bouffie");
            // }
            System.out.println(instance);
            System.out.println();
        }
    }

    private static List<Product> createProducts() {
        List<Product> products = new LinkedList<>();

        products.add(new Food("Saucisson", 6f));
        products.add(new Food("Chips nature", 3f));
        products.add(new Food("Chips BBQ", 3.5f));

        products.add(new Drink("Cidre", 4f, true));
        products.add(new Drink("Cidre breton -- prix touriste", 42f));
        products.add(new Drink("Cidre breton -- prix breton", 2f, true));
        products.add(new Drink("Breizh Cola", 3.2f));
        products.add(new Drink("Coca cola", 25f));
        products.add(new Drink("Vodka", 8f, true));
        products.add(new Drink("Monaco", 5f, true));
        products.add(new Drink("Passoa", 4f, true));
        products.add(new Drink("Kirch", 4f, true));
        products.add(new Drink("Sake", 6f, true));
        products.add(new Drink("Soho", 5.2f, true));
        products.add(new Drink("Eau", 0f));

        return products;
    }
}
