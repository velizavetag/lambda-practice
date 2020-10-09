package com.endava.java.internship.lambdapractice.stream;

import com.endava.java.internship.lambdapractice.model.Employee;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

import static com.endava.java.internship.lambdapractice.model.enums.Department.MANAGEMENT;

public class MixOfEverything {
    //given a list of employees, check if there's anyone from MANAGEMENT on their close coworker list

    //Not a good idea
    public boolean checkThereIsManagementTeamMemberForEachInForEach(List<Employee> employees) {
        //Why can't I use a simple boolean?
        AtomicBoolean managementTeamMemberPresent = new AtomicBoolean(false);

        employees.forEach(
            employee -> employee.getTeamMates()
                .forEach(teamMate -> {
                    if (teamMate.getDepartment().equals(MANAGEMENT))
                        managementTeamMemberPresent.set(true);
                })
        );
        return managementTeamMemberPresent.get();
    }

    //Another failure attempt
    public boolean checkThereIsManagementTeamMemberUsingFilter(List<Employee> employees) {
        return employees.stream()
            .filter(this::isFromManagement)
            .count() > 0;
    }

    private boolean isFromManagement(Employee employee) {
        return employee.getTeamMates()
                            .stream()
                            .filter(teamMate -> teamMate.getDepartment().equals(MANAGEMENT))
                                .count() > 0;
    }

    //Better, but not there yet
    public boolean tryToUseItUsingStreamAnyMatch(List<Employee> employees) {
        return employees.stream()
            .anyMatch(employee -> employee.getTeamMates().stream()
                                    .anyMatch(teamMate -> teamMate.getDepartment().equals(MANAGEMENT)));
    }

    //Please do not repeat at home
    public boolean verboseAndUglyToMixImperativeAndDeclarativeApproach(List<Employee> employees) {
        return employees.stream()
            .flatMap(employee -> {
                if(employee == null) {
                    throw new RuntimeException();
                }
               return employee.getTeamMates().stream();
            })
            .map(Employee::getDepartment)
            .anyMatch(department -> department.equals(MANAGEMENT));
    }

    //Please do repeat at home
    public boolean codeInCleanAndNiceMannerOne(List<Employee> employees) {
        return employees.stream()
            .flatMap(employee -> employee.getTeamMates().stream())
            .map(Employee::getDepartment)
            .anyMatch(department -> department.equals(MANAGEMENT));
    }

    //Please do repeat at home
    public boolean codeInCleanAndNiceMannerTwo(List<Employee> employees) {
        return employees.stream()
            .map(Employee::getTeamMates)
            .flatMap(List::stream)
            .map(Employee::getDepartment)
            .anyMatch(department -> department.equals(MANAGEMENT));
    }
}
