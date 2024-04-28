package com.example;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The main class for the IntLinkedList application.
 */
public class Main {

    /**
     * The main method for the IntLinkedList application.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntLinkedList list = new IntLinkedList();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Append node");
            System.out.println("2. Prepend node");
            System.out.println("3. Get node value by index");
            System.out.println("4. Print all elements");
            System.out.println("5. Clear list");
            System.out.println("6. Remove node from end");
            System.out.println("7. Remove node with value");
            System.out.println("8. Remove node from start");
            System.out.println("9. Exit");

            int choice = getUserInput(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Enter value to append: ");
                    int valueToAppend = getUserInput(scanner);
                    list.appendNode(valueToAppend);
                    break;
                case 2:
                    System.out.print("Enter value to prepend: ");
                    int valueToPrepend = getUserInput(scanner);
                    list.prependNode(valueToPrepend);
                    break;
                case 3:
                    System.out.print("Enter index of node to get value: ");
                    int index = getUserInput(scanner);
                    try {
                        int value = list.getNodeValue(index);
                        System.out.println("Value at index " + index + ": " + value);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    list.printAllElements();
                    break;
                case 5:
                    list.clearList();
                    System.out.println("List cleared.");
                    break;
                case 6:
                    try {
                        list.removeNodeFromEnd();
                        System.out.println("Node removed from end.");
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.print("Enter value to remove: ");
                    int valueToRemove = getUserInput(scanner);
                    try {
                        list.removeNodeWithValue(valueToRemove);
                        System.out.println("Node with value " + valueToRemove + " removed.");
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        list.removeNodeFromStart();
                        System.out.println("Node removed from start.");
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Gets an integer value from the user input.
     *
     * @param scanner the Scanner object to read user input
     * @return the integer value entered by the user
     */
    public static int getUserInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer value.");
            scanner.nextLine(); // clear buffer
        }
        return scanner.nextInt();
    }
}
