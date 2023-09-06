package com.ata.code;

import java.util.ArrayList;

/**
 * Shop class is responsible for holding the products and any type
 * of searching or listing of products
 * The class maintains an ArrayList of products, which it
 * uses for printing all the products and searching for products.
 */
public class Shop {

    private String name;
    private ArrayList<Product> products;

    /**
     * Class constructor, which expects a Product array.
     * @param name takes in a String to initialize
     * @param products takes in a ArrayList of products to initialize
     */
    public Shop(String name, ArrayList<Product> products) {
        this.name = name;
        this.products = products;
    }

    /**
     * Prints all the different products in shop.
     */
    public void printProducts() {
        System.out.println("--Products--");
        for (Product product : products) {
            System.out.println(String.format("ID %d: %s - $%.2f",product.getId(), product.getName(), product.getPrice()));
        }


    }

    /**
     * Searches through products names to match user input passed as the variable searchText.
     * @param searchText takes in a String to compare to the other product names
     * @return integer value of the ID of the matched product
     */
    public int findProduct(String searchText) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(searchText)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return String value of the shop name
     */
    public String getName() {
        return name;
    }

    /**
     * Searches through the products ArrayList for a matching id
     * @param id takes in an int to compare to the other product ids
     * @return Product value of matching id
     */
    public Product matchId(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
