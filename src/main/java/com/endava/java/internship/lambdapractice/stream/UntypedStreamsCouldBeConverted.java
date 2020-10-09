package com.endava.java.internship.lambdapractice.stream;

import java.util.List;

public class UntypedStreamsCouldBeConverted {

    //let's presume we have an old not generified code. We have a task to make more functional looking
    class ProcessOnlyValuesOfSpecialType {
        public int countDoubleNaNs(List numbers) {
            int count = 0;
            for (Object e : numbers) {
                if (e instanceof Double) {
                    Double d = (Double) e;
                    if (d.isNaN()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    // we did our task!
    class TypeOfStreamCouldBeChanged {
        public int countDoubleNaNs(List numbers) {
            return (int) numbers.stream()
                    .filter(Double.class::isInstance)
                    .mapToDouble(Double.class::cast)
                    .filter(Double::isNaN)
                    .count();
        }
    }
}