package com.examples.generics;

import java.util.ArrayList;
import java.util.List;

public class WildCardError {
    // Compiler processes `i` as a type of `Object`.
    // When `List.set` is invoked, the compiler cannot confirm the object
    // type being inserted into the list, thus produces an error.
    static void foo(List<?> i) {
        i.set(0, i.get(0));
    }

    public static void main(String[] args) {
        foo(new ArrayList<>());
    }
}
