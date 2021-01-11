package com.fpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HandleInputs {

    private Scanner scanner;

    public HandleInputs(Scanner scanner) {
        this.scanner = scanner;
    }

    protected int handlePositionInput() {
        int position;
        do {
            try {
                System.out.print("What position would you like to look at?" +
                        "\n 1 = GK, 2 = DEF, 3 = MID, 4 = FWD, 5 = ALL \n");
                position = scanner.nextInt();
            } catch (InputMismatchException e) {
                position = 1;
                System.out.println("Incorrect input given. Please try again");
            }
        } while (position < 1 || position > 5);

        return position;
    }

    public int handleMinPrice() {
        int price;
        do {
            try {
                System.out.print("What is the minimum price of the player?" +
                        "\n Enter number between 30 and 130 \n");
                price = scanner.nextInt();
            } catch (InputMismatchException e) {
                price = 1;
                System.out.println("Incorrect input given. Please try again");
            }
        } while (price > 130 || price < 30);

        return price;
    }

    protected int handleMaxPriceInput() {
        int price;
        do {
            try {
                System.out.print("What is the maximum price of the player?" +
                        "\n Enter number between 30 and 130 \n");
                price = scanner.nextInt();
            } catch (InputMismatchException e) {
                price = 1;
                System.out.println("Incorrect input given. Please try again");
            }
        } while (price > 130 || price < 30);

        return price;
    }

    protected int handleSearchInput() {
        int search;
        do {
            try {
                System.out.print("What characteristics are you looking for?" +
                        "\n 1 = Value, 2 = Influence, 3 = Creative, 4 = Threat, 5 = Form  \n");
                search = scanner.nextInt();
            } catch (InputMismatchException e) {
                search = 1;
                System.out.println("Incorrect input given. Please try again");
            }
        } while (search < 1 || search > 5);

        return search;
    }

    public String handleFixturesInput() {
        System.out.println("");
        System.out.println("Would you like to see chosen players' fixtures?\n y=yes n=no");
        String in = scanner.nextLine();
        return in;
    }
}
