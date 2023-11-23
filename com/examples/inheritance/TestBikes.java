package com.examples.inheritance;

public class TestBikes {
    public static void main(String[] args) {
        Bicycle bike01, bike02, bike03;

        bike01 = new Bicycle(20, 10, 1);
        bike02 = new MountainBike(20, 10, 5, "Dual");
        bike03 = new RoadBike(40, 20, 8, 23);

        /* The JVM calls the appropriate method for the object that is
         * referred to in each variable. It does not call the method that
         * is defined by the variable's type.
         */
        bike01.printDescription();
        bike02.printDescription();
        bike03.printDescription();
    }
}
