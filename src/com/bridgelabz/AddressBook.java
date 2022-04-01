package com.bridgelabz;

import java.util.*;

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
         * Adding the person details to address book
         */
        addressBook.add(person);
    }

    /**
     * This method is used to give the user edit option based on the first name
     */
    private static void editContact() {
        System.out.println("Enter the person name you want to edit: ");
        String personName = scanner.next();

        Optional<Person> optionalContact = addressBook.stream().filter(person -> person.getFirstName().equals(personName)).findFirst();
        if (!optionalContact.isPresent()) {
            System.out.println("Sorry could not find the contact with the given name");
            return;
        }
        Person person = optionalContact.get();
        System.out.println("Please select the field you want to edit ");
        System.out.println("1.Lastname  2.Address  3.City  4.State  5.Zip  6.Phone number  7.email ");
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                System.out.println("Please enter new last name :");
                String lastName = scanner.next();
                person.setLastName(lastName);
                break;
            case 2:
                System.out.println("Please enter new address :");
                String address = scanner.next();
                person.setAddress(address);
                break;
            case 3:
                System.out.println("Please enter new city :");
                String city = scanner.next();
                person.setCity(city);
                break;
            case 4:
                System.out.println("Please enter new state :");
                String state = scanner.next();
                person.setState(state);
                break;
            case 5:
                System.out.println("Please enter new zip :");
                long zip = scanner.nextLong();
                person.setZip(zip);
                break;
            case 6:
                System.out.println("Please enter new phone number :");
                long phoneNumber = scanner.nextLong();
                person.setPhoneNumber(phoneNumber);
                break;
            case 7:
                System.out.println("Please enter new email :");
                String email = scanner.next();
                person.setEmail(email);
                break;
            default:
                System.out.println("Invalid option. Please enter valid !");
                scanner.close();
        }
        listContacts();
    }

    /**
     * @param scanner - taking scanner object
     *                Method for giving the user to select he option and perform acc to it
     */
    private static void readUserInput(Scanner scanner) {
        System.out.println("Please select one option");
        System.out.println("1. Add new contact \n2. Edit contact \n3. List contacts ");
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                addNewContact(scanner);
                System.out.println("Contact added successfully!");
                break;
            case 2:
                editContact();
                break;
            case 3:
                listContacts();
                break;
            default:
                System.out.println("Invalid option. Please select valid");
        }
    }

    /**
     * Displaying the Person's Contact list
     */
    private static void listContacts() {
        for (Person person : addressBook) {
            System.out.println(person);
        }
    }

    /**
     * Main method for manipulating person class
     *
     * @param args - default java param
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System...!");
        String userChoice;
        do {
            readUserInput(scanner);
            System.out.println("Do you want to continue(Y/N) ?");
            userChoice = scanner.next();
        } while (userChoice.equalsIgnoreCase("Y"));
        System.out.println("Thank you!");
    }
}





