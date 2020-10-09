package com.endava.java.internship.lambdapractice.model;

import java.util.Optional;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class ContactPerson {
    String name;
    String lastName;
    String phoneNumber;
    String address;

    public Optional<String> getAddress() {
        return Optional.of(address);
    }
}
