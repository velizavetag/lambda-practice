package com.endava.java.internship.lambdapractice.stream.wrong;

import java.util.stream.IntStream;

public class InfiniteStreams {

    public void whatWillHappen(){
        IntStream.iterate(0, i -> i + 1)
                .forEach(System.out::println);
    }

    public void whatAboutNow(){
        IntStream.iterate(0, i -> i + 1)
                .limit(10)
                .forEach(System.out::println);
    }

    //Oh man. Please learn to write the streams correctly
    public void whatWillHappenNow(){
        IntStream.iterate(0, i -> (i + 1 ) % 2)
                .distinct()
                .limit(10)
                .forEach(System.out::println);
    }

    //Huh?
    public void isThisOneOkay(){
        IntStream.iterate(0, i -> (i + 1 ) % 2)
                .limit(10)
                .distinct()
                .forEach(System.out::println);
    }
}
