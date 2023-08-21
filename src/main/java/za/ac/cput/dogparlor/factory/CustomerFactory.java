package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.Address;
import za.ac.cput.dogparlor.domain.Customer;
import za.ac.cput.dogparlor.util.Helper;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerFactory {

    public static Customer createCustomer(String firstName, String lastName, String email, String phone,
                                          String password, List<Address> addresses) {

        if ((Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(password)))
            return null;

        if (!Helper.isValidEmail(email))
            return null;

        if (!Helper.isNumeric(phone))
            return null;

        String customerID = Helper.generateID();

        return new Customer.Builder()
                .setCustomerID(customerID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhone(phone)
                .setPassword(password)
                .setAddresses(addresses)
                .build();

    }

}
