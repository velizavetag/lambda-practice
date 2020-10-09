package com.endava.java.internship.lambdapractice.stream;

import com.endava.java.internship.lambdapractice.model.Customer;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreationOptions {

    //first option. BUT NOT COOL
    public Stream<Customer> getStreamFromList(Customer customer1, Customer customer2) {
        return Arrays.asList(customer1, customer2).stream();
    }

    //second option. YES PLEASE!
    public Stream<Customer> getStreamFromElementsUsingOf(Customer customer1, Customer customer2) {
        return Stream.of(customer1, customer2);
    }

    //who does this?
    public Stream<Customer> generateStreamByMappingCopies(int n) {
        return Collections.nCopies(n, "string")
            .stream()
            .map(string -> new Customer());
    }

    //who does this[2] ?
    public Stream<Customer> generateStreamFromRange(int n) {
        return IntStream.range(0, n).mapToObj(element -> new Customer());
    }

    //oh thank you
    public Stream<Customer> generateStreamFromSupplierWithLimit(int n) {
        return Stream.generate(Customer::new).limit(n);
    }

    //you can do this one as well
    public Stream<Customer> generateStreamFromArrayWithLimit(Customer[] customers, int max) {
        return Stream.empty();
    }
}
