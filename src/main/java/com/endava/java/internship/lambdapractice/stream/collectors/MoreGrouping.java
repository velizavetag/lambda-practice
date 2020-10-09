package com.endava.java.internship.lambdapractice.stream.collectors;

import com.endava.java.internship.lambdapractice.model.enums.Department;
import com.endava.java.internship.lambdapractice.model.Employee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;

public class MoreGrouping {
    private final Set<Employee> users = new HashSet<>();
//given a list of employees find the team mates that are in IT department
    //how you shouldn't do
    public Map<String, Set<Employee>> findItFolks() {
        Map<String, Set<Employee>> itGuys = new HashMap<>();
        users.forEach(u -> u.getTeamMates().stream()
            .filter(r -> r.getDepartment().equals(Department.IT))
            .forEach(r -> {
                Set<Employee> teamMateInIt = itGuys.get(r.getName());
                if (teamMateInIt == null) {
                    teamMateInIt = new HashSet<>();
                    itGuys.put(r.getName(), teamMateInIt);
                }
                teamMateInIt.add(u);
            })
        );
        return itGuys;
    }

    //how to do it... almost
    public Map<String, Set<Employee>> findItGuys(List<Employee> employees) {
        return employees.stream()
            //what is bad here?
            .flatMap(employee -> employee.getTeamMates().stream()
                .filter(teamMate -> teamMate.getDepartment().equals(Department.IT))
                .map(teamMate -> new Pair<>(employee, teamMate))
            ).collect(groupingBy(p -> p.getKey().getName(),
                                 mapping(Pair::getValue, toSet())));
    }

    //any tuple implementation from 3rd party libraries. Could be found in vavr library, for example
    class Pair<K, V> {
        private final K key;
        private final V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }
    }
}
