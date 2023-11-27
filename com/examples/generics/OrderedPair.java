package com.examples.generics;

public class OrderedPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }

    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }

    public String toString() {
        return this.key + ": " + this.value;
    }

    public static void main(String[] args) {
        Pair<String, Integer> p1 = new OrderedPair<String,Integer>("Even", 8);
        Pair<String, String> p2 = new OrderedPair<String,String>("hello", "world");
        // Infers the the type arguments from the declaration.
        Pair<String, Integer> p3 = new OrderedPair<>("One", 1);

        // Substitute a type parameter with a parameterized type.
        Pair<String, Box<Integer>> p4 = new OrderedPair<String,Box<Integer>>("primes", new Box<>());

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        Pair<Integer, String> p5 = new OrderedPair<Integer,String>(1, "apple");
        Pair<Integer, String> p6 = new OrderedPair<Integer,String>(2, "pear");
        boolean same = Util.<Integer, String>compare(p5, p6);

        System.out.println(same);
    }
}
