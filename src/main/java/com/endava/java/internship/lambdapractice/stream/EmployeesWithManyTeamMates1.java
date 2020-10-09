package com.endava.java.internship.lambdapractice.stream;

import com.endava.java.internship.lambdapractice.model.Employee;

import java.util.Comparator;
import java.util.List;

// find the employee who has the largest amount of team mates
public class EmployeesWithManyTeamMates1 {

    //before lambdas and coolest java 8 features
    public Employee findCoolEmployeeWithTeamMates(List<Employee> employees) {
        if (employees.isEmpty()) {
            return null;
        }
        Employee coolEmployee = employees.iterator().next();
        for (Employee user : employees) {
            if (user.getTeamMates().size() > coolEmployee.getTeamMates().size()) {
                coolEmployee = user;
            }
        }
        return coolEmployee;
    }

    //nice way
    public Employee findCoolEmployeeInAveryFunctionalApproach(List<Employee> employees) {
        return employees.stream()
            .max(Comparator.comparingInt(user -> user.getTeamMates().size()))
            .orElse(null);
    }
}
