package com.ata.code;

import java.util.ArrayList;

/**
 * Cart class is responsible for holding the products that the user has added to their cart.
 * The class maintains an ArrayList of products, the total, and the tax rate.
 * The functionality of this class includes adding items to the cart,
 * printing the items that are currently in the cart, and checking out the user.
 * Checking out will print the items in the cart, print the cart total, and will empty the cart.
 */
public class Cart {

    private ArrayList<Product> items;
    private double total;
    private double taxRate;

    /**
     * Class constructor, which expects a double.
     * @param taxRate takes in an int id to initialize
     */
    public Cart(double taxRate) {
        this.total = 0;
        this.taxRate = taxRate;
        this.items = new ArrayList<Product>();
    }

    /**
     * @param product takes in a product and adds it to the items ArrayList
     */
    public void addItem(Product product) {
        items.add(product);
        System.out.println(String.format("%s has been added to your cart.", product.getName()));
        total += product.getPrice();
    }

    /**
     * showDetails print the current items in the Cart along with the total with and without tax.
     */
    public void showDetails() {
        if (items.size() == 0) {
            System.out.println("The cart is empty. Please add at least one product to see it in the cart.");
        } else {
            StringBuilder sb = new StringBuilder();
            System.out.println(String.format("--Cart--%nItem Count: %d%nItems:", items.size()));
            for (Product item : items) {
                sb.append(String.format("%s: $%.2f%n", item.getName(), item.getPrice()));

            }
            System.out.println(String.format("%s%n%nPre-Tax Total: $%.2f%nPost-Tax Total (10.00%% Tax): $%.2f",
                                             sb, total, total * (1 + taxRate / 100)));
        }
    }

    /**
     * Prints the total of the cart, thanks the shopper, and clears the cart.
     */
    public void checkout(String shopName) {
        if (items.size() == 0) {
            System.out.println("Your cart is currently empty. Please add at least one product to check out.");
        } else {
            System.out.println(String.format("Your total is $%.2f", total * (1 + taxRate / 100)));
            System.out.println(String.format("Thank you for shopping at %s.", shopName));
            items.clear();
            this.total = 0;
        }
    }
}
