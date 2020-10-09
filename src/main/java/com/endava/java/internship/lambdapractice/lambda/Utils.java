package com.endava.java.internship.lambdapractice.lambda;

import com.endava.java.internship.lambdapractice.model.Employee;

import java.util.List;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.var;

import static com.endava.java.internship.lambdapractice.model.enums.Department.ACCOUNTING;
import static com.endava.java.internship.lambdapractice.model.enums.Department.IT;
import static com.endava.java.internship.lambdapractice.model.enums.Department.MANAGEMENT;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Utils {

    public static List<Employee> getListOfUsers() {
        var user1 = new Employee("Peter", "Parker", 20, IT, false, false, null);
        var user2 = new Employee("John", "Doe", 25, IT,  false, true, null);
        var user3 = new Employee("Jillian", "Haffner", 32, IT, false, true, null);
        var user4 = new Employee("Patric", "Finnigan", 43, ACCOUNTING, true, false, null);
        var user5 = new Employee("Jane", "Ducket", 45, ACCOUNTING, true, true, null);
        var user6 = new Employee("Juliana", "Harvey", 47, ACCOUNTING, true, true, null);
        var user7 = new Employee("Daniel", "Reddington", 20, MANAGEMENT, true, true, null);

        return List.of(user1, user2, user3, user4, user5, user6, user7);
    }
}
