package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressBookTest {

    @Test
    public void givenUserChoice_whenInvalid_ShouldThrowException() {
        AddressBook addressBook = new AddressBook();
        try {
            addressBook.readUserInput(10);
        } catch (AddressBookException e) {
            Assertions.assertEquals(AddressBookException.ExceptionType.INVALID_USER_CHOICE_EXCEPTION, e.type);
        }
    }

    @Test
    public void givenNewContact_ShouldAddSuccessfully() {
        AddressBook addressBook = new AddressBook();
        Person person = new Person("Pragna", "Kasthuri", "Residency", "Hyderabad", "Telangan",
                                    "505452", "9876543210", "pragna@gmail.com");
        addressBook.addNewContact(person);
        Person person1 = null;
        try {
            person1 = addressBook.getContact("Pragna");
        } catch (AddressBookException e) {}
        Assertions.assertTrue(person.equals(person1));
    }

    @Test
    public void givenPersonName_whenInvalid_ShouldThrowException() {
        AddressBook addressBook = new AddressBook();
        try {
            addressBook.getContact("Pragna");
        } catch (AddressBookException e) {
            Assertions.assertEquals(AddressBookException.ExceptionType.NO_SUCH_CONTACT_FOUND, e.type);
        }
    }

    @Test
    public void givenPersonName_whenValid_ShouldReturnObject() {
        AddressBook addressBook = new AddressBook();
        try {
            addressBook.addNewContact(new Person("Pragna", "Kasthuri", "Residency", "Hyderabad", "Telangan",
                    "505452", "9876543210", "pragna@gmail.com"));
            Person person = addressBook.getContact("Pragna");
            Assertions.assertTrue("Pragna".equals(person.getFirstName()));
        } catch (AddressBookException e) {}
    }

    @Test
    public void givenFirstName_WhenProper_ShouldReturnTrue() {
        boolean result = false;
        try {
            result = AddressBookValidationUtil.isValidFirstName("Pragna");
        } catch (AddressBookException e) {}
        Assertions.assertTrue(result);
    }

    @Test
    public void givenFirstName_WhenNotProper_ShouldReturnFalse() {
        boolean result = false;
        try {
            result = AddressBookValidationUtil.isValidFirstName("u8shdj");
        } catch (AddressBookException e) {
            Assertions.assertEquals(AddressBookException.ExceptionType.INVALID_FIRST_NAME, e.type);
        }
    }

    @Test
    public void givenLastName_WhenProper_ShouldReturnTrue() {
        boolean result = false;
        try {
            result = AddressBookValidationUtil.isValidLastName("Kasthuri");
        } catch (AddressBookException e) {}
        Assertions.assertTrue(result);
    }

    @Test
    public void givenLastName_WhenNotProper_ShouldReturnFalse() {
        boolean result = false;
        try {
            result = AddressBookValidationUtil.isValidLastName("dr45sb");
        } catch (AddressBookException e) {
            Assertions.assertEquals(AddressBookException.ExceptionType.INVALID_LAST_NAME, e.type);
        }
    }

    @Test
    public void givenAddress_WhenProper_ShouldReturnTrue() {
        boolean result = false;
        try {
            result = AddressBookValidationUtil.isValidAddress("Flat #333 Hyderabad 500019");
        } catch (AddressBookException e) {}
        Assertions.assertTrue(result);
    }

    @Test
    public void givenAddress_whenLengthExceeded_ShouldReturnFalse() {
        boolean result = false;
        try {
            result = AddressBookValidationUtil.isValidAddress("Flat #333 Hyderabad 500019 blah blah blah");
        } catch (AddressBookException e) {
            Assertions.assertEquals(AddressBookException.ExceptionType.INVALID_ADDRESS, e.type);
        }
    }

    @Test
    public void givenCity_WhenProper_ShouldReturnTrue() {
        boolean result = false;
        try {
            result = AddressBookValidationUtil.isValidCity("hyd");
        } catch (AddressBookException e) {}
        Assertions.assertTrue(result);
    }

    @Test
    public void givenCity_WhenNotProper_ShouldReturnFalse() {
        boolean result = false;
        try {
            result = AddressBookValidationUtil.isValidCity("T&*vj");
        } catch (AddressBookException e) {
            Assertions.assertEquals(AddressBookException.ExceptionType.INVALID_CITY, e.type);
        }
    }

    @Test
    public void givenState_WhenProper_ShouldReturnTrue() {
        boolean result = false;
        try {
            result = AddressBookValidationUtil.isValidState("Telangana");
        } catch (AddressBookException e) {}
        Assertions.assertTrue(result);
    }

    @Test
    public void givenState_WhenNotProper_ShouldReturnFalse() {
        boolean result = false;
        try {
            result = AddressBookValidationUtil.isValidState("vgs%99789");
        } catch (AddressBookException e) {
            Assertions.assertEquals(AddressBookException.ExceptionType.INVALID_STATE, e.type);
        }
    }

    @Test
    public void givenZip_WhenProper_ShouldReturnTrue() {
        boolean result = false;
        try {
            result = AddressBookValidationUtil.isValidZip("500109");
        } catch (AddressBookException e) {}
        Assertions.assertTrue(result);
    }

    @Test
    public void givenZip_WhenNotProper_ShouldReturnFalse() {
        boolean result = false;
        try {
            result = AddressBookValidationUtil.isValidZip("34567612b76878");
        } catch (AddressBookException e) {
            Assertions.assertEquals(AddressBookException.ExceptionType.INVALID_ZIP, e.type);
        }
        Assertions.assertEquals(false, result);
    }

    @Test
    public void givenPhoneNumber_WhenProper_ShouldReturnTrue() {
        boolean result = false;
        try {
            result = AddressBookValidationUtil.isValidPhoneNumber("9012345678");
        } catch (AddressBookException e) {}
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPhoneNumber_WhenNotProper_ShouldReturnFalse() {
        boolean result = false;
        try {
            result = AddressBookValidationUtil.isValidPhoneNumber("56572");
        } catch (AddressBookException e) {
            Assertions.assertEquals(AddressBookException.ExceptionType.INVALID_PHONE, e.type);
        }
    }

    @Test
    public void givenEmail_WhenProper_ShouldReturnTrue() {
        boolean result = false;
        try {
            result = AddressBookValidationUtil.isValidEmail("pragna@gmail.com");
        } catch (AddressBookException e) {}
        Assertions.assertTrue(result);
    }

    @Test
    public void givenEmail_WhenNotProper_ShouldReturnFalse() {
        boolean result = false;
        try {
            result = AddressBookValidationUtil.isValidEmail("bhjhes*.C..comds");
        } catch (AddressBookException e) {
            Assertions.assertEquals(AddressBookException.ExceptionType.INVALID_EMAIL, e.type);
        }
    }
}
