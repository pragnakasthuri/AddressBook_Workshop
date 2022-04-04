package com.bridgelabz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private List<Person> addressBook = new ArrayList();

    /**
     * Creating addNewContact method to add contacts into list
     * @param scanner - taking scanner object
     */
    public void addNewContact(Scanner scanner) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the details :");
        String firstName = "";
        System.out.println("First Name :");
        while(true) {
            try {
                firstName = bufferedReader.readLine();
                if (AddressBookValidationUtil.isValidFirstName(firstName)) {
                    break;
                }
            } catch (AddressBookException e) {
                System.err.println(e.getMessage()+", Please enter again");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Last Name :");
        String lastName = "";
        while(true) {
            try {
                lastName = bufferedReader.readLine();
                if (AddressBookValidationUtil.isValidLastName(lastName)) {
                    break;
                }
            } catch (AddressBookException e) {
                System.err.println(e.getMessage() + ", Please enter again");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Address :");
        String address = "";
        while(true) {
            try {
                address = bufferedReader.readLine();
                if (AddressBookValidationUtil.isValidAddress(address)) {
                    break;
                }
            } catch (AddressBookException e) {
                System.err.println(e.getMessage() + ", Please enter again");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("City :");
        String city = "";
        while(true) {
            try {
                city = bufferedReader.readLine();
                if (AddressBookValidationUtil.isValidCity(city)) {
                    break;
                }
            } catch (AddressBookException e) {
                System.err.println(e.getMessage() + ", Please enter again");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("State :");
        String state = "";
        while(true) {
            try {
                state = bufferedReader.readLine();
                if (AddressBookValidationUtil.isValidState(state)) {
                    break;
                }
            } catch (AddressBookException e) {
                System.err.println(e.getMessage()+ ", Please enter again");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Zip :");
        String zip = "";
        while(true) {
            try {
                zip = bufferedReader.readLine();
                if (AddressBookValidationUtil.isValidZip(zip)) {
                    break;
                }
            } catch (AddressBookException e) {
                System.err.println(e.getMessage() + ", Please enter again");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Phone Number :");
        String phoneNumber = "";
        while(true) {
            try {
                phoneNumber = bufferedReader.readLine();
                if (AddressBookValidationUtil.isValidPhoneNumber(phoneNumber)) {
                    break;
                }
            } catch (AddressBookException e) {
                System.err.println(e.getMessage() + ", Please enter again");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Email :");
        String email = "";
        while(true) {
            try {
                email = bufferedReader.readLine();
                if (AddressBookValidationUtil.isValidEmail(email)) {
                    break;
                }
            } catch (AddressBookException e) {
                System.err.println(e.getMessage() + ", Please enter again");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        /**
         * Creating Contact object and passing all the details as params
         */
        Person person = new Person(firstName, lastName, address, city, state, zip, phoneNumber, email);
        /**
         * Adding the person details to address book
         */
        this.addNewContact(person);
    }

    /**
     * Creating addNewContact method to address book
     * @param person
     */
    public void addNewContact(Person person) {
        if (person != null) {
            this.addressBook.add(person);
        }
    }

    /**
     * Creating getContact method to get the name if the given name is present
     * @param personName - name given by user to search and edit
     * @return - optional person
     * @throws AddressBookException
     */
    public Person getContact(String personName) throws AddressBookException {
        Optional<Person> optionalPerson = this.addressBook.stream().filter(person -> person.getFirstName().equalsIgnoreCase(personName)).findFirst();
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        }
        throw new AddressBookException("No suitable contact found", AddressBookException.ExceptionType.NO_SUCH_CONTACT_FOUND);
    }

    /**
     * This method is used to give the user edit option based on the first name
     */
    public void editContact() {
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
                String zip = scanner.next();
                person.setZip(zip);
                break;
            case 6:
                System.out.println("Please enter new phone number :");
                String phoneNumber = scanner.next();
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
     * @param userChoice - taking user choice
     * Method to act according to the user choice
     * @throws AddressBookException if invalid choice passed
     */
    public void readUserInput(int userChoice)throws AddressBookException{
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
            case 4:
                deleteContact();
                break;
            default: {
                System.out.println("Invalid option. Please select valid option");
                throw new AddressBookException("Invalid option. Please select valid", AddressBookException.ExceptionType.INVALID_USER_CHOICE_EXCEPTION);
            }
        }
    }

    /**
     * Displaying the Person's Contact list
     */
    public void listContacts() {
        if (this.addressBook.isEmpty()) {
            System.out.println("No contacts found!");
        }
        for (Person person : addressBook) {
            System.out.println(person);
        }
    }

    /**
     * Method for deleting the contact for the given name as input
     */
    public void deleteContact() {
        System.out.println("Please enter the name of the person u want to delete :");
        String contactName = scanner.next();
        Iterator<Person> iterator = addressBook.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            /**
             * Checking if the gaven name is in match with the name in the list
             */
            if (contactName.equals(person.getFirstName())) {
                iterator.remove();
                System.out.println("The contact got deleted");
            } else
                System.out.println("Please enter the correct name: ");
        }
    }

    /**
     * Main method for manipulating person class
     * @param args - default java param
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System...!");
        AddressBook addressBook =  new AddressBook();
        String userChoice;
        do {
            System.out.println("Please select one option");
            System.out.println("1. Add new contact \n2. Edit contact \n3. List contacts \n4. Delete contact ");
            try {
                addressBook.readUserInput(scanner.nextInt());
            } catch (AddressBookException e) {
                e.printStackTrace();
            }
            System.out.println("Do you want to continue(Y/N) ?");
            userChoice = scanner.next();
        } while (userChoice.equalsIgnoreCase("Y"));
        System.out.println("Thank you!");
    }
}





