package com.endava.java.internship.lambdapractice.stream.collectors;

import com.endava.java.internship.lambdapractice.model.Employee;

import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toMap;

//given an Employee list, try to get one with the largest amount of bonus points
//get the employee's name
//put the result in a map
public class HowToUseCollectors {

    //this one is tough
    public Map<String, Integer> getMaxAgeByEmployeeBonusPointsHardToRead(List<Employee> users) {
        return users.stream()
            .collect(groupingBy(Employee::getName))
            .entrySet().stream()
            .collect(toMap(
                Map.Entry::getKey,
                //try to use a meaningful name of the parameter
                e -> e.getValue().stream()
                    .map(Employee::getBonusPoints)
                    .reduce(0, Integer::max)
            ));
    }

    //also tough
    public Map<String, Integer> getMaxAgeByEmployeeBonusPointsAttempt2(List<Employee> employees) {
        return employees.stream()
            .collect(groupingBy(Employee::getName,
                                collectingAndThen(maxBy(comparing(Employee::getBonusPoints)),
                                                  employee -> employee.get().getBonusPoints())));
    }

    //thumbs up
    public Map<String, Integer> getMaxAgeByEmployeeBonusPointsCleanCode(List<Employee> employees) {
        return employees.stream()
            .collect(toMap(Employee::getName,
                           Employee::getBonusPoints,
                           Integer::max));
    }

    //good
    public Map<String, Integer> getMaxAgeByEmployeeBonusPoints(List<Employee> employees) {
        return employees.stream()
            .collect(
                groupingBy(
                    Employee::getName,
                    mapping(Employee::getBonusPoints, reducing(0, Integer::max))
                )
            );
    }
}
