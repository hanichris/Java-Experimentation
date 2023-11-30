package com.examples.exceptions;

import java.io.FileWriter;
import java.io.IOException;
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

    public void writeList() throws IOException {
        // FileWriter throws an IOException that MUST be handled.
        // Because IOException is a checked exception, compiler complains if
        // it is not handled.
        PrintWriter out = null;
        FileWriter f = null;

        try {
            System.out.println("Entered try block!!!");
            f = new FileWriter("OutFile.txt");
            out = new PrintWriter(f);
            for (int i = 0; i < SIZE; i++) {
                // .get() throws an IndexOutOfBoundsException that MUST be handled.
                // However, the IndexOutOfBoundsException is an unchecked exception
                // so the compiler does not complain.
                out.println("Value at: " + i + " = " + list.get(i));
            }
        } catch (IndexOutOfBoundsException | IOException e) {
            System.err.println("Caught Exception: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not opened");
            }

            if (f != null) {
                System.out.println("Closing FileWriter");
                f.close();
            }
        }
        // or alternatively:
        // } catch (IndexOutOfBoundsException e) {
        //     System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        // } catch (IOException e) {
        //     System.err.println("Caught IOException: " + e.getMessage());
        // }
    }
    
    // Alternatively using try-with-resources.
    // public void writeList() throws IOException {
    //     try(FileWriter f = new FileWriter("OutFile.txt");
    //         PrintWriter out = new PrintWriter(f)) {
    //         for (int i = 0; i < SIZE; i++) {
    //             out.println("Value at: " + i + " = " + list.get(i));
    //         }
    //     }
    // }
}
