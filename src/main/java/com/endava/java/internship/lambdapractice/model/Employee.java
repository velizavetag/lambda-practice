package com.endava.java.internship.lambdapractice.model;

import com.endava.java.internship.lambdapractice.model.enums.Department;

import java.util.List;
import java.util.Optional;

import lombok.Data;

@Data
public class Employee {
    private final String name;
    private final String lastName;
    private final int age;
    private final Department department;
    private List<Employee> teamMates;
    private Integer bonusPoints;
    private final boolean hasAccessToAccountingInfo;
    private final boolean hasAccessToPersonalInfo;
    private final ContactPerson contactPerson;

    public Optional<ContactPerson> getContactPerson(){
        return Optional.of(contactPerson);
    }
}
