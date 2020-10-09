package com.endava.java.internship.lambdapractice.optional;

import com.endava.java.internship.lambdapractice.model.Employee;

import java.util.List;
import java.util.Optional;

public class StreamsAndOptionalCombined {

    public Optional<String> findTeamMembersWhoseNameStartsWithM(List<Employee> employees) {
      return  employees.stream()
            .map(Employee::getName)
            .filter(name -> name.startsWith("M"))
            .findAny();
    }

    //you can also filter the optional! Live coding
    public Integer checkBonusPointsAreGreaterThan100(Employee employee) {
        return Optional.ofNullable(employee)
            .map(Employee::getBonusPoints)
            .orElse(0);
    }
}
