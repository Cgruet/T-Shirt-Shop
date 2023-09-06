package com.ata.code;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The ShopRunner class is the main entry point for the application.
 * It encapsulates a Menu, providing it with a Scanner configured
 * with System.in to allow the menu to read from standard in.
 * When the application starts, the menu's greet and show methods are called.
 */
public class ShopRunner {
    /**
     * Main entry point to the application.
     * Asks the menu's greeting to be printed to standard out by calling its greet method.
     * Asks the menu to be shown by calling its show method.
     * @param args Command line arguments to the application
     */
    public static void main(String[] args) {
        double taxRate = 10.00;
        String shopName = "T-Shirt Mart";
        String[] productNames = {"Crew Neck", "V-Neck", "Polo", "Boat Neck", "Tank Top"};
        double[] productPrices = {20.00, 20.00, 25.50, 30.25, 15.75};
        ArrayList<Product> products = new ArrayList<Product>();
        for (int i = 0; i < productNames.length; i++) {
            products.add(new Product(i, productNames[i], productPrices[i]));
        }

        Shop shop = new Shop(shopName, products);

        Cart cart = new Cart(taxRate);

        Menu menu = new Menu(new Scanner(new InputStreamReader(System.in, Charset.forName("UTF-8"))),
                             shop, cart);

        menu.greet();
        menu.executeMenu();
    }
}
