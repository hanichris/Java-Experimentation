package com.examples.generics;

public class Count {

    public static <T> int countGreaterThan(T[] array, T elem) {
        int count = 0;
        // for (T t : array) {
        //     // Compile error since `>` is defined only for primitive types.
        //     // if (t > elem) {
        //     //     ++count;
        //     // }
        // }
        return count;
    }

    public static <T extends Comparable<T>> int countGreaterThan(T[] array, T elem) {
        int count = 0;

        for (T t : array) {
            if (t.compareTo(elem) > 0) {
                ++count;
            }
        }

        return count;
    }
}
