package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Creating AddressBook class for manipulating the person class
 */
public class AddressBook {

    /**
     * Creating a scanner object to read inputs from user
     */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Creating new array list for storing the person details
     */
    private static List<Person> addressBook = new ArrayList();


    /**
     * Creating addNewContact method to add contacts into list
     *
     * @param scanner - taking scanner object
     */
    public static void addNewContact(Scanner scanner) {
        System.out.println("Please enter the details :");
        System.out.println("First Name :");
        String firstName = scanner.next();
        System.out.println("Last Name :");
        String lastName = scanner.next();
        System.out.println("Address :");
        String address = scanner.next();
        System.out.println("City :");
        String city = scanner.next();
        System.out.println("State :");
        String state = scanner.next();
        System.out.println("Zip :");
        long zip = scanner.nextLong();
        System.out.println("Phone Number :");
        long phoneNumber = scanner.nextLong();
        System.out.println("Email :");
        String email = scanner.next();
        /**
         * Creating Contact object and passing all the details as params
         */
        Person person = new Person(firstName, lastName, address, city, state, zip, phoneNumber, email);
        /**
         * If there is no existing entry for given contact type then create new array list
         */
        addressBook.add(person);
    }

    /**
     * Main method for manipulating person class
     * @param args - default java param
     */
    public static void main(String[] args) {
        /**
         * Calling addNewContact method
         */
        addNewContact(scanner);

    }
}





