package com.examples.exceptions;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers {
    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers() {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
    }

    public void writeList() {
        // FileWriter throws an IOException that MUST be handled.
        // Because IOException is a checked exception, compiler complains if
        // it is not handled.
        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));

        for (int i = 0; i < SIZE; i++) {
            // .get() throws an IndexOutOfBoundsException that MUST be handled.
            // However, the IndexOutOfBoundsException is an unchecked exception
            // so the compiler does not complain.
            out.println("Value at: " + i + " = " + list.get(i));
        }
        out.close();
    }
}
