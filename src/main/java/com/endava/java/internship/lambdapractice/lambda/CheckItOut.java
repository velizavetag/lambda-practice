package com.endava.java.internship.lambdapractice.lambda;

import com.endava.java.internship.lambdapractice.model.Employee;

@FunctionalInterface
public interface CheckItOut {
    boolean test(Employee user);
}
