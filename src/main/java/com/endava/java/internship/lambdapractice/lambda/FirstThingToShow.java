package com.endava.java.internship.lambdapractice.lambda;

import com.endava.java.internship.lambdapractice.model.Employee;

import java.util.List;
import java.util.function.Predicate;

import lombok.val;

import static com.endava.java.internship.lambdapractice.model.enums.Department.IT;
import static com.endava.java.internship.lambdapractice.lambda.Utils.getListOfUsers;

public class FirstThingToShow {

    public static void main(String[] args) {
        val listOfUsers = getListOfUsers();

        print(listOfUsers, new HasAccessToPersonalInfo());
        print(listOfUsers, user -> user.getAge() > 30);

    }

    private static void print(List<Employee> users, CheckItOut filtering) {

        for(Employee user : users) {
            if(filtering.test(user)) {
                System.out.println(user.getName().concat(" ").concat(user.getLastName()));
            }
        }
    }
}
