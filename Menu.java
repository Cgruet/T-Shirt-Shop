package com.ata.code;

import java.util.Scanner;

/**
 * Menu class is responsible for greeting the user, showing a menu
 * to the user for interaction with the application.
 * The class maintains a String[] array of menu options, which it
 * uses for printing the menu to standard out.
 * The class is also responsible for responding to user interaction
 * with respect to its menu.
 */
public class Menu {
    final private Cart cart;
    final private Shop shop;
    final private Scanner scanner;

    /**
     * Class constructor, which expects a Scanner object
     * It allows for the user to specify how a Scanner is to
     * be configured outside this class and for basic inversion of control.
     * @param scanner takes in a Scanner object to initialize
     * @param shop takes in a Shop object to initialize
     */
    public Menu(Scanner scanner, Shop shop, Cart cart) {
        this.scanner = scanner;
        this.shop = shop;
        this.cart = cart;
    }


    /**
     * Prints the menu to standard output, using the class's menuOptions array.
     * It accepts user input using the encapsulated Scanner instance.
     * All output is printed to standard out.
     * All input is collected from standard in.
     */
    public void executeMenu() {
        MenuOption menuOption;
        do {
            printMenu();
            menuOption = getNextOptionFromUser();
            handleShopperSelection(menuOption);
        } while (menuOption != MenuOption.EXIT);
        exit();
    }

    /**
     * Asks the user to enter their name.
     * After the user provides their name, it outputs a greeting to the user to standard out.
     */
    public void greet() {
        System.out.println("Hello. Please enter your name:");
        String name = scanner.nextLine();
        System.out.println(String.format("Welcome %s to %s", name, shop.getName()));
    }

    /**
     * Prints the menu header and menu options.
     */
    private void printMenu() {
        System.out.println();
        System.out.println("--Main Menu--");
        System.out.println("Select an option using one of the numbers shown");
        System.out.println();

        for (MenuOption menuOption : MenuOption.values()) {
            System.out.println(String.format("%d: %s", menuOption.getId(), menuOption.getDisplayValue()));
        }
    }

    /**
     * Prints an exit statement and closes the scanner object.
     */
    private void exit() {
        System.out.println("Exiting now. Goodbye.");
        scanner.close();
    }

    /**
     * Collects next user-entered int.
     * @return integer value denoting the user selection
     */
    private int getNextIntFromUser() {
        return scanner.nextInt();
    }

    /**
     * Skips a line of empty input from the scanner's input stream
     * and then returns the next available line.
     * @return string representing the line of input typed by the user
     */
    private String getNextStringLineFromUser() {
        scanner.nextLine();
        return scanner.nextLine();
    }


    private MenuOption getNextOptionFromUser() {
        int optionId = getNextIntFromUser();
        return MenuOption.fromOptionId(optionId);
    }


    private void handleShopperSelection(MenuOption menuOption) {
        if (menuOption == MenuOption.LIST_PRODUCTS) {
            shop.printProducts();
        }
        if (menuOption == MenuOption.BUY_PRODUCT) {
            listProducts();
        }
        if (menuOption == MenuOption.FIND_PRODUCT) {
            buyProduct();
        }
        if (menuOption == MenuOption.SHOW_CART) {
            cart.showDetails();
        }
        if (menuOption == MenuOption.CHECKOUT) {
            cart.checkout(shop.getName());
        }

    }


    private void listProducts() {
        System.out.println("Please enter the ID of the product you would like to purchase:");
        int addItemId = getNextIntFromUser();
        Product product = shop.matchId(addItemId);
        if (product == null) {
            System.out.println("That item ID is invalid and could not be added to the cart.");
        } else {
            cart.addItem(product);
        }
    }


    private void buyProduct() {
        System.out.println("Enter the item to search for:");
        String itemToFind = getNextStringLineFromUser();
        int id = shop.findProduct(itemToFind);
        if (id == -1) {
            System.out.println("That product was not found.");
        } else {
            System.out.println(String.format("%s was found and its product id is %d", itemToFind, id));
        }
    }

}
