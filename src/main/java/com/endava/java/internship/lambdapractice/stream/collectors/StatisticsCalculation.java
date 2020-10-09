package com.endava.java.internship.lambdapractice.stream.collectors;

import com.endava.java.internship.lambdapractice.model.Employee;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.summarizingInt;

public class StatisticsCalculation {

    //Could've been done better
    public void printSomeStatisticalInformation(List<Employee> employees) {
        getBonusPointsStream(employees)
            .max()
            .ifPresent(max -> System.out.println("MAX: " + max));
        getBonusPointsStream(employees)
            .min()
            .ifPresent(min -> System.out.println("MIN: " + min));
        getBonusPointsStream(employees)
            .average()
            .ifPresent(avg -> System.out.println("AVG" + avg));
    }

    private IntStream getBonusPointsStream(List<Employee> employeeList) {
        return employeeList.stream()
            .mapToInt(Employee::getBonusPoints);
    }

    public void useSummaryStatistics(List<Employee> employees) {
        //please fill in
        IntSummaryStatistics intSummaryStatistics = employees.stream()
            .collect(Collectors.summarizingInt(Employee::getBonusPoints));

        System.out.println("MAX" + intSummaryStatistics.getMax());
    }
}
