package com.endava.java.internship.lambdapractice.optional;

import com.endava.java.internship.lambdapractice.model.ContactPerson;
import com.endava.java.internship.lambdapractice.model.Employee;

import lombok.var;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

public class OptionalMapsFlatMaps {

    //This is bad
    public String getContactInfoAddressInUpperCaseLettersBefore(Employee employee) {
        String address = "Undefined";
        if (employee != null) {
            var contactPerson = employee.getContactPerson();
            if(employee.getContactPerson().isPresent()) {
                var contactAddress = contactPerson.get().getAddress();
                if(contactAddress.isPresent() ) {
                    address = contactAddress.get().toUpperCase();
                }
            }
        }
        return address;
    }

    //when you got to know the lambdas and try to make you code more functional
    public String getContactInfoAddressInUpperCaseLettersUsingIfPresent(Employee employee) {
        final StringBuilder stringBuilder = new StringBuilder();
        ofNullable(employee)
            .ifPresent(empl -> empl.getContactPerson()
                .ifPresent(contactPerson -> contactPerson.getAddress()
                    .ifPresent(address -> stringBuilder.append(address.toUpperCase()))));

        return stringBuilder.toString();
    }

    //when you learned the map function from the Optional API
    public String usingMapWithoutCheckingIfOptionalPresent(Employee employee) {
        return ofNullable(employee)
            .map(Employee::getContactPerson)
            .map(contactPerson -> contactPerson.get().getAddress())
            .map(address -> address.get().toUpperCase())
            .orElse("Unknown");
    }

    public String usingFlatMatIsTheBestOptionInThisCase(Employee employee) {
        return ofNullable(employee)
            .flatMap(Employee::getContactPerson)
            .flatMap(ContactPerson::getAddress)
            .map(String::toUpperCase)
            .orElse("Unknown");
    }
}
