package com.tactfactory.pub;

import java.util.HashMap;
import java.util.Map;

public class Bill {
    private static int counter = 0;

    private int id;
    private Map<Product, Integer> products = new HashMap<>();

    public Bill() {
        this.id = ++Bill.counter;
    }

    public boolean addProduct(Product p, int number) throws Exception {
        boolean result = false;

        if (p.hasEnoughStock(number)) {
            Integer origin = this.products.get(p);
            int value = (origin == null ? number : origin + number);

            this.products.put(p, value);
            result = true;
        }

        return result;
    }

    public long computeAmount() {
        long result = 0;

        for (Map.Entry<Product, Integer> entry : this.products.entrySet()) {
            Integer productNumber = entry.getValue();
            float productPrice = entry.getKey().getFinalPrice();

            result += (productPrice * productNumber);
        }

        return result;
    }
}
