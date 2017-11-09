package com.tactfactory.pub;

public abstract class Product {
    private String name;
    private float price;
    private String description;
    private float vat;
    private boolean alcohol;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public float getVat() {
        return vat;
    }
    public void setVat(float vat) {
        this.vat = vat;
    }
    public boolean isAlcohol() {
        return alcohol;
    }
    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }

    public float getFinalPrice() {
        return this.getVat() * this.price;
    }
}
