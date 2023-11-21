package com.examples.calculator;

public class Calculator {
    
    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String[] args) {
        Calculator myapp = new Calculator();
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtration = (a, b) -> a - b;

        System.out.println("40 + 2 = " +
            myapp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " + 
            myapp.operateBinary(20, 10, subtration));
    }
}
