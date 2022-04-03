package com.bridgelabz;

/**
 * Creating AddressBookValidationUtil to validate the person's details using regex
 */
public class AddressBookValidationUtil {

    /**
     * Creating isValidFirstName to validate the first name using regex
     * @param firstName - first name of person
     * @return true or false
     */
    public static boolean isValidFirstName(String firstName) throws AddressBookException {
        /**
         * Regular expression for First name validation
         */
        String firstNameRegex = "^[A-Z]{1}[a-z]{2,}$";
        if (firstName.matches(firstNameRegex)) {
            return true;
        } else {
            throw new AddressBookException("Invalid FirstName", AddressBookException.ExceptionType.INVALID_FIRST_NAME);
        }
    }

    /**
     * Creating isValidLastName to validate the last name using regex
     * @param lastName - last name of person
     * @return true or false
     */
    public static boolean isValidLastName(String lastName) throws AddressBookException {
        /**
         * Regular expression for last name validation
         */
        String lastNameRegex = "^[A-Z]{1}[a-z]{2,}$";
        if (lastName.matches(lastNameRegex)) {
            return true;
        } else {
            throw new AddressBookException("Invalid Lastname", AddressBookException.ExceptionType.INVALID_LAST_NAME);
        }
    }

    /**
     * Creating isValidAddress to validate the address using regex
     * @param address - address of person
     * @return true or false
     */
    public static boolean isValidAddress(String address) throws AddressBookException {
        /**
         * Regular expression for address validation
         */
        String addressRegex = "^(.){0,30}$";
        if (address.matches(addressRegex)) {
            return true;
        } else {
            throw new AddressBookException("Invalid Address", AddressBookException.ExceptionType.INVALID_ADDRESS);
        }
    }

    /**
     * Creating isValidCity to validate the city using regex
     * @param city - City of person
     * @return true or false
     */
    public static boolean isValidCity(String city) throws AddressBookException {
        /**
         * Regular expression for city validation
         */
        String cityRegex = "^[\\w]{2,}$";
        if (city.matches(cityRegex)) {
            return true;
        } else {
            throw new AddressBookException("Invalid City", AddressBookException.ExceptionType.INVALID_CITY);
        }
    }

    /**
     * Creating isValidState to validate the state using regex
     * @param state - state of person
     * @return true or false
     */
    public static boolean isValidState(String state) throws AddressBookException {
        /**
         * Regular expression for state validation
         */
        String stateRegex = "^[\\w]{2,}$";
        if (state.matches(stateRegex)) {
            return true;
        } else {
            throw new AddressBookException("Invalid State", AddressBookException.ExceptionType.INVALID_STATE);
        }
    }

    /**
     * Creating isValidZip to validate the Zip using regex
     * @param zip -  zip code
     * @return true or false
     */
    public static boolean isValidZip(String zip) throws AddressBookException {
        /**
         * Regular expression for Zip code validation
         */
        String zipRegex = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$";
        if (zip.matches(zipRegex)) {
            return true;
        } else {
            throw new AddressBookException("Invalid Zip", AddressBookException.ExceptionType.INVALID_ZIP);
        }
    }

    /**
     * Creating isValidPhoneNumber to validate the phone number using regex
     * @param phoneNumber - phone number of person
     * @return true or false
     */
    public static boolean isValidPhoneNumber(String phoneNumber) throws AddressBookException {
        /**
         * Regular expression for phone number validation
         */
        String phoneNumberRegex = "^[0-9]{10}$";
        if (phoneNumber.matches(phoneNumberRegex)) {
            return true;
        } else {
            throw new AddressBookException("Invalid Phone Number", AddressBookException.ExceptionType.INVALID_PHONE);
        }
    }

    /**
     * Creating isValidEmail to validate the Email using regex
     * @param email - email of person
     * @return true or false
     */
    public static boolean isValidPEmail(String email) throws AddressBookException {
        /**
         * Regular expression for Email validation
         */
        String emailRegex = "^[a-zA-Z-9]+([._+-]?[0-9A-Za-z]+)*@[a-zA-Z0-9]+.[a-zA-Z]{2,4}([.][a-z]{2})?$";
        if (email.matches(emailRegex)) {
            return true;
        } else {
            throw new AddressBookException("Invalid Email", AddressBookException.ExceptionType.INVALID_EMAIL);
        }
    }
}
