package com.endava.java.internship.lambdapractice.optional;

import com.endava.java.internship.lambdapractice.model.Employee;

import java.util.Optional;

import static java.util.Optional.ofNullable;

public class OptionalIntro {

    //before java 8
    public String getEmployeeLastNameBeforeJava8(Employee employee) {
        return (employee != null && employee.getLastName() != null ) ? employee.getLastName() : "John Doe";
    }

    //attempt to use optional api
    public String usingIsPresent(Employee employee) {
        if(ofNullable(employee).isPresent()) {
            if(ofNullable(employee.getLastName()).isPresent()) {
                return employee.getLastName();
            }
        }
        return "John Doe";
    }

    //nice an clean approach
    public String getUserNameCorrectlyUsingOptionalApi(Employee employee) {
        return Optional.ofNullable(employee)
            .map(Employee::getLastName)
            .orElse( "John Doe");
    }
}
