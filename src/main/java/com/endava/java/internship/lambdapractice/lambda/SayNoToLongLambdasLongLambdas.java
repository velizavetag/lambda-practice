package com.endava.java.internship.lambdapractice.lambda;

import com.endava.java.internship.lambdapractice.model.Employee;
import com.endava.java.internship.lambdapractice.model.EmployeeDto;
import com.endava.java.internship.lambdapractice.model.enums.Department;

import java.util.List;
import java.util.function.Function;

import lombok.var;

import static java.util.stream.Collectors.toList;

public class SayNoToLongLambdasLongLambdas {

    public List<EmployeeDto> convertToDtoList(List<Employee> users) {
        return users.stream()
            .map(user -> {
                var employeeDto = EmployeeDto.builder()
                    .name(user.getName())
                    .lastName(user.getLastName())
                    .department(user.getDepartment())
                    .build();

                    return employeeDto;
            })
            .collect(toList());
    }

    public List<EmployeeDto> convertFromEmployeeListToEmployeeDtoList(List<Employee> users) {
        return users.stream()
            .map(convertFromEmployeeToEmployeeDto)
            .collect(toList());
    }

    private Function<Employee, EmployeeDto> convertFromEmployeeToEmployeeDto =
        employee -> EmployeeDto.builder()
            .name(employee.getName())
            .lastName(employee.getLastName())
            .department(employee.getDepartment())
            .build();
}
