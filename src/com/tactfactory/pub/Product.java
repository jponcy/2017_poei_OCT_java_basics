package com.tactfactory.pub;

public abstract class Product {
    private String name;
    private float price;
    private String description;
    private float vat = 1.2f;
    private boolean alcohol;

    public Product()
    {}

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, float price, boolean alcohol) {
        this(name, price);

        this.setAlcohol(alcohol);
    }

    public Product(String name, float price, String description, float vat,
            boolean alcohol) {
        this(name, price);

        this.description = description;
        this.vat = vat;
        this.alcohol = alcohol;
    }

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

    protected String message(String prefix, String middle) {
        return prefix + " | " + this.getName() + " -> " +
                this.getFinalPrice() + " (" + this.getPrice() + ") €" +
                middle +
                (this.getDescription() == null ? "" : "\n" + this.getDescription());
    }

    public float getFinalPrice() {
        float result = this.getVat() * this.price;

        result = (int)(result * 100f) / 100f;

        return result;
    }
}
