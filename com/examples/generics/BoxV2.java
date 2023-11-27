package com.examples.generics;

public class BoxV2<T> {
    
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return this.t; }

    public <U extends Number> void inspect(U u) {
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String[] args) {
        BoxV2<Integer> integerBox = new BoxV2<Integer>();
        integerBox.set(123);
        integerBox.inspect(12);
    }
}
