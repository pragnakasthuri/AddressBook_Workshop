package com.bridgelabz;

/**
 * Creating an exception class to hold custom exceptions
 */
public class AddressBookException extends Exception {
    enum ExceptionType {
        INVALID_USER_CHOICE_EXCEPTION, NO_SUCH_CONTACT_FOUND, INVALID_FIRST_NAME,
        INVALID_LAST_NAME, INVALID_ADDRESS, INVALID_CITY, INVALID_STATE, INVALID_ZIP, INVALID_PHONE, INVALID_EMAIL
    }

    ExceptionType type;

    public AddressBookException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}

