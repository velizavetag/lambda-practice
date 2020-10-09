package com.endava.java.internship.lambdapractice.lambda;

import com.endava.java.internship.lambdapractice.model.Employee;

public class HasAccessToPersonalInfo implements CheckItOut {
    @Override
    public boolean test(Employee user) {
        return user.isHasAccessToAccountingInfo();
    }
}
