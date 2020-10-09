package com.endava.java.internship.lambdapractice.model;

import com.endava.java.internship.lambdapractice.model.enums.Department;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class EmployeeDto {
    String name;
    String lastName;
    Department department;
}
