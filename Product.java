package com.ata.code;

/**
 * Product class is responsible for holding the products data.
 * The class maintains the product's id, name, and price.
 */
public class Product {

    private int id;
    private String name;
    private double price;

    /**
     * Class constructor, which expects a String and two int.
     * @param id takes in an int id to initialize
     * @param name takes in a String name to initialize
     * @param price takes in an int price to initialize
     */
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * @return Sting value of the Product name
     */
    public String getName() {
        return name;
    }

    /**
     * @return int value of the Product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return int value of the Product id
     */
    public int getId() {
        return id;
    }
}
