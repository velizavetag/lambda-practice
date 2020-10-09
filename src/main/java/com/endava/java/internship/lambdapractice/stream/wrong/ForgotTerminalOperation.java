package com.endava.java.internship.lambdapractice.stream.wrong;

import java.util.stream.IntStream;

public class ForgotTerminalOperation {

    //will not do anything. Besides, it's ugly anyway
    public void willDoNothingInReality() {
        IntStream.range(1, 5)
                .peek(System.out::println)
                .peek(i -> {
                    if (i == 5)
                        throw new RuntimeException("bang");
                });
    }
}
