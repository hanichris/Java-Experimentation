package com.examples.generics;

import java.util.List;

public class WildCardFixed {
    void foo(List<?> i) {
        fooHelper(i);
    }

    // To work around the compiler error that exists,
    // Use the helper method to capture the wildcard through
    // type inference.
    // The compiler uses inference to determine that `T` is `CAP#1`,
    // the capture variable in the invocation.
    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }
}
